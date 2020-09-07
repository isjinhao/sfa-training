package headfirst._20_bridge;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

class ReadXML {

    public static Object getObject(String args) {

        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("design-pattern/src/main/java/headfirst/_20_bridge/config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = null;
            if (args.equals("color")) {
                classNode = nl.item(0).getFirstChild();
            } else if (args.equals("bag")) {
                classNode = nl.item(1).getFirstChild();
            }
            String cName = "headfirst._20_bridge." + classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}