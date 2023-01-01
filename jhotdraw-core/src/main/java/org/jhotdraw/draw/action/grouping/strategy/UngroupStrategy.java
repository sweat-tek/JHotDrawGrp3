package org.jhotdraw.draw.action.grouping.strategy;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.grouping.Grouping;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public class UngroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.ungroupSelection";
    private final Grouping grouping = new Grouping();

    @Override
    public String getID() {
        return UngroupStrategy.ID;
    }

    @Override
    public boolean canPerformAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        return  drawingView.getSelectionCount() == 1 &&
                drawingView.getSelectedFigures().iterator().next().getClass().equals(
                    prototype.getClass()
                );
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        throw new NotImplementedException();
    }
}
