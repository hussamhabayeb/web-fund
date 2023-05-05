package com.example.travels.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.travels.models.Expense;
import com.example.travels.services.ExpensesServices;
@Controller
public class expenseController {
	private final ExpensesServices expensesServices;
	
	
    public expenseController(ExpensesServices expensesServices){
        this.expensesServices = expensesServices;
    }
    
    
    
    @GetMapping("/expenses")
    public String newExpense(@ModelAttribute("expense") Expense expense, Model model) {
    	
    	List<Expense> AllExp = expensesServices.allExpenses(); 
		model.addAttribute("expense", AllExp);
		
		
		
		
        return "exp.jsp";
    
    	
    }
		
}
