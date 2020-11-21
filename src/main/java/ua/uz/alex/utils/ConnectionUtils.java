package ua.uz.alex.utils;

import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static String USER_NAME = "test";
	private static String USER_PASSWORD = "pass";
	private static String URL = "jdbc:mysql://localhost/m_shop";

	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//java.net.URL loggerConfig = ConnectionUtils.class.getClassLoader().getResource("log4j2.xml");
	//	DOMConfigurator.configure("log4j2.xml");
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
}
