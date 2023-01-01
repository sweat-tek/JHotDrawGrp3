package org.jhotdraw.draw.action.grouping;

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.draw.action.grouping.strategy.GroupingStrategy;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.util.ResourceBundleUtil;

import java.awt.event.ActionEvent;

/**
 * @author Alexander Matzen
 * @version $Id$
 */
public class GroupingAction extends AbstractSelectedAction {
    private final CompositeFigure prototype;
    private final GroupingStrategy groupingStrategy;

    /**
     * Creates an action which acts on the selected figures on the current view
     * of the specified editor.
     *
     * @param editor The DrawingEditor which manages the views.
     */
    protected GroupingAction(DrawingEditor editor, CompositeFigure compositeFigure, GroupingStrategy groupingStrategy) {
        super(editor);
        this.prototype = compositeFigure;
        this.groupingStrategy = groupingStrategy;

        setLabel();
        updateEnabledState();
    }

    private void setLabel() {
        ResourceBundleUtil labels  = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, groupingStrategy.getID());
    }

    @Override
    protected void updateEnabledState() {
        try {
            setEnabled(groupingStrategy.canPerformAction(
                getView(),
                prototype,
                getView().getSelectedFigures()
            ));
        } catch (NullPointerException e) {
            // If not initialized yet, then disable the action
            setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        groupingStrategy.performGroupingAction(
            getView(),
            prototype,
            getView().getSelectedFigures()
        );

    }


}
