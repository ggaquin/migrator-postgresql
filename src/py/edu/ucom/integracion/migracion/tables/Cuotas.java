package py.edu.ucom.integracion.migracion.tables;

import java.util.ArrayList;
import java.util.Date;

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

    public String nroCuota;
    public double canCuota;
    public double monCuota;
    public Date fecUltCuoPagada;
    public double salCuota;
    public ArrayList<CuoPagadas> cuoPagadas;

    public ArrayList<CuoPagadas> getCuoPagadas() {
    	if (this.cuoPagadas == null){
    		this.cuoPagadas = new ArrayList<CuoPagadas>();
    	}
        return cuoPagadas;
    }

    public void setCuoPagadas(ArrayList<CuoPagadas> newCuoPagadas) {
    	this.cuoPagadas = newCuoPagadas;
    }

    public void setCuoPagadas(CuoPagadas newCuoPagadas) {
    	
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
