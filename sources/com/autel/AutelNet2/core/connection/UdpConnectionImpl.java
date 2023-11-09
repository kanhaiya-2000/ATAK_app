package com.autel.AutelNet2.core.connection;

import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.utils.UdpConfig;
import com.autel.common.product.AutelProductType;
import com.autel.util.log.AutelLog;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class UdpConnectionImpl extends BaseUdpConnection {
    private static final long SEND_FAST = 1;
    private static final long SEND_MID = 2;
    private static final long SEND_MID_EVO = 3;
    private static final long SEND_SLOW = 10;
    private static final long SEND_SLOW_EVO = 20;
    private static final String TAG = "Upgrade";
    private byte[] arrayOfByte;
    int bufferLength = 1460;
    private boolean isRetry = false;
    private byte seekMagic = -5;
    private long seekPosition;
    private long send_sleep_time = SEND_MID_EVO;
    private DatagramSocket socket;
    private boolean stopSendFile = false;

    /* access modifiers changed from: protected */
    public void openConnection(int i) {
        DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
        this.socket = datagramSocket;
        datagramSocket.setReuseAddress(true);
        this.socket.setBroadcast(true);
        this.socket.bind(new InetSocketAddress(i));
    }

    /* access modifiers changed from: protected */
    public void closeConnection() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        short s;
        if (bArr != null) {
            try {
                int length = bArr.length;
                int i = this.bufferLength;
                if (length <= i) {
                    this.socket.send(new DatagramPacket(bArr, bArr.length, InetAddress.getByName(getTargetAddress()), UdpConfig.SEND_UDP_PORT));
                    return;
                }
                byte[] bArr2 = new byte[i];
                this.arrayOfByte = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, 16);
                this.arrayOfByte[3] = Byte.MIN_VALUE;
                int length2 = bArr.length - 16;
                int i2 = 16;
                short s2 = 0;
                while (length2 > 0) {
                    if (length2 >= this.bufferLength - 16) {
                        byte[] bArr3 = this.arrayOfByte;
                        System.arraycopy(bArr, i2, bArr3, 16, bArr3.length - 16);
                        byte[] bArr4 = this.arrayOfByte;
                        s = (short) bArr4.length;
                        int i3 = s - 16;
                        i2 += i3;
                        length2 -= i3;
                        int i4 = this.bufferLength;
                        bArr4[4] = (byte) (i4 >> 8);
                        bArr4[5] = (byte) (i4 & 255);
                    } else {
                        System.arraycopy(bArr, i2, this.arrayOfByte, 16, length2);
                        byte[] bArr5 = this.arrayOfByte;
                        bArr5[3] = 64;
                        s = (short) (length2 + 16);
                        i2 += length2;
                        length2 -= length2;
                        bArr5[4] = (byte) (s >> 8);
                        bArr5[5] = (byte) (s & 255);
                    }
                    byte[] bArr6 = this.arrayOfByte;
                    bArr6[14] = (byte) (s2 >> 8);
                    bArr6[15] = (byte) (s2 & 255);
                    s2 = (short) (s2 + 1);
                    Log.d("Upgrade", "send msg length:" + s + "  packageid:" + s2);
                    this.socket.send(new DatagramPacket(this.arrayOfByte, s, InetAddress.getByName(getTargetAddress()), UdpConfig.SEND_UDP_PORT));
                    this.arrayOfByte[3] = 0;
                    Thread.sleep(5);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Upgrade", "send msg Exception:" + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendInputStream(FileInputStream fileInputStream) {
        this.stopSendFile = false;
        if (AutelProductType.EVO_2 == AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getProduct()) {
            this.send_sleep_time = SEND_MID;
        } else {
            this.send_sleep_time = SEND_MID_EVO;
        }
        Log.d("Upgrade", "send sendInputStream length:");
        byte[] bArr = new byte[this.bufferLength];
        this.arrayOfByte = bArr;
        bArr[12] = 0;
        bArr[3] = Byte.MIN_VALUE;
        if (isRetry()) {
            this.arrayOfByte[12] = this.seekMagic;
            Log.d("Upgrade", "send sendInputStream retry squence = FB");
            if (getSeekPosition() >= 0) {
                fileInputStream.getChannel().position(getSeekPosition());
                Log.d("Upgrade", "send sendInputStream retry squence = FB getSeekPosition = " + getSeekPosition());
            }
            setRetry(false);
            setSeekPosition(0);
        }
        sendFileInputStream(fileInputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0094 A[Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b0 A[Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ea A[Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendFileInputStream(java.io.FileInputStream r15) {
        /*
            r14 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r1 = r14.bufferLength     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r2 = 16
            int r1 = r1 - r2
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000f:
            int r6 = r15.read(r1)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = -1
            java.lang.String r8 = "Upgrade"
            if (r6 == r7) goto L_0x00ef
            boolean r7 = r14.stopSendFile     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            if (r7 != 0) goto L_0x00ef
            r0.reset()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r0.write(r1, r3, r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r7 = r0.toByteArray()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r9 = r14.bufferLength     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r10 = r9 + -16
            r11 = 5
            r12 = 4
            r13 = 3
            if (r6 != r10) goto L_0x0046
            byte[] r5 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r6 = r7.length     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.lang.System.arraycopy(r7, r3, r5, r2, r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r5 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r6 = r5.length     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            short r6 = (short) r6     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r7 = r14.bufferLength     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r9 = r7 >> 8
            byte r9 = (byte) r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r5[r12] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r5[r11] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            goto L_0x0062
        L_0x0046:
            int r9 = r9 + -16
            if (r6 >= r9) goto L_0x0063
            byte[] r5 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.lang.System.arraycopy(r7, r3, r5, r2, r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r5 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 64
            r5[r13] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r6 = r6 + 16
            short r6 = (short) r6     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r7 = r6 >> 8
            byte r7 = (byte) r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r5[r12] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = r6 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r5[r11] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
        L_0x0062:
            r5 = r6
        L_0x0063:
            byte[] r6 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte r7 = com.autel.AutelNet2.core.utils.UdpConfig.MAGIC1     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r9 = 1
            r6[r9] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r6 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 2
            byte r9 = com.autel.AutelNet2.core.utils.UdpConfig.VERSION     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r6 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 6
            byte r9 = (byte) r2     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 7
            byte r9 = (byte) r3     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte r7 = (byte) r12     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r9 = 8
            r6[r9] = r7     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 9
            byte r9 = (byte) r3     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 10
            byte r9 = (byte) r13     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 11
            byte r9 = (byte) r11     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r4 <= r7) goto L_0x009b
            r7 = 13
            int r9 = r4 >> 16
            byte r9 = (byte) r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
        L_0x009b:
            r7 = 14
            int r9 = r4 >> 8
            byte r9 = (byte) r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 15
            r9 = r4 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r4 = r4 + 1
            r6 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 < r6) goto L_0x00c4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.lang.String r7 = "packageid 超出范围: packageid -> "
            r6.append(r7)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6.append(r4)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            com.autel.util.log.AutelLog.debug_i(r8, r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
        L_0x00c4:
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r7 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.lang.String r8 = r14.getTargetAddress()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r8)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            int r9 = com.autel.AutelNet2.core.utils.UdpConfig.SEND_UDP_PORT     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6.<init>(r7, r5, r8, r9)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            java.net.DatagramSocket r7 = r14.socket     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7.send(r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            byte[] r6 = r14.arrayOfByte     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r6[r13] = r3     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r7 = 12
            r6[r7] = r3     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            long r6 = r14.send_sleep_time     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x000f
            java.lang.Thread.sleep(r6)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            goto L_0x000f
        L_0x00ef:
            java.lang.String r1 = "send msg finish:"
            android.util.Log.d(r8, r1)     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r15.close()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0105, IOException -> 0x0100, InterruptedException -> 0x00fb }
            goto L_0x0109
        L_0x00fb:
            r15 = move-exception
            r15.printStackTrace()
            goto L_0x0109
        L_0x0100:
            r15 = move-exception
            r15.printStackTrace()
            goto L_0x0109
        L_0x0105:
            r15 = move-exception
            r15.printStackTrace()
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.AutelNet2.core.connection.UdpConnectionImpl.sendFileInputStream(java.io.FileInputStream):void");
    }

    /* access modifiers changed from: protected */
    public final int readDataBlock(byte[] bArr) {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        this.socket.receive(datagramPacket);
        return datagramPacket.getLength();
    }

    /* access modifiers changed from: protected */
    public String getTargetAddress() {
        return UdpConfig.FLY_ROUTE_HOST_USB_ADDR;
    }

    /* access modifiers changed from: protected */
    public int getUdpPort() {
        return UdpConfig.RECEIVE_UDP_PORT;
    }

    /* access modifiers changed from: protected */
    public void parseData(BaseMsgPacket baseMsgPacket) {
        PacketDisPatcher.getInstance().onDisPatchPacket(baseMsgPacket);
    }

    public void stopSendFile() {
        this.stopSendFile = true;
        this.isRetry = false;
    }

    public void setSend_sleep_time(int i) {
        AutelLog.m15084e("Upgrade", "setSend_sleep_time:state" + i);
        if (AutelProductType.EVO_2 == AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getProduct()) {
            this.send_sleep_time = SEND_MID;
            if (i == 9) {
                this.send_sleep_time = SEND_FAST;
            } else if (i == 10) {
                this.send_sleep_time = SEND_MID;
            } else if (i == 11) {
                this.send_sleep_time = SEND_SLOW;
            }
        } else {
            this.send_sleep_time = SEND_MID_EVO;
            if (i == 9) {
                this.send_sleep_time = SEND_FAST;
            } else if (i == 10) {
                this.send_sleep_time = SEND_MID_EVO;
            } else if (i == 11) {
                this.send_sleep_time = SEND_SLOW_EVO;
            }
        }
    }

    public boolean isRetry() {
        return this.isRetry;
    }

    public void setRetry(boolean z) {
        this.isRetry = z;
    }

    public long getSeekPosition() {
        return this.seekPosition;
    }

    public void setSeekPosition(long j) {
        this.seekPosition = j;
    }
}
