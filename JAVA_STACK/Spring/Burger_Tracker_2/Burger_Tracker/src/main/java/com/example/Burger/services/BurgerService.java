package com.example.Burger.services;



import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.example.Burger.models.Burger;
import com.example.Burger.repository.BurgerRepository;

@Service
public class BurgerService {

	

	 private final BurgerRepository burgerRepository;
	 
	 
	 public BurgerService(BurgerRepository burgerRepository) {
	     this.burgerRepository = burgerRepository;
	 }
	 // returns all the Burger
	 public List<Burger> allBurgers() {
	     return burgerRepository.findAll();
	 }
	 
	 public Burger createBurger(Burger b) {
	     return burgerRepository.save(b);
	 }
	 // retrieves Burger
	 public Burger findBurger(Long id) {
	     Optional<Burger> optionalBurger= burgerRepository.findById(id);
	     if(optionalBurger.isPresent()) {
	         return optionalBurger.get();
	     } else {
	         return null;
	     }
	 }
	 public void deleteById(Long id) {
	     try {
	         burgerRepository.deleteById(id);
	     }
	     catch(IllegalArgumentException e) {
	         System.out.println("Invalid Arguments");
	     }

	 }
	 public Burger updateBurger(Burger b) {
		 return burgerRepository.save(b);
	 }
	}


