package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	public Connection conexion;
	public Statement sentencia;
	public ResultSet resultado;
	
	public void ConectarBasedeDatos() {
		try {
			final String Controlador = "com.mysql.cj.jdbc.Driver";
			Class.forName(Controlador);
			final String url_db = "jdbc:mysql://localhost:3306/dblogin";
			conexion = DriverManager.getConnection(url_db, "root", "");
			sentencia = conexion.createStatement();
		} catch (ClassNotFoundException | SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void DesconectarBasedeDatos() {
		try {
			if (conexion != null) {
				if (sentencia != null) {
					sentencia.close();
				}
				conexion.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			}
	}
}
