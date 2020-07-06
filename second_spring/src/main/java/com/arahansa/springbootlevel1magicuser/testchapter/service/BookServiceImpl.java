package com.arahansa.springbootlevel1magicuser.testchapter.service;

import com.arahansa.springbootlevel1magicuser.testchapter.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Override
    public List<Book> getBookList() {
        return Collections.emptyList();
    }
}
