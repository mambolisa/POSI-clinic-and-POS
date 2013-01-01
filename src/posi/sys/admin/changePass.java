/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.event.ActionEvent;

/**
 *
 * @author Aquarius
 */
public class changePass extends posi.sys.expeditors.popup{
    javax.swing.JPanel pane, panel;
    javax.swing.JLabel label;
    javax.swing.JPasswordField old, new_ , new_repeat;
    javax.swing.JButton changePass, cancel;
    
    java.awt.Dimension label_dimension = new java.awt.Dimension(150, 30);
    
    public changePass(){
        super ( new java.awt.Dimension(430,200), "Change password");
        
        content();
    }
    
    
    public void content(){
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        label = new javax.swing.JLabel("Old password: ", javax.swing.SwingConstants.RIGHT);
        label.setPreferredSize( label_dimension );
        old = new javax.swing.JPasswordField(20);
        old.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(label);
        pane.add(old);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        label = new javax.swing.JLabel("New password: ", javax.swing.SwingConstants.RIGHT);
        label.setPreferredSize( label_dimension );
        new_ = new javax.swing.JPasswordField(20);
        new_.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(label);
        pane.add(new_);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        label = new javax.swing.JLabel("Repeat password: ", javax.swing.SwingConstants.RIGHT);
        label.setPreferredSize( label_dimension );
        new_repeat = new javax.swing.JPasswordField(20);
        new_repeat.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(label);
        pane.add(new_repeat);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 40));
        
        changePass = new javax.swing.JButton( "Change password" );
        changePass.addActionListener(new Action());
        pane.add( changePass );
        
        cancel = new javax.swing.JButton( "Cancel" );
        cancel.addActionListener(new Action());
        pane.add( cancel );
        panel.add(pane);
        
        add( panel );
    }
    
    public static void main( String [] args){
        new changePass().setVisible(true);
    }
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() == changePass ){
                
            }else if( e.getSource() == cancel ){
                dispose();
            }
        }
        
    }
}
