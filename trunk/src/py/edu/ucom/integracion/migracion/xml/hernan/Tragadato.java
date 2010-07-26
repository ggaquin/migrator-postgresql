/**
 * 
 */
package py.edu.ucom.integracion.migracion.xml.hernan;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author roshka
 * 
 */
public class Tragadato {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Nueva coneccion para el origen
		Conexion connSource = new Conexion();
		connSource.setType(Conexion.ConnectionType.SOURCE);
		connSource.setClassname("");
		connSource.setConnstring("");
		connSource.setPassword("");
		connSource.setUser("");
		// Nueva coneccion para el destino
		Conexion connTarget = new Conexion();
		connTarget.setType(Conexion.ConnectionType.TARGET);
		connTarget.setClassname("");
		connTarget.setConnstring("");
		connTarget.setPassword("");
		connTarget.setUser("");

		// Nuevo objeto de configuracion
		Config config = new Config();
		// cargo las conecciones
		config.setSource(connSource);
		config.setTarget(connTarget);

		// objeto translation (donde estan los sql, campos, tipos y orden)
		Translation translation = new Translation();

		Source source = new Source();
		source.setSql("select * from mg_country c	inner join mg_currency curr on c.baseReceiveCurrency = curr.currencyCode");

		ArrayList<Field> list = new ArrayList();
		Field f = new Field();
		f.setName("countryName");
		f.setType("string");
		list.add(f);

		f = new Field();
		f.setName("currencyName");
		f.setType("string");
		list.add(f);

		// -------------------------------------------------------

		Target target = new Target();
		target.setTarget("test");

		list = new ArrayList();
		f = new Field();
		f.setName("nombre_pais");
		f.setType("string");
		f.setOrder(1);
		f.setValue("countryName");
		list.add(f);

		f = new Field();
		f.setName("nombre_moneda");
		f.setType("string");
		f.setOrder(2);
		f.setValue("currencyName");
		list.add(f);

		target.setCampos(list);

		translation.setSource(source);
		translation.setTarget(target);

		config.getTranslations().add(translation);

		// ------------------------------------------------------
		// -------------------------------------------------------

		try {
			Class.forName(config.getSource().getClassname());
			Connection conSource = DriverManager.getConnection(
					config.getSource().getConnstring(),
					config.getSource().getUser(),
					config.getSource().getPassword()
				);

			Class.forName(config.getTarget().getClassname());
			Connection conTarget = DriverManager.getConnection(
					config.getTarget().getConnstring(),
					config.getTarget().getUser(),
					config.getTarget().getPassword()
				);

			for (Translation traslation : config.getTranslations()) {
				PreparedStatement psOrigen = conSource.prepareStatement(
																traslation.getSource().getSql());

				ResultSet rsOrigen = psOrigen.executeQuery();
				
				//--------
				//conseguir una conexion al desitno, armar el sql de insert
				//--------
				String sqlInsert = "insert into " + traslation.getTarget().getTarget() + "  (";
				String values = "";
				int i = 0;
				for(Field campo : traslation.getTarget().getCampos()){
					sqlInsert = sqlInsert + campo.getName();
					values = values + "?";
					i++;
					if( i < (traslation.getTarget().getCampos().size()-1)){
						sqlInsert = sqlInsert + ", ";
						values = values + ", ";
					}
				}
				sqlInsert = sqlInsert + ") values (" + values +")";  
				 
				
				
				while(rsOrigen.next()){
					
				}
				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
