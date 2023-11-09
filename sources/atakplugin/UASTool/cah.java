package atakplugin.UASTool;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;

public class cah {
    /* renamed from: a */
    public static Type[] m10990a(String str, Class cls) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Type[] typeArr = new Type[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            typeArr[i] = m10991b(stringTokenizer.nextToken().trim(), cls);
            i++;
        }
        return typeArr;
    }

    /* renamed from: b */
    public static Type m10991b(String str, Class cls) {
        try {
            if (str.indexOf("<") == -1) {
                return cbn.m11175a(Class.forName(str, false, cls.getClassLoader()));
            }
            return m10992c(str, cls);
        } catch (ClassNotFoundException unused) {
            TypeVariable[] typeParameters = cls.getTypeParameters();
            for (int i = 0; i < typeParameters.length; i++) {
                if (typeParameters[i].getName().equals(str)) {
                    return typeParameters[i];
                }
            }
            throw new ClassNotFoundException(str);
        }
    }

    /* renamed from: c */
    private static Type m10992c(String str, Class cls) {
        int indexOf = str.indexOf(60);
        return new cai(m10990a(str.substring(indexOf + 1, str.lastIndexOf(62)), cls), Class.forName(str.substring(0, indexOf), false, cls.getClassLoader()));
    }
}
