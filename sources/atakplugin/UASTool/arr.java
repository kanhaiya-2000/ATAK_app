package atakplugin.UASTool;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo1538e = {"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public abstract class arr<K, V> extends AbstractMap<K, V> implements bhf, Map<K, V> {
    /* renamed from: a */
    public abstract Set mo1785a();

    public abstract V put(K k, V v);

    protected arr() {
    }

    /* renamed from: b */
    public Set mo1786b() {
        return super.keySet();
    }

    /* renamed from: c */
    public int mo1787c() {
        return super.size();
    }

    /* renamed from: d */
    public Collection mo1788d() {
        return super.values();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return mo1785a();
    }

    public final Set<K> keySet() {
        return mo1786b();
    }

    public final int size() {
        return mo1787c();
    }

    public final Collection<V> values() {
        return mo1788d();
    }
}
