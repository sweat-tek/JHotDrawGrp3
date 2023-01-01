package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class ArrangeSendToBackStrategy implements ArrangeStrategy {

    public static final String ID = "edit.sendToBack";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void arrangeFigures(DrawingView view, Collection<Figure> figures) {
        figures.forEach(view.getDrawing()::sendToBack);
    }

    @Override
    public void unarrangeFigures(DrawingView view, Collection<Figure> figures) {
        figures.forEach(view.getDrawing()::bringToFront);
    }
}
