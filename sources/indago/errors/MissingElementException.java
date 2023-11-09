package indago.errors;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo1538e = {"Lindago/errors/MissingElementException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "elementName", "", "(Ljava/lang/String;)V", "indago"})
public final class MissingElementException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissingElementException(String str) {
        super("Element (" + str + ") not found");
        bfq.m6567f(str, "elementName");
    }
}
