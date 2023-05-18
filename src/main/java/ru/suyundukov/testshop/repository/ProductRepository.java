package ru.suyundukov.testshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.testshop.entity.Product;

/**
 * Репозиторий для продуктов, наследуется от "JpaRepository<Product, Integer>", для работы с БД.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsProductByName(String name);
    Product findProductByName(String name);
}
