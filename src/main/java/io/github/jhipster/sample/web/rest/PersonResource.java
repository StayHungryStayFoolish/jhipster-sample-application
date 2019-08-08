package io.github.jhipster.sample.web.rest;

import io.github.jhipster.sample.config.ApplicationProperties;
import io.github.jhipster.sample.entity.Person;
import io.github.jhipster.sample.mapper.PersonDao;
import io.github.jhipster.sample.service.UserService;
import io.micrometer.core.annotation.Timed;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Created by bonismo@hotmail.com on 2019/7/24 7:40 PM
 * @Description:
 * @Version: 1.0
 */
@RestController
@Transactional
@RequestMapping("/api")
public class PersonResource {

    private final UserService userRepository;
    private final PersonDao personDao;

    private LocalTime onDuty;
    private LocalTime offDuty;

//    private LocalTime onDuty;
//    private LocalTime offDuty;

    private final ApplicationProperties properties;

    public PersonResource(UserService userRepository, PersonDao personDao, ApplicationProperties properties) {
        this.userRepository = userRepository;
        this.personDao = personDao;
        this.properties = properties;
        onDuty = properties.getAttendance().getRule().getOnDuty();
        offDuty = properties.getAttendance().getRule().getOffDuty();
    }

    @GetMapping("/test/init")
    public void initUser() throws Exception {
        userRepository.initUser();
    }

    @GetMapping("/person/create")
    @Timed
    public void createPerson() throws Exception {
        String name = "Lily";
        String age = "18";
        String sex = "female";
        System.out.println(name + " : " + age + " : " + sex);
        personDao.insertPerson(name, age, sex);
        throw new Exception("aaaaaaaaaaa");
    }

    @GetMapping("/person/{name}")
    @Timed
    public Person createPerson(@PathVariable String name) {
        Person person = personDao.findPersonByName(name);
        return person;
    }

    @GetMapping("/attendance/config")
    public Map<String, LocalTime> attendanceConfig() {
        Map<String, LocalTime> map = new HashMap<>();
        map.put("onDuty", onDuty);
        map.put("offDuty", offDuty);
        return map;
    }
}
