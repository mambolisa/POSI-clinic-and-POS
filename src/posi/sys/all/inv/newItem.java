/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class newItem extends posi.sys.expeditors.popup {
    public newItem(){
        super(new java.awt.Dimension(400,500),"New Item");
        
        this.addContent(new javax.swing.JButton("New item"));
    }
}
