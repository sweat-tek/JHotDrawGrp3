package org.jhotdraw.draw.action.arrange;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public interface ArrangeStrategy {

    String getId();
    void arrangeFigures(DrawingView view, Collection<Figure> figures);
    void unarrangeFigures(DrawingView view, Collection<Figure> figures);

}
