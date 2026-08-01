package com.seu.class6_product_shop;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInterface extends JpaRepository<Product, Integer> {

    List<Product> findAllByStockGreaterThan(int stock);
}
