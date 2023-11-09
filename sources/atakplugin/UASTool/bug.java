package atakplugin.UASTool;

import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.autel.util.okhttp.model.Headers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class bug {

    /* renamed from: a */
    private static final int f3842a = 15;

    /* renamed from: b */
    private static final int f3843b = 31;

    /* renamed from: c */
    private static final int f3844c = 63;

    /* renamed from: d */
    private static final int f3845d = 127;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final bue[] f3846e = {new bue(bue.f3831e, ""), new bue(bue.f3828b, "GET"), new bue(bue.f3828b, "POST"), new bue(bue.f3829c, "/"), new bue(bue.f3829c, "/index.html"), new bue(bue.f3830d, "http"), new bue(bue.f3830d, "https"), new bue(bue.f3827a, "200"), new bue(bue.f3827a, "204"), new bue(bue.f3827a, "206"), new bue(bue.f3827a, "304"), new bue(bue.f3827a, "400"), new bue(bue.f3827a, "404"), new bue(bue.f3827a, (String) TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING), new bue("accept-charset", ""), new bue("accept-encoding", (String) Headers.HEAD_VALUE_ACCEPT_ENCODING), new bue("accept-language", ""), new bue("accept-ranges", ""), new bue("accept", ""), new bue("access-control-allow-origin", ""), new bue("age", ""), new bue("allow", ""), new bue("authorization", ""), new bue("cache-control", ""), new bue("content-disposition", ""), new bue("content-encoding", ""), new bue("content-language", ""), new bue("content-length", ""), new bue("content-location", ""), new bue("content-range", ""), new bue("content-type", ""), new bue("cookie", ""), new bue((String) FlightLogger.LOCS_DATE, ""), new bue("etag", ""), new bue("expect", ""), new bue("expires", ""), new bue("from", ""), new bue("host", ""), new bue("if-match", ""), new bue("if-modified-since", ""), new bue("if-none-match", ""), new bue("if-range", ""), new bue("if-unmodified-since", ""), new bue("last-modified", ""), new bue((String) UasC2Event.LinkDetail.detailName, ""), new bue("location", ""), new bue("max-forwards", ""), new bue("proxy-authenticate", ""), new bue("proxy-authorization", ""), new bue("range", ""), new bue("referer", ""), new bue("refresh", ""), new bue("retry-after", ""), new bue("server", ""), new bue("set-cookie", ""), new bue("strict-transport-security", ""), new bue("transfer-encoding", ""), new bue("user-agent", ""), new bue("vary", ""), new bue("via", ""), new bue("www-authenticate", "")};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Map<bwq, Integer> f3847f = m9563c();

    private bug() {
    }

    /* renamed from: atakplugin.UASTool.bug$a */
    static final class C0249a {

        /* renamed from: a */
        bue[] f3848a;

        /* renamed from: b */
        int f3849b;

        /* renamed from: c */
        int f3850c;

        /* renamed from: d */
        int f3851d;

        /* renamed from: e */
        private final List<bue> f3852e;

        /* renamed from: f */
        private final bwp f3853f;

        /* renamed from: g */
        private final int f3854g;

        /* renamed from: h */
        private int f3855h;

        C0249a(int i, bxr bxr) {
            this(i, i, bxr);
        }

        C0249a(int i, int i2, bxr bxr) {
            this.f3852e = new ArrayList();
            bue[] bueArr = new bue[8];
            this.f3848a = bueArr;
            this.f3849b = bueArr.length - 1;
            this.f3850c = 0;
            this.f3851d = 0;
            this.f3854g = i;
            this.f3855h = i2;
            this.f3853f = bxb.m10330a(bxr);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo3623a() {
            return this.f3855h;
        }

        /* renamed from: e */
        private void m9569e() {
            int i = this.f3855h;
            int i2 = this.f3851d;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m9572f();
            } else {
                m9564a(i2 - i);
            }
        }

        /* renamed from: f */
        private void m9572f() {
            this.f3852e.clear();
            Arrays.fill(this.f3848a, (Object) null);
            this.f3849b = this.f3848a.length - 1;
            this.f3850c = 0;
            this.f3851d = 0;
        }

        /* renamed from: a */
        private int m9564a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f3848a.length;
                while (true) {
                    length--;
                    i2 = this.f3849b;
                    if (length < i2 || i <= 0) {
                        bue[] bueArr = this.f3848a;
                        System.arraycopy(bueArr, i2 + 1, bueArr, i2 + 1 + i3, this.f3850c);
                        this.f3849b += i3;
                    } else {
                        i -= this.f3848a[length].f3836j;
                        this.f3851d -= this.f3848a[length].f3836j;
                        this.f3850c--;
                        i3++;
                    }
                }
                bue[] bueArr2 = this.f3848a;
                System.arraycopy(bueArr2, i2 + 1, bueArr2, i2 + 1 + i3, this.f3850c);
                this.f3849b += i3;
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3625b() {
            while (!this.f3853f.mo3854i()) {
                byte m = this.f3853f.mo3866m() & 255;
                if (m == 128) {
                    throw new IOException("index == 0");
                } else if ((m & 128) == 128) {
                    m9566b(mo3624a((int) m, 127) - 1);
                } else if (m == 64) {
                    m9575h();
                } else if ((m & 64) == 64) {
                    m9570e(mo3624a((int) m, 63) - 1);
                } else if ((m & 32) == 32) {
                    int a = mo3624a((int) m, 31);
                    this.f3855h = a;
                    if (a < 0 || a > this.f3854g) {
                        throw new IOException("Invalid dynamic table size update " + this.f3855h);
                    }
                    m9569e();
                } else if (m == 16 || m == 0) {
                    m9573g();
                } else {
                    m9568d(mo3624a((int) m, 15) - 1);
                }
            }
        }

        /* renamed from: c */
        public List<bue> mo3626c() {
            ArrayList arrayList = new ArrayList(this.f3852e);
            this.f3852e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m9566b(int i) {
            if (m9574g(i)) {
                this.f3852e.add(bug.f3846e[i]);
                return;
            }
            int c = m9567c(i - bug.f3846e.length);
            if (c >= 0) {
                bue[] bueArr = this.f3848a;
                if (c <= bueArr.length - 1) {
                    this.f3852e.add(bueArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: c */
        private int m9567c(int i) {
            return this.f3849b + 1 + i;
        }

        /* renamed from: d */
        private void m9568d(int i) {
            this.f3852e.add(new bue(m9571f(i), mo3627d()));
        }

        /* renamed from: g */
        private void m9573g() {
            this.f3852e.add(new bue(bug.m9561b(mo3627d()), mo3627d()));
        }

        /* renamed from: e */
        private void m9570e(int i) {
            m9565a(-1, new bue(m9571f(i), mo3627d()));
        }

        /* renamed from: h */
        private void m9575h() {
            m9565a(-1, new bue(bug.m9561b(mo3627d()), mo3627d()));
        }

        /* renamed from: f */
        private bwq m9571f(int i) {
            if (m9574g(i)) {
                return bug.f3846e[i].f3834h;
            }
            return this.f3848a[m9567c(i - bug.f3846e.length)].f3834h;
        }

        /* renamed from: g */
        private boolean m9574g(int i) {
            return i >= 0 && i <= bug.f3846e.length - 1;
        }

        /* renamed from: a */
        private void m9565a(int i, bue bue) {
            this.f3852e.add(bue);
            int i2 = bue.f3836j;
            if (i != -1) {
                i2 -= this.f3848a[m9567c(i)].f3836j;
            }
            int i3 = this.f3855h;
            if (i2 > i3) {
                m9572f();
                return;
            }
            int a = m9564a((this.f3851d + i2) - i3);
            if (i == -1) {
                int i4 = this.f3850c + 1;
                bue[] bueArr = this.f3848a;
                if (i4 > bueArr.length) {
                    bue[] bueArr2 = new bue[(bueArr.length * 2)];
                    System.arraycopy(bueArr, 0, bueArr2, bueArr.length, bueArr.length);
                    this.f3849b = this.f3848a.length - 1;
                    this.f3848a = bueArr2;
                }
                int i5 = this.f3849b;
                this.f3849b = i5 - 1;
                this.f3848a[i5] = bue;
                this.f3850c++;
            } else {
                this.f3848a[i + m9567c(i) + a] = bue;
            }
            this.f3851d += i2;
        }

        /* renamed from: i */
        private int m9576i() {
            return this.f3853f.mo3866m() & 255;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo3624a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = m9576i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public bwq mo3627d() {
            int i = m9576i();
            boolean z = (i & 128) == 128;
            int a = mo3624a(i, 127);
            if (z) {
                return bwq.m10200e(bui.m9640a().mo3642b(this.f3853f.mo3855i((long) a)));
            }
            return this.f3853f.mo3838e((long) a);
        }
    }

    /* renamed from: c */
    private static Map<bwq, Integer> m9563c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f3846e.length);
        int i = 0;
        while (true) {
            bue[] bueArr = f3846e;
            if (i >= bueArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bueArr[i].f3834h)) {
                linkedHashMap.put(bueArr[i].f3834h, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* renamed from: atakplugin.UASTool.bug$b */
    static final class C0250b {

        /* renamed from: g */
        private static final int f3856g = 4096;

        /* renamed from: h */
        private static final int f3857h = 16384;

        /* renamed from: a */
        int f3858a;

        /* renamed from: b */
        int f3859b;

        /* renamed from: c */
        bue[] f3860c;

        /* renamed from: d */
        int f3861d;

        /* renamed from: e */
        int f3862e;

        /* renamed from: f */
        int f3863f;

        /* renamed from: i */
        private final bwl f3864i;

        /* renamed from: j */
        private int f3865j;

        /* renamed from: k */
        private boolean f3866k;

        C0250b(bwl bwl) {
            this(4096, bwl);
        }

        C0250b(int i, bwl bwl) {
            this.f3865j = Integer.MAX_VALUE;
            bue[] bueArr = new bue[8];
            this.f3860c = bueArr;
            this.f3861d = bueArr.length - 1;
            this.f3862e = 0;
            this.f3863f = 0;
            this.f3858a = i;
            this.f3859b = i;
            this.f3864i = bwl;
        }

        /* renamed from: a */
        private void m9582a() {
            Arrays.fill(this.f3860c, (Object) null);
            this.f3861d = this.f3860c.length - 1;
            this.f3862e = 0;
            this.f3863f = 0;
        }

        /* renamed from: b */
        private int m9584b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f3860c.length;
                while (true) {
                    length--;
                    i2 = this.f3861d;
                    if (length < i2 || i <= 0) {
                        bue[] bueArr = this.f3860c;
                        System.arraycopy(bueArr, i2 + 1, bueArr, i2 + 1 + i3, this.f3862e);
                        bue[] bueArr2 = this.f3860c;
                        int i4 = this.f3861d;
                        Arrays.fill(bueArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                        this.f3861d += i3;
                    } else {
                        i -= this.f3860c[length].f3836j;
                        this.f3863f -= this.f3860c[length].f3836j;
                        this.f3862e--;
                        i3++;
                    }
                }
                bue[] bueArr3 = this.f3860c;
                System.arraycopy(bueArr3, i2 + 1, bueArr3, i2 + 1 + i3, this.f3862e);
                bue[] bueArr22 = this.f3860c;
                int i42 = this.f3861d;
                Arrays.fill(bueArr22, i42 + 1, i42 + 1 + i3, (Object) null);
                this.f3861d += i3;
            }
            return i3;
        }

        /* renamed from: a */
        private void m9583a(bue bue) {
            int i = bue.f3836j;
            int i2 = this.f3859b;
            if (i > i2) {
                m9582a();
                return;
            }
            m9584b((this.f3863f + i) - i2);
            int i3 = this.f3862e + 1;
            bue[] bueArr = this.f3860c;
            if (i3 > bueArr.length) {
                bue[] bueArr2 = new bue[(bueArr.length * 2)];
                System.arraycopy(bueArr, 0, bueArr2, bueArr.length, bueArr.length);
                this.f3861d = this.f3860c.length - 1;
                this.f3860c = bueArr2;
            }
            int i4 = this.f3861d;
            this.f3861d = i4 - 1;
            this.f3860c[i4] = bue;
            this.f3862e++;
            this.f3863f += i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3631a(List<bue> list) {
            if (this.f3866k) {
                int i = this.f3865j;
                if (i < this.f3859b) {
                    mo3629a(i, 31, 32);
                }
                this.f3866k = false;
                this.f3865j = Integer.MAX_VALUE;
                mo3629a(this.f3859b, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                bue bue = list.get(i2);
                bwq k = bue.f3834h.mo3948k();
                bwq bwq = bue.f3835i;
                Integer num = (Integer) bug.f3847f.get(k);
                if (num != null) {
                    mo3629a(num.intValue() + 1, 15, 0);
                    mo3630a(bwq);
                } else {
                    int a = bsp.m9148a((T[]) this.f3860c, bue);
                    if (a != -1) {
                        mo3629a((a - this.f3861d) + bug.f3846e.length, 127, 128);
                    } else {
                        this.f3864i.mo3833d(64);
                        mo3630a(k);
                        mo3630a(bwq);
                        m9583a(bue);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3629a(int i, int i2, int i3) {
            if (i < i2) {
                this.f3864i.mo3833d(i | i3);
                return;
            }
            this.f3864i.mo3833d(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f3864i.mo3833d(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f3864i.mo3833d(i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3630a(bwq bwq) {
            mo3629a(bwq.mo3951n(), 127, 0);
            this.f3864i.mo3816b(bwq);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3628a(int i) {
            this.f3858a = i;
            int min = Math.min(i, 16384);
            int i2 = this.f3859b;
            if (i2 != min) {
                if (min < i2) {
                    this.f3865j = Math.min(this.f3865j, min);
                }
                this.f3866k = true;
                this.f3859b = min;
                m9585b();
            }
        }

        /* renamed from: b */
        private void m9585b() {
            int i = this.f3859b;
            int i2 = this.f3863f;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m9582a();
            } else {
                m9584b(i2 - i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static bwq m9561b(bwq bwq) {
        int n = bwq.mo3951n();
        int i = 0;
        while (i < n) {
            byte d = bwq.mo3931d(i);
            if (d < 65 || d > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + bwq.mo3929c());
            }
        }
        return bwq;
    }
}
