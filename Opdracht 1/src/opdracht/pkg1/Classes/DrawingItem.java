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
public class DrawingItem {
    Point anchor;
    Color color;
    DrawingItem previousState;

    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
    }
    
    public void setPreviousState(){
    this.previousState = new DrawingItem(this.anchor,this.color);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Get Set ">
    public DrawingItem getPreviousState() {
        return previousState;
    }
    
    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point Anchor) {
        this.anchor = Anchor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    // </editor-fold>
}
