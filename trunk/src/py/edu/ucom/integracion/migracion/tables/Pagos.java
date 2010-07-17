package py.edu.ucom.integracion.migracion.tables;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Pagos.java
 * Author:  Largo
 * Purpose: Defines the Class Pagos
 ***********************************************************************/
/**
 * Pagos realizados
 * 
 */
public class Pagos implements DatabaseTables {

	public String codPago;
	public Date fecPago;
	public double monto;
//	public ArrayList<DetPagos> detPagos;
//	public ArrayList<CuoPagadas> cuoPagadas;
	public Socios socios;
	public Creditos creditos;

	public ArrayList<DetPagos> getDetPagos() {
//		if (detPagos == null) {
//			detPagos = new ArrayList<DetPagos>();
//		}
//		return detPagos;
		return null;
	}

	public void setDetPagos(ArrayList<DetPagos> newDetPagos) {
		
	}

	public void addDetPagos(DetPagos newDetPagos) {
//		if (newDetPagos == null) {
//			return;
//		}
//		if (this.detPagos == null) {
//			this.detPagos = new ArrayList<DetPagos>();
//		}
//		if (!this.detPagos.contains(newDetPagos)) {
//			this.detPagos.add(newDetPagos);
//			newDetPagos.setPagos(this);
//		}
	}

	public void removeDetPagos(DetPagos oldDetPagos) {
//		if (oldDetPagos == null) {
//			return;
//		}
//		if (this.detPagos != null) {
//			if (this.detPagos.contains(oldDetPagos)) {
//				this.detPagos.remove(oldDetPagos);
//				oldDetPagos.setPagos((Pagos) null);
//			}
//		}
	}

	public ArrayList<CuoPagadas> getCuoPagadas() {
//		if (cuoPagadas == null) {
//			cuoPagadas = new ArrayList<CuoPagadas>();
//		}
//		return cuoPagadas;
		return null;
	}

	public void setCuoPagadas(ArrayList<CuoPagadas> newCuoPagadas) {
		for (java.util.Iterator iter = newCuoPagadas.iterator(); iter.hasNext();) {
			addCuoPagadas((CuoPagadas) iter.next());
		}
	}

	public void addCuoPagadas(CuoPagadas newCuoPagadas) {
//		if (newCuoPagadas == null) {
//			return;
//		}
//		if (this.cuoPagadas == null) {
//			this.cuoPagadas = new ArrayList<CuoPagadas>();
//		}
//		if (!this.cuoPagadas.contains(newCuoPagadas)) {
//			this.cuoPagadas.add(newCuoPagadas);
//			newCuoPagadas.setPagos(this);
//		}
	}

	public void removeCuoPagadas(CuoPagadas oldCuoPagadas) {
//		if (oldCuoPagadas == null) {
//			return;
//		}
//		if (this.cuoPagadas != null) {
//			if (this.cuoPagadas.contains(oldCuoPagadas)) {
//				this.cuoPagadas.remove(oldCuoPagadas);
//				oldCuoPagadas.setPagos((Pagos) null);
//			}
//		}
	}

	public Socios getSocios() {
		return socios;
	}

	public void setSocios(Socios newSocios) {
		if (this.socios == null || !this.socios.equals(newSocios)) {
			if (this.socios != null) {
				Socios oldSocios = this.socios;
				this.socios = null;
				oldSocios.removePagos(this);
			}
			if (newSocios != null) {
				this.socios = newSocios;
				this.socios.addPagos(this);
			}
		}
	}

	public Creditos getCreditos() {
		return creditos;
	}

	public void setCreditos(Creditos newCreditos) {
		if (this.creditos == null || !this.creditos.equals(newCreditos)) {
			if (this.creditos != null) {
				Creditos oldCreditos = this.creditos;
				this.creditos = null;
			}
			if (newCreditos != null) {
				this.creditos = newCreditos;
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
}
