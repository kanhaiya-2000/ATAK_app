package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, mo1538e = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"})
public abstract class arj<K, V> implements bgz, Map<K, V> {

    /* renamed from: a */
    public static final C0100a f2213a = new C0100a((bfd) null);

    /* renamed from: b */
    private volatile Set<? extends K> f2214b;

    /* renamed from: c */
    private volatile Collection<? extends V> f2215c;

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: d */
    public abstract Set mo1753d();

    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected arj() {
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return mo1753d();
    }

    public final Set<K> keySet() {
        return mo1748b();
    }

    public final int size() {
        return mo1746a();
    }

    public final Collection<V> values() {
        return mo1749c();
    }

    public boolean containsKey(Object obj) {
        return m3062b(obj) != null;
    }

    public boolean containsValue(Object obj) {
        Iterable<Map.Entry> entrySet = entrySet();
        if ((entrySet instanceof Collection) && ((Collection) entrySet).isEmpty()) {
            return false;
        }
        for (Map.Entry value : entrySet) {
            if (bfq.m6552a(value.getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo1747a(Map.Entry<?, ?> entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        Map map = this;
        Object obj = map.get(key);
        if (!bfq.m6552a((Object) value, obj)) {
            return false;
        }
        if (obj != null || map.containsKey(key)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Iterable<Map.Entry> entrySet = map.entrySet();
        if ((entrySet instanceof Collection) && ((Collection) entrySet).isEmpty()) {
            return true;
        }
        for (Map.Entry a : entrySet) {
            if (!mo1747a((Map.Entry<?, ?>) a)) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        Map.Entry b = m3062b(obj);
        if (b != null) {
            return b.getValue();
        }
        return null;
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: a */
    public int mo1746a() {
        return entrySet().size();
    }

    /* renamed from: b */
    public Set<K> mo1748b() {
        if (this.f2214b == null) {
            this.f2214b = new ark(this);
        }
        Set<? extends K> set = this.f2214b;
        if (set == null) {
            bfq.m6538a();
        }
        return set;
    }

    public String toString() {
        return ato.m4738a(entrySet(), ", ", "{", "}", 0, (CharSequence) null, new arm(this), 24, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String m3061b(Map.Entry<? extends K, ? extends V> entry) {
        return m3060a((Object) entry.getKey()) + "=" + m3060a((Object) entry.getValue());
    }

    /* renamed from: a */
    private final String m3060a(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* renamed from: c */
    public Collection<V> mo1749c() {
        if (this.f2215c == null) {
            this.f2215c = new arn(this);
        }
        Collection<? extends V> collection = this.f2215c;
        if (collection == null) {
            bfq.m6538a();
        }
        return collection;
    }

    /* renamed from: b */
    private final Map.Entry<K, V> m3062b(K k) {
        Object obj;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (bfq.m6552a(((Map.Entry) obj).getKey(), (Object) k)) {
                break;
            }
        }
        return (Map.Entry) obj;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, mo1538e = {"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.arj$a */
    public static final class C0100a {
        private C0100a() {
        }

        public /* synthetic */ C0100a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final int mo1766a(Map.Entry<?, ?> entry) {
            bfq.m6567f(entry, LogTask.LOG_TYPE_ERROR);
            Object key = entry.getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        /* renamed from: b */
        public final String mo1768b(Map.Entry<?, ?> entry) {
            bfq.m6567f(entry, LogTask.LOG_TYPE_ERROR);
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            return sb.toString();
        }

        /* renamed from: a */
        public final boolean mo1767a(Map.Entry<?, ?> entry, Object obj) {
            bfq.m6567f(entry, LogTask.LOG_TYPE_ERROR);
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (!bfq.m6552a((Object) entry.getKey(), entry2.getKey()) || !bfq.m6552a((Object) entry.getValue(), entry2.getValue())) {
                return false;
            }
            return true;
        }
    }
}
