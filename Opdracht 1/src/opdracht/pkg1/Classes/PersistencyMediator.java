/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg1.Classes;

import java.util.Properties;

/**
 *
 * @author Jorrit
 */
public interface PersistencyMediator {
    public Drawing Load(String nameDrawing);
    public boolean Save(Drawing drawing);
    public boolean Init(Properties props);
}
