package py.edu.ucom.integracion.migracion.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

public class Source {
	private String sql;
	private List<Field> campos;


	public Source(Element element) {
		//this.sql = new String();
		this.sql = element.getChild("sourceSql").getValue();
		List<Element> fields = new ArrayList<Element>();
		Element campos = element.getChild("fields");
		fields = campos.getChildren("field");
		for (Element campo : fields) {
			Field field = new Field();
			field.setName(campo.getAttributeValue("name"));
			field.setType(Field.Type.fromString(campo.getAttributeValue("type")));
//			field.setOrder(Integer.valueOf(campo.getAttributeValue("order")));
//			field.setValue(campo.getAttributeValue("value"));
		}
	}

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
