package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	// Método para conectar ao banco de dados
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {

				Properties props = loadProperties(); // pegamos as propriedades de conexão
				String url = props.getProperty("dburl"); // pega a url do banco de dados, que foi definida no arquivo
															// db.properties
				conn = DriverManager.getConnection(url, props); // obtem a conexão com o banco de dados
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		// Conectar com o banco de dados no JDBC é instanciar um objeto do tipo
		// connection
		return conn;
	}

	// Método para fechar a conexão com o banco de dados
	public static void closeConnetion() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties properties = new Properties();

			properties.load(fs);
			return properties;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}
			catch (SQLException e){
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e){
				throw new DbException(e.getMessage());
			}
		}
	}
}
