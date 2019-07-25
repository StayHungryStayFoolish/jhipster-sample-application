package io.github.jhipster.sample.web.rest;

import io.github.jhipster.sample.entity.Person;
import io.github.jhipster.sample.service.PersonService;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Created by bonismo@hotmail.com on 2019/7/24 7:40 PM
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    @Timed
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @PutMapping("/person")
    @Timed
    public void updatePerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @GetMapping("/person/{name}")
    @Timed
    public Person findPersonByName(@PathVariable String name) {
        return personService.findPerson(name);
    }

    @DeleteMapping("/person/{id}")
    @Timed
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
