/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import posi.sys.all.expeditors.database.db_connect;

/**
 *
 * @author Aquarius
 */
public class trackItem  extends posi.sys.expeditors.popup{
    private int item_id;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JButton button;
    private db_connect db = new db_connect();
    
    private inventoryTable inv;
    
    private Object [][] data;
   // private posi.sys.expeditors.popup popup;
    
    public trackItem(){
        super(new java.awt.Dimension(850,550),"Track item");
        setVisible(false);
        
        final Search search = new Search();
        
        search.addWindowListener(new java.awt.event.WindowListener(){

            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e) { }

            @Override
            public void windowClosed(WindowEvent e) { 
                item_id = search.getTableSelectedRow();
                content();                 
                setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        
        });
        
        search.setVisible(true);
    }
    
    public trackItem(int itemId){
        super(new java.awt.Dimension(850,550),"Track item");
        
        this.item_id = itemId;
        
        this.content();
    }
  
    public final void content(){ System.out.print(item_id);
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
        new trackItem();
    }
}
