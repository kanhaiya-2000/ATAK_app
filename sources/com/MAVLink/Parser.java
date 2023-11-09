package com.MAVLink;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkStats;

public class Parser {
    static boolean msg_received;

    /* renamed from: m */
    private MAVLinkPacket f8229m;
    MAV_states state = MAV_states.MAVLINK_PARSE_STATE_UNINIT;
    public MAVLinkStats stats = new MAVLinkStats();

    enum MAV_states {
        MAVLINK_PARSE_STATE_UNINIT,
        MAVLINK_PARSE_STATE_IDLE,
        MAVLINK_PARSE_STATE_GOT_STX,
        MAVLINK_PARSE_STATE_GOT_LENGTH,
        MAVLINK_PARSE_STATE_GOT_SEQ,
        MAVLINK_PARSE_STATE_GOT_SYSID,
        MAVLINK_PARSE_STATE_GOT_COMPID,
        MAVLINK_PARSE_STATE_GOT_MSGID,
        MAVLINK_PARSE_STATE_GOT_CRC1,
        MAVLINK_PARSE_STATE_GOT_PAYLOAD
    }

    public MAVLinkPacket mavlink_parse_char(int i) {
        msg_received = false;
        switch (C11141.$SwitchMap$com$MAVLink$Parser$MAV_states[this.state.ordinal()]) {
            case 1:
            case 2:
                if (i == 254) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
                    this.f8229m = new MAVLinkPacket();
                    break;
                }
                break;
            case 3:
                if (!msg_received) {
                    this.f8229m.len = i;
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH;
                    break;
                } else {
                    msg_received = false;
                    this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                    break;
                }
            case 4:
                this.f8229m.seq = i;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ;
                break;
            case 5:
                this.f8229m.sysid = i;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID;
                break;
            case 6:
                this.f8229m.compid = i;
                this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID;
                break;
            case 7:
                this.f8229m.msgid = i;
                if (this.f8229m.len != 0) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID;
                    break;
                } else {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
                    break;
                }
            case 8:
                this.f8229m.payload.add((byte) i);
                if (this.f8229m.payloadIsFilled()) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
                    break;
                }
                break;
            case 9:
                this.f8229m.generateCRC();
                if (i == this.f8229m.crc.getLSB()) {
                    this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1;
                    break;
                } else {
                    msg_received = false;
                    this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                    if (i == 254) {
                        this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
                        this.f8229m.crc.start_checksum();
                    }
                    this.stats.crcError();
                    break;
                }
            case 10:
                if (i == this.f8229m.crc.getMSB()) {
                    this.stats.newPacket(this.f8229m);
                    msg_received = true;
                    this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                    break;
                } else {
                    msg_received = false;
                    this.state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
                    if (i == 254) {
                        this.state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
                        this.f8229m.crc.start_checksum();
                    }
                    this.stats.crcError();
                    break;
                }
        }
        if (msg_received) {
            return this.f8229m;
        }
        return null;
    }

    /* renamed from: com.MAVLink.Parser$1 */
    /* synthetic */ class C11141 {
        static final /* synthetic */ int[] $SwitchMap$com$MAVLink$Parser$MAV_states;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.MAVLink.Parser$MAV_states[] r0 = com.MAVLink.Parser.MAV_states.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$MAVLink$Parser$MAV_states = r0
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_UNINIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_STX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x003e }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x006c }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$MAVLink$Parser$MAV_states     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.MAVLink.Parser$MAV_states r1 = com.MAVLink.Parser.MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.MAVLink.Parser.C11141.<clinit>():void");
        }
    }
}
