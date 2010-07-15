package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Solicitudes.java
 * Author:  Largo
 * Purpose: Defines the Class Solicitudes
 ***********************************************************************/
/** Detalle de las solicitudes de creditos
 * 
 */
public class Solicitudes implements DatabaseTables {

    public java.lang.String nroSolicitud;
    public java.util.Date fecSolicitud;
    public java.util.Collection<Creditos> creditos;
    public Socios socios;

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
            newCreditos.setSolicitudes(this);
        }
    }

    public void removeCreditos(Creditos oldCreditos) {
        if (oldCreditos == null) {
            return;
        }
        if (this.creditos != null) {
            if (this.creditos.contains(oldCreditos)) {
                this.creditos.remove(oldCreditos);
                oldCreditos.setSolicitudes((Solicitudes) null);
            }
        }
    }

    public void removeAllCreditos() {
        if (creditos != null) {
            Creditos oldCreditos;
            for (java.util.Iterator iter = getIteratorCreditos(); iter.hasNext();) {
                oldCreditos = (Creditos) iter.next();
                iter.remove();
                oldCreditos.setSolicitudes((Solicitudes) null);
            }
        }
    }

    /** @pdGenerated default parent getter */
    public Socios getSocios() {
        return socios;
    }

    /** @pdGenerated default parent setter
     * @param newSocios */
    public void setSocios(Socios newSocios) {
        if (this.socios == null || !this.socios.equals(newSocios)) {
            if (this.socios != null) {
                Socios oldSocios = this.socios;
                this.socios = null;
                oldSocios.removeSolicitudes(this);
            }
            if (newSocios != null) {
                this.socios = newSocios;
                this.socios.addSolicitudes(this);
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
