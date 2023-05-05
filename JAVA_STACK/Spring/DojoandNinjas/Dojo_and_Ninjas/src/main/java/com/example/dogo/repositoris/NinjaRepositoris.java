package com.example.dogo.repositoris;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.dogo.model.Ninja;

public interface NinjaRepositoris extends CrudRepository <Ninja, Long>{
	 // this method retrieves all the books from the database
    List<Ninja> findAll();
    // this method finds books with descriptions containing the search string
    
}