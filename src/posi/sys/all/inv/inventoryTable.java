/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;


/**
 *
 * @author Aquarius
 */
public class inventoryTable extends javax.swing.JTable{
    private static javax.swing.JScrollPane scrollPane;
    private posi.sys.all.inv.TablesList r = new posi.sys.all.inv.TablesList();
    
    public inventoryTable(){
        
    }
    
    public inventoryTable(java.util.Vector data, java.util.Vector columnNames){
        super(data, columnNames);      
       // r.addItem(table, "")
        setTable();
    }
    
    public inventoryTable(Object [][] data, String [] columnNames){
        super(data, columnNames);        
        setTable();
    }
    
    private void setTable(){
        setFillsViewportHeight(true);
        setAutoCreateRowSorter(true);
        setRowHeight(25);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }
    
    public  javax.swing.JTable table(){
        return this;
    }
        
    public void setTableModel(javax.swing.table.TableModel dataModel){
        setModel(dataModel);
    }
    
    public void setMouseListener(java.awt.event.MouseAdapter m){
        addMouseListener(m);
    }
    
    public javax.swing.JScrollPane tableScrollPane(){
        scrollPane= new javax.swing.JScrollPane(this);
        return scrollPane;
    }
}