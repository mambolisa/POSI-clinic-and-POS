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

public class inventory_mngt extends javax.swing.JFrame {
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenu file, edit, view, options, reports, logout ;
    private java.awt.Dimension screen;
    private javax.swing.JToolBar toolBarTop,toolBarLeft;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton button;
    private javax.swing.JPanel toolBarPanel;
    public inventory_mngt(){
        new posi.sys.expeditors.LooknFeel("System");
        
        screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        menubar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu("File");
        edit = new javax.swing.JMenu("Edit");
        view = new javax.swing.JMenu("View");
        options = new javax.swing.JMenu("Options");
        reports = new javax.swing.JMenu("Reports");
        logout = new javax.swing.JMenu("Logout");
        
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(options);
        menubar.add(reports);
        menubar.add(logout);
        
        this.setJMenuBar(menubar);
        
        toolBarPanel = new javax.swing.JPanel(new java.awt.GridLayout(1,2));
        toolBarPanel.setSize(new java.awt.Dimension(400, 30));
        
        toolBarTop = new javax.swing.JToolBar();
        this.addToolbarContentTop(toolBarTop);        
        toolBarTop.setPreferredSize(new java.awt.Dimension(200, 30));
        toolBarPanel.add(toolBarTop);

        toolBarTop = new javax.swing.JToolBar();
        this.addToolbarContentTop(toolBarTop);        
        toolBarTop.setPreferredSize(new java.awt.Dimension(200, 30));
        toolBarPanel.add(toolBarTop);
        
        this.add(toolBarPanel,BorderLayout.PAGE_START);
        
        toolBarLeft = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        this.addToolbarContentLeft(toolBarLeft);
        this.add(toolBarLeft,BorderLayout.LINE_START);
        
        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.addTab("Inventory List",new inventoryTable().table());
        
        this.add(tabbedPane,BorderLayout.CENTER);
    }
    
    private void addToolbarContentLeft(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton("List");
        button.setAlignmentX(BOTTOM_ALIGNMENT);
        button.setBounds(0,50,40, 15);
        toolbar.add(button);
    }
    
    private void addToolbarContentTop(javax.swing.JToolBar toolbar){
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Document New.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("New");
        button.addActionListener(new Action());
        button.setBorderPainted(false);
	button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Save.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Save");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);

        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Write.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Edit");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Refresh.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Refresh");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Trash.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Remove");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Arrow2 Left.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Undo");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Arrow2 Right.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Redo");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Stats 3.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Reports");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button);
        
        button = new javax.swing.JButton(new posi.sys.expeditors.sundry().createImageIcon("images/Go Out.gif", new java.awt.Dimension(28, 28)));
        button.setActionCommand("Exit");
        button.addActionListener(new Action());
        button.setContentAreaFilled(false);
        toolbar.add(button); 
    }

    public void display(String title){
        this.setSize(screen.width, screen.height);
        this.setVisible(true);
        this.setTitle(title);
        this.setLocation((screen.width - getWidth())/2,((screen.height-getHeight())/2));
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    class Action implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             if("New".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Save".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Edit".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Refresh".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Remove".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Undo".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Redo".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }else if("Exit".equals(e.getActionCommand())){
                new posi.sys.expeditors.popup(new java.awt.Dimension(400,500),new javax.swing.JButton("There"),"New Item").setVisible(true);
            }
            
        }
        
    }
    public static void main(String [] args ){
       new inventory_mngt().display("Inventory Management");
    }
}
