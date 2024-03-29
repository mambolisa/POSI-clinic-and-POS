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
import posi.sys.all.inv.invTables;
import posi.sys.all.inv.inventoryMngt;
import posi.sys.expeditors.utilityFunctions;
import posi.sys.expeditors.sundry;


/**
 *
 * @author Aquarius
 */
public class POS extends posi.sys.expeditors.popup {
    private javax.swing.JMenuItem menuitem;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenu menu ;
    private static javax.swing.JButton button,buttonQty,buttonTotal,buttonDisc;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel panel,panel2;
    private javax.swing.JTabbedPane tabbedPane;
    
    private static javax.swing.JTextField textfield;
    private javax.swing.JLabel label,labelTime;
    
    private static invTables inv;
   
    private static int default_num_rows = 15;
    
    private static db_connect db = new db_connect();
    
    private java.util.Vector columnNames ;
    private java.util.Vector data ;
    
    private boolean sellAll = false;
    public POS(){
        super(new java.awt.Dimension(990,675),"Point of sale");
         //System,Metal, Motif, GTK
        new posi.sys.expeditors.LooknFeel("Metal");
        
        menubar = new javax.swing.JMenuBar();
        
        menu = new javax.swing.JMenu("Actions");
        
        menuitem = new javax.swing.JMenuItem("New Sales ", sundry.createImageIcon("images/Document new.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ));
        menuitem.setActionCommand("new_sales");
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Search Item", sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ));
        menuitem.setActionCommand("search_item"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Complete sale", sundry.createImageIcon("images/Cart.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("Sell"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Print reciept");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK ));
        menuitem.setActionCommand("print_reciept");        
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Print invoice");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("print_invoice");
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menu.addSeparator();
        menuitem = new javax.swing.JMenuItem("Items catalogue");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("item_catalogue");
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Close"); 
        menuitem.setActionCommand("close");
        menuitem.addActionListener(new Action());
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
        toolBar.setPreferredSize(new java.awt.Dimension(getWidth() - 350 - 20, 40));
        panel.add(toolBar); 
        
        //toolBar = new javax.swing.JToolBar();
        addToolbarContent_3(toolBar);        
        //toolBar.setFloatable(false);
        //toolBar.setPreferredSize(new java.awt.Dimension(395, 40));
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
        button.setActionCommand("Go");
        button.addActionListener( new Action());
        toolbar.add(button); 
   }    
    
private void addToolbarContent_2(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("print_reciept");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Document new.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("new_sales");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("Customer");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));
        button.setActionCommand("search_item");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Cart.gif", new java.awt.Dimension(34, 32)));
        button.setPreferredSize( new java.awt.Dimension(34, 32));        
        button.setActionCommand("Sell");
        button.addActionListener( new Action());
	button.setContentAreaFilled(false);
        toolbar.add(button);
   }    
    
    private void addToolbarContent_3(javax.swing.JToolBar toolbar){        
        labelTime = new javax.swing.JLabel(new java.text.SimpleDateFormat("     HH:mm:ss a").format(new java.util.Date()));

        new javax.swing.Timer(1000,new java.awt.event.ActionListener() {
            @Override
             public void actionPerformed(ActionEvent arg0) {
                date = new java.text.SimpleDateFormat("     HH:mm:ss a");
                dt = new java.util.Date();
                dshow = date.format(dt);
                labelTime.setText( dshow );
            }
        }).start();        
        
        
        labelTime.setPreferredSize(new java.awt.Dimension(200, 40));
        labelTime.setForeground(Color.black);
        labelTime.setText( dshow );
        toolbar.add(labelTime); 
        
        label = new javax.swing.JLabel();
        label.setPreferredSize(new java.awt.Dimension(220, 40));
        label.setText( "User: "+ inventoryMngt.get_user_info()[1]);
        label.setForeground(Color.darkGray);
        toolbar.add(label); 
        
        label = new javax.swing.JLabel();
        label.setPreferredSize(new java.awt.Dimension(200, 40));
        label.setText( "Session: " + inventoryMngt.get_user_info()[7]);
        label.setForeground(Color.BLUE);
        toolbar.add(label); 
   } 
    
    private void addToolbarContent_4(javax.swing.JToolBar toolbar){   
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new java.awt.Dimension(450, 100));
        addButtons(panel);
        toolbar.add(panel); 
        
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new java.awt.Dimension(300, 100));
        right_panel(panel) ;
        
        toolbar.add(panel); 
   }
    
   private void right_panel(javax.swing.JPanel panel){
        buttonQty = new javax.swing.JButton("0");
        buttonQty.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonQty.setContentAreaFilled(false);
        buttonQty.setForeground(Color.magenta);
        buttonQty.setFont(new Font("Verdana", Font.BOLD, 14));
        panel.add(buttonQty);
        
        button = new javax.swing.JButton("");
        button.setPreferredSize(new java.awt.Dimension(90, 40));
        button.setContentAreaFilled(false);
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button.setForeground(Color.magenta);
        panel.add(button);
        
        buttonDisc = new javax.swing.JButton("0.00");
        buttonDisc.setPreferredSize(new java.awt.Dimension(90, 40));
        buttonDisc.setContentAreaFilled(false);
        buttonDisc.setFont(new Font("Verdana", Font.BOLD, 14));
        buttonDisc.setForeground(Color.magenta);
        panel.add(buttonDisc);
        
        buttonTotal = new javax.swing.JButton("0.00");
        buttonTotal.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonTotal.setContentAreaFilled(false);
        buttonTotal.setFont(new Font("Verdana", Font.BOLD, 14));
        buttonTotal.setForeground(Color.magenta);//button.setFont();
        //button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(buttonTotal);
   }
   
   private void addButtons(javax.swing.JPanel panel){
       javax.swing.JButton button;
       
       button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow3 Left.gif", new java.awt.Dimension(25, 40)));
       button.setActionCommand("scroll_left");
       button.addActionListener( new Action());
       button.setPreferredSize(new java.awt.Dimension(25,35));
       button.setContentAreaFilled(false);
       
       panel.add(button);
       
       panel2 = new javax.swing.JPanel();
       POS_scroll_items.makeScrollButtons(panel2);       
       panel.add(panel2);
       
       button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow3 Right.gif", new java.awt.Dimension(25, 40)));
       button.setActionCommand("scroll_right");
       button.addActionListener( new Action());
       button.setPreferredSize(new java.awt.Dimension(25,35));
       button.setContentAreaFilled(false);
       
       panel.add(button);
   }
      
   public void addDefaultRows(){               
        for (int i = 1; i <= default_num_rows; i++ ){
            Object [] row = {"","","","",""};
            ( (javax.swing.table.DefaultTableModel) inv.getModel() ).addRow( row );
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
        
        inv = new invTables(data,columnNames){
            @Override
            public void setAutoCreateRowSorter(boolean autoCreateRowSorter) {
                super.setAutoCreateRowSorter(false);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                if ( column == 0 || column ==5 )
                    return false;
                else
                    return true;
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                if("".equals(inv.getModel().getValueAt(row, 0).toString()))
                    return;
                
                if("".equals(aValue.toString()) || super.getValueAt(row,0) == null)
                    return;
                if(column == 1){//BAR code
                        
                }else if (column == 2){//item name
                        
                }else if (column == 3){//qty
                    Object [] qty = POS.getItemQty(this.getValueAt(row, 1).toString());
                    int avail_qty = 0;
                    
                    if(sellAll){
                        avail_qty = Integer.parseInt(qty[0].toString());
                    }else{
                        avail_qty = Integer.parseInt(qty[0].toString())- Integer.parseInt(qty[1].toString());//avail - min qty
                    }
                    
                    if( Integer.parseInt(aValue.toString()) > avail_qty ){
                        JOptionPane.showMessageDialog(null, "Requested item quanitity is not available,\n Available quantity is " + avail_qty, "Warning message", JOptionPane.WARNING_MESSAGE);
                        return;
                    }else{
                        super.setValueAt(aValue, row, column);
                        double total = Double.parseDouble(this.getValueAt(row, 4).toString()) * Integer.parseInt(aValue.toString());
                        super.setValueAt(total, row, 6);
                    }
                }else if (column == 4){//price
                    Object [] price = POS.getItemPrice(this.getValueAt(row, 1).toString());
                    double min_price =  Double.parseDouble(price[1].toString());
                    
                    if( Double.parseDouble(aValue.toString()) < min_price){
                        JOptionPane.showMessageDialog(null, "Price too low. \n Minimum price is " + min_price, "Warning message", JOptionPane.WARNING_MESSAGE);
                        return;
                    }else{
                        super.setValueAt(aValue, row, column);
                        double total = Integer.parseInt(this.getValueAt(row, 3).toString()) * Double.parseDouble(aValue.toString());
                        super.setValueAt(total, row, 6);
                    }  
                }else if (column == 5){//Discount
                    
                }else if (column == 6){//Total
                    
                }
                updateFooterQty();
            }
        };
        inv.getTableHeader().setReorderingAllowed(false);
        inv.getTableHeader().setResizingAllowed(false);
        inv.setAutoCreateRowSorter(false);
        
        inv.setRowHeight(29);
        
        //set column widths
        inv.getColumnModel().getColumn(0).setPreferredWidth(50);
        inv.getColumnModel().getColumn(1).setPreferredWidth(110);
        inv.getColumnModel().getColumn(2).setPreferredWidth(320);
        inv.getColumnModel().getColumn(3).setPreferredWidth(70);
        inv.getColumnModel().getColumn(4).setPreferredWidth(70);
        inv.getColumnModel().getColumn(5).setPreferredWidth(70);
        
        
        addDefaultRows();       
        
        inv.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                 if (SwingUtilities.isRightMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   
                   int rowNum = inv.rowAtPoint(p);
                   Object itemCode =  inv.getModel().getValueAt(rowNum, 0);
                   
                   if(itemCode == "") {
                        return;
                    }
                   
                   javax.swing.JPopupMenu popup = new utilityFunctions().salesCatRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
        });
        
       scrollpane = inv.tableScrollPane();//.tableScrollPane();
        
        return scrollpane;
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if("scroll_left".equals( e.getActionCommand())){ 
                String prev = "prev";
                POS_scroll_items.scrollItems(panel2, prev);
            }else if("scroll_right".equals( e.getActionCommand())){
                String next = "next";
                POS_scroll_items.scrollItems(panel2, next);
            }else if("scroll_left".equals( e.getActionCommand())){
                
            }else if("close".equals( e.getActionCommand())){
                dispose();
            }else if("new_sales".equals( e.getActionCommand())){
                dispose();
                 new POS().setVisible(true);
            }else if("search_item".equals( e.getActionCommand())){
                new posi.sys.search.Search(){
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                           addRowItem(get_item_bar_code());
                           super.setVisible(false);
                        }else
                             super.setVisible(b);
                    }
                }.setVisible(true);               
            }else if("print_reciept".equals( e.getActionCommand())){                
                
            }else if("item_catalogue".equals( e.getActionCommand())){
                
            }else if("Customer".equals( e.getActionCommand())){
                new posi.sys.search.SearchPersons("cust"){ 
                    @Override
                    public void hide_cust_add(){
                        super.hide_cust_add();
                    }
                    
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                             cust_index = get_index();
                             super.setVisible( true );
                        }else {
                            super.setVisible( true );
                        }
                    }
                    
                    @Override
                    public void setTitle(String title){
                        super.setTitle("Search customers");
                    }
                    
                }.setVisible(true);
            }else if("Go".equals( e.getActionCommand())){
                addRowItem(textfield.getText());
            }else if("Sell".equals( e.getActionCommand())){
                //info -> amount,disc,qty,invoice_id,user_rep, session, time
                //buttonQty,buttonTotal,buttonDisc
                Object [] obj = new Object[]{
                                                buttonTotal.getText(),//total
                                                buttonDisc.getText(), //disc
                                                buttonQty.getText(), // qty
                                                "",//invoice_id
                                                "",//user_rep
                                                "",//session
                                                dshow,//time
                                            };
                new PosSale( obj ).setVisible(true);
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
                textfield.setText("");
            }
        }        
    }
    
    public static void addRowItem(String itemName){
       String sql = "SELECT item_id,item_default_bar_code,item_name,item_default_price,(item_default_price-item_default_min_price) from items WHERE item_default_bar_code='"+itemName+"' LIMIT 1;";
       Object[][] data = (Object[][])db.getData(sql);
       
       if( data.length == 0){
            JOptionPane.showMessageDialog(null, "No such item exists!!", "Error message!", JOptionPane.ERROR_MESSAGE);
            textfield.setText("");
            return;
       }
       double disc = round2Decimal(Double.parseDouble(data[0][3].toString()));//- Double.parseDouble(data[0][3].toString());
       double total = round2Decimal(Double.parseDouble(data[0][3].toString()) * 1);
       
       Object [] row = {data[0][0],data[0][1],data[0][2],"1",data[0][3],disc,total };
       
       Object [] info = rowInfo(data[0][1].toString());
       if(info[0] != null){
            if("true".equals(info[0].toString()) ){
                Object [] qty = getItemQty(data[0][1].toString());
                
                int availQty = Integer.parseInt(qty[0].toString());
                int newQty = Integer.parseInt(info[2].toString())+1;
                int minQty = Integer.parseInt(qty[1].toString());
                double newTotal = 0;
                
                if(newQty < availQty && (availQty - newQty) > minQty ) {
                    inv.getModel().setValueAt(newQty, Integer.parseInt(info[1].toString()), 3); // updating items in list
                   
                    newTotal = (Integer.parseInt(info[2].toString()) * Double.parseDouble(inv.getModel().getValueAt(Integer.parseInt(info[1].toString()),4).toString()));
                    newTotal = round2Decimal(newTotal);
                    
                    inv.getModel().setValueAt((newTotal), Integer.parseInt(info[1].toString()), 6);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No more items available!", "Warning message", JOptionPane.WARNING_MESSAGE);
                }
            }else{                
                ( (javax.swing.table.DefaultTableModel) inv.getModel() ).insertRow( 0, row); // consequent adding items to list      
                
            }
       }else{
           if(inv.getModel().getRowCount() > default_num_rows ){
                int nextAvail = getNextAvailRow();

                if(nextAvail != 0){
                     inv.getModel().setValueAt(data[0][0], nextAvail, 0); 
                     inv.getModel().setValueAt(data[0][1], nextAvail, 1);
                     inv.getModel().setValueAt(data[0][2], nextAvail, 2);
                     inv.getModel().setValueAt("1", nextAvail, 3);
                     inv.getModel().setValueAt(round2Decimal(Double.parseDouble(data[0][3].toString())), nextAvail, 4);
                     inv.getModel().setValueAt(round2Decimal(disc), nextAvail, 5);
                     inv.getModel().setValueAt(round2Decimal(total), nextAvail, 6);
                }else{
                     ( (javax.swing.table.DefaultTableModel) inv.getModel() ).addRow( row); // consequent adding items to list
                }
           }else{
                     ( (javax.swing.table.DefaultTableModel) inv.getModel() ).insertRow( 0, row); // consequent adding items to list
                }
       }
       
       updateFooterQty();
    }

    
    public void removeRow(int rowIndex){
        
    }
    
    private static void updateFooterQty(){
        int rows = inv.getModel().getRowCount();
        double totalAll = 0,  discAll = 0;
        int qtyAll = 0;
        for(int i = 0; i < rows; i++ ){
           if(!"".equals(inv.getModel().getValueAt(i, 0).toString())){
              qtyAll   += (!"".equals(inv.getValueAt(i, 3).toString()) ) ? Integer.parseInt(inv.getValueAt(i, 3).toString()) : 0;
              discAll  += (!"".equals(inv.getValueAt(i, 5).toString())) ? Double.parseDouble(inv.getValueAt(i, 5).toString()) : 0.00;
              totalAll += (!"".equals(inv.getValueAt(i, 6).toString())) ? Double.parseDouble(inv.getValueAt(i, 6).toString()): 0.00; 
           }
        }
        
        buttonQty.setText(""+qtyAll);
        buttonDisc.setText(""+round2Decimal(discAll));
        buttonTotal.setText(""+round2Decimal(totalAll));
    }
    
    private static double round2Decimal(double num){
        java.text.DecimalFormat twoDForm = new java.text.DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(num));  
    }
    
    private static Object[] rowInfo(String itemCode){
        Object [] info = new Object[3];
        
        int max = inv.getRowCount();
        
        for (int i = 0; i< max; i++){
            if(itemCode.equals(inv.getModel().getValueAt(i, 1))){
                info[0] = "true"; //test if available
                info[1] = i;//row num
                info[2] = inv.getModel().getValueAt(i, 3);  //item cat qty
                
            }
        }
        return info;
    }
     
    private static int getNextAvailRow(){
        int max = inv.getRowCount();
        int availRow = 0;
        
        for (int i = 0; i< max; i++){
            if("".equals(inv.getModel().getValueAt(i, 0))){
                availRow = i;
                return availRow;
            }
        }
        return availRow;
    }
    
    public static Object[] getItemQty(String item){
        String sql = "SELECT item_qty,item_min_qty FROM items WHERE item_default_bar_code = '"+item+"';";
        Object [][] row = db.getData(sql);
        Object [] info = new Object[2];
        info[0] = Integer.parseInt(row[0][0].toString());    
        info[1] = Integer.parseInt(row[0][1].toString()); ;
    return info;
    }
    
    public static Object[] getItemPrice(String item){
        String sql = "SELECT item_default_price,item_default_min_price,item_default_per_disc FROM items WHERE item_default_bar_code = '"+item+"';";
        Object [][] row = db.getData(sql);
        Object [] info = new Object[3];
        info[0] = Double.parseDouble(row[0][0].toString());    
        info[1] = Double.parseDouble(row[0][1].toString()); 
        info[2] = Integer.parseInt(row[0][2].toString()); 
    return info;
    }
    
    public static void main(String [] args){
        new POS().setVisible(true);
    }
    
    private javax.swing.JScrollPane scrollpane;
    private  java.text.SimpleDateFormat date;
    java.util.Date dt;
    String dshow, cust_index;
}
