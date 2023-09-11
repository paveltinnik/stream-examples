package com.paveltinnik.advanced_functional_concepts.design_patterns.command;

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new SpeakerImpl();

        App app = new App();

        // Here is example of method references
        app.add(speaker::play);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeDown);
        app.add(speaker::volumeDown);
        app.add(speaker::pause);

        app.run();
    }
}