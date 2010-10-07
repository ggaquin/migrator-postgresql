package py.edu.ucom.integracion.migracion.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

public class Target {
	private String target;
	private List<Field> campos = new ArrayList<Field>();
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public Target(Element element) {
		//Element target = element.getChild("target");
		this.setTarget(element.getAttributeValue("name"));
		List<Element> fields = new ArrayList<Element>();
		Element target = element.getChild("fields"); 
		fields = target.getChildren("field");
		for (Element campo : fields) {
			Field field = new Field();
			field.setName(campo.getAttributeValue("name"));
			field.setType(field.getType().fromString(campo.getAttributeValue("type")));
			field.setOrder(Integer.valueOf(campo.getAttributeValue("order")));
			field.setValue(campo.getAttributeValue("value"));
			this.campos.add(field);
		}
	}
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
