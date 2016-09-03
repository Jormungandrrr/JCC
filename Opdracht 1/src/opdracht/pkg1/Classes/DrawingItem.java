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
public abstract class DrawingItem implements Comparable<DrawingItem>{
    private Point anchor;
    private Color color;
    private DrawingItem previousState;

    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
    }
    
    public void setPreviousState(){
    this.previousState = new DrawingItem(this.anchor,this.color) {};
    }
    
    public void previousState()
    {
        this.anchor = this.previousState.anchor;
        this.color = this.previousState.color;
    }
    
    @Override
    public int compareTo(DrawingItem o) {
      if ((this.anchor.x + this.anchor.y) < (o.anchor.x + o.anchor.y)) {
             return -1;
         }
         else if ((this.anchor.x + this.anchor.y) > (o.anchor.x + o.anchor.y)) {
             return 1;
         }
         else if((this.anchor.x + this.anchor.y) == (o.anchor.x + o.anchor.y)) {
             return 0;
         }
         else return 0;   
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
