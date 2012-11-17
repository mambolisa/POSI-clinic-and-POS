/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;

/**
 *
 * @author Aquarius
 */
public class inventoryTable extends javax.swing.JTable{
    private javax.swing.JTable table;

    private javax.swing.JScrollPane scrollPane;
Object[][] data;

                String[] cols;
    
    public inventoryTable(){
        table = new javax.swing.JTable(this.data, this.cols);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);    
        table.setRowHeight(50);
    }
    
    public inventoryTable(Object [][] data, String [] columnNames){
        this.cols = columnNames;
        this.data = data;
        
        table = new javax.swing.JTable(this.data, this.cols);        
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
    }
    
    public  javax.swing.JTable table(){
        return table;
    }
    
    public  javax.swing.JScrollPane tableScrollPane(){
        scrollPane= new javax.swing.JScrollPane(table);
        return scrollPane;
    }
}