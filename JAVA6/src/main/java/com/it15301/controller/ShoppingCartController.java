package com.it15301.controller;

import com.it15301.entity.OrderDetail;
import com.it15301.entity.Product;
import com.it15301.repositories.OrderRepository;
import com.it15301.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	@RequestMapping("/cart")
	public String cart(Model model) {
//		List<OrderDetail> lstOrder = orderRepo.findByOrder(1);
//		for(int i=0;i<lstOrder.size();i++) {
//			Optional<Product> lstProduct = proRepo.findById(lstOrder.get(i).getProductid());
//			model.addAttribute("proCart",lstProduct);
//		}
		return "cart";
	}
}
