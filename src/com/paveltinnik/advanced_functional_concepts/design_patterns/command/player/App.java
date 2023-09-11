package com.paveltinnik.advanced_functional_concepts.design_patterns.command.player;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final List<Command> commands;

    public App() {
        commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void run() {
        for (Command command : commands) {
            command.execute();
        }
    }
}