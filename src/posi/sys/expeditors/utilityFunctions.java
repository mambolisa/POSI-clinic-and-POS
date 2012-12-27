/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors;

import java.awt.event.ActionEvent;
import posi.sys.admin.user_mng_en;
import posi.sys.all.inv.newItem;
import posi.sys.all.inv.trackItem;

/**
 *
 * @author Aquarius
 */
public class utilityFunctions {
    private  int Id;
    
    public javax.swing.JPopupMenu user_mng_popup(int userId){
        Id = userId;
        javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem menuitem;
        menuitem = new javax.swing.JMenuItem("Edit",new posi.sys.expeditors.sundry().createImageIcon("images/Write.gif", new java.awt.Dimension(23, 23)));
        menuitem.addActionListener(new action());
        menuitem.setActionCommand("editUser");
        popup.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Remove",new posi.sys.expeditors.sundry().createImageIcon("images/Trash.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("RemoveUser");
        menuitem.addActionListener(new action());
        popup.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Privileges",new posi.sys.expeditors.sundry().createImageIcon("images/Info.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("privUser");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("User reports",new posi.sys.expeditors.sundry().createImageIcon("images/Stats 3.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("userReport");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        popup.addSeparator();
        menuitem = new javax.swing.JMenuItem("New User",new posi.sys.expeditors.sundry().createImageIcon("images/Woman.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("newUser");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
     return popup;
    }
    
    public javax.swing.JPopupMenu invRowPopupMenu(int itemCode){
        Id = itemCode;
        
        javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem menuitem;
        menuitem = new javax.swing.JMenuItem("Edit",new posi.sys.expeditors.sundry().createImageIcon("images/Write.gif", new java.awt.Dimension(23, 23)));
        menuitem.addActionListener(new action());
        menuitem.setActionCommand("editSales");
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
 
    public javax.swing.JPopupMenu salesCatRowPopupMenu(int itemCode){
        Id = itemCode;
        javax.swing.JPopupMenu popup = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem menuitem;
        menuitem = new javax.swing.JMenuItem("View item",new posi.sys.expeditors.sundry().createImageIcon("images/Cube.gif", new java.awt.Dimension(23, 23)));
        menuitem.addActionListener(new action());
        menuitem.setActionCommand("edit");
        popup.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Remove item from list",new posi.sys.expeditors.sundry().createImageIcon("images/Cancel.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("RemoveFromSalesList");
        menuitem.addActionListener(new action());
        popup.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Customer item history",new posi.sys.expeditors.sundry().createImageIcon("images/Dots.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("CustHist");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        popup.addSeparator();
        menuitem = new javax.swing.JMenuItem("Leave comment on item",new posi.sys.expeditors.sundry().createImageIcon("images/Bubble 1.gif", new java.awt.Dimension(23, 23)));
        menuitem.setActionCommand("LeaveCommentOnItem");
        menuitem.addActionListener(new action());
        popup.add(menuitem);
        
        return popup;
    }
        
    class action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if("edit".equals(e.getActionCommand())){
                new newItem(Id,false).setVisible(true);
            }else if("editSales".equals(e.getActionCommand())){
                new newItem(Id,true).setVisible(true);
            }else if("newItem".equals(e.getActionCommand())){
                new newItem().setVisible(true);
            }else if("trackitem".equals(e.getActionCommand())){
                new trackItem(Id);
            }else if("LeaveCommentOnItem".equals(e.getActionCommand())){
                
            }else if("CustHist".equals(e.getActionCommand())){
            
            }else if("RemoveFromSalesList".equals(e.getActionCommand())){
                
            }else if("Remove".equals(e.getActionCommand())){
                int n = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to remove item?", "Continue with changes?",javax.swing.JOptionPane.YES_NO_OPTION);
                if( n == 0){
                      
                }else{
                   return;
                }
            }else if("editUser".equals(e.getActionCommand())){
               new user_mng_en( ""+ Id ){ }.setVisible(true);
            }else if("RemoveUser".equals(e.getActionCommand())){
                
            }else if("privUser".equals(e.getActionCommand())){
                
            }else if("userReport".equals(e.getActionCommand())){
                
            }else if("newUser".equals(e.getActionCommand())){
                new user_mng_en(  ){ }.setVisible(true);
            }
        }
        
    }
}
