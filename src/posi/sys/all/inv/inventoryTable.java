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
    private javax.swing.JTable table;

    private javax.swing.JScrollPane scrollPane;
    Object[][] data;

    String[] cols;
        
    public inventoryTable(Object [][] data, String [] columnNames){
        this.cols = columnNames;
        this.data = data;
        
        table = new javax.swing.JTable(this.data, this.cols);        
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(20);
    }
    
    public  javax.swing.JTable table(){
        return table;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        return  super.getValueAt(row, col);       
    }
    
    public void setTableModel(javax.swing.table.TableModel dataModel){
        table.setModel(dataModel);
    }
    
    public void setMouseListener(java.awt.event.MouseAdapter m){
        table.addMouseListener(m);
    }
    
    public  javax.swing.JScrollPane tableScrollPane(){
        scrollPane= new javax.swing.JScrollPane(table);
        return scrollPane;
    }
}