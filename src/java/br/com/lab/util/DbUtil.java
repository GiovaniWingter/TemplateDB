package br.com.lab.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

	private static final String DRIVER_JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	
	private static final String URL_DATABASE = "jdbc:sqlserver://localhost;databaseName=JavaJSF;";
	private static final String USUARIO_DB = "sa";
	private static final String SENHA_USUARIO_DB = "1234";
	
	static {
		try {
			Class.forName(DRIVER_JDBC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection connection = null;
                try {
                    connection = DriverManager.getConnection(URL_DATABASE, USUARIO_DB, SENHA_USUARIO_DB);
                    connection.setAutoCommit(true);
		} catch (SQLException e) {
                    e.getMessage();
		}finally{
                    return connection;
                }
	}
	
	public static void close(Connection conn, PreparedStatement statement, ResultSet result) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
