package com.it15301.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it15301.dto.OrderDetailDTO;
import com.it15301.dto.ProductDTO;
import com.it15301.entity.OrderDetail;
import com.it15301.entity.Product;
//import com.it15301.dto.UserDTO;

@Service
public class OrderDetailMapper {
	@Autowired
	private ModelMapper mapper;

	public OrderDetail convertToEntity(OrderDetailDTO orderDetailDTO)
	{
		OrderDetail entity = mapper.map(orderDetailDTO, OrderDetail.class);
		
		return entity;
	}

	public OrderDetailDTO convertToDTO(OrderDetail entity)
	{
		OrderDetailDTO orderDetailDTO = mapper.map(entity, OrderDetailDTO.class);
		
		return orderDetailDTO;
	}
}
