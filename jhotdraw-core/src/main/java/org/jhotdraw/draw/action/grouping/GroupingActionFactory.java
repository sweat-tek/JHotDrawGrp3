package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.grouping.strategy.GroupStrategy;
import org.jhotdraw.draw.action.grouping.strategy.GroupingStrategy;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.GroupFigure;

public class GroupingActionFactory {
    private final DrawingEditor drawingEditor;
    private CompositeFigure compositeFigure;
    private GroupingStrategy groupingStrategy;

    private GroupingActionFactory(DrawingEditor drawingEditor) {
        this.drawingEditor = drawingEditor;
    }

    public static GroupingActionFactory initiate(DrawingEditor drawingEditor) {
        return new GroupingActionFactory(drawingEditor);
    }

    public GroupingActionFactory withCompositeFigure(CompositeFigure compositeFigure) {
        this.compositeFigure = compositeFigure;
        return this;
    }

    public GroupingActionFactory withGroupingStrategy(GroupingStrategy groupingStrategy) {
        this.groupingStrategy = groupingStrategy;
        return this;
    }

    public GroupingAction create() {
        if (compositeFigure == null) {
            compositeFigure = new GroupFigure();
        }

        if (groupingStrategy == null) {
            groupingStrategy = new GroupStrategy();
        }

        return new GroupingAction(drawingEditor, compositeFigure, groupingStrategy);
    }

}
