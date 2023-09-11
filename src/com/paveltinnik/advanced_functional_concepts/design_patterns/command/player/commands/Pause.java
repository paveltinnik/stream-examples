package com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.commands;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.speaker.Speaker;

public class Pause implements Command {

    private final Speaker speaker;

    public Pause(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.pause();
    }
}