package ru.suyundukov.testshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.suyundukov.testshop.entity.Product;
import ru.suyundukov.testshop.repository.ProductRepository;

/**
 * Класс-сервис для продуктов, реализует основную бизнес-логику. Инжектит бин "ProductRepository" и работает с ним.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public boolean exists(String name){
        return productRepository.existsProductByName(name);
    }

    public Product findByName(String name) {
        return productRepository.findProductByName(name);
    }


}
