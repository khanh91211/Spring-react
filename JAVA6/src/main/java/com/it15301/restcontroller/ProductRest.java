package com.it15301.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it15301.entity.Product;
import com.it15301.exception.ResourceException;
import com.it15301.repositories.ProductRepository;
import com.it15301.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductRest {
	
	@Autowired
	private ProductRepository proRepo;
	
	@RequestMapping("/product")
	public List<Product> getProduct() {
		List<Product> lstProduct= proRepo.findAll(); 
		return lstProduct;
	}
	
	@PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product) {
        return proRepo.save(product);
	}
	
        
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer id) throws ResourceException {
        Product product = proRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
        return ResponseEntity.ok().body(product);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer id, @RequestBody Product productDetail) throws ResourceException {
        Product productUd = proRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
		productUd.setName(productDetail.getName());
		productUd.setImage(productDetail.getImage());
		productUd.setPrice(productDetail.getPrice());
		productUd.setCreateDate(productDetail.getCreateDate());
		productUd.setAvailable(productDetail.getAvailable());
		productUd.setCategoryId(productDetail.getCategoryId());
		proRepo.save(productUd);
        return ResponseEntity.ok().body(productUd);
    }
    
    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer id) throws ResourceException {
        proRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
        proRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
