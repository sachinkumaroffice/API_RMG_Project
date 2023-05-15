package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Database_Utility {
	public Driver driver;
	public Connection con;
	int set = 0;
	public void connectToDB() throws Throwable {
		
			driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUsername, IPathConstants.DBPassword);
	}
	
	public String readDataFromDBAndValidate(String query, int columnIndex, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		 while (result.next()) {
			if (result.getString(columnIndex).equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		 }
		 if (flag) {
			System.out.println(expData+"Project is Verified");
			return expData;
		} else {
			System.out.println("Project not verified");
			return " ";
		}
     }
	
	public void deleteDataInDBAndValidate(String expectedProject) throws Throwable {
		String query = "delete from project where project_Id = '"+expectedProject+"';";
		int set = con.createStatement().executeUpdate(query);
			if (set==1) {
				System.out.println("deleted successfully in Database");
			} else {
				System.out.println("Not achieved the deletion of the project in Database");
			}
	}
	
	
	
	public void disconnectFromDB() throws Throwable {
		con.close();
	}
	}
