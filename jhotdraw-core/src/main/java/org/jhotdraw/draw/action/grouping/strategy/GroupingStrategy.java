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
     * @param drawingView The DrawingView which manages the views.
     * @param figures    The Figures which should be grouped
     * @return True, if the strategy action can be performed.
     */
    boolean canPerformAction(DrawingView drawingView, Collection<Figure> figures);

    /**
     * Determines whether the strategy action can be performed.
     *
     * @return True, if the strategy action can be performed.
     */
    //boolean isEnabled();

    /**
     * Performs the grouping action corresponding to the strategy
     *
     * @param drawingView The drawing view
     * @param compositeFigure The composite figure
     * @param figures The figures to be grouped (only applicable for GroupStrategy, leave empty collection else)
     */
    void performGroupingAction(DrawingView drawingView, CompositeFigure compositeFigure, Collection<Figure> figures);
}
