package com.arahansa.springbootlevel1magicuser.testchapter.miscellaneous;


import com.arahansa.springbootlevel1magicuser.Springbootlevel1magicuserApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        properties = {"property.value=propertyTest"},
        classes = Springbootlevel1magicuserApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class SpringBootTestApplicationTests {

//    @Value("${value}")
//    private String value;


    @Value("${property.value}")
    private String propertyValue;

    @Test
    void contextLoads() {
        // assertThat(value).isEqualTo("test");
        assertThat(propertyValue).isEqualTo("propertyTest");
    }
}
