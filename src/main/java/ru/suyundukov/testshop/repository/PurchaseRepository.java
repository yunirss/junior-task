package ru.suyundukov.testshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suyundukov.testshop.entity.Purchase;

/**
 * Интерфейс, содержит методы для работы с базами данных
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
