package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Pagos.java
 * Author:  Largo
 * Purpose: Defines the Class Pagos
 ***********************************************************************/
/** Pagos realizados
 * 
 */
public class Pagos implements DatabaseTables{

    public java.lang.String codPago;
    public java.util.Date fecPago;
    public double monto;
    public java.util.Collection<DetPagos> detPagos;
    public java.util.Collection<CuoPagadas> cuoPagadas;
    public Socios socios;
    public Creditos creditos;

    /** @pdGenerated default getter */
    public java.util.Collection<DetPagos> getDetPagos() {
        if (detPagos == null) {
            detPagos = new java.util.HashSet<DetPagos>();
        }
        return detPagos;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorDetPagos() {
        if (detPagos == null) {
            detPagos = new java.util.HashSet<DetPagos>();
        }
        return detPagos.iterator();
    }

    /** @pdGenerated default setter
     * @param newDetPagos */
    public void setDetPagos(java.util.Collection<DetPagos> newDetPagos) {
        removeAllDetPagos();
        for (java.util.Iterator iter = newDetPagos.iterator(); iter.hasNext();) {
            addDetPagos((DetPagos) iter.next());
        }
    }

    /** @pdGenerated default add
     * @param newDetPagos */
    public void addDetPagos(DetPagos newDetPagos) {
        if (newDetPagos == null) {
            return;
        }
        if (this.detPagos == null) {
            this.detPagos = new java.util.HashSet<DetPagos>();
        }
        if (!this.detPagos.contains(newDetPagos)) {
            this.detPagos.add(newDetPagos);
            newDetPagos.setPagos(this);
        }
    }

    /** @pdGenerated default remove
     * @param oldDetPagos */
    public void removeDetPagos(DetPagos oldDetPagos) {
        if (oldDetPagos == null) {
            return;
        }
        if (this.detPagos != null) {
            if (this.detPagos.contains(oldDetPagos)) {
                this.detPagos.remove(oldDetPagos);
                oldDetPagos.setPagos((Pagos) null);
            }
        }
    }

    /** @pdGenerated default removeAll */
    public void removeAllDetPagos() {
        if (detPagos != null) {
            DetPagos oldDetPagos;
            for (java.util.Iterator iter = getIteratorDetPagos(); iter.hasNext();) {
                oldDetPagos = (DetPagos) iter.next();
                iter.remove();
                oldDetPagos.setPagos((Pagos) null);
            }
        }
    }

    /** @pdGenerated default getter */
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
            newCuoPagadas.setPagos(this);
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
                oldCuoPagadas.setPagos((Pagos) null);
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
                oldCuoPagadas.setPagos((Pagos) null);
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
                oldSocios.removePagos(this);
            }
            if (newSocios != null) {
                this.socios = newSocios;
                this.socios.addPagos(this);
            }
        }
    }

    /** @pdGenerated default parent getter */
    public Creditos getCreditos() {
        return creditos;
    }

    /** @pdGenerated default parent setter
     * @param newCreditos */
    public void setCreditos(Creditos newCreditos) {
        if (this.creditos == null || !this.creditos.equals(newCreditos)) {
            if (this.creditos != null) {
                Creditos oldCreditos = this.creditos;
                this.creditos = null;
                oldCreditos.removePagos(this);
            }
            if (newCreditos != null) {
                this.creditos = newCreditos;
                this.creditos.addPagos(this);
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
