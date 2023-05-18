package ru.suyundukov.testshop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.suyundukov.testshop.commands.AddPurchaseCommand;
import ru.suyundukov.testshop.commands.ExitCommand;
import ru.suyundukov.testshop.commands.FindAllPurchaseCommand;
import ru.suyundukov.testshop.commands.FindByCriteriaCommand;

@Component
@RequiredArgsConstructor
public class CommandExecutor {
    @Autowired
    private final AddPurchaseCommand addPurchaseCommand;
    @Autowired
    private final ExitCommand exitCommand;
    @Autowired
    private final FindByCriteriaCommand findByCriteriaCommand;
    @Autowired
    private final FindAllPurchaseCommand findAllPurchaseCommand;

    public void executeCommand(int command){
        switch (command) {
            case 1:
                addPurchaseCommand.execute();
                break;
            case 2:
                findAllPurchaseCommand.execute();
                break;
            case 3:
                findByCriteriaCommand.execute();
                break;
            case 4:
                exitCommand.execute();
                break;
            default:
                System.out.println("Введите число от 1 до 4 для выполнения соответствующих комманд");
                System.out.println("1. Покупка товара");
                System.out.println("2. Вывод истории всех покупок");
                System.out.println("3. Поиск покупки по критерию");
                System.out.println("4. Выход из программы");
                return;
        }
    }
}