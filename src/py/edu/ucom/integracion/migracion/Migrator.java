/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;
import py.edu.ucom.integracion.migracion.exceptions.CreditosExceptionError;
import py.edu.ucom.integracion.migracion.exceptions.SociosExceptionError;
import py.edu.ucom.integracion.migracion.tables.Creditos;
import py.edu.ucom.integracion.migracion.tables.Cuotas;
import py.edu.ucom.integracion.migracion.tables.Pagos;
import py.edu.ucom.integracion.migracion.tables.Socios;
import py.edu.ucom.integracion.migracion.tables.Solicitudes;
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
		ConexionServer serverDestino = conectarse(host, "cooperativa", user, pass);
		try {
			// migrarSocios(serverOrigen, serverDestino);
			//migrarCreditos(serverOrigen, serverDestino);
			migrarPagos(serverOrigen, serverDestino);
			// } catch (SociosExceptionError e) {
			// System.out.println("Error en SOCIOS!!!");
			// Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
			// e);
			// e.printStackTrace();

			// } catch (CreditosExceptionError e) {
			// System.out.println("Error en CREDITOS!!!");
			// Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
			// e);
			//	e.printStackTrace();
			// } catch (CuotaExceptionError e) {
			// System.out.println("Error en CREDITOS!!!");
			// Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null,
			// e);
			// e.printStackTrace();
		} catch (SociosExceptionError e) {
			e.printStackTrace();
		} finally {
			serverDestino.close();
			serverOrigen.close();
		}

	}

	private ConexionServer conectarse(String host, String database, String user, String pass) {
		ConexionServer server = new ConexionServer();
		server.Conector(user, pass, database, host);

		return server;
	}

	private boolean migrarSocios(ConexionServer serverOrigen, ConexionServer serverDestino) throws SociosExceptionError {
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
			SociosExceptionError error = new SociosExceptionError(e.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		} catch (SQLException e) {
			SociosExceptionError error = new SociosExceptionError(e.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		}
		return false;
	}

	private boolean migrarPagos(ConexionServer serverOrigen, ConexionServer serverDestino) throws SociosExceptionError {
		ResultSet x;
		Pagos pago;
		try {
			x = serverOrigen.selectQuery("select nropago, nrosocio,nrocredito,fecha_pago,monto_pago from pagos");
			while (x.next()) {
				 pago = new Pagos();
				pago.setCodPago(x.getString(1));
				pago.setNroSocios(x.getString(2));
				pago.setNroCreditos(x.getString(3));
				pago.setFecPago(x.getDate(4));
				pago.setMonto(x.getDouble(5));
				pago.save(serverDestino);
			}
		} catch (PSQLException e) {
			SociosExceptionError error = new SociosExceptionError(e.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		} catch (SQLException e) {
			SociosExceptionError error = new SociosExceptionError(e.getStackTrace().toString());
			e.printStackTrace();
			throw error;
		}

		return false;

	}

	private boolean migrarCreditos(ConexionServer serverOrigen,
		ConexionServer serverDestino) throws CreditosExceptionError {
		ResultSet rstCreditos;
		// ResultSet rstPagos;
		Creditos creditos;
		Cuotas cuota;
		Solicitudes solicitud;
		String queryCreditos = "select * from creditos";
		try {
			rstCreditos = serverOrigen.selectQuery(queryCreditos);
			while (rstCreditos.next()) {
				creditos = new Creditos();
				solicitud = new Solicitudes();
				creditos.setNroCredito(String.valueOf(rstCreditos.getInt(1)));
				creditos.setTipCreditos(new TipCreditos(String.valueOf(rstCreditos.getInt(2))));
				solicitud.setSocios(String.valueOf(rstCreditos.getInt(3)));
				solicitud.setFecSolicitud(rstCreditos.getDate(4));
				solicitud.setNroSolicitud(String.valueOf(rstCreditos.getInt(5)));
				int canCuotas = rstCreditos.getInt(9);
				double monCuota = rstCreditos.getDouble(8);
				// System.out.println(monCuota * canCuotas);
				creditos.setMonTotal((rstCreditos.getDouble(8) * rstCreditos.getInt(9)));
				creditos.setSolicitud(solicitud);
				for (int i = 0; i < canCuotas; i++) {
					cuota = new Cuotas();
					cuota.setNroCuota(String.valueOf(i));
					cuota.setSalCuota(monCuota);
					cuota.setCanCuota(canCuotas);
					cuota.setMonCuota(monCuota);
					creditos.getCuotas().add(cuota);
				}
				creditos.save(serverDestino);
			}
		} catch (PSQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
				.getStackTrace().toString());
			e.printStackTrace();
		} catch (SQLException e) {
			SociosExceptionError error = new SociosExceptionError(e
				.getStackTrace().toString());
			e.printStackTrace();
		}
		return false;
	}
}
