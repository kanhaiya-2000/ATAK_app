package com.autel.internal.dsp;

import com.autel.internal.dsp.evo.EvoDspImpl;
import com.autel.internal.dsp.evo.EvoDspInitializeProxy;
import com.autel.internal.dsp.evo.EvoDspService;
import com.autel.internal.dsp.evo.EvoDspService4Initialize;
import com.autel.internal.dsp.xstar.XStarDspImpl;
import com.autel.internal.dsp.xstar.XStarDspInitializeProxy;
import com.autel.internal.dsp.xstar.XStarDspPreconditionProxy;
import com.autel.internal.dsp.xstar.XStarDspService;
import com.autel.internal.dsp.xstar.XStarDspService4Initialize;

public class DspFactory {
    public static EvoDspService4Initialize createG2Dsp() {
        return new EvoDspInitializeProxy();
    }

    public static EvoDspService createG2DspService() {
        return new EvoDspImpl();
    }

    public static XStarDspService4Initialize createXStarDsp() {
        return new XStarDspInitializeProxy();
    }

    public static XStarDspService createXStarDspService() {
        return new XStarDspPreconditionProxy(new XStarDspImpl());
    }
}
