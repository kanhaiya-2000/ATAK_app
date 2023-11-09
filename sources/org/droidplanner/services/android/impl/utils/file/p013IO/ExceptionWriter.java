package org.droidplanner.services.android.impl.utils.file.p013IO;

import android.content.Context;
import com.o3dr.android.client.utils.FileUtils;
import java.io.PrintStream;

/* renamed from: org.droidplanner.services.android.impl.utils.file.IO.ExceptionWriter */
public class ExceptionWriter {
    private final Context context;

    public ExceptionWriter(Context context2) {
        this.context = context2;
    }

    public void saveStackTraceToSD(Throwable th) {
        if (th != null) {
            try {
                PrintStream printStream = new PrintStream(FileUtils.getExceptionFileStream(this.context));
                th.printStackTrace(printStream);
                printStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
