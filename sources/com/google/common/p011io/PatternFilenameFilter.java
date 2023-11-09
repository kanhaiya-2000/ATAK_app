package com.google.common.p011io;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.google.common.io.PatternFilenameFilter */
public final class PatternFilenameFilter implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    public PatternFilenameFilter(Pattern pattern2) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern2);
    }

    public boolean accept(@cij File file, String str) {
        return this.pattern.matcher(str).matches();
    }
}
