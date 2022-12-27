package com.example.demo.Service;

import com.example.demo.Bean.Product;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {
    // SELECT
    List<Product> findAllProducts();
    List<Product> findAllProducts(int page, int size);
    List<Product> findAllProductsByName(String name);
    List<Product> findAllProductsByProductId(String id);
    List<Product> findAllProductsByProductVendor(String vendor);
    List<Product> findAllProductsByProductPrice(String price);
    List<Product> findAllProductsByStock(String stock);

    // INSERT
    boolean saveProduct(Product product);
}
