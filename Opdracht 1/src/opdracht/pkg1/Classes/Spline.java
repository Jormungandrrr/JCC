/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.*;
import java.util.Arrays;
/**
 *
 * @author Jorrit
 */
public class Spline extends DrawingItem{
    private Point[] points;
    private int weight;
    private int degree;

    public Spline(Point anchor, Color color, Point[] points, int weight, int degree) {
        super(anchor, color);
        this.points = points;
        this.weight = weight;
        this.degree = degree;
        System.out.println(this.toString());
    }
    
    public String toString() { 
     return "Spline : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().x + " Points: " + Arrays.toString(points) + " Weight: " + weight + " Degrees: " + degree;
    }

    public Point[] getPoints() {
        return points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
