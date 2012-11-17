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
        
        public String [][] getArrayQuery(String sql){ 
            String [][] data = null;            
            try {
                s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                rs=s.executeQuery(sql);

                int i = 0;
                int numCols = rs.getMetaData().getColumnCount();
                
                while ( rs.next() ){ i++; }
                
                rs.beforeFirst();
                
                data = new String[i][numCols];
                int j = 0,k = 0,l = 0;
                
                while ( rs.next() ){
                    while( k < numCols ){
                       l = k + 1;
                       data[j][k] = rs.getString(l);
                    k++;
                    }
                j++;
                }
              
            } catch (SQLException ex) {
                Logger.getLogger(ex.getMessage());
            }
        return data;        
        }
        
        public Object[] getRow(ResultSet rs){
            Object [] row = null;
            try {
                int numCols = rs.getMetaData().getColumnCount();
                
                row = new Object[numCols];
                                
                int colNum = 0,l = 0;
                while ( colNum < numCols ){
                    l = colNum+1;
                    row[colNum] = rs.getObject(l);
                colNum++;
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
