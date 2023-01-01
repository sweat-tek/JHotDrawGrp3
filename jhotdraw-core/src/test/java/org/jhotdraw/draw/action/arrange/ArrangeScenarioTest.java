package org.jhotdraw.draw.action.arrange;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.Test;

public class ArrangeScenarioTest extends ScenarioTest<GivenFigures, WhenArrange, ThenArranged> {
    @Test
    public void send_to_back_two_selected_figures() {
        Figure figure1 = new RectangleFigure();
        Figure figure2 = new RectangleFigure();
        Figure figure3 = new RectangleFigure();

        given().some_figures_back_to_front(figure1, figure2, figure3);
        when().select_figures(figure3, figure2)
                .and().send_to_back();
        then().selected_figures_appear_in_back_in_order();
    }

    @Test
    public void send_to_front_two_selected_figures() {
        Figure figure1 = new RectangleFigure();
        Figure figure2 = new RectangleFigure();
        Figure figure3 = new RectangleFigure();

        given().some_figures_back_to_front(figure1, figure2, figure3);
        when().select_figures(figure2, figure1)
                .and().bring_to_front();
        then().selected_figures_appear_in_front_in_order();
    }
}
