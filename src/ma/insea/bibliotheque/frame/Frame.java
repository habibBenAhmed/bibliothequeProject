/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.insea.bibliotheque.frame;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import ma.insea.bibliotheque.addLivre.AddLivrePanel;

/**
 *
 * @author habib
 */
public class Frame extends JFrame{

    private FrameController frameController = new FrameController();
    
    public Frame() throws HeadlessException {
        setTitle("Bibliotheque");
        buildFrame();
    }
    
    public void buildFrame(){
        addWindowListener(new WindowAdapter() {

             @Override
             public void windowOpened(WindowEvent e) {
                frameController.open();
             }

             @Override
             public void windowClosing(WindowEvent e) {
                frameController.close();
             }

         });
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null); 
        AddLivrePanel addLivrePanel = new AddLivrePanel(this);
    }
}
