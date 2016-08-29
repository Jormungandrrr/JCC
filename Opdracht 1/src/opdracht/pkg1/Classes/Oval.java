/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Jorrit
 */
public class Oval extends DrawingItem {
    double width;
    double height;

    public Oval(Point anchor, Color color) {
        super(anchor, color);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
