package ru.suyundukov.testshop.service;

import org.springframework.stereotype.Service;
import ru.suyundukov.testshop.entity.Purchase;
import ru.suyundukov.testshop.repository.PurchaseRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Интерфейс, содержит методы для класса.
 */
@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository repository) {
        this.purchaseRepository = repository;
    }

    public void addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public void findAll() {
        if (purchaseRepository.findAll().isEmpty()) {
            System.out.println("История покупок пуста.");
        }
        List<Purchase> list = purchaseRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getProduct().getName() + " , " +
                    list.get(i).getQuantity() + " pieces.");//todo добавить сумму покупки
        }
    }

    public void searchPurchases(String criteria) {

    }

    public void savePurchaseInFile(Purchase purchase) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("purchase_history.txt", true))) {
            int total = purchase.getProduct().getPrice() * purchase.getQuantity();
            writer.write(purchase.getProduct().getName() + ", " + purchase.getQuantity() + ", " + total);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving purchase history: " + e.getMessage());
        }
    }
}
