package java.util.function;

import java.util.Objects;
import java.util.function.C5916a;

/* renamed from: java.util.function.a */
public interface C5916a<T> {
    /* renamed from: a */
    C5916a<T> mo26620a(C5916a<? super T> aVar);

    void accept(T t);

    /* renamed from: java.util.function.a$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static C5916a $default$a(C5916a _this, C5916a aVar) {
            Objects.requireNonNull(aVar);
            return new C5916a(aVar) {
                public final /* synthetic */ C5916a f$1;

                {
                    this.f$1 = r2;
                }

                /* renamed from: a */
                public /* synthetic */ C5916a mo26620a(C5916a aVar) {
                    return C5916a.CC.$default$a(this, aVar);
                }

                public final void accept(Object obj) {
                    C5916a.CC.$private$a(C5916a.this, this.f$1, obj);
                }
            };
        }

        public static /* synthetic */ void $private$a(C5916a _this, C5916a aVar, Object obj) {
            _this.accept(obj);
            aVar.accept(obj);
        }
    }
}
