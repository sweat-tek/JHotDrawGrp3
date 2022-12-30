package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.figure.TextHolderFigure;
import org.jhotdraw.draw.text.FloatingTextField;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import java.awt.event.ActionListener;

public class TextEditUtil {

    public static UndoableEdit createUndoableEdit(final TextHolderFigure editedFigure, final String oldText, final String newText) {
        return new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("attribute.text.text");
            }

            @Override
            public void undo() {
                super.undo();
                editedFigure.willChange();
                editedFigure.setText(oldText);
                editedFigure.changed();
            }

            @Override
            public void redo() {
                super.redo();
                editedFigure.willChange();
                editedFigure.setText(newText);
                editedFigure.changed();
            }
        };
    }

    public static FloatingTextField initializeTextField(FloatingTextField textField, ActionListener listener) {
        if (textField == null) {
            textField = new FloatingTextField();
            textField.addActionListener(listener);
        }
        return textField;
    }
}
