package atakplugin.UASTool;

import atakplugin.UASTool.agp;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.Vector;

public class ahw implements agp {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Hashtable f1369e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Hashtable f1370c = new Hashtable();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Vector f1371d = new Vector();

    /* renamed from: b */
    public static ahw m1549b(String str) {
        StringReader stringReader = new StringReader(str);
        try {
            return new ahw(stringReader);
        } finally {
            stringReader.close();
        }
    }

    /* renamed from: c */
    public static ahw m1551c(String str) {
        FileReader fileReader = new FileReader(aji.m1821d(str));
        try {
            return new ahw(fileReader);
        } finally {
            fileReader.close();
        }
    }

    ahw(Reader reader) {
        m1548a(reader);
    }

    /* renamed from: a */
    private void m1548a(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        Vector vector = new Vector();
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (trim.length() != 0 && !trim.startsWith("#")) {
                    String[] split = trim.split("[= \t]", 2);
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    if (split.length > 1) {
                        if (split[0].equals(HttpHeaders.HOST)) {
                            this.f1370c.put(str, vector);
                            this.f1371d.addElement(str);
                            String str2 = split[1];
                            str = str2;
                            vector = new Vector();
                        } else {
                            vector.addElement(split);
                        }
                    }
                }
            } else {
                this.f1370c.put(str, vector);
                this.f1371d.addElement(str);
                return;
            }
        }
    }

    /* renamed from: a */
    public agp.C0041a mo811a(String str) {
        return new C0047a(str);
    }

    static {
        Hashtable hashtable = new Hashtable();
        f1369e = hashtable;
        hashtable.put("kex", "KexAlgorithms");
        hashtable.put("server_host_key", "HostKeyAlgorithms");
        hashtable.put("cipher.c2s", "Ciphers");
        hashtable.put("cipher.s2c", "Ciphers");
        hashtable.put("mac.c2s", "Macs");
        hashtable.put("mac.s2c", "Macs");
        hashtable.put("compression.s2c", "Compression");
        hashtable.put("compression.c2s", "Compression");
        hashtable.put("compression_level", "CompressionLevel");
        hashtable.put("MaxAuthTries", "NumberOfPasswordPrompts");
    }

    /* renamed from: atakplugin.UASTool.ahw$a */
    class C0047a implements agp.C0041a {

        /* renamed from: b */
        private String f1373b;

        /* renamed from: c */
        private Vector f1374c;

        C0047a(String str) {
            boolean z;
            Vector vector = new Vector();
            this.f1374c = vector;
            this.f1373b = str;
            vector.addElement(ahw.this.f1370c.get(""));
            byte[] c = aji.m1820c(str);
            if (ahw.this.f1371d.size() > 1) {
                for (int i = 1; i < ahw.this.f1371d.size(); i++) {
                    String[] split = ((String) ahw.this.f1371d.elementAt(i)).split("[ \t]");
                    for (String trim : split) {
                        String trim2 = trim.trim();
                        if (trim2.startsWith("!")) {
                            trim2 = trim2.substring(1).trim();
                            z = true;
                        } else {
                            z = false;
                        }
                        if (aji.m1807a(aji.m1820c(trim2), c)) {
                            if (!z) {
                                this.f1374c.addElement(ahw.this.f1370c.get((String) ahw.this.f1371d.elementAt(i)));
                            }
                        } else if (z) {
                            this.f1374c.addElement(ahw.this.f1370c.get((String) ahw.this.f1371d.elementAt(i)));
                        }
                    }
                }
            }
        }

        /* renamed from: c */
        private String m1553c(String str) {
            if (ahw.f1369e.get(str) != null) {
                str = (String) ahw.f1369e.get(str);
            }
            String str2 = null;
            for (int i = 0; i < this.f1374c.size(); i++) {
                Vector vector = (Vector) this.f1374c.elementAt(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= vector.size()) {
                        break;
                    }
                    String[] strArr = (String[]) vector.elementAt(i2);
                    if (strArr[0].equals(str)) {
                        str2 = strArr[1];
                        break;
                    }
                    i2++;
                }
                if (str2 != null) {
                    break;
                }
            }
            return str2;
        }

        /* renamed from: d */
        private String[] m1554d(String str) {
            String str2;
            Vector vector = new Vector();
            for (int i = 0; i < this.f1374c.size(); i++) {
                Vector vector2 = (Vector) this.f1374c.elementAt(i);
                for (int i2 = 0; i2 < vector2.size(); i2++) {
                    String[] strArr = (String[]) vector2.elementAt(i2);
                    if (strArr[0].equals(str) && (str2 = strArr[1]) != null) {
                        vector.remove(str2);
                        vector.addElement(str2);
                    }
                }
            }
            String[] strArr2 = new String[vector.size()];
            vector.toArray(strArr2);
            return strArr2;
        }

        /* renamed from: a */
        public String mo812a() {
            return m1553c("Hostname");
        }

        /* renamed from: b */
        public String mo814b() {
            return m1553c("User");
        }

        /* renamed from: c */
        public int mo816c() {
            try {
                return Integer.parseInt(m1553c("Port"));
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        /* renamed from: a */
        public String mo813a(String str) {
            if (!str.equals("compression.s2c") && !str.equals("compression.c2s")) {
                return m1553c(str);
            }
            String c = m1553c(str);
            return (c == null || c.equals("no")) ? "none,zlib@openssh.com,zlib" : "zlib@openssh.com,zlib,none";
        }

        /* renamed from: b */
        public String[] mo815b(String str) {
            return m1554d(str);
        }
    }
}
