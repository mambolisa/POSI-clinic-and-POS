/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author Aquarius
 */
public class tool {
    private static javax.swing.JPanel panel_all, panel_main, panel_top;
    private static javax.swing.JLabel label;
    private static javax.swing.JComboBox combo_top;
    
    public static javax.swing.JPanel tool(){
        panel_all = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_all.setPreferredSize(new java.awt.Dimension(700, 40));
        
        panel_top = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_top.setPreferredSize(new java.awt.Dimension(700, 40));
        
        label = new javax.swing.JLabel("Controls");
        label.setPreferredSize(new java.awt.Dimension(60, 35));
        panel_top.add(label);
        
        combo_top = new javax.swing.JComboBox( new Object[]{"-- Selection --","POS","Inventory","Users","Reports","Warehouse"});
        combo_top.setPreferredSize(new java.awt.Dimension(150, 30));
        combo_top.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JComboBox combo = (javax.swing.JComboBox) e.getSource();
                int selectedID = combo.getSelectedIndex();
                
                switch(selectedID){
                    case 1://POS
                        posControl();
                    break;
                    case 2://Inventory
                        inventoryControl();
                    break;
                    case 3://Users
                        usersControl();
                    break;
                    case 4://Reports
                        reportsControl();
                    break;             
                }
            }
        });
        panel_top.add(combo_top);
        panel_all.add(panel_top);
        
        panel_main = new javax.swing.JPanel();
        panel_main.setPreferredSize(new java.awt.Dimension(830, 390));
        panel_main.setBackground(Color.white );
        
        panel_all.add(panel_main);
        
    return panel_all;
    }
    
    private static void inventoryControl(){
        admin.change_right_pane( tool( ) );
        
        panel_main.add(new javax.swing.JButton("Inventory"));
    }
    
    private static void posControl(){
        admin.change_right_pane( tool( ) );
        
        panel_main.add(new javax.swing.JButton("POS"));
    }
    
    private static void usersControl(){
        admin.change_right_pane( tool( ) );
        
        panel_main.add(new javax.swing.JButton("Users"));      
    }
    
    private static void reportsControl(){
        admin.change_right_pane( tool( ) );
        
        panel_main.add(new javax.swing.JButton("Reports"));      
    }
}