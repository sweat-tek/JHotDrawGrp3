package org.jhotdraw.draw.action.arrange;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.util.ResourceBundleUtil;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ArrangeAction extends AbstractSelectedAction {
    private final ArrangeStrategy strategy;

    @FeatureEntryPoint("Arrange")
    public ArrangeAction(DrawingEditor editor, ArrangeStrategy strategy) {
        super(editor);
        this.strategy = strategy;
        ResourceBundleUtil labels
                = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, strategy.getId());
        updateEnabledState();
    }

    @Override
    @FeatureEntryPoint("Arrange")
    public void actionPerformed(ActionEvent e) {
        final DrawingView view = getView();
        final LinkedList<Figure> figures = new LinkedList<>(view.getSelectedFigures());

        ArrangeEdit edit = new ArrangeEdit(
                strategy, view, figures
        );

        edit.performEdit();

        fireUndoableEditHappened(edit);
    }
}
