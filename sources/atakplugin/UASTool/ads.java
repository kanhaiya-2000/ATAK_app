package atakplugin.UASTool;

import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ads {

    /* renamed from: a */
    protected static Logger f589a = Logger.getLogger(ads.class.getName());

    /* renamed from: b */
    protected static Map<Integer, Map<Integer, Class<? extends adh>>> f590b = new HashMap();

    static {
        HashSet<Class> hashSet = new HashSet<>();
        hashSet.add(adl.class);
        hashSet.add(adu.class);
        hashSet.add(adh.class);
        hashSet.add(ado.class);
        hashSet.add(adr.class);
        hashSet.add(adt.class);
        hashSet.add(adg.class);
        hashSet.add(adp.class);
        hashSet.add(adn.class);
        hashSet.add(adk.class);
        for (Class cls : hashSet) {
            adm adm = (adm) cls.getAnnotation(adm.class);
            int[] a = adm.mo342a();
            int b = adm.mo343b();
            Map map = f590b.get(Integer.valueOf(b));
            if (map == null) {
                map = new HashMap();
            }
            for (int valueOf : a) {
                map.put(Integer.valueOf(valueOf), cls);
            }
            f590b.put(Integer.valueOf(b), map);
        }
    }

    /* renamed from: a */
    public static adh m574a(int i, ByteBuffer byteBuffer) {
        adh adh;
        int f = C0679nk.m12499f(byteBuffer);
        Map map = f590b.get(Integer.valueOf(i));
        if (map == null) {
            map = f590b.get(-1);
        }
        Class cls = (Class) map.get(Integer.valueOf(f));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            Logger logger = f589a;
            logger.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(f) + " found: " + cls);
            adh = new adv();
        } else {
            try {
                adh = (adh) cls.newInstance();
            } catch (Exception e) {
                Logger logger2 = f589a;
                Level level = Level.SEVERE;
                logger2.log(level, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + f, e);
                throw new RuntimeException(e);
            }
        }
        adh.mo310a(f, byteBuffer);
        return adh;
    }
}
