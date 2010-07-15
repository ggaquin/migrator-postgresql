/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion.tables;

import py.edu.ucom.integracion.migracion.ConexionServer;

/**
 *
 * @author Largo
 */
public abstract interface  DatabaseTables  {
    public void save(ConexionServer server);
    public void delete(ConexionServer server);
    public void migrar(ConexionServer server);

}
