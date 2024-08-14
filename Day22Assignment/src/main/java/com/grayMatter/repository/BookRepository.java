package com.grayMatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
