/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.invTables;
import posi.sys.expeditors.utilityFunctions;

/**
 *
 * @author Aquarius
 */
public class user_management {
    private static javax.swing.JPanel panel_main, panel_top, panel_center, panel_btn;
    private static javax.swing.JButton button, button_1, button_2;
 
    private static posi.sys.all.expeditors.database.db_connect db;
    
    private static invTables inv;
    
    private static Object[][] data;
    
    private static String index, item_bar_code;
    
    private static javax.swing.JLabel label_list;
    
    public static javax.swing.JPanel user_management(){
        panel_main = new javax.swing.JPanel();
        panel_main.add( top_button( ), BorderLayout.LINE_START );
        panel_main.add( center( ), BorderLayout.CENTER );
        
        return panel_main;
    }
    
    public static javax.swing.JPanel top_button(){        
        label_list = new javax.swing.JLabel();
        label_list.setFont ( new java.awt.Font ( java.awt.Font.DIALOG_INPUT, java.awt.Font.BOLD, 24 ) );
        label_list.setText("User management");
        label_list.setPreferredSize(new java.awt.Dimension(600,37));
        
        panel_top = new javax.swing.JPanel( new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_top.setPreferredSize(new java.awt.Dimension(780,37));
        
        panel_btn = new javax.swing.JPanel( new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT) );
        panel_btn.setPreferredSize(new java.awt.Dimension(150,37));
        button = new javax.swing.JButton("Add user");
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new user_mng_en(  ){
                            
                }.setVisible(true);
            }
        });
        panel_btn.add(button);
        
        panel_top.add( label_list  );
        panel_top.add( panel_btn );
        
        
        return panel_top;
    }
    
    public static javax.swing.JPanel center(){
        panel_center = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        db = new db_connect();
        
        String sql = "SELECT employee_id,employee_serial_num, employee_fname,employee_mname,employee_lname,employee_idnum FROM employees";
        data = db.getData(sql);
        
        final String [] columnNames = {"Employee Id","Serail code","First name","Middle name","Last name","National ID"};
         
        inv = new invTables(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        inv.setRowHeight(28);
        
        inv.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                int rowNum = inv.table().rowAtPoint(p);  
                
                if( rowNum != -1){                    
                    Object itemCode =  data[rowNum][0];
                    Object itemBarCode = data[rowNum][1];

                    if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                        if(e.getClickCount() >= 2){
                            index = itemCode.toString();
                            item_bar_code = itemBarCode.toString();  
                            new user_mng_en( index ){

                            }.setVisible(true);
                        }
                    }else if (javax.swing.SwingUtilities.isRightMouseButton(e)){
                       javax.swing.JPopupMenu popup = new utilityFunctions().user_mng_popup(Integer.parseInt(itemCode.toString()));

                       popup.show(e.getComponent(), e.getX(), e.getY());
                   }
                }
           }
       });
        javax.swing.JScrollPane scrollpanel = inv.tableScrollPane();
        scrollpanel.setPreferredSize(new java.awt.Dimension(780, 390));
        panel_center.add(scrollpanel);
        
        return panel_center;
    }
}

