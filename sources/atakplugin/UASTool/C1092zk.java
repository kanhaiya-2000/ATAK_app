package atakplugin.UASTool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* renamed from: atakplugin.UASTool.zk */
public class C1092zk {

    /* renamed from: a */
    public int f7959a;

    /* renamed from: b */
    public C1093a f7960b;

    /* renamed from: c */
    public int f7961c;

    /* renamed from: d */
    public int f7962d;

    /* renamed from: e */
    public int f7963e;

    /* renamed from: f */
    public boolean f7964f = false;

    /* renamed from: g */
    public boolean f7965g = false;

    /* renamed from: h */
    public int f7966h;

    /* renamed from: i */
    public int f7967i;

    /* renamed from: j */
    public int f7968j;

    /* renamed from: k */
    public int f7969k;

    /* renamed from: l */
    public int f7970l;

    /* renamed from: m */
    aew f7971m;

    /* renamed from: n */
    aez f7972n;

    /* renamed from: atakplugin.UASTool.zk$a */
    public enum C1093a {
        P,
        B,
        I,
        SP,
        SI
    }

    public C1092zk(InputStream inputStream, Map<Integer, aez> map, Map<Integer, aew> map2, boolean z) {
        try {
            inputStream.read();
            afc afc = new afc(inputStream);
            this.f7959a = afc.mo547a("SliceHeader: first_mb_in_slice");
            switch (afc.mo547a("SliceHeader: slice_type")) {
                case 0:
                case 5:
                    this.f7960b = C1093a.P;
                    break;
                case 1:
                case 6:
                    this.f7960b = C1093a.B;
                    break;
                case 2:
                case 7:
                    this.f7960b = C1093a.I;
                    break;
                case 3:
                case 8:
                    this.f7960b = C1093a.SP;
                    break;
                case 4:
                case 9:
                    this.f7960b = C1093a.SI;
                    break;
            }
            int a = afc.mo547a("SliceHeader: pic_parameter_set_id");
            this.f7961c = a;
            aew aew = map2.get(Integer.valueOf(a));
            this.f7971m = aew;
            aez aez = map.get(Integer.valueOf(aew.f742f));
            this.f7972n = aez;
            if (aez.f768A) {
                this.f7962d = afc.mo550b(2, "SliceHeader: colour_plane_id");
            }
            this.f7963e = afc.mo550b(this.f7972n.f792j + 4, "SliceHeader: frame_num");
            if (!this.f7972n.f773F) {
                boolean c = afc.mo552c("SliceHeader: field_pic_flag");
                this.f7964f = c;
                if (c) {
                    this.f7965g = afc.mo552c("SliceHeader: bottom_field_flag");
                }
            }
            if (z) {
                this.f7966h = afc.mo547a("SliceHeader: idr_pic_id");
            }
            if (this.f7972n.f783a == 0) {
                this.f7967i = afc.mo550b(this.f7972n.f793k + 4, "SliceHeader: pic_order_cnt_lsb");
                if (this.f7971m.f743g && !this.f7964f) {
                    this.f7968j = afc.mo551b("SliceHeader: delta_pic_order_cnt_bottom");
                }
            }
            if (this.f7972n.f783a == 1 && !this.f7972n.f785c) {
                this.f7969k = afc.mo551b("delta_pic_order_cnt_0");
                if (this.f7971m.f743g && !this.f7964f) {
                    this.f7970l = afc.mo551b("delta_pic_order_cnt_1");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "SliceHeader{first_mb_in_slice=" + this.f7959a + ", slice_type=" + this.f7960b + ", pic_parameter_set_id=" + this.f7961c + ", colour_plane_id=" + this.f7962d + ", frame_num=" + this.f7963e + ", field_pic_flag=" + this.f7964f + ", bottom_field_flag=" + this.f7965g + ", idr_pic_id=" + this.f7966h + ", pic_order_cnt_lsb=" + this.f7967i + ", delta_pic_order_cnt_bottom=" + this.f7968j + '}';
    }
}
