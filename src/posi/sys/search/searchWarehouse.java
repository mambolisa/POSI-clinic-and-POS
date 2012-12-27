/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.search;

import posi.sys.expeditors.utilityFunctions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.table.TableModel;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.advanced_search;
import posi.sys.all.inv.invTables;



/**
 *
 * @author Aquarius
 */
public class searchWarehouse extends posi.sys.expeditors.popup {
    private javax.swing.JPanel panel,panel2,panel3; 
    private javax.swing.JTextField textfield;
    private javax.swing.JButton button;
    
    private posi.sys.all.expeditors.database.db_connect db;
    
    private invTables inv;
    
    private Object[][] data;
    
    private String index, warehouse_bar_code, warehouse_name;
    private Double warehouse_price;
    private javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter;
    
    public searchWarehouse(){
       super(new java.awt.Dimension(850,550),"Search");
       
       panel2 = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
      // panel2.setPreferredSize(new java.awt.Dimension(845, 40));
       
       panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));       
       panel.setPreferredSize(new java.awt.Dimension(600, 40));
       
       textfield = new javax.swing.JTextField(30); 
       textfield.setActionCommand("Search");
       textfield.setPreferredSize(new java.awt.Dimension(300, 35));
       textfield.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                sorter.setRowFilter(javax.swing.RowFilter.regexFilter(textfield.getText()));
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
       
       panel.add(textfield);
       
       button = new javax.swing.JButton("Search");
       button.addActionListener(new ActionWarehouse());
       button.setActionCommand("Search");
       button.setPreferredSize(new java.awt.Dimension(100, 35));
       panel.add(button);
       
       panel2.add(panel);
       
       panel3 = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.RIGHT));
       button = new javax.swing.JButton("Advanced search");
       button.addActionListener(new ActionWarehouse());
       button.setActionCommand("advanced_search");
       button.setPreferredSize(new java.awt.Dimension(200, 35));
       panel3.add(button);
       
       panel2.add(panel3);
       this.add(panel2,BorderLayout.PAGE_START);
       
       this.add(searchTable(),BorderLayout.CENTER);
       
       
    }
    
    public static void main(String [] args){
        new searchWarehouse().setVisible(true);
    }
    
    public int getTableSelectedRow(){
        return inv.getSelectedRow();                
    }
      
    public String get_warehouse_index(){
        return index;
    }
    
    public String get_warehouse_name(){
        return warehouse_name;
    }
        
    public void set_textfield_text(String text){
        textfield.setText(text);
    }
    
    public javax.swing.JScrollPane searchTable(){
        db = new db_connect();
        String sql = "SELECT warehouse_id , warehouse_name , warehouse_location, warehouse_status   FROM warehouses";
        
        data = db.getData( sql );
        
        final String [] columnNames = { "Warehouse num", "Warehouse name", "Warehouse location", "Warehouse status"};
        inv = new invTables(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        inv.getTableHeader().setReorderingAllowed(false);
        inv.getTableHeader().setResizingAllowed(false);
        
        inv.getColumnModel().getColumn(0).setPreferredWidth(70);
        inv.getColumnModel().getColumn(1).setPreferredWidth(150);
        inv.getColumnModel().getColumn(2).setPreferredWidth(320);
        
        sorter = new javax.swing.table.TableRowSorter<TableModel>(inv.getModel());
        inv.setRowSorter(sorter);
        
        inv.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                int rowNum = inv.rowAtPoint(p);  
                if( rowNum != -1 ){               
                    Object index_id =  data[rowNum][0];
                    Object name = data[rowNum][1];
                    if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                        if(e.getClickCount() >= 2){
                            index = index_id.toString();
                            warehouse_name = name.toString();
                            
                            setVisible(false);

                        }
                    }
                }
           }
       });
        
    return  inv.tableScrollPane();
    }
}
class ActionWarehouse implements java.awt.event.ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
         if( "advanced_search".equals(e.getActionCommand())){
             new advanced_search().setVisible(true);
         }
    }
        
}