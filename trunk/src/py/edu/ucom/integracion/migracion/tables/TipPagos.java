package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  TipPagos.java
 * Author:  Largo
 * Purpose: Defines the Class TipPagos
 ***********************************************************************/
public class TipPagos implements DatabaseTables {

    public java.lang.String codTipPago;
    public java.lang.String descripcion;
    public java.util.Collection<DetPagos> detPagos;

    public java.util.Collection<DetPagos> getDetPagos() {
        if (detPagos == null) {
            detPagos = new java.util.HashSet<DetPagos>();
        }
        return detPagos;
    }

    public java.util.Iterator getIteratorDetPagos() {
        if (detPagos == null) {
            detPagos = new java.util.HashSet<DetPagos>();
        }
        return detPagos.iterator();
    }

    public void setDetPagos(java.util.Collection<DetPagos> newDetPagos) {
        removeAllDetPagos();
        for (java.util.Iterator iter = newDetPagos.iterator(); iter.hasNext();) {
            addDetPagos((DetPagos) iter.next());
        }
    }

    public void addDetPagos(DetPagos newDetPagos) {
        if (newDetPagos == null) {
            return;
        }
        if (this.detPagos == null) {
            this.detPagos = new java.util.HashSet<DetPagos>();
        }
        if (!this.detPagos.contains(newDetPagos)) {
            this.detPagos.add(newDetPagos);
            newDetPagos.setTipPagos(this);
        }
    }

    public void removeDetPagos(DetPagos oldDetPagos) {
        if (oldDetPagos == null) {
            return;
        }
        if (this.detPagos != null) {
            if (this.detPagos.contains(oldDetPagos)) {
                this.detPagos.remove(oldDetPagos);
                oldDetPagos.setTipPagos((TipPagos) null);
            }
        }
    }

    public void removeAllDetPagos() {
        if (detPagos != null) {
            DetPagos oldDetPagos;
            for (java.util.Iterator iter = getIteratorDetPagos(); iter.hasNext();) {
                oldDetPagos = (DetPagos) iter.next();
                iter.remove();
                oldDetPagos.setTipPagos((TipPagos) null);
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
