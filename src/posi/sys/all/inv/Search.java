/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import posi.sys.expeditors.utilityFunctions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.table.TableModel;
import posi.sys.all.expeditors.database.db_connect;

/**
 *
 * @author Aquarius
 */
public class Search extends posi.sys.expeditors.popup {
    private javax.swing.JPanel panel,panel2,panel3; 
    private javax.swing.JTextField textfield;
    private javax.swing.JButton button;
    
    private posi.sys.all.expeditors.database.db_connect db;
    
    private inventoryTable inv;
    
    private Object[][] data;
    
    private String item_index, item_bar_code;
    private javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter;
    
    public Search(){
       super(new java.awt.Dimension(850,550),"Search");
       
       panel2 = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
      // panel2.setPreferredSize(new java.awt.Dimension(845, 40));
       
       panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));       
       panel.setPreferredSize(new java.awt.Dimension(600, 40));
       
       textfield = new javax.swing.JTextField(30); 
       textfield.addActionListener(new Action());
       textfield.setActionCommand("Search");
       textfield.setPreferredSize(new java.awt.Dimension(300, 35));

       panel.add(textfield);
       
       button = new javax.swing.JButton("Search");
       button.addActionListener(new Action());
       button.setActionCommand("Search");
       button.setPreferredSize(new java.awt.Dimension(100, 35));
       panel.add(button);
       
       panel2.add(panel);
       
       panel3 = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.RIGHT));
       button = new javax.swing.JButton("Advanced search");
       button.addActionListener(new Action());
       button.setActionCommand("advanced_search");
       button.setPreferredSize(new java.awt.Dimension(200, 35));
       panel3.add(button);
       
       panel2.add(panel3);
       this.add(panel2,BorderLayout.PAGE_START);
       
       this.add(searchTable(),BorderLayout.CENTER);
       
       textfield.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                 sorter.setRowFilter(javax.swing.RowFilter.regexFilter(textfield.getText()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    public static void main(String [] args){
        new Search().setVisible(true);
    }
    
    public int getTableSelectedRow(){
        return inv.getSelectedRow();                
    }
      
    public String get_item_index(){
        return item_index;
    }
    
    public String get_item_bar_code(){
        return item_bar_code;
    }
    
    public final javax.swing.JScrollPane searchTable(){
        db = new db_connect();
        String sql = "SELECT item_id, item_default_bar_code,item_name, item_description,item_default_price,item_qty FROM items, item_status WHERE item_status = item_status_id ";
        data = db.getData(sql);
        
        final String [] columnNames = {"Item Num","Item code","Item name","Description","Item price","Item qty"};
         
        inv = new inventoryTable(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        inv.setRowHeight(28);
        
        inv.getColumnModel().getColumn(0).setPreferredWidth(70);
        inv.getColumnModel().getColumn(1).setPreferredWidth(180);
        inv.getColumnModel().getColumn(2).setPreferredWidth(300);
        inv.getColumnModel().getColumn(3).setPreferredWidth(200);
        inv.getColumnModel().getColumn(4).setPreferredWidth(130);
        inv.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        sorter = new javax.swing.table.TableRowSorter<TableModel>(inv.getModel());
        inv.setRowSorter(sorter);
        
        inv.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                   
                int rowNum = inv.table().rowAtPoint(p);
                Object itemCode =  data[rowNum][0];
                Object itemBarCode = data[rowNum][1];
                if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                    if(e.getClickCount() >= 2){
                        item_index = itemCode.toString();
                        item_bar_code = itemBarCode.toString();
                        setVisible(false);
                        
                    }
                }else if (javax.swing.SwingUtilities.isRightMouseButton(e)){
                   javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
        
    return  inv.tableScrollPane();
    }
}


class Action implements java.awt.event.ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
         if( "advanced_search".equals(e.getActionCommand())){
             new advanced_search().setVisible(true);
         }
    }
        
}