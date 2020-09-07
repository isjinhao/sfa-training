package jishuneimu.basis.xmlparse;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/26
 */
public class XPathTest {

    public static void main(String[] args) throws Exception {

        System.out.println(boolean.class.equals(Boolean.class));

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // 关闭DTD验证
        documentBuilderFactory.setValidating(false);

        documentBuilder.setEntityResolver(new InventoryEntityResolver());

        Document document = documentBuilder.parse("mybatis-learn\\src\\main\\java\\jishuneimu\\basis\\xmlparse\\inventory.xml");

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression expression = xPath.compile("//book[author='Neal Stephenson']/title/text()");

        NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            System.out.println(item.getNodeValue());
        }

        System.out.println("\n***********************************************\n");
        nodeList = (NodeList) xPath.evaluate("//book[@year>1997]/@*|//book[@year>1997]/title/text()", document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            System.out.println(item.getNodeValue());
        }

    }
}

class InventoryEntityResolver implements EntityResolver {

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        InputStream in = Resources.getResourceAsStream("jishuneimu/basis/xmlparse/inventory.xsd");
        System.out.println(in.available());
        InputSource source = new InputSource(in);
        source.setPublicId(publicId);
        source.setSystemId(systemId);
        return source;
    }
}