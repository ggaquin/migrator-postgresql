package py.edu.ucom.integracion.migracion.tables;

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

    public java.lang.String nroCredito;
    public java.util.Date fecDesmbolso;
    public double monTotal;
    public java.util.Collection<Pagos> pagos;
    public Solicitudes solicitudes;
    public TipCreditos tipCreditos;

    public java.util.Collection<Pagos> getPagos() {
        if (pagos == null) {
            pagos = new java.util.HashSet<Pagos>();
        }
        return pagos;
    }

    public java.util.Iterator getIteratorPagos() {
        if (pagos == null) {
            pagos = new java.util.HashSet<Pagos>();
        }
        return pagos.iterator();
    }

    public void setPagos(java.util.Collection<Pagos> newPagos) {
        removeAllPagos();
        for (java.util.Iterator iter = newPagos.iterator(); iter.hasNext();) {
            addPagos((Pagos) iter.next());
        }
    }

    public void addPagos(Pagos newPagos) {
        if (newPagos == null) {
            return;
        }
        if (this.pagos == null) {
            this.pagos = new java.util.HashSet<Pagos>();
        }
        if (!this.pagos.contains(newPagos)) {
            this.pagos.add(newPagos);
            newPagos.setCreditos(this);
        }
    }

    public void removePagos(Pagos oldPagos) {
        if (oldPagos == null) {
            return;
        }
        if (this.pagos != null) {
            if (this.pagos.contains(oldPagos)) {
                this.pagos.remove(oldPagos);
                oldPagos.setCreditos((Creditos) null);
            }
        }
    }

    public void removeAllPagos() {
        if (pagos != null) {
            Pagos oldPagos;
            for (java.util.Iterator iter = getIteratorPagos(); iter.hasNext();) {
                oldPagos = (Pagos) iter.next();
                iter.remove();
                oldPagos.setCreditos((Creditos) null);
            }
        }
    }

    public Solicitudes getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Solicitudes newSolicitudes) {
        if (this.solicitudes == null || !this.solicitudes.equals(newSolicitudes)) {
            if (this.solicitudes != null) {
                Solicitudes oldSolicitudes = this.solicitudes;
                this.solicitudes = null;
                oldSolicitudes.removeCreditos(this);
            }
            if (newSolicitudes != null) {
                this.solicitudes = newSolicitudes;
                this.solicitudes.addCreditos(this);
            }
        }
    }

    public TipCreditos getTipCreditos() {
        return tipCreditos;
    }

    public void setTipCreditos(TipCreditos newTipCreditos) {
        if (this.tipCreditos == null || !this.tipCreditos.equals(newTipCreditos)) {
            if (this.tipCreditos != null) {
                TipCreditos oldTipCreditos = this.tipCreditos;
                this.tipCreditos = null;
                oldTipCreditos.removeCreditos(this);
            }
            if (newTipCreditos != null) {
                this.tipCreditos = newTipCreditos;
                this.tipCreditos.addCreditos(this);
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
