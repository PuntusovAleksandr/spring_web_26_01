package com.luxoft.jquery.controller;

import com.luxoft.jquery.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
	ModelAndView model = new ModelAndView("persons");
	return model;
    }
    
    @RequestMapping(value = "/getPersons", method = RequestMethod.POST)
    public @ResponseBody List<Person> getPersons(@RequestParam(value = "firstName", required = true) String firstName) {
        System.out.println("Incoming parameter - " + firstName);
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName("Ivanov");
        person.setEmail("ivan.ivanov@gmail.com");
        person.setPhoneNumber("+380939218051");
        Person person2 = new Person();
        person2.setFirstName(firstName);
        person2.setLastName("Petrov");
        person2.setEmail("petr.petrov@gmail.com");
        person2.setPhoneNumber("+380953651597");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person2);
	return persons;
    }
}
