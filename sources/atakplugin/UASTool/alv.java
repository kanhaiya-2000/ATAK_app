package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;

class alv extends ame {

    /* renamed from: a */
    final /* synthetic */ alu f2064a;

    /* renamed from: b */
    private final /* synthetic */ amc f2065b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    alv(alu alu, String str, amc amc) {
        super(str);
        this.f2064a = alu;
        this.f2065b = amc;
    }

    /* renamed from: f */
    public long mo19f() {
        long j = 8;
        for (ama a : this.f2064a.f2057e.get(this.f2065b)) {
            j += (long) a.mo1467a().remaining();
        }
        return j;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        ArrayList arrayList = new ArrayList();
        long j = 8;
        for (ama a : this.f2064a.f2057e.get(this.f2065b)) {
            ByteBuffer a2 = a.mo1467a();
            arrayList.add(a2);
            j += (long) a2.remaining();
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12515b(allocate, j);
        allocate.put(C0678nj.m12488a(mo1476h()));
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            writableByteChannel.write((ByteBuffer) it.next());
        }
    }
}
