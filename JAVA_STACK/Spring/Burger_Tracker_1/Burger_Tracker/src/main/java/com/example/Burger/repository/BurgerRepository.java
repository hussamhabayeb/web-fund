package com.example.Burger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Burger.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    // this method retrieves all the Burgers from the database
    List<Burger> findAll();
    
 
    Long countByNameContaining(String search);
   
    Long deleteByNameStartingWith(String search);
}
