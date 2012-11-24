/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public  class TablesList extends java.util.ArrayList {
    private int count = 0;
    javax.swing.JComponent c;
    public void addItem(javax.swing.JComponent c, String title){
        count++;
        
        this.add(c);
    }
    
    public int getCount(){
        return count;
    }
    
    public void removeItem(){
        count--;
    }
    
    public javax.swing.JComponent getComponent(String title){
        return c;
    }
    
    public javax.swing.JComponent getComponentTable(String title){
        
        return c;
    }
}
