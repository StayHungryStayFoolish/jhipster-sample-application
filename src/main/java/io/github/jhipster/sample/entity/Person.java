package io.github.jhipster.sample.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * @Author: Created by bonismo@hotmail.com on 2019/7/24 7:21 PM
 * @Description:
 * @Version: 1.0
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @Size(min = 1, max = 3)
    @Column(length = 3, unique = true, nullable = false)
    private String age;

    @Size(min = 1, max = 5)
    @Column(length = 10, unique = true, nullable = false)
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
            Objects.equals(getAge(), person.getAge()) &&
            Objects.equals(getSex(), person.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSex());
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", sex='" + sex + '\'' +
            '}';
    }
}
