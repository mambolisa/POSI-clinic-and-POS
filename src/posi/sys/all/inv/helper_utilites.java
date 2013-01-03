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
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.setBackground(java.awt.Color.white);
        panel.setPreferredSize(new java.awt.Dimension(200, 225));
        
        javax.swing.JLabel label_c = new javax.swing.JLabel("Filter category: ", javax.swing.SwingConstants.LEFT);
        label_c.setPreferredSize(new java.awt.Dimension(200, 25));
        
        javax.swing.JComboBox combo = new javax.swing.JComboBox( items() );
        combo.setPreferredSize(new java.awt.Dimension(150, 25));
        
        panel.add( label_c );
        panel.add( combo );
        
        javax.swing.JLabel label_d = new javax.swing.JLabel("Filter date: ", javax.swing.SwingConstants.LEFT);
        label_d.setPreferredSize(new java.awt.Dimension(200, 25));
        
        javax.swing.JTextField text = new javax.swing.JTextField(  );
        text.setPreferredSize(new java.awt.Dimension(150, 25));
        
        panel.add(label_d);
        panel.add(text);
        
    return panel;
    }
    /*
     * I suggest that you do this
to remove:
jpanel.remove(component); //remove component from your jpanel in this case i used jpanel
jpanel.revalidate();
jframe.repaint();//repaint a JFrame jframe in this case

to add:
jpanel.add(component); //add component to jpanel in this case i used jpanel
jpanel.revalidate();
jframe.repaint();//repaint a JFrame jframe in this case

//my reson for diong this is because if you intend to remove then add again then remove this is best 
     */
}
