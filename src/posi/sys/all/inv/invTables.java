/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;


/**
 *
 * @author Aquarius
 * 
 */

public class invTables extends javax.swing.JTable{
    private static javax.swing.JScrollPane scrollPane;
    private posi.sys.all.inv.ManageTabs r = new posi.sys.all.inv.ManageTabs();

    private javax.swing.JTable table = this;
    
    private posi.sys.all.expeditors.database.db_connect db = new posi.sys.all.expeditors.database.db_connect();
     
    private invTables(){
 
    }
    
    public void create(String sql, String [] columnNames){
        Object [][] data = db.getData(sql);
        table = new javax.swing.JTable(data, columnNames);
        setTable();
    }
    
    public void refresh(){
        
    }
    
    public invTables(java.util.Vector data, java.util.Vector columnNames){
        super(data, columnNames); 
        setTable();
    }
    
    public invTables(Object [][] data, String [] columnNames){
        super(data, columnNames);        
        setTable();
    }
    
    private void setTable(){
        setFillsViewportHeight(true);
        setAutoCreateRowSorter(true);
        setRowHeight(28);
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