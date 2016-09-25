/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

/**
 *
 * @author Jorrit
 */
public class SerializationMediator implements PersistencyMediator {

    Properties props;
    
    @Override
    public Drawing Load(String nameDrawing) {
       Drawing d = null;
       try {
         FileInputStream fileIn = new FileInputStream("drawing.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         d = (Drawing) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException c) {
         System.out.println("Drawing not found");
         c.printStackTrace();
         return null;
      }
        System.out.println("Drawing loaded");
       return d;
    }
    @Override
    public boolean Save(Drawing drawing) {
         try {
         FileOutputStream fileOut =
         new FileOutputStream("drawing.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(drawing);
         out.close();
         fileOut.close();
         }
         catch(IOException i) {
            i.printStackTrace();
         return false;
      }
         return true;
    }

    @Override
    public boolean Init(Properties props) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //https://www.tutorialspoint.com/java/java_serialization.htm
}
