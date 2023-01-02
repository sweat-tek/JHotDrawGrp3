package org.jhotdraw.draw.action.text.unit;

import org.jhotdraw.draw.figure.TextFigure;
import org.junit.Assert;
import org.junit.Test;

//import java.awt.geom.AffineTransform;
//import java.awt.geom.Point2D;

public class TextToolFunctionalityTests {

    /*
    @Test
    public void testSetCoordinates() {
        TextFigure figure = new TextFigure();
        Point2D.Double[] coordinates = new Point2D.Double[]{
                new Point2D.Double(1, 2),
                new Point2D.Double(3, 4)};
        figure.setCoordinates(coordinates);

        System.out.println("Specified coordinates: x: " + coordinates[0].getX() + ", y: " + coordinates[0].getY());
        System.out.println("Expected coordinates: " +
                "x: " + figure.getCoordinates()[0].getX() + ", " +
                "y: " + figure.getCoordinates()[0].getY());

        Assert.assertArrayEquals(figure.getCoordinates(), coordinates);
    }

     */

    @Test
    public void testConstructor() {
        TextFigure figure = new TextFigure();
        Assert.assertNotNull(figure);
        Assert.assertEquals("Text", figure.getText());
        Assert.assertTrue(figure.isEditable());
    }

    @Test
    public void testConstructorWithText() {
        TextFigure figure = new TextFigure("Hello");
        Assert.assertNotNull(figure);
        Assert.assertEquals("Hello", figure.getText());
        Assert.assertTrue(figure.isEditable());
    }

    /*
    @Test
    public void testSetRotates() {
        TextFigure figure = new TextFigure();
        double[] rotates = new double[]{45, 90};
        figure.setRotates(rotates);

        System.out.println("Specified rotates: " + rotates[0] + ", " + rotates[1]);
        System.out.println("Expected rotates: " + figure.getRotates()[0] + ", " + figure.getRotates()[1]);

        Assert.assertArrayEquals(figure.getRotates(), rotates, 0.0);
    }

     */

    @Test
    public void testIsEditable() {
        TextFigure figure = new TextFigure();
        Assert.assertTrue(figure.isEditable());
    }

    @Test
    public void testTextInFigure() {
        TextFigure figure = new TextFigure();
        String text = "Hello World";
        figure.setText(text);
        Assert.assertEquals(text, figure.getText());
    }

    /*
    @Test
    public void testTransform() {
        TextFigure figure = new TextFigure();
        AffineTransform transform = new AffineTransform(1, 0, 0, 1, 0, 0);
        Point2D.Double[] coordinates = new Point2D.Double[]{
                new Point2D.Double(1, 2),
                new Point2D.Double(3, 4)};

        figure.setCoordinates(coordinates);
        figure.transform(transform);

        System.out.println("Specified coordinates: x: " + coordinates[0].getX() + ", y: " + coordinates[0].getY());
        System.out.println("Expected coordinates: " +
                "x: " + figure.getCoordinates()[0].getX() + ", " +
                "y: " + figure.getCoordinates()[0].getY());

        Assert.assertArrayEquals(figure.getCoordinates(), coordinates);
    }

     */
}


