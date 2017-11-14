package com.andmicroservice.skeleton.resources;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("TestResource is up and running...");

        return "TestResource is up and running!";
    }
}
