/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors.application;

/**
 *
 * @author Aquarius
 */
public class applications extends posi.sys.expeditors.popup {
    public applications(){
        super(new java.awt.Dimension(400,500),"Reduce inventory");
        
        this.addContent(new javax.swing.JButton("Calc"));
        this.addContent(new javax.swing.JButton("Calendar"));
        this.addContent(new javax.swing.JButton("Clock"));
    }
    
    
}

