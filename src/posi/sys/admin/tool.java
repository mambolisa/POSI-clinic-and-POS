/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

/**
 *
 * @author Aquarius
 */
public class tool {
    private static javax.swing.JPanel panel_main;
    
    public static javax.swing.JPanel tool(){
        panel_main = new javax.swing.JPanel();
        panel_main.add(new javax.swing.JButton("Settings"));
        
        return panel_main;
    }
}
