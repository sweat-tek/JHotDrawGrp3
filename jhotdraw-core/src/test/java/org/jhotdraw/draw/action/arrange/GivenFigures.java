package org.jhotdraw.draw.action.arrange;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.figure.Figure;

public class GivenFigures extends Stage<GivenFigures> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState

    private DefaultDrawingView view;

    @BeforeStage
    public void before() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    public GivenFigures some_figures_back_to_front(Figure... figures) {
        for (Figure f : figures) {
            view.getDrawing().add(f);
        }
        return self();
    }

}
