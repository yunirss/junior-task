package ru.suyundukov.testshop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Test implements CommandLineRunner {
    @Autowired
    private CommandExecutor commandExecutor;

    @Override
    public void run(String... args) {
        System.out.println("Выберите команду : ");
        System.out.println("1. Покупка товара");
        System.out.println("2. Вывод истории всех покупок");
        System.out.println("3. Поиск покупки по критерию");
        System.out.println("4. Выход ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int answer = scanner.nextInt();
            commandExecutor.executeCommand(answer);
        }
    }
}
