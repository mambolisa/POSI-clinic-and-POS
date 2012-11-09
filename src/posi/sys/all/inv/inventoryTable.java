/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.BorderLayout;

/**
 *
 * @author Aquarius
 */
public class inventoryTable extends javax.swing.JTable{
    private String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};

    private Object[][] data = {
        {"Mary", "Campione",
         "Snowboarding", new Integer(5), new Boolean(false)},
        {"Alison", "Huml",
         "Rowing", new Integer(3), new Boolean(true)},
        {"Kathy", "Walrath",
         "Knitting", new Integer(2), new Boolean(false)},
        {"Sharon", "Zakhour",
         "Speed reading", new Integer(20), new Boolean(true)},
        {"Philip", "Milne",
         "Pool", new Integer(10), new Boolean(false)}
    };

    private javax.swing.JTable table;

    private javax.swing.JScrollPane scrollPane;
    
    public inventoryTable(){
        table = new javax.swing.JTable(data, columnNames);
        scrollPane= new javax.swing.JScrollPane(table);
        table.setFillsViewportHeight(true);
    }
    
    public javax.swing.JScrollPane table(){
        return scrollPane;
    }
}
