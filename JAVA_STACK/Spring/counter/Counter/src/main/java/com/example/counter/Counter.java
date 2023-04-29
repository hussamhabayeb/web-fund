package com.example.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller 

public class Counter {

	
	@RequestMapping("/your_server")
	public String myCounter(HttpSession  session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
	
	
	@RequestMapping("/your_server/counter")
	public String myCounter1(HttpSession  session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
			}
			else {
				session.setAttribute("count",(Integer)session.getAttribute("count")+1);
			}
					return "counter1.jsp";
	}
	
	
	
}
