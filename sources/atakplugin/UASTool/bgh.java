package atakplugin.UASTool;

public abstract class bgh extends bex implements bjr {
    public bgh() {
    }

    public bgh(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public bjr getReflected() {
        return (bjr) super.getReflected();
    }

    /* renamed from: h */
    public boolean mo2474h() {
        return getReflected().mo2474h();
    }

    /* renamed from: i */
    public boolean mo2476i() {
        return getReflected().mo2476i();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bgh) {
            bgh bgh = (bgh) obj;
            if (!getOwner().equals(bgh.getOwner()) || !getName().equals(bgh.getName()) || !getSignature().equals(bgh.getSignature()) || !bfq.m6552a(getBoundReceiver(), bgh.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof bjr) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        bjh compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
