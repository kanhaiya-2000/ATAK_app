package atakplugin.UASTool;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class aew extends aet {

    /* renamed from: a */
    public boolean f737a;

    /* renamed from: b */
    public int f738b;

    /* renamed from: c */
    public int f739c;

    /* renamed from: d */
    public int f740d;

    /* renamed from: e */
    public int f741e;

    /* renamed from: f */
    public int f742f;

    /* renamed from: g */
    public boolean f743g;

    /* renamed from: h */
    public int f744h;

    /* renamed from: i */
    public int f745i;

    /* renamed from: j */
    public boolean f746j;

    /* renamed from: k */
    public int f747k;

    /* renamed from: l */
    public int f748l;

    /* renamed from: m */
    public int f749m;

    /* renamed from: n */
    public int f750n;

    /* renamed from: o */
    public boolean f751o;

    /* renamed from: p */
    public boolean f752p;

    /* renamed from: q */
    public boolean f753q;

    /* renamed from: r */
    public int[] f754r;

    /* renamed from: s */
    public int[] f755s;

    /* renamed from: t */
    public int[] f756t;

    /* renamed from: u */
    public boolean f757u;

    /* renamed from: v */
    public int[] f758v;

    /* renamed from: w */
    public C0024a f759w;

    /* renamed from: atakplugin.UASTool.aew$a */
    public static class C0024a {

        /* renamed from: a */
        public boolean f760a;

        /* renamed from: b */
        public aey f761b = new aey();

        /* renamed from: c */
        public int f762c;

        /* renamed from: d */
        public boolean[] f763d;

        public String toString() {
            return "PPSExt{transform_8x8_mode_flag=" + this.f760a + ", scalindMatrix=" + this.f761b + ", second_chroma_qp_index_offset=" + this.f762c + ", pic_scaling_list_present_flag=" + this.f763d + '}';
        }
    }

    /* renamed from: a */
    public static aew m787a(byte[] bArr) {
        return m786a((InputStream) new ByteArrayInputStream(bArr));
    }

    /* renamed from: a */
    public static aew m786a(InputStream inputStream) {
        afc afc = new afc(inputStream);
        aew aew = new aew();
        aew.f741e = afc.mo547a("PPS: pic_parameter_set_id");
        aew.f742f = afc.mo547a("PPS: seq_parameter_set_id");
        aew.f737a = afc.mo552c("PPS: entropy_coding_mode_flag");
        aew.f743g = afc.mo552c("PPS: pic_order_present_flag");
        int a = afc.mo547a("PPS: num_slice_groups_minus1");
        aew.f744h = a;
        if (a > 0) {
            int a2 = afc.mo547a("PPS: slice_group_map_type");
            aew.f745i = a2;
            int i = aew.f744h;
            aew.f754r = new int[(i + 1)];
            aew.f755s = new int[(i + 1)];
            aew.f756t = new int[(i + 1)];
            if (a2 == 0) {
                for (int i2 = 0; i2 <= aew.f744h; i2++) {
                    aew.f756t[i2] = afc.mo547a("PPS: run_length_minus1");
                }
            } else if (a2 == 2) {
                for (int i3 = 0; i3 < aew.f744h; i3++) {
                    aew.f754r[i3] = afc.mo547a("PPS: top_left");
                    aew.f755s[i3] = afc.mo547a("PPS: bottom_right");
                }
            } else {
                int i4 = 3;
                if (a2 == 3 || a2 == 4 || a2 == 5) {
                    aew.f757u = afc.mo552c("PPS: slice_group_change_direction_flag");
                    aew.f740d = afc.mo547a("PPS: slice_group_change_rate_minus1");
                } else if (a2 == 6) {
                    if (i + 1 <= 4) {
                        i4 = i + 1 > 2 ? 2 : 1;
                    }
                    int a3 = afc.mo547a("PPS: pic_size_in_map_units_minus1");
                    aew.f758v = new int[(a3 + 1)];
                    for (int i5 = 0; i5 <= a3; i5++) {
                        int[] iArr = aew.f758v;
                        iArr[i5] = afc.mo550b(i4, "PPS: slice_group_id [" + i5 + "]f");
                    }
                }
            }
        }
        aew.f738b = afc.mo547a("PPS: num_ref_idx_l0_active_minus1");
        aew.f739c = afc.mo547a("PPS: num_ref_idx_l1_active_minus1");
        aew.f746j = afc.mo552c("PPS: weighted_pred_flag");
        aew.f747k = (int) afc.mo548a(2, "PPS: weighted_bipred_idc");
        aew.f748l = afc.mo551b("PPS: pic_init_qp_minus26");
        aew.f749m = afc.mo551b("PPS: pic_init_qs_minus26");
        aew.f750n = afc.mo551b("PPS: chroma_qp_index_offset");
        aew.f751o = afc.mo552c("PPS: deblocking_filter_control_present_flag");
        aew.f752p = afc.mo552c("PPS: constrained_intra_pred_flag");
        aew.f753q = afc.mo552c("PPS: redundant_pic_cnt_present_flag");
        if (afc.mo541d()) {
            C0024a aVar = new C0024a();
            aew.f759w = aVar;
            aVar.f760a = afc.mo552c("PPS: transform_8x8_mode_flag");
            if (afc.mo552c("PPS: pic_scaling_matrix_present_flag")) {
                for (int i6 = 0; i6 < ((aew.f759w.f760a ? 1 : 0) * true) + 6; i6++) {
                    if (afc.mo552c("PPS: pic_scaling_list_present_flag")) {
                        aew.f759w.f761b.f766a = new aex[8];
                        aew.f759w.f761b.f767b = new aex[8];
                        if (i6 < 6) {
                            aew.f759w.f761b.f766a[i6] = aex.m789a(afc, 16);
                        } else {
                            aew.f759w.f761b.f767b[i6 - 6] = aex.m789a(afc, 64);
                        }
                    }
                }
            }
            aew.f759w.f762c = afc.mo551b("PPS: second_chroma_qp_index_offset");
        }
        afc.mo559l();
        return aew;
    }

    /* renamed from: a */
    public void mo520a(OutputStream outputStream) {
        afe afe = new afe(outputStream);
        afe.mo567a(this.f741e, "PPS: pic_parameter_set_id");
        afe.mo567a(this.f742f, "PPS: seq_parameter_set_id");
        afe.mo569a(this.f737a, "PPS: entropy_coding_mode_flag");
        afe.mo569a(this.f743g, "PPS: pic_order_present_flag");
        afe.mo567a(this.f744h, "PPS: num_slice_groups_minus1");
        if (this.f744h > 0) {
            afe.mo567a(this.f745i, "PPS: slice_group_map_type");
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            int i = this.f745i;
            if (i == 0) {
                for (int i2 = 0; i2 <= this.f744h; i2++) {
                    afe.mo567a(iArr3[i2], "PPS: ");
                }
            } else if (i == 2) {
                for (int i3 = 0; i3 < this.f744h; i3++) {
                    afe.mo567a(iArr[i3], "PPS: ");
                    afe.mo567a(iArr2[i3], "PPS: ");
                }
            } else {
                int i4 = 3;
                if (i == 3 || i == 4 || i == 5) {
                    afe.mo569a(this.f757u, "PPS: slice_group_change_direction_flag");
                    afe.mo567a(this.f740d, "PPS: slice_group_change_rate_minus1");
                } else if (i == 6) {
                    int i5 = this.f744h;
                    if (i5 + 1 <= 4) {
                        i4 = i5 + 1 > 2 ? 2 : 1;
                    }
                    afe.mo567a(this.f758v.length, "PPS: ");
                    int i6 = 0;
                    while (true) {
                        int[] iArr4 = this.f758v;
                        if (i6 > iArr4.length) {
                            break;
                        }
                        afe.mo565a(iArr4[i6], i4);
                        i6++;
                    }
                }
            }
        }
        afe.mo567a(this.f738b, "PPS: num_ref_idx_l0_active_minus1");
        afe.mo567a(this.f739c, "PPS: num_ref_idx_l1_active_minus1");
        afe.mo569a(this.f746j, "PPS: weighted_pred_flag");
        afe.mo568a((long) this.f747k, 2, "PPS: weighted_bipred_idc");
        afe.mo570b(this.f748l, "PPS: pic_init_qp_minus26");
        afe.mo570b(this.f749m, "PPS: pic_init_qs_minus26");
        afe.mo570b(this.f750n, "PPS: chroma_qp_index_offset");
        afe.mo569a(this.f751o, "PPS: deblocking_filter_control_present_flag");
        afe.mo569a(this.f752p, "PPS: constrained_intra_pred_flag");
        afe.mo569a(this.f753q, "PPS: redundant_pic_cnt_present_flag");
        C0024a aVar = this.f759w;
        if (aVar != null) {
            afe.mo569a(aVar.f760a, "PPS: transform_8x8_mode_flag");
            afe.mo569a(this.f759w.f761b != null, "PPS: scalindMatrix");
            if (this.f759w.f761b != null) {
                for (int i7 = 0; i7 < ((this.f759w.f760a ? 1 : 0) * true) + 6; i7++) {
                    if (i7 < 6) {
                        afe.mo569a(this.f759w.f761b.f766a[i7] != null, "PPS: ");
                        if (this.f759w.f761b.f766a[i7] != null) {
                            this.f759w.f761b.f766a[i7].mo530a(afe);
                        }
                    } else {
                        int i8 = i7 - 6;
                        afe.mo569a(this.f759w.f761b.f767b[i8] != null, "PPS: ");
                        if (this.f759w.f761b.f767b[i8] != null) {
                            this.f759w.f761b.f767b[i8].mo530a(afe);
                        }
                    }
                }
            }
            afe.mo570b(this.f759w.f762c, "PPS: ");
        }
        afe.mo571c();
    }

    public int hashCode() {
        int i = 1231;
        int hashCode = (((((((((Arrays.hashCode(this.f755s) + 31) * 31) + this.f750n) * 31) + (this.f752p ? 1231 : 1237)) * 31) + (this.f751o ? 1231 : 1237)) * 31) + (this.f737a ? 1231 : 1237)) * 31;
        C0024a aVar = this.f759w;
        int hashCode2 = (((((((((((((((((((((((((((((((((hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + this.f738b) * 31) + this.f739c) * 31) + this.f744h) * 31) + this.f748l) * 31) + this.f749m) * 31) + (this.f743g ? 1231 : 1237)) * 31) + this.f741e) * 31) + (this.f753q ? 1231 : 1237)) * 31) + Arrays.hashCode(this.f756t)) * 31) + this.f742f) * 31) + (this.f757u ? 1231 : 1237)) * 31) + this.f740d) * 31) + Arrays.hashCode(this.f758v)) * 31) + this.f745i) * 31) + Arrays.hashCode(this.f754r)) * 31) + this.f747k) * 31;
        if (!this.f746j) {
            i = 1237;
        }
        return hashCode2 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aew aew = (aew) obj;
        if (!Arrays.equals(this.f755s, aew.f755s) || this.f750n != aew.f750n || this.f752p != aew.f752p || this.f751o != aew.f751o || this.f737a != aew.f737a) {
            return false;
        }
        C0024a aVar = this.f759w;
        if (aVar == null) {
            if (aew.f759w != null) {
                return false;
            }
        } else if (!aVar.equals(aew.f759w)) {
            return false;
        }
        return this.f738b == aew.f738b && this.f739c == aew.f739c && this.f744h == aew.f744h && this.f748l == aew.f748l && this.f749m == aew.f749m && this.f743g == aew.f743g && this.f741e == aew.f741e && this.f753q == aew.f753q && Arrays.equals(this.f756t, aew.f756t) && this.f742f == aew.f742f && this.f757u == aew.f757u && this.f740d == aew.f740d && Arrays.equals(this.f758v, aew.f758v) && this.f745i == aew.f745i && Arrays.equals(this.f754r, aew.f754r) && this.f747k == aew.f747k && this.f746j == aew.f746j;
    }

    public String toString() {
        return "PictureParameterSet{\n       entropy_coding_mode_flag=" + this.f737a + ",\n       num_ref_idx_l0_active_minus1=" + this.f738b + ",\n       num_ref_idx_l1_active_minus1=" + this.f739c + ",\n       slice_group_change_rate_minus1=" + this.f740d + ",\n       pic_parameter_set_id=" + this.f741e + ",\n       seq_parameter_set_id=" + this.f742f + ",\n       pic_order_present_flag=" + this.f743g + ",\n       num_slice_groups_minus1=" + this.f744h + ",\n       slice_group_map_type=" + this.f745i + ",\n       weighted_pred_flag=" + this.f746j + ",\n       weighted_bipred_idc=" + this.f747k + ",\n       pic_init_qp_minus26=" + this.f748l + ",\n       pic_init_qs_minus26=" + this.f749m + ",\n       chroma_qp_index_offset=" + this.f750n + ",\n       deblocking_filter_control_present_flag=" + this.f751o + ",\n       constrained_intra_pred_flag=" + this.f752p + ",\n       redundant_pic_cnt_present_flag=" + this.f753q + ",\n       top_left=" + this.f754r + ",\n       bottom_right=" + this.f755s + ",\n       run_length_minus1=" + this.f756t + ",\n       slice_group_change_direction_flag=" + this.f757u + ",\n       slice_group_id=" + this.f758v + ",\n       extended=" + this.f759w + '}';
    }
}
