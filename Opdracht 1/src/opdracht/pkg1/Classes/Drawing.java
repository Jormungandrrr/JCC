/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.util.*;

/**
 *
 * @author Jorrit
 */
public class Drawing implements java.io.Serializable {
    private String name;
    private int width;
    private int height;
    public List<DrawingItem> drawitems = new ArrayList<>();

    public Drawing(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }
    public Drawing() {
    }
    
    //Get setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint(JavaFXPaintable paintable) {
    }
}