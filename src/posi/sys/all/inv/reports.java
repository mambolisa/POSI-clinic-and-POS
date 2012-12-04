/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Aquarius
 */
public class reports extends posi.sys.expeditors.popup implements javax.swing.event.ListSelectionListener {
    private javax.swing.JPanel panelTop,panelBottom;
    private javax.swing.JButton button1, button2;
    private javax.swing.JSplitPane splitpanel;
    private javax.swing.JList listGraph,listTable;
    
    private int divider_location = 150 ;
    Object [] TableLeftdata = {"Table 1","Table 2","Table 3","Table 4","Table 5"};
    Object [] GraphLeftdata = {"Graph 1","Graph 2","Graph 3","Graph 4"};
    
    public reports(){
        super(new java.awt.Dimension(1000,650),"Reports");
        addContent();
    }
    
    private void addContent(){
        panelTop = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.CENTER, 10, 15));
       // panelTop.setBackground(Color);
        splitpanel = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT);
        splitpanel.setDividerLocation(divider_location);
        splitpanel.setEnabled(false);
        
        button1 = new javax.swing.JButton("Graphs");
        button1.setPreferredSize(new java.awt.Dimension(170, 35));
        button1.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                listGraph = new javax.swing.JList( GraphLeftdata ); 
                
                splitpanel.setDividerLocation(divider_location);
                splitpanel.setLeftComponent(LeftContent(listGraph));
                splitpanel.setRightComponent(GraphRightContent());
            }
        
        });
        panelTop.add(button1);
        
        button2 = new javax.swing.JButton("Tables");
        button2.setPreferredSize(new java.awt.Dimension(170, 35));
        button2.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                listTable = new javax.swing.JList( TableLeftdata ); 
                
                splitpanel.setDividerLocation(divider_location);
                splitpanel.setLeftComponent(LeftContent(listTable));
                splitpanel.setRightComponent(TableRightContent());
            }
        
        });
        panelTop.add(button2);
        
        add(panelTop, BorderLayout.PAGE_START);
        listGraph = new javax.swing.JList( GraphLeftdata ); 
        
        splitpanel.setLeftComponent( LeftContent( listGraph ) );
        splitpanel.setRightComponent(GraphRightContent( ) );
        
        add(splitpanel,BorderLayout.CENTER);
        
        panelBottom = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT, 10, 15));
        add(panelBottom,BorderLayout.PAGE_END);
        
    }
    
        
    private javax.swing.JScrollPane LeftContent(javax.swing.JList list){        
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(javax.swing.JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        javax.swing.JScrollPane listScroller = new javax.swing.JScrollPane(list);
        listScroller.setPreferredSize(new java.awt.Dimension(100, 200));
        
    return listScroller;
    }
   
    private javax.swing.JComponent GraphRightContent(){
        return new javax.swing.JButton("Button Graph");
    }
    
    private javax.swing.JComponent TableRightContent(){
        return new javax.swing.JButton("Button Graph");
        
    }
    public static void main(String[] args){
        new reports().setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if( e.getSource() == listGraph ){
            
        }else if( e.getSource() == listTable  ){
            
        }
        System.out.println(e.getLastIndex());
    }
}
