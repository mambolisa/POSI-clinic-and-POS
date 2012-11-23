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
import java.util.logging.Level;
import java.util.logging.Logger;

public class db_connect{
	private Connection con, driver;
	private Statement stmt, s;
	private ResultSet rs;
	// class constructor
        
	public db_connect(){
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String dbURL = "jdbc:mysql://localhost:3306/posi";
                    con = DriverManager.getConnection(dbURL, "root", "stan");
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
        
        public Object[][] getData(String sql){
            java.util.List<Object[]> list = new java.util.ArrayList<Object[]>();
            Object [][] data = null;
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=s.executeQuery(sql);
                
                int numCols = rs.getMetaData().getColumnCount();
                
                while(rs.next()){
                    Object [] row = new Object[numCols];
                    
                    for (int j = 0; j< numCols; j++ ){                        
                        row[j] = (rs.getObject(j+1) != null )? rs.getObject(j+1) : " " ;
                    }
                    list.add(row);
                }
                
                data = (Object[][]) list.toArray(new Object[list.size()][numCols]);
                
            } catch (SQLException ex) {
                Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }

        return data;            
        }
        
        public Object[] getRow(String sql){
            Object [] row = null;
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=s.executeQuery(sql);
                
                int numCols = rs.getMetaData().getColumnCount();
                
                row = new Object[numCols];
                    
                for (int j = 0; j< numCols; j++ ){                        
                    row[j] = rs.getObject(j+1);
                } 
            } catch (SQLException ex) {
                Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }

        return row; 
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
