package com.example.dogo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dogo.model.Dojo;
import com.example.dogo.model.Ninja;
import com.example.dogo.repositoris.DojoRepositoris;
import com.example.dogo.repositoris.NinjaRepositoris;
import com.example.dogo.services.AppServices;

import jakarta.validation.Valid;

@Controller
public class AppController {

	private final AppServices appServices;
  
    
    public AppController(AppServices appServices) {
        this.appServices = appServices;
     
    }
    
	
    @GetMapping("/dojo/new")
    public String newDojo(@ModelAttribute("goToJspFile") Dojo dpjo1 ) {
	

	 
        return "new.jsp";
	
}
    
    @PostMapping("/dojo")
    public String create(@Valid @ModelAttribute("goToJspFile") Dojo dojo1, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	
            return "new.jsp";
        } else {
        	appServices.createdDojo(dojo1 );
        	 List<Dojo> dojos=appServices.allDojos();
    		 model.addAttribute("alldojos", dojo1);
            return "redirect:/dojo/new";
        }
    
        
        
    	
    }
    
    @GetMapping("/ninja/new")
    public String newNinga(@ModelAttribute("goToJspFile2") Ninja ninja1,Model model ) {
    	
   	 	List<Dojo> dojos=appServices.allDojos();
		 model.addAttribute("alldojos", dojos);

	 
        return "render.jsp";
    
}
    @PostMapping("/ninja")
    public String createNinja(@Valid @ModelAttribute("goToJspFile") Ninja ninja1, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	
            return "new.jsp";
        } else {
        	appServices.createNinja(ninja1 );
        	 List<Ninja> ninjas=appServices.allNinja();
    		 model.addAttribute("allninjas", ninja1);
            return "redirect:/ninja/new";
        }
    
        
        
    	
    }
    
    
    @GetMapping("/dojo/{Id}")
    public String showDojo(@PathVariable("Id") long Id,Model model ) {
	
    	
   	 Dojo dojo1=appServices.findDojo(Id);
		 model.addAttribute("allninjas", dojo1);
	 
        return "shownin.jsp";
	
}
}

    
    



