package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

public class GroupStrategy implements GroupingStrategy {
    @Override
    public String getID() {
        return null;
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure compositeFigure, Collection<Figure> figures) {
        throw new NotImplementedException();
    }
}
