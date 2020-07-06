package com.arahansa.springbootlevel1magicuser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlainTest {
    @Test
    public void contextLoads() {
        assertThat("Hello World").isEqualTo("Hello World");
    }
}
