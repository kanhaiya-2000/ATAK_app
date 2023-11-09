package atakplugin.UASTool;

import java.util.Locale;

public class bza implements byf {

    /* renamed from: a */
    private static final String f4327a = "AEIOU";

    /* renamed from: b */
    private static final String f4328b = "EIY";

    /* renamed from: c */
    private static final String f4329c = "CSPTG";

    /* renamed from: d */
    private int f4330d = 4;

    /* renamed from: a */
    private boolean m10750a(int i, int i2) {
        return i2 + 1 == i;
    }

    /* renamed from: a */
    public String mo4137a(String str) {
        String str2 = str;
        if (str2 == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str2.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str2.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuffer stringBuffer = new StringBuffer(40);
        StringBuffer stringBuffer2 = new StringBuffer(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c != 'W') {
                if (c != 'X') {
                    stringBuffer.append(charArray);
                } else {
                    charArray[0] = 'S';
                    stringBuffer.append(charArray);
                }
            } else if (charArray[1] == 'R') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
            } else if (charArray[1] == 'H') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
                stringBuffer.setCharAt(0, 'W');
            } else {
                stringBuffer.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            stringBuffer.append(charArray, 1, charArray.length - 1);
        } else {
            stringBuffer.append(charArray);
        }
        int length = stringBuffer.length();
        while (stringBuffer2.length() < mo4136a() && i < length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == 'C' || !m10752a(stringBuffer, i, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i == 0) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!m10752a(stringBuffer, i, 'M') || !m10750a(length, i)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                    case 'C':
                        if (!m10752a(stringBuffer, i, 'S') || m10750a(length, i) || f4328b.indexOf(stringBuffer.charAt(i + 1)) < 0) {
                            if (!m10753a(stringBuffer, i, "CIA")) {
                                if (m10750a(length, i) || f4328b.indexOf(stringBuffer.charAt(i + 1)) < 0) {
                                    if (!m10752a(stringBuffer, i, 'S') || !m10754b(stringBuffer, i, 'H')) {
                                        if (m10754b(stringBuffer, i, 'H')) {
                                            if (i == 0 && length >= 3 && m10751a(stringBuffer, 2)) {
                                                stringBuffer2.append('K');
                                                break;
                                            } else {
                                                stringBuffer2.append('X');
                                                break;
                                            }
                                        } else {
                                            stringBuffer2.append('K');
                                            break;
                                        }
                                    } else {
                                        stringBuffer2.append('K');
                                        break;
                                    }
                                } else {
                                    stringBuffer2.append('S');
                                    break;
                                }
                            } else {
                                stringBuffer2.append('X');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!m10750a(length, i + 1) && m10754b(stringBuffer, i, 'G')) {
                            int i2 = i + 2;
                            if (f4328b.indexOf(stringBuffer.charAt(i2)) >= 0) {
                                stringBuffer2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        stringBuffer2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        stringBuffer2.append(charAt);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if ((!m10750a(length, i3) || !m10754b(stringBuffer, i, 'H')) && ((m10750a(length, i3) || !m10754b(stringBuffer, i, 'H') || m10751a(stringBuffer, i + 2)) && (i <= 0 || (!m10753a(stringBuffer, i, "GN") && !m10753a(stringBuffer, i, "GNED"))))) {
                            boolean a = m10752a(stringBuffer, i, 'G');
                            if (!m10750a(length, i) && f4328b.indexOf(stringBuffer.charAt(i3)) >= 0 && !a) {
                                stringBuffer2.append('J');
                                break;
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!m10750a(length, i) && ((i <= 0 || f4329c.indexOf(stringBuffer.charAt(i - 1)) < 0) && m10751a(stringBuffer, i + 1))) {
                            stringBuffer2.append('H');
                            break;
                        }
                    case 'K':
                        if (i > 0) {
                            if (!m10752a(stringBuffer, i, 'C')) {
                                stringBuffer2.append(charAt);
                                break;
                            }
                        } else {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!m10754b(stringBuffer, i, 'H')) {
                            stringBuffer2.append(charAt);
                            break;
                        } else {
                            stringBuffer2.append('F');
                            break;
                        }
                    case 'Q':
                        stringBuffer2.append('K');
                        break;
                    case 'S':
                        if (!m10753a(stringBuffer, i, "SH") && !m10753a(stringBuffer, i, "SIO") && !m10753a(stringBuffer, i, "SIA")) {
                            stringBuffer2.append('S');
                            break;
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!m10753a(stringBuffer, i, "TIA") && !m10753a(stringBuffer, i, "TIO")) {
                            if (!m10753a(stringBuffer, i, "TCH")) {
                                if (!m10753a(stringBuffer, i, "TH")) {
                                    stringBuffer2.append('T');
                                    break;
                                } else {
                                    stringBuffer2.append('0');
                                    break;
                                }
                            }
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        stringBuffer2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!m10750a(length, i) && m10751a(stringBuffer, i + 1)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                    case 'X':
                        stringBuffer2.append('K');
                        stringBuffer2.append('S');
                        break;
                    case 'Z':
                        stringBuffer2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (stringBuffer2.length() > mo4136a()) {
                stringBuffer2.setLength(mo4136a());
            }
        }
        return stringBuffer2.toString();
    }

    /* renamed from: a */
    private boolean m10751a(StringBuffer stringBuffer, int i) {
        return f4327a.indexOf(stringBuffer.charAt(i)) >= 0;
    }

    /* renamed from: a */
    private boolean m10752a(StringBuffer stringBuffer, int i, char c) {
        if (i <= 0 || i >= stringBuffer.length() || stringBuffer.charAt(i - 1) != c) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m10754b(StringBuffer stringBuffer, int i, char c) {
        if (i < 0 || i >= stringBuffer.length() - 1 || stringBuffer.charAt(i + 1) != c) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10753a(StringBuffer stringBuffer, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i, str.length() + i).equals(str);
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4137a((String) obj);
        }
        throw new byd("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4137a(str);
    }

    /* renamed from: a */
    public boolean mo4139a(String str, String str2) {
        return mo4137a(str).equals(mo4137a(str2));
    }

    /* renamed from: a */
    public int mo4136a() {
        return this.f4330d;
    }

    /* renamed from: a */
    public void mo4138a(int i) {
        this.f4330d = i;
    }
}
