/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors.application;

/**
 *
 * @author Aquarius
 */
public class Clock extends posi.sys.expeditors.popup {
    private static boolean isDigital = true;
    private static javax.swing.JLabel label;
    private static java.text.SimpleDateFormat date;
    private static java.util.Date dt;
    private static String dshow;
    
    public Clock(){
        super(new java.awt.Dimension(500,100),"");
        
        if( isDigital ) {
            setDimensions(600, 100);
            label = new javax.swing.JLabel();
            label.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 40));
            getContentPane().add(label);
        
            Digital();
            setTitle("Digital clock");
        } else {
            setDimensions(500, 400);
            Analogue();
            setTitle("Analogue clock");
        }
    }
    
    public static final void Digital(){
        new javax.swing.Timer(1000,new java.awt.event.ActionListener() {
            @Override
             public void actionPerformed(java.awt.event.ActionEvent arg0) {
                date = new java.text.SimpleDateFormat("     yyyy/MM/dd HH:mm:ss a");
                dt = new java.util.Date();
                dshow = date.format(dt);
                label.setText( dshow  );
            }
        }).start();       
    }
    
    public static final void Analogue(){
        
    }
    
    public static void main(String [] args){
        new Clock().setVisible(true);
    }
}
