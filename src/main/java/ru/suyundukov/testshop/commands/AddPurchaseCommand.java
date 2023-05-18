package ru.suyundukov.testshop.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.suyundukov.testshop.entity.Product;
import ru.suyundukov.testshop.entity.Purchase;
import ru.suyundukov.testshop.service.ProductService;
import ru.suyundukov.testshop.service.PurchaseService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class AddPurchaseCommand implements Command {
    @Autowired
    private final ProductService productService;
    @Autowired
    private final PurchaseService purchaseService;

    @Override
    public void execute() {
        System.out.println("Что хотите добавить?");
        System.out.println("1. Apples");
        System.out.println("2. Bananas");
        System.out.println("3. Oranges");
        System.out.println("4. Pears");
        System.out.println("5. Pineapples");
        Scanner scanner = new Scanner(System.in);
        String answer;
        while (true) {
            answer = scanner.nextLine().trim();
            if (productService.exists(answer)) {
                break;
            } else {
                System.out.println("Такого продукта не существует, попробуйте еще раз");
            }
        }
        System.out.println("Сколько нужно?");
        int quantity;
        while (true) {
            quantity = scanner.nextInt();
            if (quantity < 1) {
                System.out.println("Введите положительное число");
            } else {
                break;
            }
        }
        Product product = productService.findByName(answer);
        Purchase purchase = new Purchase(product, quantity);
        purchaseService.addPurchase(purchase);
        int total = product.getPrice() * quantity;
        System.out.println("Сумма покупки : " + total);
        purchaseService.savePurchaseInFile(purchase);
        System.out.println("Покупка сохранена в файл \"purchase_history.txt\"");
    }
}