package com.practiseapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiseapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
