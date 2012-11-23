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
    public static javax.swing.ImageIcon createImageIcon(String path, java.awt.Dimension d) {
        java.net.URL imgURL = posi.sys.Main.class.getResource(path);
        
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imgURL);
        java.awt.Image img = icon.getImage() ;  
        
        java.awt.Image newimg = img.getScaledInstance( d.width, d.height,  java.awt.Image.SCALE_SMOOTH ) ;  
        
    return new javax.swing.ImageIcon( newimg );
    } 
    public static javax.swing.JComboBox createCombo(javax.swing.JComboBox combo,Object [][] data){
        for (int i = 0; i < data.length; i++){
            Object [] row = data[i];
            
            for (int j = 0; j< row.length; j++){
                String cont = row[j].toString();
                combo.addItem(cont);
            }
        }
        
    return combo;
    }
}
