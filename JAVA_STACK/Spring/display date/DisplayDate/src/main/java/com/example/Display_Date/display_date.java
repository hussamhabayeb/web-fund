package com.example.Display_Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller



public class display_date  {
	
			@RequestMapping("/")
			public String render() {
				
				return "index.jsp";
	
			}
			Date now =new Date();
			
			@RequestMapping("/date")
			public String date(Model model) {
				
				SimpleDateFormat dateIn = new SimpleDateFormat("EEEE, MMMM d , y");
				String dateOut= dateIn.format(now); 
				model.addAttribute("date", dateOut );
				return "date.jsp";
	
			}
			@RequestMapping("/time")
			public String time(Model model) {
				
				SimpleDateFormat timeIn = new SimpleDateFormat("h:m:s a");
				String timeOut= timeIn.format(now); 


			
				model.addAttribute("time", timeOut);
				return "time.jsp";
	
			}
	        }

	


