package com.oleus.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oleus.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
