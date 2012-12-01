/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public  class TablesList  {
    private int count = 0;
    private javax.swing.JComponent c;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane scrollpane;
    private java.util.List<Object> list;
    
    public TablesList(){
        list = new java.util.ArrayList<Object>();
    }
    
    public void addItem(javax.swing.JComponent c, String title){
        count++;
        
    }
    
    public int getCount(){
        return count;
    }
    
    public void removeItem(){
        count--;
    }
    
    public javax.swing.JScrollPane getComponent(String title){
        return scrollpane;
    }
    
    public javax.swing.JTable getComponentTable(String title){
        
        return table;
    }
}
