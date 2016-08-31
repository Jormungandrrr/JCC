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
public class Polygon extends DrawingItem{
    private Point[] vertices;
    private int weight;

    public Polygon(Point anchor, Color color, Point[] vertices, int weight) {
        super(anchor, color);
        this.vertices = vertices;
        this.weight = weight;
        System.out.println(this.toString());
    }
    
    public String toString() { 
     return "Polygon : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().x + " Vertices: " + Arrays.toString(vertices) + " Weigtht: " + weight;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
