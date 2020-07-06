package com.arahansa.springbootlevel1magicuser.testchapter.repository;

import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
