/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.event.ActionEvent;
/**
 *
 * @author Aquarius
 */
public class POS_scroll_items {
    private static String sqls [] = {
        "SELECT item_name,item_default_bar_code FROM items",
        "", 
        "",
    };
    public static int scroll_end;
    public static int scroll_interval = 3;
    public static int scroll_current;
    
    private static javax.swing.JButton button;
    
    private static int item_option = 0;
    
    private static int start_scroll = 1;
    private static posi.sys.all.expeditors.database.db_connect db = new posi.sys.all.expeditors.database.db_connect();
    
    public POS_scroll_items(){
        
    }
    
   private static javax.swing.JPanel panelRemoveComponent(javax.swing.JPanel panel){
       int size = panel.getComponentCount();
       
       for(int i = 0; i < size; i++){
           panel.remove(i);
       }
   return panel;
   }
   public static void makeScrollButtons(javax.swing.JPanel panel){
       javax.swing.JPanel panelNew = new javax.swing.JPanel();
       
       Object[][] data = db.getData( sqls[ item_option ] );
       scroll_end = data.length;
       
       for(int i = start_scroll; i <= scroll_interval; i++ ){
           String item_name = data[i][0].toString();
           String item_bar_code = data[i][1].toString();
           
           button = new javax.swing.JButton(item_name);
           button.setActionCommand(item_bar_code);
           button.setAutoscrolls(true);
           button.addActionListener(new java.awt.event.ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                   POS.addRowItem(e.getActionCommand());
               }
       
           });
           
           int item_width = item_name.length()*15;
           if(item_width > 120) {
               item_width = 120;
           }
           button.setPreferredSize(new java.awt.Dimension(item_width, 35));
           
           panelNew.add(button);
       }
       
       panel.add(panelNew);
       scroll_current = scroll_interval-1;
   }
   
   public static void scrollItems(javax.swing.JPanel panel){
       start_scroll += 1;
       
       makeScrollButtons(panelRemoveComponent(panel));
   }
    
}
