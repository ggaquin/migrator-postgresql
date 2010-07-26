package py.edu.ucom.integracion.migracion.xml.largo;

import java.util.ArrayList;

public class Target {
	private String target;
	private ArrayList<Field> campos;
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public ArrayList<Field> getCampos() {
		return campos;
	}
	public void setCampos(ArrayList<Field> campos) {
		this.campos = campos;
	}

}
