package com.arahansa.springbootlevel1magicuser.testchapter.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer idx;

    private String title;

    private LocalDateTime publishedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt){
        this.title = title;
        this.publishedAt = publishedAt;
    }

}
