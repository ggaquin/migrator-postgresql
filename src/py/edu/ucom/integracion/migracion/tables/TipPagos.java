package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module: TipPagos.java Author: Largo Purpose: Defines the Class TipPagos
 ***********************************************************************/
public class TipPagos implements DatabaseTables {

	public java.lang.String codTipPago;
	public java.lang.String descripcion;

	
	/**
	 * @param codTipPago
	 */
	public TipPagos(String codTipPago, ConexionServer server) {
		ResultSet x;
		String query = "select * from tip_pagos where cod_tip_pago = ?";
		try {
			PreparedStatement statement = server.getConn().prepareStatement(query);
			x= statement.executeQuery();
			while (x.next()) {
				this.codTipPago = x.getString(1);
				this.descripcion = x.getString(2);
			}
		} catch (SQLException e) {
			System.out.println("Error en TIPPAGOS");
			e.printStackTrace();
		}

	}

	// public java.util.Collection<DetPagos> detPagos;
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
		// TODO Auto-generated method stub

	}

	/**
	 * @return the codTipPago
	 */
	public java.lang.String getCodTipPago() {
		return codTipPago;
	}

	/**
	 * @return the descripcion
	 */
	public java.lang.String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param codTipPago
	 *           the codTipPago to set
	 */
	public void setCodTipPago(java.lang.String codTipPago) {
		this.codTipPago = codTipPago;
	}

	/**
	 * @param descripcion
	 *           the descripcion to set
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}

}
