package atakplugin.UASTool;

import android.util.Log;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class cqb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final List<C0334b> f4872a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private static final C0334b f4873b = new cqc();

    /* renamed from: a */
    public static void m12003a(String str, Object... objArr) {
        f4873b.mo4883v(str, objArr);
    }

    /* renamed from: a */
    public static void m12004a(Throwable th, String str, Object... objArr) {
        f4873b.mo4884v(th, str, objArr);
    }

    /* renamed from: b */
    public static void m12007b(String str, Object... objArr) {
        f4873b.mo4876d(str, objArr);
    }

    /* renamed from: b */
    public static void m12008b(Throwable th, String str, Object... objArr) {
        f4873b.mo4877d(th, str, objArr);
    }

    /* renamed from: c */
    public static void m12010c(String str, Object... objArr) {
        f4873b.mo4880i(str, objArr);
    }

    /* renamed from: c */
    public static void m12011c(Throwable th, String str, Object... objArr) {
        f4873b.mo4881i(th, str, objArr);
    }

    /* renamed from: d */
    public static void m12012d(String str, Object... objArr) {
        f4873b.mo4885w(str, objArr);
    }

    /* renamed from: d */
    public static void m12013d(Throwable th, String str, Object... objArr) {
        f4873b.mo4886w(th, str, objArr);
    }

    /* renamed from: e */
    public static void m12014e(String str, Object... objArr) {
        f4873b.mo4878e(str, objArr);
    }

    /* renamed from: e */
    public static void m12015e(Throwable th, String str, Object... objArr) {
        f4873b.mo4879e(th, str, objArr);
    }

    /* renamed from: f */
    public static void m12016f(String str, Object... objArr) {
        f4873b.wtf(str, objArr);
    }

    /* renamed from: f */
    public static void m12017f(Throwable th, String str, Object... objArr) {
        f4873b.wtf(th, str, objArr);
    }

    /* renamed from: a */
    public static C0334b m12000a() {
        return f4873b;
    }

    /* renamed from: a */
    public static C0334b m12001a(String str) {
        List<C0334b> list = f4872a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).explicitTag.set(str);
        }
        return f4873b;
    }

    /* renamed from: a */
    public static void m12002a(C0334b bVar) {
        Objects.requireNonNull(bVar, "tree == null");
        if (bVar != f4873b) {
            f4872a.add(bVar);
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    /* renamed from: b */
    public static void m12006b(C0334b bVar) {
        if (!f4872a.remove(bVar)) {
            throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + bVar);
        }
    }

    /* renamed from: b */
    public static void m12005b() {
        f4872a.clear();
    }

    private cqb() {
        throw new AssertionError("No instances.");
    }

    /* renamed from: atakplugin.UASTool.cqb$b */
    public static abstract class C0334b {
        /* access modifiers changed from: private */
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        public boolean isLoggable(int i) {
            return true;
        }

        /* access modifiers changed from: protected */
        public abstract void log(int i, String str, String str2, Throwable th);

        /* access modifiers changed from: package-private */
        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* renamed from: v */
        public void mo4883v(String str, Object... objArr) {
            prepareLog(2, (Throwable) null, str, objArr);
        }

        /* renamed from: v */
        public void mo4884v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* renamed from: d */
        public void mo4876d(String str, Object... objArr) {
            prepareLog(3, (Throwable) null, str, objArr);
        }

        /* renamed from: d */
        public void mo4877d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* renamed from: i */
        public void mo4880i(String str, Object... objArr) {
            prepareLog(4, (Throwable) null, str, objArr);
        }

        /* renamed from: i */
        public void mo4881i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* renamed from: w */
        public void mo4885w(String str, Object... objArr) {
            prepareLog(5, (Throwable) null, str, objArr);
        }

        /* renamed from: w */
        public void mo4886w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        /* renamed from: e */
        public void mo4878e(String str, Object... objArr) {
            prepareLog(6, (Throwable) null, str, objArr);
        }

        /* renamed from: e */
        public void mo4879e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, (Throwable) null, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            if (isLoggable(i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr.length > 0) {
                        str = String.format(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + Log.getStackTraceString(th);
                    }
                } else if (th != null) {
                    str = Log.getStackTraceString(th);
                } else {
                    return;
                }
                log(i, getTag(), str, th);
            }
        }
    }

    /* renamed from: atakplugin.UASTool.cqb$a */
    public static class C0333a extends C0334b {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;

        /* access modifiers changed from: protected */
        public String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            return className.substring(className.lastIndexOf(46) + 1);
        }

        /* access modifiers changed from: package-private */
        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return createStackElementTag(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() >= 4000) {
                int i2 = 0;
                int length = str2.length();
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + 4000);
                        String substring = str2.substring(i2, min);
                        if (i == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
            } else if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        }
    }
}
