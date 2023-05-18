package ru.suyundukov.testshop.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.suyundukov.testshop.service.PurchaseService;

@Component
@RequiredArgsConstructor
public class FindAllPurchaseCommand implements Command {
    @Autowired
    private final PurchaseService purchaseService;

    @Override
    public void execute() {
        System.out.println("Вывод всей истории покупок");
        purchaseService.findAll();
    }
}
