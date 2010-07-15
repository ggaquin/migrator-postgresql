/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.edu.ucom.integracion.migracion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.ucom.integracion.migracion.tables.DatabaseTables;
import py.edu.ucom.integracion.migracion.tables.Socios;

/**
 *
 * @author Largo
 */



public class Migrator
{
    String host = "localhost";
    String database = "migracion";
    String user = "postgres";
    String pass = "123456";

    void migrar(){
        ConexionServer serverOrigen = conectarse(host, "migracion", user, pass);
        ConexionServer serverDestino = conectarse(host,"cooperativa", user, pass);
        try {
            migrarSocios(serverOrigen, serverDestino);
        } catch (SQLException ex) {
            Logger.getLogger(Migrator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ConexionServer conectarse(String host, String database, String user, String pass) {
        ConexionServer server = new ConexionServer();
        server.Conector(user, pass, database, host);


        return server;
    }

    private boolean migrarSocios(ConexionServer serverOrigen, ConexionServer serverDestino) throws SQLException {
        ResultSet x = serverOrigen.selectQuery("select * from socios");
        Socios socios;
        ArrayList<DatabaseTables> arrayDatabase = new ArrayList<DatabaseTables>();
        while (x.next()) {
            socios = new Socios();
            socios.setNroSocio(x.getString(1));
            socios.setFecIngreso(x.getDate(2));
            socios.setNombres(x.getString(3));
            socios.setApellidos(x.getString(4));
            socios.setNroDocumento(x.getString(5));
            socios.setAportes(x.getInt(7));
//            System.out.println(socios.getApellidos() + " - " + socios.getFecIngreso().toString());
            arrayDatabase.add(socios);
            socios.save(serverDestino);
        }


        return false;
    }
    
    private void migrarCuotas(ConexionServer serverOrigen, ConexionServer serverDestino) throws SQLException{
    	ResultSet x = serverOrigen.selectQuery("select * from socios");
    }
}
