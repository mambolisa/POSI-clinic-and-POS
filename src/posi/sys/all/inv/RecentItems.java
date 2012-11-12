/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class RecentItems  extends posi.sys.expeditors.popup {
    public RecentItems(){
        super(new java.awt.Dimension(400,500),"Recent Item");
        
        this.getContentPane().add(new javax.swing.JButton("Recent"));
    }
}
