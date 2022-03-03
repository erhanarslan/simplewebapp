package com.erhanarslan.repository;

import org.springframework.data.repository.CrudRepository;

import com.erhanarslan.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {

}
