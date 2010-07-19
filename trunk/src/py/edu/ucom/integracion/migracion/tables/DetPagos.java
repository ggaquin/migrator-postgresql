package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  DetPagos.java
 * Author:  Largo
 * Purpose: Defines the Class DetPagos
 ***********************************************************************/
/** Detalle de los pagos realizados por los socion
 * 
 */
public class DetPagos implements DatabaseTables{

    public java.lang.String codPagDetalle;
    public TipPagos tipPagos;
    public Pagos pagos;

    public TipPagos getTipPagos() {
        return tipPagos;
    }

    public void setTipPagos(TipPagos newTipPagos) {
        if (this.tipPagos == null || !this.tipPagos.equals(newTipPagos)) {
            if (this.tipPagos != null) {
                TipPagos oldTipPagos = this.tipPagos;
                this.tipPagos = null;
                oldTipPagos.removeDetPagos(this);
            }
            if (newTipPagos != null) {
                this.tipPagos = newTipPagos;
                this.tipPagos.addDetPagos(this);
            }
        }
    }

    /** @pdGenerated default parent getter */
    public Pagos getPagos() {
        return pagos;
    }

    /** @pdGenerated default parent setter
     * @param newPagos */
    public void setPagos(Pagos newPagos) {

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
