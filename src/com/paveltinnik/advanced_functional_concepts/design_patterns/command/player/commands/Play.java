package com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.commands;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.speaker.Speaker;

public class Play implements Command {

    private final Speaker speaker;

    public Play(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.play();
    }
}