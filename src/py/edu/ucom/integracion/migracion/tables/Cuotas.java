package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Cuotas.java
 * Author:  Largo
 * Purpose: Defines the Class Cuotas
 ***********************************************************************/
/**
 * Tabla con las cuotas generadas por los creditos desembolsados a los socios
 * 
 */
public class Cuotas implements DatabaseTables {

	private String nroCuota;
	private int canCuota;
	private double monCuota;
	private Date fecUltCuoPagada;
	private double salCuota;

	public String getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(String nroCuota) {
		this.nroCuota = nroCuota;
	}

	public int getCanCuota() {
		return canCuota;
	}

	public void setCanCuota(int canCuota) {
		this.canCuota = canCuota;
	}

	public double getMonCuota() {
		return monCuota;
	}

	public void setMonCuota(double monCuota) {
		this.monCuota = monCuota;
	}

	public Date getFecUltCuoPagada() {
		return fecUltCuoPagada;
	}

	public void setFecUltCuoPagada(Date fecUltCuoPagada) {
		this.fecUltCuoPagada = fecUltCuoPagada;
	}

	public double getSalCuota() {
		return salCuota;
	}

	public void setSalCuota(double salCuota) {
		this.salCuota = salCuota;
	}

	public void save(ConexionServer server) {

		String query = new String();
		query = "insert into cuotas (" +
			"nro_cuota, " +
			"can_cuota, " +
			"mon_cuota, " +
			"fec_ult_cuo_pagada," +
			"sal_cuota) " +
			"values (?,?,?,?,?);";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.nroCuota);
			statement.setInt(2, this.canCuota);
			statement.setDouble(3, this.monCuota);
			statement.setDate(4, this.fecUltCuoPagada);
			statement.setDouble(5, this.salCuota);

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
}
