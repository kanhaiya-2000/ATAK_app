package atakplugin.UASTool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo1538e = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"})
public final class bby implements bku<File> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final File f2521a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final bca f2522b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final bdl<File, Boolean> f2523c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final bdl<File, aqr> f2524d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final bdw<File, IOException, aqr> f2525e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final int f2526f;

    private bby(File file, bca bca, bdl<? super File, Boolean> bdl, bdl<? super File, aqr> bdl2, bdw<? super File, ? super IOException, aqr> bdw, int i) {
        this.f2521a = file;
        this.f2522b = bca;
        this.f2523c = bdl;
        this.f2524d = bdl2;
        this.f2525e = bdw;
        this.f2526f = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ bby(File file, bca bca, bdl bdl, bdl bdl2, bdw bdw, int i, int i2, bfd bfd) {
        this(file, (i2 & 2) != 0 ? bca.TOP_DOWN : bca, bdl, bdl2, bdw, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bby(File file, bca bca) {
        this(file, bca, (bdl) null, (bdl) null, (bdw) null, 0, 32, (bfd) null);
        bfq.m6567f(file, "start");
        bfq.m6567f(bca, "direction");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bby(File file, bca bca, int i, bfd bfd) {
        this(file, (i & 2) != 0 ? bca.TOP_DOWN : bca);
    }

    /* renamed from: a */
    public Iterator<File> mo1859a() {
        return new C0140b();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo1538e = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bby$c */
    private static abstract class C0144c {

        /* renamed from: a */
        private final File f2540a;

        /* renamed from: a */
        public abstract File mo2272a();

        public C0144c(File file) {
            bfq.m6567f(file, SoloComp.SSH_USERNAME);
            this.f2540a = file;
        }

        /* renamed from: b */
        public final File mo2273b() {
            return this.f2540a;
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo1538e = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bby$a */
    private static abstract class C0139a extends C0144c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0139a(File file) {
            super(file);
            bfq.m6567f(file, "rootDir");
            if (aqx.f2180a) {
                boolean isDirectory = file.isDirectory();
                if (aqx.f2180a && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo1538e = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bby$b */
    private final class C0140b extends arg<File> {

        /* renamed from: b */
        private final ArrayDeque<C0144c> f2528b;

        public C0140b() {
            ArrayDeque<C0144c> arrayDeque = new ArrayDeque<>();
            this.f2528b = arrayDeque;
            if (bby.this.f2521a.isDirectory()) {
                arrayDeque.push(m6275a(bby.this.f2521a));
            } else if (bby.this.f2521a.isFile()) {
                arrayDeque.push(new C0142b(this, bby.this.f2521a));
            } else {
                mo1713b();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo1711a() {
            File c = m6276c();
            if (c != null) {
                mo1712a(c);
            } else {
                mo1713b();
            }
        }

        /* renamed from: a */
        private final C0139a m6275a(File file) {
            int i = bbz.f2541a[bby.this.f2522b.ordinal()];
            if (i == 1) {
                return new C0143c(this, file);
            }
            if (i == 2) {
                return new C0141a(this, file);
            }
            throw new aou();
        }

        /* renamed from: c */
        private final File m6276c() {
            File a;
            while (true) {
                C0144c peek = this.f2528b.peek();
                if (peek == null) {
                    return null;
                }
                a = peek.mo2272a();
                if (a == null) {
                    this.f2528b.pop();
                } else if (bfq.m6552a((Object) a, (Object) peek.mo2273b()) || !a.isDirectory() || this.f2528b.size() >= bby.this.f2526f) {
                    return a;
                } else {
                    this.f2528b.push(m6275a(a));
                }
            }
            return a;
        }

        @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo1538e = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"})
        /* renamed from: atakplugin.UASTool.bby$b$a */
        private final class C0141a extends C0139a {

            /* renamed from: a */
            final /* synthetic */ C0140b f2529a;

            /* renamed from: b */
            private boolean f2530b;

            /* renamed from: c */
            private File[] f2531c;

            /* renamed from: d */
            private int f2532d;

            /* renamed from: e */
            private boolean f2533e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0141a(C0140b bVar, File file) {
                super(file);
                bfq.m6567f(file, "rootDir");
                this.f2529a = bVar;
            }

            /* renamed from: a */
            public File mo2272a() {
                if (!this.f2533e && this.f2531c == null) {
                    bdl a = bby.this.f2523c;
                    if (a != null && !((Boolean) a.invoke(mo2273b())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = mo2273b().listFiles();
                    this.f2531c = listFiles;
                    if (listFiles == null) {
                        bdw b = bby.this.f2525e;
                        if (b != null) {
                            aqr aqr = (aqr) b.mo2065a(mo2273b(), new bbm(mo2273b(), (File) null, "Cannot list files in a directory", 2, (bfd) null));
                        }
                        this.f2533e = true;
                    }
                }
                File[] fileArr = this.f2531c;
                if (fileArr != null) {
                    int i = this.f2532d;
                    if (fileArr == null) {
                        bfq.m6538a();
                    }
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f2531c;
                        if (fileArr2 == null) {
                            bfq.m6538a();
                        }
                        int i2 = this.f2532d;
                        this.f2532d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.f2530b) {
                    this.f2530b = true;
                    return mo2273b();
                }
                bdl c = bby.this.f2524d;
                if (c != null) {
                    aqr aqr2 = (aqr) c.invoke(mo2273b());
                }
                return null;
            }
        }

        @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo1538e = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"})
        /* renamed from: atakplugin.UASTool.bby$b$c */
        private final class C0143c extends C0139a {

            /* renamed from: a */
            final /* synthetic */ C0140b f2536a;

            /* renamed from: b */
            private boolean f2537b;

            /* renamed from: c */
            private File[] f2538c;

            /* renamed from: d */
            private int f2539d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0143c(C0140b bVar, File file) {
                super(file);
                bfq.m6567f(file, "rootDir");
                this.f2536a = bVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
                if (r0.length == 0) goto L_0x008b;
             */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File mo2272a() {
                /*
                    r10 = this;
                    boolean r0 = r10.f2537b
                    r1 = 0
                    if (r0 != 0) goto L_0x0028
                    atakplugin.UASTool.bby$b r0 = r10.f2536a
                    atakplugin.UASTool.bby r0 = atakplugin.UASTool.bby.this
                    atakplugin.UASTool.bdl r0 = r0.f2523c
                    if (r0 == 0) goto L_0x0020
                    java.io.File r2 = r10.mo2273b()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x0020
                    return r1
                L_0x0020:
                    r0 = 1
                    r10.f2537b = r0
                    java.io.File r0 = r10.mo2273b()
                    return r0
                L_0x0028:
                    java.io.File[] r0 = r10.f2538c
                    if (r0 == 0) goto L_0x004c
                    int r2 = r10.f2539d
                    if (r0 != 0) goto L_0x0033
                    atakplugin.UASTool.bfq.m6538a()
                L_0x0033:
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0037
                    goto L_0x004c
                L_0x0037:
                    atakplugin.UASTool.bby$b r0 = r10.f2536a
                    atakplugin.UASTool.bby r0 = atakplugin.UASTool.bby.this
                    atakplugin.UASTool.bdl r0 = r0.f2524d
                    if (r0 == 0) goto L_0x004b
                    java.io.File r2 = r10.mo2273b()
                    java.lang.Object r0 = r0.invoke(r2)
                    atakplugin.UASTool.aqr r0 = (atakplugin.UASTool.aqr) r0
                L_0x004b:
                    return r1
                L_0x004c:
                    java.io.File[] r0 = r10.f2538c
                    if (r0 != 0) goto L_0x00a0
                    java.io.File r0 = r10.mo2273b()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f2538c = r0
                    if (r0 != 0) goto L_0x007f
                    atakplugin.UASTool.bby$b r0 = r10.f2536a
                    atakplugin.UASTool.bby r0 = atakplugin.UASTool.bby.this
                    atakplugin.UASTool.bdw r0 = r0.f2525e
                    if (r0 == 0) goto L_0x007f
                    java.io.File r2 = r10.mo2273b()
                    atakplugin.UASTool.bbm r9 = new atakplugin.UASTool.bbm
                    java.io.File r4 = r10.mo2273b()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    java.lang.Object r0 = r0.mo2065a(r2, r9)
                    atakplugin.UASTool.aqr r0 = (atakplugin.UASTool.aqr) r0
                L_0x007f:
                    java.io.File[] r0 = r10.f2538c
                    if (r0 == 0) goto L_0x008b
                    if (r0 != 0) goto L_0x0088
                    atakplugin.UASTool.bfq.m6538a()
                L_0x0088:
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x00a0
                L_0x008b:
                    atakplugin.UASTool.bby$b r0 = r10.f2536a
                    atakplugin.UASTool.bby r0 = atakplugin.UASTool.bby.this
                    atakplugin.UASTool.bdl r0 = r0.f2524d
                    if (r0 == 0) goto L_0x009f
                    java.io.File r2 = r10.mo2273b()
                    java.lang.Object r0 = r0.invoke(r2)
                    atakplugin.UASTool.aqr r0 = (atakplugin.UASTool.aqr) r0
                L_0x009f:
                    return r1
                L_0x00a0:
                    java.io.File[] r0 = r10.f2538c
                    if (r0 != 0) goto L_0x00a7
                    atakplugin.UASTool.bfq.m6538a()
                L_0x00a7:
                    int r1 = r10.f2539d
                    int r2 = r1 + 1
                    r10.f2539d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bby.C0140b.C0143c.mo2272a():java.io.File");
            }
        }

        @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo1538e = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"})
        /* renamed from: atakplugin.UASTool.bby$b$b */
        private final class C0142b extends C0144c {

            /* renamed from: a */
            final /* synthetic */ C0140b f2534a;

            /* renamed from: b */
            private boolean f2535b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0142b(C0140b bVar, File file) {
                super(file);
                bfq.m6567f(file, "rootFile");
                this.f2534a = bVar;
                if (aqx.f2180a) {
                    boolean isFile = file.isFile();
                    if (aqx.f2180a && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            /* renamed from: a */
            public File mo2272a() {
                if (this.f2535b) {
                    return null;
                }
                this.f2535b = true;
                return mo2273b();
            }
        }
    }

    /* renamed from: a */
    public final bby mo2269a(bdl<? super File, Boolean> bdl) {
        bfq.m6567f(bdl, "function");
        return new bby(this.f2521a, this.f2522b, bdl, this.f2524d, this.f2525e, this.f2526f);
    }

    /* renamed from: b */
    public final bby mo2271b(bdl<? super File, aqr> bdl) {
        bfq.m6567f(bdl, "function");
        return new bby(this.f2521a, this.f2522b, this.f2523c, bdl, this.f2525e, this.f2526f);
    }

    /* renamed from: a */
    public final bby mo2270a(bdw<? super File, ? super IOException, aqr> bdw) {
        bfq.m6567f(bdw, "function");
        return new bby(this.f2521a, this.f2522b, this.f2523c, this.f2524d, bdw, this.f2526f);
    }

    /* renamed from: a */
    public final bby mo2268a(int i) {
        if (i > 0) {
            return new bby(this.f2521a, this.f2522b, this.f2523c, this.f2524d, this.f2525e, i);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i + '.');
    }
}
