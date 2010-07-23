package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  DetPagos.java
 * Author:  Largo
 * Purpose: Defines the Class DetPagos
 ***********************************************************************/
/**
 * Detalle de los pagos realizados por los socion
 * 
 */
public class DetPagos implements DatabaseTables {

	public String codPagDetalle;
	public TipPagos tipPagos;


	@Override
	public void delete(ConexionServer server) {
		// TODO Auto-generated method stub

	}

	@Override
	public void migrar(ConexionServer server) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(ConexionServer server) {
		String query = new String();
		TipPagos tipPago;
		query = "INSERT INTO public.pagos(" +
			"cod_pago," +
			"nro_socio," +
			"nro_credito," +
			"fec_pago," +
			"monto) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.codPagDetalle);
//			statement.setString(2, this.nroSocios);
//			statement.setString(3, this.nroCreditos);
//			statement.setDate(4, (java.sql.Date) this.fecPago);
//			statement.setDouble(5, this.monto);


			statement.executeUpdate();
		} catch (PSQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * @return the codPagDetalle
	 */
	public java.lang.String getCodPagDetalle() {
		return codPagDetalle;
	}

	/**
	 * @return the tipPagos
	 */
	public TipPagos getTipPagos() {
		return tipPagos;
	}


	/**
	 * @param codPagDetalle
	 *           the codPagDetalle to set
	 */
	public void setCodPagDetalle(java.lang.String codPagDetalle) {
		this.codPagDetalle = codPagDetalle;
	}

	/**
	 * @param tipPagos
	 *           the tipPagos to set
	 */
	public void setTipPagos(TipPagos tipPagos) {
		this.tipPagos = tipPagos;
	}


}
