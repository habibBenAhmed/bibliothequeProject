/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.insea.bibliotheque.addLivre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ma.insea.bibliotheque.FormatDate;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author habib
 */
public class AddLivrePanel extends JDialog{

    private AddLivreController addLivreController = new AddLivreController(this);
    
    public AddLivrePanel(JFrame owner) {
       super(owner, true);
       buildPanel();
    }
    
   
    public void buildPanel(){
        JLabel isbnLabel = new JLabel("Isbn :");
        JLabel titreLabel = new JLabel("Titre :");
        JLabel editorLabel = new JLabel("Editor :");
        JLabel dateLabel = new JLabel("Date :");
        JLabel descriptionLabel = new JLabel("Description :");
        
        JTextField isbn = new JTextField();
        JTextField titre = new JTextField();
        JTextField editor = new JTextField();
        
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "asgas");
        JDatePickerImpl date = new JDatePickerImpl(
                new JDatePanelImpl(new UtilDateModel(),p),
                new FormatDate()
        );
        
        JTextArea description = new JTextArea(4, 40);
        JScrollPane jsp = new JScrollPane(description);
        
        JButton save = new JButton("save");
        JButton cancel = new JButton("cancel");
        
        addLivreController.setDate(date);
        addLivreController.setDescription(description);
        addLivreController.setEditor(editor);
        addLivreController.setIsbn(isbn);
        addLivreController.setTitre(titre);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addLivreController.save(e);
            }
        });
        
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addLivreController.cancel(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addLivreController.cancel(null);
            }

        });
        JPanel center = new JPanel(null);
        isbnLabel.setBounds(5, 5, 100, 25);
        center.add(isbnLabel);
        isbn.setBounds(110, 5,200,25);
        center.add(isbn);
        titreLabel.setBounds(5, 35, 100, 25);
        center.add(titreLabel);
        titre.setBounds(110, 35, 200, 25);
        center.add(titre);
        editorLabel.setBounds(5, 65, 100, 25);
        center.add(editorLabel);
        editor.setBounds(110, 65, 200, 25);
        center.add(editor);
        dateLabel.setBounds(5, 95, 100, 25);
        center.add(dateLabel);
        date.setBounds(110, 95, 200, 25);
        center.add(date);
        descriptionLabel.setBounds(5, 125, 100, 25);
        center.add(descriptionLabel);
        jsp.setBounds(110, 125, 200, 75);
        center.add(jsp);
        save.setBounds(180, 205, 80, 25);
        center.add(save);
        cancel.setBounds(265, 205, 80, 25);
        center.add(cancel);
        setContentPane(center);
        setSize(350,240);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
        
    }
}
