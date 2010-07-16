/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.exceptions.CreditosExceptionError;
import py.edu.ucom.integracion.migracion.exceptions.CuotaExceptionError;
import py.edu.ucom.integracion.migracion.exceptions.SociosExceptionError;
import py.edu.ucom.integracion.migracion.tables.Creditos;
import py.edu.ucom.integracion.migracion.tables.Cuotas;
import py.edu.ucom.integracion.migracion.tables.Pagos;
import py.edu.ucom.integracion.migracion.tables.Socios;
import py.edu.ucom.integracion.migracion.tables.TipCreditos;

/**
 * 
 * @author Largo
 */

public class Migrator {
	String host = "localhost";
	String database = "migracion";
	String user = "postgres";
	String pass = "123456";

	void migrar() {
		ConexionServer serverOrigen = conectarse(host, "migracion", user, pass);
		ConexionServer serverDestino = conectarse(host, "cooperativa", user,
				pass);
		try {
			migrarSocios(serverOrigen, serverDestino);
			migrarCreditos(serverOrigen, serverDestino);
		} catch (SociosExceptionError e) {
			System.out.println("Error en SOCIOS!!!");
			Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
					e);
			e.printStackTrace();

		} catch (CreditosExceptionError e) {
			System.out.println("Error en CREDITOS!!!");
			Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
					e);
			e.printStackTrace();
		} catch (CuotaExceptionError e) {
			System.out.println("Error en CREDITOS!!!");
			Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
					e);
			e.printStackTrace();
		}

	}

	private ConexionServer conectarse(String host, String database,
			String user, String pass) {
		ConexionServer server = new ConexionServer();
		server.Conector(user, pass, database, host);

		return server;
	}

	private boolean migrarSocios(ConexionServer serverOrigen,
			ConexionServer serverDestino) throws SociosExceptionError {
		ResultSet x;
		Socios socios;
		try {
			x = serverOrigen.selectQuery("select * from socios");
			while (x.next()) {
				socios = new Socios();
				socios.setNroSocio(x.getString(1));
				socios.setFecIngreso(x.getDate(2));
				socios.setNombres(x.getString(3));
				socios.setApellidos(x.getString(4));
				socios.setNroDocumento(x.getString(5));
				socios.setAportes(x.getInt(7));
				socios.save(serverDestino);
			}
		} catch (PSQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
					.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		} catch (SQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
					.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		}
		return false;
	}

	private boolean migrarCuotas(ConexionServer serverOrigen,
			ConexionServer serverDestino) throws SociosExceptionError {
		// ResultSet x =
		// serverOrigen.selectQuery("SELECT * FROM public.cuotas");
		// Cuotas cuotas = new Cuotas();
		// try {
		// x = serverOrigen.selectQuery("select * from socios");
		// while (x.next()) {
		// cuotas = new Cuotas();
		// cuotas.s(x.getString(1));
		// cuotas.setFecIngreso(x.getDate(2));
		// cuotas.setNombres(x.getString(3));
		// cuotas.setApellidos(x.getString(4));
		// cuotas.setNroDocumento(x.getString(5));
		// cuotas.setAportes(x.getInt(7));
		// cuotas.save(serverDestino);
		// }
		// } catch (PSQLException e) {
		// SociosExceptionError error = new
		// SociosExceptionError(e.getStackTrace().toString());
		// e.printStackTrace();
		// throw error;
		// } catch (SQLException e) {
		// SociosExceptionError error = new
		// SociosExceptionError(e.getStackTrace().toString());
		// e.printStackTrace();
		// throw error;
		// }
		return false;

	}

	private boolean migrarCreditos(ConexionServer serverOrigen,
			ConexionServer serverDestino) throws CreditosExceptionError {
		ResultSet rstCreditos;
		ResultSet rstPagos;
		Creditos creditos;
		Cuotas cuota;
		Pagos pagos;
		String queryCreditos = "select * from creditos";
		String queryPagos = "select * from pagos where pagos.nrosocio = ?";
		try {
			rstCreditos = serverOrigen.selectQuery(queryCreditos);
			while (rstCreditos.next()) {
				creditos = new Creditos();
				cuota = new Cuotas();
				creditos.setNroCredito(String.valueOf(rstCreditos.getInt(1)));
				creditos.setTipCreditos(new TipCreditos(String.valueOf(rstCreditos.getInt(2))));
				creditos.setNroCredito(String.valueOf(rstCreditos.getInt(3)));
				creditos.setFecDesmbolso(rstCreditos.getDate(6));
				
				PreparedStatement statement = serverOrigen.getPrepareStatement(queryPagos);
				try {
					statement.setInt(1, Integer.parseInt(creditos.getNroCredito()));
					rstPagos = statement.executeQuery();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				// creditos.set
				// creditos.setNombres(x.getString(3));
				// creditos.setApellidos(x.getString(4));
				// creditos.setNroDocumento(x.getString(5));
				// creditos.setAportes(x.getInt(7));
				creditos.save(serverDestino);
			}
		} catch (PSQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
					.getStackTrace().toString());
			e.printStackTrace();
			// throw error;
		} catch (SQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
					.getStackTrace().toString());
			e.printStackTrace();
			// throw error;
		}
		return false;
	}
}
