/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1;
import java.awt.Color;
import java.awt.*;
import opdracht.pkg1.Classes.*;
import java.io.File;
import java.util.Collections;
/**
 *
 * @author Jorrit
 */
public class Opdracht1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Drawing draw = new Drawing();
    Point[] pointArray = {new Point(10,10),new Point(10,10),new Point(10,10),new Point(10,10)};
    
    System.out.println("Symbolen worden getekend:");
    draw.drawitems.add(new Oval(new Point(10,10),Color.RED,10,10));
    draw.drawitems.add(new PaintedText(new Point(10,10),Color.GREEN,"Dit is de content. ",Font.getFont(Font.SANS_SERIF)));
    draw.drawitems.add(new opdracht.pkg1.Classes.Polygon(new Point(5,5),Color.CYAN,pointArray,10));
    draw.drawitems.add(new Spline(new Point(10,10),Color.orange,pointArray,10,10));
    draw.drawitems.add(new opdracht.pkg1.Classes.Image(new Point(1,1),Color.MAGENTA,new File("image.jpg"),10.10));
    System.out.println("\n");
    System.out.println("Lijst met getekende symbolen:");
    Collections.sort(draw.drawitems);
    for(DrawingItem a: draw.drawitems)//printing the sorted list of names
         System.out.println(a.toString());
    }
    
}
