package atakplugin.UASTool;

import atakplugin.UASTool.C1084zf;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class aff {
    /* renamed from: a */
    public static C1084zf m843a(InputStream inputStream) {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, "UTF-8"));
        C1084zf zfVar = new C1084zf();
        while (lineNumberReader.readLine() != null) {
            String readLine = lineNumberReader.readLine();
            String str = "";
            while (true) {
                String readLine2 = lineNumberReader.readLine();
                if (readLine2 == null || readLine2.trim().equals("")) {
                    zfVar.mo6316i().add(new C1084zf.C1085a(m842a(readLine.split("-->")[0]), m842a(readLine.split("-->")[1]), str));
                } else {
                    str = String.valueOf(str) + readLine2 + "\n";
                }
            }
            zfVar.mo6316i().add(new C1084zf.C1085a(m842a(readLine.split("-->")[0]), m842a(readLine.split("-->")[1]), str));
        }
        return zfVar;
    }

    /* renamed from: a */
    private static long m842a(String str) {
        return (Long.parseLong(str.split(":")[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(str.split(":")[1].trim()) * 60 * 1000) + (Long.parseLong(str.split(":")[2].split(",")[0].trim()) * 1000) + Long.parseLong(str.split(":")[2].split(",")[1].trim());
    }
}
