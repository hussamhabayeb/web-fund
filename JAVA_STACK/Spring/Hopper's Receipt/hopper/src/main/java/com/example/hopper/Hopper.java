package com.example.hopper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Hopper {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "hussam habayeb";
        String itemName = "shadid";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
        model.addAttribute("fullname", name);
        model.addAttribute("item", itemName);
        model.addAttribute("itemprice", price);
        model.addAttribute("desc", description);
        model.addAttribute("supplier", vendor);
    
        return "index.jsp";
    }
    //...
    

}
