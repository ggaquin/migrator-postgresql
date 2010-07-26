package py.edu.ucom.integracion.migracion.xml.largo;

public class Field {
	private String name;
	private String type;
	private String value;
	private int order;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
