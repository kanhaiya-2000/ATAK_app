package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import com.atakmap.android.uastool.tasks.UASTask;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo1538e = {"Lindago/messages/EventMessage;", "", "messageData", "Lindago/messages/MessageData;", "priority", "Lindago/messages/MessagePriority;", "message", "", "(Lindago/messages/MessageData;Lindago/messages/MessagePriority;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getMessageData", "()Lindago/messages/MessageData;", "getPriority", "()Lindago/messages/MessagePriority;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "indago"})
public final class EventMessage {
    private final String message;
    private final MessageData messageData;
    private final MessagePriority priority;

    public static /* synthetic */ EventMessage copy$default(EventMessage eventMessage, MessageData messageData2, MessagePriority messagePriority, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = eventMessage.messageData;
        }
        if ((i & 2) != 0) {
            messagePriority = eventMessage.priority;
        }
        if ((i & 4) != 0) {
            str = eventMessage.message;
        }
        return eventMessage.copy(messageData2, messagePriority, str);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final MessagePriority component2() {
        return this.priority;
    }

    public final String component3() {
        return this.message;
    }

    public final EventMessage copy(MessageData messageData2, MessagePriority messagePriority, String str) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(messagePriority, UASTask.COTDETAIL_PRIORITY);
        bfq.m6567f(str, "message");
        return new EventMessage(messageData2, messagePriority, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMessage)) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return bfq.m6552a((Object) this.messageData, (Object) eventMessage.messageData) && bfq.m6552a((Object) this.priority, (Object) eventMessage.priority) && bfq.m6552a((Object) this.message, (Object) eventMessage.message);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        MessagePriority messagePriority = this.priority;
        int hashCode2 = (hashCode + (messagePriority != null ? messagePriority.hashCode() : 0)) * 31;
        String str = this.message;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "EventMessage(messageData=" + this.messageData + ", priority=" + this.priority + ", message=" + this.message + ")";
    }

    public EventMessage(MessageData messageData2, MessagePriority messagePriority, String str) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(messagePriority, UASTask.COTDETAIL_PRIORITY);
        bfq.m6567f(str, "message");
        this.messageData = messageData2;
        this.priority = messagePriority;
        this.message = str;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final MessagePriority getPriority() {
        return this.priority;
    }

    public final String getMessage() {
        return this.message;
    }
}
