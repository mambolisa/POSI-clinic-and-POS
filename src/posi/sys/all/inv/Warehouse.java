/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.expeditors.sundry;
import posi.sys.expeditors.utilityFunctions;

/**
 *
 * @author Aquarius
 */
public class Warehouse extends posi.sys.expeditors.popup {
    private javax.swing.JPanel panel , panel1, panel_1, panel_2;
    private javax.swing.JLabel label;
    private javax.swing.JButton button;
    private javax.swing.JSplitPane splitpane;
    
    private Object[][] data;
    private inventoryTable inv;
    
    private db_connect db = new db_connect();
    
    private javax.swing.JLabel label_list;
    private javax.swing.JPanel panel_min;
    private javax.swing.JComboBox combo;
    
    private javax.swing.JPanel panel_warehouse_l,panel_warehouse_r,panel_warehouse;
    private String item_index, item_bar_code;
    
    public Warehouse(){        
        super(new java.awt.Dimension(790,570),"Warehouse");
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.setBackground(Color.white);
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        splitpane = new javax.swing.JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitpane.setDividerLocation(80);
        splitpane.setEnabled(false);
        add_content();
    }
    
    private void add_content(){
        top_buttons();
        center_cont();
        
        splitpane.setLeftComponent(panel);
        splitpane.setRightComponent(panel1);
        
        add(splitpane);
        manage_warehouse();
    }
    
    private void center_cont(){
        
    }
    
    private void top_buttons(){
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.addMouseListener( new MouseListen( panel_1 ) );
        panel_1.addMouseMotionListener( new MouseListen( panel_1 ) );
        panel_1.setBackground(Color.white);
        label = new javax.swing.JLabel("Warehouses");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley1.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 14));
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manage_warehouse();
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(Color.white);
        panel_1.addMouseListener( new MouseListen( panel_1 ) );
        panel_1.addMouseMotionListener( new MouseListen( panel_1 ) );
        label = new javax.swing.JLabel("Warehouse transfer");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley3.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(warehouse_transfers());
                splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(Color.white);
        panel_1.addMouseListener( new MouseListen( panel_1 ) );
        panel_1.addMouseMotionListener( new MouseListen( panel_1 ) );
        label = new javax.swing.JLabel("Settings");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley2.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(warehouse_controls());
                splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
    }
    
    public void manage_warehouse(){  
        String sql = "SELECT warehouse_id , warehouse_name , warehouse_location, warehouse_status   FROM warehouses";
        
        data = db.getData( sql );
        
        final String [] columnNames = { "Warehouse num", "Warehouse name", "Warehouse location", "Warehouse status"};
        inv = new inventoryTable(data,columnNames){
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
   
       javax.swing.JPanel panel_ = new javax.swing.JPanel(new java.awt.BorderLayout());
       
       top_mid_buttons();
       
       label_list.setText("Warehouse list");
       
       panel_.add(panel_min, BorderLayout.PAGE_START);
       panel_.add(inv.tableScrollPane(), BorderLayout.CENTER);
                
       splitpane.setRightComponent ( panel_ );
       splitpane.setDividerLocation(80);
    }
  
    public void top_mid_buttons(){       
       panel_min = new javax.swing.JPanel(new java.awt.BorderLayout());
       panel_min.setPreferredSize(new java.awt.Dimension(780, 40));
       
       label_list = new javax.swing.JLabel();
       label_list.setFont ( new java.awt.Font ( java.awt.Font.DIALOG_INPUT, java.awt.Font.BOLD, 24 ) );
       
       panel_min.add( label_list , BorderLayout.CENTER );
       
       
       javax.swing.JButton button_add = new javax.swing.JButton("Add warehouse");
       button_add.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add_warehouse();
            }
        });
       javax.swing.JButton button_ = new javax.swing.JButton("List of warehouses");
       button_.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                manage_warehouse();
            }
        });
       
       javax.swing.JPanel pane = new javax.swing.JPanel();
       pane.setPreferredSize(new java.awt.Dimension(300, 25 ) );
       pane.add(button_add);
       pane.add(button_);
    
       panel_min.add( pane , BorderLayout.LINE_END );
    }
    
    public void add_warehouse(){
        top_mid_buttons();
        label_list.setText("Add warehouse");
        javax.swing.JPanel panel = new javax.swing.JPanel ( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );        
        
        panel.add(panel_min);        
        add_form( panel );
        
        splitpane.setRightComponent ( panel );
        splitpane.setDividerLocation(80);
    }
    
    public java.awt.Component warehouse_transfers(){
        panel_warehouse = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
     
        Object [] data_;
        
        data_ = db.getRow("SELECT warehouse_name FROM warehouses;");
        
        javax.swing.JList list = new javax.swing.JList(data_); //data has type Object[]
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(javax.swing.JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setSelectedIndex(0);
        
        javax.swing.JScrollPane listScroller = new javax.swing.JScrollPane(list);
        listScroller.setPreferredSize(new java.awt.Dimension( 150, 250 ) );

        panel_warehouse_l = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_warehouse_l.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Warehouses list ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51)));
        panel_warehouse_l.setPreferredSize(new java.awt.Dimension(180, 300));
        panel_warehouse_l.add(listScroller);
        
        panel_warehouse_r = new javax.swing.JPanel();
        
        panel_warehouse_r.add( warehouse_items ( ""+ ( list.getSelectedIndex() + 1 ) ) );
                
        panel_warehouse.add(panel_warehouse_l);
        //panel_warehouse.add( inv.tableScrollPane ( ) );
        panel_warehouse.add(panel_warehouse_r);
        
    return panel_warehouse;
    }
  
    private javax.swing.JScrollPane warehouse_items( String warehouse_id ){
        panel_warehouse_r.setPreferredSize(new java.awt.Dimension(570, 420));        
        panel_warehouse_r.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Items list ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51)));
        
        String sql = "SELECT item_id, item_default_bar_code,item_name,item_default_price,item_qty FROM items, warehouses WHERE item_warehouse_location = "+warehouse_id+" ";
        //System.out.println(sql);
        data = db.getData( sql );
        
        final String [] columnNames = { "Item Num", "Item code", "Item name", "Item price", "Item qty" };
         
        inv = new inventoryTable(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public void setPreferredSize(Dimension preferredSize) {
                super.setPreferredSize(new java.awt.Dimension(700, 350));
            }
            
        };
        
        inv.setRowHeight(28);
       // inv.setPreferredSize(new java.awt.Dimension(700, 350));
        
        inv.getColumnModel().getColumn(0).setPreferredWidth( 100 );
        inv.getColumnModel().getColumn(1).setPreferredWidth( 100 );
        inv.getColumnModel().getColumn(2).setPreferredWidth( 200 );
        inv.getColumnModel().getColumn(3).setPreferredWidth( 100 );
        inv.getColumnModel().getColumn(4).setPreferredWidth( 100 );
        
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
                       // panel_warehouse_r.setVisible(false);
                        
                        //panel_warehouse_r = new javax.swing.JPanel();
                       // panel_warehouse_r.add( item_transfer ( ) );

                        //panel_warehouse.add( panel_warehouse_l );
                        //panel_warehouse_r = null;//.add( item_transfer ( ) );
                    }
                }else if (javax.swing.SwingUtilities.isRightMouseButton(e)){
                   javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
        javax.swing.JScrollPane scrollpane = inv.tableScrollPane ( );
        scrollpane.setPreferredSize(new java.awt.Dimension(550, 390));     
        
    return scrollpane;
    }
   
    private javax.swing.JPanel item_transfer(){
        javax.swing.JPanel panel = new javax.swing.JPanel();
        
    return panel;
    }
    private void add_form(javax.swing.JPanel panel){
        javax.swing.JPanel panel_;
        javax.swing.JLabel label;
        javax.swing.JTextField textfield;
        javax.swing.JButton button_;
        
        javax.swing.JPanel panel_1  = new javax.swing.JPanel();
        panel_1.setPreferredSize(new java.awt.Dimension(450, 300));
        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New warehouse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse id");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        textfield = new javax.swing.JTextField(20);
        textfield.setPreferredSize(new java.awt.Dimension(200, 30));
        textfield.setEditable(false);
        panel_.add( textfield );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse name");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        textfield = new javax.swing.JTextField(20);
        textfield.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_.add( textfield );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse Location");
        label.setPreferredSize(new java.awt.Dimension(130, 30));
        panel_.add( label );        
        textfield = new javax.swing.JTextField(20);
        textfield.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_.add( textfield );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse status");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        javax.swing.JComboBox combo = new javax.swing.JComboBox(new Object[]{"Active","Inactive"});
        combo.setPreferredSize(new java.awt.Dimension(150, 30));
        panel_.add( combo );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.CENTER ) );
        label = new javax.swing.JLabel("");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );
        button_ = new javax.swing.JButton("Add warehouse");
        button_.addActionListener(new Action());
        button_.setActionCommand("add");
        panel_.add( button_ );
        
        button_ = new javax.swing.JButton("Cancel");
        button_.addActionListener(new Action());
        button_.setActionCommand("cancel");                     
        panel_.add(button_);
        
        panel_1.add( panel_);
        
        panel.add(panel_1);
    }
    
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if("add".equals(e.getActionCommand())){
                
            }else if("cancel".equals(e.getActionCommand())){
                manage_warehouse();
            }
        }
        
    }
    public java.awt.Component warehouse_controls(){
        return new javax.swing.JButton("");
    }
    public static void main(String [] args){
        new Warehouse().setVisible(true);
    }
    
    class MouseListen implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener{
        javax.swing.JPanel innerPanel = null;
        
        public MouseListen(javax.swing.JPanel panel_){
            innerPanel = panel_;
        }
        @Override
        public void mouseClicked(MouseEvent e) {               
          /*  setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            innerPanel.setBackground(Color.LIGHT_GRAY);             
            * 
            */
        }

        @Override
        public void mousePressed(MouseEvent e) {  }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) {  }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void mouseDragged(MouseEvent e) {  }

        @Override
        public void mouseMoved(MouseEvent e) {  
           /* java.awt.Rectangle r = new java.awt.Rectangle(innerPanel.getBounds().x+innerPanel.getWidth(),innerPanel.getBounds().y+innerPanel.getHeight());
            panel_1.setBackground(Color.WHITE);
            
            if( r.contains ( e.getX ( ) , e.getY ( ) ) ){   
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                innerPanel.setBackground(Color.LIGHT_GRAY);               
            }else{
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                innerPanel.setBackground(Color.WHITE); 
            }*/
        }
        
    }
}
