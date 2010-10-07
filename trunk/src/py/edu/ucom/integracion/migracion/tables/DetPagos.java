package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  DetPagos.java
 * Author:  Largo
 * Purpose: Defines the Class DetPagos
 ***********************************************************************/
/**
 * Detalle de los pagos realizados por los socion
 * 
 */
public class DetPagos implements DatabaseTables {

	private String codPagDetalle;
	private String codPago;
	private TipPagos tipPagos;
	private Double monPago;


	@Override
	public void delete(ConexionServer server) {
		// TODO Auto-generated method stub

	}

	@Override
	public void migrar(ConexionServer server) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(ConexionServer server) {
		String query = new String();
		//TipPagos tipPago;
		query = "INSERT INTO det_pagos(" +
			"cod_tip_pago," +
			"cod_pago," +
			"cod_pag_detalle) " +
			"VALUES (?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.codPagDetalle);
			statement.setString(2, this.codPago);
			statement.setString(3, this.tipPagos.getCodTipPago());
			statement.executeUpdate();
		} catch (PSQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * @return the codPagDetalle
	 */
	public java.lang.String getCodPagDetalle() {
		return codPagDetalle;
	}

	/**
	 * @return the tipPagos
	 */
	public TipPagos getTipPagos() {
		return tipPagos;
	}


	/**
	 * @param codPagDetalle
	 *           the codPagDetalle to set
	 */
	public void setCodPagDetalle(java.lang.String codPagDetalle) {
		this.codPagDetalle = codPagDetalle;
	}

	/**
	 * @param tipPagos
	 *           the tipPagos to set
	 */
	public void setTipPagos(TipPagos tipPagos) {
		this.tipPagos = tipPagos;
	}

	/**
	 * @return the monPago
	 */
	public Double getMonPago() {
		return monPago;
	}

	/**
	 * @param monPago the monPago to set
	 */
	public void setMonPago(Double monPago) {
		this.monPago = monPago;
	}

	/**
	 * @return the codPago
	 */
	public String getCodPago() {
		return codPago;
	}

	/**
	 * @param codPago the codPago to set
	 */
	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}


}
