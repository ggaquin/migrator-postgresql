package py.edu.ucom.integracion.migracion.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Config {
	private Conexion source;
	private Conexion target;
	private List<Translation> translations = new ArrayList<Translation>();

	public Config() {
		SAXBuilder builder = new SAXBuilder();
		Document doc = new Document();
		try {
			doc = builder.build("XML/pwelti.xml");
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		List<Element> conn = root.getChildren("conn");
		for (Element element : conn) {
			String type = element.getAttribute("type").getValue();
			if (type.compareToIgnoreCase(Conexion.ConnectionType.SOURCE.toString()) == 0) {
				Conexion connSource = new Conexion(element);
			}
			else {
				Conexion connTarget = new Conexion(element);

			}
		}

		Element translation = root.getChild("translations");
		List<Element> translations = translation.getChildren("translation");
		for (Element element : translations) {
			Translation trans = new Translation(element);
		}
		/*
		 * Boolean.parseBoolean(statusNode.getValue()); Element tableNode =
		 * connSource.getChild("table");
		 * Integer.parseInt(tableNode.getAttributeValue("id"));
		 */

	}

	public Conexion getSource() {
		return source;
	}

	public void setSource(Conexion source) {
		this.source = source;
	}

	public Conexion getTarget() {
		return target;
	}

	public void setTarget(Conexion target) {
		this.target = target;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

}
