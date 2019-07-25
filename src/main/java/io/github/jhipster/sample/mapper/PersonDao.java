package io.github.jhipster.sample.mapper;

import io.github.jhipster.sample.entity.Person;
import org.apache.ibatis.annotations.*;

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
    void insertPerson(Person person);

    @Update("UPDATE person SET age=#{age} WHERE name=#{name}")
    void update(Person person);

    @Delete("DELETE FROM person WHERE id =#{id}")
    void delete(Long id);
}
