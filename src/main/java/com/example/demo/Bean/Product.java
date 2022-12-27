package com.example.demo.Bean;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="productId")
    private Integer productId;

    @Column(name="productName")
    private String productName;
    @Column(name="productVendor")
    private String productVendor;
    @Column(name="productPrice")
    private double productPrice;
    @Column(name="stock")
    private Integer stock;

    public Product(){

    }

    public Product(Integer productId,
                   String productName,
                   String productVendor,
                   double productPrice,
                   Integer stock){
        this.productId = productId;
        this.productName = productName;
        this.productVendor = productVendor;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public Integer getProductId(){
        return productId;
    }

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
