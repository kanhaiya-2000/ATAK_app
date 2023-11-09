package org.tensorflow.lite.support.label;

import atakplugin.UASTool.civ;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class TensorLabel {
    private final Map<Integer, List<String>> axisLabels;
    private final int[] shape;
    private final TensorBuffer tensorBuffer;

    public TensorLabel(@civ Map<Integer, List<String>> map, @civ TensorBuffer tensorBuffer2) {
        SupportPreconditions.checkNotNull(map, "Axis labels cannot be null.");
        SupportPreconditions.checkNotNull(tensorBuffer2, "Tensor Buffer cannot be null.");
        this.axisLabels = map;
        this.tensorBuffer = tensorBuffer2;
        this.shape = tensorBuffer2.getShape();
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            boolean z = true;
            boolean z2 = intValue >= 0 && intValue < this.shape.length;
            SupportPreconditions.checkArgument(z2, "Invalid axis id: " + intValue);
            Object value = next.getValue();
            SupportPreconditions.checkNotNull(value, "Label list is null on axis " + intValue);
            if (this.shape[intValue] != ((List) next.getValue()).size()) {
                z = false;
            }
            SupportPreconditions.checkArgument(z, "Label number " + ((List) next.getValue()).size() + " mismatch the shape on axis " + intValue);
        }
    }

    public TensorLabel(@civ List<String> list, @civ TensorBuffer tensorBuffer2) {
        this(makeMap(getFirstAxisWithSizeGreaterThanOne(tensorBuffer2), list), tensorBuffer2);
    }

    @civ
    public Map<String, TensorBuffer> getMapWithTensorBuffer() {
        int firstAxisWithSizeGreaterThanOne = getFirstAxisWithSizeGreaterThanOne(this.tensorBuffer);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SupportPreconditions.checkArgument(this.axisLabels.containsKey(Integer.valueOf(firstAxisWithSizeGreaterThanOne)), "get a <String, TensorBuffer> map requires the labels are set on the first non-1 axis.");
        List<String> list = this.axisLabels.get(Integer.valueOf(firstAxisWithSizeGreaterThanOne));
        DataType dataType = this.tensorBuffer.getDataType();
        int typeSize = this.tensorBuffer.getTypeSize();
        int flatSize = this.tensorBuffer.getFlatSize();
        ByteBuffer buffer = this.tensorBuffer.getBuffer();
        buffer.rewind();
        int i = (flatSize / this.shape[firstAxisWithSizeGreaterThanOne]) * typeSize;
        SupportPreconditions.checkNotNull(list, "Label list should never be null");
        int i2 = 0;
        for (String put : list) {
            buffer.position(i2 * i);
            ByteBuffer slice = buffer.slice();
            slice.order(buffer.order()).limit(i);
            TensorBuffer createDynamic = TensorBuffer.createDynamic(dataType);
            int[] iArr = this.shape;
            createDynamic.loadBuffer(slice, Arrays.copyOfRange(iArr, firstAxisWithSizeGreaterThanOne + 1, iArr.length));
            linkedHashMap.put(put, createDynamic);
            i2++;
        }
        return linkedHashMap;
    }

    @civ
    public Map<String, Float> getMapWithFloatValue() {
        int firstAxisWithSizeGreaterThanOne = getFirstAxisWithSizeGreaterThanOne(this.tensorBuffer);
        int i = 0;
        SupportPreconditions.checkState(firstAxisWithSizeGreaterThanOne == this.shape.length - 1, "get a <String, Scalar> map is only valid when the only labeled axis is the last one.");
        List<String> list = this.axisLabels.get(Integer.valueOf(firstAxisWithSizeGreaterThanOne));
        float[] floatArray = this.tensorBuffer.getFloatArray();
        SupportPreconditions.checkState(list.size() == floatArray.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String put : list) {
            linkedHashMap.put(put, Float.valueOf(floatArray[i]));
            i++;
        }
        return linkedHashMap;
    }

    @civ
    public List<Category> getCategoryList() {
        int firstAxisWithSizeGreaterThanOne = getFirstAxisWithSizeGreaterThanOne(this.tensorBuffer);
        int i = 0;
        SupportPreconditions.checkState(firstAxisWithSizeGreaterThanOne == this.shape.length - 1, "get a Category list is only valid when the only labeled axis is the last one.");
        List<String> list = this.axisLabels.get(Integer.valueOf(firstAxisWithSizeGreaterThanOne));
        float[] floatArray = this.tensorBuffer.getFloatArray();
        SupportPreconditions.checkState(list.size() == floatArray.length);
        ArrayList arrayList = new ArrayList();
        for (String category : list) {
            arrayList.add(new Category(category, floatArray[i]));
            i++;
        }
        return arrayList;
    }

    private static int getFirstAxisWithSizeGreaterThanOne(@civ TensorBuffer tensorBuffer2) {
        int[] shape2 = tensorBuffer2.getShape();
        for (int i = 0; i < shape2.length; i++) {
            if (shape2[i] > 1) {
                return i;
            }
        }
        throw new IllegalArgumentException("Cannot find an axis to label. A valid axis to label should have size larger than 1.");
    }

    private static Map<Integer, List<String>> makeMap(int i, List<String> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(i), list);
        return linkedHashMap;
    }
}
