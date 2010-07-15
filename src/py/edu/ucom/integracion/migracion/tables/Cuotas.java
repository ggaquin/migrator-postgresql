package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Cuotas.java
 * Author:  Largo
 * Purpose: Defines the Class Cuotas
 ***********************************************************************/
/** Tabla con las cuotas generadas por los creditos desembolsados a los socios
 * 
 */
public class Cuotas implements DatabaseTables{

    public java.lang.String nroCuota;
    public double canCuota;
    public double monCuota;
    public java.util.Date fecUltCuoPagada;
    public double salCuota;
    public java.util.Collection<CuoPagadas> cuoPagadas;

    public java.util.Collection<CuoPagadas> getCuoPagadas() {
        if (cuoPagadas == null) {
            cuoPagadas = new java.util.HashSet<CuoPagadas>();
        }
        return cuoPagadas;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorCuoPagadas() {
        if (cuoPagadas == null) {
            cuoPagadas = new java.util.HashSet<CuoPagadas>();
        }
        return cuoPagadas.iterator();
    }

    /** @pdGenerated default setter
     * @param newCuoPagadas */
    public void setCuoPagadas(java.util.Collection<CuoPagadas> newCuoPagadas) {
        removeAllCuoPagadas();
        for (java.util.Iterator iter = newCuoPagadas.iterator(); iter.hasNext();) {
            addCuoPagadas((CuoPagadas) iter.next());
        }
    }

    /** @pdGenerated default add
     * @param newCuoPagadas */
    public void addCuoPagadas(CuoPagadas newCuoPagadas) {
        if (newCuoPagadas == null) {
            return;
        }
        if (this.cuoPagadas == null) {
            this.cuoPagadas = new java.util.HashSet<CuoPagadas>();
        }
        if (!this.cuoPagadas.contains(newCuoPagadas)) {
            this.cuoPagadas.add(newCuoPagadas);
            newCuoPagadas.setCuotas(this);
        }
    }

    /** @pdGenerated default remove
     * @param oldCuoPagadas */
    public void removeCuoPagadas(CuoPagadas oldCuoPagadas) {
        if (oldCuoPagadas == null) {
            return;
        }
        if (this.cuoPagadas != null) {
            if (this.cuoPagadas.contains(oldCuoPagadas)) {
                this.cuoPagadas.remove(oldCuoPagadas);
                oldCuoPagadas.setCuotas((Cuotas) null);
            }
        }
    }

    /** @pdGenerated default removeAll */
    public void removeAllCuoPagadas() {
        if (cuoPagadas != null) {
            CuoPagadas oldCuoPagadas;
            for (java.util.Iterator iter = getIteratorCuoPagadas(); iter.hasNext();) {
                oldCuoPagadas = (CuoPagadas) iter.next();
                iter.remove();
                oldCuoPagadas.setCuotas((Cuotas) null);
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
