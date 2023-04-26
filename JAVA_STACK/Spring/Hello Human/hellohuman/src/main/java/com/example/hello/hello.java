package com.example.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class hello {
	
	@RequestMapping("")
  
    public String index() { 
            return "Hello human!";
    }
	


	    @RequestMapping("/name")
	    public String index1(@RequestParam(value="name") String x) {
	        return "You searched for: " + x;
	    }
	    
	    




