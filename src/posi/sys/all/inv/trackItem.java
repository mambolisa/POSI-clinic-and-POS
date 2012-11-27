/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author Aquarius
 */
public class trackItem extends posi.sys.expeditors.popup {
    private int item_id;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JButton button;
    
    public trackItem(){
        super(new java.awt.Dimension(800,650),"Track Item");
        this.getContentPane().add(posi.sys.all.inv.reports.InvAll());
        this.content();
    }
    
    public trackItem(int itemId){
        super(new java.awt.Dimension(800,650),"Track Item");
        this.item_id = itemId;
        
        this.content();
    }
  
    public final void content(){
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
        new trackItem().setVisible(true);
    }
}
