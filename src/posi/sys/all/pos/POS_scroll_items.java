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
    
    public static int scroll_end;
    public static int scroll_interval = 3;
    public static int scroll_current;
    
    private static javax.swing.JButton button;
    
    private static int item_option = 0;
    
    private static int start_scroll = 1;
    private static posi.sys.all.expeditors.database.db_connect db = new posi.sys.all.expeditors.database.db_connect();
    /*private static String sqls [] = {
        "SELECT item_name,item_default_bar_code FROM items LIMIT "+ start_scroll + ","+scroll_interval,
        "", 
        "",
    };*/
    public POS_scroll_items(){
        
    }
    
   /*private static javax.swing.JPanel panelRemoveComponent(javax.swing.JPanel panel){
       int size = panel.getComponentCount();
       
       for(int i = 0; i < size; i++){
           //panel.remove(i);
           javax.swing.JButton button = (javax.swing.JButton)panel.getComponent(i);
           button.setName(null);
       }
   return panel;
   }*/
    
   public static void makeScrollButtons(javax.swing.JPanel panel){
       String sqls [] = {
                        "SELECT item_name,item_default_bar_code FROM items LIMIT "+ start_scroll + ","+scroll_interval,
                        "", 
                        "",
                    };
       System.out.println(sqls[ item_option ]);
       Object[][] data = db.getData( sqls[ item_option ] );
       
       
       if(data.length == 0) 
           return;
       else
           scroll_end = data.length;
       
       int comp_count = panel.getComponentCount();
       int counter = 0;
       
       for(int i = 0; i < scroll_end; i++ ){
           String item_name = data[i][0].toString();
           String item_bar_code = data[i][1].toString();
           System.out.println("main: "+ panel.getComponentCount() );
           
           if(counter < comp_count){ 
                javax.swing.JButton btn = (javax.swing.JButton) panel.getComponent(counter);
                btn.setText(item_name);
                btn.setActionCommand(item_bar_code);
                counter++;
           }else{System.out.println("else: "+ panel.getComponentCount() );
                button = new javax.swing.JButton(item_name);
                button.setActionCommand(item_bar_code);
                //button.setAutoscrolls(true);
                button.addActionListener(new java.awt.event.ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        POS.addRowItem(e.getActionCommand());
                    }

                });
                button.setPreferredSize(new java.awt.Dimension((int)button.getPreferredSize().getWidth(), 35));
                panel.add(button);
           }
          // counter++;
       }       
       //scroll_current = scroll_interval-1;
   }
   
   public static void scrollItems(javax.swing.JPanel panel, String action){
       if("next".equals(action)){           
           start_scroll += scroll_interval;
       }else if ("prev".equals(action)){
           if( start_scroll > scroll_interval )               
                start_scroll -=  scroll_interval - 1;
       }
       
       makeScrollButtons((panel));
   }
    
}
