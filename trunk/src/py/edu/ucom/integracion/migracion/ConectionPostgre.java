package py.edu.ucom.integracion.migracion;

import java.sql.*;

/**
 *
 * @author largonet
 */
public class ConectionPostgre {
    //Parametros de conexion para el Postgre

    private static CallableStatement stmt;
    private String driver = "org.postgresql.Driver";
    private static String direccionPostgre = "jdbc:postgresql://";
    private static String ipPostgre = "127.0.0.1";
    private static String portPostgre = "5432";
    private static String userPostgre = "postgre";
    private static String passPostgre = "123456";
    private static String databasePostgre = "migracion";
    private static Connection connPostgre;

    /**
     * 
     * @param 
     * @return
     */
    public String Personas(
            String NroDocumento) throws ClassNotFoundException {
        // declaramos las variables de salida del procedimiento
        String PriNombre, SegNombre, PriApellido, SegApellido, ApeCasada;
        String FecNac, EstCivil, Sexo, Nacionalidad, Profesion;
        // declaramos la variable/manejador de error
        String MsgError;
        // declaramos la variable que utilizaremos para concatenar y retornar la respuesta
        String Respuesta = new String();
        //declaramos el resultset
        ResultSet rsetPersonas;
        try {
            //me conecto al sybase
            ConectarsePostgre();
            //preparo la sentencia para llamar el procedimiento que obtiene los datos personales
            //recibe como paramentro de entrada el Numero de Documento de la persona.
            stmt = connPostgre.prepareCall("{call sp_olp_datos_personales ?}");
            //preparo los parametos de tipo IN y OUT
            stmt.setString(1, NroDocumento);
            //Ejecuto el procedimiento
            rsetPersonas = stmt.executeQuery();
            if (rsetPersonas.next()) {
                //Recorro el ResultSet
                do {
                    PriNombre = rsetPersonas.getString(1); // Primer Nombre
                    SegNombre = rsetPersonas.getString(2); // Segundo Nombre
                    PriApellido = rsetPersonas.getString(3); // Primer Apellido
                    SegApellido = rsetPersonas.getString(4); // Segundo Apellido
                    ApeCasada = rsetPersonas.getString(5); // Apellido Casada
                    FecNac = rsetPersonas.getString(6); // Fecha de Nacimiento
                    EstCivil = rsetPersonas.getString(7); // Estado Civil
                    Sexo = rsetPersonas.getString(8); // Sexo
                    Nacionalidad = rsetPersonas.getString(9); // Nacionalidad
                    Profesion = rsetPersonas.getString(10); // Profesion
                    //Concatenamos las variables
                    Respuesta = (Respuesta + PriNombre + "~" + SegNombre + "~" + PriApellido + "~" + SegApellido + "~" + ApeCasada + "~"
                            + FecNac + "~" + EstCivil + "~" + Sexo + "~" + Nacionalidad + "~" + Profesion + "\\");
                } while (rsetPersonas.next());
            }
            //Cierro la conexion
            closeConnexion(connPostgre);
            // retorno la respuesta obtuvida
            return Respuesta;
        } //Manejo de errores
        catch (SQLException Sqle) {
            //Sqle.printStackTrace();
            MsgError = Sqle.getMessage();

            closeConnexion(connPostgre);
            return "11~" + MsgError;
        } catch (NullPointerException Nulle) {
            MsgError = Nulle.getMessage();
            //Nulle.printStackTrace();
            closeConnexion(connPostgre);
            return "12~" + MsgError;
        }
    }

    /**
     * Metodo para establecer una conexion a la base de datos Sybase de Informconf
     * @throws java.sql.SQLException
     */
    private void ConectarsePostgre() throws SQLException, ClassNotFoundException {
        try {
            try {
                Class.forName(driver);
                //DriverManager.getConnection(direccionPostgre, userPostgre , passPostgre);
                //DriverManager.registerDriver(new org.postgresql.jdbc4.Jdbc4Connection(ipPostgre, port, userPostgre, ipPostgre, null, ipPostgre)SybDriver());
                connPostgre = DriverManager.getConnection(direccionPostgre + ipPostgre + ":" + portPostgre, userPostgre, passPostgre);

            } catch (SQLException sQLException) {
                Class.forName(driver);
                connPostgre = DriverManager.getConnection(direccionPostgre + ipPostgre + ":" + portPostgre, userPostgre, passPostgre);
            }

        } catch (SQLException sQLException) {
            System.out.println("Error al establecer la conexion");
        }

    }

    /**
     * Metodo para cerrar una conexion
     */
    private static void closeConnexion(Connection conn) {
        try {
            conn.close();
        } catch (SQLException SQLe) {
            System.out.println("Error al cerrar conexion");
        } catch (NullPointerException h) {
            System.out.println("No hay conexion abierta.");
        }

    }
}
