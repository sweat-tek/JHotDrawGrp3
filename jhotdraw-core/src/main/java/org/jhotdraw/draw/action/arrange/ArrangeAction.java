package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.util.ResourceBundleUtil;

import java.awt.event.ActionEvent;

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
        ArrangeActionTrigger action = new ArrangeActionTrigger(strategy, getView(), getView().getSelectedFigures());

        strategy.arrangeFigures(getView(), getView().getSelectedFigures());

        fireUndoableEditHappened(action);
    }
}
