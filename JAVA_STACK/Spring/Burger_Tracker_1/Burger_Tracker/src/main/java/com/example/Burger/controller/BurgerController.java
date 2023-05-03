package com.example.Burger.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Burger.models.Burger;
import com.example.Burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	 	private final BurgerService burgerService;
	    public BurgerController(BurgerService burgerService){
	        this.burgerService = burgerService;
	    }
	 @GetMapping("/")
	    public String newBurger(@ModelAttribute("burg") Burger burger,Model model) {
		 List<Burger> burgers=burgerService.allBurgers();
		 model.addAttribute("burgers", burgers);
		 System.out.println(burgers);
		 
	        return "show.jsp";
	    }
	    @PostMapping("/burger")
	    public String create(@Valid @ModelAttribute("book") Burger burger, BindingResult result,Model model) {
	        if (result.hasErrors()) {
	        	
	            return "show.jsp";
	        } else {
	        	burgerService.createBurger(burger );
	        	 List<Burger> burgers=burgerService.allBurgers();
	    		 model.addAttribute("burgers", burgers);
	            return "redirect:/";
	        }
	        
	    }
	    @RequestMapping("{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	Burger burger = burgerService.findBurger(id);
	        model.addAttribute("burger", burger);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/burgers/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("burgers", burger);
	            return "edit.jsp";
	        } else {
	        	burgerService.updateBurger(burger);
	            return "redirect:/";
	        }
	    }
}
