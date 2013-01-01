/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.pos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import posi.sys.all.inv.inventoryMngt;
import posi.sys.expeditors.popup;

/**
 *
 * @author Aquarius
 */

public class PosSale  extends popup {
    private javax.swing.JLabel label;
    private javax.swing.JTextField total, disc, qty, user, session, invoice, change, time, recieved;
    private javax.swing.JPanel panel = new javax.swing.JPanel();
    private java.awt.Dimension pane_dimension, label_dimension;
    
    private java.awt.Font font, font_text;
    
    private java.awt.Dimension textfield_dimensions;
    
    private javax.swing.JButton button;
    
    private String [] user_info;
    
    public PosSale(Object [] info){
        super(new java.awt.Dimension( 470, 600 ), "POS sale summary" );
        
        pane_dimension = new java.awt.Dimension(getWidth() - 10, 50);
        label_dimension = new java.awt.Dimension(100, 30);
        textfield_dimensions = new java.awt.Dimension(270, 37);
        font = new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 15);
        font_text = new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 16);
        
        user_info = inventoryMngt.get_user_info();
        
        content(info);
    }
    
    public static void main(String [] args){
        new PosSale(new Object[]{}).setVisible(true);
    }
    
    private void content(final Object [] info){
        javax.swing.JPanel pane;
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Recieved: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        recieved = new javax.swing.JTextField();
        recieved.setPreferredSize( textfield_dimensions );
        recieved.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    final int cha = (int)(Double.parseDouble(recieved.getText()) - Double.parseDouble(info[0].toString()));
                    
                    final popup p = new popup(new java.awt.Dimension(450, 150), "Change");
                    javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
                    
                    javax.swing.JTextField text = new javax.swing.JTextField(  );
                    text.setText( ""+cha );
                    text.setPreferredSize(new java.awt.Dimension(230, 100));
                    text.setEditable(false);
                    text.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 60));
                    text.addKeyListener(new java.awt.event.KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) { }
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if( e.getKeyCode() == 10){
                                p.dispose();
                                change.setText( ""+cha );
                            }
                        }
                        @Override
                        public void keyReleased(KeyEvent e) { }
                    });
                    javax.swing.JLabel label = new javax.swing.JLabel("Change");
                    label.setPreferredSize(new java.awt.Dimension(150,100));
                    label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 30));
                    panel.add( label );
                    panel.add(text);
                    
                    p.add(panel);
                    p.setVisible(true);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { }
        });        
        recieved.setFont( font_text );
        pane.add( label );
        pane.add( recieved );
        panel.add( pane );
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Amount: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        total = new javax.swing.JTextField(info[0].toString());
        total.setPreferredSize( textfield_dimensions );
        total.setFont( font_text );
        total.setEditable( false );
        pane.add( label );
        pane.add( total );
        panel.add( pane );
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Discount: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        disc = new javax.swing.JTextField(info[1].toString());
        disc.setPreferredSize( textfield_dimensions );
        disc.setFont( font_text );
        disc.setEditable( false );
        pane.add(label);
        pane.add(disc);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Quantity: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        qty = new javax.swing.JTextField(info[2].toString());
        qty.setFont( font_text );
        qty.setPreferredSize( textfield_dimensions );
        qty.setEditable( false );
        pane.add(label);
        pane.add(qty);
        panel.add(pane);
        
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Change: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        change = new javax.swing.JTextField();
        change.setFont( font_text );
        change.setPreferredSize( textfield_dimensions );
        change.setEditable( false );
        pane.add( label );
        pane.add( change );
        panel.add( pane );
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Invoice ID: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        invoice = new javax.swing.JTextField();
        invoice.setFont( font_text );
        invoice.setPreferredSize( textfield_dimensions );
        invoice.setEditable( false );
        pane.add(label);
        pane.add(invoice);
        panel.add(pane);

        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("User rep: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        user = new javax.swing.JTextField(user_info[1].toString()+" "+user_info[2].toString());
        user.setFont( font_text );
        user.setPreferredSize( textfield_dimensions );
        user.setEditable( false );
        pane.add( label );
        pane.add( user );
        panel.add( pane );
                
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Session: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        session = new javax.swing.JTextField();
        session.setFont( font_text );
        session.setPreferredSize(textfield_dimensions);
        session.setEditable( false );
        pane.add( label );
        pane.add( session );
        panel.add( pane );
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize( pane_dimension );
        label = new javax.swing.JLabel("Time: ", javax.swing.SwingConstants.RIGHT);
        label.setFont( font );
        label.setPreferredSize( label_dimension );
        
        time = new javax.swing.JTextField(info[6].toString().trim());
        time.setFont( font_text );
        time.setPreferredSize(textfield_dimensions);
        time.setEditable( false );
        pane.add( label );
        pane.add( time );
        panel.add( pane );
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        pane.setPreferredSize( pane_dimension );
        
        button = new javax.swing.JButton("Commit");
        button.setPreferredSize(new java.awt.Dimension(150, 40));
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commitSales();
            }
        });
        pane.add( button );
                
        button = new javax.swing.JButton("Print reciept");
        button.setPreferredSize(new java.awt.Dimension(150, 40));
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                printReciept();
            }
        });
        pane.add( button );
        
        button = new javax.swing.JButton("Cancel");
        button.setPreferredSize(new java.awt.Dimension(100, 40));
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        pane.add( button );
        panel.add( pane );
        
    getContentPane().add(panel);
    }
    
    private void commitSales(){
        
    }
    
    private void printReciept(){
        
    }
    
    private void showQRCode(){
        
    }    
}
