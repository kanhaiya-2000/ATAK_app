package atakplugin.UASTool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class caa extends bzz implements cca {

    /* renamed from: b */
    private String f4409b;

    /* renamed from: c */
    private cbm<?> f4410c;

    /* renamed from: d */
    private Type f4411d;

    public caa(cbm<?> cbm, String str, int i, String str2, cbm<?> cbm2, Type type) {
        super(cbm, str, i);
        this.f4409b = str2;
        this.f4410c = cbm2;
        this.f4411d = type;
    }

    public caa(cbm<?> cbm, cbm<?> cbm2, Field field) {
        super(cbm, cbm2, field.getModifiers());
        this.f4409b = field.getName();
        this.f4410c = cbn.m11175a(field.getType());
        Type genericType = field.getGenericType();
        if (genericType instanceof Class) {
            this.f4411d = cbn.m11175a((Class) genericType);
        } else {
            this.f4411d = genericType;
        }
    }

    /* renamed from: a */
    public String mo4291a() {
        return this.f4409b;
    }

    /* renamed from: b */
    public cbm<?> mo4292b() {
        return this.f4410c;
    }

    /* renamed from: c */
    public Type mo4293c() {
        return this.f4411d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Modifier.toString(mo4289f()));
        stringBuffer.append(" ");
        stringBuffer.append(mo4292b().toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.f4405a);
        stringBuffer.append(".");
        stringBuffer.append(mo4291a());
        return stringBuffer.toString();
    }
}
