/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.all.inv.invTables;
import posi.sys.expeditors.sundry;
import posi.sys.expeditors.utilityFunctions;

/**
 *
 * @author Aquarius
 */
public class Customer extends posi.sys.expeditors.popup {
    private javax.swing.JPanel panel , panel1, panel_1, panel_2;
    private javax.swing.JLabel label;
    private javax.swing.JButton button;
    private javax.swing.JSplitPane splitpane;
    
    private Object[][] data;
    private db_connect db = new db_connect();
    
    private javax.swing.JComboBox combo;

    private String index;
    
    private javax.swing.JTextField cust_id,cust_fname,cust_lname,cust_idnum,cust_points,passportnum,subscribernum,added_date;
    
    public Customer(String index){        
        super(new java.awt.Dimension(790,570),"Customer");
        this.index = index;
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.setBackground(Color.white);
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        
        splitpane = new javax.swing.JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitpane.setDividerLocation(80);
        splitpane.setEnabled(false);
        
        splitpane.setLeftComponent( top_buttons( ) );
        add(splitpane);
        
        add_cust_form_content();
    }
    
    private void add_cust_form_content(){          
        splitpane.setRightComponent(cust_form( ));        
        
        //add_form( panel , "Edit customer details", true, this.index );
    }
    
    private javax.swing.JPanel others_panel(){
        javax.swing.JPanel panel, panel_top ;
        javax.swing.JButton button ;
                
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_top = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_top.setPreferredSize(new java.awt.Dimension(700, 40));
        
        button = new javax.swing.JButton("Customer preference");
        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setPreferredSize(new java.awt.Dimension(160, 35));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cust_preference();
            }
        });
        
        panel.add(button);
        
        button = new javax.swing.JButton("Latest transaction");
        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setPreferredSize(new java.awt.Dimension(160, 35));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                latest_transaction();
            }
        });
        
        panel.add(button);
        
        button = new javax.swing.JButton("Customer account ");
        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setContentAreaFilled(false);
        button.setPreferredSize(new java.awt.Dimension(160, 35));
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                customer_account();
            }
        });
        
        panel.add(button);
    return panel;
    }
    
    private void customer_account(){
        
    }
    private void cust_preference(){
        javax.swing.JPanel panel, panel1;
        javax.swing.JButton button;
        javax.swing.JLabel label;
        
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.add(others_panel( ));
        
        label = new javax.swing.JLabel("Customer preference", SwingConstants.CENTER);
        label.setPreferredSize(new java.awt.Dimension(this.getWidth()-20, 30));
        panel.add(label);
        db = new db_connect();
        String sql = "SELECT preference_id, item_id,item_name,item_default_price,preference_item_price,preference_item_qty FROM customer_preference, items WHERE preference_item_id = item_id ";
        data = db.getData(sql);
     
        final String [] columnNames = {"Preference id","Item id","Item name","Item default price","Customer price","Customer qty"};
         
        //panel prereference
        final invTables preference;
        preference = new invTables(data,columnNames){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        preference.getColumnModel().getColumn(0).setPreferredWidth(100);
        preference.getColumnModel().getColumn(1).setPreferredWidth(70);
        preference.getColumnModel().getColumn(2).setPreferredWidth(200);
        preference.getColumnModel().getColumn(3).setPreferredWidth(100);
        preference.getColumnModel().getColumn(4).setPreferredWidth(100);
        preference.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        preference.setMouseListener(new java.awt.event.MouseAdapter() {
            @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
                java.awt.Point p = e.getPoint();
                int rowNum = preference.rowAtPoint(p);  
                if( rowNum != -1 ){               
                    Object pref_id =  data[rowNum][0];
                    Object item_id =  data[rowNum][1];
                    Object item_name = data[rowNum][2];
                    Object item_price = data[rowNum][4];
                    Object item_qty = data[rowNum][5];
                    
                    if (javax.swing.SwingUtilities.isLeftMouseButton(e)){                    
                        if(e.getClickCount() >= 2){
                            new editCustPreference(index, new Object []{pref_id, item_id, item_name, item_price, item_qty}){
                                
                            }.setVisible(true);                            
                        }
                    }
                }
           }
       });
        
        javax.swing.JScrollPane scrollpane = preference.tableScrollPane();
        scrollpane.setPreferredSize(new java.awt.Dimension(this.getWidth()-20, this.getHeight()-270));
        panel.add(scrollpane);
        
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panel1.setPreferredSize(new java.awt.Dimension(760, 40));
        
        button = new javax.swing.JButton("Add preference");
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new editCustPreference(index).setVisible(true);
            }
        });
        panel1.add(button);
        
        panel.add(panel1);
        
        splitpane.setRightComponent( panel );
    }
    
  private void latest_transaction(){
        javax.swing.JPanel panel, panel1;
        javax.swing.JButton button;
        javax.swing.JLabel label;
        
        panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel.add(others_panel( ));
        
        label = new javax.swing.JLabel("Customer preference", SwingConstants.CENTER);
        label.setPreferredSize(new java.awt.Dimension(this.getWidth()-20, 30));
        panel.add(label);
        db = new db_connect();
        String sql = "SELECT item_name,item_default_price,preference_item_price,preference_item_qty FROM customer_preference, items WHERE preference_item_id = item_id ";
        data = db.getData(sql);
     
        final String [] columnNames = {"Item name","Item default price","Item cust price","Customer price"};
         
        //panel prereference
        final invTables preference;
        preference = new invTables(data,columnNames){

          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
        };
        
        preference.setMouseListener(new java.awt.event.MouseAdapter() {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e){
               if (SwingUtilities.isRightMouseButton(e)){
                   java.awt.Point p = e.getPoint();
                   
                   int rowNum = preference.table().rowAtPoint(p);
                   Object itemCode =  data[rowNum][0];
                   javax.swing.JPopupMenu popup = new utilityFunctions().invRowPopupMenu(Integer.parseInt(itemCode.toString()));
                   
                   popup.show(e.getComponent(), e.getX(), e.getY());
               }
           }
       });
        
        preference.getColumnModel().getColumn(0).setPreferredWidth(200);
        preference.getColumnModel().getColumn(1).setPreferredWidth(100);
        preference.getColumnModel().getColumn(2).setPreferredWidth(100);
        preference.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        javax.swing.JScrollPane scrollpane = preference.tableScrollPane();
        scrollpane.setPreferredSize(new java.awt.Dimension(this.getWidth()-20, this.getHeight()-270));
        panel.add(scrollpane);
        
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panel1.setPreferredSize(new java.awt.Dimension(750, 40));
        
        button = new javax.swing.JButton("Add preference");
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel1.add(button);
        
        panel.add(panel1);
        
        splitpane.setRightComponent( new javax.swing.JPanel() );
    }
  
    private void others(){
        splitpane.setRightComponent(others_panel( ));
    }
    
    private javax.swing.JPanel cust_form(){
        javax.swing.JPanel panel_;
        javax.swing.JLabel label;
        
        javax.swing.JPanel panel_1  = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_1.setPreferredSize(new java.awt.Dimension(780, 350));
        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null," Customer edit " , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(770, 45));
        
        label = new javax.swing.JLabel("Customer id: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        cust_id = new javax.swing.JTextField(20);
        cust_id.setPreferredSize(new java.awt.Dimension(200, 30));
        cust_id.setEditable(false);
        panel_.add( cust_id );
        
        //panel_1.add( panel_ );
         
        //panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        //panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("First name: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        cust_fname = new javax.swing.JTextField(20);
        cust_fname.setPreferredSize(new java.awt.Dimension(200, 30));
        cust_fname.setEditable(true);
        panel_.add( cust_fname );
        
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(770, 45));
        
        label = new javax.swing.JLabel("Last name: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        cust_lname = new javax.swing.JTextField(20);
        cust_lname.setPreferredSize(new java.awt.Dimension(200, 30));
        cust_lname.setEditable(true);
        panel_.add( cust_lname );
        
        //panel_1.add( panel_ );
        
        //panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        //panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("ID num: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        cust_idnum = new javax.swing.JTextField(20);
        cust_idnum.setPreferredSize(new java.awt.Dimension(200, 30));
        cust_idnum.setEditable(true);
        panel_.add( cust_idnum );
        
        panel_1.add( panel_ );     
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(770, 45));
        
        label = new javax.swing.JLabel("Customer points: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        cust_points = new javax.swing.JTextField(20);
        cust_points.setPreferredSize(new java.awt.Dimension(200, 30));
        cust_points.setEditable(false);
        panel_.add( cust_points );
        
        //panel_1.add( panel_ ); 
        
        //panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        //panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("Status: ", SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        
        combo = new javax.swing.JComboBox(db.getColData("SELECT customer_status_name FROM customer_status;"));
        combo.setPreferredSize(new java.awt.Dimension(180, 30));
        //textfield_w_id.setEditable(false);
        panel_.add( combo );
        
        panel_1.add( panel_ );
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("Passport num: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        passportnum = new javax.swing.JTextField(20);
        passportnum.setPreferredSize(new java.awt.Dimension(200, 30));
        passportnum.setEditable(true);
        panel_.add( passportnum );
        
        panel_1.add( panel_ );        
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("Subscription id: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        subscribernum = new javax.swing.JTextField(20);
        subscribernum.setPreferredSize(new java.awt.Dimension(200, 30));
        subscribernum.setEditable(false);
        panel_.add( subscribernum );
        
        panel_1.add( panel_ );        
       
        
        panel_ = new javax.swing.JPanel( new java.awt.FlowLayout (  java.awt.FlowLayout.LEFT ) );
        panel_.setPreferredSize(new java.awt.Dimension(400, 45));
        
        label = new javax.swing.JLabel("Date added: ",SwingConstants.RIGHT);
        label.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_.add( label );        
        
        added_date = new javax.swing.JTextField(20);
        added_date.setPreferredSize(new java.awt.Dimension(200, 30));
        added_date.setEditable(false);
        panel_.add( added_date );
        
        panel_1.add( panel_ );
        
        panel_1.add(cust_buttons());
        
        get_cust_details();
        
    return panel_1;
    }
    
    private javax.swing.JPanel cust_buttons(){
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panel.setPreferredSize(new java.awt.Dimension(730, 40));
        button = new javax.swing.JButton("Update customer");
        button.setActionCommand("addCust");
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( "addCust".equals(e.getActionCommand() ) ){
                    
                }                
            }
        });
        panel.add(button);
        
        button = new javax.swing.JButton("Cancel");
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(button);
        
    return panel; 
        
    }
    
    private void get_cust_details(){
        if( !"".equals(this.index) ){
            String sql = "SELECT * FROM customers where customer_id = "+this.index+";";
            Object [] data = db.getRow(sql);
            
            System.out.println(data.length);
            
            cust_id.setText(data[0].toString());
            cust_fname.setText(data[1].toString());
            cust_lname.setText(data[2].toString());
            cust_idnum.setText(data[3].toString());
            passportnum.setText(data[4].toString());            
            subscribernum.setText(data[6].toString());
            cust_points.setText(data[7].toString());
            added_date.setText(data[8].toString());
        }
    }
    
    private javax.swing.JPanel top_buttons(){
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(Color.white);
        label = new javax.swing.JLabel("Customers");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley1.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 14));
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add_cust_form_content();
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(Color.white);
        label = new javax.swing.JLabel("Customer history");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley3.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //splitpane.setRightComponent(warehouse_transfers());
                //splitpane.setDividerLocation(80);
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
        
        panel_1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panel_1.setPreferredSize(new java.awt.Dimension(80, 75));
        panel_1.setBackground(Color.white);
        label = new javax.swing.JLabel("Others");
        label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 8));
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Smiley2.gif", new java.awt.Dimension(70, 70)));
        button.setPreferredSize(new java.awt.Dimension(70, 50));
        button.setContentAreaFilled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //splitpane.setRightComponent(warehouse_controls());
                //splitpane.setDividerLocation(80);
                cust_preference();
            }
        });
        panel_1.add(button);
        panel_1.add(label);
        
        panel.add(panel_1);
        
    return panel;
    }

  
    private void warehouse_update_table(String id){
        String sql = "SELECT item_id, item_default_bar_code,item_name,item_default_price,item_qty FROM items WHERE item_warehouse_location = "+id+" ";
        System.out.println(sql);
        data = db.getData( sql );
        
        
        //inv.getModel().
        
        //javax.swing.table.TableModel model = (javax.swing.table.TableModel) inv_items.getModel();
        //javax.swing.table.AbstractTableModel main_model = (javax.swing.table.AbstractTableModel) inv_items.getModel();
        //main_model.fireTableDataChanged();
        
    }

    
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
        
    }

    public static void main(String [] args){
        new Customer(""+1).setVisible(true);
    }
}
