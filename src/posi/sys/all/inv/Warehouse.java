/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;
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
    private invTables inv , inv_items;
    
    private db_connect db = new db_connect();
    
    private javax.swing.JLabel label_list;
    private javax.swing.JPanel panel_min;
    private javax.swing.JComboBox combo;
    
    private javax.swing.JPanel panel_warehouse_l,panel_warehouse_r,panel_warehouse;
    private String item_index, item_bar_code, warehouse_to_index;
    
    private javax.swing.JComboBox combo_status;
    
    private javax.swing.JTextField textfield_item_id, warehouse_from, item_name, warehouse_to, item_transfer_qty, transfer_date, transfer_price;
    
    private javax.swing.JTextField textfield_w_name, textfield_w_location, textfield_w_id;
    
    javax.swing.JList list;
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
        
        
       inv.setMouseListener(new java.awt.event.MouseAdapter() {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
               if (SwingUtilities.isLeftMouseButton(e)){
                   if( e.getClickCount() >= 2 ){
                        java.awt.Point p = e.getPoint();

                        int rowNum = inv.table().rowAtPoint(p);
                        if(rowNum != -1){
                            Object itemCode =  data[rowNum][0];
                            top_mid_buttons();
                            label_list.setText("Edit Warehouse "+ data[rowNum][1].toString());
                            javax.swing.JPanel panel = new javax.swing.JPanel ( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );        

                            panel.add(panel_min);        
                            add_form( panel , "Edit warehouse details", true, itemCode.toString());

                            splitpane.setRightComponent ( panel );
                            splitpane.setDividerLocation(80);
                        }
                   }
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
    public void top_mid_buttons_warehouse_transfer(){       
       panel_min = new javax.swing.JPanel(new java.awt.BorderLayout());
       panel_min.setPreferredSize(new java.awt.Dimension(this.getWidth() - 15 , 40));
       
       label_list = new javax.swing.JLabel();
       label_list.setFont ( new java.awt.Font ( java.awt.Font.DIALOG_INPUT, java.awt.Font.BOLD, 24 ) );
       
       panel_min.add( label_list , BorderLayout.CENTER );

       javax.swing.JButton button_ = new javax.swing.JButton("<< Back");
       button_.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                splitpane.setRightComponent(warehouse_transfers());
                splitpane.setDividerLocation(80);
            }
        });
       
       javax.swing.JPanel pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
       pane.setPreferredSize(new java.awt.Dimension(350, 25 ) );
       pane.add(button_);
    
       panel_min.add( pane , BorderLayout.LINE_END );
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
        add_form( panel , "New warehouse", false, null);
        
        splitpane.setRightComponent ( panel );
        splitpane.setDividerLocation(80);
    }
    
    public java.awt.Component warehouse_transfers(){
        panel_warehouse = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        Object [] data_;
        
        data_ = db.getColData("SELECT warehouse_name FROM warehouses;");
        
        list = new javax.swing.JList(data_); //data has type Object[]
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(javax.swing.JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setSelectedIndex(0);
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener(){
             
            @Override
            public void valueChanged(ListSelectionEvent e) {
                javax.swing.JList list = (javax.swing.JList) e.getSource();
                
                Object [] id = db.getRow("SELECT warehouse_id FROM warehouses WHERE warehouse_name='"+list.getSelectedValue()+"'");
                warehouse_update_table( id[0].toString() );
            }
            
        });
        
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
  
    private void warehouse_update_table(String id){
        String sql = "SELECT item_id, item_default_bar_code,item_name,item_default_price,item_qty FROM items WHERE item_warehouse_location = "+id+" ";
        System.out.println(sql);
        data = db.getData( sql );
        
        
        //inv.getModel().
        
        //javax.swing.table.TableModel model = (javax.swing.table.TableModel) inv_items.getModel();
        javax.swing.table.AbstractTableModel main_model = (javax.swing.table.AbstractTableModel) inv_items.getModel();
        main_model.fireTableDataChanged();
        
    }
    private javax.swing.JScrollPane warehouse_items( String warehouse_id ){
        panel_warehouse_r.setPreferredSize(new java.awt.Dimension(570, 420));        
        panel_warehouse_r.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Items list ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51)));
        
        String sql = "SELECT item_id, item_default_bar_code,item_name,item_default_price,item_qty FROM items WHERE item_warehouse_location = "+warehouse_id+" ";
       // System.out.println(sql);
        data = db.getData( sql );
        
        final String [] columnNames = { "Item Num", "Item code", "Item name", "Item price", "Item qty" };
         
        inv_items = new invTables( data, columnNames ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public void setPreferredSize(Dimension preferredSize) {
                super.setPreferredSize(new java.awt.Dimension(700, 350));
            } 

            @Override
            public void setModel(TableModel dataModel) {
                super.setModel(new javax.swing.table.AbstractTableModel(){

                    @Override
                    public int getRowCount() {
                        return data.length;
                    }

                    @Override
                    public int getColumnCount() {
                        return columnNames.length;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return data[rowIndex][columnIndex];
                    }
                    
                });
            }
            
        };
        
        inv_items.setRowHeight(28);
       inv_items.getColumnModel().getColumn(0).setHeaderValue((Object)"Item Num");
       inv_items.getColumnModel().getColumn(1).setHeaderValue((Object)"Item code");
       inv_items.getColumnModel().getColumn(2).setHeaderValue((Object)"Item name");
       inv_items.getColumnModel().getColumn(3).setHeaderValue((Object)"Item price");
       inv_items.getColumnModel().getColumn(4).setHeaderValue((Object)"Item qty");
        
        inv_items.getColumnModel().getColumn(0).setPreferredWidth( 100 );
        inv_items.getColumnModel().getColumn(1).setPreferredWidth( 100 );
        inv_items.getColumnModel().getColumn(2).setPreferredWidth( 200 );
        inv_items.getColumnModel().getColumn(3).setPreferredWidth( 100 );
        inv_items.getColumnModel().getColumn(4).setPreferredWidth( 100 );
        
        inv_items.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                
                int rowNum = inv_items.table().rowAtPoint(p); 
                if( rowNum == -1) return;
                Object itemCode =  data[rowNum][0];
                Object itemBarCode = data[rowNum][1]; 
                Object itemName = data[rowNum][2]; 
                Object itemPrice = data[rowNum][3]; 
                Object itemQty = data[rowNum][4]; 
                
                if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                    if(e.getClickCount() >= 2){
                        item_index = itemCode.toString();
                        item_bar_code = itemBarCode.toString(); 
                        item_transfer(item_bar_code, new Object[]{itemName, itemPrice,itemQty});
                        
                    }
                }else if (javax.swing.SwingUtilities.isRightMouseButton(e)){
                   javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
        javax.swing.JScrollPane scrollpane = inv_items.tableScrollPane ( );
        scrollpane.setPreferredSize(new java.awt.Dimension(550, 390));     
        
    return scrollpane;
    }
   
    private void item_transfer(String item_bar_code, Object[] info){
        top_mid_buttons_warehouse_transfer();
        label_list.setText("Transfer items");
        javax.swing.JPanel panel = new javax.swing.JPanel ( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );        
        
        panel.add(panel_min); 
        
        items_transfer( panel , "Transfer item from warehouse", item_bar_code, info );
        
        splitpane.setRightComponent ( panel );
        splitpane.setDividerLocation(80);
    }
    
    private void items_transfer(javax.swing.JPanel panel, String border_title, String id_num, Object [] info){
        javax.swing.JPanel panel_;
        javax.swing.JLabel label;
        javax.swing.JButton button_;
        
        javax.swing.JPanel panel_1  = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_1.setPreferredSize(new java.awt.Dimension(770, 380));
        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null," "+ border_title+" " , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(750, 45));
        label = new javax.swing.JLabel("Item id: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        textfield_item_id = new javax.swing.JTextField(20);
        textfield_item_id.setText(id_num);
        textfield_item_id.setPreferredSize(new java.awt.Dimension(200, 30));
        textfield_item_id.setEditable(false);
        panel_.add( textfield_item_id );
        //panel_1.add( panel_ );
    
        label = new javax.swing.JLabel("Warehouse from: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        warehouse_from = new javax.swing.JTextField();
        warehouse_from.setText(list.getSelectedValue().toString());
        warehouse_from.setPreferredSize(new java.awt.Dimension(200, 30));
        warehouse_from.setEditable(false);
        panel_.add( warehouse_from );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(750, 45));
        label = new javax.swing.JLabel("Item name: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        item_name = new javax.swing.JTextField(20);
        item_name.setPreferredSize(new java.awt.Dimension(200, 30));
        item_name.setEditable(false);
        item_name.setText(info[0].toString());
        panel_.add( item_name );
        //panel_1.add( panel_ );

        //panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        //panel_.setPreferredSize(new java.awt.Dimension(350, 45));
        label = new javax.swing.JLabel("Warehouse to: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        warehouse_to = new javax.swing.JTextField(20);
        warehouse_to.setPreferredSize(new java.awt.Dimension(200, 30));
        warehouse_to.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
                new posi.sys.search.searchWarehouse(){                    
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                            warehouse_to_index = get_warehouse_index( );
                            warehouse_to.setText( get_warehouse_name( ) );
                            super.setVisible(false);
                        }else{ super.setVisible( true ); }
                    }
                }.setVisible(true);
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
        panel_.add( warehouse_to );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(750, 45));
        label = new javax.swing.JLabel("Item transfer qty: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 30));
        panel_.add( label );        
        item_transfer_qty = new javax.swing.JTextField(20);
        item_transfer_qty.setPreferredSize(new java.awt.Dimension(200, 30));
        item_transfer_qty.setText(info[2].toString());
        panel_.add( item_transfer_qty );
        //panel_1.add( panel_ );
        
        label = new javax.swing.JLabel("Trasfer date/time: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        transfer_date = new javax.swing.JTextField(20);
        transfer_date.setPreferredSize(new java.awt.Dimension(200, 30));
        
        //current date
        java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        java.util.Date dt = new java.util.Date();
        String dshow = date.format(dt);
        //end date declaration
        
        transfer_date.setText(dshow);
        
        panel_.add( transfer_date );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Item transfer price: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );        
        transfer_price = new javax.swing.JTextField(20);
        transfer_price.setPreferredSize(new java.awt.Dimension(200, 30));
        transfer_price.setText(info[1].toString());
        panel_.add( transfer_price );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.RIGHT ) );
        panel_.setPreferredSize(new java.awt.Dimension(750, 45));
        
        label = new javax.swing.JLabel("");
        label.setPreferredSize(new java.awt.Dimension(120, 40));
        panel_.add( label );

        button_ = new javax.swing.JButton("Cancel");
        button_.addActionListener(new Action());
        button_.setActionCommand("cancel");                     
        panel_.add(button_);
        
        button_ = new javax.swing.JButton("Transfer item");
        button_.addActionListener(new Action());
        button_.setActionCommand("transferItem");
        panel_.add( button_ );
        
        panel_1.add( panel_);
        
        panel.add(panel_1);
    }
    private void populate_edit_warehouse(String  id_num){
        Object [] row  = db.getRow("SELECT * FROM warehouses WHERE warehouse_id = '" + id_num + "'");
       // textfield_w_name,textfield_w_location,textfield_w_id,combo_status
        textfield_w_name.setText(row[1].toString() );
               
        textfield_w_location.setText( row[2].toString() );
                
        textfield_w_id.setText( row[0].toString() );
        
        if ( !"".equals(row[3].toString()) || !" ".equals(row[3].toString()) ) {
            combo_status.setSelectedItem( (row[3].toString()) );
        }
    }
    
    private void add_form(javax.swing.JPanel panel, String border_title, boolean ifEdit , String id_num){
        javax.swing.JPanel panel_;
        javax.swing.JLabel label;
        javax.swing.JTextField textfield;
        javax.swing.JButton button_;
        
        javax.swing.JPanel panel_1  = new javax.swing.JPanel();
        panel_1.setPreferredSize(new java.awt.Dimension(450, 300));
        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, border_title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse id");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        textfield_w_id = new javax.swing.JTextField(20);
        textfield_w_id.setPreferredSize(new java.awt.Dimension(200, 30));
        textfield_w_id.setEditable(false);
        panel_.add( textfield_w_id );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse name");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        textfield_w_name = new javax.swing.JTextField(20);
        textfield_w_name.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_.add( textfield_w_name );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse Location");
        label.setPreferredSize(new java.awt.Dimension(130, 30));
        panel_.add( label );        
        textfield_w_location = new javax.swing.JTextField(20);
        textfield_w_location.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_.add( textfield_w_location );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        label = new javax.swing.JLabel("Warehouse status");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );        
        combo_status = new javax.swing.JComboBox(new Object[]{"Active","Inactive"});
        combo_status.setPreferredSize(new java.awt.Dimension(150, 30));
        panel_.add( combo_status );
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.CENTER ) );
        label = new javax.swing.JLabel("");
        label.setPreferredSize(new java.awt.Dimension(130, 40));
        panel_.add( label );

        button_ = new javax.swing.JButton("Cancel");
        button_.addActionListener(new Action());
        button_.setActionCommand("cancel");                     
        panel_.add(button_);
        
        button_ = new javax.swing.JButton("Add warehouse");
        button_.addActionListener(new Action());
        button_.setActionCommand("add");
        panel_.add( button_ );
        
        panel_1.add( panel_);
        
        panel.add(panel_1);
        
        if( ifEdit ){
            button_.setText("Edit");
            button_.setActionCommand("editWarehouse");
            populate_edit_warehouse( id_num );
        }
            
    }
    
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if("add".equals(e.getActionCommand())){
                // textfield_w_name,textfield_w_location,textfield_w_id,combo_status
                String sql = "INSERT INTO warehouses VALUES( NULL,'"+textfield_w_name.getText()+"',"
                        + "'" + textfield_w_location.getText() + "',"
                        + "'" + combo_status.getSelectedItem() + "' )";
                
                if (db.addNew(sql)){
                    javax.swing.JOptionPane.showMessageDialog(null,"New record saved! " ,"Details updated",JOptionPane.INFORMATION_MESSAGE);
                    manage_warehouse();
                }else{
                     javax.swing.JOptionPane.showMessageDialog(null,"Record failed to save! " ,"Details update error",JOptionPane.ERROR_MESSAGE);
                }
                
            }else if("cancel".equals(e.getActionCommand())){
                manage_warehouse();
            }else if("transferItem".equals(e.getActionCommand())){
                
            }else if("editWarehouse".equals(e.getActionCommand())){
                String sql = "UPDATE warehouses SET "
                        + "warehouse_name = '"+textfield_w_name.getText()+"',"
                        + "warehouse_location = '"+textfield_w_location.getText()+"',"
                        + "warehouse_status = '"+combo_status.getSelectedItem()+"'"
                        + "WHERE warehouse_id = '"+textfield_w_id.getText()+"'";
                
                if(db.Update(sql)){
                    javax.swing.JOptionPane.showMessageDialog(null,"Details updated! " ,"Details updated",JOptionPane.INFORMATION_MESSAGE);
                    manage_warehouse();
                }else{
                     javax.swing.JOptionPane.showMessageDialog(null,"Record failed to update! " ,"Details update error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
        
    }
    public java.awt.Component warehouse_controls(){
        return new javax.swing.JButton("");
    }
    public static void main(String [] args){
        new Warehouse().setVisible(true);
    }
}
