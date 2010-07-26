package py.edu.ucom.integracion.migracion.tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.util.PSQLException;

import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Pagos.java
 * Author:  Largo
 * Purpose: Defines the Class Pagos
 ***********************************************************************/
/**
 * Pagos realizados
 * 
 */
public class Pagos implements DatabaseTables {

	private String codPago;
	private Date fecPago;
	private double monto;
	private ArrayList<DetPagos> detPagos;
	private ArrayList<CuoPagadas> cuoPagadas;
	private String nroSocios;
	private String nroCreditos;

	public String getCodPago() {
		return codPago;
	}

	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}

	public Date getFecPago() {
		return fecPago;
	}

	public void setFecPago(Date fecPago) {
		this.fecPago = fecPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNroSocios() {
		return nroSocios;
	}

	public void setNroSocios(String nroSocios) {
		this.nroSocios = nroSocios;
	}

	public String getNroCreditos() {
		return nroCreditos;
	}

	public void setNroCreditos(String nroCreditos) {
		this.nroCreditos = nroCreditos;
	}

	public void save(ConexionServer server) {
		String query = new String();
		query = "INSERT INTO public.pagos(" +
			"cod_pago," +
			"nro_socio," +
			"nro_credito," +
			"fec_pago," +
			"monto) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement statement =
				server.getConn().prepareStatement(query);
			statement.setString(1, this.codPago);
			statement.setString(2, this.nroSocios);
			statement.setString(3, this.nroCreditos);
			statement.setDate(4, (java.sql.Date) this.fecPago);
			statement.setDouble(5, this.monto);
			statement.executeUpdate();
			for (DetPagos detalles : detPagos) {
				detalles.save(server);
			}
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

	public ArrayList<DetPagos> getDetPagos() {
		return detPagos;
	}

	public void setDetPagos(DetPagos detPagos) {
		this.detPagos.add(detPagos);
	}

	public ArrayList<CuoPagadas> getCuoPagadas() {
		return cuoPagadas;
	}

	public void setCuoPagadas(ArrayList<CuoPagadas> cuoPagadas) {
		this.cuoPagadas = cuoPagadas;
	}
}
