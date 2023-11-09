package indago.errors;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo1538e = {"Lindago/errors/InvalidFormatException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fieldName", "", "expectedType", "actualValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "indago"})
public final class InvalidFormatException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidFormatException(String str, String str2, String str3) {
        super("Invalid format. " + str + " was expected to be a " + str2 + ". Actual value was " + str3);
        bfq.m6567f(str, "fieldName");
        bfq.m6567f(str2, "expectedType");
    }
}
