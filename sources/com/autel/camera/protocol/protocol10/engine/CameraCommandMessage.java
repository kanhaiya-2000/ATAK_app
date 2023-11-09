package com.autel.camera.protocol.protocol10.engine;

public class CameraCommandMessage {
    public static String PARAM_MSGID = "msg_id";
    public static String PARAM_PARAM = "param";
    public static String PARAM_RVAL = "rval";
    private String data;
    private int msgId;
    private String param;
    private int token;
    private String type;

    public CameraCommandMessage(int i, int i2, String str, String str2) {
        setToken(i);
        setType(str);
        setParam(str2);
        setMsgId(i2);
        setData(createCameraControllerMessage());
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMsgId(int i) {
        this.msgId = i;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public int getToken() {
        return this.token;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String str) {
        this.param = str;
    }

    private String createCameraControllerMessage() {
        ParamsTool paramsTool = new ParamsTool();
        paramsTool.setParams("token", getToken());
        paramsTool.setParams(PARAM_MSGID, getMsgId());
        paramsTool.setParams("type", getType());
        paramsTool.setParams(PARAM_PARAM, getParam());
        return paramsTool.toString();
    }
}
