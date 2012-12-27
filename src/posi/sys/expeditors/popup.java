/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors;

import java.awt.event.KeyEvent;

/**
 *
 * @author Aquarius
 */
public class popup extends javax.swing.JDialog {
    private java.awt.Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();;
    
    public popup(){
        this.setResizable(false);
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
    }
    
    public popup(java.awt.Frame parent, boolean modal, java.awt.Dimension d) {
        super(parent, modal);
    
        this.setPopup(d);
    }
 
    public popup(java.awt.Dimension d,java.awt.Container content, String title) {
        super(new java.awt.Frame(), true);
        
        this.setPopup(d);
        
        this.addContent(content);
        
        this.setTitle(title);
    }
    
    public popup(java.awt.Dimension d) {
        super(new java.awt.Frame(), true);
        
        this.setPopup(d);
    }
    
    public popup(java.awt.Dimension d, String title) {
        super(new java.awt.Frame(), true);
        
        this.setPopup(d);
        
        this.setTitle(title);
    }
    
    public void setDimensions(int width, int height){
        this.setSize(width, height);
        this.setLocation((screen.width - width )/2,((screen.height- height)/2)); 
    }
    
    public void addContent(java.awt.Component c){
        getContentPane().add(c);
    }
    
    public void SetPopup(java.awt.Dimension d){
        setPopup(d);
    }
    
    private void setPopup(java.awt.Dimension d){
        this.setSize(d.width, d.height);
        
        this.setResizable(false);
        
        this.setLocation((screen.width - this.getWidth())/2,((screen.height-this.getHeight())/2));  
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        
        this.setIconImage(sundry.createImageIcon("images/Globe.gif", new java.awt.Dimension(20,20)).getImage());
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        dispose();
    }
    
}
