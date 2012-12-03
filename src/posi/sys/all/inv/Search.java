/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author Aquarius
 */
public class Search extends posi.sys.expeditors.popup {
    private posi.sys.all.inv.tableReports allItems;
    private javax.swing.JPanel panel; 
    private javax.swing.JTextField textfield;
    private javax.swing.JButton button;
    
    public Search(){
       super(new java.awt.Dimension(850,550),"Search");
       
       panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
       
       textfield = new javax.swing.JTextField(30); 
       textfield.addActionListener(new Action());
       textfield.setActionCommand("Search");
       textfield.setPreferredSize(new java.awt.Dimension(300, 30));
       panel.add(textfield);
       
       button = new javax.swing.JButton("Search");
       button.addActionListener(new Action());
       button.setActionCommand("Search");
       button.setPreferredSize(new java.awt.Dimension(100, 35));
       panel.add(button);
       
       this.add(panel,BorderLayout.PAGE_START);
       
       allItems = new posi.sys.all.inv.tableReports();
       
       this.add(allItems.InvAll(),BorderLayout.CENTER);
    }
    
    public static void main(String [] args){
        new Search().setVisible(true);
    }
}

class Action implements java.awt.event.ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    }