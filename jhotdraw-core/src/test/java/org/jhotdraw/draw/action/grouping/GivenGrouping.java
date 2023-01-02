package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;

import java.util.Collection;

public class GivenGrouping extends Stage<GivenGrouping> {

    @ProvidedScenarioState
    private DrawingEditor editor;
    @ProvidedScenarioState
    private DrawingView view;

    @BeforeStage
    public void before() {
        this.editor = new DefaultDrawingEditor();
        this.view = new DefaultDrawingView();
        editor.setActiveView(view);
    }

    public GivenGrouping some_ungrouped_figures(Collection<Figure> figures) {
        figures.forEach(view.getDrawing()::add);
        return self();
    }
}
