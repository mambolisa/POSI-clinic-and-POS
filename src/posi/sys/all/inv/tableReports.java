/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.expeditors.utilityFunctions;
/**
 *
 * @author Aquarius
 */
public class tableReports {
    private static db_connect db;
    private Object[][] data;
    private inventoryTable inv;
    
    public javax.swing.JScrollPane InvAll(){
        db = new db_connect();
        String sql = "SELECT item_id,item_default_bar_code,item_name, item_description,item_default_price,item_qty FROM items, item_status WHERE item_status = item_status_id ";
        data = db.getData(sql);
     
        final String [] columnNames = {"Item Id","Item code","Item name","Description","Item price","Item qty"};
         
        inv = new inventoryTable(data,columnNames);
        inv.getTableHeader().setReorderingAllowed(false);
        inv.getTableHeader().setResizingAllowed(false);
        
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
                      }else if (col == 4){
                          sql = "UPDATE items set item_default_price = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }else if ( col == 5){
                          sql = "UPDATE items set item_qty = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }else if ( col == 3){
                          sql = "UPDATE items set item_description = '"+value+"' WHERE item_id='"+data[row][0]+"';"; 
                      }
                          
                      if(db.Update(sql)){
                            JOptionPane.showMessageDialog(null,"Item  has been updated","Record updated!",JOptionPane.INFORMATION_MESSAGE);
                            fireTableCellUpdated(row, col);
                      }else{
                            JOptionPane.showMessageDialog(null,"Item  has failed to update","Record update erro!",JOptionPane.ERROR_MESSAGE);      
                      } 
                  }else{

                  }
              }
        });
        inv.getColumnModel().getColumn(0).setPreferredWidth(70);
        inv.getColumnModel().getColumn(1).setPreferredWidth(150);
        inv.getColumnModel().getColumn(2).setPreferredWidth(320);
        inv.getColumnModel().getColumn(3).setPreferredWidth(250);
        inv.getColumnModel().getColumn(4).setPreferredWidth(100);
        inv.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        
       inv.setMouseListener(new java.awt.event.MouseAdapter() {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
               if (SwingUtilities.isRightMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   
                   int rowNum = inv.table().rowAtPoint(p);
                   Object itemCode =  data[rowNum][0];
                   javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
    return  inv.tableScrollPane();
    }
    
    public javax.swing.JTable getTable(){
        return inv;
    }
    
    public javax.swing.table.TableModel getTableModel(){
        return inv.getModel();
        
    }
}
