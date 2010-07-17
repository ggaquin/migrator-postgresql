package py.edu.ucom.integracion.migracion.tables;

import java.util.ArrayList;
import java.util.Date;

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
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void delete(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void migrar(ConexionServer server) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
