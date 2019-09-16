package com.project.shortener.controllers;

import com.project.shortener.persistence.User;
import com.project.shortener.persistence.UserRepository;
import com.project.shortener.services.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Test controller - say hello.
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private MessageProducer messageProducer;

    /**
     * Test request method.
     *
     * @return greeting.
     */
    @RequestMapping("/")
    public String index() {
        log.info("Hello world controller.");
        List<User> all = userRepository.findAll();
        all.forEach(System.out::println);
        messageProducer.produce();
        return "Greetings from Springsdf Boot!";
    }

    @GetMapping("/jwttest")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public String jwttest() {
        log.info("jwttest");
        return "jwttest";
    }
}
