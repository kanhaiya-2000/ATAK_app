package atakplugin.UASTool;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

/* renamed from: atakplugin.UASTool.nh */
public class C0676nh {

    /* renamed from: a */
    static final /* synthetic */ boolean f5333a = true;

    /* renamed from: a */
    public static void m12483a(Map<String, C0688nt> map, File file) {
        C0678nj njVar = new C0678nj((C1007ws) new C1009wu(new RandomAccessFile(file, "r").getChannel()));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            C0688nt a = aft.m882a((C0695nz) njVar, (String) next.getKey());
            hashMap.put(aft.m884a(a), (C0688nt) next.getValue());
            hashMap2.put(aft.m884a(a), Long.valueOf(a.mo1475g()));
            if (!f5333a && a.mo19f() != ((C0688nt) next.getValue()).mo19f()) {
                throw new AssertionError();
            }
        }
        njVar.close();
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        for (String str : hashMap.keySet()) {
            channel.position(((Long) hashMap2.get(str)).longValue());
            ((C0688nt) hashMap.get(str)).mo18a((WritableByteChannel) channel);
        }
        channel.close();
    }
}
