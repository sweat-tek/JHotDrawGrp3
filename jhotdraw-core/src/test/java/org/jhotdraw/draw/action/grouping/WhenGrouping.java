package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class WhenGrouping extends Stage<WhenGrouping> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    public WhenGrouping the_user_selects_the_figures(Collection<Figure> figures) {
        figures.forEach(editor.getActiveView()::addToSelection);
        return self();
    }

}
