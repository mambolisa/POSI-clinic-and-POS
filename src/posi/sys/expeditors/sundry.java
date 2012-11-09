/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors;

/**
 *
 * @author Aquarius
 */
public class sundry {
    public javax.swing.ImageIcon createImageIcon(String path, java.awt.Dimension d) {
        java.net.URL imgURL = posi.sys.Main.class.getResource(path);
        
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imgURL);
        java.awt.Image img = icon.getImage() ;  
        
        java.awt.Image newimg = img.getScaledInstance( d.width, d.height,  java.awt.Image.SCALE_SMOOTH ) ;  
        
   return new javax.swing.ImageIcon( newimg );
    } 

}
