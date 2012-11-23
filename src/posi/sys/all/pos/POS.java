/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


/**
 *
 * @author Aquarius
 */
public class POS extends posi.sys.expeditors.popup {
    javax.swing.JMenuItem menuitem;
    javax.swing.JMenuBar menubar;
    javax.swing.JMenu menu ;
    public POS(){
        super(new java.awt.Dimension(950,650),"Point of sale");
        
        menubar = new javax.swing.JMenuBar();
        
        menu = new javax.swing.JMenu("Actions");
        
        menuitem = new javax.swing.JMenuItem("New Sales ");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Search Item");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Print reciept");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Print invoice");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Items catalogue");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Close");        
        menu.add(menuitem);
        
        menubar.add(menu);
        
        menu = new javax.swing.JMenu("Transactions");        
        menuitem = new javax.swing.JMenuItem("Sales return");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_R, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Customers window");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_C,ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menubar.add(menu);
        
        this.setJMenuBar(menubar);
    }
    
    public static void main(String [] args){
        new POS().setVisible(true);
    }
}

