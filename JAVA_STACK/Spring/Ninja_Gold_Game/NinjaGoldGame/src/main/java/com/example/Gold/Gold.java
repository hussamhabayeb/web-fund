package com.example.Gold;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
@Controller
public class Gold {
	
	
	
	Random randMachine = new Random();
	@RequestMapping("/")
	public String goldForm() {
		
		
		return"gold.jsp";
	}
	
	@PostMapping("/form")
	public String CollectGold( 
			@RequestParam(value="custom") int form,
			Model model,
			HttpSession session) {
		
		String color="text-success";
		int temp = 0 ;
		 String activity="";
		if (session.getAttribute("gold")==null) {
			session.setAttribute("gold",0);
		}
		if (session.getAttribute("message")==null) {
			session.setAttribute("message","");
		}

		if(form == 1) {
		  temp=randMachine.nextInt(10,21);
		  activity="<p class='"+color+"'>You entered a farm and earned "+temp+new Date()+"</p>";
		  session.setAttribute("message",session.getAttribute("message")+activity);
		}
		else if(form == 2) {
		  temp=randMachine.nextInt(5,11);	
		   activity="<p class='"+color+"'>You entered a cave and earned "+temp+new Date()+"</p>";
		  session.setAttribute("message",session.getAttribute("message")+activity);
		}
		else if(form == 3) {
		temp=randMachine.nextInt(2,6);
		   activity="<p class='"+color+"'>You entered a house and earned "+temp+new Date()+"</p>";
		  session.setAttribute("message",session.getAttribute("message")+activity);
			}
		else if(form ==4) {
		 temp=randMachine.nextInt(-50,51);
		
			if (temp<0) {
				 color="text-danger";
				 activity="<p class='"+color+"'>You entered a quest and lose "+temp+new Date()+"</p>";
				 
				}
			else
		activity="<p class='"+color+"'>You entered a farm and earned "+temp+new Date()+"</p>";
		  session.setAttribute("message",session.getAttribute("message")+activity);
			 }

		
		 session.setAttribute("gold",temp+(int) session.getAttribute("gold"));
		
		
		return"redirect:/";
	}
	
	@RequestMapping("/rest")
	public String clear(HttpSession session) {
		
	session.invalidate();
		
		return"redirect:/";
	}
	
}
