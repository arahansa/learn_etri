package com.arahansa.springbootlevel1magicuser.testchapter.controller;

import com.arahansa.springbootlevel1magicuser.testchapter.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "book";
    }
}

