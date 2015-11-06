/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.insea.bibliotheque.frame;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ma.insea.bibliotheque.DataBase;

/**
 *
 * @author habib
 */
public class FrameController {

    public FrameController() {
    }

    public void open(){
        try {
            DataBase.connection();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "error lors de connection a la base de donne veillez verifier",
                    "connection failed to base de donné",JOptionPane.ERROR_MESSAGE);        
        }
    }   
    
    public void close(){
        try {
            DataBase.disconnection();
        } catch (SQLException ex) {
        }
    }
}
