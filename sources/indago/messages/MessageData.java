package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.time.CoordinatedTime;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006 "}, mo1538e = {"Lindago/messages/MessageData;", "", "sourceDevice", "", "destinationDevice", "messageNumber", "", "transmissionTime", "inReplyToMessageNumber", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getDestinationDevice", "()Ljava/lang/String;", "getInReplyToMessageNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageNumber", "()I", "getSourceDevice", "getTransmissionTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)Lindago/messages/MessageData;", "equals", "", "other", "hashCode", "toString", "Companion", "indago"})
public final class MessageData {
    public static final Companion Companion = new Companion((bfd) null);
    private final String destinationDevice;
    private final Integer inReplyToMessageNumber;
    private final int messageNumber;
    private final String sourceDevice;
    private final String transmissionTime;

    public static /* synthetic */ MessageData copy$default(MessageData messageData, String str, String str2, int i, String str3, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = messageData.sourceDevice;
        }
        if ((i2 & 2) != 0) {
            str2 = messageData.destinationDevice;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = messageData.messageNumber;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = messageData.transmissionTime;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            num = messageData.inReplyToMessageNumber;
        }
        return messageData.copy(str, str4, i3, str5, num);
    }

    public final String component1() {
        return this.sourceDevice;
    }

    public final String component2() {
        return this.destinationDevice;
    }

    public final int component3() {
        return this.messageNumber;
    }

    public final String component4() {
        return this.transmissionTime;
    }

    public final Integer component5() {
        return this.inReplyToMessageNumber;
    }

    public final MessageData copy(String str, String str2, int i, String str3, Integer num) {
        bfq.m6567f(str, "sourceDevice");
        bfq.m6567f(str2, "destinationDevice");
        return new MessageData(str, str2, i, str3, num);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MessageData) {
                MessageData messageData = (MessageData) obj;
                if (bfq.m6552a((Object) this.sourceDevice, (Object) messageData.sourceDevice) && bfq.m6552a((Object) this.destinationDevice, (Object) messageData.destinationDevice)) {
                    if (!(this.messageNumber == messageData.messageNumber) || !bfq.m6552a((Object) this.transmissionTime, (Object) messageData.transmissionTime) || !bfq.m6552a((Object) this.inReplyToMessageNumber, (Object) messageData.inReplyToMessageNumber)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.sourceDevice;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.destinationDevice;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.messageNumber) * 31;
        String str3 = this.transmissionTime;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.inReplyToMessageNumber;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "MessageData(sourceDevice=" + this.sourceDevice + ", destinationDevice=" + this.destinationDevice + ", messageNumber=" + this.messageNumber + ", transmissionTime=" + this.transmissionTime + ", inReplyToMessageNumber=" + this.inReplyToMessageNumber + ")";
    }

    public MessageData(String str, String str2, int i, String str3, Integer num) {
        bfq.m6567f(str, "sourceDevice");
        bfq.m6567f(str2, "destinationDevice");
        this.sourceDevice = str;
        this.destinationDevice = str2;
        this.messageNumber = i;
        this.transmissionTime = str3;
        this.inReplyToMessageNumber = num;
    }

    public final String getSourceDevice() {
        return this.sourceDevice;
    }

    public final String getDestinationDevice() {
        return this.destinationDevice;
    }

    public final int getMessageNumber() {
        return this.messageNumber;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageData(String str, String str2, int i, String str3, Integer num, int i2, bfd bfd) {
        this(str, str2, i, (i2 & 8) != 0 ? new CoordinatedTime().toString(false) : str3, (i2 & 16) != 0 ? null : num);
    }

    public final String getTransmissionTime() {
        return this.transmissionTime;
    }

    public final Integer getInReplyToMessageNumber() {
        return this.inReplyToMessageNumber;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, mo1538e = {"Lindago/messages/MessageData$Companion;", "", "()V", "createDefaultDataToServer", "Lindago/messages/MessageData;", "sourceDevice", "", "messageNumber", "", "createDefaultDataToServer$indago", "indago"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(bfd bfd) {
            this();
        }

        public final MessageData createDefaultDataToServer$indago(String str, int i) {
            bfq.m6567f(str, "sourceDevice");
            return new MessageData(str, "VCT", i, (String) null, (Integer) null, 24, (bfd) null);
        }
    }
}
