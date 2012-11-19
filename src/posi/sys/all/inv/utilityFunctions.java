/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.event.ActionEvent;

/**
 *
 * @author Aquarius
 */
public class utilityFunctions {
    private static Object itemID;
    public static javax.swing.JPopupMenu invRowPopupMenu(Object itemCode){
        itemID = itemCode;
        javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem menuitem;
        menuitem = new javax.swing.JMenuItem("Edit",new posi.sys.expeditors.sundry().createImageIcon("images/Write.gif", new java.awt.Dimension(23, 23)));
        menuitem.addActionListener(new action());
        menuitem.setActionCommand("edit");
        popup.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Remove",new posi.sys.expeditors.sundry().createImageIcon("images/Trash.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("edit");
        menuitem.addActionListener(new action());
        popup.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Track item",new posi.sys.expeditors.sundry().createImageIcon("images/Dots up.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("trackitem");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Item reports",new posi.sys.expeditors.sundry().createImageIcon("images/Stats2.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("itemreports");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        return popup;
    }
    
    static class action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand()+" "+itemID);
        }
        
    }
}
