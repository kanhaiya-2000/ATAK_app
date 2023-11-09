package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.wq */
public class C1005wq implements C0695nz, Closeable, Iterator<C0688nt> {

    /* renamed from: a */
    private static final C0688nt f7518a = new C1006wr("eof ");

    /* renamed from: b */
    private static afp f7519b = afp.m867a(C1005wq.class);

    /* renamed from: c */
    private List<C0688nt> f7520c = new ArrayList();

    /* renamed from: s */
    protected C0675ng f7521s;

    /* renamed from: t */
    protected C1007ws f7522t;

    /* renamed from: u */
    C0688nt f7523u = null;

    /* renamed from: v */
    long f7524v = 0;

    /* renamed from: w */
    long f7525w = 0;

    /* renamed from: x */
    long f7526x = 0;

    /* renamed from: c */
    public List<C0688nt> mo36c() {
        if (this.f7522t == null || this.f7523u == f7518a) {
            return this.f7520c;
        }
        return new afn(this.f7520c, this);
    }

    /* renamed from: a */
    public void mo172a(List<C0688nt> list) {
        this.f7520c = new ArrayList(list);
        this.f7523u = f7518a;
        this.f7522t = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public long mo6130u() {
        long j = 0;
        for (int i = 0; i < mo36c().size(); i++) {
            j += this.f7520c.get(i).mo19f();
        }
        return j;
    }

    /* renamed from: a */
    public <T extends C0688nt> List<T> mo202a(Class<T> cls) {
        List<C0688nt> c = mo36c();
        ArrayList arrayList = null;
        C0688nt ntVar = null;
        for (int i = 0; i < c.size(); i++) {
            C0688nt ntVar2 = c.get(i);
            if (cls.isInstance(ntVar2)) {
                if (ntVar == null) {
                    ntVar = ntVar2;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                        arrayList.add(ntVar);
                    }
                    arrayList.add(ntVar2);
                }
            }
        }
        if (arrayList != null) {
            return arrayList;
        }
        if (ntVar != null) {
            return Collections.singletonList(ntVar);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    public <T extends C0688nt> List<T> mo203a(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        List<C0688nt> c = mo36c();
        for (int i = 0; i < c.size(); i++) {
            C0688nt ntVar = c.get(i);
            if (cls.isInstance(ntVar)) {
                arrayList.add(ntVar);
            }
            if (z && (ntVar instanceof C0695nz)) {
                arrayList.addAll(((C0695nz) ntVar).mo203a(cls, z));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo170a(C0688nt ntVar) {
        if (ntVar != null) {
            this.f7520c = new ArrayList(mo36c());
            ntVar.mo1473a((C0695nz) this);
            this.f7520c.add(ntVar);
        }
    }

    /* renamed from: a */
    public void mo6123a(C1007ws wsVar, long j, C0675ng ngVar) {
        this.f7522t = wsVar;
        long b = wsVar.mo5655b();
        this.f7525w = b;
        this.f7524v = b;
        wsVar.mo5654a(wsVar.mo5655b() + j);
        this.f7526x = wsVar.mo5655b();
        this.f7521s = ngVar;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        C0688nt ntVar = this.f7523u;
        if (ntVar == f7518a) {
            return false;
        }
        if (ntVar != null) {
            return true;
        }
        try {
            this.f7523u = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f7523u = f7518a;
            return false;
        }
    }

    /* renamed from: v */
    public C0688nt next() {
        C0688nt a;
        C0688nt ntVar = this.f7523u;
        if (ntVar == null || ntVar == f7518a) {
            C1007ws wsVar = this.f7522t;
            if (wsVar == null || this.f7524v >= this.f7526x) {
                this.f7523u = f7518a;
                throw new NoSuchElementException();
            }
            try {
                synchronized (wsVar) {
                    this.f7522t.mo5654a(this.f7524v);
                    a = this.f7521s.mo5101a(this.f7522t, this);
                    this.f7524v = this.f7522t.mo5655b();
                }
                return a;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.f7523u = null;
            return ntVar;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f7520c.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.f7520c.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: b */
    public final void mo209b(WritableByteChannel writableByteChannel) {
        for (C0688nt a : mo36c()) {
            a.mo18a(writableByteChannel);
        }
    }

    /* renamed from: a */
    public ByteBuffer mo201a(long j, long j2) {
        ByteBuffer a;
        long j3 = j2;
        C1007ws wsVar = this.f7522t;
        if (wsVar != null) {
            synchronized (wsVar) {
                a = this.f7522t.mo5653a(this.f7525w + j, j3);
            }
            return a;
        }
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(j2));
        long j4 = j + j3;
        long j5 = 0;
        for (C0688nt next : this.f7520c) {
            long f = next.mo19f() + j5;
            if (f > j && j5 < j4) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                WritableByteChannel newChannel = Channels.newChannel(byteArrayOutputStream);
                next.mo18a(newChannel);
                newChannel.close();
                int i = (j5 > j ? 1 : (j5 == j ? 0 : -1));
                if (i >= 0 && f <= j4) {
                    allocate.put(byteArrayOutputStream.toByteArray());
                } else if (i < 0 && f > j4) {
                    long j6 = j - j5;
                    allocate.put(byteArrayOutputStream.toByteArray(), afi.m847a(j6), afi.m847a((next.mo19f() - j6) - (f - j4)));
                } else if (i < 0 && f <= j4) {
                    long j7 = j - j5;
                    allocate.put(byteArrayOutputStream.toByteArray(), afi.m847a(j7), afi.m847a(next.mo19f() - j7));
                } else if (i >= 0 && f > j4) {
                    allocate.put(byteArrayOutputStream.toByteArray(), 0, afi.m847a(next.mo19f() - (f - j4)));
                }
            }
            j5 = f;
        }
        return (ByteBuffer) allocate.rewind();
    }

    public void close() {
        this.f7522t.close();
    }
}
