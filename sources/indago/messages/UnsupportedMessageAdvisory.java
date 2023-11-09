package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo1538e = {"Lindago/messages/UnsupportedMessageAdvisory;", "", "messageData", "Lindago/messages/MessageData;", "(Lindago/messages/MessageData;)V", "getMessageData", "()Lindago/messages/MessageData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class UnsupportedMessageAdvisory {
    private final MessageData messageData;

    public static /* synthetic */ UnsupportedMessageAdvisory copy$default(UnsupportedMessageAdvisory unsupportedMessageAdvisory, MessageData messageData2, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = unsupportedMessageAdvisory.messageData;
        }
        return unsupportedMessageAdvisory.copy(messageData2);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final UnsupportedMessageAdvisory copy(MessageData messageData2) {
        bfq.m6567f(messageData2, "messageData");
        return new UnsupportedMessageAdvisory(messageData2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UnsupportedMessageAdvisory) && bfq.m6552a((Object) this.messageData, (Object) ((UnsupportedMessageAdvisory) obj).messageData);
        }
        return true;
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        if (messageData2 != null) {
            return messageData2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "UnsupportedMessageAdvisory(messageData=" + this.messageData + ")";
    }

    public UnsupportedMessageAdvisory(MessageData messageData2) {
        bfq.m6567f(messageData2, "messageData");
        this.messageData = messageData2;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }
}
