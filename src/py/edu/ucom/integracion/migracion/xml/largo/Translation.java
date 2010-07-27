package py.edu.ucom.integracion.migracion.xml.largo;

import org.jdom.Element;


public class Translation {
	private Source source;
	private Target target;
	
	public Translation(Element element) {
		source = new Source(element.getChild("source"));
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}

}
