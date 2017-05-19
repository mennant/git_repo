package test_sql_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connect_to_sqls {

	   public static void dbConnect(String db_connect_string,
	            String db_userid,
	            String db_password)
	   {
	      try {
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection conn = DriverManager.getConnection(db_connect_string,
	                  db_userid, db_password);
	         System.out.println("connected to db : ****************** " + db_connect_string);
	         Statement statement = conn.createStatement();
	         String queryString = "select * from sysobjects where type ='u'";
	         ResultSet rs = statement.executeQuery(queryString);
	         while (rs.next()) {
	            System.out.println(rs.getString(1));
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	   public static void main(String[] args)
	   {
		 
	     dbConnect("jdbc:sqlserver://172.30.10.90:49788", "sa","123456qQ");
	     dbConnect("jdbc:sqlserver://172.30.10.6:1433", "sa","Sa123456");

	   }
	
	

}
