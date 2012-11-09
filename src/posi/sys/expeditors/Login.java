/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.expeditors;

/**
 *
 * @author Aquarius
 */
public class Login{
    public Login(){
        new posi.sys.expeditors.popup(new java.awt.Dimension(500, 400), "Login").setVisible(true);
    }
    public static void main(String args[]){
        new Login();
    }
}
