package io.github.jhipster.sample.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @Version: V1.0.0
 * <p>
 * Description:
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "io.github.jhipster.sample.entity")
@MapperScan(basePackages = "io.github.jhipster.sample.mapper", sqlSessionTemplateRef = "matchingSqlSessionTemplate")
public class MatchingDatabaseConfiguration {


    @Bean
    @ConfigurationProperties("application.matching.datasource")
    public DataSourceProperties matchingDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "matchingDataSource")
    @ConfigurationProperties("application.matching.datasource")
    public DataSource matchingDataSource() {
        return matchingDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "matchingTransactionManager")
    public DataSourceTransactionManager matchingTransactionManager() {
        return new DataSourceTransactionManager(matchingDataSource());
    }

    @Bean(name = "matchingSqlSessionFactory")
    public SqlSessionFactory matchingSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(matchingDataSource());
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
//            getResources(localMapper));
//        sessionFactory.setPlugins(ArrayUtils.toArray(pageHelper));
        return sessionFactory.getObject();
    }

    @Bean(name = "matchingSqlSessionTemplate")
    public SqlSessionTemplate buildSqlSessionTemplate(@Qualifier("matchingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "matchingTransaction")
    public PlatformTransactionManager matchingTransactionManager(@Qualifier("matchingDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(
//        DataSource dataSource) {
//        DataSourceTransactionManager manager = new DataSourceTransactionManager();
//        manager.setDataSource(dataSource);
//        return manager;
//    }
}


