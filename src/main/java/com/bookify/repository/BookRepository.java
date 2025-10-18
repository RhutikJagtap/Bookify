package com.bookify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookify.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
