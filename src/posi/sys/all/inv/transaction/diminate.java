/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv.transaction;

/**
 *
 * @author Aquarius
 */
public class diminate extends posi.sys.expeditors.popup {
    public diminate(){
        super(new java.awt.Dimension(400,500),"Reduce inventory");
        
        this.addContent(new javax.swing.JButton("Reduce"));
    }
}
