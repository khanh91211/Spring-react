package com.it15301.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it15301.dto.OrderDetailDTO;
import com.it15301.dto.ProductDTO;
import com.it15301.entity.Category;
import com.it15301.entity.Order;
import com.it15301.entity.OrderDetail;
import com.it15301.entity.Product;
import com.it15301.mappers.OrderDetailMapper;
import com.it15301.mappers.ProductMapper;
import com.it15301.repositories.CategoryRepository;
import com.it15301.repositories.OrderRepository;
import com.it15301.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderDetailMapper mapper;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("prod",this.productRepo.findAll());
		return "index";
	}
	
	
	@RequestMapping("/product")
	public String product(Model model) {
		String idcate = request.getParameter("cate_sort");
		String sortField = idcate == null ? "" : idcate;
		List<Product> lstProduct;
//		lstProduct= sortField == "category_id" ? productRepo.findAll() :productRepo.findByCate(sortField);
		if(sortField == "" || sortField == null) {
			lstProduct=productRepo.findAll();
		}else {
			lstProduct=productRepo.findByCate(sortField);
		}
		model.addAttribute("prod",lstProduct);
		List<Category> lstCategory = categoryRepo.findAll();
		model.addAttribute("categr",lstCategory);
		return "product";
	}
	
//	@SuppressWarnings("unused")
	@RequestMapping("/product/addcart")
	   public String addProduct(Model model,
			   @Valid OrderDetailDTO ordeDetail) {
		  Integer idaddCart = Integer.valueOf(request.getParameter("id_addcart"));
	      OrderDetail orderdt=this.mapper.convertToEntity(ordeDetail);
	      System.out.println(idaddCart);
//    	  orderdt.setOrderid(1);
//    	  orderdt.setProductid(idaddCart);
//    	  orderdt.setPrice(Double.valueOf(12.3));
//    	  orderdt.setQuantity(1);
    	  this.orderRepo.save(orderdt);
	      return "redirect:/product";
	   }
}
