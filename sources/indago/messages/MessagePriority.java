package indago.messages;

import atakplugin.UASTool.aot;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, mo1538e = {"Lindago/messages/MessagePriority;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "DEBUG", "INFORMATIONAL", "WARNING", "ERROR", "FAILURE", "Companion", "indago"})
public enum MessagePriority {
    DEBUG(0),
    INFORMATIONAL(1),
    WARNING(2),
    ERROR(3),
    FAILURE(4);
    
    public static final Companion Companion = null;
    private final int priority;

    private MessagePriority(int i) {
        this.priority = i;
    }

    public final int getPriority() {
        return this.priority;
    }

    static {
        Companion = new Companion((bfd) null);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo1538e = {"Lindago/messages/MessagePriority$Companion;", "", "()V", "fromPriority", "Lindago/messages/MessagePriority;", "priority", "", "indago"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(bfd bfd) {
            this();
        }

        public final MessagePriority fromPriority(int i) {
            for (MessagePriority messagePriority : MessagePriority.values()) {
                if (messagePriority.getPriority() == i) {
                    return messagePriority;
                }
            }
            return null;
        }
    }
}
