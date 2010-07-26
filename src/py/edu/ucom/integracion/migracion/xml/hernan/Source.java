package py.edu.ucom.integracion.migracion.xml.hernan;

import java.util.List;

public class Source {
	private String sql;
	private List<Field> campos;


	public List<Field> getCampos() {
		return campos;
	}

	public void setCampos(List<Field> campos) {
		this.campos = campos;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	
}
