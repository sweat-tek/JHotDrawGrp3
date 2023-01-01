package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.draw.action.grouping.strategy.GroupingStrategy;
import org.jhotdraw.draw.figure.CompositeFigure;

import java.awt.event.ActionEvent;

/**
 * @author Alexander Matzen
 * @version $Id$
 */
public class GroupingAction extends AbstractSelectedAction {
    private CompositeFigure compositeFigure;
    private GroupingStrategy groupingStrategy;

    /**
     * Creates an action which acts on the selected figures on the current view
     * of the specified editor.
     *
     * @param editor The DrawingEditor which manages the views.
     */
    protected GroupingAction(DrawingEditor editor, CompositeFigure compositeFigure, GroupingStrategy groupingStrategy) {
        super(editor);
        this.compositeFigure = compositeFigure;
        this.groupingStrategy = groupingStrategy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
