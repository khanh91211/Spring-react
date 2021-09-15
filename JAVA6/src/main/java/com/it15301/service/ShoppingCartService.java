package com.it15301.service;

import com.it15301.exception.ResourceException;
import com.it15301.entity.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService{

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws ResourceException;

    BigDecimal getTotal();
}

