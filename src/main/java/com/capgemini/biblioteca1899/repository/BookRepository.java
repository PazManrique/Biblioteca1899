package com.capgemini.biblioteca1899.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.biblioteca1899.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
