package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class ConfigureDatabase {
	private static final String URL = "jdbc:mysql://localhost:3306/sonic_tails_run?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	private static Connection conn;

	private ConfigureDatabase() {
	}

	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("연결 성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to database", "message", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			conn.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
