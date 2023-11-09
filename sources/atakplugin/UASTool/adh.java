package atakplugin.UASTool;

import java.nio.ByteBuffer;

@adm(mo342a = {0})
public abstract class adh {

    /* renamed from: ac */
    static final /* synthetic */ boolean f536ac = true;

    /* renamed from: Z */
    int f537Z;

    /* renamed from: aa */
    int f538aa;

    /* renamed from: ab */
    int f539ab;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract int mo292a();

    /* renamed from: a */
    public abstract void mo294a(ByteBuffer byteBuffer);

    /* renamed from: b */
    public abstract ByteBuffer mo295b();

    /* renamed from: i */
    public int mo312i() {
        return this.f537Z;
    }

    /* renamed from: a */
    public void mo311a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        int i2 = 0;
        while (true) {
            if (i > 0 || i2 < this.f539ab) {
                i2++;
                if (i > 0) {
                    byteBuffer.put((mo313j() + position) - i2, (byte) (i & 127));
                } else {
                    byteBuffer.put((mo313j() + position) - i2, Byte.MIN_VALUE);
                }
                i >>>= 7;
            } else {
                byteBuffer.position(position + mo313j());
                return;
            }
        }
    }

    /* renamed from: j */
    public int mo313j() {
        int a = mo292a();
        int i = 0;
        while (true) {
            if (a <= 0 && i >= this.f539ab) {
                return i;
            }
            a >>>= 7;
            i++;
        }
    }

    /* renamed from: k */
    public int mo314k() {
        return mo292a() + mo313j() + 1;
    }

    /* renamed from: a */
    public final void mo310a(int i, ByteBuffer byteBuffer) {
        this.f537Z = i;
        int f = C0679nk.m12499f(byteBuffer);
        this.f538aa = f & 127;
        int i2 = 1;
        while ((f >>> 7) == 1) {
            f = C0679nk.m12499f(byteBuffer);
            i2++;
            this.f538aa = (this.f538aa << 7) | (f & 127);
        }
        this.f539ab = i2;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.f538aa);
        mo294a(slice);
        if (f536ac || slice.remaining() == 0) {
            byteBuffer.position(byteBuffer.position() + this.f538aa);
            return;
        }
        throw new AssertionError(String.valueOf(getClass().getSimpleName()) + " has not been fully parsed");
    }

    public String toString() {
        return "BaseDescriptor" + "{tag=" + this.f537Z + ", sizeOfInstance=" + this.f538aa + '}';
    }
}
