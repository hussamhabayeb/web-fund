package com.example.Products.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Products.models.Categorie;
import com.example.Products.models.Product;
import com.example.Products.services.AppService;

import jakarta.validation.Valid;


@Controller
public class AppController {


 	private final AppService appService;
	private Long prod_id;
 	
 	
 	
    public AppController(AppService appService){
        this.appService = appService;
    }
	
    
    @GetMapping("/")
    public String homePage(Model model) {
    	List<Product> products=appService.allProducts();
    	List<Categorie> categories=appService.allCategories();
	 model.addAttribute("pro", products);
	 model.addAttribute("cat", categories);
	 
	 
        return "home.jsp";
    }
    
    @GetMapping("/products/new")
    public String renderProduct(@ModelAttribute("productss") Product product) {
    	
        return "showpro.jsp";
    }
    
    
    
    @PostMapping("/product")
    public String create(@Valid @ModelAttribute("productss") Product product, BindingResult result) {
        if (result.hasErrors()) {
        	
            return "showpro.jsp";
        } else {
        	appService.createProduct(product );
        	
            return "redirect:/";
        }
    
    
    
}
    
    @GetMapping("/Categories/new")
    public String renderProduct(@ModelAttribute("categoriess") Categorie categories) {
    	
        return "showcat.jsp";
    }
    
    
    
    @PostMapping("/categorie")
    public String create(@Valid @ModelAttribute("categoriess")  Categorie categories, BindingResult result) {
        if (result.hasErrors()) {
        	
            return "showcat.jsp";
        } else {
        	appService.createCategorie(categories );
        	
            return "redirect:/";
        }
   
}
    
    @GetMapping("/product/{prod_id}")
    public String renderAddProduct(@ModelAttribute("goToJspFile3")  Categorie categories,@PathVariable("prod_id") Long id, Model model) {
    	Product product1 =appService.findProduct(id);
    	model.addAttribute("prod", product1);
    	
    	List<Categorie> allcat=appService.allCategories();
    	 model.addAttribute("cat", allcat);
        return "addpro.jsp";
    }
    
    
    
    @PostMapping("/product/{prod_id}")
    public String AddProduct(@ModelAttribute("goToJspFile3") Product product,@PathVariable("prod_id") Long id, Long category_id) {
    	Product product_1 =appService.findProduct(prod_id);
    	Categorie category_1 =appService.findCategorie(category_id);
    	appService.addProduct_To_Category(prod_id,category_id);
    	

    }
    
}
