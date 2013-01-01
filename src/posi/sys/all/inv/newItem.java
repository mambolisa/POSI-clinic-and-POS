/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */
public class newItem extends posi.sys.expeditors.popup {
    private int item_num = -1;
    private posi.sys.all.expeditors.database.db_connect db = new posi.sys.all.expeditors.database.db_connect();;
    private Object [][] data;
    private boolean ifNew,ifDataAvailable;
    private int counter;
   
    private java.sql.ResultSet rs;
    
    public newItem(){
        super(new java.awt.Dimension(700,600),"New Item");
        this.addContent(true);
        
    }
    public newItem(int itemNum, boolean iNewEnabledBtn){
        super(new java.awt.Dimension(700,600),"Edit Item");
        
        this.item_num = itemNum;
        this.addContent(false);
        
        if(!iNewEnabledBtn){
            disableButtons();
        }else{
            enableButtons();
        }
    }
    
    public static void main(String [] args){
        new newItem(11, false).setVisible(true);
    }
  
    private void disableButtons(){
        prev.setEnabled(false);
        next.setEnabled(false);
        SaveUpdate.setEnabled(false);
        TrackItem.setEnabled(false);
    }
    
    private void enableButtons(){
        prev.setEnabled(true);
        next.setEnabled(true);
        SaveUpdate.setEnabled(true);
        TrackItem.setEnabled(true);
    }
    
    private void addContent(boolean ifNewItem){
        this.createSwingComponents();        
       // ifDataAvailable = false;
        this.ifNew = ifNewItem;
        
        if(this.item_num == -1 ){
            this.ifNew = true;
        }else{            
           // String sql = "SELECT * FROM items where item_id="+this.item_num;
            String sql = "SELECT * FROM items";
            
            rs = db.Query(sql);
            try {
                boolean cont = true;
                
                while( rs.next() && cont == true){
                    if( rs.getInt(1) == item_num ){
                        newPopulate(rs);
                        cont = false;
                    }
                }
                //ifDataAvailable = (data.length > 0 && data.length <= 1)? true : false ;
                //this.renderContent( false );
            } catch (SQLException ex) {
                Logger.getLogger(newItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if( !this.ifNew ){
            SaveUpdate.setText("Update");
            SaveUpdate.setActionCommand("Update");  
            enableButtons();
            SaveUpdate.setEnabled(true);
        }  else{
            ItemIdText.setText(" Auto-Generated");
            disableButtons();
            SaveUpdate.setEnabled(true);
        }
    }
    
    private void newPopulate(java.sql.ResultSet rs) throws SQLException{
        ItemIdText.setText(""+rs.getInt(1));
        ItemBarCodeText.setText(""+rs.getString(4));
        ItemNameText.setText(""+rs.getString(2));
        ItemPriceText.setText(""+rs.getDouble(6));
        ItemQtyText.setText(""+rs.getInt(8));
        
         if(!"".equals(rs.getInt(10)) && !" ".equals(rs.getInt(10)) && CatComboBox.getItemCount() > 0) {
            CatComboBox.setSelectedIndex(rs.getInt(10));
        }
        
        if(rs.getInt(19) == 0 && !" ".equals(rs.getInt(19)) && ItemStatusCombo.getItemCount() > 0) {
            ItemStatusCombo.setSelectedIndex(rs.getInt(19));
        } 
        SizeText.setText(""+rs.getString(18));
        ColorText.setText(""+rs.getString(17));
        MakeText.setText(""+rs.getString(16));

   //    if(!"".equals(rs.getInt(15)) && !" ".equals(rs.getInt(15)) && QualityComboBox.getItemCount() > 0 ) {
      //      QualityComboBox.setSelectedIndex(rs.getInt(15));
    //    }

        if(!"".equals(rs.getInt(11)) && !" ".equals(rs.getInt(11)) && itemConversionCombo.getItemCount() > 0 ) {
            itemConversionCombo.setSelectedIndex(rs.getInt(11));
        }
        WeightText.setText(""+rs.getString(14));
        DescTextArea.setText(""+rs.getString(3));
        
/*        if(!"".equals(rs.getInt(13)) && !" ".equals(rs.getInt(13)) && ManufCombo.getItemCount() > 0 ) {
            ManufCombo.setSelectedIndex(rs.getInt(13));
        }*
        */
    }
    
   private void updateItem(){
        String sql = "UPDATE items SET "
                + "item_name = '"+ItemNameText.getText()+"', "
                + "item_description = '"+DescTextArea.getText()+"',"
                + "item_default_bar_code = '"+ItemBarCodeText.getText()+"', "
                + "item_default_price = '"+ItemPriceText.getText()+"',"
                + "item_qty = '"+ItemQtyText.getText()+"',"
                + "item_category = '"+CatComboBox.getSelectedIndex()+"',"
                + "item_conversion_id = '"+itemConversionCombo.getSelectedIndex()+"',"
                + "item_manuf = '"+ManufCombo.getSelectedIndex()+"',"
                + "item_weight = '"+WeightText.getText()+"',"
                + "item_quality = '"+QualityComboBox.getSelectedIndex()+"',"
                + "item_make = '"+MakeText.getText()+"',"
                + "item_color = '"+ColorText.getText()+"',"
                + "item_size = '"+SizeText.getText()+"',"
                + "item_status = '"+ItemStatusCombo.getSelectedIndex()+"'"
                + "WHERE item_id = '"+ItemIdText.getText()+"';";
        //System.out.println(sql);
        if(db.Update(sql)){
            JOptionPane.showMessageDialog(null,"Item "+ItemNameText.getText()+" has been updated","Record updated!",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Item "+ItemNameText.getText()+" has failed to update","Record update erro!",JOptionPane.ERROR_MESSAGE);      
        }
            
    }
    private void addItem(){
        java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("yyyy-MM-dd k:m:s");
        java.util.Date dt = new java.util.Date();
        String dshow = date.format(dt);
        
        String sql = "INSERT INTO items "
                + "(item_name,item_description,  item_default_bar_code, item_default_price, item_qty, item_category, item_conversion_id, "
                + "item_manuf, item_weight, item_quality, item_make, item_color, item_size, item_status, created_at)"
                + "VALUES ( '"+ItemNameText.getText()+"','"+DescTextArea.getText()+"','"+ItemBarCodeText.getText()+"','"+ItemPriceText.getText()+"',"
                + "'"+ItemQtyText.getText()+"','"+(CatComboBox.getSelectedIndex()+1)+"','"+(itemConversionCombo.getSelectedIndex()+1)+"',"
                + "'"+(ManufCombo.getSelectedIndex()+1)+"','"+WeightText.getText()+"','"+(QualityComboBox.getSelectedIndex()+1)+"','"+MakeText.getText()+"',"
                + "'"+ColorText.getText()+"','"+SizeText.getText()+"','"+(ItemStatusCombo.getSelectedIndex()+1)+"','"+dshow+"')";

        //System.out.println(sql);
        
        if(db.addNew(sql)){
            JOptionPane.showMessageDialog(null,"Item "+ItemNameText.getText()+" has been added","Record added!",JOptionPane.INFORMATION_MESSAGE);
            SaveUpdate.setText("Update");
            SaveUpdate.setActionCommand("Update"); 
            enableButtons();
            this.setTitle("Update item");
            
            rs = db.Query("SELECT * FROM items");
            try {
                rs.last();
                ItemIdText.setText(""+rs.getInt(1));
            } catch (SQLException ex) {
                Logger.getLogger(newItem.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }else{
            JOptionPane.showMessageDialog(null,"Item "+ItemNameText.getText()+" has failed to be added","Record adding error!",JOptionPane.ERROR_MESSAGE);        
        }
    }
  
    private void createSwingComponents(){

        jPanel1 = new javax.swing.JPanel();
        itemIdLabel = new javax.swing.JLabel();
        ItemIdText = new javax.swing.JTextField();
        itemBarCodeLabel = new javax.swing.JLabel();
        ItemBarCodeText = new javax.swing.JTextField();
        ItemNameLabel = new javax.swing.JLabel();
        ItemNameText = new javax.swing.JTextField();
        ItemPriceLabel = new javax.swing.JLabel();
        ItemPriceText = new javax.swing.JTextField();
        ItemQtyLabel = new javax.swing.JLabel();
        ItemQtyText = new javax.swing.JTextField();
        CatLabel = new javax.swing.JLabel();
        CatComboBox = new javax.swing.JComboBox();
        statusLabel = new javax.swing.JLabel();
        ItemStatusCombo = new javax.swing.JComboBox();
        itemConversionLabel = new javax.swing.JLabel();
        itemConversionCombo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        sizeLabel = new javax.swing.JLabel();
        SizeText = new javax.swing.JTextField();
        ColorLabel = new javax.swing.JLabel();
        ColorText = new javax.swing.JTextField();
        MakeLabel = new javax.swing.JLabel();
        MakeText = new javax.swing.JTextField();
        QualityLabel = new javax.swing.JLabel();
        QualityComboBox = new javax.swing.JComboBox();
        WeigthLabel = new javax.swing.JLabel();
        WeightText = new javax.swing.JTextField();
        descLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescTextArea = new javax.swing.JTextArea();
        ManufLabel = new javax.swing.JLabel();
        ManufCombo = new javax.swing.JComboBox();
        picPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        SaveUpdate = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        TrackItem = new javax.swing.JButton();
        Close = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 51))); // NOI18N
       
        ItemIdText.setEditable(false);
        
        itemIdLabel.setText("Item Id");

        itemBarCodeLabel.setText("Item bar code");

        ItemNameLabel.setText("Item name");

        ItemPriceLabel.setText("Item price");

        ItemQtyLabel.setText("Item qty");

        CatLabel.setText("Category");

        Object [][] cat = db.getData("SELECT item_category_name FROM items_categories");
        sundry.createCombo(CatComboBox, cat);
                
        statusLabel.setText("Item status");

        Object [][] status = db.getData("SELECT item_status_name FROM item_status");
        sundry.createCombo(ItemStatusCombo, status);
        
        itemConversionLabel.setText("Item Conversion qty");

        Object [][] conv = db.getData("SELECT  item_conversion_name, item_conversion_qty FROM item_conversions");
        sundry.createCombo(itemConversionCombo, conv);
        
   javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(itemConversionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemConversionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ItemStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(itemIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(itemBarCodeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ItemBarCodeText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ItemPriceLabel)
                                .addGap(2, 2, 2)
                                .addComponent(ItemPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ItemQtyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemQtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CatLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ItemNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CatComboBox, 0, 154, Short.MAX_VALUE)
                    .addComponent(ItemNameText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemIdLabel)
                    .addComponent(itemBarCodeLabel)
                    .addComponent(ItemBarCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemNameLabel)
                    .addComponent(ItemNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemPriceLabel)
                    .addComponent(ItemPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemQtyLabel)
                    .addComponent(ItemQtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CatLabel)
                    .addComponent(CatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemConversionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemConversionLabel)
                    .addComponent(statusLabel))
                .addContainerGap())
        );


        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other descriptions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sizeLabel.setText("Item size");

        ColorLabel.setText("Color");

        MakeLabel.setText("Origin/Make");

        QualityLabel.setText("Item quality");

        Object [][] quality = db.getData("SELECT item_quality_value FROM item_quality");
        sundry.createCombo(QualityComboBox, quality);
        
        WeigthLabel.setText("Item weight");

        descLabel.setText("Item description");

        DescTextArea.setColumns(20);
        DescTextArea.setRows(5);
        jScrollPane1.setViewportView(DescTextArea);

        ManufLabel.setText("Manufacturer");
        
        Object [][] manuf = db.getData("SELECT item_manuf_name FROM item_manufacturer");
        sundry.createCombo(ManufCombo, manuf);
        
        picPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray));

        javax.swing.GroupLayout picPanelLayout = new javax.swing.GroupLayout(picPanel);
        picPanel.setLayout(picPanelLayout);
        picPanelLayout.setHorizontalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        picPanelLayout.setVerticalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Item pic");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(QualityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QualityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(WeigthLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(WeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(ManufLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ManufCombo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ColorText)
                                .addGap(18, 18, 18)
                                .addComponent(MakeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MakeText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(SizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ColorLabel)
                    .addComponent(ColorText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MakeLabel)
                    .addComponent(MakeText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QualityLabel)
                    .addComponent(QualityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WeigthLabel)
                    .addComponent(WeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManufLabel)
                    .addComponent(ManufCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(descLabel)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );

        SaveUpdate.setText("Save");
        SaveUpdate.setActionCommand("Save");
        SaveUpdate.addActionListener(new action());

        prev.setText("<< Previous");
        prev.setActionCommand("Prev");
        prev.addActionListener(new action());
        
        next.setText("Next >>");
        next.setActionCommand("Next");
        next.addActionListener(new action());
        
        TrackItem.setText("Track item");
        TrackItem.setActionCommand("Track");
        TrackItem.addActionListener(new action());
        
        Close.setText("Close");
        Close.setActionCommand("Close");
        Close.addActionListener(new action());

     javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(SaveUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrackItem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaveUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrackItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();     
    }

    
    class action implements java.awt.event.ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("Save".equals(e.getActionCommand())){
                addItem();
            }else if("Update".equals(e.getActionCommand())){
                updateItem();
            }else if("Close".equals(e.getActionCommand())){
                dispose();
            }else if("Track".equals(e.getActionCommand())){                
                setVisible(false);
                new trackItem(Integer.parseInt(ItemIdText.getText()));
            }else if("Next".equals(e.getActionCommand())){
                try {
                    if(rs.next()){
                        newPopulate(rs);
                    }                    
                    
                } catch (SQLException ex) {
                   //Logger.getLogger(newItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if("Prev".equals(e.getActionCommand())){
                try {
                    if(rs.previous()){
                        newPopulate(rs);
                    }
                } catch (SQLException ex) {
                   // Logger.getLogger(newItem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    private javax.swing.JComboBox CatComboBox;
    private javax.swing.JLabel CatLabel;
    private javax.swing.JButton Close;
    private javax.swing.JLabel ColorLabel;
    private javax.swing.JTextField ColorText;
    private javax.swing.JTextArea DescTextArea;
    private javax.swing.JTextField ItemBarCodeText;
    private javax.swing.JTextField ItemIdText;
    private javax.swing.JLabel ItemNameLabel;
    private javax.swing.JTextField ItemNameText;
    private javax.swing.JLabel ItemPriceLabel;
    private javax.swing.JTextField ItemPriceText;
    private javax.swing.JLabel ItemQtyLabel;
    private javax.swing.JTextField ItemQtyText;
    private javax.swing.JLabel MakeLabel;
    private javax.swing.JTextField MakeText;
    private javax.swing.JLabel ManufLabel;
    private javax.swing.JComboBox ManufCombo;
    private javax.swing.JComboBox QualityComboBox;
    private javax.swing.JLabel QualityLabel;
    private javax.swing.JButton SaveUpdate;
    private javax.swing.JTextField SizeText;
    private javax.swing.JButton TrackItem;
    private javax.swing.JTextField WeightText;
    private javax.swing.JLabel WeigthLabel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel itemBarCodeLabel;
    private javax.swing.JLabel itemIdLabel;
    private javax.swing.JComboBox ItemStatusCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JPanel picPanel;
    private javax.swing.JButton prev;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel statusLabel;    
    private javax.swing.JComboBox itemConversionCombo;
    private javax.swing.JLabel itemConversionLabel;
    
}
