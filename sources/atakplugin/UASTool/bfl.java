package atakplugin.UASTool;

public class bfl extends bex implements bfj, bjl {
    private final int arity;

    public bfl(int i) {
        this.arity = i;
    }

    public bfl(int i, Object obj) {
        super(obj);
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    public bjl getReflected() {
        return (bjl) super.getReflected();
    }

    /* access modifiers changed from: protected */
    public bjh computeReflected() {
        return bgp.m6702a(this);
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bfl) {
            bfl bfl = (bfl) obj;
            if (getOwner() != null ? getOwner().equals(bfl.getOwner()) : bfl.getOwner() == null) {
                if (!getName().equals(bfl.getName()) || !getSignature().equals(bfl.getSignature()) || !bfq.m6552a(getBoundReceiver(), bfl.getBoundReceiver())) {
                    return false;
                }
                return true;
            }
            return false;
        } else if (obj instanceof bjl) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        bjh compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
