package org.jhotdraw.draw.action.grouping;

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
     * @param drawingView The DrawingView which manages the views.
     * @param prototype  The CompositeFigure prototype
     * @param figures    The figures to be grouped (only applicable for GroupStrategy, leave empty collection else)
     * @return True, if the strategy action can be performed.
     */
    boolean canPerformAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures);

    /**
     * Performs the grouping action corresponding to the strategy
     *
     * @param drawingView The DrawingView which manages the views.
     * @param prototype  The CompositeFigure prototype
     * @param figures The figures to be grouped (only applicable for GroupStrategy, leave empty collection else)
     */
    void performGroupingAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures);
}
