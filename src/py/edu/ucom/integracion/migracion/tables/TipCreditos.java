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

    public java.lang.String codTipCredito;
    public java.lang.String descripcion;
    public double relAporte;
    public double maxMonto;
    public java.util.Collection<Creditos> creditos;

    public java.util.Collection<Creditos> getCreditos() {
        if (creditos == null) {
            creditos = new java.util.HashSet<Creditos>();
        }
        return creditos;
    }

    public java.util.Iterator getIteratorCreditos() {
        if (creditos == null) {
            creditos = new java.util.HashSet<Creditos>();
        }
        return creditos.iterator();
    }

    public void setCreditos(java.util.Collection<Creditos> newCreditos) {
        removeAllCreditos();
        for (java.util.Iterator iter = newCreditos.iterator(); iter.hasNext();) {
            addCreditos((Creditos) iter.next());
        }
    }

    public void addCreditos(Creditos newCreditos) {
        if (newCreditos == null) {
            return;
        }
        if (this.creditos == null) {
            this.creditos = new java.util.HashSet<Creditos>();
        }
        if (!this.creditos.contains(newCreditos)) {
            this.creditos.add(newCreditos);
            newCreditos.setTipCreditos(this);
        }
    }

    public void removeCreditos(Creditos oldCreditos) {
        if (oldCreditos == null) {
            return;
        }
        if (this.creditos != null) {
            if (this.creditos.contains(oldCreditos)) {
                this.creditos.remove(oldCreditos);
                oldCreditos.setTipCreditos((TipCreditos) null);
            }
        }
    }

    public void removeAllCreditos() {
        if (creditos != null) {
            Creditos oldCreditos;
            for (java.util.Iterator iter = getIteratorCreditos(); iter.hasNext();) {
                oldCreditos = (Creditos) iter.next();
                iter.remove();
                oldCreditos.setTipCreditos((TipCreditos) null);
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
