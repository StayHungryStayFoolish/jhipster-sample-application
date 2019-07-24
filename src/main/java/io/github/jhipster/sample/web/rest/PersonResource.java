package io.github.jhipster.sample.web.rest;

import io.github.jhipster.sample.entity.Person;
import io.github.jhipster.sample.mapper.PersonDao;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Created by bonismo@hotmail.com on 2019/7/24 7:40 PM
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class PersonResource {

    private final PersonDao personDao;

    public PersonResource(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/person/create/")
    @Timed
    public void createPerson() {
        String name = "Lily";
        String age = "18";
        String sex = "female";
        personDao.insertPerson(name, age, sex);
    }

    @GetMapping("/person/{name}")
    @Timed
    public Person createPerson(@PathVariable String name) {
        Person person = personDao.findPersonByName(name);
        return person;
    }
}
