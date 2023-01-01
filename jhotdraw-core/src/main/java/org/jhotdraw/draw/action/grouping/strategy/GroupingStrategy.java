package org.jhotdraw.draw.action.grouping.strategy;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

/**
 * Grouping Strategy Contract
 *
 * @author Alexander Matzen
 */
public interface GroupingStrategy {
    /**
     * Returns the Strategy ID used for Swing ActionMap
     *
     * @return Strategy ID
     */
    String getID();

    /**
     * Performs the grouping action corresponding to the strategy
     *
     * @param drawingView The drawing view
     * @param compositeFigure The composite figure
     * @param figures The figures to be grouped (only applicable for GroupStrategy, leave empty collection else)
     */
    void performGroupingAction(DrawingView drawingView, CompositeFigure compositeFigure, Collection<Figure> figures);
}
