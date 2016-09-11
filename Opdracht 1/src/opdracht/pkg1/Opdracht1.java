/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1;
import java.awt.Point;
import opdracht.pkg1.Classes.*;
import java.io.File;
import java.util.Collections;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author Jorrit
 */
public class Opdracht1 extends Application {

    /**
     * @param args the command line arguments
     */
    private Canvas canvas =  new Canvas(300, 250);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private  Drawing drawing = new Drawing();
    private JavaFXPaintable paintable = new JavaFXPaintable(gc);
    
    public static void main(String[] args) {
        launch(args);
    }
    
        
    public void draw(GraphicsContext gc){
    Point[] lineArray = {new Point(20,10),new Point(20,30),new Point(80,20),new Point(30,60)};
    Point[] triArray = {new Point(150,300),new Point(200,100),new Point(100,200),new Point(200,300)};
    System.out.println("Symbolen worden aangemaakt:");
    drawing.drawitems.add(new Oval(new Point(10,100),Color.RED,10,10));
    drawing.drawitems.add(new PaintedText(new Point(100,10),Color.GREEN,"Dit is de content. ",Font.font(STYLESHEET_CASPIAN)));
    drawing.drawitems.add(new opdracht.pkg1.Classes.Polygon(new Point(5,5),Color.CYAN,triArray,10));
    drawing.drawitems.add(new Spline(new Point(30,1),Color.YELLOW,lineArray,10,10));
    drawing.drawitems.add(new opdracht.pkg1.Classes.Image(new Point(220,50),Color.MAGENTA,new File("C:\\dickbutt.png"),10.10));
    Collections.sort(drawing.drawitems);
    for(DrawingItem a: drawing.drawitems)
        a.paint(paintable);   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Drawing");
        Group root = new Group();
        draw(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
