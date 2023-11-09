package atakplugin.UASTool;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class afu<K extends Comparable, V> implements Map<K, V> {

    /* renamed from: a */
    TreeMap<K, V> f885a = new TreeMap<>(new afv(this));

    public boolean containsValue(Object obj) {
        return false;
    }

    public afu() {
    }

    public afu(K k, V v) {
        put(k, v);
    }

    public int size() {
        return this.f885a.size();
    }

    public boolean isEmpty() {
        return this.f885a.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f885a.get(obj) != null;
    }

    public V get(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.f885a.keySet().iterator();
        K next = it.next();
        while (true) {
            Comparable comparable2 = (Comparable) next;
            if (!it.hasNext()) {
                return this.f885a.get(comparable2);
            }
            if (comparable.compareTo(comparable2) >= 0) {
                return this.f885a.get(comparable2);
            }
            next = it.next();
        }
    }

    /* renamed from: a */
    public V put(K k, V v) {
        return this.f885a.put(k, v);
    }

    public V remove(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.f885a.keySet().iterator();
        K next = it.next();
        while (true) {
            Comparable comparable2 = (Comparable) next;
            if (!it.hasNext()) {
                return this.f885a.remove(comparable2);
            }
            if (comparable.compareTo(comparable2) >= 0) {
                return this.f885a.remove(comparable2);
            }
            next = it.next();
        }
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.f885a.putAll(map);
    }

    public void clear() {
        this.f885a.clear();
    }

    public Set<K> keySet() {
        return this.f885a.keySet();
    }

    public Collection<V> values() {
        return this.f885a.values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.f885a.entrySet();
    }
}
