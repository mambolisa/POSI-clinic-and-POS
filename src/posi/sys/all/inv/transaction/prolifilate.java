/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv.transaction;

/**
 *
 * @author Aquarius
 */
public class prolifilate extends posi.sys.expeditors.popup {
    public prolifilate(){
        super(new java.awt.Dimension(400,500),"Increase inventory");
        
        this.addContent(new javax.swing.JButton("Increase"));
    }
}
