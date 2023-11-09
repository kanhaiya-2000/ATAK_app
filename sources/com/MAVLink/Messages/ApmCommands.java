package com.MAVLink.Messages;

import java.util.ArrayList;

public enum ApmCommands {
    CMD_NAV_WAYPOINT("Waypoint", 16, CommandType.NAVIGATION),
    CMD_NAV_LOITER_UNLIM("Loiter", 17, CommandType.NAVIGATION),
    CMD_NAV_LOITER_TURNS("LoiterN", 18, CommandType.NAVIGATION),
    CMD_NAV_LOITER_TIME("LoiterT", 19, CommandType.NAVIGATION),
    CMD_NAV_RETURN_TO_LAUNCH("RTL", 20, CommandType.COMMAND),
    CMD_NAV_LAND("Land", 21, CommandType.NAVIGATION),
    CMD_NAV_TAKEOFF("Takeoff", 22, CommandType.NAVIGATION),
    CMD_NAV_ROI("ROI", 80, CommandType.COMMAND_WITH_TARGET),
    CMD_NAV_PATHPLANNING("Path", 81, CommandType.COMMAND),
    CMD_DO_JUMP("Do Jump", 177, CommandType.COMMAND),
    CMD_DO_SET_HOME("Set Home", 179, CommandType.COMMAND_WITH_TARGET),
    CMD_DO_CHANGE_SPEED("Set Speed", 178, CommandType.COMMAND),
    CMD_CONDITION_CHANGE_ALT("Set Alt", 113, CommandType.NAVIGATION),
    CMD_CONDITION_DISTANCE("Set Distance", 114, CommandType.COMMAND),
    CMD_CONDITION_YAW("Yaw to", 115, CommandType.COMMAND);
    
    private final int arduPilotIntValue;
    private final CommandType commandType;
    private final String name;

    private enum CommandType {
        NAVIGATION,
        COMMAND,
        COMMAND_WITH_TARGET
    }

    private ApmCommands(String str, int i, CommandType commandType2) {
        this.name = str;
        this.arduPilotIntValue = i;
        this.commandType = commandType2;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.arduPilotIntValue;
    }

    /* renamed from: com.MAVLink.Messages.ApmCommands$1 */
    /* synthetic */ class C11131 {
        static final /* synthetic */ int[] $SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.MAVLink.Messages.ApmCommands$CommandType[] r0 = com.MAVLink.Messages.ApmCommands.CommandType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType = r0
                com.MAVLink.Messages.ApmCommands$CommandType r1 = com.MAVLink.Messages.ApmCommands.CommandType.COMMAND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.MAVLink.Messages.ApmCommands$CommandType r1 = com.MAVLink.Messages.ApmCommands.CommandType.COMMAND_WITH_TARGET     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.MAVLink.Messages.ApmCommands$CommandType r1 = com.MAVLink.Messages.ApmCommands.CommandType.NAVIGATION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.MAVLink.Messages.ApmCommands.C11131.<clinit>():void");
        }
    }

    public boolean showOnMap() {
        return C11131.$SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType[this.commandType.ordinal()] != 1;
    }

    public boolean isOnFligthPath() {
        return C11131.$SwitchMap$com$MAVLink$Messages$ApmCommands$CommandType[this.commandType.ordinal()] == 3;
    }

    public static ApmCommands getCmd(int i) {
        for (ApmCommands apmCommands : values()) {
            if (i == apmCommands.getType()) {
                return apmCommands;
            }
        }
        return null;
    }

    public static ApmCommands getCmd(String str) {
        for (ApmCommands apmCommands : values()) {
            if (str.equals(apmCommands.getName())) {
                return apmCommands;
            }
        }
        return null;
    }

    public static ArrayList<String> getNameList() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApmCommands name2 : values()) {
            arrayList.add(name2.getName());
        }
        return arrayList;
    }
}
