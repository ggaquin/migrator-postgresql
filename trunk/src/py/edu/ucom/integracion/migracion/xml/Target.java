package py.edu.ucom.integracion.migracion.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

public class Target {
	private String target;
	private List<Field> campos;
	
	public Target(Element element) {
		Element target = element.getChild("target");
		this.setTarget(target.getValue());
		List<Element> fields = new ArrayList<Element>();
		fields = target.getChildren("fields");
		for (Element campo : fields) {
			Field field = new Field();
			field.setName(campo.getAttributeValue("name"));
			field.setType(field.getType().fromString(campo.getAttributeValue("type")));
			field.setOrder(Integer.valueOf(campo.getAttributeValue("order")));
			field.setValue(campo.getAttributeValue("value"));
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
