package com.example.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.mysql.jdbc.Driver;

//import com.mysql.cj.jdbc.Driver;

//factory class
public class ConnectionFactory {
	
	private static Properties properties =new Properties();
	static {
		try {
			FileInputStream fis=new FileInputStream("src/main/resources/db.properties");
			properties.load(fis);
			fis.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static {
		//step -1 : register 'jdbc driver';
		try {
			 //DriverManager.registerDriver(new Driver());
			 Class.forName(properties.getProperty("db.driver"));
			 
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//factory method
	public static Connection getConnection() throws SQLException{
		//step-2: create db-connection with url,username,pwd
		String url=properties.getProperty("db.url");
		String username=properties.getProperty("db.username");
		String password=properties.getProperty("db.password");
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
		
	}

}
