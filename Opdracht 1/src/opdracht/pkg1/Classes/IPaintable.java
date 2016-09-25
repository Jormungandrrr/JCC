/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.awt.Point;
import java.awt.Color;

/**
 *
 * @author Jorrit
 */
public interface IPaintable {
    public void setColor(Color color);
    public void paintOval(Oval oval);
    public void paintLine(Point from,Point to,int weight);
    public void paintText(PaintedText text);
    public void paintImage(Image image);
    public void clear();
    
}
