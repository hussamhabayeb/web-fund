package com.example.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.club.models.Book;
import com.example.club.models.LoginUser;
import com.example.club.models.User;
import com.example.club.services.BookService;
import com.example.club.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {

     @Autowired
     private UserService userServ;
     
     @Autowired
     private BookService bookServ;
     
     
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "main.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "main.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/home";
	    }
	 
	 
	 
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "main.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	 
	 
	 
	 @GetMapping("/home")
	    public String home(Model model, HttpSession session) {
		 if (session.getAttribute("user_id") != null) {
	    	 System.out.println("zolo");
	         Long user_id = (Long) session.getAttribute("user_id");
	         User thisUser = userServ.findUserById(user_id);
	    
	         //////////////////////
	         List<Book> book1 = bookServ.allBooks();
	 		model.addAttribute("user", thisUser);
	 		model.addAttribute("books", book1);
	 		
	         
	         return "home.jsp";
	     } else {
	    	 System.out.print("not logged");
	         return "redirect:/";
	     }
	      
	    }
	 
	   @GetMapping("/books/new")
	    public String newBook( @ModelAttribute("book") Book book,Model model, HttpSession session ) {
		   if (session.getAttribute("user_id") != null) {
		    	 System.out.println("zolo");
		         Long user_id = (Long) session.getAttribute("user_id");
		         User thisUser = userServ.findUserById(user_id);
		    
		         //////////////////////
		         
		 		model.addAttribute("user", thisUser);
		 		
		 		
		         
		         return "creat_b.jsp";
		     } else {
		    	 System.out.print("not logged");
		         return "redirect:/";
		     }
		      
		    }
	    
	   @PostMapping("/books/new")
	    public String addBook(@Valid @ModelAttribute("book") Book book,BindingResult result,Model model, HttpSession session ) {
		   if (session.getAttribute("user_id") != null) {
		    	 System.out.println("zolo");
		         Long user_id = (Long) session.getAttribute("user_id");
		         User thisUser = userServ.findUserById(user_id);
		    
		         //////////////////////
		         
		 		model.addAttribute("user", thisUser);
		 		
		 		bookServ.createBook(book );
	        	 List<Book> Books=bookServ.allBooks();
	    		 model.addAttribute("book", Books);
	            return "redirect:/home";
	        }
		      else {
		    	 System.out.print("not logged");
		         return "redirect:/";
		     }
	   }
		      
	   
		   @GetMapping("/books/{id}")
		    public String detailsBook(@PathVariable("id") Long id,Model model, HttpSession session ) {
			   if (session.getAttribute("user_id") != null) {
			    	 System.out.println("zolo");
			         Long user_id = (Long) session.getAttribute("user_id");
			         User thisUser = userServ.findUserById(user_id);
			    
			         //////////////////////
			         
			 		model.addAttribute("user", thisUser);
			 		
			 		Book book1=bookServ.findBook( id);
			         model.addAttribute("boook", book1);
			         model.addAttribute("userId", thisUser);
			 		
			         
			         return "details_b.jsp";
			     } else {
			    	 System.out.print("not logged");
			         return "redirect:/";
			     }
			    
			   
			  
}
	   
		   @GetMapping("/logout")
		    public String logout( HttpSession session) {
		    	Long user_id = (Long) session.getAttribute("user_id");
		    	session.invalidate();
		    	return "redirect:/";
		    }

		   @GetMapping("/book/edit/{id}")
			 public String showEditBook(@PathVariable("id") Long id,@ModelAttribute("book") Book book,Model model,HttpSession session ) {
				 System.out.println("husssamhab");
				 if (session.getAttribute("user_id") != null) {
					 System.out.println("editMethod");
					 Long userId = (Long) session.getAttribute("user_id");
					  User thisUser = userServ.findUserById(userId);
					 Book book1=bookServ.findBook( id);
					  model.addAttribute("book1", book1);
			         model.addAttribute("userId", thisUser);
			         
			         return "edit_b.jsp";
				 }
				 
					return "redirect:/";
			 }
		   
		   @PutMapping("/book/edit/{id}")
			 public String submitEditBookt(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			    		@PathVariable("id") Long id,HttpSession session)  {
				 System.out.println(session.getAttribute("1111"));
					if(session.getAttribute("user_id") == null) {
						 System.out.println(session.getAttribute("2222222"));
						return "redirect:/";
					}
					
					if(result.hasErrors()) {
						System.out.println("abdooooooon");
						
						return "edit_p.jsp";
					}else {
						 System.out.println(session.getAttribute("donee"));
						 
						 Long user_id = (Long) session.getAttribute("user_id");
				         User thisUser = userServ.findUserById(user_id);
				    
				         //////////////////////
				         
				 		model.addAttribute("user", thisUser);
						 bookServ.updateBook(book);
						
							
						return "redirect:/home";
					}
		}

		   
		   
		   @GetMapping("/book/delete/{id}")
		   public String destroy(@PathVariable("id") Long id) {
			   bookServ.deleteBook(id);
			   return "redirect:/home";
		   }
}
