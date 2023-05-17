package ru.suyundukov.testshop.service;

import org.springframework.stereotype.Service;
import ru.suyundukov.testshop.entity.Product;
import ru.suyundukov.testshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean exists(String name){
        return productRepository.existsProductByName(name);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findByName(String name) {
        return productRepository.findProductByName(name);
    }


}
