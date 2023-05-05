package com.example.dogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dogo.model.Dojo;
import com.example.dogo.model.Ninja;
import com.example.dogo.repositoris.DojoRepositoris;
import com.example.dogo.repositoris.NinjaRepositoris;

@Service
public class AppServices {
	
	
    
    	private final NinjaRepositoris ninjaRepositoris;
	    private final DojoRepositoris dojoRepositoris;
	    
	    public AppServices(DojoRepositoris dojoRepositoris, NinjaRepositoris ninjaRepositoris) {
	        this.dojoRepositoris = dojoRepositoris;
	        this.ninjaRepositoris = ninjaRepositoris;
	    }
	    
	    
	    
	    
	    

	    // returns all the Dojo
	    public List<Dojo> allDojos() {
	        return dojoRepositoris.findAll();
	    }
	    // creates a Dojo
	    public Dojo createdDojo(Dojo d) {
	        return dojoRepositoris.save(d);
	    }
	    // retrieves a Dojo
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepositoris.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	    public List<Ninja> allNinja() {
	        return ninjaRepositoris.findAll();
	    }
	    // creates a Ninja
	    public Ninja createNinja(Ninja d) {
	        return ninjaRepositoris.save(d);
	    }
	    // retrieves a Ninja
	    public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepositoris.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
	}

