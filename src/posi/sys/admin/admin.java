/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.event.ActionEvent;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */
public class admin extends posi.sys.expeditors.popup{
    javax.swing.JPanel panel, panel_1, panel1;
    public static javax.swing.JSplitPane splitpane;
    javax.swing.JButton button;
    javax.swing.JLabel label;
    
    public admin(){
        super(new java.awt.Dimension(790,570),"Warehouse");
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.setBackground(java.awt.Color.white);
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        splitpane = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitpane.setDividerLocation(80);
        splitpane.setEnabled(false);
        add_content();
    }
    
    public void user_management(){
        splitpane.setRightComponent(user_management.user_management());
        splitpane.setDividerLocation(80);        
    }
    
    public void security(){
        splitpane.setRightComponent(security.security());
        splitpane.setDividerLocation(80);        
    }
    
    public void settings(){
        splitpane.setRightComponent(tool.tool());
        splitpane.setDividerLocation(80);        
    }
    
    private void add_content(){
        top_buttons();
        
        splitpane.setLeftComponent(panel);
        splitpane.setRightComponent(panel1);
        
        add(splitpane);
        
        splitpane.setRightComponent(user_management.user_management());
        splitpane.setDividerLocation(80);
    }

   
    private void top_buttons(){
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(java.awt.Color.white);
        label = new javax.swing.JLabel("Settings");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Tool.gif", new java.awt.Dimension(60, 50)));
        button.setPreferredSize(new java.awt.Dimension(60, 50));
        button.setContentAreaFilled(false);
        button.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 14));
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(tool.tool());
                splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(java.awt.Color.white);
        label = new javax.swing.JLabel("Security");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Security.gif", new java.awt.Dimension(60, 50)));
        button.setPreferredSize(new java.awt.Dimension(60, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(security.security());
                splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(java.awt.Color.white);
        label = new javax.swing.JLabel("User management");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Woman.gif", new java.awt.Dimension(60, 50)));
        button.setPreferredSize(new java.awt.Dimension(60, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(user_management.user_management());
                splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
    } 
    
    public static void main(String [] args){
        new admin().setVisible(true);
    }
}
