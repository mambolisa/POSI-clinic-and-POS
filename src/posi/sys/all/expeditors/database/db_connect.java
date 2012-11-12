/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.expeditors.database;

/**
 *
 * @author Aquarius
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

public class db_connect{
	private Connection con, driver;
	private Statement stmt, s;
	private ResultSet rs;
	// class constructor

	public db_connect(){
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String dbURL = "jdbc:mysql://localhost:3306/hospitalms";
                    con = DriverManager.getConnection(dbURL, "root", "");
		}
		catch (Exception err) {
			System.out.println( "Error: " + err );
		}
	}// close the constructor

        public Connection getConnection(){
            return con;
        }
        
	public void addNew(String sql){
		try {
			stmt=con.createStatement();
			stmt.execute(sql);
		}
		catch (Exception err) {
			System.out.println( "Error: " + err );
		}
	}

	public ResultSet Query(String sql){
		try{
			s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=s.executeQuery(sql);
		}
		catch (Exception err) {
			System.out.println( "Query Error " + err );
		}
		return rs;
	}

	public void Delete(String sql){
		PreparedStatement st;
		try{
			st=con.prepareStatement(sql);
			st.executeUpdate();
		}
		catch (Exception err) {
			System.out.println( "Error deleting: " + err );
		}
	}

	public void Update(String sql){
		try{
			s=con.createStatement();
			s.execute(sql);
		}
		catch (Exception err) {
			System.out.println( "Error=== " + err );
		}
	}
}
