package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class ArrangeBringToFrontStrategy implements ArrangeStrategy {

    public static final String ID = "edit.bringToFront";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void performMove(DrawingView view, Collection<Figure> figures) {
        Drawing drawing = view.getDrawing();
        drawing.sort(figures).forEach(drawing::bringToFront);
    }

    @Override
    public void revertMove(DrawingView view, Collection<Figure> figures) {
        figures.forEach(view.getDrawing()::sendToBack);
    }

}
