package com.arahansa.springbootlevel1magicuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
		classes = Springbootlevel1magicuserApplication.class,
		properties = {"property.value=propertyTest"}
		,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Springbootlevel1magicuserApplicationTests {

	@Value("${property.value}")
	private String propertyValue;


	@Test
	public void contextLoadsTest() {
		System.out.println(propertyValue);
		assertThat(propertyValue).isEqualTo("propertyTest");
	}
}

