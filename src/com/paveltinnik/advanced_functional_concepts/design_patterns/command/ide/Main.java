package com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide;

import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.commands.ReplaceSelection;
import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.commands.SaveToClipboard;
import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.commands.SelectAll;
import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.editor.Editor;
import com.paveltinnik.advanced_functional_concepts.design_patterns.command.ide.editor.EditorImpl;

public class Main {
    public static void main(String[] args) {
        Editor editor = new EditorImpl();

        Application application = new Application();

        application.add(new SelectAll(editor));
        application.add(new SaveToClipboard(editor));
        application.add(new ReplaceSelection(editor));

        application.run();
    }
}
