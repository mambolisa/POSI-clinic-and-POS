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
        menuitem.setActionCommand("Remove");
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
        
        popup.addSeparator();
        menuitem = new javax.swing.JMenuItem("New Item",new posi.sys.expeditors.sundry().createImageIcon("images/Document New.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("newItem");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        return popup;
    }
    
    static class action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand()+" "+itemID);
            if("edit".equals(e.getActionCommand())){
                new newItem((Integer)itemID).setVisible(true);
            }else if("newItem".equals(e.getActionCommand())){
                new newItem().setVisible(true);
            }else if("trackitem".equals(e.getActionCommand())){
                new trackItem(Integer.parseInt(itemID.toString())).setVisible(true);
            }else if("Remove".equals(e.getActionCommand())){
                int n = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to remove item?", "Continue with changes?",javax.swing.JOptionPane.YES_NO_OPTION);
                if( n == 0){
                      
                }else{
                   return;
                }
            } 
        }
        
    }
}
