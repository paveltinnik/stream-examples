package com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.editor;

import java.util.Scanner;

public class EditorImpl implements Editor {
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();

    @Override
    public void selectAll() {
        System.out.println("selecting all: \"" + text + "\"");
    }

    @Override
    public String getSelection() {
        return text;
    }

    @Override
    public void replaceSelection(String value) {
        System.out.println("replacing selection to \"" + value + "\"");
    }

    @Override
    public String getClipboard() {
        return text;
    }

    @Override
    public void saveToClipboard(String value) {
        System.out.println("saving \"" + value + "\" to clipboard");
    }
}
