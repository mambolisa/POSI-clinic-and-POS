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
        
	public boolean addNew(String sql){
                boolean ifAdded = false;
		try {
			stmt=con.createStatement();
			stmt.execute(sql);
                        ifAdded = true;
		}
		catch (Exception err) {
			System.out.println( "Error: " + err );
		}
           return ifAdded;
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
        
        public Object[] getColData(String sql){
            java.util.List list = new java.util.ArrayList();
            Object [] data = null;
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=s.executeQuery(sql);
                
                while(rs.next()){
                    list.add((rs.getObject(1) != null )? rs.getObject(1) : " " );
                }
                
                data = (Object[]) list.toArray(new Object[list.size()]);
                
            } catch (SQLException ex) {
                Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }

        return data;             
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
        
        public boolean exists(String sql){
            int test_count = 0;
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=s.executeQuery(sql);
                
                while(rs.next() ){
                    test_count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return (test_count > 0) ? true : false ;
        }
        
        public Object[] getRow(String sql){
            Object [] row = {};
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=s.executeQuery(sql);
                
                int numCols = rs.getMetaData().getColumnCount();
                
                rs.next();
                
                row = new Object[numCols];
                 
                for (int j = 0; j< numCols; j++ ){                        
                    row[j] = ( rs.getObject ( j+1 ) != null ) ? rs.getObject(j+1) : " " ;
                } 
                
            } catch (SQLException ex) {
                Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
            }

        return row; 
        }
        
	public boolean Delete(String sql){
            boolean ifDeleted = false;
		PreparedStatement st;
		try{
			st=con.prepareStatement(sql);
			st.executeUpdate();
                        ifDeleted = true;
		}
		catch (Exception err) {
			System.out.println( "Error deleting: " + err );
		}
            return ifDeleted;
	}

	public boolean Update(String sql){
            boolean ifUpdated = false;
		try{
			s=con.createStatement();
			s.execute(sql);
                        ifUpdated = true;
		}
		catch (Exception err) {
			System.out.println( "Error=== " + err );
		}
           return ifUpdated;
	}
}
