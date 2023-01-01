package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.grouping.strategy.GroupingStrategy;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.Collection;

abstract class GroupingUndoableEdit extends AbstractUndoableEdit {
    private final GroupingStrategy groupingStrategy;
    private final DrawingView drawingView;
    private final CompositeFigure prototype;
    private final Collection<Figure> figures;

    public GroupingUndoableEdit(
        GroupingStrategy strategy,
        DrawingView drawingView,
        CompositeFigure prototype,
        Collection<Figure> figures
    ) {
        super();
        this.groupingStrategy = strategy;
        this.drawingView = drawingView;
        this.prototype = prototype;
        this.figures = figures;
    }

    @Override
    public String getPresentationName() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        return labels.getTextProperty(groupingStrategy.getID());
    }
}
