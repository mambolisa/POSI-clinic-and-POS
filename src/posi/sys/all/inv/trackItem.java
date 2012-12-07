/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import posi.sys.all.expeditors.database.db_connect;

/**
 *
 * @author Aquarius
 */
public class trackItem extends posi.sys.expeditors.popup {
    private int item_id;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JButton button;
    private db_connect db = new db_connect();
    
    private inventoryTable inv;
    
    private Object [][] data;
    
    public trackItem(){
        super(new java.awt.Dimension(800,650),"Track Item");
        this.getContentPane().add(searchTable());
        //this.content();
    }
    
    public trackItem(int itemId){
        super(new java.awt.Dimension(800,650),"Track Item");
        this.item_id = itemId;
        
        this.content();
    }
    public final javax.swing.JScrollPane searchTable(){        
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
    public final void content(){
        toolBar = new javax.swing.JToolBar();
        addToolbarContent(toolBar);        
        toolBar.setFloatable(true);
       // toolBar.setPreferredSize(new java.awt.Dimension(200, 30));
        add(toolBar,BorderLayout.PAGE_START); 
        //add(new javax.swing.JButton("Testing"),BorderLayout.CENTER);
    }
    
    private void addToolbarContent(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Clock.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Clock");
        button.addActionListener(new Action());
        button.setToolTipText("Open clock");
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Calendar.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Calendar");
        button.addActionListener(new Action());
        button.setToolTipText("Calendar application");
	button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Calc.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("calc");
        button.addActionListener(new Action());
        button.setToolTipText("Open calculator");
	button.setContentAreaFilled(false);
        toolbar.add(button);  
   }
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    public static void main(String [] args){
        new trackItem().setVisible(true);
    }
}
