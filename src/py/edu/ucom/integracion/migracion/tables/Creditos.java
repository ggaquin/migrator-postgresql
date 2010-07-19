package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Creditos.java
 * Author:  Largo
 * Purpose: Defines the Class Creditos
 ***********************************************************************/

/**
 * Detalle de los creditos desembolsados
 * 
 * 
 */
public class Creditos implements DatabaseTables {

	private String nroCredito;
	private Date fecDesmbolso;
	private double monTotal;
	private TipCreditos tipCreditos;
	private String socio;
	private Solicitudes solicitud;
	private ArrayList<Cuotas> cuotas;

	public ArrayList<Cuotas> getCuotas() {
		if(this.cuotas == null)
			this.cuotas = new ArrayList<Cuotas>();
		return cuotas;
	}

	public void setCuotas(ArrayList<Cuotas> cuotas) {
		this.cuotas = cuotas;
	}

	public TipCreditos getTipCreditos() {
		return tipCreditos;
	}

	public void setTipCreditos(TipCreditos newTipCreditos) {
		if (this.tipCreditos == null || !this.tipCreditos.equals(newTipCreditos)) {
			if (this.tipCreditos != null) {
				TipCreditos oldTipCreditos = this.tipCreditos;
				this.tipCreditos = null;
			}
			if (newTipCreditos != null) {
				this.tipCreditos = newTipCreditos;
			}
		}
	}

	public void save(ConexionServer server) {
		this.solicitud.save(server);
		String query = new String();
		query = "INSERT INTO public.creditos(" +
			"nro_credito," +
			"nro_solicitud," +
			"cod_tip_credito," +
			"fec_desmbolso," +
			"mon_total)" +
			"VALUES (?,?,?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.nroCredito);
			statement.setString(2, this.solicitud.getNroSolicitud());
			statement.setString(3, this.tipCreditos.getCodTipCredito());
			statement.setDate(4, (java.sql.Date) this.fecDesmbolso);
			statement.setDouble(5, this.monTotal);

			// System.out.println(this.nombres + " - " +
			// this.fecIngreso.toString());

			statement.executeUpdate();
		} catch (PSQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void migrar(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return the nroCredito
	 */
	public String getNroCredito() {
		return nroCredito;
	}

	/**
	 * @return the fecDesmbolso
	 */
	public Date getFecDesmbolso() {
		return fecDesmbolso;
	}

	/**
	 * @return the monTotal
	 */
	public double getMonTotal() {
		return monTotal;
	}

	/**
	 * @param nroCredito
	 *           the nroCredito to set
	 */
	public void setNroCredito(String nroCredito) {
		this.nroCredito = nroCredito;
	}

	/**
	 * @param fecDesmbolso
	 *           the fecDesmbolso to set
	 */
	public void setFecDesmbolso(Date fecDesmbolso) {
		this.fecDesmbolso = fecDesmbolso;
	}

	/**
	 * @param monTotal
	 *           the monTotal to set
	 */
	public void setMonTotal(double monTotal) {
		this.monTotal = monTotal;
	}

	/**
	 * @return the socio
	 */
	public String getSocio() {
		return socio;
	}

	/**
	 * @param socio
	 *           the socio to set
	 */
	public void setSocio(String socio) {
		this.socio = socio;
	}

	/**
	 * @return the solicitud
	 */
	public Solicitudes getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud
	 *           the solicitud to set
	 */
	public void setSolicitud(Solicitudes solicitud) {
		this.solicitud = solicitud;
	}
}