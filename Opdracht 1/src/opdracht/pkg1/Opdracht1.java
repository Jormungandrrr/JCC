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
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import java.awt.Color;
import java.awt.Font;
import javafx.stage.Stage;
/**
 *
 * @author Jorrit
 */
public class Opdracht1 extends Application {

    /**
     * @param args the command line arguments
     */
    private Drawing drawing = new Drawing("TestDrawing",300, 250);
    private final Canvas canvas =  new Canvas(drawing.getWidth(), drawing.getHeight());
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final JavaFXPaintable paintable = new JavaFXPaintable(gc);
    private final SerializationMediator ser = new SerializationMediator();
    private final DatabaseMediator dbm = new DatabaseMediator();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void itemsToDraw(){
    Point[] lineArray = {new Point(20,10),new Point(20,30),new Point(80,20),new Point(30,60)};
    Point[] triArray = {new Point(150,300),new Point(200,100),new Point(100,200),new Point(200,300)};
    System.out.println("Symbolen worden aangemaakt:");
    drawing.drawitems.add(new Oval(new Point(10,100),Color.RED,10,10));
    drawing.drawitems.add(new PaintedText(new Point(100,10),Color.GREEN,"Dit is de content. ",new Font("Serif", Font.ITALIC, 24)));
    drawing.drawitems.add(new opdracht.pkg1.Classes.Polygon(new Point(5,5),Color.CYAN,triArray,10));
    drawing.drawitems.add(new Spline(new Point(30,1),Color.YELLOW,lineArray,10,10));
    drawing.drawitems.add(new opdracht.pkg1.Classes.Image(new Point(220,50),Color.MAGENTA,new File("C:\\dickbutt.png"),10.10));
    Collections.sort(drawing.drawitems);
    }
    
        
    public void draw(GraphicsContext gc){
    //itemsToDraw();
    //drawing = dbm.Load("TestDrawing");
    //drawing = ser.Load("testDrawing");
    System.out.println(drawing.getName() + " " + drawing.getWidth() + " " + drawing.getHeight());
    for(DrawingItem a: drawing.drawitems)
        a.paint(paintable);   
    
    //Serialize();
    //dbm.Save(drawing);
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
    
        private void Serialize(){
          if (ser.Save(drawing))
          {
              System.out.println("Serialization succeeded");
          }
          drawing = ser.Load("D0");
    }
}
