package atakplugin.UASTool;

import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.zs */
public class C1104zs {

    /* renamed from: a */
    ByteBuffer f8093a;

    /* renamed from: b */
    int f8094b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: boolean[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1104zs(java.nio.ByteBuffer r15) {
        /*
            r14 = this;
            r14.<init>()
            r14.f8093a = r15
            atakplugin.UASTool.afc r0 = new atakplugin.UASTool.afc
            atakplugin.UASTool.afh r1 = new atakplugin.UASTool.afh
            r2 = 0
            java.nio.Buffer r15 = r15.position(r2)
            java.nio.ByteBuffer r15 = (java.nio.ByteBuffer) r15
            r1.<init>(r15)
            java.io.InputStream r15 = java.nio.channels.Channels.newInputStream(r1)
            r0.<init>(r15)
            r15 = 4
            java.lang.String r1 = "vps_parameter_set_id"
            int r15 = r0.mo550b(r15, r1)
            r14.f8094b = r15
            r15 = 2
            java.lang.String r1 = "vps_reserved_three_2bits"
            r0.mo550b(r15, r1)
            r1 = 6
            java.lang.String r3 = "vps_max_layers_minus1"
            r0.mo550b(r1, r3)
            r3 = 3
            java.lang.String r4 = "vps_max_sub_layers_minus1"
            int r3 = r0.mo550b(r3, r4)
            java.lang.String r4 = "vps_temporal_id_nesting_flag"
            r0.mo552c((java.lang.String) r4)
            r4 = 16
            java.lang.String r5 = "vps_reserved_0xffff_16bits"
            r0.mo550b(r4, r5)
            r14.mo6342a(r3, r0)
            java.lang.String r4 = "vps_sub_layer_ordering_info_present_flag"
            boolean r4 = r0.mo552c((java.lang.String) r4)
            r5 = 1
            if (r4 == 0) goto L_0x0050
            r6 = 1
            goto L_0x0052
        L_0x0050:
            int r6 = r3 + 1
        L_0x0052:
            int[] r6 = new int[r6]
            if (r4 == 0) goto L_0x0058
            r7 = 1
            goto L_0x005a
        L_0x0058:
            int r7 = r3 + 1
        L_0x005a:
            int[] r7 = new int[r7]
            if (r4 == 0) goto L_0x0060
            r8 = 1
            goto L_0x0062
        L_0x0060:
            int r8 = r3 + 1
        L_0x0062:
            int[] r8 = new int[r8]
            if (r4 == 0) goto L_0x0068
            r4 = 0
            goto L_0x0069
        L_0x0068:
            r4 = r3
        L_0x0069:
            java.lang.String r9 = "]"
            if (r4 <= r3) goto L_0x0139
            java.lang.String r4 = "vps_max_layer_id"
            int r10 = r0.mo550b(r1, r4)
            java.lang.String r1 = "vps_num_layer_sets_minus1"
            int r11 = r0.mo547a(r1)
            int[] r15 = new int[r15]
            r15[r5] = r10
            r15[r2] = r11
            java.lang.Class<boolean> r1 = boolean.class
            java.lang.Object r15 = java.lang.reflect.Array.newInstance(r1, r15)
            r12 = r15
            boolean[][] r12 = (boolean[][]) r12
            r13 = 1
        L_0x0089:
            if (r13 <= r11) goto L_0x010e
            java.lang.String r15 = "vps_timing_info_present_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x00f5
            r15 = 32
            java.lang.String r1 = "vps_num_units_in_tick"
            r0.mo550b(r15, r1)
            java.lang.String r1 = "vps_time_scale"
            r0.mo550b(r15, r1)
            java.lang.String r15 = "vps_poc_proportional_to_timing_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x00ac
            java.lang.String r15 = "vps_num_ticks_poc_diff_one_minus1"
            r0.mo547a(r15)
        L_0x00ac:
            java.lang.String r15 = "vps_num_hrd_parameters"
            int r15 = r0.mo547a(r15)
            int[] r1 = new int[r15]
            boolean[] r4 = new boolean[r15]
            r6 = 0
        L_0x00b7:
            if (r6 < r15) goto L_0x00ba
            goto L_0x00f5
        L_0x00ba:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "hrd_layer_set_idx["
            r7.<init>(r8)
            r7.append(r6)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            int r7 = r0.mo547a(r7)
            r1[r6] = r7
            if (r6 <= 0) goto L_0x00eb
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "cprms_present_flag["
            r7.<init>(r8)
            r7.append(r6)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            boolean r7 = r0.mo552c((java.lang.String) r7)
            r4[r6] = r7
            goto L_0x00ed
        L_0x00eb:
            r4[r2] = r5
        L_0x00ed:
            boolean r7 = r4[r6]
            r14.m14991a(r7, r3, r0)
            int r6 = r6 + 1
            goto L_0x00b7
        L_0x00f5:
            java.lang.String r15 = "vps_extension_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x010a
        L_0x00fd:
            boolean r15 = r0.mo541d()
            if (r15 != 0) goto L_0x0104
            goto L_0x010a
        L_0x0104:
            java.lang.String r15 = "vps_extension_data_flag"
            r0.mo552c((java.lang.String) r15)
            goto L_0x00fd
        L_0x010a:
            r0.mo559l()
            return
        L_0x010e:
            r15 = 0
        L_0x010f:
            if (r15 <= r10) goto L_0x0115
            int r13 = r13 + 1
            goto L_0x0089
        L_0x0115:
            r1 = r12[r13]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "layer_id_included_flag["
            r4.<init>(r6)
            r4.append(r13)
            java.lang.String r6 = "]["
            r4.append(r6)
            r4.append(r15)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            boolean r4 = r0.mo552c((java.lang.String) r4)
            r1[r15] = r4
            int r15 = r15 + 1
            goto L_0x010f
        L_0x0139:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "vps_max_dec_pic_buffering_minus1["
            r10.<init>(r11)
            r10.append(r4)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            int r10 = r0.mo547a(r10)
            r6[r4] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r11)
            r10.append(r4)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            int r10 = r0.mo547a(r10)
            r7[r4] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r11)
            r10.append(r4)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            int r9 = r0.mo547a(r9)
            r8[r4] = r9
            int r4 = r4 + 1
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1104zs.<init>(java.nio.ByteBuffer):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: boolean[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6342a(int r20, atakplugin.UASTool.afc r21) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            r2 = 2
            java.lang.String r3 = "general_profile_space "
            r1.mo550b(r2, r3)
            java.lang.String r3 = "general_tier_flag"
            r1.mo552c((java.lang.String) r3)
            r3 = 5
            java.lang.String r4 = "general_profile_idc"
            r1.mo550b(r3, r4)
            r4 = 32
            boolean[] r5 = new boolean[r4]
            r6 = 0
            r7 = 0
        L_0x001b:
            java.lang.String r8 = "]"
            if (r7 < r4) goto L_0x01b4
            java.lang.String r5 = "general_progressive_source_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_interlaced_source_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_non_packed_constraint_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_frame_only_constraint_flag"
            r1.mo552c((java.lang.String) r5)
            r9 = 44
            java.lang.String r5 = "general_reserved_zero_44bits"
            r1.mo550b(r9, r5)
            r10 = 8
            java.lang.String r5 = "general_level_idc"
            r1.mo550b(r10, r5)
            boolean[] r11 = new boolean[r0]
            boolean[] r12 = new boolean[r0]
            r5 = 0
        L_0x0046:
            if (r5 < r0) goto L_0x0175
            if (r0 <= 0) goto L_0x0056
            r5 = r0
        L_0x004b:
            if (r5 < r10) goto L_0x004e
            goto L_0x0056
        L_0x004e:
            java.lang.String r7 = "reserved_zero_2bits"
            r1.mo550b(r2, r7)
            int r5 = r5 + 1
            goto L_0x004b
        L_0x0056:
            int[] r7 = new int[r0]
            boolean[] r13 = new boolean[r0]
            int[] r14 = new int[r0]
            int[] r5 = new int[r2]
            r15 = 1
            r5[r15] = r4
            r5[r6] = r0
            java.lang.Class<boolean> r15 = boolean.class
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r15, r5)
            r15 = r5
            boolean[][] r15 = (boolean[][]) r15
            boolean[] r5 = new boolean[r0]
            boolean[] r6 = new boolean[r0]
            boolean[] r10 = new boolean[r0]
            boolean[] r9 = new boolean[r0]
            int[] r4 = new int[r0]
            r3 = 0
        L_0x0077:
            if (r3 < r0) goto L_0x007a
            return
        L_0x007a:
            boolean r17 = r11[r3]
            if (r17 == 0) goto L_0x0159
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "sub_layer_profile_space["
            r2.<init>(r0)
            r2.append(r3)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
            r2 = 2
            int r0 = r1.mo550b(r2, r0)
            r7[r3] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_tier_flag["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r13[r3] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_profile_idc["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r0 = r1.mo550b(r2, r0)
            r14[r3] = r0
            r0 = 0
        L_0x00c6:
            r2 = 32
            if (r0 < r2) goto L_0x012e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_progressive_source_flag["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r5[r3] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_interlaced_source_flag["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r6[r3] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_non_packed_constraint_flag["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r10[r3] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_frame_only_constraint_flag["
            r0.<init>(r2)
            r0.append(r3)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r9[r3] = r0
            java.lang.String r0 = "reserved"
            r2 = 44
            r1.mo548a((int) r2, (java.lang.String) r0)
            goto L_0x0159
        L_0x012e:
            r2 = 44
            r16 = r15[r3]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r18 = r5
            java.lang.String r5 = "sub_layer_profile_compatibility_flag["
            r2.<init>(r5)
            r2.append(r3)
            java.lang.String r5 = "]["
            r2.append(r5)
            r2.append(r0)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            boolean r2 = r1.mo552c((java.lang.String) r2)
            r16[r0] = r2
            int r0 = r0 + 1
            r5 = r18
            goto L_0x00c6
        L_0x0159:
            r18 = r5
            boolean r0 = r12[r3]
            if (r0 == 0) goto L_0x016a
            java.lang.String r0 = "sub_layer_level_idc"
            r2 = 8
            int r0 = r1.mo550b(r2, r0)
            r4[r3] = r0
            goto L_0x016c
        L_0x016a:
            r2 = 8
        L_0x016c:
            int r3 = r3 + 1
            r0 = r20
            r5 = r18
            r2 = 2
            goto L_0x0077
        L_0x0175:
            r2 = 8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "sub_layer_profile_present_flag["
            r0.<init>(r3)
            r0.append(r5)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r11[r5] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "sub_layer_level_present_flag["
            r0.<init>(r3)
            r0.append(r5)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r12[r5] = r0
            int r5 = r5 + 1
            r0 = r20
            r2 = 2
            r3 = 5
            r4 = 32
            r6 = 0
            r9 = 44
            r10 = 8
            goto L_0x0046
        L_0x01b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "general_profile_compatibility_flag["
            r0.<init>(r2)
            r0.append(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r5[r7] = r0
            int r7 = r7 + 1
            r0 = r20
            r2 = 2
            r3 = 5
            r4 = 32
            r6 = 0
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1104zs.mo6342a(int, atakplugin.UASTool.afc):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14991a(boolean r12, int r13, atakplugin.UASTool.afc r14) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0054
            java.lang.String r12 = "nal_hrd_parameters_present_flag"
            boolean r12 = r14.mo552c((java.lang.String) r12)
            java.lang.String r1 = "vcl_hrd_parameters_present_flag"
            boolean r1 = r14.mo552c((java.lang.String) r1)
            if (r12 != 0) goto L_0x0013
            if (r1 == 0) goto L_0x0056
        L_0x0013:
            java.lang.String r2 = "sub_pic_hrd_params_present_flag"
            boolean r2 = r14.mo552c((java.lang.String) r2)
            r3 = 5
            if (r2 == 0) goto L_0x0032
            r4 = 8
            java.lang.String r5 = "tick_divisor_minus2"
            r14.mo550b(r4, r5)
            java.lang.String r4 = "du_cpb_removal_delay_increment_length_minus1"
            r14.mo550b(r3, r4)
            java.lang.String r4 = "sub_pic_cpb_params_in_pic_timing_sei_flag"
            r14.mo552c((java.lang.String) r4)
            java.lang.String r4 = "dpb_output_delay_du_length_minus1"
            r14.mo550b(r3, r4)
        L_0x0032:
            r4 = 4
            java.lang.String r5 = "bit_rate_scale"
            r14.mo550b(r4, r5)
            java.lang.String r5 = "cpb_size_scale"
            r14.mo550b(r4, r5)
            if (r2 == 0) goto L_0x0044
            java.lang.String r5 = "cpb_size_du_scale"
            r14.mo550b(r4, r5)
        L_0x0044:
            java.lang.String r4 = "initial_cpb_removal_delay_length_minus1"
            r14.mo550b(r3, r4)
            java.lang.String r4 = "au_cpb_removal_delay_length_minus1"
            r14.mo550b(r3, r4)
            java.lang.String r4 = "dpb_output_delay_length_minus1"
            r14.mo550b(r3, r4)
            goto L_0x0057
        L_0x0054:
            r12 = 0
            r1 = 0
        L_0x0056:
            r2 = 0
        L_0x0057:
            boolean[] r3 = new boolean[r13]
            boolean[] r4 = new boolean[r13]
            boolean[] r5 = new boolean[r13]
            int[] r6 = new int[r13]
            int[] r7 = new int[r13]
        L_0x0061:
            if (r0 <= r13) goto L_0x0064
            return
        L_0x0064:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "fixed_pic_rate_general_flag["
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = "]"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r8 = r14.mo552c((java.lang.String) r8)
            r3[r0] = r8
            boolean r8 = r3[r0]
            if (r8 != 0) goto L_0x0098
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "fixed_pic_rate_within_cvs_flag["
            r8.<init>(r10)
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r8 = r14.mo552c((java.lang.String) r8)
            r4[r0] = r8
        L_0x0098:
            boolean r8 = r4[r0]
            if (r8 == 0) goto L_0x00b4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "elemental_duration_in_tc_minus1["
            r8.<init>(r10)
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int r8 = r14.mo547a(r8)
            r7[r0] = r8
            goto L_0x00cb
        L_0x00b4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "low_delay_hrd_flag["
            r8.<init>(r10)
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r8 = r14.mo552c((java.lang.String) r8)
            r5[r0] = r8
        L_0x00cb:
            boolean r8 = r5[r0]
            if (r8 != 0) goto L_0x00e6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "cpb_cnt_minus1["
            r8.<init>(r10)
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int r8 = r14.mo547a(r8)
            r6[r0] = r8
        L_0x00e6:
            if (r12 == 0) goto L_0x00ed
            r8 = r6[r0]
            r11.mo6341a(r0, r8, r2, r14)
        L_0x00ed:
            if (r1 == 0) goto L_0x00f4
            r8 = r6[r0]
            r11.mo6341a(r0, r8, r2, r14)
        L_0x00f4:
            int r0 = r0 + 1
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1104zs.m14991a(boolean, int, atakplugin.UASTool.afc):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6341a(int i, int i2, boolean z, afc afc) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        boolean[] zArr = new boolean[i2];
        for (int i3 = 0; i3 <= i2; i3++) {
            iArr[i3] = afc.mo547a("bit_rate_value_minus1[" + i3 + "]");
            iArr2[i3] = afc.mo547a("cpb_size_value_minus1[" + i3 + "]");
            if (z) {
                iArr3[i3] = afc.mo547a("cpb_size_du_value_minus1[" + i3 + "]");
                iArr4[i3] = afc.mo547a("bit_rate_du_value_minus1[" + i3 + "]");
            }
            zArr[i3] = afc.mo552c("cbr_flag[" + i3 + "]");
        }
    }

    /* renamed from: a */
    public ByteBuffer mo6340a() {
        return this.f8093a;
    }
}
