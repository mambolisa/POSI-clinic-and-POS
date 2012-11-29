/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import jxl.format.Border;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.inventoryTable;
import posi.sys.expeditors.sundry;


/**
 *
 * @author Aquarius
 */
public class POS extends posi.sys.expeditors.popup {
    private javax.swing.JMenuItem menuitem;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenu menu ;
    private javax.swing.JButton button;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane tabbedPane;
    
    private javax.swing.JTextField textfield;
    private javax.swing.JLabel label;
    private javax.swing.JTable table;
    
    private db_connect db = new db_connect();
    
    private String [] columnNames = {"Item bar code","Item Name","Item qty","Price","Discount","Total"};
    private Object [][] data ;
    public POS(){
        super(new java.awt.Dimension(970,670),"Point of sale");
         //System,Metal, Motif, GTK
        new posi.sys.expeditors.LooknFeel("Metal");
        
        menubar = new javax.swing.JMenuBar();
        
        menu = new javax.swing.JMenu("Actions");
        
        menuitem = new javax.swing.JMenuItem("New Sales ");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Search Item");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Print reciept");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK ));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Print invoice");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Items catalogue");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Close");        
        menu.add(menuitem);
        
        menubar.add(menu);
        
        menu = new javax.swing.JMenu("Transactions");        
        menuitem = new javax.swing.JMenuItem("Sales return");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_R, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menuitem = new javax.swing.JMenuItem("Customers window");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_C,ActionEvent.SHIFT_MASK));
        menu.add(menuitem);
        menubar.add(menu);
        
        setJMenuBar(menubar);
        
        panel= new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        toolBar = new javax.swing.JToolBar();
        addToolbarContent(toolBar);        
        toolBar.setFloatable(false);
        toolBar.setPreferredSize(new java.awt.Dimension(350, 40));
        panel.add(toolBar); 
        
        toolBar = new javax.swing.JToolBar();
        addToolbarContent_2(toolBar);        
        toolBar.setFloatable(false);
        toolBar.setPreferredSize(new java.awt.Dimension(200, 40));
        panel.add(toolBar); 
        
        toolBar = new javax.swing.JToolBar();
        addToolbarContent_3(toolBar);        
        toolBar.setFloatable(false);
        toolBar.setPreferredSize(new java.awt.Dimension(395, 40));
        panel.add(toolBar); 
        
        add(panel,BorderLayout.PAGE_START);
        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addTab("Sales catalogue",addSalesTable());
               
        add(tabbedPane,BorderLayout.CENTER);
        
        toolBar = new javax.swing.JToolBar();
        addToolbarContent_4(toolBar);        
        toolBar.setFloatable(false);
        toolBar.setPreferredSize(new java.awt.Dimension(300, 50));
        add(toolBar,BorderLayout.PAGE_END);
    }
    
    private void addToolbarContent(javax.swing.JToolBar toolbar){
        textfield = new javax.swing.JTextField(30);
        textfield.setPreferredSize(new java.awt.Dimension(150, 50));
        textfield.setActionCommand("inputText");
        textfield.addKeyListener( new KeyListen());
        toolbar.add(textfield); 
        
        button = new javax.swing.JButton("Go");
        button.setPreferredSize(new java.awt.Dimension(80, 60));
        button.setActionCommand("SearchItem");
        button.addActionListener( new Action());
        toolbar.add(button); 
   }    
    
private void addToolbarContent_2(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("PrintReciept");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Document new.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("NewSales");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("Search");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button);
   }    
    
    private void addToolbarContent_3(javax.swing.JToolBar toolbar){
        java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("     k:m:s");
        java.util.Date dt = new java.util.Date();
        String dshow = date.format(dt)+" AM";
        
        label = new javax.swing.JLabel();
        label.setPreferredSize(new java.awt.Dimension(150, 40));
        label.setText( dshow);
        label.setForeground(Color.black);
        toolbar.add(label); 
        
        label = new javax.swing.JLabel();
        label.setPreferredSize(new java.awt.Dimension(140, 40));
        label.setText( "User: "+"Administrator");
        label.setForeground(Color.darkGray);
        toolbar.add(label); 
        
        label = new javax.swing.JLabel();
        label.setPreferredSize(new java.awt.Dimension(140, 40));
        label.setText( "Session: " + 1);
        label.setForeground(Color.BLUE);
        toolbar.add(label); 
   } 
    
    private void addToolbarContent_4(javax.swing.JToolBar toolbar){
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new java.awt.Dimension(550, 100));
        addButtons(panel);
        toolbar.add(panel); 
        
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new java.awt.Dimension(100, 100));
        right_panel(panel) ;
        
        toolbar.add(panel); 
   }
    
   private void right_panel(javax.swing.JPanel panel){
        java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dt = new java.util.Date();
        String dshow = date.format(dt);
        
        button = new javax.swing.JButton(dshow);
        button.setContentAreaFilled(false);
        button.setForeground(Color.GRAY);
        //button.setFont();
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
       panel.add(button);
   }
   
   private void addButtons(javax.swing.JPanel panel){
       javax.swing.JButton button;
       
       button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow3 Left.gif", new java.awt.Dimension(25, 40)));
       button.setActionCommand("left_scroll");
       button.addActionListener( new Action());
       button.setPreferredSize(new java.awt.Dimension(25,40));
       button.setContentAreaFilled(false);
       
       panel.add(button);
       
       for(int i = 1; i <= 5; i++ ){
           String item_name = "Item "+i;
           button = new javax.swing.JButton(item_name);
           int item_width = item_name.length()*15;
           if(item_width > 130)
               item_width = 130;
           button.setPreferredSize(new java.awt.Dimension(item_width, 40));
           panel.add(button);
       }
       
       button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow3 Right.gif", new java.awt.Dimension(25, 40)));
       button.setActionCommand("right_scroll");
       button.addActionListener( new Action());
       button.setPreferredSize(new java.awt.Dimension(25,40));
       button.setContentAreaFilled(false);
       
       panel.add(button);
   }
   
    public final javax.swing.JScrollPane addSalesTable(){
        int cols = 6, rows = 16;
        data = new Object[rows][cols];
        for ( int i = 0; i < rows; i++ ){
            for ( int j = 0; j < cols-1; j++ ){
                data[i][j] = "";
            }
        }
        new inventoryTable(data,columnNames);
        table = inventoryTable.table();
        table.setRowHeight(29);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        scrollpane = inventoryTable.tableScrollPane();
        
        return scrollpane;
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    class KeyListen implements java.awt.event.KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyChar = e.getKeyCode();
            if(keyChar == 10){
                addRowItem(textfield.getText());
            }
        }        
    }
    
    public void addRowItem(String itemName){
       String sql = "SELECT * from items WHERE item_default_bar_code='"+itemName+"' OR item_name='"+itemName+"' LIMIT 1;";
       Object[] row = db.getRow(sql);
       
       
    }
    
    public static void main(String [] args){
        new POS().setVisible(true);
    }
    
    private javax.swing.JScrollPane scrollpane;
}

