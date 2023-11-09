package org.tensorflow.lite.support.model;

import android.content.Context;
import atakplugin.UASTool.civ;
import atakplugin.UASTool.cix;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.Map;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.Tensor;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.SupportPreconditions;

public class Model {
    private final MappedByteBuffer byteModel;
    private final GpuDelegateProxy gpuDelegateProxy;
    private final Interpreter interpreter;
    private final String modelPath;

    public enum Device {
        CPU,
        NNAPI,
        GPU
    }

    public static class Options {
        /* access modifiers changed from: private */
        public final Device device;
        /* access modifiers changed from: private */
        public final int numThreads;

        /* synthetic */ Options(Builder builder, C60361 r2) {
            this(builder);
        }

        public static class Builder {
            /* access modifiers changed from: private */
            public Device device = Device.CPU;
            /* access modifiers changed from: private */
            public int numThreads = 1;

            public Builder setDevice(Device device2) {
                this.device = device2;
                return this;
            }

            public Builder setNumThreads(int i) {
                this.numThreads = i;
                return this;
            }

            public Options build() {
                return new Options(this, (C60361) null);
            }
        }

        private Options(Builder builder) {
            this.device = builder.device;
            this.numThreads = builder.numThreads;
        }
    }

    @Deprecated
    public static class Builder {
        private final MappedByteBuffer byteModel;
        private Device device = Device.CPU;
        private final String modelPath;
        private int numThreads = 1;

        @civ
        public Builder(@civ Context context, @civ String str) {
            this.modelPath = str;
            this.byteModel = FileUtil.loadMappedFile(context, str);
        }

        @civ
        public Builder setDevice(Device device2) {
            this.device = device2;
            return this;
        }

        @civ
        public Builder setNumThreads(int i) {
            this.numThreads = i;
            return this;
        }

        @civ
        public Model build() {
            return Model.createModel(this.byteModel, this.modelPath, new Options.Builder().setNumThreads(this.numThreads).setDevice(this.device).build());
        }
    }

    public static Model createModel(@civ Context context, @civ String str) {
        return createModel(context, str, new Options.Builder().build());
    }

    public static Model createModel(@civ Context context, @civ String str, @civ Options options) {
        SupportPreconditions.checkNotEmpty(str, "Model path in the asset folder cannot be empty.");
        return createModel(FileUtil.loadMappedFile(context, str), str, options);
    }

    public static Model createModel(@civ MappedByteBuffer mappedByteBuffer, @civ String str, @civ Options options) {
        GpuDelegateProxy gpuDelegateProxy2;
        Interpreter.Options options2 = new Interpreter.Options();
        int i = C60361.$SwitchMap$org$tensorflow$lite$support$model$Model$Device[options.device.ordinal()];
        boolean z = true;
        if (i == 1) {
            options2.setUseNNAPI(true);
        } else if (i == 2) {
            gpuDelegateProxy2 = GpuDelegateProxy.maybeNewInstance();
            if (gpuDelegateProxy2 == null) {
                z = false;
            }
            SupportPreconditions.checkArgument(z, "Cannot inference with GPU. Did you add \"tensorflow-lite-gpu\" as dependency?");
            options2.addDelegate(gpuDelegateProxy2);
            options2.setNumThreads(options.numThreads);
            return new Model(str, mappedByteBuffer, new Interpreter((ByteBuffer) mappedByteBuffer, options2), gpuDelegateProxy2);
        }
        gpuDelegateProxy2 = null;
        options2.setNumThreads(options.numThreads);
        return new Model(str, mappedByteBuffer, new Interpreter((ByteBuffer) mappedByteBuffer, options2), gpuDelegateProxy2);
    }

    /* renamed from: org.tensorflow.lite.support.model.Model$1 */
    /* synthetic */ class C60361 {
        static final /* synthetic */ int[] $SwitchMap$org$tensorflow$lite$support$model$Model$Device;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.tensorflow.lite.support.model.Model$Device[] r0 = org.tensorflow.lite.support.model.Model.Device.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$tensorflow$lite$support$model$Model$Device = r0
                org.tensorflow.lite.support.model.Model$Device r1 = org.tensorflow.lite.support.model.Model.Device.NNAPI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$tensorflow$lite$support$model$Model$Device     // Catch:{ NoSuchFieldError -> 0x001d }
                org.tensorflow.lite.support.model.Model$Device r1 = org.tensorflow.lite.support.model.Model.Device.GPU     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$tensorflow$lite$support$model$Model$Device     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.tensorflow.lite.support.model.Model$Device r1 = org.tensorflow.lite.support.model.Model.Device.CPU     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.support.model.Model.C60361.<clinit>():void");
        }
    }

    @civ
    public MappedByteBuffer getData() {
        return this.byteModel;
    }

    @civ
    public String getPath() {
        return this.modelPath;
    }

    public Tensor getInputTensor(int i) {
        return this.interpreter.getInputTensor(i);
    }

    public Tensor getOutputTensor(int i) {
        return this.interpreter.getOutputTensor(i);
    }

    public int[] getOutputTensorShape(int i) {
        return this.interpreter.getOutputTensor(i).shape();
    }

    public void run(@civ Object[] objArr, @civ Map<Integer, Object> map) {
        this.interpreter.runForMultipleInputsOutputs(objArr, map);
    }

    public void close() {
        Interpreter interpreter2 = this.interpreter;
        if (interpreter2 != null) {
            interpreter2.close();
        }
        GpuDelegateProxy gpuDelegateProxy2 = this.gpuDelegateProxy;
        if (gpuDelegateProxy2 != null) {
            gpuDelegateProxy2.close();
        }
    }

    private Model(@civ String str, @civ MappedByteBuffer mappedByteBuffer, @civ Interpreter interpreter2, @cix GpuDelegateProxy gpuDelegateProxy2) {
        this.modelPath = str;
        this.byteModel = mappedByteBuffer;
        this.interpreter = interpreter2;
        this.gpuDelegateProxy = gpuDelegateProxy2;
    }
}
