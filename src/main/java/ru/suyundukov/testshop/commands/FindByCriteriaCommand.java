package ru.suyundukov.testshop.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.suyundukov.testshop.service.PurchaseService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FindByCriteriaCommand implements Command {
    @Autowired
    private final PurchaseService purchaseService;

    @Override
    public void execute() {
        System.out.println("Поиск покупок по названию продукта");
        System.out.println("Введите название продукта : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        purchaseService.searchPurchases(name);
    }
}