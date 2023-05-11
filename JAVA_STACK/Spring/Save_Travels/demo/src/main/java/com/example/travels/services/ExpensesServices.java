package com.example.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.travels.models.Expense;
import com.example.travels.repository.BxpensesRepository;

@Service
public class ExpensesServices {
	 private final BxpensesRepository expensesRepository;
	    
	    public ExpensesServices(BxpensesRepository expensesRepository) {
	        this.expensesRepository = expensesRepository;
	    }
	    
	    
	    
	    
	    
	    public List<Expense> allExpenses() {
	        return expensesRepository.findAll();
	    }
	    
	    
	    
	    
	    public Expense createExpenses(Expense E) {
	        return expensesRepository.save(E);
	    }
	    
	    
	    
	    
	    
	    public Expense findExpense(Long id) {
	        Optional<Expense> optionalExpense = expensesRepository.findById(id);
	        if(optionalExpense.isPresent()) {
	            return optionalExpense.get();
	        } else {
	            return null;
	        }
	    }
	    
	    
	    
	    public void deleteById(Long id) {
		     try {
		    	 expensesRepository.deleteById(id);
		     }
		     catch(IllegalArgumentException e) {
		         System.out.println("Invalid Arguments");
		     }

		 }
	    
	    
	    
		 public Expense updateExpense(Expense e) {
			 return expensesRepository.save(e);
		 }
}
