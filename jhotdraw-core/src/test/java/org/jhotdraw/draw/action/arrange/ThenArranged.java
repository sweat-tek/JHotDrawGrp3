package org.jhotdraw.draw.action.arrange;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Set;

public class ThenArranged extends Stage<ThenArranged> {

    @ExpectedScenarioState
    private DefaultDrawingView view;

    @ExpectedScenarioState
    private Set<Figure> selection;

    public ThenArranged selected_figures_appear_in_back_in_order() {
        int count = this.selection.size();

        // Get $count figures from the back of the drawing
        List<Figure> figures = this.view.getDrawing().getFiguresFrontToBack();

        // Get last $count elements from the list
        List<Figure> figuresInBack = figures.subList(
                figures.size() - count,
                figures.size()
        );

        Assertions.assertArrayEquals(this.selection.toArray(), figuresInBack.toArray());

        return self();
    }

    public ThenArranged selected_figures_appear_in_front_in_order() {
        int count = this.selection.size();

        // Get $count figures from the back of the drawing
        List<Figure> figures = this.view.getDrawing().getFiguresFrontToBack();

        // Get first $count elements from the list
        List<Figure> figuresInFront = figures.subList(
                0,
                count
        );

        Assertions.assertArrayEquals(this.selection.toArray(), figuresInFront.toArray());

        return self();
    }
}
