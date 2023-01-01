package org.jhotdraw.draw.action.arrange;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;

import java.awt.event.ActionEvent;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class WhenArrange extends Stage<WhenArrange> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selection;

    public WhenArrange select_figures(Figure... figures) {
        for (Figure f : figures) {
            editor.getActiveView().addToSelection(f);
        }
        this.selection = editor.getActiveView().getSelectedFigures();
        return self();
    }

    WhenArrange send_to_back() {
        ArrangeAction action = new ArrangeAction(
                editor,
                new ArrangeSendToBackStrategy()
        );

        action.actionPerformed(mock(ActionEvent.class));

        return self();
    }

    WhenArrange bring_to_front() {
        ArrangeAction action = new ArrangeAction(
                editor,
                new ArrangeBringToFrontStrategy()
        );

        action.actionPerformed(mock(ActionEvent.class));

        return self();
    }
}
