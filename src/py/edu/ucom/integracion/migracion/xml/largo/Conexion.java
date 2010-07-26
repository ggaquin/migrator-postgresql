package py.edu.ucom.integracion.migracion.xml.largo;

public class Conexion {
	private ConnectionType type;
	private String classname;
	private String user;
	private String password;
	private String connstring;
	
	public static enum ConnectionType{
		SOURCE,
		TARGET
	}
	

	public ConnectionType getType() {
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
