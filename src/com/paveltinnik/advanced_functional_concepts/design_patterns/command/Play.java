package com.paveltinnik.advanced_functional_concepts.design_patterns.command;

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