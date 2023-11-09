package com.autel.AutelNet2.core.message;

import android.text.TextUtils;
import com.autel.AutelNet2.constant.MsgNode;
import com.autel.AutelNet2.core.utils.UdpConfig;
import com.autel.AutelNet2.utils.BytesUtils;
import com.autel.downloader.bean.DownloadTask;
import com.autel.util.okhttp.utils.MessageParser;
import java.io.FileInputStream;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseMsgPacket implements Serializable {
    protected MessageParser messageParser = new MessageParser();
    private byte[] msg_body;
    protected MsgHead msg_head;

    /* access modifiers changed from: protected */
    public abstract String loadBody();

    /* access modifiers changed from: protected */
    public byte[] loadBodyToByte() {
        return null;
    }

    public FileInputStream loadFileInputStream() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void loadHead();

    public abstract BaseMsgPacket parseBody();

    public int getType() {
        MsgHead msgHead = this.msg_head;
        if (msgHead == null) {
            return 0;
        }
        return msgHead.msg_type;
    }

    public BaseMsgPacket(MsgHead msgHead, byte[] bArr) {
        this.msg_head = msgHead;
        this.msg_body = bArr;
    }

    public BaseMsgPacket() {
        MsgHead msgHead = new MsgHead();
        this.msg_head = msgHead;
        msgHead.msg_src = MsgNode.PHONE_NODE;
        this.msg_head.msg_dst = 2048;
        loadHead();
    }

    public void setHead(MsgHead msgHead) {
        this.msg_head = msgHead;
    }

    public MsgHead getHead() {
        return this.msg_head;
    }

    private void setBody() {
        String loadBody = loadBody();
        if (!TextUtils.isEmpty(loadBody)) {
            setBody(loadBody);
        }
    }

    private void setBodyToByte() {
        byte[] loadBodyToByte = loadBodyToByte();
        if (loadBodyToByte != null) {
            setBody(loadBodyToByte);
        }
    }

    private void setBody(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            setBody(str.getBytes());
        }
    }

    /* access modifiers changed from: protected */
    public void setBody(byte[] bArr) {
        this.msg_body = bArr;
    }

    public byte[] getBody() {
        return this.msg_body;
    }

    public String getBodyString() {
        if (this.msg_body != null) {
            return new String(this.msg_body);
        }
        return null;
    }

    public byte[] getMsgBody() {
        return this.msg_body;
    }

    public JSONObject getBodyJson() {
        try {
            return new JSONObject(getBodyString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPacketSequence(short s) {
        MsgHead msgHead = this.msg_head;
        if (msgHead != null) {
            msgHead.sequence = s;
        }
    }

    public void setPacketId(short s) {
        MsgHead msgHead = this.msg_head;
        if (msgHead != null) {
            msgHead.package_id = s;
        }
    }

    public byte[] encodePacket() {
        loadHead();
        if (this.msg_head == null) {
            return null;
        }
        setBodyToByte();
        loadFileInputStream();
        setBody();
        if (this.msg_body != null) {
            this.msg_head.length = (short) (UdpConfig.HEAD_LENGTH + this.msg_body.length);
        } else {
            this.msg_head.length = (short) UdpConfig.HEAD_LENGTH;
        }
        byte[] data = this.msg_head.getData();
        byte[] bArr = this.msg_body;
        return (bArr == null || bArr.length == 0) ? data : BytesUtils.arrayComb(data, bArr);
    }

    /* access modifiers changed from: protected */
    public boolean isResultSucc(JSONObject jSONObject) {
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            try {
                if (jSONObject.getInt(DownloadTask.STATUS) == 0) {
                    return true;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isResultSucc(JSONArray jSONArray) {
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            try {
                if (jSONArray.getInt(0) == 0) {
                    return true;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String toString() {
        String str = "";
        if (this.msg_head == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.msg_head.toString());
        if (this.msg_body != null) {
            str = new String(this.msg_body);
        }
        sb.append(str);
        return sb.toString();
    }
}
