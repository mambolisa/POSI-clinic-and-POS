/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import posi.sys.all.expeditors.database.db_connect;
/**
 *
 * @author Aquarius
 */
public class reports {
    
    public static javax.swing.JScrollPane InvAll(){
        db_connect db = new db_connect();
        String sql = "SELECT item_default_bar_code,item_name,item_default_price,item_default_price,item_qty, item_description,item_category FROM items";        System.out.print(db.getArrayQuery(sql));
        final Object[][] data = db.getArrayQuery(sql);
        
         final String [] columnNames = {"Item code","Item name","Item price","Item qty","Description","Category"};
         javax.swing.JTable table= new inventoryTable(data,columnNames).table();
         
         table.setModel(new javax.swing.table.AbstractTableModel(){
             @Override
            public int getColumnCount() {
                  return columnNames.length;
              }

             @Override
              public int getRowCount() {
                  return data.length;
              }

             @Override
              public String getColumnName(int col) {
                  return columnNames[col];
              }

             @Override
              public Object getValueAt(int row, int col) {
                  return data[row][col];
              }

             @Override
              public boolean isCellEditable(int row, int col) {
                  return false;
              }

             @Override
              public void setValueAt(Object value, int row, int col) {
                  data[row][col] = value;
                  fireTableCellUpdated(row, col);
              }
        });
    return  new inventoryTable(data,columnNames).tableScrollPane();
    }
}
