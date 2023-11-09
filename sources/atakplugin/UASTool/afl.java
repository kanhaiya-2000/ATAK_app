package atakplugin.UASTool;

import java.util.Objects;

public class afl {

    /* renamed from: a */
    private transient C0027a[] f856a;

    /* renamed from: b */
    private transient int f857b;

    /* renamed from: c */
    private int f858c;

    /* renamed from: d */
    private float f859d;

    /* renamed from: atakplugin.UASTool.afl$a */
    private static class C0027a {

        /* renamed from: a */
        int f860a;

        /* renamed from: b */
        int f861b;

        /* renamed from: c */
        Object f862c;

        /* renamed from: d */
        C0027a f863d;

        protected C0027a(int i, int i2, Object obj, C0027a aVar) {
            this.f860a = i;
            this.f861b = i2;
            this.f862c = obj;
            this.f863d = aVar;
        }
    }

    public afl() {
        this(20, 0.75f);
    }

    public afl(int i) {
        this(i, 0.75f);
    }

    public afl(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        } else if (f > 0.0f) {
            i = i == 0 ? 1 : i;
            this.f859d = f;
            this.f856a = new C0027a[i];
            this.f858c = (int) (((float) i) * f);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
    }

    /* renamed from: a */
    public int mo581a() {
        return this.f857b;
    }

    /* renamed from: b */
    public boolean mo586b() {
        return this.f857b == 0;
    }

    /* renamed from: a */
    public boolean mo584a(Object obj) {
        Objects.requireNonNull(obj);
        C0027a[] aVarArr = this.f856a;
        int length = aVarArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            for (C0027a aVar = aVarArr[i]; aVar != null; aVar = aVar.f863d) {
                if (aVar.f862c.equals(obj)) {
                    return true;
                }
            }
            length = i;
        }
    }

    /* renamed from: b */
    public boolean mo587b(Object obj) {
        return mo584a(obj);
    }

    /* renamed from: a */
    public boolean mo583a(int i) {
        C0027a[] aVarArr = this.f856a;
        for (C0027a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.f863d) {
            if (aVar.f860a == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public Object mo585b(int i) {
        C0027a[] aVarArr = this.f856a;
        for (C0027a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.f863d) {
            if (aVar.f860a == i) {
                return aVar.f862c;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo589c() {
        C0027a[] aVarArr = this.f856a;
        int length = aVarArr.length;
        int i = (length * 2) + 1;
        C0027a[] aVarArr2 = new C0027a[i];
        this.f858c = (int) (((float) i) * this.f859d);
        this.f856a = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                C0027a aVar = aVarArr[i2];
                while (aVar != null) {
                    C0027a aVar2 = aVar.f863d;
                    int i3 = (aVar.f860a & Integer.MAX_VALUE) % i;
                    aVar.f863d = aVarArr2[i3];
                    aVarArr2[i3] = aVar;
                    aVar = aVar2;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public Object mo582a(int i, Object obj) {
        C0027a[] aVarArr = this.f856a;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % aVarArr.length;
        for (C0027a aVar = aVarArr[length]; aVar != null; aVar = aVar.f863d) {
            if (aVar.f860a == i) {
                Object obj2 = aVar.f862c;
                aVar.f862c = obj;
                return obj2;
            }
        }
        if (this.f857b >= this.f858c) {
            mo589c();
            aVarArr = this.f856a;
            length = i2 % aVarArr.length;
        }
        aVarArr[length] = new C0027a(i, i, obj, aVarArr[length]);
        this.f857b++;
        return null;
    }

    /* renamed from: c */
    public Object mo588c(int i) {
        C0027a[] aVarArr = this.f856a;
        int length = (Integer.MAX_VALUE & i) % aVarArr.length;
        C0027a aVar = null;
        for (C0027a aVar2 = aVarArr[length]; aVar2 != null; aVar2 = aVar2.f863d) {
            if (aVar2.f860a == i) {
                if (aVar != null) {
                    aVar.f863d = aVar2.f863d;
                } else {
                    aVarArr[length] = aVar2.f863d;
                }
                this.f857b--;
                Object obj = aVar2.f862c;
                aVar2.f862c = null;
                return obj;
            }
            aVar = aVar2;
        }
        return null;
    }

    /* renamed from: d */
    public synchronized void mo590d() {
        C0027a[] aVarArr = this.f856a;
        int length = aVarArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.f857b = 0;
            } else {
                aVarArr[length] = null;
            }
        }
    }
}
