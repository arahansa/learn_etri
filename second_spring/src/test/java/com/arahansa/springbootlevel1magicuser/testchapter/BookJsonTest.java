package com.arahansa.springbootlevel1magicuser.testchapter;


import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTest {

    @Autowired
    JacksonTester<Book> json;

    @Test
    void json_테스트() throws IOException {
        Book book = Book.builder().title("테스트").build();
        String content = "{\"title\":\"테스트\"}";

        assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
        assertThat(this.json.parseObject(content).getPublishedAt()).isNull();

        assertThat(this.json.write(book)).isEqualToJson("/test.json");
        assertThat(this.json.write(book)).hasJsonPathStringValue("title");
        assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");
    }
}
