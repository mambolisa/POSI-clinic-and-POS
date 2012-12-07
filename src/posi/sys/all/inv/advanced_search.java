/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class advanced_search extends posi.sys.expeditors.popup {
    public advanced_search(){
        super(new java.awt.Dimension(900,600),"Advanced search");
    }
    
    public static void main(String [] args){
        new advanced_search().setVisible(true);
    }
}
