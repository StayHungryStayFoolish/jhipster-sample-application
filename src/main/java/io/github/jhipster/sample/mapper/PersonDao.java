package io.github.jhipster.sample.mapper;

import io.github.jhipster.sample.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Created by bonismo@hotmail.com on 2019/7/24 7:24 PM
 * @Description:
 * @Version: 1.0
 */
@Mapper
public interface PersonDao {

    @Select("SELECT * FROM person WHERE NAME = #{name}")
    Person findPersonByName(@Param("name") String name);

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO person(name, age,sex) VALUES(#{name}, #{age}, #{sex})")
    void insertPerson(@Param("name") String name, @Param("age") String age, @Param("sex") String sex);

}
