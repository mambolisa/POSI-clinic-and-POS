/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class trackItem extends posi.sys.expeditors.popup {
    public trackItem(){
        super(new java.awt.Dimension(400,500),"Track Item");
        
        this.addContent(new javax.swing.JButton("Track item"));
    }
}
