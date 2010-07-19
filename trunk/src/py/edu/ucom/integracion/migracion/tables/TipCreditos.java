package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

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

	/**
	 * @param codTipCredito
	 */
	public TipCreditos(String codTipCredito) {
		this.codTipCredito = codTipCredito;
	}
	public TipCreditos(){
		
	}

	private String codTipCredito;
    private String descripcion;
    private double relAporte;
    private double maxMonto;
    

    public void save(ConexionServer server) {
		String query = new String();
		query = "INSERT INTO public.tip_creditos " +
			"VALUES (?,?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.codTipCredito);
			statement.setString(2, this.descripcion);
			statement.setDouble(3, this.relAporte);
			statement.setDouble(4, this.maxMonto);

			// System.out.println(this.nombres + " - " +
			// this.fecIngreso.toString());

			statement.executeUpdate();
		} catch (PSQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

    public void delete(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void migrar(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	/**
	 * @return the codTipCredito
	 */
	public String getCodTipCredito() {
		return codTipCredito;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the relAporte
	 */
	public double getRelAporte() {
		return relAporte;
	}

	/**
	 * @return the maxMonto
	 */
	public double getMaxMonto() {
		return maxMonto;
	}

	/**
	 * @param codTipCredito the codTipCredito to set
	 */
	public void setCodTipCredito(String codTipCredito) {
		this.codTipCredito = codTipCredito;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param relAporte the relAporte to set
	 */
	public void setRelAporte(double relAporte) {
		this.relAporte = relAporte;
	}

	/**
	 * @param maxMonto the maxMonto to set
	 */
	public void setMaxMonto(double maxMonto) {
		this.maxMonto = maxMonto;
	}
}
