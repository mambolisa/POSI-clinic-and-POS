/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.Dimension;


/**
 *
 * @author Aquarius
 */
public class POS extends posi.sys.expeditors.popup {
    public POS(){
        super(new java.awt.Dimension(900,600),"Point of sale");
        
        this.addContent(new javax.swing.JButton("Point of sale"));
    }
}

