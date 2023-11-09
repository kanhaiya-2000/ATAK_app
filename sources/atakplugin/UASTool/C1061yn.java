package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.SecretKey;

/* renamed from: atakplugin.UASTool.yn */
public class C1061yn extends C1018xc {

    /* renamed from: d */
    acu f7715d;

    /* renamed from: e */
    C1026xj f7716e;

    /* renamed from: f */
    afu<Integer, SecretKey> f7717f;

    public C1061yn(C1062yo yoVar, SecretKey secretKey) {
        this(yoVar, (Map<UUID, SecretKey>) Collections.singletonMap(yoVar.mo6147i(), secretKey));
    }

    public C1061yn(C1062yo yoVar, Map<UUID, SecretKey> map) {
        super("dec(" + yoVar.mo6144f() + ")");
        this.f7717f = new afu<>();
        this.f7716e = yoVar;
        C0743pn pnVar = (C0743pn) aft.m883a((C1003wo) yoVar.mo13n(), "enc./sinf/schm");
        if ("cenc".equals(pnVar.mo36c()) || "cbc1".equals(pnVar.mo36c())) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : yoVar.mo6146h().entrySet()) {
                if (next.getKey() instanceof adw) {
                    arrayList.add((adw) next.getKey());
                } else {
                    mo6146h().put((adx) next.getKey(), (long[]) next.getValue());
                }
            }
            int i = -1;
            for (int i2 = 0; i2 < yoVar.mo11l().size(); i2++) {
                int i3 = 0;
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (Arrays.binarySearch(yoVar.mo6146h().get((adx) arrayList.get(i4)), (long) i2) >= 0) {
                        i3 = i4 + 1;
                    }
                }
                if (i != i3) {
                    if (i3 == 0) {
                        this.f7717f.put(Integer.valueOf(i2), map.get(yoVar.mo6147i()));
                    } else {
                        int i5 = i3 - 1;
                        if (((adw) arrayList.get(i5)).mo383c()) {
                            SecretKey secretKey = map.get(((adw) arrayList.get(i5)).mo385e());
                            if (secretKey != null) {
                                this.f7717f.put(Integer.valueOf(i2), secretKey);
                            } else {
                                throw new RuntimeException("Key " + ((adw) arrayList.get(i5)).mo385e() + " was not supplied for decryption");
                            }
                        } else {
                            this.f7717f.put(Integer.valueOf(i2), null);
                        }
                    }
                    i = i3;
                }
            }
            this.f7715d = new acu(this.f7717f, yoVar.mo11l(), yoVar.mo6149k(), pnVar.mo36c());
            return;
        }
        throw new RuntimeException("You can only use the CencDecryptingTrackImpl with CENC (cenc or cbc1) encrypted tracks");
    }

    public void close() {
        this.f7716e.close();
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f7716e.mo6140b();
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        C0728pb pbVar = (C0728pb) aft.m883a((C1003wo) this.f7716e.mo13n(), "enc./sinf/frma");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f7716e.mo13n().mo18a(Channels.newChannel(byteArrayOutputStream));
            C0737pi piVar = (C0737pi) new C0678nj((C1007ws) new C1011ww(byteArrayOutputStream.toByteArray())).mo36c().get(0);
            if (piVar.mo5316d() instanceof C0793rd) {
                ((C0793rd) piVar.mo5316d()).mo5574a(pbVar.mo5280a());
            } else if (piVar.mo5316d() instanceof C0801rj) {
                ((C0801rj) piVar.mo5316d()).mo5636a(pbVar.mo5280a());
            } else {
                throw new RuntimeException("I don't know " + piVar.mo5316d().mo1476h());
            }
            LinkedList linkedList = new LinkedList();
            for (C0688nt next : piVar.mo5316d().mo36c()) {
                if (!next.mo1476h().equals(C0732pe.f5641a)) {
                    linkedList.add(next);
                }
            }
            piVar.mo5316d().mo172a((List<C0688nt>) linkedList);
            return piVar;
        } catch (IOException unused) {
            throw new RuntimeException("Dumping stsd to memory failed");
        }
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7716e.mo12m();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7716e.mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7716e.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7715d;
    }
}
