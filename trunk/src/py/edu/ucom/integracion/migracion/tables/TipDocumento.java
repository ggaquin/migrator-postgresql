package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  TipDocumento.java
 * Author:  Largo
 * Purpose: Defines the Class TipDocumento
 ***********************************************************************/
/** Tabla con los tipos de documentos para las personas
 * 
 */
public class TipDocumento implements DatabaseTables {

    public java.lang.String codTipDocumento;
    public java.lang.String descripcion;
    public java.lang.String abreviacion;
    public Socios socios;

    public void setSocios(Socios newSocios) {
        if (this.socios == null) {
            this.socios = newSocios;
        }
    }

    public Socios getSocios() {
        return this.socios;
    }

    public void setAbreviacion(String newAbreviacion) {
        if (this.abreviacion == null) {
            this.abreviacion = newAbreviacion;
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
