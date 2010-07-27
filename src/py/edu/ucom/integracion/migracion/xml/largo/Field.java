package py.edu.ucom.integracion.migracion.xml.largo;

import py.edu.ucom.integracion.migracion.xml.largo.Conexion.ConnectionType;

public class Field {

	public static enum Type {
		STRING("STRING"),
		INTEGER("INTEGER"),
		DATE("DATE"),
		BOOLEAN("BOOLEAN");

		private String typeString;

		Type(String value) {
			this.typeString = value;

		}

		public String toString() {
			return typeString;
		}

		public static Type fromString(String value) {
			if (value.equalsIgnoreCase(Type.BOOLEAN.toString()))
				return Type.BOOLEAN;
			else
				if (value.equalsIgnoreCase(Type.DATE.toString()))
					return Type.DATE;
				else
					if (value.equalsIgnoreCase(Type.INTEGER.toString()))
						return Type.INTEGER;
					else
						if (value.equalsIgnoreCase(Type.STRING.toString()))
							return Type.STRING;

			return null;
		}
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
