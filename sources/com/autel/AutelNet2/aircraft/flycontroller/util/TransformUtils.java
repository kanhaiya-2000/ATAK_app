package com.autel.AutelNet2.aircraft.flycontroller.util;

import com.autel.AutelNet2.aircraft.base.ParamsQueryPacket;
import com.autel.AutelNet2.aircraft.base.ParamsSetPacket;
import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.base.RequestCmdBean;
import com.autel.AutelNet2.aircraft.engine.FmuCmdParams;
import com.autel.AutelNet2.aircraft.engine.ParamsInfo;
import com.autel.AutelNet2.aircraft.engine.ParamsReadInfo;

public class TransformUtils {
    public static int msgId;

    public static ParamsSetPacket getParamsSetPacket(float f, String str) {
        ParamsInfo paramsInfo = new ParamsInfo();
        paramsInfo.setParamValue(f);
        paramsInfo.setParamId(str);
        paramsInfo.setParamType(9);
        return new ParamsSetPacket(new RequestBean(paramsInfo));
    }

    public static ParamsSetPacket getParamsSetPacketT(float f, String str) {
        ParamsInfo paramsInfo = new ParamsInfo();
        paramsInfo.setParamValue(f);
        paramsInfo.setParamId(str);
        paramsInfo.setParamType(6);
        return new ParamsSetPacket(new RequestBean(paramsInfo));
    }

    public static ParamsQueryPacket getParamsGetPacket(String str) {
        ParamsReadInfo paramsReadInfo = new ParamsReadInfo();
        paramsReadInfo.setParamId(str);
        return new ParamsQueryPacket(new RequestBean(paramsReadInfo));
    }

    public static RequestCmdBean getRequestCmdBean(String str) {
        RequestCmdBean requestCmdBean = new RequestCmdBean();
        requestCmdBean.setCommand(str);
        requestCmdBean.setMethod("COMMON_COMMAND");
        return requestCmdBean;
    }

    public static <T> RequestCmdBean<T> getRequestCmdParamBean(T t, String str) {
        RequestCmdBean<T> requestCmdBean = new RequestCmdBean<>();
        requestCmdBean.setCommand(str);
        requestCmdBean.setMethod("COMMON_COMMAND");
        requestCmdBean.setParams(t);
        return requestCmdBean;
    }

    public static RequestCmdBean<FmuCmdParams> getRequestCmdParamBean(FmuCmdParams fmuCmdParams, String str) {
        RequestCmdBean<FmuCmdParams> requestCmdBean = new RequestCmdBean<>();
        requestCmdBean.setCommand(str);
        requestCmdBean.setMethod("COMMON_COMMAND");
        requestCmdBean.setParams(fmuCmdParams);
        return requestCmdBean;
    }

    public static RequestCmdBean getRequestBatteryCmdBean(String str) {
        RequestCmdBean requestCmdBean = new RequestCmdBean();
        requestCmdBean.setCommand(str);
        requestCmdBean.setMethod("COMMON_COMMAND");
        return requestCmdBean;
    }

    public static RequestCmdBean<FmuCmdParams> getRequestBatteryCmdParamBean(FmuCmdParams fmuCmdParams, String str) {
        RequestCmdBean<FmuCmdParams> requestCmdBean = new RequestCmdBean<>();
        requestCmdBean.setCommand(str);
        requestCmdBean.setMethod("COMMON_COMMAND");
        requestCmdBean.setParams(fmuCmdParams);
        return requestCmdBean;
    }
}
