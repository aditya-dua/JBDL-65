package l12_JDBC_CURD_Ops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		String url="jdbc:mysql://localhost:3306/jbdl65";
		String user="root";
		String password= "password";
		
		
		try {
			con = dbConnection(url,user,password);
			//createTable(con);
			insertRecord(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static Connection dbConnection(String url, String user,String pass) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,pass);
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void createTable(Connection con) throws SQLException {
		String sql="CREATE TABLE IF NOT EXISTS `registeration` ("
				+ "  `id` INT NOT NULL,"
				+ "  `first` VARCHAR(45) NULL,"
				+ "  `last` VARCHAR(45) NULL,"
				+ "  `age` VARCHAR(45) NULL,"
				+ "  PRIMARY KEY (`id`));";
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		
		
		System.out.println("Table Created Successfully.");
	}
	
	public static int insertRecord(Connection con) throws SQLException {
		String sql = "Insert into `registeration` values (6, 'Aditya','Dua',25);";
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println("Insertion Result : "+result);
		return result;
		
	}
	
	
}
