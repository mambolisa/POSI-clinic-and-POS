/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable.PrintMode;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */

public class inventoryMngt extends javax.swing.JFrame {
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenu file,/* edit,*/ view,/* options,*/ reports, logout,warehouse, transaction, submenu,menu , admin, help;
    private java.awt.Dimension screen;
    private javax.swing.JToolBar toolBarTop_1,toolBarTop_2,toolBarTop_3,toolBarTop_4,toolBarLeft, toolBarBottom;
    public static ManageTabs tabbedPane;
    private javax.swing.JButton button;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JMenuItem menuitem;
    private javax.swing.JCheckBoxMenuItem checkBoxMenuItemNav, checkBoxMenuItemTrasaction, checkBoxMenuItemSysControl, checkBoxMenuItemIControl;
    ////
    private static javax.swing.JLabel username, session, role;
    private javax.swing.JPanel topToolBarPanel,topToolBarPanelMain, right_top_panel;
    
    private javax.swing.JTextField textfield;
    
    private posi.sys.all.inv.tableReports inv;
    
    private posi.sys.all.expeditors.database.db_connect db = null;
    
    private javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter;
    
    private static String [] user_info = new String[7];
    
    private static String user = "   Username: ", sess = "    Session: ", role_t = "     Role: ";
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
        menuitem.setActionCommand("Print");
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
        
        checkBoxMenuItemNav = new javax.swing.JCheckBoxMenuItem("Navigation");
        checkBoxMenuItemNav.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_N,  ActionEvent.SHIFT_MASK));
        checkBoxMenuItemNav.setActionCommand("navigationToolbar"); 
        checkBoxMenuItemNav.setSelected(true);
        checkBoxMenuItemNav.addItemListener(new itemListen());
        checkBoxMenuItemNav.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItemNav);
        
        checkBoxMenuItemIControl = new javax.swing.JCheckBoxMenuItem("Item Controls");
        checkBoxMenuItemIControl.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_I, ActionEvent.SHIFT_MASK));
        checkBoxMenuItemIControl.setActionCommand("ItemControlToolbar"); 
        checkBoxMenuItemIControl.setSelected(true);
        checkBoxMenuItemIControl.addItemListener(new itemListen());        
        checkBoxMenuItemIControl.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItemIControl);
        //ItemControlToolbar  
        checkBoxMenuItemSysControl = new javax.swing.JCheckBoxMenuItem("System controls");
        checkBoxMenuItemSysControl.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_A,  ActionEvent.SHIFT_MASK));
        checkBoxMenuItemSysControl.setActionCommand("ApplicationControlToolbar"); 
        checkBoxMenuItemSysControl.setSelected(true);
        checkBoxMenuItemSysControl.addItemListener(new itemListen());        
        checkBoxMenuItemSysControl.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItemSysControl);
        
        checkBoxMenuItemTrasaction = new javax.swing.JCheckBoxMenuItem("Transaction");
        checkBoxMenuItemTrasaction.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        checkBoxMenuItemTrasaction.setActionCommand("Transaction"); 
        checkBoxMenuItemTrasaction.setSelected(false);
        checkBoxMenuItemTrasaction.addItemListener(new itemListen());        
        checkBoxMenuItemTrasaction.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItemTrasaction);
         
        /*checkBoxMenuItemDimControl = new javax.swing.JCheckBoxMenuItem("Diminate controls");
        checkBoxMenuItemDimControl.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        checkBoxMenuItemDimControl.setActionCommand("DiminateControlToolbar"); 
        checkBoxMenuItemDimControl.setSelected(false);
        checkBoxMenuItemDimControl.addItemListener(new itemListen());        
        checkBoxMenuItemDimControl.setPreferredSize(new java.awt.Dimension(200, 25));
        menu.add(checkBoxMenuItemDimControl);
        */
        view.add(menu);
        
        menuitem = new javax.swing.JMenuItem("Applications",sundry.createImageIcon("images/Applications.gif", new java.awt.Dimension(20, 20)));
        menuitem.setActionCommand("Applications"); 
        menuitem.addActionListener(new Action());
        view.add(menuitem);
        
        menu = new javax.swing.JMenu("Stakeholders");
        menuitem = new javax.swing.JMenuItem("Customers",sundry.createImageIcon("images/Man.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menuitem.setActionCommand("Customer"); 
        menuitem.addActionListener(new Action());        
        menu.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("Suppliers",sundry.createImageIcon("images/Woman.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
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
        
        menuitem = new javax.swing.JMenuItem("Point of sale touch screen",sundry.createImageIcon("images/Cart2.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke( KeyEvent.VK_T, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("pos_touch"); 
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
        
        menuitem = new javax.swing.JMenuItem("Normal purchases");
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Q,  ActionEvent.SHIFT_MASK));
        menuitem.setActionCommand("normalpur"); 
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
        menuitem = new javax.swing.JMenuItem("Lock",sundry.createImageIcon("images/Lock.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_9,ActionEvent.SHIFT_MASK| ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("Lock"); 
        menuitem.addActionListener(new Action());
        logout.add(menuitem);
        
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
        
        help = new javax.swing.JMenu("Help");
        menuitem = new javax.swing.JMenuItem("Help & Information",sundry.createImageIcon("images/info2.gif", new java.awt.Dimension(20, 20)));
        menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("help"); 
        menuitem.addActionListener(new Action());
        help.add(menuitem);
        
        menuitem = new javax.swing.JMenuItem("About",sundry.createImageIcon("images/Wizard.gif", new java.awt.Dimension(20, 20)));
       // menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        menuitem.setActionCommand("about"); 
        menuitem.addActionListener(new Action());
        help.add(menuitem);
        
        menubar.add(help);
        
        this.setJMenuBar(menubar);
        
        splitPane = new javax.swing.JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        tabbedPane = new ManageTabs();
                
        inv  = new posi.sys.all.inv.tableReports();
        javax.swing.JScrollPane table = inv.InvAll();
        
        sorter = new javax.swing.table.TableRowSorter<javax.swing.table.TableModel>(inv.getTable().getModel());
        inv.getTable().setRowSorter(sorter);
        
        tabbedPane.addTabs("Inventory list",table,"Close inventory");

        splitPane.setLeftComponent( splitpane_left_component());

        splitPane.setDividerLocation(220);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY));
        splitPane.setEnabled(false);
        splitPane.setDividerSize(4);
        splitPane.setRightComponent(tabbedPane);
        
        javax.swing.plaf.basic.BasicSplitPaneDivider divider = ((javax.swing.plaf.basic.BasicSplitPaneUI) splitPane.getUI())
				.getDivider();

        if (divider != null) {
            divider.setBorder(null);
	}
        
        this.add(splitPane,BorderLayout.CENTER);
        
        topToolBarPanelMain = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        //topToolBarPanelMain.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 50));
        topToolBarPanel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        //topToolBarPanel.setPreferredSize(new java.awt.Dimension(getWidth() - 200, 50));
        // topToolBarPanel;
        toolBarTop_1 = new javax.swing.JToolBar();
        this.addToolbarContentTop_1(toolBarTop_1);
        toolBarTop_1.setName("Item Control");
        //toolBarTop.setPreferredSize(new java.awt.Dimension(180, 30));
        topToolBarPanel.add(toolBarTop_1);
        
        toolBarTop_2 = new javax.swing.JToolBar();
        this.addToolbarContentTop_2(toolBarTop_2); 
        toolBarTop_2.setName("Navigator");
        //toolBarTop.setPreferredSize(new java.awt.Dimension(150, 30));
        topToolBarPanel.add(toolBarTop_2);
               
        toolBarTop_3 = new javax.swing.JToolBar();
        this.addToolbarContentTop_3(toolBarTop_3); 
        toolBarTop_3.setName("System Control");
        
       // toolBarTop.setPreferredSize(new java.awt.Dimension(100, 30));
        topToolBarPanel.add(toolBarTop_3);
        
        toolBarTop_4 = new javax.swing.JToolBar();
        this.addToolbarContentTop_4(toolBarTop_4); 
        toolBarTop_4.setName("Search");
        toolBarTop_4.setPreferredSize(new java.awt.Dimension(300, 40));
        topToolBarPanel.add(toolBarTop_4);
        
        topToolBarPanelMain.add(topToolBarPanel);
        
        right_top_panel = new javax.swing.JPanel();
        session = new javax.swing.JLabel(sess+user_info[6], javax.swing.SwingConstants.RIGHT);
        session.setFont(new java.awt.Font(java.awt.Font.SERIF, java.awt.Font.PLAIN, 14));
        //session.setPreferredSize(new java.awt.Dimension(180, 45));
        
        username = new javax.swing.JLabel(user+user_info[5], javax.swing.SwingConstants.RIGHT);
        username.setFont(new java.awt.Font(java.awt.Font.SERIF, java.awt.Font.PLAIN, 14));
        //username.setPreferredSize(new java.awt.Dimension(200, 45));
        
        role = new javax.swing.JLabel(role_t+user_info[6], javax.swing.SwingConstants.RIGHT);
        role.setFont(new java.awt.Font(java.awt.Font.SERIF, java.awt.Font.PLAIN, 14));
        //role.setPreferredSize(new java.awt.Dimension(100, 45));
        
        right_top_panel.add(session);
        right_top_panel.add(username);
        right_top_panel.add(role);
        
        topToolBarPanelMain.add(right_top_panel);
        
        this.add(topToolBarPanelMain,BorderLayout.PAGE_START);
        
        toolBarLeft = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        toolBarLeft.setFloatable(false);
        this.addToolbarContentLeft(toolBarLeft);
        this.add(toolBarLeft,BorderLayout.LINE_START);
       
        toolBarBottom = new javax.swing.JToolBar();
        this.addToolbarContentBottom_1(toolBarBottom);        
        //toolBarTop.setPreferredSize(new java.awt.Dimension(200, 30));
        this.add(toolBarBottom,BorderLayout.PAGE_END);        
        
        addWindowListener(new windowAdapter());
    }

    class windowAdapter extends java.awt.event.WindowAdapter{
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            int option = javax.swing.JOptionPane.showConfirmDialog(null, ""
                         + "Are you sure you want to close application", 
                         "System exit warning!", 
                         javax.swing.JOptionPane.YES_NO_OPTION, 
                         javax.swing.JOptionPane.QUESTION_MESSAGE);
                 
                 if (option == javax.swing.JOptionPane.YES_OPTION){
                     //session loggoff
                     if(Login.logout()){
                        javax.swing.JOptionPane.showMessageDialog(null, ""
                                + "User session closed", 
                                "System exit", 
                                javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                     }else{
                        javax.swing.JOptionPane.showMessageDialog(null, ""
                                + "Error closing sessions, session does not exist", 
                                "System exit", 
                                javax.swing.JOptionPane.INFORMATION_MESSAGE); 
                     }
                 }else if ( option == javax.swing.JOptionPane.NO_OPTION){
                     
                 }
        }
    }
    public static void updateUserDisplay(){
        session.setText(sess+""+user_info[7]);
        username.setText(user+user_info[1]);
        role.setText(role_t+user_info[6]);
        
    }
    public void setsplitPaneRightComponent(java.awt.Component c){
        splitPane.setRightComponent(c);
    }
    
    public void setsplitPaneLeftComponent(java.awt.Component c){
        splitPane.setRightComponent(c);
    }
    
    public java.awt.Component splitpane_left_component(){        
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setPreferredSize(new java.awt.Dimension(210, getHeight() - 200 ));
        
        javax.swing.JTabbedPane tab = new javax.swing.JTabbedPane();
        javax.swing.JPanel panel_top_tree = new javax.swing.JPanel();        
        panel_top_tree.add(new posi.sys.all.inv.inventoryJTree().getContent());
        panel_top_tree.setPreferredSize(new java.awt.Dimension(210, 300));
        tab.add("Query lists", panel_top_tree);
        
        javax.swing.JTabbedPane tab_1 = new javax.swing.JTabbedPane();
        javax.swing.JPanel panel_bottom_tree = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel_bottom_tree.setPreferredSize(new java.awt.Dimension(210,220));
        panel_bottom_tree.setBackground(java.awt.Color.WHITE);
        panel_bottom_tree.add(helper_utilites.default_());
        tab_1.add("Helper utilities",panel_bottom_tree);
        panel.add(tab);
        panel.add(tab_1);
        
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panel);
        scroll.setPreferredSize(new java.awt.Dimension(210, getHeight() - 150 ));
        
    return scroll;
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

        button = new javax.swing.JButton(sundry.createImageIcon("images/Woman.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("userManagement");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("Manage users");
        toolbar.add(button);
        
        toolbar.addSeparator();
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Go Out.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Logout");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        button.setToolTipText("Logout");
        toolbar.add(button);       
        
    }  
  
    private void addToolbarContentTop_4(javax.swing.JToolBar toolbar){  
        //button = new javax.swing.JButton(sundry.createImageIcon("images/Stats2.gif", new java.awt.Dimension(28, 28)));
        textfield = new javax.swing.JTextField();
        textfield.setActionCommand("SearchTextField");
        textfield.requestFocus();
        
        
        textfield.addKeyListener(new java.awt.event.KeyListener(){
            //currentDataObj
            @Override
            public void keyTyped(KeyEvent e) {
                java.awt.Component c = tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
                javax.swing.JScrollPane scrollpane;
                javax.swing.JTable table_sort = null;
                        
                if ("javax.swing.JScrollPane".equals(c.getClass().getName())){
                     scrollpane = (javax.swing.JScrollPane)c;
                     
                      table_sort = (javax.swing.JTable)scrollpane.getViewport().getView();
                      sorter = new javax.swing.table.TableRowSorter<javax.swing.table.TableModel>(table_sort.getModel());
                
                      table_sort.setRowSorter(sorter);                 
                
                      sorter.setRowFilter(javax.swing.RowFilter.regexFilter(textfield.getText()));   
                }
                
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        
        });
        
        toolbar.add(textfield);
        
        button = new javax.swing.JButton("Go");
        button.setActionCommand("searchTextField");
       // button.setPreferredSize(new java.awt.Dimension(100, 45));
        button.addActionListener(new Action());
        //toolbar.add(button);

    }  
   
    public void display(String title){
        this.setSize(screen.width, screen.height);
        this.setVisible(true);
        this.setTitle(title);
        this.setLocation((screen.width - getWidth())/2,((screen.height-getHeight())/2));
        
        setExtendedState(getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    
    public static void set_user_info(String [] info){
        user_info = info;
    }
    
    public static void show_info(){
        for (int i = 0 ; i < user_info.length;i++){
            System.out.println(user_info[i]);
        }
    }
    public static String[] get_user_info(){
        return user_info;
    }
    
    class itemListen implements java.awt.event.ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == checkBoxMenuItemNav){                
                if(e.getStateChange() == ItemEvent.SELECTED ) {
                    toolBarTop_2.setVisible(true);
                }else if(e.getStateChange() == ItemEvent.DESELECTED) {
                    toolBarTop_2.setVisible(false);
                }
            }else if(e.getSource() == checkBoxMenuItemTrasaction){// updaqte
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    toolBarTop_4.setVisible(true);
                }else if(e.getStateChange() == ItemEvent.DESELECTED ) {
                    toolBarTop_4.setVisible(false);
                }
            }else if(e.getSource() == checkBoxMenuItemSysControl){
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    toolBarTop_3.setVisible(true);
                }else if(e.getStateChange() == ItemEvent.DESELECTED ) {
                    toolBarTop_3.setVisible(false);
                }
            }else if(e.getSource() == checkBoxMenuItemIControl){
                if(e.getStateChange() == ItemEvent.SELECTED ) {
                    toolBarTop_1.setVisible(true);
                }else if(e.getStateChange() == ItemEvent.DESELECTED ) {
                    toolBarTop_1.setVisible(false);
                }
            }
        }
        
    }
    class Action implements java.awt.event.ActionListener{
        public Action(){
            
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
             if("New".equals(e.getActionCommand())){
                new posi.sys.all.inv.newItem().setVisible(true);
            }else if("Save".equals(e.getActionCommand())){
            
            }else if("Edit".equals(e.getActionCommand())){
                if( inv.getTable().getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null, "Please select item row!","Select item", JOptionPane.WARNING_MESSAGE);
                }else{
                    Object itemId = inv.getTable().getValueAt(inv.getTable().getSelectedRow(), 0);
                    new posi.sys.all.inv.newItem(Integer.parseInt(itemId.toString()),false).setVisible(true);
                }
            }else if("Refresh".equals(e.getActionCommand())){
                javax.swing.JTable table = printer_helper(); 
                javax.swing.table.AbstractTableModel new_model = (javax.swing.table.AbstractTableModel)table.getModel();
                
            }else if("Print".equals(e.getActionCommand())){ 
                javax.swing.JTable table = printer_helper();
                
                PrinterJob job = PrinterJob.getPrinterJob();
                
                MessageFormat header = new MessageFormat("Header");

                MessageFormat footer = new MessageFormat("Footer");
                
                job.setPrintable(table.getPrintable(PrintMode.NORMAL, header, footer));
               // job.setPrintable(new MyTablePrintable(tblmunim, PrintMode.FIT_WIDTH, header, footer));

                if (job.printDialog()){
                   try {
                     job.print();
                      JOptionPane.showMessageDialog(null,"Completed printing ","Printing success",JOptionPane.INFORMATION_MESSAGE);
                   }
                   catch (PrinterException pe) {
                     JOptionPane.showMessageDialog(null,"Error printing: " + pe,"Printing Error!",JOptionPane.ERROR_MESSAGE);
                   } 
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
                new posi.sys.search.Search(){
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                             new posi.sys.all.inv.newItem(Integer.parseInt(get_item_index()),false).setVisible(true);
                        }else
                             super.setVisible(b);
                    }
                }.setVisible(true);
            } else if("Logout".equals(e.getActionCommand())){
                Login l = new Login(1,user_info[0]){
                    
                };
                //l.re_login_interface();
                
            } else if("warehouse".equals(e.getActionCommand())){
                //new posi.sys.all.inv.Login();
            } else if("InvAllV".equals(e.getActionCommand())){
                tabbedPane.addTabs("Inventory list", inv.InvAll(),"Close inventory");
                
            } else if("ReportV".equals(e.getActionCommand()) || "Reports".equals(e.getActionCommand())){                
                new posi.sys.all.inv.reports().setVisible(true);
               // removeAllTab();
            } else if("trackItemV".equals(e.getActionCommand()) || "TrackItem".equals(e.getActionCommand())){
                new posi.sys.all.inv.trackItem();
            } else if("mainAllV".equals(e.getActionCommand())){
                splitPane.setLeftComponent(splitpane_left_component());
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
                posi.sys.admin.admin admin = new posi.sys.admin.admin();
                admin.settings();
                admin.setVisible( true );
            } else if("userManagement".equals(e.getActionCommand())){//userManagement
                posi.sys.admin.admin admin = new posi.sys.admin.admin();
                admin.user_management();
                admin.setVisible( true );
            }  else if("Security".equals(e.getActionCommand())){
                posi.sys.admin.admin admin = new posi.sys.admin.admin();
                admin.security();
                admin.setVisible( true );
            }  else if("Warehouse".equals(e.getActionCommand())){
                new posi.sys.all.inv.Warehouse().setVisible(true);
            }else if("pos_touch".equals(e.getActionCommand())){
                new posi.sys.all.pos.pos_touch().setVisible(true);
            }else if("pos".equals(e.getActionCommand())){
                new posi.sys.all.pos.POS().setVisible(true);
            }else if("Customer".equals(e.getActionCommand())){
                new posi.sys.search.SearchPersons("cust"){                    
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                             new posi.sys.customer.Customer( get_index() ).setVisible(true);
                        }else {
                            super.setVisible(b);
                        }
                    }
                    
                    @Override
                    public void setTitle(String title){
                        super.setTitle("Search customers");
                    }
                }.setVisible(true);
                
            } else if ("Clock".equals(e.getActionCommand()))  {
                new posi.sys.expeditors.application.Clock().setVisible(true);
            } else if ("Supplier".equals(e.getActionCommand()))  {
                new posi.sys.search.SearchPersons("Supplier"){                    
                    @Override
                    public void setVisible(boolean b) {
                        if( b == false){
                             new posi.sys.supplier.Supplier( get_index() ).setVisible(true);
                        }else {
                            super.setVisible(b);
                        }
                    }
                    
                    @Override
                    public void setTitle(String title){
                        super.setTitle("Search supplier");
                    }
                }.setVisible(true);
            }else if ( "Lock".equals(e.getActionCommand())){
                new posi.sys.all.inv.Login(1,user_info[0]){

                    @Override
                    public void dispose() {
                        super.dispose();
                        System.exit(0);
                    }
                };
            
            }else if ( "normalpur".equals(e.getActionCommand())){
                new posi.sys.all.inv.purchases.default_purchase().setVisible( true );
            }
        }        
    }// 
    
    public static void main(String [] args ){
       new inventoryMngt().display("POSI Management system");
    }
   
   public static void close(){
       System.exit(0);
   }
   
   public static void update_details(String title, String[] info){
       //setTitle(title+ " Current user:" + user_info[1] +" Session: "+ user_info[6]);
   }
   
   private javax.swing.JTable printer_helper(){
       java.awt.Component c = tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
       javax.swing.JScrollPane scrollpane;
       javax.swing.JTable table_ = null;
                        
       if ("javax.swing.JScrollPane".equals(c.getClass().getName())){
          scrollpane = (javax.swing.JScrollPane)c;
          //viewport = scrollpane.getViewport();
                      
           table_ = (javax.swing.JTable)scrollpane.getViewport().getView();  
        }
       
   return table_;
   } 
}
    