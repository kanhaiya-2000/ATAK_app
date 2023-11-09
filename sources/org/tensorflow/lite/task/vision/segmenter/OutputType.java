package org.tensorflow.lite.task.vision.segmenter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.image.ColorSpaceType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public enum OutputType {
    CATEGORY_MASK(0) {
        /* access modifiers changed from: package-private */
        public void assertMasksMatchColoredLabels(List<TensorImage> list, List<ColoredLabel> list2) {
            boolean z = false;
            boolean z2 = list.size() == 1;
            SupportPreconditions.checkArgument(z2, "CATRGORY_MASK only allows one TensorImage in the list, providing " + list.size());
            TensorImage tensorImage = list.get(0);
            if (tensorImage.getColorSpaceType() == ColorSpaceType.GRAYSCALE) {
                z = true;
            }
            SupportPreconditions.checkArgument(z, "CATRGORY_MASK only supports masks of ColorSpaceType, GRAYSCALE, providing " + tensorImage.getColorSpaceType());
        }

        /* access modifiers changed from: package-private */
        public List<TensorImage> createMasksFromBuffer(List<ByteBuffer> list, int[] iArr) {
            boolean z = true;
            if (list.size() != 1) {
                z = false;
            }
            SupportPreconditions.checkArgument(z, "CATRGORY_MASK only allows one mask in the buffer list, providing " + list.size());
            ArrayList arrayList = new ArrayList();
            TensorBuffer createDynamic = TensorBuffer.createDynamic(DataType.UINT8);
            createDynamic.loadBuffer(list.get(0), iArr);
            TensorImage tensorImage = new TensorImage(DataType.UINT8);
            tensorImage.load(createDynamic, ColorSpaceType.GRAYSCALE);
            arrayList.add(tensorImage);
            return arrayList;
        }
    },
    CONFIDENCE_MASK(1) {
        /* access modifiers changed from: package-private */
        public void assertMasksMatchColoredLabels(List<TensorImage> list, List<ColoredLabel> list2) {
            SupportPreconditions.checkArgument(list.size() == list2.size(), String.format("When using CONFIDENCE_MASK, the number of masks (%d) should match the number of coloredLabels (%d).", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(list2.size())}));
            for (TensorImage next : list) {
                boolean z = next.getColorSpaceType() == ColorSpaceType.GRAYSCALE;
                SupportPreconditions.checkArgument(z, "CONFIDENCE_MASK only supports masks of ColorSpaceType, GRAYSCALE, providing " + next.getColorSpaceType());
            }
        }

        /* access modifiers changed from: package-private */
        public List<TensorImage> createMasksFromBuffer(List<ByteBuffer> list, int[] iArr) {
            ArrayList arrayList = new ArrayList();
            for (ByteBuffer loadBuffer : list) {
                TensorBuffer createDynamic = TensorBuffer.createDynamic(DataType.FLOAT32);
                createDynamic.loadBuffer(loadBuffer, iArr);
                TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                tensorImage.load(createDynamic, ColorSpaceType.GRAYSCALE);
                arrayList.add(tensorImage);
            }
            return arrayList;
        }
    };
    
    private final int value;

    /* access modifiers changed from: package-private */
    public abstract void assertMasksMatchColoredLabels(List<TensorImage> list, List<ColoredLabel> list2);

    /* access modifiers changed from: package-private */
    public abstract List<TensorImage> createMasksFromBuffer(List<ByteBuffer> list, int[] iArr);

    public int getValue() {
        return this.value;
    }

    private OutputType(int i) {
        this.value = i;
    }
}
