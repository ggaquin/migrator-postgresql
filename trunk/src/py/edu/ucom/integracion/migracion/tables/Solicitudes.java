package py.edu.ucom.integracion.migracion.tables;

import java.util.Date;

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
	private String socios;

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
		return socios;
	}

	public void setSocios(String socios) {
		this.socios = socios;
	}

	public void save(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void delete(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void migrar(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
