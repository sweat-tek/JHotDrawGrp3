package org.jhotdraw.draw.action.grouping.strategy;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;
import java.util.LinkedList;

public class GroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.groupSelection";

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

        groupFigures(drawingView, group, ungroupedFigures);
    }


    @FeatureEntryPoint(value = "Group figures")
    public void groupFigures(DrawingView view, CompositeFigure group, Collection<Figure> figures) {
        Collection<Figure> sorted = view.getDrawing().sort(figures);
        int index = view.getDrawing().indexOf(sorted.iterator().next());
        view.getDrawing().basicRemoveAll(figures);
        view.clearSelection();
        view.getDrawing().add(index, group);
        group.willChange();
        for (Figure f : sorted) {
            f.willChange();
            group.basicAdd(f);
        }
        group.changed();
        view.addToSelection(group);
    }
}
