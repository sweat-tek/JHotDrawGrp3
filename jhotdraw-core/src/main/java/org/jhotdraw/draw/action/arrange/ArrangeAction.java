package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.util.ResourceBundleUtil;

import java.awt.event.ActionEvent;
import java.util.Collection;

public class ArrangeAction extends AbstractSelectedAction {
    private final ArrangeStrategy strategy;

    public ArrangeAction(DrawingEditor editor, ArrangeStrategy strategy) {
        super(editor);
        this.strategy = strategy;
        ResourceBundleUtil labels
                = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, strategy.getId());
        updateEnabledState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final DrawingView view = getView();
        final Collection<Figure> figures = view.getSelectedFigures();

        performArrangeAction(this.strategy, view, figures);
    }

    public void performArrangeAction(ArrangeStrategy strategy, DrawingView view, Collection<Figure> figures) {
        ArrangeActionTrigger action = new ArrangeActionTrigger(strategy, view, figures);

        action.performAction();

        fireUndoableEditHappened(action);
    }
}
