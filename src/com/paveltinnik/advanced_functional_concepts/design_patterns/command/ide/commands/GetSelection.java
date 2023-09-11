package com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.commands;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.editor.Editor;

public class GetSelection implements Command{
    private final Editor editor;

    public GetSelection(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.getSelection();
    }
}