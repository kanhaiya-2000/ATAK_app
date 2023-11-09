package atakplugin.UASTool;

import atakplugin.UASTool.afa;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class aez extends aet {

    /* renamed from: A */
    public boolean f768A;

    /* renamed from: B */
    public int f769B;

    /* renamed from: C */
    public int f770C;

    /* renamed from: D */
    public int f771D;

    /* renamed from: E */
    public boolean f772E;

    /* renamed from: F */
    public boolean f773F;

    /* renamed from: G */
    public boolean f774G;

    /* renamed from: H */
    public int f775H;

    /* renamed from: I */
    public int f776I;

    /* renamed from: J */
    public int f777J;

    /* renamed from: K */
    public int f778K;

    /* renamed from: L */
    public int[] f779L;

    /* renamed from: M */
    public afa f780M;

    /* renamed from: N */
    public aey f781N;

    /* renamed from: O */
    public int f782O;

    /* renamed from: a */
    public int f783a;

    /* renamed from: b */
    public boolean f784b;

    /* renamed from: c */
    public boolean f785c;

    /* renamed from: d */
    public boolean f786d;

    /* renamed from: e */
    public int f787e;

    /* renamed from: f */
    public boolean f788f;

    /* renamed from: g */
    public boolean f789g;

    /* renamed from: h */
    public boolean f790h;

    /* renamed from: i */
    public aeu f791i;

    /* renamed from: j */
    public int f792j;

    /* renamed from: k */
    public int f793k;

    /* renamed from: l */
    public int f794l;

    /* renamed from: m */
    public int f795m;

    /* renamed from: n */
    public int f796n;

    /* renamed from: o */
    public int f797o;

    /* renamed from: p */
    public boolean f798p;

    /* renamed from: q */
    public int f799q;

    /* renamed from: r */
    public long f800r;

    /* renamed from: s */
    public boolean f801s;

    /* renamed from: t */
    public boolean f802t;

    /* renamed from: u */
    public boolean f803u;

    /* renamed from: v */
    public boolean f804v;

    /* renamed from: w */
    public boolean f805w;

    /* renamed from: x */
    public boolean f806x;

    /* renamed from: y */
    public int f807y;

    /* renamed from: z */
    public int f808z;

    /* renamed from: a */
    public static aez m792a(byte[] bArr) {
        return m791a((InputStream) new ByteArrayInputStream(bArr));
    }

    /* renamed from: a */
    public static aez m791a(InputStream inputStream) {
        afc afc = new afc(inputStream);
        aez aez = new aez();
        aez.f799q = (int) afc.mo548a(8, "SPS: profile_idc");
        aez.f801s = afc.mo552c("SPS: constraint_set_0_flag");
        aez.f802t = afc.mo552c("SPS: constraint_set_1_flag");
        aez.f803u = afc.mo552c("SPS: constraint_set_2_flag");
        aez.f804v = afc.mo552c("SPS: constraint_set_3_flag");
        aez.f805w = afc.mo552c("SPS: constraint_set_4_flag");
        aez.f806x = afc.mo552c("SPS: constraint_set_5_flag");
        aez.f800r = afc.mo548a(2, "SPS: reserved_zero_2bits");
        aez.f807y = (int) afc.mo548a(8, "SPS: level_idc");
        aez.f808z = afc.mo547a("SPS: seq_parameter_set_id");
        int i = aez.f799q;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            aeu a = aeu.m782a(afc.mo547a("SPS: chroma_format_idc"));
            aez.f791i = a;
            if (a == aeu.f723d) {
                aez.f768A = afc.mo552c("SPS: residual_color_transform_flag");
            }
            aez.f796n = afc.mo547a("SPS: bit_depth_luma_minus8");
            aez.f797o = afc.mo547a("SPS: bit_depth_chroma_minus8");
            aez.f798p = afc.mo552c("SPS: qpprime_y_zero_transform_bypass_flag");
            if (afc.mo552c("SPS: seq_scaling_matrix_present_lag")) {
                m796a(afc, aez);
            }
        } else {
            aez.f791i = aeu.f721b;
        }
        aez.f792j = afc.mo547a("SPS: log2_max_frame_num_minus4");
        int a2 = afc.mo547a("SPS: pic_order_cnt_type");
        aez.f783a = a2;
        if (a2 == 0) {
            aez.f793k = afc.mo547a("SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (a2 == 1) {
            aez.f785c = afc.mo552c("SPS: delta_pic_order_always_zero_flag");
            aez.f769B = afc.mo551b("SPS: offset_for_non_ref_pic");
            aez.f770C = afc.mo551b("SPS: offset_for_top_to_bottom_field");
            int a3 = afc.mo547a("SPS: num_ref_frames_in_pic_order_cnt_cycle");
            aez.f782O = a3;
            aez.f779L = new int[a3];
            for (int i2 = 0; i2 < aez.f782O; i2++) {
                int[] iArr = aez.f779L;
                iArr[i2] = afc.mo551b("SPS: offsetForRefFrame [" + i2 + "]");
            }
        }
        aez.f771D = afc.mo547a("SPS: num_ref_frames");
        aez.f772E = afc.mo552c("SPS: gaps_in_frame_num_value_allowed_flag");
        aez.f795m = afc.mo547a("SPS: pic_width_in_mbs_minus1");
        aez.f794l = afc.mo547a("SPS: pic_height_in_map_units_minus1");
        boolean c = afc.mo552c("SPS: frame_mbs_only_flag");
        aez.f773F = c;
        if (!c) {
            aez.f789g = afc.mo552c("SPS: mb_adaptive_frame_field_flag");
        }
        aez.f790h = afc.mo552c("SPS: direct_8x8_inference_flag");
        boolean c2 = afc.mo552c("SPS: frame_cropping_flag");
        aez.f774G = c2;
        if (c2) {
            aez.f775H = afc.mo547a("SPS: frame_crop_left_offset");
            aez.f776I = afc.mo547a("SPS: frame_crop_right_offset");
            aez.f777J = afc.mo547a("SPS: frame_crop_top_offset");
            aez.f778K = afc.mo547a("SPS: frame_crop_bottom_offset");
        }
        if (afc.mo552c("SPS: vui_parameters_present_flag")) {
            aez.f780M = m793a(afc);
        }
        afc.mo559l();
        return aez;
    }

    /* renamed from: a */
    private static void m796a(afc afc, aez aez) {
        aez.f781N = new aey();
        for (int i = 0; i < 8; i++) {
            if (afc.mo552c("SPS: seqScalingListPresentFlag")) {
                aez.f781N.f766a = new aex[8];
                aez.f781N.f767b = new aex[8];
                if (i < 6) {
                    aez.f781N.f766a[i] = aex.m789a(afc, 16);
                } else {
                    aez.f781N.f767b[i - 6] = aex.m789a(afc, 64);
                }
            }
        }
    }

    /* renamed from: a */
    private static afa m793a(afc afc) {
        afa afa = new afa();
        afa.f811a = afc.mo552c("VUI: aspect_ratio_info_present_flag");
        if (afa.f811a) {
            afa.f835y = aes.m779a((int) afc.mo548a(8, "VUI: aspect_ratio"));
            if (afa.f835y == aes.f718a) {
                afa.f812b = (int) afc.mo548a(16, "VUI: sar_width");
                afa.f813c = (int) afc.mo548a(16, "VUI: sar_height");
            }
        }
        afa.f814d = afc.mo552c("VUI: overscan_info_present_flag");
        if (afa.f814d) {
            afa.f815e = afc.mo552c("VUI: overscan_appropriate_flag");
        }
        afa.f816f = afc.mo552c("VUI: video_signal_type_present_flag");
        if (afa.f816f) {
            afa.f817g = (int) afc.mo548a(3, "VUI: video_format");
            afa.f818h = afc.mo552c("VUI: video_full_range_flag");
            afa.f819i = afc.mo552c("VUI: colour_description_present_flag");
            if (afa.f819i) {
                afa.f820j = (int) afc.mo548a(8, "VUI: colour_primaries");
                afa.f821k = (int) afc.mo548a(8, "VUI: transfer_characteristics");
                afa.f822l = (int) afc.mo548a(8, "VUI: matrix_coefficients");
            }
        }
        afa.f823m = afc.mo552c("VUI: chroma_loc_info_present_flag");
        if (afa.f823m) {
            afa.f824n = afc.mo547a("VUI chroma_sample_loc_type_top_field");
            afa.f825o = afc.mo547a("VUI chroma_sample_loc_type_bottom_field");
        }
        afa.f826p = afc.mo552c("VUI: timing_info_present_flag");
        if (afa.f826p) {
            afa.f827q = (int) afc.mo548a(32, "VUI: num_units_in_tick");
            afa.f828r = (int) afc.mo548a(32, "VUI: time_scale");
            afa.f829s = afc.mo552c("VUI: fixed_frame_rate_flag");
        }
        boolean c = afc.mo552c("VUI: nal_hrd_parameters_present_flag");
        if (c) {
            afa.f832v = m797b(afc);
        }
        boolean c2 = afc.mo552c("VUI: vcl_hrd_parameters_present_flag");
        if (c2) {
            afa.f833w = m797b(afc);
        }
        if (c || c2) {
            afa.f830t = afc.mo552c("VUI: low_delay_hrd_flag");
        }
        afa.f831u = afc.mo552c("VUI: pic_struct_present_flag");
        if (afc.mo552c("VUI: bitstream_restriction_flag")) {
            afa.f834x = new afa.C0026a();
            afa.f834x.f836a = afc.mo552c("VUI: motion_vectors_over_pic_boundaries_flag");
            afa.f834x.f837b = afc.mo547a("VUI max_bytes_per_pic_denom");
            afa.f834x.f838c = afc.mo547a("VUI max_bits_per_mb_denom");
            afa.f834x.f839d = afc.mo547a("VUI log2_max_mv_length_horizontal");
            afa.f834x.f840e = afc.mo547a("VUI log2_max_mv_length_vertical");
            afa.f834x.f841f = afc.mo547a("VUI num_reorder_frames");
            afa.f834x.f842g = afc.mo547a("VUI max_dec_frame_buffering");
        }
        return afa;
    }

    /* renamed from: b */
    private static aev m797b(afc afc) {
        aev aev = new aev();
        aev.f727a = afc.mo547a("SPS: cpb_cnt_minus1");
        aev.f728b = (int) afc.mo548a(4, "HRD: bit_rate_scale");
        aev.f729c = (int) afc.mo548a(4, "HRD: cpb_size_scale");
        aev.f730d = new int[(aev.f727a + 1)];
        aev.f731e = new int[(aev.f727a + 1)];
        aev.f732f = new boolean[(aev.f727a + 1)];
        for (int i = 0; i <= aev.f727a; i++) {
            aev.f730d[i] = afc.mo547a("HRD: bit_rate_value_minus1");
            aev.f731e[i] = afc.mo547a("HRD: cpb_size_value_minus1");
            aev.f732f[i] = afc.mo552c("HRD: cbr_flag");
        }
        aev.f733g = (int) afc.mo548a(5, "HRD: initial_cpb_removal_delay_length_minus1");
        aev.f734h = (int) afc.mo548a(5, "HRD: cpb_removal_delay_length_minus1");
        aev.f735i = (int) afc.mo548a(5, "HRD: dpb_output_delay_length_minus1");
        aev.f736j = (int) afc.mo548a(5, "HRD: time_offset_length");
        return aev;
    }

    /* renamed from: a */
    public void mo520a(OutputStream outputStream) {
        afe afe = new afe(outputStream);
        afe.mo568a((long) this.f799q, 8, "SPS: profile_idc");
        afe.mo569a(this.f801s, "SPS: constraint_set_0_flag");
        afe.mo569a(this.f802t, "SPS: constraint_set_1_flag");
        afe.mo569a(this.f803u, "SPS: constraint_set_2_flag");
        afe.mo569a(this.f804v, "SPS: constraint_set_3_flag");
        afe.mo568a(0, 4, "SPS: reserved");
        afe.mo568a((long) this.f807y, 8, "SPS: level_idc");
        afe.mo567a(this.f808z, "SPS: seq_parameter_set_id");
        int i = this.f799q;
        boolean z = false;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            afe.mo567a(this.f791i.mo521a(), "SPS: chroma_format_idc");
            if (this.f791i == aeu.f723d) {
                afe.mo569a(this.f768A, "SPS: residual_color_transform_flag");
            }
            afe.mo567a(this.f796n, "SPS: ");
            afe.mo567a(this.f797o, "SPS: ");
            afe.mo569a(this.f798p, "SPS: qpprime_y_zero_transform_bypass_flag");
            afe.mo569a(this.f781N != null, "SPS: ");
            if (this.f781N != null) {
                for (int i2 = 0; i2 < 8; i2++) {
                    if (i2 < 6) {
                        afe.mo569a(this.f781N.f766a[i2] != null, "SPS: ");
                        if (this.f781N.f766a[i2] != null) {
                            this.f781N.f766a[i2].mo530a(afe);
                        }
                    } else {
                        int i3 = i2 - 6;
                        afe.mo569a(this.f781N.f767b[i3] != null, "SPS: ");
                        if (this.f781N.f767b[i3] != null) {
                            this.f781N.f767b[i3].mo530a(afe);
                        }
                    }
                }
            }
        }
        afe.mo567a(this.f792j, "SPS: log2_max_frame_num_minus4");
        afe.mo567a(this.f783a, "SPS: pic_order_cnt_type");
        int i4 = this.f783a;
        if (i4 == 0) {
            afe.mo567a(this.f793k, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (i4 == 1) {
            afe.mo569a(this.f785c, "SPS: delta_pic_order_always_zero_flag");
            afe.mo570b(this.f769B, "SPS: offset_for_non_ref_pic");
            afe.mo570b(this.f770C, "SPS: offset_for_top_to_bottom_field");
            afe.mo567a(this.f779L.length, "SPS: ");
            int i5 = 0;
            while (true) {
                int[] iArr = this.f779L;
                if (i5 >= iArr.length) {
                    break;
                }
                afe.mo570b(iArr[i5], "SPS: ");
                i5++;
            }
        }
        afe.mo567a(this.f771D, "SPS: num_ref_frames");
        afe.mo569a(this.f772E, "SPS: gaps_in_frame_num_value_allowed_flag");
        afe.mo567a(this.f795m, "SPS: pic_width_in_mbs_minus1");
        afe.mo567a(this.f794l, "SPS: pic_height_in_map_units_minus1");
        afe.mo569a(this.f773F, "SPS: frame_mbs_only_flag");
        if (!this.f773F) {
            afe.mo569a(this.f789g, "SPS: mb_adaptive_frame_field_flag");
        }
        afe.mo569a(this.f790h, "SPS: direct_8x8_inference_flag");
        afe.mo569a(this.f774G, "SPS: frame_cropping_flag");
        if (this.f774G) {
            afe.mo567a(this.f775H, "SPS: frame_crop_left_offset");
            afe.mo567a(this.f776I, "SPS: frame_crop_right_offset");
            afe.mo567a(this.f777J, "SPS: frame_crop_top_offset");
            afe.mo567a(this.f778K, "SPS: frame_crop_bottom_offset");
        }
        if (this.f780M != null) {
            z = true;
        }
        afe.mo569a(z, "SPS: ");
        afa afa = this.f780M;
        if (afa != null) {
            m795a(afa, afe);
        }
        afe.mo571c();
    }

    /* renamed from: a */
    private void m795a(afa afa, afe afe) {
        afe.mo569a(afa.f811a, "VUI: aspect_ratio_info_present_flag");
        if (afa.f811a) {
            afe.mo568a((long) afa.f835y.mo518a(), 8, "VUI: aspect_ratio");
            if (afa.f835y == aes.f718a) {
                afe.mo568a((long) afa.f812b, 16, "VUI: sar_width");
                afe.mo568a((long) afa.f813c, 16, "VUI: sar_height");
            }
        }
        afe.mo569a(afa.f814d, "VUI: overscan_info_present_flag");
        if (afa.f814d) {
            afe.mo569a(afa.f815e, "VUI: overscan_appropriate_flag");
        }
        afe.mo569a(afa.f816f, "VUI: video_signal_type_present_flag");
        if (afa.f816f) {
            afe.mo568a((long) afa.f817g, 3, "VUI: video_format");
            afe.mo569a(afa.f818h, "VUI: video_full_range_flag");
            afe.mo569a(afa.f819i, "VUI: colour_description_present_flag");
            if (afa.f819i) {
                afe.mo568a((long) afa.f820j, 8, "VUI: colour_primaries");
                afe.mo568a((long) afa.f821k, 8, "VUI: transfer_characteristics");
                afe.mo568a((long) afa.f822l, 8, "VUI: matrix_coefficients");
            }
        }
        afe.mo569a(afa.f823m, "VUI: chroma_loc_info_present_flag");
        if (afa.f823m) {
            afe.mo567a(afa.f824n, "VUI: chroma_sample_loc_type_top_field");
            afe.mo567a(afa.f825o, "VUI: chroma_sample_loc_type_bottom_field");
        }
        afe.mo569a(afa.f826p, "VUI: timing_info_present_flag");
        if (afa.f826p) {
            afe.mo568a((long) afa.f827q, 32, "VUI: num_units_in_tick");
            afe.mo568a((long) afa.f828r, 32, "VUI: time_scale");
            afe.mo569a(afa.f829s, "VUI: fixed_frame_rate_flag");
        }
        boolean z = true;
        afe.mo569a(afa.f832v != null, "VUI: ");
        if (afa.f832v != null) {
            m794a(afa.f832v, afe);
        }
        afe.mo569a(afa.f833w != null, "VUI: ");
        if (afa.f833w != null) {
            m794a(afa.f833w, afe);
        }
        if (!(afa.f832v == null && afa.f833w == null)) {
            afe.mo569a(afa.f830t, "VUI: low_delay_hrd_flag");
        }
        afe.mo569a(afa.f831u, "VUI: pic_struct_present_flag");
        if (afa.f834x == null) {
            z = false;
        }
        afe.mo569a(z, "VUI: ");
        if (afa.f834x != null) {
            afe.mo569a(afa.f834x.f836a, "VUI: motion_vectors_over_pic_boundaries_flag");
            afe.mo567a(afa.f834x.f837b, "VUI: max_bytes_per_pic_denom");
            afe.mo567a(afa.f834x.f838c, "VUI: max_bits_per_mb_denom");
            afe.mo567a(afa.f834x.f839d, "VUI: log2_max_mv_length_horizontal");
            afe.mo567a(afa.f834x.f840e, "VUI: log2_max_mv_length_vertical");
            afe.mo567a(afa.f834x.f841f, "VUI: num_reorder_frames");
            afe.mo567a(afa.f834x.f842g, "VUI: max_dec_frame_buffering");
        }
    }

    /* renamed from: a */
    private void m794a(aev aev, afe afe) {
        afe.mo567a(aev.f727a, "HRD: cpb_cnt_minus1");
        afe.mo568a((long) aev.f728b, 4, "HRD: bit_rate_scale");
        afe.mo568a((long) aev.f729c, 4, "HRD: cpb_size_scale");
        for (int i = 0; i <= aev.f727a; i++) {
            afe.mo567a(aev.f730d[i], "HRD: ");
            afe.mo567a(aev.f731e[i], "HRD: ");
            afe.mo569a(aev.f732f[i], "HRD: ");
        }
        afe.mo568a((long) aev.f733g, 5, "HRD: initial_cpb_removal_delay_length_minus1");
        afe.mo568a((long) aev.f734h, 5, "HRD: cpb_removal_delay_length_minus1");
        afe.mo568a((long) aev.f735i, 5, "HRD: dpb_output_delay_length_minus1");
        afe.mo568a((long) aev.f736j, 5, "HRD: time_offset_length");
    }

    public String toString() {
        return "SeqParameterSet{ \n        pic_order_cnt_type=" + this.f783a + ", \n        field_pic_flag=" + this.f784b + ", \n        delta_pic_order_always_zero_flag=" + this.f785c + ", \n        weighted_pred_flag=" + this.f786d + ", \n        weighted_bipred_idc=" + this.f787e + ", \n        entropy_coding_mode_flag=" + this.f788f + ", \n        mb_adaptive_frame_field_flag=" + this.f789g + ", \n        direct_8x8_inference_flag=" + this.f790h + ", \n        chroma_format_idc=" + this.f791i + ", \n        log2_max_frame_num_minus4=" + this.f792j + ", \n        log2_max_pic_order_cnt_lsb_minus4=" + this.f793k + ", \n        pic_height_in_map_units_minus1=" + this.f794l + ", \n        pic_width_in_mbs_minus1=" + this.f795m + ", \n        bit_depth_luma_minus8=" + this.f796n + ", \n        bit_depth_chroma_minus8=" + this.f797o + ", \n        qpprime_y_zero_transform_bypass_flag=" + this.f798p + ", \n        profile_idc=" + this.f799q + ", \n        constraint_set_0_flag=" + this.f801s + ", \n        constraint_set_1_flag=" + this.f802t + ", \n        constraint_set_2_flag=" + this.f803u + ", \n        constraint_set_3_flag=" + this.f804v + ", \n        constraint_set_4_flag=" + this.f805w + ", \n        constraint_set_5_flag=" + this.f806x + ", \n        level_idc=" + this.f807y + ", \n        seq_parameter_set_id=" + this.f808z + ", \n        residual_color_transform_flag=" + this.f768A + ", \n        offset_for_non_ref_pic=" + this.f769B + ", \n        offset_for_top_to_bottom_field=" + this.f770C + ", \n        num_ref_frames=" + this.f771D + ", \n        gaps_in_frame_num_value_allowed_flag=" + this.f772E + ", \n        frame_mbs_only_flag=" + this.f773F + ", \n        frame_cropping_flag=" + this.f774G + ", \n        frame_crop_left_offset=" + this.f775H + ", \n        frame_crop_right_offset=" + this.f776I + ", \n        frame_crop_top_offset=" + this.f777J + ", \n        frame_crop_bottom_offset=" + this.f778K + ", \n        offsetForRefFrame=" + this.f779L + ", \n        vuiParams=" + this.f780M + ", \n        scalingMatrix=" + this.f781N + ", \n        num_ref_frames_in_pic_order_cnt_cycle=" + this.f782O + '}';
    }
}
