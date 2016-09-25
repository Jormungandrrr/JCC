/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.Point;
import java.util.Objects;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javafx.scene.text.Text;
/**
 *
 * @author Jorrit
 */
public class PaintedText extends DrawingItem{
    private String content;
    private Font font;

    public PaintedText(Point anchor, Color color, String content, Font font) {
        super(anchor, color);
        this.content = content;
        this.font = font;
        this.type = "text";
        System.out.println(this.toString());
    }
    @Override
    public String toString() { 
    return "Text : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().y + " Content: " + content + " Font: " + font;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.content);
        hash = 17 * hash + Objects.hashCode(this.font);
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
        final PaintedText other = (PaintedText) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.font, other.font)) {
            return false;
        }
        return true;
    }
    
     public void paint(IPaintable paintable){
     paintable.paintText(this);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    protected Rectangle BoundingBox() {
        Text text = new Text(content);
        int width = (int) text.getLayoutBounds().getWidth();
        int height = (int) text.getLayoutBounds().getHeight();
        return new Rectangle(this.getAnchor().x, this.getAnchor().y,width,height);
    }
}
