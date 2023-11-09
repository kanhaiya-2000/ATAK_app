package atakplugin.UASTool;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B<\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ\u0013\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0018\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0016R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, mo1538e = {"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "getMap", "()Ljava/util/Map;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", "hashCode", "isEmpty", "toString", "", "kotlin-stdlib"})
final class aux<K, V> implements auw<K, V> {

    /* renamed from: a */
    private final Map<K, V> f2282a;

    /* renamed from: b */
    private final bdl<K, V> f2283b;

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public aux(Map<K, ? extends V> map, bdl<? super K, ? extends V> bdl) {
        bfq.m6567f(map, "map");
        bfq.m6567f(bdl, "default");
        this.f2282a = map;
        this.f2283b = bdl;
    }

    /* renamed from: a */
    public Map<K, V> mo2012a() {
        return this.f2282a;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return mo2019e();
    }

    public final Set<K> keySet() {
        return mo2014c();
    }

    public final int size() {
        return mo2013b();
    }

    public final Collection<V> values() {
        return mo2018d();
    }

    public boolean equals(Object obj) {
        return mo2012a().equals(obj);
    }

    public int hashCode() {
        return mo2012a().hashCode();
    }

    public String toString() {
        return mo2012a().toString();
    }

    /* renamed from: b */
    public int mo2013b() {
        return mo2012a().size();
    }

    public boolean isEmpty() {
        return mo2012a().isEmpty();
    }

    public boolean containsKey(Object obj) {
        return mo2012a().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return mo2012a().containsValue(obj);
    }

    public V get(Object obj) {
        return mo2012a().get(obj);
    }

    /* renamed from: c */
    public Set<K> mo2014c() {
        return mo2012a().keySet();
    }

    /* renamed from: d */
    public Collection<V> mo2018d() {
        return mo2012a().values();
    }

    /* renamed from: e */
    public Set<Map.Entry<K, V>> mo2019e() {
        return mo2012a().entrySet();
    }

    /* renamed from: a */
    public V mo2011a(K k) {
        Map a = mo2012a();
        V v = a.get(k);
        return (v != null || a.containsKey(k)) ? v : this.f2283b.invoke(k);
    }
}
