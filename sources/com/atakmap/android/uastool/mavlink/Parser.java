package com.atakmap.android.uastool.MAVLink;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkStats;

public class Parser {

    /* renamed from: m */
    private MAVLinkPacket f8231m;
    MAV_states state;
    public MAVLinkStats stats;

    enum MAV_states {
        MAVLINK_PARSE_STATE_UNINIT,
        MAVLINK_PARSE_STATE_IDLE,
        MAVLINK_PARSE_STATE_GOT_STX,
        MAVLINK_PARSE_STATE_GOT_STX_MAVLINK1,
        MAVLINK_PARSE_STATE_GOT_LENGTH,
        MAVLINK_PARSE_STATE_GOT_SEQ,
        MAVLINK_PARSE_STATE_GOT_INCOMPAT_FLAGS,
        MAVLINK_PARSE_STATE_GOT_COMPAT_FLAGS,
        MAVLINK_PARSE_STATE_GOT_SYSID,
        MAVLINK_PARSE_STATE_GOT_COMPID,
        MAVLINK_PARSE_STATE_GOT_MSGID1,
        MAVLINK_PARSE_STATE_GOT_MSGID2,
        MAVLINK_PARSE_STATE_GOT_MSGID3,
        MAVLINK_PARSE_STATE_GOT_CRC1,
        MAVLINK_PARSE_STATE_GOT_PAYLOAD
    }

    public Parser() {
        this(false);
    }

    public Parser(boolean z) {
        this.state = MAV_states.MAVLINK_PARSE_STATE_UNINIT;
        this.stats = new MAVLinkStats(z);
    }

    /* renamed from: com.atakmap.android.uastool.MAVLink.Parser$1 */
    /* synthetic */ class C11291 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states[] r0 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states = r0
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_UNINIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX_MAVLINK1     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_INCOMPAT_FLAGS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_COMPAT_FLAGS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x006c }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID1     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID2     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x009c }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID3     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.atakmap.android.uastool.MAVLink.Parser$MAV_states r1 = com.atakmap.android.uastool.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.MAVLink.Parser.C11291.<clinit>():void");
        }
    }

    public MAVLinkPacket mavlink_parse_char(int i) {
        int i2 = i & 255;
        switch (C11291.$SwitchMap$com$atakmap$android$uastool$MAVLink$Parser$MAV_states[this.state.ordinal()]) {
            case 1:
            case 2:
                if (i2 == 253) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
                    return null;
                } else if (i2 != 254) {
                    return null;
                } else {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX_MAVLINK1;
                    return null;
                }
            case 3:
                MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(i2);
                this.f8231m = mAVLinkPacket;
                mAVLinkPacket.setProtocol(MAVLinkPacket.Protocol.PROTOCOL_2_0);
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH;
                return null;
            case 4:
                MAVLinkPacket mAVLinkPacket2 = new MAVLinkPacket(i2);
                this.f8231m = mAVLinkPacket2;
                mAVLinkPacket2.setProtocol(MAVLinkPacket.Protocol.PROTOCOL_1_0);
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPAT_FLAGS;
                return null;
            case 5:
                this.f8231m.incompat_flags = i2;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_INCOMPAT_FLAGS;
                return null;
            case 6:
                this.f8231m.compat_flags = i2;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPAT_FLAGS;
                return null;
            case 7:
                this.f8231m.seq = i2;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ;
                return null;
            case 8:
                this.f8231m.sysid = i2;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID;
                return null;
            case 9:
                this.f8231m.compid = i2;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID;
                return null;
            case 10:
                this.f8231m.msgid = i2;
                if (this.f8231m.protocol == MAVLinkPacket.Protocol.PROTOCOL_2_0) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID1;
                    return null;
                } else if (this.f8231m.len == 0) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
                    return null;
                } else {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID3;
                    return null;
                }
            case 11:
                MAVLinkPacket mAVLinkPacket3 = this.f8231m;
                mAVLinkPacket3.msgid = (i2 << 8) | mAVLinkPacket3.msgid;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID2;
                return null;
            case 12:
                MAVLinkPacket mAVLinkPacket4 = this.f8231m;
                mAVLinkPacket4.msgid = (i2 << 16) | mAVLinkPacket4.msgid;
                if (this.f8231m.len == 0) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
                    return null;
                }
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID3;
                return null;
            case 13:
                this.f8231m.payload.add((byte) i2);
                if (!this.f8231m.payloadIsFilled()) {
                    return null;
                }
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
                return null;
            case 14:
                this.f8231m.generateCRC();
                if (i2 == this.f8231m.crc.getLSB() || this.f8231m.msgid == 265) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1;
                    return null;
                }
                this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                this.stats.crcError();
                return null;
            case 15:
                if (i2 == this.f8231m.crc.getMSB() || this.f8231m.msgid == 265) {
                    this.stats.newPacket(this.f8231m);
                    this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                    return this.f8231m;
                }
                this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                this.stats.crcError();
                return null;
            default:
                return null;
        }
    }
}
