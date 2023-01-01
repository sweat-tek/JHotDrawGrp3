package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.GroupFigure;

import java.util.Objects;

public class GroupingActionFactory {
    private final DrawingEditor drawingEditor;
    private CompositeFigure compositeFigure = null;
    private GroupingStrategy groupingStrategy = null;

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
        if (Objects.isNull(compositeFigure)) {
            System.out.println("[INFO] GroupingActionFactory: compositeFigure is null, defaulting to GroupFigure");
            compositeFigure = new GroupFigure();
        }

        if (Objects.isNull(groupingStrategy)) {
            System.out.println("[INFO] GroupingActionFactory: is null, defaulting to GroupStrategy");
            groupingStrategy = new GroupStrategy();
        }

        return new GroupingAction(drawingEditor, compositeFigure, groupingStrategy);
    }

}
