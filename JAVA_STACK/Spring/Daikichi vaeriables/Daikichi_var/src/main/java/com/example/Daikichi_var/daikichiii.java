package com.example.Daikichi_var;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")
public class daikichiii {

 @RequestMapping("/travel/{theHolyLand}")
 public String travel(@PathVariable("theHolyLand") String theHolyLand){
 	return "Congratulations! You will soon travel to" +" "+ theHolyLand+"!";
 }
 
 
 
 @RequestMapping("/travel/{lottoNumber}")
 public String index1(@PathVariable("lottoNumber") String lottoNumber){
	 if (Integer.parseInt(lottoNumber)%2==0) {
		 return "You will take a grand journey in the near future, but be weary of tempting offers";
	 }
	 else {
		 return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	 }
  
 }
}

