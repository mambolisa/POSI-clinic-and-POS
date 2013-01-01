/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.search;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.table.TableModel;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.advanced_search;
import posi.sys.all.inv.invTables;
import posi.sys.expeditors.utilityFunctions;

/**
 *
 * @author Aquarius
 */
public class SearchPersons extends posi.sys.expeditors.popup{
    private javax.swing.JPanel panel,panel2,panel3; 
    private javax.swing.JTextField textfield;
    private javax.swing.JButton button;
    
    public javax.swing.JButton add_cust;
    
    private db_connect db;
    
    private String search_type = "";
    private invTables inv;
    
    private Object[][] data;
    
    private String index, item_bar_code;
    private javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter;
    
    public SearchPersons(String searchType){
       super(new java.awt.Dimension(950,550),"Search");
       
       search_type = searchType;
       
       panel2 = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
      // panel2.setPreferredSize(new java.awt.Dimension(845, 48));
       
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
       
       if( "cust".equals( search_type ) ){
            add_cust = new javax.swing.JButton("Add Customer");
            add_cust.addActionListener(new Action());
            add_cust.setActionCommand("add_cust");
            add_cust.setPreferredSize(new java.awt.Dimension(150, 35));
            panel3.add(add_cust);           
       }

       button = new javax.swing.JButton("Advanced search");
       button.addActionListener(new Action());
       button.setActionCommand("advanced_search");
       button.setPreferredSize(new java.awt.Dimension(150, 35));
       panel3.add(button);
       
       panel2.add(panel3);
       this.add(panel2,BorderLayout.PAGE_START);
       
       this.add(searchTable(),BorderLayout.CENTER);
       
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
    }

    public static void main(String [] args){
        new SearchPersons("cust").setVisible(true);
    }
    
    public void hide_cust_add(){
        add_cust.setVisible(false);
    }
            
    public int getTableSelectedRow(){
        return inv.getSelectedRow();                
    }
      
    public String get_index(){
        return index;
    }
    
    public String get_item_bar_code(){
        return item_bar_code;
    }
    
    public javax.swing.JScrollPane searchTable(){
        db = new db_connect();
        String sql = "";
        String [] columnNames = null;
        if( "cust".equals(search_type.toLowerCase()) ) {
            sql = "SELECT customer_id, customer_fname,customer_lname, customer_idnum, customer_status_name FROM customers,customer_status WHERE customer_status_id=customer_status;";
            columnNames = new String[]{"Customer Num","First name","Last name","ID Num","Status"};            
        }else if( "supplier".equals(search_type.toLowerCase()) ){
            sql = "SELECT item_supp_id,item_supp_name,item_supp_location, supplier_fax, supplier_phone_num FROM item_supplier ";
            columnNames = new String[]{"Supplier ID","Supplier name","Supplier location", "Fax", "Phone number"};              
        }
        
        data = db.getData(sql);
        
             
        inv = new invTables(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        inv.setRowHeight(28);
        
        if( "cust".equals(this.search_type) ) {
            inv.getColumnModel().getColumn(0).setPreferredWidth(130);
            inv.getColumnModel().getColumn(1).setPreferredWidth(180);
            inv.getColumnModel().getColumn(2).setPreferredWidth(200);
            inv.getColumnModel().getColumn(3).setPreferredWidth(200);
            inv.getColumnModel().getColumn(4).setPreferredWidth(130);
           // inv.getColumnModel().getColumn(5).setPreferredWidth(100);
        }
        sorter = new javax.swing.table.TableRowSorter<TableModel>(inv.getModel());
        inv.setRowSorter(sorter);
        
        inv.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                int rowNum = inv.rowAtPoint(p);  
                if( rowNum != -1 ){               
                    Object index_object =  data[rowNum][0];
                    Object itemBarCode = data[rowNum][1];
                    if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                        if(e.getClickCount() >= 2){
                            index = index_object.toString();
                            item_bar_code = itemBarCode.toString();
                            setVisible(false);

                        }
                    }else if (javax.swing.SwingUtilities.isRightMouseButton(e)){
                       javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(index.toString()));

                       popup.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
           }
       });
        
    return  inv.tableScrollPane();
    }

    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             if( "advanced_search".equals(e.getActionCommand())){
                 new advanced_search().setVisible(true);
             }
        }

    }
}
