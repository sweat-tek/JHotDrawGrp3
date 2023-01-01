package org.jhotdraw.draw.action.grouping.strategy;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public class UngroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.ungroupSelection";

    @Override
    public String getID() {
        return UngroupStrategy.ID;
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure compositeFigure, Collection<Figure> figures) {
        throw new NotImplementedException();
    }
}
