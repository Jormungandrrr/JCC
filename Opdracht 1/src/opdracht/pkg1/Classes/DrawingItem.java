/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.*;
import java.util.Objects;
/**
 *
 * @author Jorrit
 */
    public class DrawingItem implements Comparable<DrawingItem>{
    private Point anchor;
    private Color color;
    private DrawingItem previousState;

    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
    }
    
    public void setPreviousState(Point a, Color c)
    {
        this.previousState = new DrawingItem(this.anchor,this.color);
    }
    
    public void previousState()
    {
        if (this.previousState != null) {
            this.anchor = this.previousState.anchor;
            this.color = this.previousState.color;
        }
        
    }
    
    @Override
    public int compareTo(DrawingItem o) {
      int compare = 0;
      if ((this.anchor.x + this.anchor.y) < (o.anchor.x + o.anchor.y)) {
             compare = -1;
         }
      else if ((this.anchor.x + this.anchor.y) > (o.anchor.x + o.anchor.y)) {
             compare = 1;
         }
      else if(this.anchor.equals(o.anchor)){
             compare = 0;
         }
      return compare;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.anchor);
        return hash;
    }

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
        final DrawingItem other = (DrawingItem) obj;
        if (!Objects.equals(this.anchor, other.anchor)) {
            return false;
        }
        return true;
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
