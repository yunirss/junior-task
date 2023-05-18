package ru.suyundukov.testshop.commands;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.exit(0);
    }
}
