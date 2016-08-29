/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;
import java.awt.Color;
import java.awt.Point;
import java.io.*;
/**
 *
 * @author Jorrit
 */
public class Image extends DrawingItem {
    File file;
    double size;

    public Image(Point anchor, Color color) {
        super(anchor, color);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}