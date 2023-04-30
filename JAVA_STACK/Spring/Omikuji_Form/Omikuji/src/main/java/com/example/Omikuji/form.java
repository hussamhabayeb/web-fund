package com.example.Omikuji;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class form {
	
	
	
	@RequestMapping("/omikuji")
	public String index1() {
		return "index.jsp";
	}

	// ...
	@PostMapping("/login")
	public String index2(
		@RequestParam(value="number") String number,
	    @RequestParam(value="city") String city,
	    @RequestParam(value="name") String name,
	    @RequestParam(value="hobby") String hobby,
	    @RequestParam(value="animal") String animal,
	    @RequestParam(value="nice")String nice,Model model,HttpSession session) 
	    {
	    	session.setAttribute("number", number);
	    	session.setAttribute("city", city);
	    	session.setAttribute("name", name);
	    	session.setAttribute("hobby", hobby);
	    	session.setAttribute("animal", animal);
	    	session.setAttribute("nice", nice);
	    	
	    	
	    	return "redirect:/index"; // <-- we'll change this when we learn redirecting
	}
	@RequestMapping("/index")
	public String index3() {
		return "form.jsp";
	}
	// ...

}
