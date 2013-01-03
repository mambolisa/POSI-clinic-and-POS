/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import posi.sys.all.expeditors.database.db_connect;

/**
 *
 * @author Aquarius
 */
public class helper_utilites {
    private static db_connect db = new db_connect();
    
    public helper_utilites(){
        
    }
    
    private static Object[] items(){
        String sql = "SELECT item_category_name FROM items_categories";
        
    return db.getColData(sql);
    }
    
    public static javax.swing.JComponent default_(){
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setBackground(java.awt.Color.white);
        
        javax.swing.JLabel label = new javax.swing.JLabel("Filter: ", javax.swing.SwingConstants.LEFT);
        javax.swing.JComboBox combo = new javax.swing.JComboBox( items() );
        combo.setPreferredSize(new java.awt.Dimension(150, 30));
        
        panel.add(label);
        panel.add(combo);
        
    return panel;
    }
}
