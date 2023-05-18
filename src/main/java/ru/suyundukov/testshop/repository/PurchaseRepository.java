package ru.suyundukov.testshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.testshop.entity.Product;
import ru.suyundukov.testshop.entity.Purchase;

/**
 * Репозиторий для покупок, наследуется от "JpaRepository<Purchase, Integer>", для работы с БД.
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    Purchase findPurchaseByProduct(Product product);
}
