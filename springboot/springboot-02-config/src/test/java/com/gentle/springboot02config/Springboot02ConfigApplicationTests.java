package com.gentle.springboot02config;

import com.gentle.springboot02config.pojo.Dog;
import com.gentle.springboot02config.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    //private Person person;
    private Dog dog;

    @Test
    void contextLoads() {
        //System.out.println(person);
        System.out.println(dog);
    }

}
