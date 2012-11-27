/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import posi.sys.all.expeditors.database.db_connect;
/**
 *
 * @author Aquarius
 */
public class reports {
    private static db_connect db;
    public static javax.swing.JScrollPane InvAll(){
        db = new db_connect();
        String sql = "SELECT item_id,item_default_bar_code,item_name,item_default_price,item_default_price, item_description, item_status_name FROM items, item_status WHERE item_status = item_status_id ";
        final Object[][] data = db.getData(sql);
        
        final String [] columnNames = {"Item Id","Item code","Item name","Item price","Item qty","Description","Item status"};
         
        final inventoryTable inv = new inventoryTable(data,columnNames);
         
        inv.setTableModel(new javax.swing.table.AbstractTableModel(){
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
                   if (col < 2 || col == 6) {
                        return false;
                   } else {
                       return true;
                   }
              }

             @Override
              public void setValueAt(Object value, int row, int col) {                  
                  int n = javax.swing.JOptionPane.showConfirmDialog(inv, "Update "+data[row][col]+" to "+ value + "?", "Continue with changes?",javax.swing.JOptionPane.YES_NO_OPTION);
                  if( n == 0){
                      data[row][col] = value;
                      String sql = null;
                      if( col == 2){
                          sql = "UPDATE items set item_name = '"+value+"' WHERE item_id='"+data[row][0]+"';";                      
                      }else if (col == 3){
                          sql = "UPDATE items set item_default_price = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }else if ( col == 4){
                          sql = "UPDATE items set item_qty = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }else if ( col == 5){
                          sql = "UPDATE items set item_description = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }
                          
                      if(db.Update(sql)){
                            JOptionPane.showMessageDialog(null,"Item  has been updated","Record updated!",JOptionPane.INFORMATION_MESSAGE);
                            fireTableCellUpdated(row, col);
                      }else{
                            JOptionPane.showMessageDialog(null,"Item  has failed to update","Record update erro!",JOptionPane.ERROR_MESSAGE);      
                      } 
                  }else{
                      return;
                  }
              }
        });
        
       inv.setMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent e){
               if(SwingUtilities.isLeftMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   if (e.getClickCount() == 2){
                       int rowNum = inventoryTable.table().rowAtPoint(p);
                       Object itemCode =  data[rowNum][0];
                       System.out.println(rowNum);
                       posi.sys.all.inv.newItem newItem = new posi.sys.all.inv.newItem();
                   }
                   
               }else if (SwingUtilities.isRightMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   
                   int rowNum = inventoryTable.table().rowAtPoint(p);
                   Object itemCode =  data[rowNum][0];
                   javax.swing.JPopupMenu popup = utilityFunctions.invRowPopupMenu(itemCode);
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
    return  inventoryTable.tableScrollPane();
    }
}
