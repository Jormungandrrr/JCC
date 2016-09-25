/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorrit
 */
public class DatabaseMediator implements PersistencyMediator{

    Properties props;
    Connection conn;

    public DatabaseMediator() {
        initConnection();
    }
    
    
    
    @Override
    public Drawing Load(String nameDrawing) {
        try {
            Drawing d = new Drawing();
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM drawing WHERE Name = " + "'" + nameDrawing+ "'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                d.setName(rs.getString("Name"));
                d.setHeight(rs.getInt("Height"));
                d.setWidth(rs.getInt("Width"));                
            }
            GetDrawingItems(d);
             return d;
           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }  
    }

    @Override
    public boolean Save(Drawing drawing) {
        try {
            String statement = "INSERT INTO Drawing (Name, Width, Height) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(statement);
             pstmt.setString(1, drawing.getName());
             pstmt.setInt(2, drawing.getWidth());
             pstmt.setInt(3, drawing.getHeight());
             pstmt.executeUpdate();

             statement = "INSERT INTO Item (Type, Anchorx, Anchory, Color, DrawingName, File, Size, Width, Height, font, Weight, Text, Degree) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
             pstmt = conn.prepareStatement(statement);             
             
             for(DrawingItem i: drawing.drawitems)
             {
                pstmt.setString(1, i.type);
                pstmt.setInt(2, i.getAnchor().x);
                pstmt.setInt(3, i.getAnchor().y);
                pstmt.setString(4, Integer.toString(i.getColor().getRGB()));
                pstmt.setString(5, drawing.getName());
                pstmt.setString(6, null);
                pstmt.setString(7, null);
                pstmt.setString(8, null);
                pstmt.setString(9, null);
                pstmt.setString(10, null);
                pstmt.setString(11, null);
                pstmt.setString(12, null);
                pstmt.setString(13, null);
                 
                switch(i.type) {
                case "polygon" :
                Polygon p = (Polygon) i;
                pstmt.setDouble(11, p.getWeight());
                pstmt.executeUpdate();
                setVertices(p,drawing.getName());
                break;
                
                case "spline" :
                Spline s = (Spline) i;
                pstmt.setDouble(11, s.getWeight());
                pstmt.setDouble(13, s.getDegree());
                pstmt.executeUpdate();
                setPoints(s,drawing.getName());
                break;
                
                case "oval" :
                Oval o = (Oval) i;
                pstmt.setDouble(8, o.getHeight());
                pstmt.setDouble(9, o.getWidth());
                pstmt.executeUpdate();
                break;
                
                case "text" :
                PaintedText pt = (PaintedText) i;
                pstmt.setString(12, pt.getContent());
                pstmt.setString(10, pt.getFont().getFontName());
                pstmt.executeUpdate();
                break;
                
                case "image" :
                Image im = (Image) i;
                pstmt.setString(6, im.getFile().toString());
                pstmt.setDouble(7, im.getSize());
                pstmt.executeUpdate();
                break;
                default :
                System.out.println("Error");
      }                      
             }
             conn.close();
             System.out.println("Drawing saved to database");
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private void setVertices(Polygon p, String DrawingName)
    {
        try {
            int ItemID = 0;
            Statement st = conn.createStatement();
            String sql = "SELECT ID FROM item WHERE Type = 'polygon' AND DrawingName = '"+ DrawingName +"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {ItemID = rs.getInt("ID");}
            
            for(Point point: p.vertices){
                String statement = "INSERT INTO points (Pointx, Pointy, ItemID) VALUES (?, ?, ?)";
                PreparedStatement stat = conn.prepareStatement(statement);
                stat.setDouble(1, point.x);
                stat.setDouble(2, point.y);
                stat.setInt(3, ItemID);
                stat.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setPoints(Spline s, String DrawingName)
    {
        try {
            int ItemID = 0;
            Statement st = conn.createStatement();
            String sql = "SELECT ID FROM item WHERE Type = 'spline' AND DrawingName = '"+ DrawingName +"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {ItemID = rs.getInt("ID");}
            
            for(Point point: s.points){
                String statement = "INSERT INTO points (Pointx, Pointy, ItemID) VALUES (?, ?, ?)";
                PreparedStatement stat = conn.prepareStatement(statement);
                stat.setDouble(1, point.x);
                stat.setDouble(2, point.y);
                stat.setInt(3, ItemID);
                stat.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<Point> getPoints(String type, String DrawingName)
    {
        List<Point> points = new ArrayList<>();
        int itemID = 0;
        try {
        Statement st = conn.createStatement();
        String sql = "SELECT ID FROM item WHERE Type = '"+  type +"' AND DrawingName = '"+ DrawingName +"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) {itemID = rs.getInt("ID");}

            sql = "SELECT * FROM points WHERE ItemID = '"+ itemID +"'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
            points.add(new Point(rs.getInt("Pointx"),rs.getInt("Pointy")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return points;
    }
    
    private void GetDrawingItems(Drawing d){
        try {
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM item WHERE DrawingName = " + "'" + d.getName()+ "'");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Point anchor = new Point(rs.getInt("anchorx"),rs.getInt("anchory"));
                
            switch(rs.getString("Type")) {
                case "polygon" :
                List<Point> verticeslist = getPoints("polygon",d.getName());
                Point[] Vertices = verticeslist.toArray(new Point[verticeslist.size()]);
                d.drawitems.add(new Polygon(anchor,new Color(Integer.parseInt(rs.getString("Color"))),Vertices,rs.getInt("Weight")));
                break;
                case "spline" :
                List<Point> pointlist = getPoints("spline",d.getName());
                Point[] points = pointlist.toArray(new Point[pointlist.size()]);
                d.drawitems.add(new Spline(anchor,new Color(Integer.parseInt(rs.getString("Color"))),points,rs.getInt("Weight"),rs.getInt("Degree")));
                break;
                case "oval" :
                d.drawitems.add(new Oval(anchor,new Color(Integer.parseInt(rs.getString("Color"))),rs.getInt("Height"),rs.getInt("Width")));
                break;
                case "text" :
                d.drawitems.add(new PaintedText(anchor,new Color(Integer.parseInt(rs.getString("Color"))),rs.getString("Text"),new Font(rs.getString("Font"), Font.ITALIC, 24)));
                break;
                case "image" :
                d.drawitems.add(new Image(anchor,new Color(Integer.parseInt(rs.getString("Color"))),new File(rs.getString("File")),rs.getDouble("Size")));
                break;
                default :
                System.out.println("Error");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public boolean Init(Properties props) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void initConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local:3306/dbi346355","dbi346355","jorrit");
            System.out.println("Connection ok.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    }
    
}
