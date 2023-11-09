package atakplugin.UASTool;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aab extends C1018xc {

    /* renamed from: i */
    private static final String f2i = "^﻿?WEBVTT((\\u0020|\t).*)?$";

    /* renamed from: j */
    private static final Pattern f3j = Pattern.compile(f2i);

    /* renamed from: k */
    private static final String f4k = "\\S*[:=]\\S*";

    /* renamed from: l */
    private static final Pattern f5l = Pattern.compile(f4k);

    /* renamed from: m */
    private static final String f6m = "^(?!.*(-->)).*$";

    /* renamed from: n */
    private static final Pattern f7n = Pattern.compile(f6m);

    /* renamed from: o */
    private static final String f8o = "(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}";

    /* renamed from: p */
    private static final Pattern f9p = Pattern.compile(f8o);

    /* renamed from: q */
    private static final String f10q = "\\S*:\\S*";

    /* renamed from: r */
    private static final Pattern f11r = Pattern.compile(f10q);

    /* renamed from: s */
    private static final C1024xh f12s = new aac();

    /* renamed from: d */
    C1027xk f13d = new C1027xk();

    /* renamed from: e */
    C0737pi f14e;

    /* renamed from: f */
    List<C1024xh> f15f = new ArrayList();

    /* renamed from: g */
    long[] f16g = new long[0];

    /* renamed from: h */
    all f17h;

    public void close() {
    }

    /* renamed from: p */
    public String mo15p() {
        return "text";
    }

    /* renamed from: atakplugin.UASTool.aab$a */
    private static class C0002a implements C1024xh {

        /* renamed from: a */
        List<C0688nt> f18a;

        public C0002a(List<C0688nt> list) {
            this.f18a = list;
        }

        /* renamed from: a */
        public void mo8a(WritableByteChannel writableByteChannel) {
            for (C0688nt a : this.f18a) {
                a.mo18a(writableByteChannel);
            }
        }

        /* renamed from: a */
        public long mo7a() {
            long j = 0;
            for (C0688nt f : this.f18a) {
                j += f.mo19f();
            }
            return j;
        }

        /* renamed from: b */
        public ByteBuffer mo9b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                mo8a(Channels.newChannel(byteArrayOutputStream));
                return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public aab(InputStream inputStream, String str, Locale locale) {
        super(str);
        this.f13d.mo6174a(1000);
        this.f13d.mo6176a(locale.getISO3Language());
        this.f14e = new C0737pi();
        all all = new all();
        this.f17h = all;
        this.f14e.mo170a((C0688nt) all);
        alk alk = new alk();
        this.f17h.mo170a((C0688nt) alk);
        this.f17h.mo170a((C0688nt) new alm());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String readLine = bufferedReader.readLine();
        if (readLine == null || !f3j.matcher(readLine).matches()) {
            throw new IOException("Expected WEBVTT. Got " + readLine);
        }
        alk.mo1390a(String.valueOf(alk.mo1389a()) + "\n" + readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                throw new IOException("Expected an empty line after webvtt header");
            } else if (readLine2.isEmpty()) {
                long j = 0;
                while (true) {
                    String readLine3 = bufferedReader.readLine();
                    if (readLine3 != null) {
                        if (!"".equals(readLine3.trim())) {
                            readLine3 = f7n.matcher(readLine3).find() ? bufferedReader.readLine() : readLine3;
                            Matcher matcher = f9p.matcher(readLine3);
                            if (matcher.find()) {
                                long a = m7a(matcher.group());
                                if (matcher.find()) {
                                    String group = matcher.group();
                                    long a2 = m7a(group);
                                    Matcher matcher2 = f11r.matcher(readLine3.substring(readLine3.indexOf(group) + group.length()));
                                    String str2 = null;
                                    while (matcher2.find()) {
                                        str2 = matcher2.group();
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        String readLine4 = bufferedReader.readLine();
                                        if (readLine4 != null && !readLine4.isEmpty()) {
                                            if (sb.length() > 0) {
                                                sb.append("\n");
                                            }
                                            sb.append(readLine4.trim());
                                        }
                                    }
                                    if (a != j) {
                                        this.f16g = afs.m880a(this.f16g, a - j);
                                        this.f15f.add(f12s);
                                    }
                                    this.f16g = afs.m880a(this.f16g, a2 - a);
                                    aak aak = new aak();
                                    if (str2 != null) {
                                        aag aag = new aag();
                                        aag.mo17a(str2);
                                        aak.mo23a(aag);
                                    }
                                    aaf aaf = new aaf();
                                    aaf.mo17a(sb.toString());
                                    aak.mo22a(aaf);
                                    this.f15f.add(new C0002a(Collections.singletonList(aak)));
                                    j = a2;
                                } else {
                                    throw new IOException("Expected cue end time: " + readLine3);
                                }
                            } else {
                                throw new IOException("Expected cue start time: " + readLine3);
                            }
                        }
                    } else {
                        return;
                    }
                }
            } else if (f5l.matcher(readLine2).find()) {
                alk.mo1390a(String.valueOf(alk.mo1389a()) + "\n" + readLine2);
            } else {
                throw new IOException("Expected WebVTT metadata header. Got " + readLine2);
            }
        }
    }

    /* renamed from: a */
    private static long m7a(String str) {
        if (str.matches(f8o)) {
            String[] split = str.split("\\.", 2);
            long j = 0;
            for (String parseLong : split[0].split(":")) {
                j = (j * 60) + Long.parseLong(parseLong);
            }
            return (j * 1000) + Long.parseLong(split[1]);
        }
        throw new NumberFormatException("has invalid format");
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f14e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        int length = this.f16g.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = (this.f16g[i] * this.f13d.mo6178b()) / 1000;
        }
        return jArr;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f13d;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f15f;
    }
}
