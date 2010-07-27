/**
 * 
 */
package py.edu.ucom.integracion.migracion.xml.hernan;

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
		connSource.setClassname("org.postgresql.Driver");
		connSource.setConnstring("jdbc:postgresql://localhost/postgres");
		connSource.setUser("postgres");
		connSource.setPassword("123456");

		// Nueva coneccion para el destino
		Conexion connTarget = new Conexion();
		connTarget.setType(Conexion.ConnectionType.TARGET);
		connTarget.setClassname("org.postgresql.Driver");
		connTarget.setConnstring("jdbc:postgresql://localhost/postgres");
		connTarget.setPassword("123456");
		connTarget.setUser("postgres");

		// Nuevo objeto de configuracion
		Config config = new Config();
		// cargo las conecciones
		config.setSource(connSource);
		config.setTarget(connTarget);

		// objeto translation (donde estan los sql, campos, tipos y orden)
		Translation translation = new Translation();

		Source source = new Source();
		source.setSql("select * from socios");

		java.util.List<Field> list = new ArrayList<Field>();
		Field f = new Field();
		f.setName("nrosocio");
		f.setType(Field.Type.INTEGER);
		list.add(f);

		f = new Field();
		f.setName("nombres");
		f.setType(Field.Type.STRING);
		list.add(f);

		f = new Field();
		f.setName("apellidos");
		f.setType(Field.Type.STRING);
		list.add(f);

		// -------------------------------------------------------

		Target target = new Target();
		target.setTarget("trad_socios");

		list = new ArrayList<Field>();
		f = new Field();
		f.setName("nrosocio");
		f.setType(Field.Type.INTEGER);
		f.setOrder(1);
		f.setValue("nrosocio");
		list.add(f);

		f = new Field();
		f.setName("nombre");
		f.setType(Field.Type.STRING);
		f.setOrder(2);
		f.setValue("nombres");
		list.add(f);

		f = new Field();
		f.setName("apellido");
		f.setType(Field.Type.STRING);
		f.setOrder(2);
		f.setValue("apellidos");
		list.add(f);
		
		target.setCampos(list);

		translation.setSource(source);
		translation.setTarget(target);

		config.getTranslations().add(translation);

		// ------------------------------------------------------
		// -------------------------------------------------------
		int line = 1;
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
					if( i < (traslation.getTarget().getCampos().size())){
						sqlInsert = sqlInsert + ", ";
						values = values + ", ";
					}
				}
				sqlInsert = sqlInsert + ") values (" + values +")";  
				 
				PreparedStatement psdestino = conTarget.prepareStatement(sqlInsert);
				//conTarget.setAutoCommit(false);
				while(rsOrigen.next()){					
					i=1;
					for(Field destino : target.getCampos()){
						switch (destino.getType()) {
							case STRING:
								psdestino.setString(i,rsOrigen.getString(destino.getValue()) );
								break;
								
							case INTEGER:
								psdestino.setInt(i,rsOrigen.getInt(destino.getValue()) );
								break;	
								
							default:
								throw new  RuntimeException("No exite un cambo del tipo " + destino.getType());
						}
						i++;
					}
					
					System.out.print(".");
					if(line % 50 == 0){
						System.out.print("\n");
					}
					line++;
					psdestino.executeUpdate();
				}
				//conTarget.commit();
				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(String.format("Error en la linea %d",line));
			e.printStackTrace();
		}

	}

}
