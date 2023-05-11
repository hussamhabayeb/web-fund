package com.example.Products.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Products.models.Categorie;
import com.example.Products.models.Product;
@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long>{
   
	List<Categorie> findAll();
	List<Categorie> findAllByProduct(Product product);
	List<Categorie> findByProductsNotContains(Product product);
	
}