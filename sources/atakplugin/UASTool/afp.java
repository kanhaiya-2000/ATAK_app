package atakplugin.UASTool;

public abstract class afp {
    /* renamed from: a */
    public abstract void mo574a(String str);

    /* renamed from: b */
    public abstract void mo575b(String str);

    /* renamed from: c */
    public abstract void mo576c(String str);

    /* renamed from: a */
    public static afp m867a(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new afg(cls.getSimpleName());
        }
        return new afm(cls.getSimpleName());
    }
}
