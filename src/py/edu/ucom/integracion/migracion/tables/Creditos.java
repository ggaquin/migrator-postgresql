package py.edu.ucom.integracion.migracion.tables;

import java.util.Date;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Creditos.java
 * Author:  Largo
 * Purpose: Defines the Class Creditos
 ***********************************************************************/

/** Detalle de los creditos desembolsados
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
        throw new UnsupportedOperationException("Not supported yet.");
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
	 * @param nroCredito the nroCredito to set
	 */
	public void setNroCredito(String nroCredito) {
		this.nroCredito = nroCredito;
	}

	/**
	 * @param fecDesmbolso the fecDesmbolso to set
	 */
	public void setFecDesmbolso(Date fecDesmbolso) {
		this.fecDesmbolso = fecDesmbolso;
	}

	/**
	 * @param monTotal the monTotal to set
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
	 * @param socio the socio to set
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
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(Solicitudes solicitud) {
		this.solicitud = solicitud;
	}
}