package py.edu.ucom.integracion.migracion.xml;

import org.jdom.Element;

public class Conexion {
	private ConnectionType type;
	private String classname;
	private String user;
	private String password;
	private String connstring;
	
	public Conexion(Element element) {
		this.classname=element.getAttributeValue(classname);
		this.user = element.getAttributeValue("user");
		this.password = element.getAttributeValue("password");
		this.connstring = element.getAttributeValue("connstring");
	}
	
	public static enum ConnectionType{
		SOURCE("source"),
		TARGET("target");
		
		private String value;
		
		ConnectionType(String value){
			this.value = value;
			
		}
		public String toString(){
			return value;
		}
		
		public static ConnectionType fromString(String value){
			if(value.equalsIgnoreCase(ConnectionType.SOURCE.toString())){
				return ConnectionType.SOURCE;
			} else 
			if(value.equalsIgnoreCase(ConnectionType.TARGET.toString())){
				return ConnectionType.TARGET;
			}
			return null;
			
		}
	}
	

	public ConnectionType getType() {
		ConnectionType.SOURCE.toString();
		return type;
	}
	public void setType(ConnectionType type) {
		this.type = type;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConnstring() {
		return connstring;
	}
	public void setConnstring(String connstring) {
		this.connstring = connstring;
	}

}
