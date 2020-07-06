package com.arahansa.springbootlevel1magicuser.testchapter;


import com.arahansa.springbootlevel1magicuser.testchapter.controller.BookController;
import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import com.arahansa.springbootlevel1magicuser.testchapter.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MockBookControllerTest {

    BookController bookController;
    @Mock
    BookService bookService;
    ExtendedModelMap model;

    /*
        MockHttpServletRequest
        MockHttpServletResponse,
        BeanPropertyBindingResult
        등의 클래스들을 이용하여 파라미터들을 전달할 수 있다
    */
    @BeforeEach
    void setup(){
        bookController = new BookController(bookService);
        model = new ExtendedModelMap();
    }

    @Test
    void getBookList() {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        given(bookService.getBookList()).willReturn(Arrays.asList(book));
        String bookList = bookController.getBookList(model);
        assertThat(bookList).isEqualTo("book");
        List<Book> getBookList = (List<Book>) model.get("bookList");
        assertThat(getBookList).hasSize(1);
        assertThat(getBookList).contains(book);
    }
}
