package org.jhotdraw.draw.action.grouping.strategy;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public class GroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.groupSelection";

    @Override
    public String getID() {
        return GroupStrategy.ID;
    }

    @Override
    public boolean canPerformAction(DrawingView drawingView, Collection<Figure> figures) {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure compositeFigure, Collection<Figure> figures) {
        throw new NotImplementedException();
    }
}
