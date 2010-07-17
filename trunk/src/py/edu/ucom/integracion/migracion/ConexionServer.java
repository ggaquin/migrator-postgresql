/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.ucom.integracion.migracion;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 * 
 * @author Largo
 */
public class ConexionServer {

	private int numeroCols;
	private Connection conn;
	private ResultSet result;
	private Statement statement;
	private String rutaConexion;

	{
		numeroCols = -1;
	}

	protected void Conector(String user, String pass, String database, String host) {
		rutaConexion = "jdbc:postgresql://" + host + ":5432/" + database;

		inicializarConexion(rutaConexion, user, pass);
	}

	private void inicializarConexion(String rutaConexion, String user, String pass) {
		try {
			Class.forName("org.postgresql.Driver");
			setConn(java.sql.DriverManager.getConnection(rutaConexion, user, pass));
			statement = getConn().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
		} catch (PSQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + ". Acceso denegado", "Error al acceder al sistema", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + ". No se pudo accesar a la base de datos", "Sin acceso, no se obtuvo conexion",
				JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + ". No se pudo establecer conexion con la base de datos",
				"Sin conexion, el controlador no esta presente", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	public final ResultSet selectQuery(String query) throws PSQLException, SQLException {
		result = statement.executeQuery(query);
		return result;
	}

	public final void insertQuery(String query) throws PSQLException, SQLException {
		// CallableStatement prepare = conn.prepareStatement(query);
		statement.execute(query);
	}

	public final void updateQuery(String query) throws PSQLException, SQLException {
		statement.execute(query);
	}

	protected final void close() {
		try {
			if (result != null) {
				result.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (getConn() != null) {
				getConn().close();
			}
		} catch (Exception e) {

		}
	}

	public Statement getStatement() {
		return this.statement;
	}

	public PreparedStatement getPrepareStatement(String query) throws SQLException {
		PreparedStatement statement = this.conn.prepareStatement(query);
		return statement;

	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *           the conn to set
	 */
	private void setConn(Connection conn) {
		this.conn = conn;
	}
}
