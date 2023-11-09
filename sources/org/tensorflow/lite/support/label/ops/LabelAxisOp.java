package org.tensorflow.lite.support.label.ops;

import android.content.Context;
import atakplugin.UASTool.civ;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class LabelAxisOp {
    private final Map<Integer, List<String>> axisLabels;

    protected LabelAxisOp(Builder builder) {
        this.axisLabels = builder.axisLabels;
    }

    public TensorLabel apply(@civ TensorBuffer tensorBuffer) {
        SupportPreconditions.checkNotNull(tensorBuffer, "Tensor buffer cannot be null.");
        return new TensorLabel(this.axisLabels, tensorBuffer);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final Map<Integer, List<String>> axisLabels = new HashMap();

        protected Builder() {
        }

        public Builder addAxisLabel(@civ Context context, int i, @civ String str) {
            SupportPreconditions.checkNotNull(context, "Context cannot be null.");
            SupportPreconditions.checkNotNull(str, "File path cannot be null.");
            this.axisLabels.put(Integer.valueOf(i), FileUtil.loadLabels(context, str));
            return this;
        }

        public Builder addAxisLabel(int i, @civ List<String> list) {
            this.axisLabels.put(Integer.valueOf(i), list);
            return this;
        }

        public LabelAxisOp build() {
            return new LabelAxisOp(this);
        }
    }
}
