/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class Security extends posi.sys.expeditors.popup {
    public Security(){
        super(new java.awt.Dimension(400,500),"Search");
        
        this.addContent(new javax.swing.JButton("Search"));
    }
}
