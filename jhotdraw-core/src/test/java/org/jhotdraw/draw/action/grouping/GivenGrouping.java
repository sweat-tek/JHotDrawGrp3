package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.GroupFigure;

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
        this.view.setDrawing(new DefaultDrawing());
        editor.setActiveView(view);
    }

    public GivenGrouping some_ungrouped_figures(Collection<Figure> figures) {
        figures.forEach(view.getDrawing()::add);
        return self();
    }

    public GivenGrouping some_grouped_figures(Collection<Figure> figures) {
        GroupFigure group = new GroupFigure();
        figures.forEach(group::add);
        view.getDrawing().add(group);
        return self();
    }
}
