package com.paveltinnik.advanced_functional_concepts.design_patterns.command.player.speaker;

public class SpeakerImpl implements Speaker {
    @Override
    public void play() {
        System.out.println("Play");
    }

    @Override
    public void pause() {
        System.out.println("Pause");
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume down");
    }
}