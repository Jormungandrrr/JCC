/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.Point;
import java.util.Arrays;
import javafx.scene.paint.Color;
/**
 *
 * @author Jorrit
 */
public class Polygon extends DrawingItem{
    private Point[] vertices;
    private int weight;

    public Polygon(Point anchor,Color color, Point[] vertices, int weight) {
        super(anchor, color);
        this.vertices = Arrays.copyOf(vertices, vertices.length);
        this.weight = weight;
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
    
}
