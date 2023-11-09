package org.droidplanner.services.android.impl.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class TextUtils {
    private TextUtils() {
    }

    private static CharSequence apply(CharSequence[] charSequenceArr, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        openTags(spannableStringBuilder, objArr);
        for (CharSequence append : charSequenceArr) {
            spannableStringBuilder.append(append);
        }
        closeTags(spannableStringBuilder, objArr);
        return spannableStringBuilder;
    }

    private static void openTags(Spannable spannable, Object[] objArr) {
        for (Object span : objArr) {
            spannable.setSpan(span, 0, 0, 17);
        }
    }

    private static void closeTags(Spannable spannable, Object[] objArr) {
        int length = spannable.length();
        for (Object obj : objArr) {
            if (length > 0) {
                spannable.setSpan(obj, 0, length, 33);
            } else {
                spannable.removeSpan(obj);
            }
        }
    }

    public static CharSequence bold(CharSequence... charSequenceArr) {
        return apply(charSequenceArr, new StyleSpan(1));
    }

    public static CharSequence italic(CharSequence... charSequenceArr) {
        return apply(charSequenceArr, new StyleSpan(2));
    }

    public static CharSequence normal(CharSequence... charSequenceArr) {
        return apply(charSequenceArr, new StyleSpan(0));
    }

    public static CharSequence color(int i, CharSequence... charSequenceArr) {
        return apply(charSequenceArr, new ForegroundColorSpan(i));
    }
}
