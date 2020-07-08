package com.arahansa.springbootlevel1magicuser.testchapter;

import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import com.arahansa.springbootlevel1magicuser.testchapter.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaTest {
    private final static String BOOT_TEST_TITLE = "Spring Boot Test Book";
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    BookRepository bookRepository;

    @Test
    void Book_Save_Test() {
        Book book = Book.builder().title(BOOT_TEST_TITLE).publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book);
        assertThat(bookRepository.getOne(book.getIdx())).isEqualTo(book);
    }

    @Test
    void BookList_Save_Search() {

        Book book1 = Book.builder().title(BOOT_TEST_TITLE+"1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);

        Book book2 = Book.builder().title(BOOT_TEST_TITLE+"2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);

        Book book3 = Book.builder().title(BOOT_TEST_TITLE+"3").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book3);

        List<Book> bookList = bookRepository.findAll();
        assertThat(bookList).hasSize(3);
        assertThat(bookList).contains(book1, book2, book3);

    }

    @Test
    void BookList_Save_Delete() {
        Book book1 = Book.builder().title(BOOT_TEST_TITLE+"1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);

        Book book2 = Book.builder().title(BOOT_TEST_TITLE+"2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);

        bookRepository.deleteAll();

        assertThat(bookRepository.findAll()).isEmpty();
    }
}
