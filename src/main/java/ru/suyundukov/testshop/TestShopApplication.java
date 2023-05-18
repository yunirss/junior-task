package ru.suyundukov.testshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestShopApplication implements CommandLineRunner {
    @Autowired
    private CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(TestShopApplication.class, args);
    }
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
