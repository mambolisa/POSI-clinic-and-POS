/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class allItemsList extends posi.sys.expeditors.popup {
    public allItemsList(){
        super(new java.awt.Dimension(400,500),"All Items");
        
        this.addContent(new javax.swing.JButton("All items"));
    }
}
