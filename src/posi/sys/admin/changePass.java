/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.event.ActionEvent;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.inventoryMngt;
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
    
    db_connect db = new db_connect();
    
    private String index;
    public changePass(String user){
        super ( new java.awt.Dimension(430,200), "Change password");
        
        index = user;
        
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
        
    private String get_old_password(){
        String sql = ""
                + " SELECT employee_password "
                + " FROM employees "
                + " WHERE employee_id='"+ index +"' LIMIT 1";
        
    return db.getRow(sql)[0].toString();
    }
    
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() == changePass ){ System.out.println(get_old_password()+ " "+old.getText());
                if( old.getText().equals(get_old_password())){
                    if( new_.getText().equals(new_repeat.getText())){
                        String sql = ""
                                + " UPDATE employees "
                                + " SET employee_password='" + new_.getText() + "' "
                                + " WHERE employee_id='"+ index +"' ";
                        if(db.Update(sql)){
                            javax.swing.JOptionPane.showMessageDialog(null,"Password successfully changed","Password change dialog!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        }                            
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(null,"Repeat password does not match","Password change dialog!",javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                   javax.swing.JOptionPane.showMessageDialog(null,"Old password does not match","Password change dialog!",javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }else if( e.getSource() == cancel ){
                dispose();
            }
        }
        
    }
}
