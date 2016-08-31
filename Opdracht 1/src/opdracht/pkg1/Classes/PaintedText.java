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
public class PaintedText extends DrawingItem{
    private String content;
    private Font font;

    public PaintedText(Point anchor, Color color, String content, Font font) {
        super(anchor, color);
        this.content = content;
        this.font = font;
        System.out.println(this.toString());
    }
    public String toString() { 
    return "Text : " + "Color: " + this.getColor() + " Anchor: " + this.getAnchor().x + "," + this.getAnchor().x + " Content: " + content + " Font: " + font;
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
}
