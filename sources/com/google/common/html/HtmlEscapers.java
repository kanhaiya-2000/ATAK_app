package com.google.common.html;

import atakplugin.UASTool.bpg;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape(bpg.f3093a, "&quot;").addEscape('\'', "&#39;").addEscape(bpg.f3095c, "&amp;").addEscape(bpg.f3096d, "&lt;").addEscape(bpg.f3097e, "&gt;").build();

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }

    private HtmlEscapers() {
    }
}
