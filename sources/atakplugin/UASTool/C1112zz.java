package atakplugin.UASTool;

import atakplugin.UASTool.C0746pq;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: atakplugin.UASTool.zz */
public class C1112zz extends C1018xc {

    /* renamed from: d */
    C1027xk f8108d = new C1027xk();

    /* renamed from: e */
    C0737pi f8109e = new C0737pi();

    /* renamed from: f */
    aln f8110f = new aln();

    /* renamed from: g */
    List<C1024xh> f8111g = new ArrayList();

    /* renamed from: h */
    C0746pq f8112h = new C0746pq();

    /* renamed from: i */
    private long[] f8113i;

    public void close() {
    }

    /* renamed from: p */
    public String mo15p() {
        return "subt";
    }

    /* renamed from: a */
    public static String m15022a(Document document) {
        return document.getDocumentElement().getAttribute("xml:lang");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo6351b(Document document) {
        XPath newXPath = XPathFactory.newInstance().newXPath();
        newXPath.setNamespaceContext(C1108zw.f8107d);
        try {
            NodeList nodeList = (NodeList) newXPath.compile("//*[@begin]").evaluate(document, XPathConstants.NODESET);
            long j = bfu.f2629b;
            for (int i = 0; i < nodeList.getLength(); i++) {
                j = Math.min(C1108zw.m15008a(nodeList.item(i)), j);
            }
            return j;
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo6352c(Document document) {
        XPath newXPath = XPathFactory.newInstance().newXPath();
        newXPath.setNamespaceContext(C1108zw.f8107d);
        try {
            NodeList nodeList = (NodeList) newXPath.compile("//*[@end]").evaluate(document, XPathConstants.NODESET);
            long j = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                j = Math.max(C1108zw.m15015b(nodeList.item(i)), j);
            }
            return j;
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6350a(List<Document> list) {
        String str = null;
        for (Document a : list) {
            String a2 = m15022a(a);
            if (str == null) {
                this.f8108d.mo6176a(Locale.forLanguageTag(a2).getISO3Language());
                str = a2;
            } else if (!str.equals(a2)) {
                throw new RuntimeException("Within one Track all sample documents need to have the same language");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public List<String> mo6354d(Document document) {
        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@smpte:backgroundImage").evaluate(document, XPathConstants.NODESET);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < nodeList.getLength(); i++) {
            String nodeValue = nodeList.item(i).getNodeValue();
            String substring = nodeValue.substring(nodeValue.lastIndexOf("."));
            if (substring.contains("jpg") || substring.contains("jpeg")) {
                linkedHashSet.add("image/jpeg");
            } else if (substring.contains("png")) {
                linkedHashSet.add("image/png");
            }
        }
        return new ArrayList(linkedHashSet);
    }

    /* renamed from: e */
    protected static List<byte[]> m15024e(Document document) {
        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@backgroundImage").evaluate(document, XPathConstants.NODESET);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 1;
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            Node item = nodeList.item(i2);
            String nodeValue = item.getNodeValue();
            String substring = nodeValue.substring(nodeValue.lastIndexOf("."));
            String str = (String) linkedHashMap.get(nodeValue);
            if (str == null) {
                str = "urn:mp4parser:" + i + substring;
                linkedHashMap.put(str, nodeValue);
                i++;
            }
            item.setNodeValue(str);
        }
        ArrayList arrayList = new ArrayList();
        if (!linkedHashMap.isEmpty()) {
            for (Map.Entry value : linkedHashMap.entrySet()) {
                arrayList.add(m15023a(new URI(document.getDocumentURI()).resolve((String) value.getValue()).toURL().openStream()));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public long mo6355f(Document document) {
        return mo6352c(document) - mo6351b(document);
    }

    public C1112zz(String str, List<Document> list) {
        super(str);
        mo6350a(list);
        HashSet hashSet = new HashSet();
        this.f8113i = new long[list.size()];
        XPathFactory.newInstance().newXPath().setNamespaceContext(C1108zw.f8107d);
        for (int i = 0; i < list.size(); i++) {
            Document document = list.get(i);
            C0746pq.C0747a aVar = new C0746pq.C0747a();
            this.f8112h.mo36c().add(aVar);
            aVar.mo5351a(1);
            this.f8113i[i] = mo6355f(document);
            List<byte[]> e = m15024e(document);
            hashSet.addAll(mo6354d(document));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C1108zw.m15012a(document, byteArrayOutputStream, 4);
            C0746pq.C0747a.C0748a aVar2 = new C0746pq.C0747a.C0748a();
            aVar2.mo5357a((long) byteArrayOutputStream.size());
            aVar.mo5353c().add(aVar2);
            for (byte[] next : e) {
                byteArrayOutputStream.write(next);
                C0746pq.C0747a.C0748a aVar3 = new C0746pq.C0747a.C0748a();
                aVar3.mo5357a((long) next.length);
                aVar.mo5353c().add(aVar3);
            }
            this.f8111g.add(new aaa(this, byteArrayOutputStream.toByteArray()));
        }
        this.f8110f.mo1395a(zz$$ExternalSynthetic0.m15036m0(",", C1108zw.m15014a(list.get(0))));
        this.f8110f.mo1397b("");
        this.f8110f.mo1398c(zz$$ExternalSynthetic0.m15036m0(",", (CharSequence[]) new ArrayList(hashSet).toArray(new String[hashSet.size()])));
        this.f8109e.mo170a((C0688nt) this.f8110f);
        this.f8108d.mo6174a(30000);
        this.f8108d.mo6173a(65535);
    }

    /* renamed from: a */
    private static byte[] m15023a(InputStream inputStream) {
        byte[] bArr = new byte[8096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f8109e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        int length = this.f8113i.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = (this.f8113i[i] * this.f8108d.mo6178b()) / 1000;
        }
        return jArr;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f8108d;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f8111g;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f8112h;
    }
}
