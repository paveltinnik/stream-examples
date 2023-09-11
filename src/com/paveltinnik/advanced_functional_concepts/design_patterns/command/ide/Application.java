package com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final List<Command> commands;

    public Application() {
        commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    void run() {
        for (Command command : commands) {
            command.execute();
        }
    }
}