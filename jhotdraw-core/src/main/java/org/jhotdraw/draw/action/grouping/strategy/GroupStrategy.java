package org.jhotdraw.draw.action.grouping.strategy;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.grouping.Grouping;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;
import java.util.LinkedList;

public class GroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.groupSelection";
    private final Grouping grouping = new Grouping();

    @Override
    public String getID() {
        return GroupStrategy.ID;
    }

    @Override
    public boolean canPerformAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        return drawingView.getSelectionCount() > 1;
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        final LinkedList<Figure> ungroupedFigures = new LinkedList<>(figures);
        final CompositeFigure group = (CompositeFigure) prototype.clone();

        grouping.groupFigures(drawingView, group, ungroupedFigures);
    }
}
