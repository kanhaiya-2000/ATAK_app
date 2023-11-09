package atakplugin.UASTool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0002\b\n\u0006\b\u0011(\u001e0\u0001¨\u0006 "}, mo1538e = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class bcp {
    /* renamed from: a */
    private static final BufferedReader m6362a(Reader reader, int i) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    /* renamed from: a */
    private static final BufferedWriter m6364a(Writer writer, int i) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    /* renamed from: a */
    public static final List<String> m6369a(Reader reader) {
        bfq.m6567f(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        m6370a(reader, (bdl<? super String, aqr>) new bcq(arrayList));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        atakplugin.UASTool.bfn.m6527b(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (atakplugin.UASTool.bbg.m6171a(1, 1, 0) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        atakplugin.UASTool.bbp.m6218a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        atakplugin.UASTool.bfn.m6528c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        throw r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m6372b(java.io.Reader r4, atakplugin.UASTool.bdl<? super atakplugin.UASTool.bku<java.lang.String>, ? extends T> r5) {
        /*
            java.lang.String r0 = "$this$useLines"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            java.lang.String r0 = "block"
            atakplugin.UASTool.bfq.m6567f(r5, r0)
            boolean r0 = r4 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r1)
            r4 = r0
        L_0x0019:
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = 0
            r2 = 1
            r3 = r4
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x003f }
            atakplugin.UASTool.bku r3 = m6361a((java.io.BufferedReader) r3)     // Catch:{ all -> 0x003f }
            java.lang.Object r5 = r5.invoke(r3)     // Catch:{ all -> 0x003f }
            atakplugin.UASTool.bfn.m6527b(r2)
            boolean r1 = atakplugin.UASTool.bbg.m6171a(r2, r2, r1)
            if (r1 == 0) goto L_0x0038
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r4, (java.lang.Throwable) r0)
            goto L_0x003b
        L_0x0038:
            r4.close()
        L_0x003b:
            atakplugin.UASTool.bfn.m6528c(r2)
            return r5
        L_0x003f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r0 = move-exception
            atakplugin.UASTool.bfn.m6527b(r2)
            boolean r1 = atakplugin.UASTool.bbg.m6171a(r2, r2, r1)
            if (r1 != 0) goto L_0x004f
            r4.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0052
        L_0x004f:
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r4, (java.lang.Throwable) r5)
        L_0x0052:
            atakplugin.UASTool.bfn.m6528c(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcp.m6372b(java.io.Reader, atakplugin.UASTool.bdl):java.lang.Object");
    }

    /* renamed from: a */
    private static final StringReader m6366a(String str) {
        return new StringReader(str);
    }

    /* renamed from: a */
    public static final bku<String> m6361a(BufferedReader bufferedReader) {
        bfq.m6567f(bufferedReader, "$this$lineSequence");
        return bkx.m7472d(new bcj(bufferedReader));
    }

    /* renamed from: b */
    public static final String m6373b(Reader reader) {
        bfq.m6567f(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        m6360a(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        bfq.m6554b(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    /* renamed from: a */
    public static /* synthetic */ long m6360a(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m6359a(reader, writer, i);
    }

    /* renamed from: a */
    public static final long m6359a(Reader reader, Writer writer, int i) {
        bfq.m6567f(reader, "$this$copyTo");
        bfq.m6567f(writer, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }

    /* renamed from: a */
    private static final String m6367a(URL url, Charset charset) {
        return new String(m6371a(url), charset);
    }

    /* renamed from: a */
    static /* synthetic */ String m6368a(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        return new String(m6371a(url), charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        atakplugin.UASTool.bbp.m6218a(r3, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] m6371a(java.net.URL r3) {
        /*
            java.lang.String r0 = "$this$readBytes"
            atakplugin.UASTool.bfq.m6567f(r3, r0)
            java.io.InputStream r3 = r3.openStream()
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r3
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "it"
            atakplugin.UASTool.bfq.m6554b(r1, r2)     // Catch:{ all -> 0x001e }
            byte[] r1 = atakplugin.UASTool.C0138bbn.m6201a((java.io.InputStream) r1)     // Catch:{ all -> 0x001e }
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r3, (java.lang.Throwable) r0)
            return r1
        L_0x001e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r3, (java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcp.m6371a(java.net.URL):byte[]");
    }

    /* renamed from: a */
    static /* synthetic */ BufferedReader m6363a(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    /* renamed from: a */
    static /* synthetic */ BufferedWriter m6365a(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        atakplugin.UASTool.bbp.m6218a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        throw r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6370a(java.io.Reader r3, atakplugin.UASTool.bdl<? super java.lang.String, atakplugin.UASTool.aqr> r4) {
        /*
            java.lang.String r0 = "$this$forEachLine"
            atakplugin.UASTool.bfq.m6567f(r3, r0)
            java.lang.String r0 = "action"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            boolean r0 = r3 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r1)
            r3 = r0
        L_0x0019:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r3
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x003d }
            atakplugin.UASTool.bku r1 = m6361a((java.io.BufferedReader) r1)     // Catch:{ all -> 0x003d }
            java.util.Iterator r1 = r1.mo1859a()     // Catch:{ all -> 0x003d }
        L_0x0029:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003d }
            r4.invoke(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0029
        L_0x0037:
            atakplugin.UASTool.aqr r4 = atakplugin.UASTool.aqr.f2177a     // Catch:{ all -> 0x003d }
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r3, (java.lang.Throwable) r0)
            return
        L_0x003d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003f }
        L_0x003f:
            r0 = move-exception
            atakplugin.UASTool.bbp.m6218a((java.io.Closeable) r3, (java.lang.Throwable) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bcp.m6370a(java.io.Reader, atakplugin.UASTool.bdl):void");
    }
}
