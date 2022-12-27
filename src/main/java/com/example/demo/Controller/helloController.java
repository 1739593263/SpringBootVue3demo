package com.example.demo.Controller;

import com.example.demo.Bean.Message;
import com.example.demo.Bean.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://192.168.0.177:8081")
public class helloController {
    @Autowired
    private ProductService productService;

    private static List<Product> productList = new ArrayList<Product>();
    static{
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Drone");
        product.setProductVendor("DJ");
        product.setProductPrice(500);
        product.setStock(10);

        Product product1 = new Product();
        product1.setProductId(2);
        product1.setProductName("Switch");
        product1.setProductVendor("DJ");
        product1.setProductPrice(600);
        product1.setStock(25);

        productList.add(product);
        productList.add(product1);
    }

    @RequestMapping("/products")
    public Message getProducts(){
        productList = productService.findAllProducts();

        Message message = new Message();
        return message.success().add("product_Info",productList);
    }

    @GetMapping("/productsByColumn")
    public Message getProductsByColumn(@RequestParam(value = "type", defaultValue = "NULL") String type,
                                   @RequestParam(value = "content", defaultValue = "0") String content){
        Message message = new Message();
        if("NULL".equals(type)) return message.fail().add("product_Info",productList);
        else{
            if("productId".equals(type)) productList = productService.findAllProductsByProductId(content);
            if("productName".equals(type)) productList = productService.findAllProductsByName(content);
            if("productVendor".equals(type)) productList = productService.findAllProductsByProductVendor(content);
            if("productPrice".equals(type)) productList = productService.findAllProductsByProductPrice(content);
            if("stock".equals(type)) productList = productService.findAllProductsByStock(content);
        }
        return message.success().add("product_Info",productList);
    }

    @GetMapping("/saveProduct")
    public Message saveProduct(@RequestParam(value = "productName", defaultValue = "NULL") String productName,
                               @RequestParam(value = "productVendor", defaultValue = "NULL") String productVendor,
                               @RequestParam(value = "productPrice", defaultValue = "0") String productPrice,
                               @RequestParam(value = "stock", defaultValue = "0") String stock){
        Message message = new Message();
        Product product = new Product();
        product.setProductName(productName);
        product.setProductVendor(productVendor);
        product.setProductPrice(Double.parseDouble(productPrice+""));
        product.setStock(Integer.parseInt(stock+""));
        boolean b = productService.saveProduct(product);
        productList = productService.findAllProducts();
        return b? message.success().add("product_Info",productList):message.fail().add("product_Info",productList);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/world")
    public String sayWorld(@RequestParam(value = "myName", defaultValue = "REST World") String name) {
        return String.format("Hello %s!", name);
    }
}
