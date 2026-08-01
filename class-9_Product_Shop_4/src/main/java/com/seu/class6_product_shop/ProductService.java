package com.seu.class6_product_shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductInterface productInterface;

    public void saveProduct(Product product){

        if(product.getId() == 404){

            System.out.println("Product not ffound");
            return;
        }
        productInterface.save(product);
    }

    public List<Product> getAll(){

        productInterface.findAll();
    }

    public Product getById(int id){

        return productInterface.findById(id).orElse(null);
    }
}
