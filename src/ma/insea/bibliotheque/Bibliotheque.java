/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.insea.bibliotheque;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import ma.insea.bibliotheque.addLivre.AddLivreController;
import ma.insea.bibliotheque.frame.Frame;

/**
 *
 * @author habib
 */
public class Bibliotheque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         SwingUtilities.invokeLater(new Runnable() {

             @Override
             public void run() {
                 new Frame();
             }
         });
         
    }
    
}
