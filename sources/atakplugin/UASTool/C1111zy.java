package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: atakplugin.UASTool.zy */
public class C1111zy {
    /* renamed from: a */
    public static List<Document> m15016a(Document document, int i) {
        XPathExpression xPathExpression;
        XPath xPath;
        int i2 = i * 1000;
        XPath newXPath = XPathFactory.newInstance().newXPath();
        XPathExpression compile = newXPath.compile("//*[name()='p']");
        ArrayList arrayList = new ArrayList();
        while (true) {
            long size = (long) (arrayList.size() * i2);
            long size2 = (long) ((arrayList.size() + 1) * i2);
            Document document2 = (Document) document.cloneNode(true);
            NodeList nodeList = (NodeList) compile.evaluate(document2, XPathConstants.NODESET);
            int i3 = 0;
            boolean z = false;
            while (i3 < nodeList.getLength()) {
                int i4 = i2;
                Node item = nodeList.item(i3);
                long a = C1108zw.m15008a(item);
                long b = C1108zw.m15015b(item);
                if (a >= size || b <= size) {
                    xPath = newXPath;
                    xPathExpression = compile;
                } else {
                    xPath = newXPath;
                    xPathExpression = compile;
                    m15020a(item, "begin", size - a);
                    a = size;
                }
                if (a >= size && a < size2 && b > size2) {
                    m15020a(item, "end", size2 - b);
                    a = size;
                    b = size2;
                }
                if (a > size2) {
                    z = true;
                }
                if (a < size || b > size2) {
                    item.getParentNode().removeChild(item);
                } else {
                    long j = -size;
                    m15020a(item, "begin", j);
                    m15020a(item, "end", j);
                }
                i3++;
                newXPath = xPath;
                i2 = i4;
                compile = xPathExpression;
            }
            m15018a((Node) document2);
            Element element = (Element) newXPath.compile("/*[name()='tt']/*[name()='body'][1]").evaluate(document2, XPathConstants.NODE);
            String attribute = element.getAttribute("begin");
            String attribute2 = element.getAttribute("end");
            int i5 = i2;
            if (attribute == null || "".equals(attribute)) {
                element.setAttribute("begin", C1108zw.m15009a(size));
            } else {
                m15020a(element, "begin", size);
            }
            if (attribute2 == null || "".equals(attribute2)) {
                element.setAttribute("end", C1108zw.m15009a(size2));
            } else {
                m15020a(element, "end", size2);
            }
            arrayList.add(document2);
            if (!z) {
                return arrayList;
            }
            i2 = i5;
        }
    }

    /* renamed from: a */
    public static void m15020a(Node node, String str, long j) {
        int i;
        if (node.getAttributes() != null && node.getAttributes().getNamedItem(str) != null) {
            String nodeValue = node.getAttributes().getNamedItem(str).getNodeValue();
            long a = C1108zw.m15007a(nodeValue) + j;
            if (nodeValue.contains(".")) {
                i = -1;
            } else {
                i = ((int) (a - ((a / 1000) * 1000))) / 44;
            }
            node.getAttributes().getNamedItem(str).setNodeValue(C1108zw.m15010a(a, i));
        }
    }

    /* renamed from: a */
    public static Document m15017a(Document document) {
        XPath newXPath = XPathFactory.newInstance().newXPath();
        newXPath.setNamespaceContext(C1108zw.f8107d);
        NodeList nodeList = (NodeList) newXPath.compile("//*[name()='p']").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            m15021b(nodeList.item(i));
        }
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            Node item = nodeList.item(i2);
            m15019a(item, "begin");
            m15019a(item, "end");
        }
        return document;
    }

    /* renamed from: b */
    private static void m15021b(Node node) {
        long j = 0;
        Node node2 = node;
        while (true) {
            node2 = node2.getParentNode();
            if (node2 == null) {
                break;
            } else if (!(node2.getAttributes() == null || node2.getAttributes().getNamedItem("begin") == null)) {
                j += C1108zw.m15007a(node2.getAttributes().getNamedItem("begin").getNodeValue());
            }
        }
        if (!(node.getAttributes() == null || node.getAttributes().getNamedItem("begin") == null)) {
            node.getAttributes().getNamedItem("begin").setNodeValue(C1108zw.m15009a(C1108zw.m15007a(node.getAttributes().getNamedItem("begin").getNodeValue()) + j));
        }
        if (node.getAttributes() != null && node.getAttributes().getNamedItem("end") != null) {
            node.getAttributes().getNamedItem("end").setNodeValue(C1108zw.m15009a(j + C1108zw.m15007a(node.getAttributes().getNamedItem("end").getNodeValue())));
        }
    }

    /* renamed from: a */
    private static void m15019a(Node node, String str) {
        while (true) {
            node = node.getParentNode();
            if (node != null) {
                if (!(node.getAttributes() == null || node.getAttributes().getNamedItem(str) == null)) {
                    node.getAttributes().removeNamedItem(str);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m15018a(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 3) {
                item.setTextContent(item.getTextContent().trim());
            }
            m15018a(item);
        }
    }
}
