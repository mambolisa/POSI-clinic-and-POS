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
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.inventoryTable;
import posi.sys.all.inv.utilityFunctions;
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
    private inventoryTable table;
    
    private int scroll_end;
    private int scroll_interval;
    private int scroll_current;
    
    private int default_num_rows = 16;
    
    private db_connect db = new db_connect();
    
    private java.util.Vector columnNames ;
    private java.util.Vector data ;
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
        scroll_interval = 5;
        scroll_end = db.getData("SELECT * FROM items").length;
        
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
       
       makeScrollButtons(panel);
       
       button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow3 Right.gif", new java.awt.Dimension(25, 40)));
       button.setActionCommand("right_scroll");
       button.addActionListener( new Action());
       button.setPreferredSize(new java.awt.Dimension(25,40));
       button.setContentAreaFilled(false);
       
       panel.add(button);
   }
   
   private void makeScrollButtons(javax.swing.JPanel panel){
       for(int i = 1; i <= scroll_interval; i++ ){
           String item_name = "Item "+i;
           button = new javax.swing.JButton(item_name);
           int item_width = item_name.length()*15;
           if(item_width > 130)
               item_width = 130;
           button.setPreferredSize(new java.awt.Dimension(item_width, 40));
           panel.add(button);
       }
   }
   
   public void addDefaultRows(){               
        for (int i = 0; i< default_num_rows; i++ ){
            Object [] row = {"","","","",""};
            ( (javax.swing.table.DefaultTableModel) table.getModel() ).addRow( row);
        }
   }
   
    public final javax.swing.JScrollPane addSalesTable(){
        data = new java.util.Vector();
        columnNames  = new java.util.Vector();

        columnNames.addElement("Item ID");
        columnNames.addElement("Item bar code");
        columnNames.addElement("Item Name");
        columnNames.addElement("Item qty");
        columnNames.addElement("Price");
        columnNames.addElement("Discount");
        columnNames.addElement("Total");
        
        table = new inventoryTable(data,columnNames);
          
        table.setRowHeight(29);
        //set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(110);
        table.getColumnModel().getColumn(2).setPreferredWidth(320);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
         
        addDefaultRows();       
        
        table.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                if (SwingUtilities.isRightMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   
                   int rowNum = table.rowAtPoint(p);
                   Object itemCode =  table.getModel().getValueAt(rowNum, 0);
                   javax.swing.JPopupMenu popup = new utilityFunctions().salesCatRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
        });
        
        
        scrollpane = table.tableScrollPane();//.tableScrollPane();
        
        return scrollpane;
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if("scroll_left".equals( e.getActionCommand())){
                int start = ((scroll_current - scroll_interval) < 0 )? 0 : (scroll_current - scroll_interval) ;
                scrollItem(start);
            }else if("scroll_right".equals( e.getActionCommand())){
                int start = ((scroll_current + scroll_interval) > scroll_end )? scroll_current : (scroll_current + scroll_interval) ;
                scrollItem(start);
            }else if("scroll_left".equals( e.getActionCommand())){
                
            }
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
       String sql = "SELECT item_id,item_default_bar_code,item_name,item_default_price,item_default_min_price from items WHERE item_default_bar_code='"+itemName+"' LIMIT 1;";
       Object[][] data = (Object[][])db.getData(sql);
       
       if( data.length == 0){
            JOptionPane.showMessageDialog(null, "No such item exists!!", "Error message!", JOptionPane.ERROR_MESSAGE);
            textfield.setText("");
            return;
       }
       double disc = Double.parseDouble(data[0][3].toString()) ;//- Double.parseDouble(data[0][3].toString());
       double total = Double.parseDouble(data[0][3].toString()) * 1;
       
       Object [] row = {data[0][0],data[0][1],data[0][2],"1",data[0][3],disc,total };
       
       Object [] info = rowInfo(data[0][1].toString());
       if(info.length > 0 && info[0] != null){
            if("true".equals(info[0].toString()) ){
                Object [] qty = getDbItemQty(data[0][1].toString());
                
                int availQty = Integer.parseInt(qty[0].toString());
                int newQty = Integer.parseInt(info[2].toString())+1;
                int minQty = Integer.parseInt(qty[1].toString());
                
                if(newQty < availQty && (availQty - newQty) > minQty ) {
                    table.getModel().setValueAt(newQty, Integer.parseInt(info[1].toString()), 3);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No more items available!", "Warning message", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                ( (javax.swing.table.DefaultTableModel) table.getModel() ).insertRow( 0, row);
            }
       }else{
           ( (javax.swing.table.DefaultTableModel) table.getModel() ).insertRow( 0, row);
       }
       
       updateFooterQty();
    }

    
    public void removeRow(int rowIndex){
        
    }
    
    private void updateFooterQty(){
        
    }
    
    private void scrollItem(int start){        
        String sql = "SELECT ";
        
    }
    
    private void commitSales(){
        
    }
    
    private void printReciept(){
        
    }
    
    private void showQRCode(){
        
    }
    
    private Object[] rowInfo(String itemCode){
        Object [] info = new Object[3];
        
        int max = table.getRowCount();
        
        for (int i = 0; i< max; i++){
            if(itemCode.equals(table.getModel().getValueAt(i, 1))){
                info[0] = "true"; //test if available
                info[1] = i;//row num
                info[2] = table.getModel().getValueAt(i, 3);  //item cat qty
                
            }
        }
        return info;
    }
    
    
    public Object[] getDbItemQty(String item){
        String sql = "SELECT item_qty,item_min_qty FROM items WHERE item_default_bar_code = '"+item+"';";
        Object [][] row = db.getData(sql);
        Object [] info = new Object[2];
        info[0] = Integer.parseInt(row[0][0].toString());    
        info[1] = Integer.parseInt(row[0][1].toString()); ;
    return info;
    }
    
    public static void main(String [] args){
        new POS().setVisible(true);
    }
    
    private javax.swing.JScrollPane scrollpane;
}
