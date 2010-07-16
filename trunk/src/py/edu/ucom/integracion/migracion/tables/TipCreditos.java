package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  TipCreditos.java
 * Author:  Largo
 * Purpose: Defines the Class TipCreditos
 ***********************************************************************/
/** Tabla con los tipos de creditos disponibles para los socios
 * 
 */
public class TipCreditos implements DatabaseTables {

	/**
	 * @param codTipCredito
	 */
	public TipCreditos(String codTipCredito) {
		this.codTipCredito = codTipCredito;
	}

	private String codTipCredito;
    private String descripcion;
    private double relAporte;
    private double maxMonto;
    

    public void save(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void migrar(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	/**
	 * @return the codTipCredito
	 */
	public String getCodTipCredito() {
		return codTipCredito;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the relAporte
	 */
	public double getRelAporte() {
		return relAporte;
	}

	/**
	 * @return the maxMonto
	 */
	public double getMaxMonto() {
		return maxMonto;
	}

	/**
	 * @param codTipCredito the codTipCredito to set
	 */
	public void setCodTipCredito(String codTipCredito) {
		this.codTipCredito = codTipCredito;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param relAporte the relAporte to set
	 */
	public void setRelAporte(double relAporte) {
		this.relAporte = relAporte;
	}

	/**
	 * @param maxMonto the maxMonto to set
	 */
	public void setMaxMonto(double maxMonto) {
		this.maxMonto = maxMonto;
	}
}
