package com.example.demo.Service.ServiceImplement;

import com.example.demo.Bean.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductServiceImplmn implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public List<Product> findAllProducts(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page,size);
        List<Product> list = productRepository.findAll(pageable);
        return list;
    }

    @Override
    public List<Product> findAllProductsByName(String name) {
        List<Product> list = productRepository.findAllByProductNameIsContaining(name);
        return list;
    }

    @Override
    public List<Product> findAllProductsByProductId(String id) {
        List<Product> list = productRepository.findAllByProductIdIs(Integer.parseInt(id));
        return list;
    }

    @Override
    public List<Product> findAllProductsByProductVendor(String vendor) {
        List<Product> list = productRepository.findAllByProductVendorContaining(vendor);
        return list;
    }

    @Override
    public List<Product> findAllProductsByProductPrice(String price) {
        List<Product> list = productRepository.findAllByProductPriceIs(Double.parseDouble(price));
        return list;
    }

    @Override
    public List<Product> findAllProductsByStock(String stock) {
        List<Product> list = productRepository.findAllByStockIs(Integer.parseInt(stock));
        return list;
    }

    @Override
    public boolean saveProduct(Product product) {
        Product p = productRepository.save(product);
        if(p.getProductId() == product.getProductId())
            return true;
        else return false;
    }
}
