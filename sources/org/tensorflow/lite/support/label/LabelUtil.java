package org.tensorflow.lite.support.label;

import android.util.Log;
import atakplugin.UASTool.civ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class LabelUtil {
    public static List<String> mapValueToLabels(@civ TensorBuffer tensorBuffer, @civ List<String> list, int i) {
        SupportPreconditions.checkNotNull(tensorBuffer, "Given tensor should not be null");
        SupportPreconditions.checkNotNull(list, "Given labels should not be null");
        int[] intArray = tensorBuffer.getIntArray();
        Log.d("values", Arrays.toString(intArray));
        ArrayList arrayList = new ArrayList();
        for (int i2 : intArray) {
            int i3 = i2 + i;
            if (i3 < 0 || i3 >= list.size()) {
                arrayList.add("");
            } else {
                arrayList.add(list.get(i3));
            }
        }
        return arrayList;
    }

    private LabelUtil() {
    }
}
