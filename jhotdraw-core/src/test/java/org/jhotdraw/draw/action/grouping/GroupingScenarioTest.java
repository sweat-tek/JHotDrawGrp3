package org.jhotdraw.draw.action.grouping;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.jhotdraw.draw.figure.RoundRectangleFigure;
import org.jhotdraw.draw.figure.TextFigure;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class GroupingScenarioTest extends ScenarioTest<GivenGrouping, WhenGrouping, ThenGrouping> {

    @Test
    public void group_figures() {
        Collection<Figure> figures = List.of(new RectangleFigure(), new TextFigure(), new RoundRectangleFigure());

        given().some_ungrouped_figures(figures);
        when().the_user_selects_the_figures(figures)
                .and().the_user_groups_the_figures();
        then().the_editor_contains_the_group_containing_the_figures(figures);
    }

    @Test
    public void ungroup_figures() {
        Collection<Figure> figures = List.of(new RectangleFigure(), new RectangleFigure(), new TextFigure(), new RoundRectangleFigure());

        given().some_grouped_figures(figures);
        when().the_user_selects_the_group()
                .and().the_user_ungroups_the_figures();
        then().the_editor_contains_the_ungrouped_figures(figures);
    }

}
