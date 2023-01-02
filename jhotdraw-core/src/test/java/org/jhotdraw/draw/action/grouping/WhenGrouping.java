package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;

import java.awt.event.ActionEvent;
import java.util.Collection;

import static org.mockito.Mockito.mock;

public class WhenGrouping extends Stage<WhenGrouping> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Collection<Figure> selection;

    public WhenGrouping the_user_selects_the_figures(Collection<Figure> figures) {
        figures.forEach(editor.getActiveView()::addToSelection);
        this.selection = editor.getActiveView().getSelectedFigures();
        return self();
    }

    public WhenGrouping the_user_groups_the_figures() {
        GroupingAction action = GroupingActionFactory.initiate(editor)
            .withGroupingStrategy(new GroupStrategy())
            .withCompositeFigure(new GroupFigure())
            .create();

        action.actionPerformed(mock(ActionEvent.class));

        return self();
    }

    public WhenGrouping the_user_ungroups_the_figures() {
        GroupingAction action = GroupingActionFactory.initiate(editor)
            .withGroupingStrategy(new UngroupStrategy())
            .withCompositeFigure(new GroupFigure())
            .create();

        action.actionPerformed(mock(ActionEvent.class));

        return self();
    }
}
