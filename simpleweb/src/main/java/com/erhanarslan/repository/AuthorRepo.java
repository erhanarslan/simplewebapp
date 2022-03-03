package com.erhanarslan.repository;

import org.springframework.data.repository.CrudRepository;

import com.erhanarslan.model.Author;

public interface AuthorRepo extends CrudRepository<Author, Long> {

}
