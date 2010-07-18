package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Solicitudes.java
 * Author:  Largo
 * Purpose: Defines the Class Solicitudes
 ***********************************************************************/
/**
 * Detalle de las solicitudes de creditos
 * 
 */
public class Solicitudes implements DatabaseTables {

	private String nroSolicitud;
	private Date fecSolicitud;
	private String nroSocios;

	public String getNroSolicitud() {
		return nroSolicitud;
	}

	public void setNroSolicitud(String nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}

	public Date getFecSolicitud() {
		return fecSolicitud;
	}

	public void setFecSolicitud(Date fecSolicitud) {
		this.fecSolicitud = fecSolicitud;
	}

	public String getSocios() {
		return nroSocios;
	}

	public void setSocios(String socios) {
		this.nroSocios = socios;
	}

	public void save(ConexionServer server) {
		String query = new String();
		query = "INSERT INTO public.solicitudes(" +
			"nro_socio," +
			"nro_solicitud," +
			"fec_solicitud" +
			")VALUES (?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.nroSocios);
			statement.setString(2, this.nroSolicitud);
			statement.setDate(3, (java.sql.Date) this.fecSolicitud);

			statement.executeUpdate();
		} catch (PSQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		}	}

	public void delete(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void migrar(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
