/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.admin;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 *
 * @author Aquarius
 */
public class user_mng_en extends posi.sys.expeditors.popup {
    private String user_id;
    
    private javax.swing.JPanel panel = new javax.swing.JPanel();
    
    private javax.swing.JTextField emp_id, fname, mname, lname, dob, idnum, serail_num, 
            krapin,nssfnum,date_enrolled, rank,salary;
    
    private javax.swing.JComboBox type;
    
    private javax.swing.JLabel emp_id_label, fname_label, mname_label, lname_label, dob_label, idnum_label, serail_num_label, 
            krapin_label,nssfnum_label,date_enrolled_label, rank_label,salary_label,type_label;
    
    private javax.swing.JButton next, prev, cancel, save;
    
    private Object [] data;
    
    private posi.sys.all.expeditors.database.db_connect db = new posi.sys.all.expeditors.database.db_connect();
    
    public user_mng_en(){
        super(new java.awt.Dimension(450,630),"Manage user");
        
        content();
    }
    
    public user_mng_en(String index){
        super(new java.awt.Dimension(450,630),"Manage user");
        
        this.user_id = index;
        
        content();
        
        populate();
    }
    
    public final void populate(){
        Object data_ [];
        if (!"".equals(this.user_id)){
            String sql = "SELECT * FROM employees WHERE `employee_id` = "+ user_id + "";
//            System.out.print(sql);
            data_ = db.getRow(sql);
            
            emp_id.setText( data_[0].toString() );
            fname.setText( data_[1].toString() );
            mname.setText( data_[2].toString() );
            lname.setText( data_[3].toString() );            
            dob.setText( data_[4].toString() );
            idnum.setText( data_[5].toString() );            
            serail_num.setText( data_[6].toString() );
            krapin.setText( data_[7].toString() );
            nssfnum.setText( data_[8].toString() );
            date_enrolled.setText( ""+data_[9] );
            rank.setText( data_[10].toString() );
            salary.setText( data_[11].toString() );
            type.setSelectedIndex(Integer.parseInt(data_[12].toString()));
        }
    }
    
    public final void content(){
        javax.swing.JPanel pane;
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        emp_id_label = new javax.swing.JLabel("Employer ID: ", SwingConstants.RIGHT);
        emp_id_label.setPreferredSize(new java.awt.Dimension(100, 30));
        emp_id = new javax.swing.JTextField(14);
        emp_id.setPreferredSize(new java.awt.Dimension(150, 30));
        emp_id.setEditable( false );
        pane.add(emp_id_label);
        pane.add(emp_id);
        panel.add(pane);

        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        fname_label = new javax.swing.JLabel("First name: ", SwingConstants.RIGHT);
        fname_label.setPreferredSize(new java.awt.Dimension(100, 30));
        fname = new javax.swing.JTextField(20);
        fname.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(fname_label);
        pane.add(fname);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        mname_label = new javax.swing.JLabel("Middle name: ", SwingConstants.RIGHT);
        mname_label.setPreferredSize(new java.awt.Dimension(100, 30));
        mname = new javax.swing.JTextField(20);
        mname.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(mname_label);
        pane.add(mname);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        lname_label = new javax.swing.JLabel("Last name: ", SwingConstants.RIGHT);
        lname_label.setPreferredSize(new java.awt.Dimension(100, 30));
        lname = new javax.swing.JTextField(20);
        lname.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(lname_label);
        pane.add(lname);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        dob_label = new javax.swing.JLabel("DOB: ", SwingConstants.RIGHT);
        dob_label.setPreferredSize(new java.awt.Dimension(100, 30));
        dob = new javax.swing.JTextField(20);
        dob.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(dob_label);
        pane.add(dob);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        idnum_label = new javax.swing.JLabel("ID num: ", SwingConstants.RIGHT);
        idnum_label.setPreferredSize(new java.awt.Dimension(100, 30));
        idnum = new javax.swing.JTextField(20);
        idnum.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(idnum_label);
        pane.add(idnum);
        panel.add(pane);
       
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        serail_num_label = new javax.swing.JLabel("Serial num: ", SwingConstants.RIGHT);
        serail_num_label.setPreferredSize(new java.awt.Dimension(100, 30));
        serail_num = new javax.swing.JTextField(20);
        serail_num.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(serail_num_label);
        pane.add(serail_num);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        krapin_label = new javax.swing.JLabel("KRA pin: ", SwingConstants.RIGHT);
        krapin_label.setPreferredSize(new java.awt.Dimension(100, 30));
        krapin = new javax.swing.JTextField(20);
        krapin.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(krapin_label);
        pane.add(krapin);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        nssfnum_label = new javax.swing.JLabel("NSSF num: ", SwingConstants.RIGHT);
        nssfnum_label.setPreferredSize(new java.awt.Dimension(100, 30));
        nssfnum = new javax.swing.JTextField(20);
        nssfnum.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(nssfnum_label);
        pane.add(nssfnum);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        date_enrolled_label = new javax.swing.JLabel("Date enrolled: ", SwingConstants.RIGHT);
        date_enrolled_label.setPreferredSize(new java.awt.Dimension(100, 30));
        date_enrolled = new javax.swing.JTextField(20);
        date_enrolled.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(date_enrolled_label);
        pane.add(date_enrolled);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        rank_label = new javax.swing.JLabel("Rank: ", SwingConstants.RIGHT);
        rank_label.setPreferredSize(new java.awt.Dimension(100, 30));
        rank = new javax.swing.JTextField(20);
        rank.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(rank_label);
        pane.add(rank);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        salary_label = new javax.swing.JLabel("Salary: ", SwingConstants.RIGHT);
        salary_label.setPreferredSize(new java.awt.Dimension(100, 30));
        salary = new javax.swing.JTextField(20);
        salary.setPreferredSize(new java.awt.Dimension(200, 30));
        pane.add(salary_label);
        pane.add(salary);
        panel.add(pane);
        
        String sql = "SELECT employee_role_name FROM employee_roles;";
        data = db.getColData(sql);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 35));
        type_label = new javax.swing.JLabel("Type: ", SwingConstants.RIGHT);
        type_label.setPreferredSize(new java.awt.Dimension(100, 30));
        type = new javax.swing.JComboBox( data );
        type.setPreferredSize(new java.awt.Dimension(150, 30));
        pane.add(type_label);
        pane.add(type);
        panel.add(pane);
        
        pane = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        pane.setPreferredSize(new java.awt.Dimension(getWidth() - 10, 40));
        
        prev = new javax.swing.JButton( "<< Previous" );
        prev.addActionListener(new Action());
        pane.add( prev );
        
        save = new javax.swing.JButton( "Save" );
        save.addActionListener(new Action());
        pane.add( save );
        
        cancel = new javax.swing.JButton( "Cancel" );
        cancel.addActionListener(new Action());
        pane.add( cancel );
        
        next = new javax.swing.JButton( "Next >>" );
        next.addActionListener(new Action());
        pane.add( next );
        
        panel.add(pane);        
        
        add(panel);
    }
    
    public static void main(String [] args){
        new user_mng_en().setVisible(true);
    }
    
    class Action implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() == cancel){
                setVisible( false );
                dispose();
            }else if( e.getSource() == next){
                
            }else  if( e.getSource() == prev){
                
            }else  if( e.getSource() == save){
                
            }
        }
        
    }
}
