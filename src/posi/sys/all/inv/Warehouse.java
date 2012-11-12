/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class Warehouse extends posi.sys.expeditors.popup {
    public Warehouse(){
        super(new java.awt.Dimension(400,500),"Warehouse");
        
        this.addContent(new javax.swing.JButton("Warehouse"));
    }
}
