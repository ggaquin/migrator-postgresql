package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  CuoPagadas.java
 * Author:  Largo
 * Purpose: Defines the Class CuoPagadas
 ***********************************************************************/
/** Detalle de los pagos por cuotas 
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

    /** @pdGenerated default parent setter
     * @param newPagos */
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

    /** @pdGenerated default parent getter */
    public Cuotas getCuotas() {
        return cuotas;
    }

    /** @pdGenerated default parent setter
     * @param newCuotas */
    public void setCuotas(Cuotas newCuotas) {
        if (this.cuotas == null || !this.cuotas.equals(newCuotas)) {
            if (this.cuotas != null) {
                Cuotas oldCuotas = this.cuotas;
                this.cuotas = null;
                oldCuotas.removeCuoPagadas(this);
            }
            if (newCuotas != null) {
                this.cuotas = newCuotas;
                this.cuotas.addCuoPagadas(this);
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
