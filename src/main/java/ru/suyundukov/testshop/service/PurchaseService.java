package ru.suyundukov.testshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.suyundukov.testshop.entity.Purchase;
import ru.suyundukov.testshop.repository.PurchaseRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс-сервис для покупок, реализует основную бизнес-логику. Инжектит бин "PurchaseRepository" и работает с ним.
 */
@Service
@RequiredArgsConstructor
public class PurchaseService {
    @Autowired
    private final PurchaseRepository purchaseRepository;

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
                    list.get(i).getQuantity() + " pieces, " + "total: " +
                    list.get(i).getQuantity() * list.get(i).getProduct().getPrice());
        }
    }

    public void searchPurchases(String criteria) {
        List<Purchase> list = purchaseRepository.findAll();
        if (criteria == null || criteria.isBlank()) {
            System.out.println("Вы ввели пустую строку, пожалуйста введите название продукта.");
        }
        Pattern pattern = Pattern.compile(criteria, Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < list.size(); i++) {
            String purchaseInfo = list.get(i).getProduct().getName();
            if (purchaseInfo != null) {
                Matcher matcher = pattern.matcher(purchaseInfo);
                if (matcher.find()) {
                    System.out.println((i + 1) + ". " + list.get(i).getProduct().getName() + " , " +
                            list.get(i).getQuantity() + " pieces.");
                }
            }
        }
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