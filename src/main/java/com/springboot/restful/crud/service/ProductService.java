package com.springboot.restful.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.crud.entity.Product;
import com.springboot.restful.crud.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	public List<Product> saveProduct(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id){
		return productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		 productRepository.deleteById(id);
		 return "product:"+ id + " is removed";
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setId(product.getId());
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}
	
	
}
