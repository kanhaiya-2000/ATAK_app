package atakplugin.UASTool;

import java.io.IOException;

class bte extends bws {

    /* renamed from: a */
    private boolean f3668a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3458a(IOException iOException) {
    }

    public bte(bxp bxp) {
        super(bxp);
    }

    public void write(bwl bwl, long j) {
        if (this.f3668a) {
            bwl.mo3859j(j);
            return;
        }
        try {
            super.write(bwl, j);
        } catch (IOException e) {
            this.f3668a = true;
            mo3458a(e);
        }
    }

    public void flush() {
        if (!this.f3668a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f3668a = true;
                mo3458a(e);
            }
        }
    }

    public void close() {
        if (!this.f3668a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f3668a = true;
                mo3458a(e);
            }
        }
    }
}
