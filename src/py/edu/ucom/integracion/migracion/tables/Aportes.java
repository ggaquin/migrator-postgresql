package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Aportes.java
 * Author:  Largo
 * Purpose: Defines the Class Aportes
 ***********************************************************************/
/** Tabla con los montos de aportes de los socios
 * 
 */
public class Aportes implements DatabaseTables{

    public double monto;
    public Socios socios;

    public Socios getSocios() {
        return socios;
    }

    public void setSocios(Socios newSocios) {
        if (this.socios == null || !this.socios.equals(newSocios)) {
            this.socios = newSocios;
        }
    }

    public void save(ConexionServer server) {
        //String query = new String("insert into ")
        //server.getConn().prepareStatement(null)
    }

    public void delete(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void migrar(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
