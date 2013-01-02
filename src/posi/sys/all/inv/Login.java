/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import posi.sys.admin.user_mng_en;
import posi.sys.all.expeditors.database.db_connect;
import posi.sys.expeditors.audit_trails_actions;

/**
 *
 * @author Aquarius
 */
public class Login extends posi.sys.expeditors.popup{
    private javax.swing.JPanel panel,panel_main;
    private javax.swing.JLabel label;
    private javax.swing.JTextField textfield;
    private javax.swing.JPasswordField passfield;
    private javax.swing.JButton button1, button2;
    private javax.swing.JComboBox combo;
     
    private static db_connect db = new db_connect();
    
    private String error;
    
    private String [] user_info = new String[8];
    
    private int action; // 1 lock, 2 entry
    
    private static java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static java.util.Date dt = new java.util.Date();
    private static String in = date.format(dt),out = date.format(dt);
 
    private javax.swing.GroupLayout layout;
    
    public Login(int action, String user){
        super(new java.awt.Dimension(600, 400), "Login form");                
        
        this.action = action;
        
        logout();
        
        initComponents();
        
        setVisible(true);
    }
    
    public Login(int action){        
        super(new java.awt.Dimension(600, 400), "Login form");                
        
        this.action = action;
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(102, 51, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel3.setText("User type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel( db.getColData("SELECT employee_role_name FROM employee_roles;")));

        jPasswordField1.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == 10){
                    check_login();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_login();
            }
        });
        
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jPasswordField1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    
    public void check_login(){
        if( !login() ){
            javax.swing.JOptionPane.showMessageDialog(null, error, "Login error!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else{
            switch(action){
               case 1: //lock
                 inventoryMngt.set_user_info(user_info);
                 inventoryMngt.updateUserDisplay();
                 setVisible( false );
                 dispose();
                 inventoryMngt.show_info();
               break;
               case 2: // entry                            
                  setVisible ( true );
                  inventoryMngt inv = new inventoryMngt(){
                                
                  };
                  inv.set_user_info(user_info);
                  inv.updateUserDisplay();
                  inv.display("POSI Management system");
                  dispose();
                break;
             }
        }
            
    }
    public boolean login(){
        String sql = ""
                + "SELECT "
                + " e.employee_id,e.employee_fname,e.employee_lname,e.employee_idnum,e.employee_password,e.employee_role_id, er.employee_role_name "
                + " FROM employees as e, employee_roles as er "
                + " WHERE "
                + " e.employee_role_id = er.employee_role_id "
                + " AND e.employee_fname = '"+jTextField1.getText()+"' "
                + " AND e.employee_password='"+jPasswordField1.getText()+"' "
                + " AND e.employee_role_id = '"+ (jComboBox1.getSelectedIndex() + 1)+"';";
       // System.out.println(sql);
        ResultSet rs = db.Query(sql);
        boolean isLogedin= false;
        int count = 0;
        try {
            while ( rs.next() ){
                user_info[0] = rs.getString(1);//emp id
                user_info[1] = rs.getString(2);// emp fname
                user_info[2] = rs.getString(3);//emp lname
                user_info[3] = rs.getString(4);//emp idnum
                user_info[4] = rs.getString(5);//emp pass
                user_info[5] = rs.getString(6);//emp role
                user_info[6] = rs.getString(7);//emp role name
                
                set_session();
                count++;
            }
            
            if ( count == 1 ){
                isLogedin = true;
                audit_trails(user_info[0],audit_trails_actions.LOGIN,sql);
            }else if ( count > 1 ){
                error = "You are not allowed to have more than one account, please consult admin";
                isLogedin = false;
            }else if ( count < 1 ){
                isLogedin = false;
                error = "Wrong username or passowrd";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return isLogedin;
    }
    
    private void set_session(){
        refresh_time();
        String sql = ""
                + "INSERT INTO sessions "
                + "(sessions_id,sessions_user_id,session_time_in,session_time_out)"
                + "VALUES(NULL,'"+user_info[0]+"','"+in+"','')";
        if(db.addNew(sql)){
            String sql_l = "SELECT sessions_id FROM sessions "
                    + " WHERE "
                    + " sessions_user_id = '"+user_info[0]+"' "
                    + " AND session_time_in = '"+in+"' ";
            Object [] sess = db.getRow( sql_l );
            
            System.out.println(sql_l);
            user_info[7] = sess[0].toString();
        }        
    }
    
    private static void refresh_time(){
        date = new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        dt = new java.util.Date();
        in = date.format(dt);
        out = date.format(dt);
    }
    private static void logout_session(){
        refresh_time();
        String sql =" UPDATE sessions SET session_time_out= '"+out+"' "
                + " WHERE "
                + " sessions_user_id = '"+inventoryMngt.get_user_info()[0]+"' "
                + " AND sessions_id='"+inventoryMngt.get_user_info()[6]+"' ";
        
        if(!db.Update(sql)){
            System.out.println(sql);
        }
        
    }
    public static void audit_trails(String user_id, String action, String sql_stmnt){ 
        refresh_time(); 
        
        String sql = ""
                + "INSERT INTO audit_trails "
                + "(audit_trail_user_id,audit_trail_time_in,audit_trail_time_out,audit_trail_action,audit_trail_sql)"
                + "VALUES('"+user_id+"','" + in + "','"+ out +"', '"+ action +"','');";
        
        System.out.println(sql);
        
        if( !db.addNew( sql ) ) {
            //throw 
        }
    }
    
    public static void logout(){
        audit_trails(inventoryMngt.get_user_info()[1], audit_trails_actions.LOGOUT, null);
        
        logout_session();
    }
    
    public void re_login_interface(){
        posi.sys.expeditors.popup p =  this;
        
        initComponents();
        
        p.getContentPane().setLayout(layout);
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Login(2);
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
