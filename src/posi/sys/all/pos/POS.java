/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;


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
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Search Item");
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Print reciept");
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Print invoice");
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Items catalogue");
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Close");        
        menu.add(menuitem);
        
        menubar.add(menu);
        
        menu = new javax.swing.JMenu("Transactions");        
        menuitem = new javax.swing.JMenuItem("Sales return");
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Customers window");
        menu.add(menuitem);
        menubar.add(menu);
        
        this.setJMenuBar(menubar);
    }
    
    public static void main(String [] args){
        new POS().setVisible(true);
    }
}

