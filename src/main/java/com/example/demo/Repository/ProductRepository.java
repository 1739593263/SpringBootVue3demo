package com.example.demo.Repository;

import com.example.demo.Bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // SELECT
    List<Product> findAll();
    List<Product> findAll(Pageable pageable);
    List<Product> findAllByProductNameIsContaining(String name);
    List<Product> findAllByProductIdIs(Integer id);
    List<Product> findAllByProductVendorContaining(String vendor);
    List<Product> findAllByProductPriceIs(Double price);
    List<Product> findAllByStockIs(Integer stock);
    // INSERT
    Product saveAndFlush(Product product);
}
