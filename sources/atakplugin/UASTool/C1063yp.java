package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.alo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.SecretKey;

/* renamed from: atakplugin.UASTool.yp */
public class C1063yp implements C1062yo {

    /* renamed from: a */
    C1026xj f7718a;

    /* renamed from: b */
    Map<UUID, SecretKey> f7719b;

    /* renamed from: c */
    UUID f7720c;

    /* renamed from: d */
    List<C1024xh> f7721d;

    /* renamed from: e */
    List<alo> f7722e;

    /* renamed from: f */
    boolean f7723f;

    /* renamed from: g */
    boolean f7724g;

    /* renamed from: h */
    C0737pi f7725h;

    /* renamed from: i */
    afu<Integer, SecretKey> f7726i;

    /* renamed from: j */
    Map<adx, long[]> f7727j;

    /* renamed from: k */
    Object f7728k;

    /* renamed from: l */
    private final String f7729l;

    public C1063yp(C1026xj xjVar, UUID uuid, SecretKey secretKey, boolean z) {
        this(xjVar, uuid, Collections.singletonMap(uuid, secretKey), (Map<adw, long[]>) null, "cenc", z);
    }

    public C1063yp(C1026xj xjVar, UUID uuid, Map<UUID, SecretKey> map, Map<adw, long[]> map2, String str, boolean z) {
        this(xjVar, uuid, map, map2, str, z, false);
    }

    public C1063yp(C1026xj xjVar, UUID uuid, Map<UUID, SecretKey> map, Map<adw, long[]> map2, String str, boolean z, boolean z2) {
        UUID uuid2 = uuid;
        Map<UUID, SecretKey> map3 = map;
        boolean z3 = z;
        this.f7719b = new HashMap();
        char c = 0;
        this.f7723f = false;
        this.f7724g = false;
        Object obj = null;
        this.f7725h = null;
        this.f7718a = xjVar;
        this.f7719b = map3;
        this.f7720c = uuid2;
        this.f7723f = z3;
        this.f7729l = str;
        this.f7727j = new HashMap();
        for (Map.Entry next : xjVar.mo6146h().entrySet()) {
            if (!(next.getKey() instanceof adw)) {
                this.f7727j.put((adx) next.getKey(), (long[]) next.getValue());
            }
            c = 0;
            obj = null;
        }
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                this.f7727j.put((adx) next2.getKey(), (long[]) next2.getValue());
            }
        }
        this.f7727j = new C1064yq(this, this.f7727j);
        this.f7721d = xjVar.mo11l();
        this.f7722e = new ArrayList();
        BigInteger bigInteger = new BigInteger("1");
        int i = 8;
        byte[] bArr = new byte[8];
        if (!z3) {
            new SecureRandom().nextBytes(bArr);
        }
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        ArrayList arrayList = new ArrayList();
        if (map2 != null) {
            arrayList.addAll(map2.keySet());
        }
        this.f7726i = new afu<>();
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        while (i3 < xjVar.mo11l().size()) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < arrayList.size()) {
                BigInteger bigInteger3 = bigInteger2;
                if (Arrays.binarySearch(mo6146h().get((adx) arrayList.get(i5)), (long) i3) >= 0) {
                    i6 = i5 + 1;
                }
                i5++;
                bigInteger2 = bigInteger3;
                obj = null;
                i = 8;
            }
            if (i4 != i6) {
                if (i6 == 0) {
                    this.f7726i.put(Integer.valueOf(i3), map3.get(uuid2));
                } else {
                    int i7 = i6 - 1;
                    if (((adw) arrayList.get(i7)).mo385e() != null) {
                        SecretKey secretKey = map3.get(((adw) arrayList.get(i7)).mo385e());
                        if (secretKey != null) {
                            this.f7726i.put(Integer.valueOf(i3), secretKey);
                        } else {
                            throw new RuntimeException("Key " + ((adw) arrayList.get(i7)).mo385e() + " was not supplied for decryption");
                        }
                    } else {
                        this.f7726i.put(Integer.valueOf(i3), obj);
                    }
                }
                i4 = i6;
            }
            i3++;
            c = 0;
        }
        for (C0688nt next3 : xjVar.mo13n().mo5316d().mo36c()) {
            if (next3 instanceof akz) {
                this.f7728k = next3;
                this.f7724g = true;
                i2 = ((akz) next3).mo1223j() + 1;
            }
            if (next3 instanceof alb) {
                this.f7728k = next3;
                this.f7724g = true;
                i2 = ((alb) next3).mo1262u() + 1;
            }
        }
        for (int i8 = 0; i8 < this.f7721d.size(); i8++) {
            C1024xh xhVar = this.f7721d.get(i8);
            alo alo = new alo();
            this.f7722e.add(alo);
            if (this.f7726i.get(Integer.valueOf(i8)) != null) {
                byte[] byteArray = bigInteger2.toByteArray();
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, byteArray.length - i > 0 ? byteArray.length - i : 0, bArr2, 8 - byteArray.length < 0 ? 0 : 8 - byteArray.length, byteArray.length > i ? 8 : byteArray.length);
                alo.f1972a = bArr2;
                ByteBuffer byteBuffer = (ByteBuffer) xhVar.mo9b().rewind();
                if (this.f7724g) {
                    if (z2) {
                        alo.C0065j[] jVarArr = new alo.C0065j[1];
                        jVarArr[c] = alo.mo1402a(byteBuffer.remaining(), 0);
                        alo.f1973b = jVarArr;
                    } else {
                        ArrayList arrayList2 = new ArrayList(5);
                        while (byteBuffer.remaining() > 0) {
                            int a = afi.m847a(C0680nl.m12508a(byteBuffer, i2));
                            int i9 = a + i2;
                            int i10 = (i9 < 112 || mo6287a(byteBuffer.duplicate())) ? i9 : (i9 % 16) + 96;
                            arrayList2.add(alo.mo1402a(i10, (long) (i9 - i10)));
                            byteBuffer.position(byteBuffer.position() + a);
                        }
                        alo.f1973b = (alo.C0065j[]) arrayList2.toArray(new alo.C0065j[arrayList2.size()]);
                    }
                }
                bigInteger2 = bigInteger2.add(bigInteger);
            }
        }
    }

    /* renamed from: i */
    public UUID mo6147i() {
        return this.f7720c;
    }

    /* renamed from: j */
    public boolean mo6148j() {
        return this.f7724g;
    }

    /* renamed from: k */
    public List<alo> mo6149k() {
        return this.f7722e;
    }

    /* renamed from: n */
    public synchronized C0737pi mo13n() {
        if (this.f7725h == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                this.f7718a.mo13n().mo18a(Channels.newChannel(byteArrayOutputStream));
                int i = 0;
                this.f7725h = (C0737pi) new C0678nj((C1007ws) new C1011ww(byteArrayOutputStream.toByteArray())).mo36c().get(0);
                C0728pb pbVar = new C0728pb();
                pbVar.mo5281a(this.f7725h.mo5316d().mo1476h());
                if (this.f7725h.mo5316d() instanceof C0793rd) {
                    ((C0793rd) this.f7725h.mo5316d()).mo5574a(C0793rd.f6044n);
                } else if (this.f7725h.mo5316d() instanceof C0801rj) {
                    ((C0801rj) this.f7725h.mo5316d()).mo5636a(C0801rj.f6089i);
                } else {
                    throw new RuntimeException("I don't know how to cenc " + this.f7725h.mo5316d().mo1476h());
                }
                C0732pe peVar = new C0732pe();
                peVar.mo170a((C0688nt) pbVar);
                C0743pn pnVar = new C0743pn();
                pnVar.mo5342a(this.f7729l);
                pnVar.mo5344c(65536);
                peVar.mo170a((C0688nt) pnVar);
                C0742pm pmVar = new C0742pm();
                alr alr = new alr();
                alr.mo57d(this.f7720c == null ? 0 : 8);
                if (this.f7720c != null) {
                    i = 1;
                }
                alr.mo56c(i);
                UUID uuid = this.f7720c;
                if (uuid == null) {
                    uuid = new UUID(0, 0);
                }
                alr.mo55a(uuid);
                pmVar.mo170a((C0688nt) alr);
                peVar.mo170a((C0688nt) pmVar);
                this.f7725h.mo5316d().mo170a((C0688nt) peVar);
            } catch (IOException unused) {
                throw new RuntimeException("Dumping stsd to memory failed");
            }
        }
        return this.f7725h;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7718a.mo12m();
    }

    /* renamed from: e */
    public long mo6143e() {
        return this.f7718a.mo6143e();
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return this.f7718a.mo6139a();
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f7718a.mo6140b();
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7718a.mo6141c();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7718a.mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7718a.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return new acv(this.f7726i, this.f7718a.mo11l(), this.f7722e, this.f7729l);
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7718a.mo6142d();
    }

    public void close() {
        this.f7718a.close();
    }

    /* renamed from: f */
    public String mo6144f() {
        return "enc(" + this.f7718a.mo6144f() + ")";
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return this.f7718a.mo6145g();
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7727j;
    }

    /* renamed from: a */
    public boolean mo6287a(ByteBuffer byteBuffer) {
        Object obj = this.f7728k;
        if (obj instanceof alb) {
            C1094zl b = C1096zn.m14966b(byteBuffer.slice());
            if (b.f7980b >= 0 && b.f7980b <= 9) {
                return false;
            }
            if (b.f7980b >= 16 && b.f7980b <= 21) {
                return false;
            }
            if (b.f7980b < 16 || b.f7980b > 21) {
                return true;
            }
            return false;
        } else if (obj instanceof akz) {
            C1086zg b2 = C1088zi.m14949b(byteBuffer.slice());
            if (b2.f7866b == 19 || b2.f7866b == 2 || b2.f7866b == 3 || b2.f7866b == 4 || b2.f7866b == 20 || b2.f7866b == 5 || b2.f7866b == 1) {
                return false;
            }
            return true;
        } else {
            throw new RuntimeException("Subsample encryption is activated but the CencEncryptingTrackImpl can't say if this sample is to be encrypted or not!");
        }
    }
}
