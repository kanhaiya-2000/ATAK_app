package atakplugin.UASTool;

import java.io.InputStream;

/* renamed from: atakplugin.UASTool.zr */
public class C1103zr {
    public C1103zr(InputStream inputStream) {
        afc afc = new afc(inputStream);
        afc.mo548a(4, "sps_video_parameter_set_id");
        int a = (int) afc.mo548a(3, "sps_max_sub_layers_minus1");
        afc.mo552c("sps_temporal_id_nesting_flag");
        m14989a(a, afc);
        afc.mo547a("sps_seq_parameter_set_id");
        if (afc.mo547a("chroma_format_idc") == 3) {
            afc.mo538b();
            afc.mo547a("pic_width_in_luma_samples");
            afc.mo547a("pic_width_in_luma_samples");
            if (afc.mo552c("conformance_window_flag")) {
                afc.mo547a("conf_win_left_offset");
                afc.mo547a("conf_win_right_offset");
                afc.mo547a("conf_win_top_offset");
                afc.mo547a("conf_win_bottom_offset");
            }
        }
        afc.mo547a("bit_depth_luma_minus8");
        afc.mo547a("bit_depth_chroma_minus8");
        afc.mo547a("log2_max_pic_order_cnt_lsb_minus4");
        boolean c = afc.mo552c("sps_sub_layer_ordering_info_present_flag");
        int i = 0;
        int i2 = (a - (c ? 0 : a)) + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        for (i = !c ? a : i; i <= a; i++) {
            iArr[i] = afc.mo547a("sps_max_dec_pic_buffering_minus1[" + i + "]");
            iArr2[i] = afc.mo547a("sps_max_num_reorder_pics[" + i + "]");
            iArr3[i] = afc.mo547a("sps_max_latency_increase_plus1[" + i + "]");
        }
        afc.mo547a("log2_min_luma_coding_block_size_minus3");
        afc.mo547a("log2_diff_max_min_luma_coding_block_size");
        afc.mo547a("log2_min_transform_block_size_minus2");
        afc.mo547a("log2_diff_max_min_transform_block_size");
        afc.mo547a("max_transform_hierarchy_depth_inter");
        afc.mo547a("max_transform_hierarchy_depth_intra");
        if (afc.mo552c("scaling_list_enabled_flag") && afc.mo552c("sps_scaling_list_data_present_flag")) {
            m14990a(afc);
        }
        afc.mo552c("amp_enabled_flag");
        afc.mo552c("sample_adaptive_offset_enabled_flag");
        if (afc.mo552c("pcm_enabled_flag")) {
            afc.mo548a(4, "pcm_sample_bit_depth_luma_minus1");
            afc.mo548a(4, "pcm_sample_bit_depth_chroma_minus1");
            afc.mo547a("log2_min_pcm_luma_coding_block_size_minus3");
        }
    }

    /* renamed from: a */
    private void m14990a(afc afc) {
        afc afc2 = afc;
        int i = 4;
        boolean[][] zArr = new boolean[4][];
        int[][] iArr = new int[4][];
        int[][] iArr2 = new int[2][];
        int[][][] iArr3 = new int[4][][];
        int i2 = 0;
        while (i2 < i) {
            int i3 = 0;
            while (true) {
                int i4 = 6;
                if (i3 >= (i2 == 3 ? 2 : 6)) {
                    break;
                }
                zArr[i2] = new boolean[(i2 == 3 ? 2 : 6)];
                iArr[i2] = new int[(i2 == 3 ? 2 : 6)];
                if (i2 == 3) {
                    i4 = 2;
                }
                iArr3[i2] = new int[i4][];
                zArr[i2][i3] = afc.mo537a();
                if (!zArr[i2][i3]) {
                    iArr[i2][i3] = afc2.mo547a("scaling_list_pred_matrix_id_delta[" + i2 + "][" + i3 + "]");
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + i));
                    int i5 = 8;
                    if (i2 > 1) {
                        int i6 = i2 - 2;
                        iArr2[i6][i3] = afc2.mo551b("scaling_list_dc_coef_minus8[" + i2 + "- 2][" + i3 + "]");
                        i5 = 8 + iArr2[i6][i3];
                    }
                    iArr3[i2][i3] = new int[min];
                    for (int i7 = 0; i7 < min; i7++) {
                        i5 = ((i5 + afc2.mo551b("scaling_list_delta_coef ")) + 256) % 256;
                        iArr3[i2][i3][i7] = i5;
                    }
                }
                i3++;
                i = 4;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: boolean[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14989a(int r21, atakplugin.UASTool.afc r22) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = 2
            java.lang.String r3 = "general_profile_space"
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
            if (r7 < r4) goto L_0x01dd
            java.lang.String r5 = "general_progressive_source_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_interlaced_source_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_non_packed_constraint_flag"
            r1.mo552c((java.lang.String) r5)
            java.lang.String r5 = "general_frame_only_constraint_flag"
            r1.mo552c((java.lang.String) r5)
            r8 = 44
            java.lang.String r5 = "general_reserved_zero_44bits"
            r1.mo548a((int) r8, (java.lang.String) r5)
            r22.mo540c()
            boolean[] r9 = new boolean[r0]
            boolean[] r10 = new boolean[r0]
            r5 = 0
        L_0x0040:
            java.lang.String r7 = "]"
            if (r5 < r0) goto L_0x01a0
            r11 = 8
            if (r0 <= 0) goto L_0x0068
            int[] r5 = new int[r11]
            r12 = r0
        L_0x004b:
            if (r12 < r11) goto L_0x004e
            goto L_0x0068
        L_0x004e:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "reserved_zero_2bits["
            r13.<init>(r14)
            r13.append(r12)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            int r13 = r1.mo550b(r2, r13)
            r5[r12] = r13
            int r12 = r12 + 1
            goto L_0x004b
        L_0x0068:
            int[] r12 = new int[r0]
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
            boolean[] r11 = new boolean[r0]
            boolean[] r8 = new boolean[r0]
            long[] r4 = new long[r0]
            int[] r3 = new int[r0]
            r2 = 0
        L_0x008b:
            if (r2 < r0) goto L_0x008e
            return
        L_0x008e:
            boolean r17 = r9[r2]
            if (r17 == 0) goto L_0x0172
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r17 = r9
            java.lang.String r9 = "sub_layer_profile_space["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r9 = 2
            int r0 = r1.mo550b(r9, r0)
            r12[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_tier_flag["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r13[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_profile_idc["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r9 = 5
            int r0 = r1.mo550b(r9, r0)
            r14[r2] = r0
            r0 = 0
        L_0x00dc:
            r9 = 32
            if (r0 < r9) goto L_0x0147
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_progressive_source_flag["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r5[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_interlaced_source_flag["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r6[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_non_packed_constraint_flag["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r11[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r9 = "sub_layer_frame_only_constraint_flag["
            r0.<init>(r9)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r8[r2] = r0
            r9 = 44
            long r18 = r1.mo536a(r9)
            r4[r2] = r18
            r19 = r4
            goto L_0x0176
        L_0x0147:
            r9 = 44
            r16 = r15[r2]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r19 = r4
            java.lang.String r4 = "sub_layer_profile_compatibility_flag["
            r9.<init>(r4)
            r9.append(r2)
            java.lang.String r4 = "]["
            r9.append(r4)
            r9.append(r0)
            r9.append(r7)
            java.lang.String r4 = r9.toString()
            boolean r4 = r1.mo552c((java.lang.String) r4)
            r16[r0] = r4
            int r0 = r0 + 1
            r4 = r19
            goto L_0x00dc
        L_0x0172:
            r19 = r4
            r17 = r9
        L_0x0176:
            boolean r0 = r10[r2]
            if (r0 == 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "sub_layer_level_idc["
            r0.<init>(r4)
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r4 = 8
            int r0 = r1.mo550b(r4, r0)
            r3[r2] = r0
            goto L_0x0196
        L_0x0194:
            r4 = 8
        L_0x0196:
            int r2 = r2 + 1
            r0 = r21
            r9 = r17
            r4 = r19
            goto L_0x008b
        L_0x01a0:
            r17 = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_profile_present_flag["
            r0.<init>(r2)
            r0.append(r5)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r17[r5] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "sub_layer_level_present_flag["
            r0.<init>(r2)
            r0.append(r5)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r0 = r1.mo552c((java.lang.String) r0)
            r10[r5] = r0
            int r5 = r5 + 1
            r0 = r21
            r2 = 2
            r3 = 5
            r4 = 32
            r6 = 0
            r8 = 44
            goto L_0x0040
        L_0x01dd:
            boolean r0 = r22.mo537a()
            r5[r7] = r0
            int r7 = r7 + 1
            r0 = r21
            r2 = 2
            r3 = 5
            r4 = 32
            r6 = 0
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1103zr.m14989a(int, atakplugin.UASTool.afc):void");
    }
}
