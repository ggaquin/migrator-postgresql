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

	public double monPagado;
	public double nroCuoDesde;
	public double nroCuoHasta;
	public Pagos pagos;
	public Cuotas cuotas;

	public Pagos getPagos() {
		return pagos;
	}

	public void setPagos(Pagos newPagos) {
		if (this.pagos == null || !this.pagos.equals(newPagos)) {
			if (this.pagos != null) {
				Pagos oldPagos = this.pagos;
				this.pagos = null;
				oldPagos.removeCuoPagadas(this);
			}
			if (newPagos != null) {
				this.pagos = newPagos;
				this.pagos.addCuoPagadas(this);
			}
		}
	}

	public Cuotas getCuotas() {
		return cuotas;
	}

	public void setCuotas(Cuotas newCuotas) {
		if (this.cuotas == null) {
			this.cuotas = new Cuotas();
		} else if (!this.cuotas.equals(newCuotas)) {
			this.cuotas = newCuotas;
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

	public double getMonPagado() {
		return monPagado;
	}

	public void setMonPagado(double monPagado) {
		this.monPagado = monPagado;
	}

	public double getNroCuoDesde() {
		return nroCuoDesde;
	}

	public void setNroCuoDesde(double nroCuoDesde) {
		this.nroCuoDesde = nroCuoDesde;
	}

	public double getNroCuoHasta() {
		return nroCuoHasta;
	}

	public void setNroCuoHasta(double nroCuoHasta) {
		this.nroCuoHasta = nroCuoHasta;
	}
}
