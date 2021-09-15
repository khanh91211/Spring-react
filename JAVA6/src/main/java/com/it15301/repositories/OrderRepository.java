package com.it15301.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it15301.entity.OrderDetail;

public interface OrderRepository extends JpaRepository<OrderDetail, Integer>{
	
//	@Query("SELECT entity FROM Orderdetails entity WHERE Orderid LIKE: Orderid")
//	public List<OrderDetail> findByOrder(Integer Orderid);
	
}
