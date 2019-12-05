package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnection {
	private String user;
	private String password;
	private Connection conn;

	public DataBaseConnection(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() throws ClassNotFoundException {
		conn = null;
		Properties infoConnection;
		String urlConnection;

		urlConnection = "jdbc:mysql://localhost:3306/scm2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		infoConnection = new Properties();
		infoConnection.put("user", this.user);
		infoConnection.put("password", this.password);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(urlConnection, infoConnection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// Recupera coches
	public ResultSet dameCoches() throws SQLException {
		ResultSet rs = null;
		String query = "select * from coches";

		Statement stmt;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet dameUsuarios() throws SQLException {
		ResultSet rs = null;
		String query = "select * from usuarios";
		Statement stmt;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public Boolean setUsuario(String usuario, String contraseya) throws SQLException {
		String query = "INSERT INTO usuarios (usuario,contrasena)" + " VALUES ('" + usuario + "','" + contraseya + "')";
		Statement stmt;
		Boolean response = false;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			response = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = false;
		}

		return response;
	}

}
