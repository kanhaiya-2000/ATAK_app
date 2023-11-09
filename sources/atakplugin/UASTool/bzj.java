package atakplugin.UASTool;

class bzj {
    bzj() {
    }

    /* renamed from: a */
    static int m10827a(byte b) {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid URL encoding: not a valid digit (radix 16): ");
        stringBuffer.append(b);
        throw new byb(stringBuffer.toString());
    }
}
