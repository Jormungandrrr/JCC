/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.*;
/**
 *
 * @author Jorrit
 */
public class Polygon extends DrawingItem{
    Point[] vertices;
    int weight;

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
