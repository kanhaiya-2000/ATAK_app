package atakplugin.UASTool;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0013\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020$H\u0016R(\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, mo1538e = {"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"})
final class auj implements bgz, Serializable, Map {

    /* renamed from: a */
    public static final auj f2273a = new auj();

    /* renamed from: b */
    private static final long f2274b = 8246714829545688274L;

    /* renamed from: a */
    public int mo1945a() {
        return 0;
    }

    /* renamed from: a */
    public Void mo1946a(Object obj) {
        return null;
    }

    /* renamed from: a */
    public Void mo1947a(Object obj, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: a */
    public boolean mo1948a(Void voidR) {
        bfq.m6567f(voidR, "value");
        return false;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "{}";
    }

    private auj() {
    }

    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return mo1948a((Void) obj);
        }
        return false;
    }

    public final Set<Map.Entry> entrySet() {
        return mo1949b();
    }

    public final Object get(Object obj) {
        return mo1946a(obj);
    }

    public final Set<Object> keySet() {
        return mo1950c();
    }

    public final int size() {
        return mo1945a();
    }

    public final Collection values() {
        return mo1954d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    /* renamed from: b */
    public Set<Map.Entry> mo1949b() {
        return auk.f2275a;
    }

    /* renamed from: c */
    public Set<Object> mo1950c() {
        return auk.f2275a;
    }

    /* renamed from: d */
    public Collection mo1954d() {
        return aui.f2271a;
    }

    /* renamed from: e */
    private final Object m4909e() {
        return f2273a;
    }
}
