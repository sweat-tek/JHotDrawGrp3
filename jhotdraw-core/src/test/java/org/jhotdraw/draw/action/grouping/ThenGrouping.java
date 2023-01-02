package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.GroupFigure;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;

public class ThenGrouping extends Stage<ThenGrouping> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Collection<Figure> selection;

    public ThenGrouping the_editor_contains_the_group_containing_the_figures(Collection<Figure> figures) {
        Assertions.assertEquals(1, selection.size());

        GroupFigure group = (GroupFigure) selection.iterator().next();
        Assertions.assertEquals(figures.size(), group.getChildCount());

        figures.forEach(f -> Assertions.assertTrue(group.contains(f)));

        return self();
    }

}
