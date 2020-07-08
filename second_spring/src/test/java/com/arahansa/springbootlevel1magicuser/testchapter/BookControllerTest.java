package com.arahansa.springbootlevel1magicuser.testchapter;

import com.arahansa.springbootlevel1magicuser.service.MemberService;
import com.arahansa.springbootlevel1magicuser.testchapter.controller.BookController;
import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import com.arahansa.springbootlevel1magicuser.testchapter.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.contains;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @MockBean
    MemberService memberService;

    @Test
    void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));
        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attribute("bookList", contains(book)));
    }
}
