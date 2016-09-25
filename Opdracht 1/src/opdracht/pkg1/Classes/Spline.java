/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.Point;
import java.util.Arrays;
import java.awt.Color;
/**
 *
 * @author Jorrit
 */
public class Spline extends DrawingItem{
    public Point[] points;
    private int weight;
    private int degree;

    public Spline(Point anchor, Color color, Point[] points, int weight, int degree) {
        super(anchor, color);
        this.points = Arrays.copyOf(points, points.length);
        this.weight = weight;
        this.degree = degree;
        this.type = "spline";
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() { 
     return "Spline : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().y + " Points: " + Arrays.toString(points) + " Weight: " + weight + " Degrees: " + degree;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Arrays.deepHashCode(this.points);
        hash = 17 * hash + this.weight;
        hash = 17 * hash + this.degree;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Spline other = (Spline) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (this.degree != other.degree) {
            return false;
        }
        if (!Arrays.deepEquals(this.points, other.points)) {
            return false;
        }
        return true;
    }
    
     public void paint(IPaintable paintable){
     paintable.setColor(this.getColor());
         for (int i = 0; i < points.length-1;) {
                 paintable.paintLine(points[i],points[i + 1],weight);
                 i++;
         }
    
    }

    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
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
