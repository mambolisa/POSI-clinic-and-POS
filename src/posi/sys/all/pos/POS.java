/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import posi.sys.all.inv.inventoryTable;
import posi.sys.all.inv.trackItem;
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
    
    private String [] columnNames = {"Item bar code","Item Name","Item qty","Price","Total"};
    private Object [][] data ;
    public POS(){
        super(new java.awt.Dimension(950,650),"Point of sale");
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
        toolBar.setFloatable(true);
       // toolBar.setPreferredSize(new java.awt.Dimension(200, 30));
        panel.add(toolBar,BorderLayout.PAGE_START); 
        
        toolBar = new javax.swing.JToolBar();
        addToolbarContent(toolBar);        
        toolBar.setFloatable(true);
       // toolBar.setPreferredSize(new java.awt.Dimension(200, 30));
        panel.add(toolBar,BorderLayout.PAGE_START); 
        
        add(panel,BorderLayout.PAGE_START);
        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addTab("Sales catalogue",addSalesTable());
               
        add(tabbedPane,BorderLayout.CENTER);
        
        toolBar = new javax.swing.JToolBar();
        addToolbarContent(toolBar);        
        toolBar.setFloatable(true);
        //toolBar.setPreferredSize(new java.awt.Dimension(200, 30));
        add(toolBar,BorderLayout.PAGE_END);
    }
    
    private void addToolbarContent(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Document new.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Search");
        button.addActionListener( new Action());
        button.setToolTipText("Search");
	button.setContentAreaFilled(false);
        toolbar.add(button);
 
   }    
    
private void addToolbarContent_2(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Document new.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button); 
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Customers");
        button.addActionListener( new Action());
        button.setToolTipText("Customers");
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(34, 32)));
        button.setActionCommand("Search");
        button.addActionListener( new Action());
        button.setToolTipText("Search");
	button.setContentAreaFilled(false);
        toolbar.add(button);
 
   }    
    
    public final javax.swing.JScrollPane addSalesTable(){
        int cols = 5, rows = 10;
        data = new Object[rows][cols];
        for ( int i = 0; i < rows; i++ ){
            for ( int j = 0; j < cols-1; j++ ){
                data[i][j] = "";
            }
        }
        new inventoryTable(data,columnNames);
        javax.swing.JTable table = inventoryTable.table();
        table.setRowHeight(28);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        
        scrollpane = inventoryTable.tableScrollPane();
        
        return scrollpane;
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    public static void main(String [] args){
        new POS().setVisible(true);
    }
    
    private javax.swing.JScrollPane scrollpane;
}

