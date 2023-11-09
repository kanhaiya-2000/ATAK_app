package atakplugin.UASTool;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class cai implements ParameterizedType {

    /* renamed from: a */
    final /* synthetic */ Type[] f4430a;

    /* renamed from: b */
    final /* synthetic */ Class f4431b;

    cai(Type[] typeArr, Class cls) {
        this.f4430a = typeArr;
        this.f4431b = cls;
    }

    public Type[] getActualTypeArguments() {
        return this.f4430a;
    }

    public Type getRawType() {
        return this.f4431b;
    }

    public Type getOwnerType() {
        return this.f4431b.getEnclosingClass();
    }
}
