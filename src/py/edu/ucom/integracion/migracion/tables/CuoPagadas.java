package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  CuoPagadas.java
 * Author:  Largo
 * Purpose: Defines the Class CuoPagadas
 ***********************************************************************/
/**
 * Detalle de los pagos por cuotas
 * 
 * 
 */
public class CuoPagadas implements DatabaseTables {

	private double monPagado;
	private int nroCuoDesde;
	private int nroCuoHasta;
	private String codPago;
	public String codCuota;
	/**
	 * @return the monPagado
	 */
	public double getMonPagado() {
		return monPagado;
	}
	/**
	 * @return the nroCuoDesde
	 */
	public int getNroCuoDesde() {
		return nroCuoDesde;
	}
	/**
	 * @return the nroCuoHasta
	 */
	public int getNroCuoHasta() {
		return nroCuoHasta;
	}
	/**
	 * @return the codPago
	 */
	public String getCodPago() {
		return codPago;
	}
	/**
	 * @return the codCuota
	 */
	public String getCodCuota() {
		return codCuota;
	}
	/**
	 * @param monPagado the monPagado to set
	 */
	public void setMonPagado(double monPagado) {
		this.monPagado = monPagado;
	}
	/**
	 * @param nroCuoDesde the nroCuoDesde to set
	 */
	public void setNroCuoDesde(int nroCuoDesde) {
		this.nroCuoDesde = nroCuoDesde;
	}
	/**
	 * @param nroCuoHasta the nroCuoHasta to set
	 */
	public void setNroCuoHasta(int nroCuoHasta) {
		this.nroCuoHasta = nroCuoHasta;
	}
	/**
	 * @param codPago the codPago to set
	 */
	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}
	/**
	 * @param codCuota the codCuota to set
	 */
	public void setCodCuota(String codCuota) {
		this.codCuota = codCuota;
	}
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

	
}
