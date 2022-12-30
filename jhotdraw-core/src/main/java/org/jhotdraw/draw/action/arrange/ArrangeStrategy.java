package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public interface ArrangeStrategy {

    String getId();
    void performMove(DrawingView view, Collection<Figure> figures);
    void revertMove(DrawingView view, Collection<Figure> figures);

}
