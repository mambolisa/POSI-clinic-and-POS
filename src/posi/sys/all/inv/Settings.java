/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class Settings extends posi.sys.expeditors.popup {
    public Settings(){
        super(new java.awt.Dimension(400,500),"Settings");
        
        this.addContent(new javax.swing.JButton("Settings"));
    }
}
