/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import java.awt.Color;
import static javafx.scene.paint.Color.color;
/**
 *
 * @author Jorrit
 */
public class JavaFXPaintable implements IPaintable{
    private GraphicsContext gc;

    public JavaFXPaintable(GraphicsContext gc) {
        this.gc = gc;
    }
    
    private javafx.scene.paint.Color convertedColor(Color color){
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        double opacity = a / 255.0 ;
        return javafx.scene.paint.Color.rgb(r, g, b, opacity);
    }
    
    @Override
    public void setColor(Color color) {
    gc.setFill(convertedColor(color));
    gc.setStroke(convertedColor(color));
    }

    @Override
    public void paintOval(Oval oval) {
    setColor(oval.getColor());
    gc.fillOval(oval.getAnchor().x, oval.getAnchor().y, oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paintLine(Point from, Point to, int weight) {
    gc.setLineWidth(weight);
    gc.strokeLine(from.x, from.y, to.x, to.y);
    }

    @Override
    public void paintText(PaintedText text) {
    setColor(text.getColor());
    gc.fillText(text.getContent(), text.getAnchor().x, text.getAnchor().y);
    }

    @Override
    public void paintImage(Image image) {
    javafx.scene.image.Image img = new javafx.scene.image.Image(image.file.toURI().toString());
    setColor(image.getColor());
    gc.drawImage(img, image.getAnchor().x, image.getAnchor().y);
    
    }

    @Override
    public void clear() {
       gc.clearRect(200, 200, 200, 200);
    }
    
}
