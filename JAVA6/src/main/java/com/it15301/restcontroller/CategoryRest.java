package com.it15301.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.it15301.entity.Category;
import com.it15301.exception.ResourceException;
import com.it15301.repositories.CategoryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CategoryRest {
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@RequestMapping("/category")
	public List<Category> getCategory() {
		List<Category> lstCategory= cateRepo.findAll(); 
		return lstCategory;
	}
	
	@PostMapping("/category")
    public Category createCategory(@Valid @RequestBody Category category) {
        return cateRepo.save(category);
	}
	
        
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer id) throws ResourceException {
    	Category category = cateRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
        return ResponseEntity.ok().body(category);
    }
    
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Integer id, @RequestBody Category categoryDetail) throws ResourceException {
    	Category categoryUd = cateRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
    	categoryUd.setName(categoryDetail.getName());
		cateRepo.save(categoryUd);
        return ResponseEntity.ok().body(categoryUd);
    }
    
    @DeleteMapping("category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Integer id) throws ResourceException {
        cateRepo.findById(id).orElseThrow(()-> new ResourceException("Not found"));
        cateRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
