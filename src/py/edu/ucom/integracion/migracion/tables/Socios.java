package py.edu.ucom.integracion.migracion.tables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;
import py.edu.ucom.integracion.migracion.ConexionServer;

/***********************************************************************
 * Module:  Socios.java
 * Author:  Largo
 * Purpose: Defines the Class Socios
 ***********************************************************************/
/** Tabla de socios de la cooperativa
 * 
 * 
 */
public class Socios implements DatabaseTables {

    private java.lang.String nroSocio;
    private java.lang.String nombres;
    private java.lang.String apellidos;
    private java.lang.String nroDocumento;
    private java.util.Date fecIngreso;
    public Aportes aportes;
    public java.util.Collection<Pagos> pagos;
    public java.util.Collection<Solicitudes> solicitudes;
    private TipDocumento tipDocumento;

    public Aportes getAportes() {
        if (aportes == null) {
            aportes = new Aportes();
        }
        return aportes;
    }

    public void setAportes(int aportes) {
    }

    public void addAportes(Aportes aportes) {
        if (this.aportes == null) {
            this.aportes = aportes;
        }

    }

    public java.util.Collection<Pagos> getPagos() {
        if (pagos == null) {
            pagos = new java.util.HashSet<Pagos>();
        }
        return pagos;
    }

    public java.util.Iterator getIteratorPagos() {
        if (pagos == null) {
            pagos = new java.util.HashSet<Pagos>();
        }
        return pagos.iterator();
    }

    public void setPagos(java.util.Collection<Pagos> newPagos) {
        removeAllPagos();
        for (java.util.Iterator iter = newPagos.iterator(); iter.hasNext();) {
            addPagos((Pagos) iter.next());
        }
    }

    public void addPagos(Pagos newPagos) {
        if (newPagos == null) {
            return;
        }
        if (this.pagos == null) {
            this.pagos = new java.util.HashSet<Pagos>();
        }
        if (!this.pagos.contains(newPagos)) {
            this.pagos.add(newPagos);
            newPagos.setSocios(this);
        }
    }

    public void removePagos(Pagos oldPagos) {
        if (oldPagos == null) {
            return;
        }
        if (this.pagos != null) {
            if (this.pagos.contains(oldPagos)) {
                this.pagos.remove(oldPagos);
                oldPagos.setSocios((Socios) null);
            }
        }
    }

    public void removeAllPagos() {
        if (pagos != null) {
            Pagos oldPagos;
            for (java.util.Iterator iter = getIteratorPagos(); iter.hasNext();) {
                oldPagos = (Pagos) iter.next();
                iter.remove();
                oldPagos.setSocios((Socios) null);
            }
        }
    }

    public java.util.Collection<Solicitudes> getSolicitudes() {
        if (solicitudes == null) {
            solicitudes = new java.util.HashSet<Solicitudes>();
        }
        return solicitudes;
    }

    public java.util.Iterator getIteratorSolicitudes() {
        if (solicitudes == null) {
            solicitudes = new java.util.HashSet<Solicitudes>();
        }
        return solicitudes.iterator();
    }

    public void setSolicitudes(java.util.Collection<Solicitudes> newSolicitudes) {
        removeAllSolicitudes();
        for (java.util.Iterator iter = newSolicitudes.iterator(); iter.hasNext();) {
            addSolicitudes((Solicitudes) iter.next());
        }
    }

    public void addSolicitudes(Solicitudes newSolicitudes) {
        if (newSolicitudes == null) {
            return;
        }
        if (this.solicitudes == null) {
            this.solicitudes = new java.util.HashSet<Solicitudes>();
        }
        if (!this.solicitudes.contains(newSolicitudes)) {
            this.solicitudes.add(newSolicitudes);
            newSolicitudes.setSocios(this);
        }
    }

    public void removeSolicitudes(Solicitudes oldSolicitudes) {
        if (oldSolicitudes == null) {
            return;
        }
        if (this.solicitudes != null) {
            if (this.solicitudes.contains(oldSolicitudes)) {
                this.solicitudes.remove(oldSolicitudes);
                oldSolicitudes.setSocios((Socios) null);
            }
        }
    }

    public void removeAllSolicitudes() {
        if (solicitudes != null) {
            Solicitudes oldSolicitudes;
            for (java.util.Iterator iter = getIteratorSolicitudes(); iter.hasNext();) {
                oldSolicitudes = (Solicitudes) iter.next();
                iter.remove();
                oldSolicitudes.setSocios((Socios) null);
            }
        }
    }

    public TipDocumento getTipDocumento() {
        return tipDocumento;
    }

    public void setTipDocumento(TipDocumento newTipDocumento) {
        if (tipDocumento == null) {
            this.tipDocumento = newTipDocumento;
        }
    }

    /**
     * @return the nroSocio
     */
    public java.lang.String getNroSocio() {
        return nroSocio;
    }

    /**
     * @param nroSocio the nroSocio to set
     */
    public void setNroSocio(java.lang.String nroSocio) {
        this.nroSocio = nroSocio;
    }

    /**
     * @return the nombres
     */
    public java.lang.String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(java.lang.String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public java.lang.String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(java.lang.String apellidos) {
        this.apellidos = apellidos;
    }

    public void save(ConexionServer server) {
        String query = new String();
        query = "INSERT INTO socios (cod_tip_documento,"
                + "nro_socio,"
                + "nombres,"
                + "apellidos,"
                + "nro_documento,"
                + "fec_ingreso) "
                + "VALUES('1',?,?,?,?,?)";
        try {
            PreparedStatement statement =
                    server.getConn().prepareStatement(query);
            statement.setString(1, this.nroSocio);
            statement.setString(2, this.nombres);
            statement.setString(3, this.apellidos);
            statement.setString(4, this.nroDocumento);
            statement.setDate(5, (Date) this.fecIngreso);

            //System.out.println(this.nombres + " - " + this.fecIngreso.toString());

            statement.executeUpdate();
        } catch (PSQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return;
        }
        //System.out.println(this.nombres + " - " + this.fecIngreso.toString());
    }

    public void delete(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the nroDocumento
     */
    public java.lang.String getNroDocumento() {
        return nroDocumento;
    }

    /**
     * @param nroDocumento the nroDocumento to set
     */
    public void setNroDocumento(java.lang.String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    /**
     * @return the fecIngreso
     */
    public java.util.Date getFecIngreso() {
        return fecIngreso;
    }

    /**
     * @param fecIngreso the fecIngreso to set
     */
    public void setFecIngreso(java.util.Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public void migrar(ConexionServer server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
