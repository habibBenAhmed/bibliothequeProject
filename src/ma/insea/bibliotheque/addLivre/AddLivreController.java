/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.insea.bibliotheque.addLivre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import ma.insea.bibliotheque.DataBase;
import org.jdatepicker.impl.JDatePickerImpl;

/**
 *
 * @author habib
 */
public class AddLivreController {
    
    private JTextField isbn ;
    private JTextField titre ;
    private JTextField editor ;
    private JDatePickerImpl date ;
    private JTextArea description ;
    
    private JDialog addLivre;

    public AddLivreController(JDialog aDialog) {
        addLivre = aDialog;
    }

    
    public void save(ActionEvent e){
        String isbnString = isbn.getText();
        String titreString = titre.getText();
        String editorString = editor.getText();
        String dateString = date.getJFormattedTextField().getText();
        String desString = description.getText();
        new Thread(new Runnable() {

            @Override
            public void run() {
                boolean correct = true;
                if(isbnString.equals("")){
                    isbn.setBackground(Color.red);
                    correct = false;
                }
                if(titreString.equals("")){
                    titre.setBackground(Color.red);
                    correct = false;
                }
                if(editorString.equals("")){
                    editor.setBackground(Color.red);
                    correct  = false;
                }
                if(dateString.equals("")){
                    date.setBackground(Color.red);
                    correct = false;
                }
                if(desString.equals("")){
                    description.setBackground(Color.red);
                    correct = false;
                }
                if(correct){
                    try {
                        PreparedStatement ps = DataBase.connection.prepareStatement("INSERT INTO livre"
                                + " VALUES(?,?,?,?,?)");
                       ps.setString(1,isbnString);
                       ps.setString(2, titreString);
                       ps.setString(3, editorString);
                       ps.setDate(4, new Date(((java.util.Date)date.getModel().getValue()).getTime()));
                       ps.setString(5, desString);
                       ps.executeUpdate();
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                JOptionPane.showMessageDialog(addLivre,
                                        "votre livre est ajouter avec succés","Ajouter Success",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                isbn.setText("");
                                 titre.setText("");
                                 editor.setText("");
                                 date.getJFormattedTextField().setText("");
                                 description.setText("");
                            }
                        });
                    } catch (Exception ex) {
                       SwingUtilities.invokeLater(new Runnable() {

                           @Override
                           public void run() {
                               JOptionPane.showMessageDialog(addLivre, "votre livre n'a pas êté ajouter"
                                        ,"Ajouter Failed",
                                        JOptionPane.ERROR_MESSAGE
                                );
                           }
                       });
                    }
                }
            }
        }).start();
    }
    
    public void cancel(ActionEvent e){
        String isbnString = isbn.getText();
        String titreString = titre.getText();
        String editorString = editor.getText();
        String dateString = date.getJFormattedTextField().getText();
        String desString = description.getText();
        if(!isbnString.equals("") || !titreString.equals("") || !editorString.equals("") || !dateString.equals("") || !desString.equals("")){
            String options[] = {"YES","NO"};
            int choise = JOptionPane.showOptionDialog(addLivre,
                   "est ce que vous voulez quittez",
                   "confirmation de quittez",
                   JOptionPane.OK_CANCEL_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null, options, 
                   options[1]);
            if(choise == 0){
                addLivre.dispose();
            }
        }else{
            addLivre.dispose();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void setDate(JDatePickerImpl date) {
        this.date = date;
    }

    public void setDescription(JTextArea description) {
        this.description = description;
    }

    public void setEditor(JTextField editor) {
        this.editor = editor;
    }

    public void setIsbn(JTextField isbn) {
        this.isbn = isbn;
    }

    public void setTitre(JTextField titre) {
        this.titre = titre;
    }

    public JDatePickerImpl getDate() {
        return date;
    }

    public JTextArea getDescription() {
        return description;
    }

    public JTextField getEditor() {
        return editor;
    }

    public JTextField getIsbn() {
        return isbn;
    }

    public JTextField getTitre() {
        return titre;
    }
    
    
}
