package py.edu.ucom.integracion.migracion.xml.hernan;

public class Field {
	
	public static enum Type{
		STRING, INTEGER, DATE, BOOLEAN
	}
	
	private String name;
	private Type type;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}


}
