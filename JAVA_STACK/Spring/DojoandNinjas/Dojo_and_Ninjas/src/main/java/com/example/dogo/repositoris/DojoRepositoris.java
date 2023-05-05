package com.example.dogo.repositoris;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dogo.model.Dojo;

public interface DojoRepositoris extends CrudRepository<Dojo, Long>{
	 // this method retrieves all the books from the database
    List<Dojo> findAll();
    // this method finds books with descriptions containing the search string

}
