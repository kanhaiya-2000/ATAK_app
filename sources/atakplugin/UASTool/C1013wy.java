package atakplugin.UASTool;

@cax
/* renamed from: atakplugin.UASTool.wy */
public class C1013wy {

    /* renamed from: a */
    public static final /* synthetic */ C1013wy f7538a = null;

    /* renamed from: b */
    private static /* synthetic */ Throwable f7539b;

    static {
        try {
            f7538a = new C1013wy();
        } catch (Throwable th) {
            f7539b = th;
        }
    }

    /* renamed from: a */
    public static C1013wy m14474a() {
        C1013wy wyVar = f7538a;
        if (wyVar != null) {
            return wyVar;
        }
        throw new cao("com.googlecode.mp4parser.RequiresParseDetailAspect", f7539b);
    }

    /* renamed from: b */
    public static boolean m14475b() {
        return f7538a != null;
    }

    @cay(mo4370a = "this(com.googlecode.mp4parser.AbstractBox) && ((execution(public * * (..)) && !( execution(* parseDetails()) || execution(* getNumOfBytesToFirstChild()) || execution(* getType()) || execution(* isParsed()) || execution(* getHeader(*)) || execution(* parse()) || execution(* getBox(*)) || execution(* getSize()) || execution(* getOffset()) || execution(* parseDetails()) || execution(* _parseDetails(*)) || execution(* parse(*,*,*,*)) || execution(* getIsoFile()) || execution(* getParent()) || execution(* setParent(*)) || execution(* getUserType()) || execution(* setUserType(*))) && !@annotation(com.googlecode.mp4parser.annotations.DoNotParseDetail)) || @annotation(com.googlecode.mp4parser.annotations.ParseDetail))")
    /* renamed from: a */
    public void mo6137a(can can) {
        if (!(can.mo4326d() instanceof C1002wn)) {
            throw new RuntimeException("Only methods in subclasses of " + C1002wn.class.getName() + " can  be annotated with ParseDetail");
        } else if (!((C1002wn) can.mo4326d()).mo6121x()) {
            ((C1002wn) can.mo4326d()).mo6120v();
        }
    }
}
