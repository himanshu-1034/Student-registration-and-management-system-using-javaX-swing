import java.sql.*;

public class connect_to_oracle {
	
	public static Connection connecttooracle() {
		Connection connection=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		     connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","","");
		     //System.out.print("connection done");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return connection;

	}
	
}
