package com.arahansa.springbootlevel1magicuser.testchapter.miscellaneous;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.arahansa.springbootlevel1magicuser.testchapter.config.AppContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// class 를 한정지으면 다른 컨텍스트 클래스가 로딩되지 않는다.
// Automatically searches for a
// * {@link SpringBootConfiguration @SpringBootConfiguration} when nested
// * {@code @Configuration} is not used, and no explicit {@link #classes() classes} are
// * specified.
@SpringBootTest(classes = {AppContext.class})
public class SpringJunitCompareSpringBootTest {
    @Autowired
    ApplicationContext applicationContext;

    /*
    @Autowired
    HelloService helloService;
    */

    @Test
    void name() {
        assertThat(applicationContext).isNotNull();
        // assertThat(helloService).isNotNull();

        List<String> strings = Arrays.asList(applicationContext.getBeanDefinitionNames());
        System.out.println("갯수 :"+strings);
        System.out.println("갯수 :"+strings.size());
    }

}
