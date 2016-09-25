/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.Point;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Rectangle;
/**
 *
 * @author Jorrit
 */
public class Polygon extends DrawingItem{
    public Point[] vertices;
    private int weight;

    public Polygon(Point anchor,Color color, Point[] vertices, int weight) {
        super(anchor, color);
        this.vertices = Arrays.copyOf(vertices, vertices.length);
        this.weight = weight;
        this.type = "polygon";
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() { 
     return "Polygon : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().y + " Vertices: " + Arrays.toString(vertices) + " Weigtht: " + weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.vertices);
        hash = 59 * hash + this.weight;
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
        final Polygon other = (Polygon) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (!Arrays.deepEquals(this.vertices, other.vertices)) {
            return false;
        }
        return true;
    }
    
     public void paint(IPaintable paintable){
         paintable.setColor(this.getColor());
         for (int i = 0; i < vertices.length-1;) {
                 paintable.paintLine(vertices[i],vertices[i + 1],weight);
                 i++;
         }
    }

    public Point[] getVertices() {
        return Arrays.copyOf(vertices, vertices.length);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    protected Rectangle BoundingBox() {
        int MaxX = 0;
        int MaxY = 0;
        for(Point v: this.vertices){
            if (v.x >= MaxX) {MaxX = v.x;}
            if (v.y >= MaxY) {MaxY = v.y;}
        }
        return new Rectangle(this.getAnchor().x, this.getAnchor().y,MaxX,MaxY);
    }
    
}
