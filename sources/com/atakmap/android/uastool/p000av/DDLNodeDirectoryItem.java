package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.DDLNodeDirectoryItem */
class DDLNodeDirectoryItem {
    private final int alloc_bw;
    private final String guid;
    private final String name;
    private final int suid;
    private final int type;

    public DDLNodeDirectoryItem(int i, int i2, int i3, String str, String str2) {
        this.suid = i;
        this.type = i2;
        this.alloc_bw = i3;
        this.name = str;
        this.guid = str2;
    }

    public int getSuid() {
        return this.suid;
    }

    public int getType() {
        return this.type;
    }

    public int getAlloc_bw() {
        return this.alloc_bw;
    }

    public String getName() {
        return this.name;
    }

    public String getGuid() {
        return this.guid;
    }
}
