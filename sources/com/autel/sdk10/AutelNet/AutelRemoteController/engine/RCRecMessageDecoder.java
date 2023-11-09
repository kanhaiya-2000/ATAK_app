package com.autel.sdk10.AutelNet.AutelRemoteController.engine;

import com.autel.sdk10.utils.BytesUtils;

public final class RCRecMessageDecoder {
    private RCRecMessageDecoder() {
    }

    public static Object getResult(RCCommandMessage rCCommandMessage) {
        switch (rCCommandMessage.getMsgId()) {
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 17:
            case 18:
            case 19:
            case 20:
                return Integer.valueOf(decodeResultFor1Byte(rCCommandMessage));
            case 2:
            case 11:
            case 12:
                return Integer.valueOf(decodeResultFor4Byte(rCCommandMessage));
            case 4:
                return decodeResultForRemoteLangue(rCCommandMessage);
            case 13:
                return decodeRemoteUploadData(rCCommandMessage);
            case 14:
                return decodeRemoteTKData(rCCommandMessage);
            case 15:
                return decodeRemoteInfoData(rCCommandMessage);
            case 16:
                return decodeRemoteVersionData(rCCommandMessage);
            default:
                return null;
        }
    }

    private static boolean checkHead(byte[] bArr) {
        return bArr[0] == 65 && bArr[1] == 84;
    }

    private static short getTempLen(byte[] bArr) {
        return BytesUtils.getShort(new byte[]{bArr[2], bArr[3]});
    }

    private static int decodeResultFor1Byte(RCCommandMessage rCCommandMessage) {
        byte[] data = rCCommandMessage.getData();
        if (!checkHead(data) || data.length <= 6) {
            return -1;
        }
        return BytesUtils.getInt(data[6]);
    }

    private static int[] decodeResultForRemoteLangue(RCCommandMessage rCCommandMessage) {
        byte[] data = rCCommandMessage.getData();
        if (!checkHead(data) || data.length <= 6) {
            return null;
        }
        int length = data.length - 6;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = BytesUtils.getInt(data[i + 6]);
        }
        return iArr;
    }

    private static int decodeResultFor4Byte(RCCommandMessage rCCommandMessage) {
        byte[] data = rCCommandMessage.getData();
        if (!checkHead(data) || data.length <= 9) {
            return -1;
        }
        return BytesUtils.getInt(new byte[]{data[6], data[7], data[8], data[9]});
    }

    private static int[] decodeRemoteTKData(RCCommandMessage rCCommandMessage) {
        int[] iArr = new int[8];
        byte[] data = rCCommandMessage.getData();
        if (checkHead(data) && data.length > 21) {
            for (int i = 0; i < 8; i++) {
                int i2 = (i * 2) + 6;
                byte[] bArr = {data[i2], data[i2 + 1]};
                if (i < 5) {
                    iArr[i] = convert(BytesUtils.getInt(bArr));
                } else {
                    iArr[i] = BytesUtils.getInt(bArr);
                }
            }
        }
        return iArr;
    }

    private static int convert(int i) {
        return ((i - 1024) * 200) / 1330;
    }

    private static int[] decodeRemoteInfoData(RCCommandMessage rCCommandMessage) {
        int[] iArr = new int[4];
        byte[] data = rCCommandMessage.getData();
        if (checkHead(data) && data.length > 9) {
            iArr[0] = BytesUtils.getInt(data[6]);
            iArr[1] = BytesUtils.getInt(data[7]);
            iArr[2] = BytesUtils.getInt(data[8]);
            iArr[3] = BytesUtils.getInt(data[9]);
        }
        return iArr;
    }

    private static int[] decodeRemoteVersionData(RCCommandMessage rCCommandMessage) {
        int[] iArr = new int[3];
        byte[] data = rCCommandMessage.getData();
        if (checkHead(data) && data.length > 13) {
            iArr[0] = BytesUtils.getInt(new byte[]{data[6], data[7]});
            iArr[1] = BytesUtils.getInt(new byte[]{data[8], data[9]});
            iArr[2] = BytesUtils.getInt(new byte[]{data[10], data[11], data[12], data[13]});
        }
        return iArr;
    }

    private static int[] decodeRemoteUploadData(RCCommandMessage rCCommandMessage) {
        int[] iArr = new int[2];
        byte[] data = rCCommandMessage.getData();
        if (checkHead(data) && data.length > 7) {
            iArr[0] = BytesUtils.getInt(data[6]);
            iArr[1] = BytesUtils.getInt(data[7]);
        }
        return iArr;
    }
}
