package py.edu.ucom.integracion.migracion.xml.largo;

import java.util.ArrayList;
import java.util.List;

public class Config {
	private Conexion source;
	private Conexion target;
	private List<Translation> translations = new ArrayList<Translation>();
	
	public Conexion getSource() {
		return source;
	}
	public void setSource(Conexion source) {
		this.source = source;
	}
	public Conexion getTarget() {
		return target;
	}
	public void setTarget(Conexion target) {
		this.target = target;
	}
	public List<Translation> getTranslations() {
		return translations;
	}
	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	

}
