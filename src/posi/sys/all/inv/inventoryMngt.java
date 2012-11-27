/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */

public class inventoryMngt extends javax.swing.JFrame {
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenu file, edit, view, options, reports, logout,warehouse, transaction, submenu,menu , admin;
    private java.awt.Dimension screen;
    private javax.swing.JToolBar toolBarTop,toolBarLeft, toolBarBottom;
    private static javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton button;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JMenuItem menuitem;
    private javax.swing.JCheckBoxMenuItem checkBoxMenuItem;
    
    private javax.swing.JPanel topToolBarPanel;
    
    private posi.sys.all.expeditors.database.db_connect db = null;
    public inventoryMngt(){ //System,Metal, Motif, GTK
        new posi.sys.expeditors.LooknFeel("Metal");
        
        setIconImage(sundry.createImageIcon("images/Globe.gif", new java.awt.Dimension(22,22)).getImage());

        db = new posi.sys.all.expeditors.database.db_connect();
        
        screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        menubar = new javax.swing.JMenuBar();
        
        file = new javax.swing.JMenu("File");
        
        menuitem = new javax.swing.JMenuItem("New item", sundry.createImageIcon("images/Document New.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuitem.setMnemonic(KeyEvent.VK_N);
        menuitem.addActionListener(new Action());
        menuitem.setActionCommand("New");
        file.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Recent items", sundry.createImageIcon("images/Footprint.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));        
        menuitem.addActionListener(new Action());
        menuitem.setActionCommand("RecentItem");
        file.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Track items", KeyEvent.VK_T);
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        menuitem.addActionListener(new Action());
        menuitem.setActionCommand("TrackItem");
        file.add(menuitem);
        
        file.addSeparator();
        
        submenu = new javax.swing.JMenu("Export items");
        submenu.setMnemonic(KeyEvent.VK_E);
        
        menuitem = new javax.swing.JMenuItem("CSV");
        menuitem.setActionCommand("exportcsv");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Pdf");
        menuitem.setActionCommand("exportpdf");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Excel");
        menuitem.setActionCommand("exportexcel");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);
 
        file.add(submenu);
        
        submenu = new javax.swing.JMenu("Import items");
        submenu.setMnemonic(KeyEvent.VK_I);
        
        menuitem = new javax.swing.JMenuItem("CSV");
        menuitem.setActionCommand("importcsv");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Pdf");
        menuitem.setActionCommand("importpdf");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Excel");
        menuitem.setActionCommand("importexcel");
        menuitem.addActionListener(new Action());
        submenu.add(menuitem);
        
        file.add(submenu);
        
        file.addSeparator();
        
        menuitem = new javax.swing.JMenuItem("Print",sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("print");
        menuitem.addActionListener(new Action());
        file.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Exit");
        menuitem.setActionCommand("Exit");
        menuitem.addActionListener(new Action());
        file.add(menuitem);
        menubar.add(file);
        /*
        edit = new javax.swing.JMenu("Edit");
        
        menuitem = new javax.swing.JMenuItem("Undo",sundry.createImageIcon("images/Arrow2 Left.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("undo");        
        menuitem.addActionListener(new Action());
        edit.add(menuitem);

        menuitem = new javax.swing.JMenuItem("Redo",sundry.createImageIcon("images/Arrow2 Right.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("redo");        
        menuitem.addActionListener(new Action());
        edit.add(menuitem);
        
        edit.addSeparator();
        
        menuitem = new javax.swing.JMenuItem("Cut",sundry.createImageIcon("images/Clipboard Cut.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Cut");        
        menuitem.addActionListener(new Action());
        edit.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Copy",sundry.createImageIcon("images/Clipboard Copy.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Copy");        
        menuitem.addActionListener(new Action());
        edit.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Paste",sundry.createImageIcon("images/Clipboard Paste.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Paste");        
        menuitem.addActionListener(new Action());
        edit.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Delete",sundry.createImageIcon("images/Trash.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Delete"); 
        menuitem.addActionListener(new Action());
        edit.add(menuitem);
        menubar.add(edit);
        */
        view = new javax.swing.JMenu("View");
        
        menuitem = new javax.swing.JMenuItem("Search",sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Search"); 
        menuitem.addActionListener(new Action());
        view.add(menuitem);
        
        menu = new javax.swing.JMenu("Toolbars");
        
        checkBoxMenuItem = new javax.swing.JCheckBoxMenuItem("Navigation");
        checkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_N,  ActionEvent.SHIFT_MASK));
        checkBoxMenuItem.setActionCommand("navigationToolbar"); 
        checkBoxMenuItem.addActionListener(new Action());
        checkBoxMenuItem.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItem);
        
        checkBoxMenuItem = new javax.swing.JCheckBoxMenuItem("Item Controls");
        checkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_I, ActionEvent.SHIFT_MASK));
        checkBoxMenuItem.setActionCommand("ItemControlToolbar"); 
        checkBoxMenuItem.addActionListener(new Action());
        checkBoxMenuItem.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItem);
        
        checkBoxMenuItem = new javax.swing.JCheckBoxMenuItem("Application controls");
        checkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_A,  ActionEvent.SHIFT_MASK));
        checkBoxMenuItem.setActionCommand("ApplicationControlToolbar"); 
        checkBoxMenuItem.addActionListener(new Action());
        checkBoxMenuItem.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItem);
        
        checkBoxMenuItem = new javax.swing.JCheckBoxMenuItem("Ploriferate controls");
        checkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        checkBoxMenuItem.setActionCommand("PloriferateControlToolbar"); 
        checkBoxMenuItem.addActionListener(new Action());
        checkBoxMenuItem.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItem);
         
        checkBoxMenuItem = new javax.swing.JCheckBoxMenuItem("Diminate controls");
        checkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        checkBoxMenuItem.setActionCommand("DiminateControlToolbar"); 
        checkBoxMenuItem.addActionListener(new Action());
        checkBoxMenuItem.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItem);
        
        view.add(menu);
        
        menuitem = new javax.swing.JMenuItem("Applications",sundry.createImageIcon("images/Applications.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Applications"); 
        menuitem.addActionListener(new Action());
        view.add(menuitem);
        
        menu = new javax.swing.JMenu("Stakeholders");
        menuitem = new javax.swing.JMenuItem("Customers",sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Customer"); 
        menuitem.addActionListener(new Action());        
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Suppliers",sundry.createImageIcon("images/Woman.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Supplier"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        view.add(menu);
        
        menubar.add(view);
      
        menu = new javax.swing.JMenu("POS");
        menuitem = new javax.swing.JMenuItem("Point of sale",sundry.createImageIcon("images/Cart2.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("pos"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        menubar.add(menu);
        
        menu = new javax.swing.JMenu("Money matters");
        menuitem = new javax.swing.JMenuItem("Cash management",sundry.createImageIcon("images/Currency Dollar.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

        menuitem.setActionCommand("cashregister"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Accounting",sundry.createImageIcon("images/Light.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("accounting"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        menubar.add(menu);
        
        reports = new javax.swing.JMenu("Reports");
        menuitem = new javax.swing.JMenuItem("Reports",sundry.createImageIcon("images/Stats2.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Reports"); 
        menuitem.addActionListener(new Action());
        reports.add(menuitem);
        menubar.add(reports);
        
        warehouse = new javax.swing.JMenu("Warehouse ");
        menuitem = new javax.swing.JMenuItem("Warehouse control",sundry.createImageIcon("images/Home2.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Warehouse"); 
        menuitem.addActionListener(new Action());
        warehouse.add(menuitem);
        menubar.add(warehouse);
        
        transaction = new javax.swing.JMenu("Transaction");
        menu = new javax.swing.JMenu("Proliferate");
        menu.setIcon(sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        //menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
       // menu.setActionCommand("Proliferate"); 
       // menuitem.addActionListener(new Action());
        transaction.add(menu);
        
        //menuitem = new javax.swing.JMenuItem("Purchases order",sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        menuitem = new javax.swing.JMenuItem("Purchases order");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK ));
        menuitem.setActionCommand("purorder"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        //menuitem = new javax.swing.JMenuItem("Purchases invoice",sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        menuitem = new javax.swing.JMenuItem("Purchases invoice");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_N,  ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("purinvoice"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);

        transaction.add(menu);
        
        menu = new javax.swing.JMenu("Diminate");
        menu.setIcon(sundry.createImageIcon("images/Arrow1 down.gif", new java.awt.Dimension(20, 20)));
       // menuitem.setActionCommand("Diminate"); 
        //menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        //menuitem.addActionListener(new Action());
                
        //menuitem = new javax.swing.JMenuItem("Point of Sale",sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        menuitem = new javax.swing.JMenuItem("Point of Sale");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("pos"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        //menuitem = new javax.swing.JMenuItem("Sales order",sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        menuitem = new javax.swing.JMenuItem("Sales order");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("salesorder"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        //menuitem = new javax.swing.JMenuItem("Sales invoice",sundry.createImageIcon("images/Arrow1 Up.gif", new java.awt.Dimension(20, 20)));
        menuitem = new javax.swing.JMenuItem("Sales invoice");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("salesinvoice"); 
        menuitem.addActionListener(new Action());
        menu.add(menuitem);
        
        transaction.add(menu);
        menubar.add(transaction);
        
        menu = new javax.swing.JMenu("Administrator");
        admin = new javax.swing.JMenu("Admin controls");
        menu.add(admin);
         
        menuitem = new javax.swing.JMenuItem("Settings",sundry.createImageIcon("images/Tool.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("Settings"); 
        menuitem.addActionListener(new Action());
        admin.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Security",sundry.createImageIcon("images/Security.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("Security"); 
        menuitem.addActionListener(new Action());
        admin.add(menuitem);
        menubar.add(menu);
        
        menuitem = new javax.swing.JMenuItem("User management",sundry.createImageIcon("images/Woman.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("userManagement"); 
        menuitem.addActionListener(new Action());
        admin.add(menuitem);
        menubar.add(menu);
        
        logout = new javax.swing.JMenu("Go away");
        menuitem = new javax.swing.JMenuItem("Logout",sundry.createImageIcon("images/Go out.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.SHIFT_MASK| ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Logout"); 
        menuitem.addActionListener(new Action());
        logout.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Exit",sundry.createImageIcon("images/Standby.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Exit"); 
        menuitem.addActionListener(new Action());
        logout.add(menuitem);
        
        menubar.add(logout);
        
        menubar.add(new javax.swing.JMenu("Help"));
        
        this.setJMenuBar(menubar);
        splitPane = new javax.swing.JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        topToolBarPanel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
       // topToolBarPanel;
        toolBarTop = new javax.swing.JToolBar();
        this.addToolbarContentTop_1(toolBarTop);
        toolBarTop.setName("Item Control");
        //toolBarTop.setPreferredSize(new java.awt.Dimension(180, 30));
        topToolBarPanel.add(toolBarTop);
        
        toolBarTop = new javax.swing.JToolBar();
        this.addToolbarContentTop_2(toolBarTop); 
        toolBarTop.setName("Navigator");
        //toolBarTop.setPreferredSize(new java.awt.Dimension(150, 30));
        topToolBarPanel.add(toolBarTop);
        
        toolBarTop = new javax.swing.JToolBar();
        this.addToolbarContentTop_3(toolBarTop); 
        toolBarTop.setName("System Control");
        
       // toolBarTop.setPreferredSize(new java.awt.Dimension(100, 30));
        topToolBarPanel.add(toolBarTop);
        
        this.add(topToolBarPanel,BorderLayout.PAGE_START);
        
        toolBarLeft = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        toolBarLeft.setFloatable(false);
        this.addToolbarContentLeft(toolBarLeft);
        this.add(toolBarLeft,BorderLayout.LINE_START);
       
        toolBarBottom = new javax.swing.JToolBar();
        this.addToolbarContentBottom_1(toolBarBottom);        
        //toolBarTop.setPreferredSize(new java.awt.Dimension(200, 30));
        this.add(toolBarBottom,BorderLayout.PAGE_END);        
        
       /* toolBarBottom = new javax.swing.JToolBar();
        this.addToolbarContentBottom_2(toolBarBottom);        
        toolBarTop.setPreferredSize(new java.awt.Dimension(200, 30));
        this.add(toolBarBottom,BorderLayout.AFTER_LAST_LINE);  
         */
        
        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
                                            
        addTabPane("Inventory list",posi.sys.all.inv.reports.InvAll(),"Close inventory");
                
        splitPane.setLeftComponent(new posi.sys.all.inv.inventoryJTree().getContent());

        splitPane.setDividerLocation(220);
        splitPane.setContinuousLayout(true);
        splitPane.setEnabled(false);
        splitPane.setRightComponent(tabbedPane);
        
        this.add(splitPane,BorderLayout.CENTER);
    }
    
    public javax.swing.JTable getCurrentTable(){
        javax.swing.JComponent c = (javax.swing.JComponent)tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
        javax.swing.JScrollPane scrollpane = (javax.swing.JScrollPane)c.getComponent(2);
        
        javax.swing.JTable table = (javax.swing.JTable)scrollpane.getComponent(1);
    return table;  
    }
    
    public static void addTabPane(String title,java.awt.Component c, String tooltip){
        if (tabbedPane.indexOfTab(title) == -1 ){
            javax.swing.ImageIcon n = null;
            
            tabbedPane.addTab(title,sundry.createImageIcon("images/Cancel.gif", new java.awt.Dimension(17, 17)),c,tooltip);
            tabbedPane.setSelectedIndex( tabbedPane.indexOfTab( title ) );
        }else {
            tabbedPane.setSelectedIndex( tabbedPane.indexOfTab( title ) );
        }
        
    }
   
    public void removeTab(){
        
    }
    
    public void removeAllTab(){
        tabbedPane.removeAll();
    }
    public void setsplitPaneRightComponent(java.awt.Component c){
        splitPane.setRightComponent(c);
    }
    
    public void setsplitPaneLeftComponent(java.awt.Component c){
        splitPane.setRightComponent(c);
    }
    
    private void addToolbarContentLeft(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton("Reports");
        button.setAlignmentX(BOTTOM_ALIGNMENT);
        button.setUI(new posi.sys.expeditors.VerticalButtonUI(270));
        button.setActionCommand("ReportV");
        button.addActionListener(new Action());
        toolbar.add(button);
        
        toolbar.addSeparator();
        
        button = new javax.swing.JButton("Inventory list");
        button.setAlignmentX(BOTTOM_ALIGNMENT);
        button.setUI(new posi.sys.expeditors.VerticalButtonUI(270));
        button.setActionCommand("InvAllV");
        button.addActionListener(new Action());
        toolbar.add(button);
        
        toolbar.addSeparator();
        
        button = new javax.swing.JButton("Track item");
        button.setAlignmentX(BOTTOM_ALIGNMENT);
        button.setUI(new posi.sys.expeditors.VerticalButtonUI(270));
        button.setActionCommand("trackItemV");
        button.addActionListener(new Action());
        toolbar.add(button);
        
        toolbar.addSeparator();
        
        button = new javax.swing.JButton("Home");
        button.setAlignmentX(BOTTOM_ALIGNMENT);
        button.setUI(new posi.sys.expeditors.VerticalButtonUI(270));
        button.setActionCommand("mainAllV");
        button.addActionListener(new Action());
        toolbar.add(button);
    }
    
    private void addToolbarContentBottom_1(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(sundry.createImageIcon("images/Clock.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Clock");
        button.addActionListener(new Action());
        button.setToolTipText("Open clock");
	button.setContentAreaFilled(false);
        toolbar.add(button);         
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Calendar.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Calendar");
        button.addActionListener(new Action());
        button.setToolTipText("Calendar application");
	button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Calc.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("calc");
        button.addActionListener(new Action());
        button.setToolTipText("Open calculator");
	button.setContentAreaFilled(false);
        toolbar.add(button);  
   }
 
    private void addToolbarContentBottom_2(javax.swing.JToolBar toolbar){    
        button = new javax.swing.JButton(sundry.createImageIcon("images/Text Minus.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Text-");
        button.addActionListener(new Action());
        button.setToolTipText("Reduce font");
	button.setContentAreaFilled(false);
        toolbar.add(button);   
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Text Plus.gif", new java.awt.Dimension(25, 25)));
        button.setActionCommand("Text+");
        button.addActionListener(new Action());
        button.setToolTipText("Increase font");
	button.setContentAreaFilled(false);
        toolbar.add(button);        
    }
    
    private void addToolbarContentTop_1(javax.swing.JToolBar toolbar){
         button = new javax.swing.JButton(sundry.createImageIcon("images/Document New.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("New");
        button.addActionListener(new Action());
        button.setToolTipText("New item");
	button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Save.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Save");
        button.addActionListener(new Action());
        button.setToolTipText("Save");
        button.setContentAreaFilled(false);
        toolbar.add(button);

        button = new javax.swing.JButton(sundry.createImageIcon("images/Write.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Edit");
        button.addActionListener(new Action());
        button.setToolTipText("Edit item");
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Trash.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Remove");
        button.addActionListener(new Action());
        button.setToolTipText("Remove item");
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Print");
        button.addActionListener(new Action());
        button.setToolTipText("Print");
        button.setContentAreaFilled(false);
        toolbar.add(button);
    }
    
    private void addToolbarContentTop_2(javax.swing.JToolBar toolbar){        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow2 Left.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Undo");
        button.addActionListener(new Action());
        button.setToolTipText("Undo");
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Arrow2 Right.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Redo");
        button.addActionListener(new Action());
        button.setToolTipText("Redo");
        button.setContentAreaFilled(false);
        toolbar.add(button);        
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Search.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Search");
        button.addActionListener(new Action());
        button.setToolTipText("Search");
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Refresh.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Refresh");
        button.addActionListener(new Action());
        button.setToolTipText("Refresh");
        button.setContentAreaFilled(false);
        toolbar.add(button);
    }

    private void addToolbarContentTop_3(javax.swing.JToolBar toolbar){  
        button = new javax.swing.JButton(sundry.createImageIcon("images/Stats2.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Reports");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("View Reports");
        toolbar.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Tool.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Settings");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("Manage settings");
        toolbar.add(button);

        button = new javax.swing.JButton(sundry.createImageIcon("images/Security.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Security");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("Manage security");
        toolbar.add(button);
        
        toolbar.addSeparator();
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Go Out.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Logout");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("Logout");
        toolbar.add(button);       
        
    }    
    public void display(String title){
        this.setSize(screen.width, screen.height);
        this.setVisible(true);
        this.setTitle(title);
        this.setLocation((screen.width - getWidth())/2,((screen.height-getHeight())/2));
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
             if("New".equals(e.getActionCommand())){
                new posi.sys.all.inv.newItem().setVisible(true);
            }else if("Save".equals(e.getActionCommand())){
            
            }else if("Edit".equals(e.getActionCommand())){
                if( inventoryTable.table().getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null, "Please select item row!","Select item", JOptionPane.WARNING_MESSAGE);
                }else{
                    Object itemId = inventoryTable.table().getValueAt(inventoryTable.table().getSelectedRow(), 0);
                    new posi.sys.all.inv.newItem(Integer.parseInt(itemId.toString())).setVisible(true);
                }
            }else if("Refresh".equals(e.getActionCommand())){
            
            }else if("Print".equals(e.getActionCommand())){
                try {
                    if (!inventoryTable.table().print()) {
                        System.err.println("User cancelled printing");
                    }
                } catch (java.awt.print.PrinterException exception) {
                    System.err.format("Cannot print %s%n", exception.getMessage());
                }

            }else if("Remove".equals(e.getActionCommand())){
                int n = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to remove item?", "Continue with changes?",javax.swing.JOptionPane.YES_NO_OPTION);
                if( n == 0){
                      
                }else{
                }
            }else if("Undo".equals(e.getActionCommand())){
                
            }else if("Redo".equals(e.getActionCommand())){
     
            }else if("Exit".equals(e.getActionCommand())){
                System.exit(0);
            }else if("Search".equals(e.getActionCommand())){
                new posi.sys.all.inv.Search().setVisible(true);
            } else if("Logout".equals(e.getActionCommand())){
                new posi.sys.expeditors.Login();
            } else if("warehouse".equals(e.getActionCommand())){
                new posi.sys.expeditors.Login();
            } else if("InvAllV".equals(e.getActionCommand())){
                addTabPane("Inventory list", posi.sys.all.inv.reports.InvAll(),"Close inventory");
                
            } else if("ReportV".equals(e.getActionCommand()) || "Reports".equals(e.getActionCommand())){                
                splitPane.setLeftComponent(inventoryJTree.updateTree());
                splitPane.setDividerLocation(220);
               // removeAllTab();
            } else if("trackItemV".equals(e.getActionCommand()) || "TrackItem".equals(e.getActionCommand())){
                new posi.sys.all.inv.trackItem().setVisible(true);
            } else if("mainAllV".equals(e.getActionCommand())){
                splitPane.setLeftComponent(new inventoryJTree().getContent());
                splitPane.setDividerLocation(220);                
               // removeAllTab();
            } else if("Diminate".equals(e.getActionCommand())){
                new posi.sys.all.inv.transaction.diminate().setVisible(true);
            } else if("Proliferate".equals(e.getActionCommand())){
                new posi.sys.all.inv.transaction.prolifilate().setVisible(true);
            } else if("RecentItem".equals(e.getActionCommand())){
                new posi.sys.all.inv.RecentItems().setVisible(true);
            } else if("Toolbars".equals(e.getActionCommand())){
                
            } else if("Applications".equals(e.getActionCommand())){
                new posi.sys.expeditors.application.applications().setVisible(true);
            } else if("Settings".equals(e.getActionCommand())){
                new posi.sys.all.inv.Settings().setVisible(true);
            }  else if("Security".equals(e.getActionCommand())){
                new posi.sys.all.inv.Security().setVisible(true);
            }  else if("Warehouse".equals(e.getActionCommand())){
                new posi.sys.all.inv.Warehouse().setVisible(true);
            }else if("pos".equals(e.getActionCommand())){
                new posi.sys.all.pos.POS().setVisible(true);
            } else  if("PloriferateControlToolbar".equals(e.getActionCommand())){
                //PloriferateControlToolbar
                if("itemControl".equals(toolBarTop.getName())){
                    System.out.println("item");
                }
            } else  if("DiminateControlToolbar".equals(e.getActionCommand())){
                //navigationToolbar
                if("itemControl".equals(toolBarTop.getName())){
                    System.out.println("item");
                }
            }else  if("ApplicationControlToolbar".equals(e.getActionCommand())){
                //navigationToolbar
                if("SystemControl".equals(toolBarTop.getName())){
                    System.out.println("sys");
                }
            }else  if("ItemControlToolbar".equals(e.getActionCommand())){
                //navigationToolbar
                if("itemControl".equals(toolBarTop.getName())){
                    System.out.println("Nav");
                }
            }else  if("navigationToolbar".equals(e.getActionCommand())){
                //navigationToolbar
                if("navigator".equals(toolBarTop.getName())){
                    System.out.println("Nav");
                }
            }
        }        
    }// 
    
    public static void main(String [] args ){
       new inventoryMngt().display("POSI Management system");
    }
}
