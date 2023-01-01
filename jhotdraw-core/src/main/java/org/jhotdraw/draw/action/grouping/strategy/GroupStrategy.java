package org.jhotdraw.draw.action.grouping.strategy;

import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.grouping.Grouping;
import org.jhotdraw.draw.action.grouping.GroupingUndoableEdit;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.Collection;
import java.util.LinkedList;

public class GroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.groupSelection";
    private final Grouping grouping = new Grouping();

    @Override
    public String getID() {
        return GroupStrategy.ID;
    }

    @Override
    public boolean canPerformAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        return drawingView.getSelectionCount() > 1;
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        final LinkedList<Figure> ungroupedFigures = new LinkedList<>(figures);
        final CompositeFigure group = (CompositeFigure) prototype.clone();
        final GroupingUndoableEdit undoableEdit = new GroupingUndoableEdit(
            this,
            drawingView,
            prototype,
            figures
        ) {
            @Override
            public void undo() throws CannotUndoException {
                grouping.ungroupFigures(drawingView, group);
                super.undo();
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                grouping.groupFigures(drawingView, group, ungroupedFigures);
            }
        };

        grouping.groupFigures(drawingView, group, ungroupedFigures);
        drawingView.getDrawing().fireUndoableEditHappened(undoableEdit);
    }
}
