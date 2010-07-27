package py.edu.ucom.integracion.migracion.xml.hernan;

import java.util.ArrayList;
import java.util.List;

public class Target {
	private String target;
	private List<Field> campos;
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<Field> getCampos() {
		return campos;
	}
	public void setCampos(List<Field> campos) {
		this.campos = campos;
	}

}
