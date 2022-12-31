package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.Collection;

public class ArrangeActionTrigger extends AbstractUndoableEdit {
    private final ArrangeStrategy strategy;
    private DrawingView view;
    private Collection<Figure> figures;

    public ArrangeActionTrigger(ArrangeStrategy strategy, DrawingView view, Collection<Figure> figures) {
        super();
        this.strategy = strategy;
        this.view = view;
        this.figures = figures;
    }

    @Override
    public String getPresentationName() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        return labels.getTextProperty(strategy.getId());
    }

    public void performAction() {
        strategy.arrangeFigures(view, figures);
    }

    @Override
    public void undo() throws CannotUndoException {
        super.undo();
        strategy.arrangeFigures(view, figures);
    }

    @Override
    public void redo() throws CannotRedoException {
        super.redo();
        this.performAction();
    }
}
