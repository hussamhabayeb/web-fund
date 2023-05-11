package com.example.Products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Products.models.Categorie;
import com.example.Products.models.Product;
import com.example.Products.repository.CategorieRepository;
import com.example.Products.repository.ProductRepository;
@Service
public class AppService {

	
 private final CategorieRepository categorieRepository;
 private final ProductRepository productRepository;
	 
	 
	 public AppService(CategorieRepository categorieRepository,ProductRepository productRepository) {
	     this.categorieRepository = categorieRepository;
	     this.productRepository=productRepository;
	 }
	
	 // returns all the Product
	 public List<Product> allProducts() {
	     return productRepository.findAll();
	 }
	
	// returns all the Category
		 public List<Categorie> allCategories() {
		     return categorieRepository.findAll();
		 }
		
	// create a Product
		 public Product createProduct(Product p) {
		     return productRepository.save(p);
		 }
		 
	// create a Category
		public Categorie createCategorie(Categorie c) {
				     return categorieRepository.save(c);
				 }
		 
	
   // retrieves Product
		 public Product findProduct(Long id) {
		     Optional<Product> optionalProduct= productRepository.findById(id);
		     if(optionalProduct.isPresent()) {
		         return optionalProduct.get();
		     } else {
		         return null;
		     }
		 }
		 
	// retrieves Category
		 public Categorie findCategorie(Long id) {
			Optional<Categorie> optionalCategorie= categorieRepository.findById(id);
				 if(optionalCategorie.isPresent()) {
				         return optionalCategorie.get();
				     } else {
				         return null;
				     }
				 }
	
	
	// add product to category
		 public void   addProduct_To_Category(Long product_id,Long category_id) {
			    
			    // retrieve an instance of a category using another method in the service.
			 
			    Categorie thisCategory = findCategorie(category_id);
			    
			    // retrieve an instance of a product using another method in the service.
			    Product thisProduct = findProduct(product_id);
			    
			    // add the product to this category's list of products
			    thisCategory.getProducts().add(thisProduct);
			    
			    // Save thisCategory, since you made changes to its product list.
			    categorieRepository.save(thisCategory);	


		 }
	
	
	
	
	
}
