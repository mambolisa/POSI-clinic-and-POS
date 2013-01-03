/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */
public class reports extends posi.sys.expeditors.popup implements javax.swing.event.ListSelectionListener,java.awt.event.ActionListener {
    private javax.swing.JPanel panelTop,panelBottom,panel;
    private javax.swing.JButton button,button1, button2;
    private javax.swing.JSplitPane splitpanel;
    private javax.swing.JList listGraph,listTable;
    private javax.swing.JToolBar toolbar, toolbar1;
    private javax.swing.JComboBox combo;
    private int divider_location = 150 ;
    
    private javax.swing.JList list;
    
    Object [] SalesList = {"All Sales","Recent sales","Slow moving","Sales return"};
    Object [] PurList = {"All purchases","Recent purchases","Purchases return"};
    Object [] SysList = {"User sys usage","Audit trails"};
    
    public reports(){
        super(new java.awt.Dimension(1100,670),"Reports");
        addContent();
    }
    
    private void addContent(){
        panelTop = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT));
        panelTop.setPreferredSize(new java.awt.Dimension(1000, 60));
        toolbar = new javax.swing.JToolBar();
        toolbar.setFloatable(false);
                
       // panelTop.setBackground(Color);
        splitpanel = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT);
        splitpanel.setDividerLocation(divider_location);
        splitpanel.setEnabled(false);
       
        panel = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox(new Object[]{"---Choose report type---","Sales","Purchases","System reports", "Users reports"}){   };
        combo.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo.getSelectedIndex() == 1){
                    splitpanel.setLeftComponent(LeftContent(SalesList));
                    splitpanel.setDividerLocation(divider_location);
                }else if(combo.getSelectedIndex() == 2){
                    splitpanel.setLeftComponent(LeftContent(PurList));
                    splitpanel.setDividerLocation(divider_location);
                }else if(combo.getSelectedIndex() == 3){
                    splitpanel.setLeftComponent(LeftContent(SysList));
                    splitpanel.setDividerLocation(divider_location);
                }
            }
        });
        combo.setPreferredSize(new java.awt.Dimension(160, 35));
        panel.add(combo);
       // combo.setSize(100, 35);
        //toolbar.add(combo);
        
        button1 = new javax.swing.JButton(sundry.createImageIcon("images/Graph.gif", new java.awt.Dimension(40, 35)));
        button1.setContentAreaFilled(false);
        //button1.setPreferredSize(new java.awt.Dimension(130, 40));
        //button1.setBounds(80, 3, 130, 40);
        button1.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                splitpanel.setDividerLocation(divider_location);
                splitpanel.setRightComponent(GraphRightContent());
            }
        
        });
        
        toolbar.add(button1);
        
        button2 = new javax.swing.JButton(sundry.createImageIcon("images/Table.gif", new java.awt.Dimension(40, 35)));
        button2.setContentAreaFilled(false);
        //button2.setPreferredSize(new java.awt.Dimension(130, 40));
        //button2.setBounds(220, 3, 130, 35);
        button2.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                splitpanel.setDividerLocation(divider_location);
                splitpanel.setRightComponent(TableRightContent());
            }
        
        });
        toolbar.add(button2);
        
        panelTop.add(toolbar);
                
        toolbar1 = new javax.swing.JToolBar("Controls");
        toolbar1.setFloatable(false);
        button = new javax.swing.JButton(sundry.createImageIcon("images/Printer.gif", new java.awt.Dimension(40, 35)));
        button.setActionCommand("Printer");
        button.addActionListener(this);
        button.setContentAreaFilled(false);
        toolbar1.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Tag.gif", new java.awt.Dimension(40, 35)));
        button.setActionCommand("Export");
        button.addActionListener(this);
        button.setContentAreaFilled(false);
        toolbar1.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Gear.gif", new java.awt.Dimension(40, 35)));
        button.setActionCommand("Settings");
        button.addActionListener(this);
        button.setContentAreaFilled(false);
        toolbar1.add(button);
        
        button = new javax.swing.JButton(sundry.createImageIcon("images/Cancel.gif", new java.awt.Dimension(40, 35)));
        button.setActionCommand("Close");
        button.addActionListener(this);
        button.setContentAreaFilled(false);
        toolbar1.add(button);
        
        panelTop.add(toolbar1);
                
        //panel = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.RIGHT));
        //panel.setPreferredSize(new java.awt.Dimension(300, 30));
        toolbar1 = new javax.swing.JToolBar("Reports");
        toolbar1.setFloatable(false);
        toolbar1.setPreferredSize(new java.awt.Dimension(180, 50));
        //toolbar1.add(new javax.swing.JLabel("Report: "));
        toolbar1.add(panel);
        panelTop.add(toolbar1);
        
        add(panelTop, BorderLayout.PAGE_START);
        
        splitpanel.setLeftComponent( LeftContent( SalesList ) );
        splitpanel.setRightComponent(GraphRightContent( ) );
        
        add(splitpanel,BorderLayout.CENTER);
        
        panelBottom = new javax.swing.JPanel(new java.awt.FlowLayout(FlowLayout.LEFT, 10, 15));
        add(panelBottom,BorderLayout.PAGE_END);
        
    }
    
        
    private javax.swing.JScrollPane LeftContent(Object [] data){ 
        list = new javax.swing.JList( data ); 
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(javax.swing.JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        javax.swing.JScrollPane listScroller = new javax.swing.JScrollPane(list);
        listScroller.setPreferredSize(new java.awt.Dimension(100, 200));
        
    return listScroller;
    }
   
    private javax.swing.JComponent GraphRightContent(){
        return  (defaultChart());
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
    
    public ChartPanel defaultChart(){
                // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, "Stan");
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        
    return chartPanel;
    }
    
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux", 29);
        result.setValue("Mac", 20);
        result.setValue("Windows", 51);
        return result;
        
    }
    
    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Close".equals(e.getActionCommand())){
           dispose();
        }else if("Export".equals(e.getActionCommand())){
           
        }else if("Printer".equals(e.getActionCommand())){
           
        }else if("Settings".equals(e.getActionCommand())){
           new reportSettings(){
               
           }.setVisible(true);
        }
    }
    
}
