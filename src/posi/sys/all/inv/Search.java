/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import posi.sys.all.expeditors.database.db_connect;

/**
 *
 * @author Aquarius
 */
public class Search extends posi.sys.expeditors.popup {
    private javax.swing.JPanel panel; 
    private javax.swing.JTextField textfield;
    private javax.swing.JButton button;
    
    private posi.sys.all.expeditors.database.db_connect db;
    
    private inventoryTable inv;
    
    private Object[][] data;
    
    public Search(){
       super(new java.awt.Dimension(850,550),"Search");
       
       panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
       
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
       
       this.add(panel,BorderLayout.PAGE_START);
       
       
       this.add(searchTable(),BorderLayout.CENTER);
    }
    
    public static void main(String [] args){
        new Search().setVisible(true);
    }
    
    public final javax.swing.JScrollPane searchTable(){
        db = new db_connect();
        String sql = "SELECT item_default_bar_code,item_name, item_description,item_default_price,item_qty FROM items, item_status WHERE item_status = item_status_id ";
        data = db.getData(sql);
        
        final String [] columnNames = {"Item code","Item name","Description","Item price","Item qty"};
         
        inv = new inventoryTable(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        inv.setRowHeight(28);
        
        inv.getColumnModel().getColumn(0).setPreferredWidth(180);
        inv.getColumnModel().getColumn(1).setPreferredWidth(300);
        inv.getColumnModel().getColumn(2).setPreferredWidth(200);
        inv.getColumnModel().getColumn(3).setPreferredWidth(130);
        inv.getColumnModel().getColumn(4).setPreferredWidth(100);
        
    return  inv.tableScrollPane();
    }
}


class Action implements java.awt.event.ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

    }
        
    }