package atakplugin.UASTool;

import atakplugin.UASTool.alc;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: atakplugin.UASTool.zo */
public class C1097zo {

    /* renamed from: A */
    private static final int f8040A = 4;

    /* renamed from: B */
    private static final int f8041B = 5;

    /* renamed from: C */
    private static final int f8042C = 6;

    /* renamed from: D */
    private static final int f8043D = 7;

    /* renamed from: E */
    private static final int f8044E = 8;

    /* renamed from: F */
    private static final int f8045F = 9;

    /* renamed from: G */
    private static final int f8046G = 16;

    /* renamed from: H */
    private static final int f8047H = 17;

    /* renamed from: I */
    private static final int f8048I = 18;

    /* renamed from: J */
    private static final int f8049J = 19;

    /* renamed from: K */
    private static final int f8050K = 20;

    /* renamed from: L */
    private static final int f8051L = 21;

    /* renamed from: M */
    private static final long f8052M = 1048576;

    /* renamed from: a */
    public static final int f8053a = 32;

    /* renamed from: b */
    public static final int f8054b = 33;

    /* renamed from: c */
    public static final int f8055c = 34;

    /* renamed from: d */
    public static final int f8056d = 35;

    /* renamed from: e */
    public static final int f8057e = 39;

    /* renamed from: f */
    public static final int f8058f = 41;

    /* renamed from: g */
    public static final int f8059g = 42;

    /* renamed from: h */
    public static final int f8060h = 43;

    /* renamed from: i */
    public static final int f8061i = 44;

    /* renamed from: j */
    public static final int f8062j = 48;

    /* renamed from: k */
    public static final int f8063k = 49;

    /* renamed from: l */
    public static final int f8064l = 50;

    /* renamed from: m */
    public static final int f8065m = 51;

    /* renamed from: n */
    public static final int f8066n = 52;

    /* renamed from: o */
    public static final int f8067o = 53;

    /* renamed from: p */
    public static final int f8068p = 54;

    /* renamed from: q */
    public static final int f8069q = 55;

    /* renamed from: w */
    private static final int f8070w = 0;

    /* renamed from: x */
    private static final int f8071x = 1;

    /* renamed from: y */
    private static final int f8072y = 2;

    /* renamed from: z */
    private static final int f8073z = 3;

    /* renamed from: r */
    LinkedHashMap<Long, ByteBuffer> f8074r = new LinkedHashMap<>();

    /* renamed from: s */
    LinkedHashMap<Long, ByteBuffer> f8075s = new LinkedHashMap<>();

    /* renamed from: t */
    LinkedHashMap<Long, ByteBuffer> f8076t = new LinkedHashMap<>();

    /* renamed from: u */
    List<Long> f8077u = new ArrayList();

    /* renamed from: v */
    List<C1024xh> f8078v = new ArrayList();

    /* renamed from: atakplugin.UASTool.zo$b */
    public static class C1099b {

        /* renamed from: a */
        int f8085a;

        /* renamed from: b */
        int f8086b;

        /* renamed from: c */
        int f8087c;

        /* renamed from: d */
        int f8088d;
    }

    /* renamed from: atakplugin.UASTool.zo$c */
    public enum C1100c {
        AUD_SEI_SLICE,
        SEI_SLICE,
        SLICE_OES_EOB
    }

    public C1097zo(C1007ws wsVar) {
        C1098a aVar = new C1098a(wsVar);
        ArrayList<ByteBuffer> arrayList = new ArrayList<>();
        long j = 1;
        long j2 = 1;
        int i = 0;
        while (true) {
            ByteBuffer a = m14973a(aVar);
            if (a == null) {
                System.err.println("");
                alc alc = new alc();
                alc.mo1268a(m14974a());
                alc.mo1296j(0);
                return;
            }
            C1099b b = mo6333b(a);
            switch (b.f8086b) {
                case 32:
                    this.f8074r.put(Long.valueOf(j2), a);
                    break;
                case 33:
                    this.f8075s.put(Long.valueOf(j2), a);
                    break;
                case 34:
                    this.f8076t.put(Long.valueOf(j2), a);
                    break;
            }
            i = b.f8086b < 32 ? b.f8086b : i;
            if (mo6332a(b.f8086b, a, (List<ByteBuffer>) arrayList) && !arrayList.isEmpty()) {
                System.err.println("##########################");
                for (ByteBuffer byteBuffer : arrayList) {
                    C1099b b2 = mo6333b(byteBuffer);
                    System.err.println(String.format("type: %3d - layer: %3d - tempId: %3d - size: %3d", new Object[]{Integer.valueOf(b2.f8086b), Integer.valueOf(b2.f8087c), Integer.valueOf(b2.f8088d), Integer.valueOf(byteBuffer.limit())}));
                    j = 1;
                }
                System.err.println("                          ##########################");
                this.f8078v.add(mo6329a((List<ByteBuffer>) arrayList));
                arrayList.clear();
                j2 += j;
            }
            arrayList.add(a);
            if (i >= 16 && i <= 21) {
                this.f8077u.add(Long.valueOf(j2));
            }
            j = 1;
        }
    }

    /* renamed from: a */
    public static void m14976a(String[] strArr) {
        new C1097zo(new C1009wu("c:\\content\\test-UHD-HEVC_01_FMV_Med_track1.hvc"));
    }

    /* renamed from: a */
    private ByteBuffer m14973a(C1098a aVar) {
        while (!aVar.mo6335b()) {
            try {
                aVar.mo6337d();
            } catch (EOFException unused) {
                return null;
            }
        }
        aVar.mo6338e();
        while (!aVar.mo6336c()) {
            aVar.mo6337d();
        }
        return aVar.mo6339f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: boolean[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6331a(int r20, atakplugin.UASTool.afc r21) {
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
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1097zo.mo6331a(int, atakplugin.UASTool.afc):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: boolean[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo6328a(java.nio.ByteBuffer r15) {
        /*
            r14 = this;
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
            r0.mo550b(r15, r1)
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
            r14.mo6331a(r3, r0)
            java.lang.String r4 = "vps_sub_layer_ordering_info_present_flag"
            boolean r4 = r0.mo552c((java.lang.String) r4)
            if (r4 == 0) goto L_0x0047
            r5 = 0
            goto L_0x0048
        L_0x0047:
            r5 = r3
        L_0x0048:
            int[] r5 = new int[r5]
            if (r4 == 0) goto L_0x004e
            r6 = 0
            goto L_0x004f
        L_0x004e:
            r6 = r3
        L_0x004f:
            int[] r6 = new int[r6]
            if (r4 == 0) goto L_0x0055
            r7 = 0
            goto L_0x0056
        L_0x0055:
            r7 = r3
        L_0x0056:
            int[] r7 = new int[r7]
            if (r4 == 0) goto L_0x005c
            r4 = 0
            goto L_0x005d
        L_0x005c:
            r4 = r3
        L_0x005d:
            java.lang.String r8 = "]"
            if (r4 <= r3) goto L_0x012e
            java.lang.String r4 = "vps_max_layer_id"
            int r9 = r0.mo550b(r1, r4)
            java.lang.String r1 = "vps_num_layer_sets_minus1"
            int r10 = r0.mo547a(r1)
            int[] r15 = new int[r15]
            r11 = 1
            r15[r11] = r9
            r15[r2] = r10
            java.lang.Class<boolean> r1 = boolean.class
            java.lang.Object r15 = java.lang.reflect.Array.newInstance(r1, r15)
            r12 = r15
            boolean[][] r12 = (boolean[][]) r12
            r13 = 1
        L_0x007e:
            if (r13 <= r10) goto L_0x0103
            java.lang.String r15 = "vps_timing_info_present_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x00ea
            r15 = 32
            java.lang.String r1 = "vps_num_units_in_tick"
            r0.mo550b(r15, r1)
            java.lang.String r1 = "vps_time_scale"
            r0.mo550b(r15, r1)
            java.lang.String r15 = "vps_poc_proportional_to_timing_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x00a1
            java.lang.String r15 = "vps_num_ticks_poc_diff_one_minus1"
            r0.mo547a(r15)
        L_0x00a1:
            java.lang.String r15 = "vps_num_hrd_parameters"
            int r15 = r0.mo547a(r15)
            int[] r1 = new int[r15]
            boolean[] r4 = new boolean[r15]
            r5 = 0
        L_0x00ac:
            if (r5 < r15) goto L_0x00af
            goto L_0x00ea
        L_0x00af:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "hrd_layer_set_idx["
            r6.<init>(r7)
            r6.append(r5)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            int r6 = r0.mo547a(r6)
            r1[r5] = r6
            if (r5 <= 0) goto L_0x00e0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "cprms_present_flag["
            r6.<init>(r7)
            r6.append(r5)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            boolean r6 = r0.mo552c((java.lang.String) r6)
            r4[r5] = r6
            goto L_0x00e2
        L_0x00e0:
            r4[r2] = r11
        L_0x00e2:
            boolean r6 = r4[r5]
            r14.m14975a((boolean) r6, (int) r3, (atakplugin.UASTool.afc) r0)
            int r5 = r5 + 1
            goto L_0x00ac
        L_0x00ea:
            java.lang.String r15 = "vps_extension_flag"
            boolean r15 = r0.mo552c((java.lang.String) r15)
            if (r15 == 0) goto L_0x00ff
        L_0x00f2:
            boolean r15 = r0.mo541d()
            if (r15 != 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.String r15 = "vps_extension_data_flag"
            r0.mo552c((java.lang.String) r15)
            goto L_0x00f2
        L_0x00ff:
            r0.mo559l()
            return r2
        L_0x0103:
            r15 = 0
        L_0x0104:
            if (r15 <= r9) goto L_0x010a
            int r13 = r13 + 1
            goto L_0x007e
        L_0x010a:
            r1 = r12[r13]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "layer_id_included_flag["
            r4.<init>(r5)
            r4.append(r13)
            java.lang.String r5 = "]["
            r4.append(r5)
            r4.append(r15)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            boolean r4 = r0.mo552c((java.lang.String) r4)
            r1[r15] = r4
            int r15 = r15 + 1
            goto L_0x0104
        L_0x012e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "vps_max_dec_pic_buffering_minus1["
            r9.<init>(r10)
            r9.append(r4)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            int r9 = r0.mo547a(r9)
            r5[r4] = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r10)
            r9.append(r4)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            int r9 = r0.mo547a(r9)
            r6[r4] = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r10)
            r9.append(r4)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            int r8 = r0.mo547a(r8)
            r7[r4] = r8
            int r4 = r4 + 1
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1097zo.mo6328a(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14975a(boolean r12, int r13, atakplugin.UASTool.afc r14) {
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
            r11.mo6330a(r0, r8, r2, r14)
        L_0x00ed:
            if (r1 == 0) goto L_0x00f4
            r8 = r6[r0]
            r11.mo6330a(r0, r8, r2, r14)
        L_0x00f4:
            int r0 = r0 + 1
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1097zo.m14975a(boolean, int, atakplugin.UASTool.afc):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6330a(int i, int i2, boolean z, afc afc) {
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
    private List<alc.C0055a> m14974a() {
        alc.C0055a aVar = new alc.C0055a();
        aVar.f1871a = true;
        aVar.f1873c = 32;
        aVar.f1874d = new ArrayList();
        for (ByteBuffer next : this.f8074r.values()) {
            byte[] bArr = new byte[next.limit()];
            next.position(0);
            next.get(bArr);
            aVar.f1874d.add(bArr);
        }
        alc.C0055a aVar2 = new alc.C0055a();
        aVar2.f1871a = true;
        aVar2.f1873c = 33;
        aVar2.f1874d = new ArrayList();
        for (ByteBuffer next2 : this.f8075s.values()) {
            byte[] bArr2 = new byte[next2.limit()];
            next2.position(0);
            next2.get(bArr2);
            aVar2.f1874d.add(bArr2);
        }
        alc.C0055a aVar3 = new alc.C0055a();
        aVar3.f1871a = true;
        aVar3.f1873c = 33;
        aVar3.f1874d = new ArrayList();
        for (ByteBuffer next3 : this.f8076t.values()) {
            byte[] bArr3 = new byte[next3.limit()];
            next3.position(0);
            next3.get(bArr3);
            aVar3.f1874d.add(bArr3);
        }
        return Arrays.asList(new alc.C0055a[]{aVar, aVar2, aVar3});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6332a(int i, ByteBuffer byteBuffer, List<ByteBuffer> list) {
        if (list.isEmpty()) {
            return true;
        }
        boolean z = mo6333b(list.get(list.size() - 1)).f8086b <= 31;
        switch (i) {
            case 32:
            case 33:
            case 34:
            case 35:
            case 39:
            case 41:
            case 42:
            case 43:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                if (z) {
                    return true;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                switch (i) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        break;
                    default:
                        return false;
                }
        }
        byteBuffer.position(0);
        byteBuffer.get(new byte[50]);
        byteBuffer.position(2);
        int f = C0679nk.m12499f(byteBuffer);
        if (!z || (f & 128) <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public C1099b mo6333b(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        int d = C0679nk.m12497d(byteBuffer);
        C1099b bVar = new C1099b();
        bVar.f8085a = (32768 & d) >> 15;
        bVar.f8086b = (d & 32256) >> 9;
        bVar.f8087c = (d & 504) >> 3;
        bVar.f8088d = d & 7;
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1024xh mo6329a(List<ByteBuffer> list) {
        byte[] bArr = new byte[(list.size() * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (ByteBuffer remaining : list) {
            wrap.putInt(remaining.remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = list.get(i);
        }
        return new C1025xi(byteBufferArr);
    }

    /* renamed from: atakplugin.UASTool.zo$a */
    class C1098a {

        /* renamed from: a */
        long f8079a = 0;

        /* renamed from: b */
        int f8080b = 0;

        /* renamed from: c */
        C1007ws f8081c;

        /* renamed from: d */
        ByteBuffer f8082d;

        /* renamed from: e */
        long f8083e;

        C1098a(C1007ws wsVar) {
            this.f8081c = wsVar;
            mo6334a();
        }

        /* renamed from: a */
        public void mo6334a() {
            C1007ws wsVar = this.f8081c;
            this.f8082d = wsVar.mo5653a(this.f8079a, Math.min(wsVar.mo5651a() - this.f8079a, C1097zo.f8052M));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo6335b() {
            int limit = this.f8082d.limit();
            int i = this.f8080b;
            if (limit - i >= 3) {
                if (this.f8082d.get(i) == 0 && this.f8082d.get(this.f8080b + 1) == 0 && this.f8082d.get(this.f8080b + 2) == 1) {
                    return true;
                }
                return false;
            } else if (this.f8079a + ((long) i) == this.f8081c.mo5651a()) {
                throw new EOFException();
            } else {
                throw new RuntimeException("buffer repositioning require");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo6336c() {
            int limit = this.f8082d.limit();
            int i = this.f8080b;
            if (limit - i >= 3) {
                return this.f8082d.get(i) == 0 && this.f8082d.get(this.f8080b + 1) == 0 && (this.f8082d.get(this.f8080b + 2) == 0 || this.f8082d.get(this.f8080b + 2) == 1);
            }
            if (this.f8079a + ((long) i) + 3 > this.f8081c.mo5651a()) {
                return this.f8079a + ((long) this.f8080b) == this.f8081c.mo5651a();
            }
            this.f8079a = this.f8083e;
            this.f8080b = 0;
            mo6334a();
            return mo6336c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo6337d() {
            this.f8080b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6338e() {
            int i = this.f8080b + 3;
            this.f8080b = i;
            this.f8083e = this.f8079a + ((long) i);
        }

        /* renamed from: f */
        public ByteBuffer mo6339f() {
            long j = this.f8083e;
            long j2 = this.f8079a;
            if (j >= j2) {
                this.f8082d.position((int) (j - j2));
                ByteBuffer slice = this.f8082d.slice();
                slice.limit((int) (((long) this.f8080b) - (this.f8083e - this.f8079a)));
                return slice;
            }
            throw new RuntimeException("damn! NAL exceeds buffer");
        }
    }
}
