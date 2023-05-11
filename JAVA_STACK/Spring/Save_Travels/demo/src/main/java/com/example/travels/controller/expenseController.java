package com.example.travels.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.travels.models.Expense;
import com.example.travels.services.ExpensesServices;

import jakarta.validation.Valid;
@Controller
public class expenseController {
	private final ExpensesServices expensesServices;
	
	
    public expenseController(ExpensesServices expensesServices){
        this.expensesServices = expensesServices;
    }
    
    
    
    @GetMapping("/expenses")
    public String newExpense(@ModelAttribute("exp") Expense expense, Model model) {
    	
    	List<Expense> AllExp = expensesServices.allExpenses(); 
		model.addAttribute("expense", AllExp);
		
		
		
		
        return "exp.jsp";
    
    	
    }
    @PostMapping("/expense")
    public String create(@Valid @ModelAttribute("exp") Expense expense, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	
        	 List<Expense> expenses=expensesServices.allExpenses();
    		 model.addAttribute("expense",expenses);
            return "exp.jsp";
        } else {
        	expensesServices.createExpenses(expense );
        	
            return "redirect:/expenses";
        }
        
    }
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Expense expense = expensesServices.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
    @PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,@PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
        	
            model.addAttribute("expense", expense);
            return "edit.jsp";
        } else {
        	expensesServices.updateExpense(expense);
            return "redirect:/expenses/edit/"+id ;
        }
    }
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	expensesServices.deleteById(id);
        return "redirect:/expenses";
    }
    
    @GetMapping("/expenses/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
    	Expense expense1 = expensesServices.findExpense(id);
        model.addAttribute("ex", expense1);
        return "details.jsp";
    }
}
