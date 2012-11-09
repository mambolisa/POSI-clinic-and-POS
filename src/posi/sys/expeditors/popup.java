/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors;

/**
 *
 * @author Aquarius
 */
public class popup extends javax.swing.JDialog {
    private java.awt.Dimension screen;
    
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
  
    public popup(java.awt.Dimension d, String title) {
        super(new java.awt.Frame(), true);
        
        this.setPopup(d);
        
        this.setTitle(title);
    }
    
    public void setDimensions(int width, int height){
        this.setSize(width, height);
    }
    
    public void addContent(java.awt.Container content){
        getContentPane().add(content);
    }
    
    private void setPopup(java.awt.Dimension d){
        screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setSize(d.width, d.height);
        
        this.setLocation((screen.width - this.getWidth())/2,((screen.height-this.getHeight())/2));  
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
    }
}
