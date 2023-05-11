package com.example.Products.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Products.models.Categorie;
import com.example.Products.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findAllByProduct(Categorie categorie);
	List<Product> findByProductsNotContains(Categorie categorie);
	
}