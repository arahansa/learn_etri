package com.arahansa.springbootlevel1magicuser.testchapter.controller;

import com.arahansa.springbootlevel1magicuser.testchapter.pojo.FruitProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @Value("${propertyTest}")
    private String propertyTestName;

    FruitProperty fruitProperty;

    ApplicationContext applicationContext;

    public TestController(FruitProperty fruitProperty, ApplicationContext applicationContext){
        this.fruitProperty = fruitProperty;
        this.applicationContext = applicationContext;
    }


    @GetMapping("/bean-list")
    public List<String> beanList(){
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }

    @GetMapping("hi")
    public String helloWorld33(){
        System.out.println("propertyTestName");
        System.out.println(propertyTestName);
        return "Hello World?----";
    }

    @GetMapping("/fruit")
    public FruitProperty fruitProperty(){
        return fruitProperty;
    }

}
