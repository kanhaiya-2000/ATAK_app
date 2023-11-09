package atakplugin.UASTool;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: atakplugin.UASTool.zw */
public class C1108zw {

    /* renamed from: a */
    static byte[] f8104a = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n    <xsl:output method=\"text\"/>\n    <xsl:key name=\"kElemByNSURI\"\n             match=\"*[namespace::*[not(. = ../../namespace::*)]]\"\n              use=\"namespace::*[not(. = ../../namespace::*)]\"/>\n    <xsl:template match=\"/\">\n        <xsl:for-each select=\n            \"//namespace::*[not(. = ../../namespace::*)]\n                           [count(..|key('kElemByNSURI',.)[1])=1]\">\n            <xsl:value-of select=\"concat(.,'&#xA;')\"/>\n        </xsl:for-each>\n    </xsl:template>\n</xsl:stylesheet>".getBytes();

    /* renamed from: b */
    public static final String f8105b = "http://www.smpte-ra.org/schemas/2052-1/2010/smpte-tt";

    /* renamed from: c */
    public static final String f8106c = "http://www.w3.org/ns/ttml";

    /* renamed from: d */
    public static final NamespaceContext f8107d = new C1109a((C1109a) null);

    /* renamed from: a */
    public static void m15013a(String[] strArr) {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        C1112zz zzVar = new C1112zz("a.xml", C1111zy.m15016a(newInstance.newDocumentBuilder().parse("C:\\dev\\mp4parser\\a.xml"), 60));
        C1022xf xfVar = new C1022xf();
        xfVar.mo6161a((C1026xj) zzVar);
        new C1030xn().mo6195a(xfVar).mo209b(new FileOutputStream("output.mp4").getChannel());
    }

    /* renamed from: a */
    public static String[] m15014a(Document document) {
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new ByteArrayInputStream(f8104a)));
            StringWriter stringWriter = new StringWriter();
            newTransformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            ArrayList arrayList = new ArrayList(new LinkedHashSet(Arrays.asList(stringWriter.getBuffer().toString().split("\n"))));
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static String m15009a(long j) {
        return m15010a(j, -1);
    }

    /* renamed from: a */
    public static String m15010a(long j, int i) {
        String str = j >= 0 ? "" : "-";
        long abs = Math.abs(j);
        long j2 = ((abs / 1000) / 60) / 60;
        long j3 = abs - (((j2 * 1000) * 60) * 60);
        long j4 = (j3 / 1000) / 60;
        long j5 = j3 - ((j4 * 1000) * 60);
        long j6 = j5 / 1000;
        long j7 = j5 - (1000 * j6);
        if (i >= 0) {
            return String.format("%s%02d:%02d:%02d:%d", new Object[]{str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j6), Integer.valueOf(i)});
        }
        return String.format("%s%02d:%02d:%02d.%03d", new Object[]{str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j7)});
    }

    /* renamed from: a */
    public static long m15007a(String str) {
        long j;
        Matcher matcher = Pattern.compile("(-?)([0-9][0-9]):([0-9][0-9]):([0-9][0-9])([\\.:][0-9][0-9]?[0-9]?)?").matcher(str);
        if (matcher.matches()) {
            int i = 1;
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            String group5 = matcher.group(5);
            if (group5 == null) {
                group5 = ".000";
            }
            String replace = group5.replace(":", ".");
            long parseLong = (Long.parseLong(group2) * 60 * 60 * 1000) + (Long.parseLong(group3) * 60 * 1000) + (Long.parseLong(group4) * 1000);
            if (replace.contains(":")) {
                j = (long) (((double) parseLong) + (Double.parseDouble("0" + replace.replace(":", ".")) * 40.0d * 1000.0d));
            } else {
                j = (long) (((double) parseLong) + (Double.parseDouble("0" + replace) * 1000.0d));
            }
            if ("-".equals(group)) {
                i = -1;
            }
            return j * ((long) i);
        }
        throw new RuntimeException("Cannot match '" + str + "' to time expression");
    }

    /* renamed from: atakplugin.UASTool.zw$a */
    private static class C1109a implements NamespaceContext {
        private C1109a() {
        }

        /* synthetic */ C1109a(C1109a aVar) {
            this();
        }

        public String getNamespaceURI(String str) {
            if (str.equals("ttml")) {
                return C1108zw.f8106c;
            }
            if (str.equals("smpte")) {
                return C1108zw.f8105b;
            }
            return null;
        }

        public Iterator getPrefixes(String str) {
            return Arrays.asList(new String[]{"ttml", "smpte"}).iterator();
        }

        public String getPrefix(String str) {
            if (str.equals(C1108zw.f8106c)) {
                return "ttml";
            }
            if (str.equals(C1108zw.f8105b)) {
                return "smpte";
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m15012a(Document document, OutputStream outputStream, int i) {
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("encoding", "UTF-8");
            if (i > 0) {
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
            }
            try {
                newTransformer.transform(new DOMSource(document), new StreamResult(outputStream));
            } catch (TransformerException e) {
                throw new IOException(e);
            }
        } catch (TransformerConfigurationException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static long m15008a(Node node) {
        long j = 0;
        Node node2 = node;
        while (true) {
            node2 = node2.getParentNode();
            if (node2 == null) {
                break;
            } else if (!(node2.getAttributes() == null || node2.getAttributes().getNamedItem("begin") == null)) {
                j += m15007a(node2.getAttributes().getNamedItem("begin").getNodeValue());
            }
        }
        return (node.getAttributes() == null || node.getAttributes().getNamedItem("begin") == null) ? j : j + m15007a(node.getAttributes().getNamedItem("begin").getNodeValue());
    }

    /* renamed from: b */
    public static long m15015b(Node node) {
        long j = 0;
        Node node2 = node;
        while (true) {
            node2 = node2.getParentNode();
            if (node2 == null) {
                break;
            } else if (!(node2.getAttributes() == null || node2.getAttributes().getNamedItem("begin") == null)) {
                j += m15007a(node2.getAttributes().getNamedItem("begin").getNodeValue());
            }
        }
        return (node.getAttributes() == null || node.getAttributes().getNamedItem("end") == null) ? j : j + m15007a(node.getAttributes().getNamedItem("end").getNodeValue());
    }

    /* renamed from: a */
    public static void m15011a(Document document, File file) {
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@backgroundImage").evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                URI create = URI.create(nodeList.item(i).getNodeValue());
                if (!create.isAbsolute()) {
                    m15006a(new URI(document.getDocumentURI()).resolve(create).toURL().openStream(), new File(file.toURI().resolve(create).toURL().getFile()));
                }
            }
            m15006a(new URI(document.getDocumentURI()).toURL().openStream(), file);
        } catch (XPathExpressionException e) {
            throw new IOException(e);
        } catch (URISyntaxException e2) {
            throw new IOException(e2);
        }
    }

    /* renamed from: a */
    private static long m15006a(InputStream inputStream, File file) {
        byte[] bArr = new byte[16384];
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return j;
                }
                fileOutputStream.write(bArr, 0, read);
                j += (long) read;
            } finally {
                fileOutputStream.close();
            }
        }
    }
}
