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

public class UngroupStrategy implements GroupingStrategy {
    public static final String ID = "edit.ungroupSelection";
    private final Grouping grouping = new Grouping();

    @Override
    public String getID() {
        return UngroupStrategy.ID;
    }

    @Override
    public boolean canPerformAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        return  drawingView.getSelectionCount() == 1 &&
                drawingView.getSelectedFigures().iterator().next().getClass().equals(
                    prototype.getClass()
                );
    }

    @Override
    public void performGroupingAction(DrawingView drawingView, CompositeFigure prototype, Collection<Figure> figures) {
        final CompositeFigure group = (CompositeFigure) drawingView.getSelectedFigures().iterator().next();
        final LinkedList<Figure> ungroupedFigures = new LinkedList<>();
        final GroupingUndoableEdit undoableEdit = new GroupingUndoableEdit(
            this,
            drawingView,
            prototype,
            figures
        ) {
            @Override
            public void undo() throws CannotUndoException {
                grouping.groupFigures(drawingView, group, ungroupedFigures);
                super.undo();
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                grouping.ungroupFigures(drawingView, group);
            }
        };

        ungroupedFigures.addAll(grouping.ungroupFigures(drawingView, group));
        drawingView.getDrawing().fireUndoableEditHappened(undoableEdit);
    }
}
