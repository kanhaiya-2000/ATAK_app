package com.atakmap.android.uastool.PD100;

import com.atakmap.comms.j;
import com.atakmap.coremap.log.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

class Stanag4586Server extends Thread implements AutoCloseable {
    private static final int MAX_STANAG_DATA_SIZE = 514;
    private static final String TAG = "Stanag4586Server";
    private volatile boolean cancelled = false;
    private Thread heartbeatThread;
    private long lastUpdate;
    private String listenAddress;
    private String listenNetwork;
    private int listenPort = 0;
    private MulticastSocket listenSocket;
    private final PD100Monitor monitor;
    private final int receiveBufferSize = 65536;
    private final byte[] udpReceiveData;
    private final DatagramPacket udpReceivePacket;
    private String upAddress;
    private int upPort = 0;

    private void setupScheduledMessages() {
    }

    public Stanag4586Server(PD100Monitor pD100Monitor) {
        byte[] bArr = new byte[65536];
        this.udpReceiveData = bArr;
        this.udpReceivePacket = new DatagramPacket(bArr, bArr.length);
        this.heartbeatThread = null;
        this.lastUpdate = 0;
        this.monitor = pD100Monitor;
    }

    public void setListenAddress(String str, int i, String str2) {
        this.listenAddress = str;
        this.listenPort = i;
        this.listenNetwork = str2;
    }

    public void setUplinkAddress(String str, int i) {
        this.upAddress = str;
        this.upPort = i;
    }

    private void send4586Hello(String str, int i) {
        new Thread(new Runnable(str, i) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Stanag4586Server.this.lambda$send4586Hello$0$Stanag4586Server(this.f$1, this.f$2);
            }
        }).start();
    }

    public /* synthetic */ void lambda$send4586Hello$0$Stanag4586Server(String str, int i) {
        try {
            sleep(100);
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] renderCUCSAuthRequestFrame = renderCUCSAuthRequestFrame();
            if (renderCUCSAuthRequestFrame != null) {
                datagramSocket.send(new DatagramPacket(renderCUCSAuthRequestFrame, renderCUCSAuthRequestFrame.length, InetAddress.getByName(str), i));
            }
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    public void close() {
        this.cancelled = true;
        interrupt();
    }

    public void run() {
        this.cancelled = false;
        send4586Hello(this.upAddress, this.upPort);
        while (true) {
            j.a aVar = null;
            if (!this.cancelled) {
                try {
                    InetAddress byName = InetAddress.getByName(this.listenAddress);
                    for (j.a aVar2 : j.a()) {
                        if (aVar2.b.equals(this.listenNetwork)) {
                            aVar = aVar2;
                        }
                    }
                    if (aVar == null) {
                        cancel();
                        return;
                    }
                    NetworkInterface a = aVar.a();
                    if (a == null) {
                        break;
                    } else if (!a.isUp()) {
                        break;
                    } else {
                        if (this.listenSocket == null) {
                            this.listenSocket = new MulticastSocket(this.listenPort);
                            if (byName.isMulticastAddress()) {
                                this.listenSocket.joinGroup(new InetSocketAddress(this.listenAddress, this.listenPort), a);
                            }
                        }
                        this.udpReceivePacket.setLength(this.udpReceiveData.length);
                        this.listenSocket.receive(this.udpReceivePacket);
                        if (this.udpReceivePacket.getLength() <= 0) {
                            Log.d(TAG, "STANAG packet ZERO");
                        } else {
                            this.lastUpdate = System.currentTimeMillis();
                            ByteBuffer allocate = ByteBuffer.allocate(this.udpReceiveData.length * 2);
                            allocate.put(Arrays.copyOfRange(this.udpReceivePacket.getData(), this.udpReceivePacket.getOffset(), this.udpReceivePacket.getLength()));
                            allocate.flip();
                            byte b = 49;
                            ArrayList arrayList = new ArrayList();
                            Log.d(TAG, "=============");
                            int i = 0;
                            int i2 = 0;
                            while (allocate.hasRemaining()) {
                                i++;
                                if (allocate.get() == b) {
                                    i++;
                                    if (allocate.get() == 48) {
                                        allocate.position(i + 8);
                                        int i3 = allocate.getInt();
                                        int i4 = allocate.getInt();
                                        int i5 = allocate.getInt();
                                        int i6 = allocate.getInt();
                                        int i7 = allocate.getInt();
                                        if (i5 <= MAX_STANAG_DATA_SIZE) {
                                            byte[] bArr = new byte[i5];
                                            allocate.get(bArr);
                                            int i8 = allocate.getInt();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Packet: ");
                                            int i9 = i2 + 1;
                                            sb.append(i2);
                                            sb.append(" Id: ");
                                            sb.append(i3);
                                            sb.append(" Type: ");
                                            sb.append(i4);
                                            sb.append(" Len: ");
                                            sb.append(i5);
                                            sb.append(" StreamId: ");
                                            sb.append(i6);
                                            sb.append(" pktSeqNum: ");
                                            sb.append(i7);
                                            sb.append(" ckSum: ");
                                            sb.append(i8);
                                            Log.d(TAG, sb.toString());
                                            handleMessage(i4, bArr);
                                            Log.d(TAG, "=============");
                                            if (!arrayList.contains(Integer.valueOf(i4))) {
                                                arrayList.add(Integer.valueOf(i4));
                                            }
                                            i = allocate.position();
                                            i2 = i9;
                                        }
                                    }
                                }
                                b = 49;
                            }
                            Log.d(TAG, "=============");
                            Log.d(TAG, "Found Message Types:");
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Log.d(TAG, String.valueOf((Integer) it.next()));
                            }
                            Log.d(TAG, "=============");
                            allocate.compact();
                            this.monitor.onStanagConnectionActivity();
                        }
                    }
                } catch (Exception e) {
                    Log.d(TAG, "STANAG Error: Exception encountered in UDP receive socket :" + e.getMessage());
                }
            } else {
                Log.d(TAG, "Stopping STANAG...");
                MulticastSocket multicastSocket = this.listenSocket;
                if (multicastSocket != null) {
                    multicastSocket.close();
                    this.listenSocket = null;
                    return;
                }
                return;
            }
        }
        cancel();
    }

    public void cancel() {
        this.cancelled = true;
        MulticastSocket multicastSocket = this.listenSocket;
        if (multicastSocket != null) {
            multicastSocket.close();
            this.listenSocket = null;
        }
    }

    private boolean handleMessage(int i, byte[] bArr) {
        if (i == 1) {
            new CUCSAuthRequest(bArr);
        } else if (i == 46) {
            new FlightTerminationCommand(bArr);
        } else if (i == 104) {
            new VehicleOperatingStates(bArr);
        } else if (i == 110) {
            new FromToNextWaypointStates(bArr);
        } else if (i == 900) {
            new MissionUploadDownloadStatus(bArr);
        } else if (i == 1200) {
            new FieldConfigurationRequest(bArr);
        } else if (i == 1203) {
            new ConfigurationComplete(bArr);
        } else if (i == 2326) {
            Log.d(TAG, i + ": NOT IMPLEMENTED");
        } else if (i == 20) {
            new VehicleID(bArr);
        } else if (i == 21) {
            new VSMAuthResponse(bArr);
            setupHeartbeat();
        } else if (i == 101) {
            new InertialStates(bArr);
        } else if (i == 102) {
            new AirGroundRelativeStates(bArr);
        } else if (i == 200) {
            new PayloadSteeringCommand(bArr);
        } else if (i != 201) {
            switch (i) {
                case 42:
                    new VehicleOperatingModeCommand(bArr);
                    break;
                case 43:
                    new VehicleSteeringCommand(bArr);
                    break;
                case 44:
                    new AirVehicleLights(bArr);
                    break;
                default:
                    switch (i) {
                        case 106:
                            new VehicleOperatingModeSupport(bArr);
                            break;
                        case 107:
                            new VehicleLightsState(bArr);
                            break;
                        case 108:
                            new FlightTerminationModeReport(bArr);
                            break;
                        default:
                            switch (i) {
                                case 300:
                                    new PayloadConfiguration(bArr);
                                    break;
                                case 301:
                                    new EoIrConfigurationState(bArr);
                                    break;
                                case 302:
                                    new EoIrLaserOperatingState(bArr);
                                    break;
                                default:
                                    switch (i) {
                                        case 800:
                                            new MissionTransferCommand(bArr);
                                            break;
                                        case 801:
                                            new AvRoute(bArr);
                                            break;
                                        case 802:
                                            new AvPositionWaypoint(bArr);
                                            break;
                                        default:
                                            switch (i) {
                                                case 1300:
                                                    new FieldConfigurationIntegerResponse(bArr);
                                                    break;
                                                case 1301:
                                                    new FieldConfigurationDoubleResponse(bArr);
                                                    break;
                                                case 1302:
                                                    new FieldConfigurationEnumeratedResponse(bArr);
                                                    break;
                                                case 1303:
                                                    new FieldConfigurationCommand(bArr);
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 1400:
                                                            new MessageAcknowledgement(bArr);
                                                            break;
                                                        case 1401:
                                                            new MessageAcknowledgmentConfiguration(bArr);
                                                            break;
                                                        case 1402:
                                                            new ScheduleMessageUpdateCommand(bArr);
                                                            break;
                                                        case 1403:
                                                            new GenericInformationRequestMessage(bArr);
                                                            break;
                                                        default:
                                                            try {
                                                                Log.d(TAG, "Unexpected STANAG4586 message type: " + i);
                                                                break;
                                                            } catch (Exception e) {
                                                                Log.d(TAG, i + " STANAG4586 EXCEPTION: ", e);
                                                                return false;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            new EoIrLaserPayloadCommand(bArr);
        }
        return true;
    }

    private void setupHeartbeat() {
        if (this.heartbeatThread == null) {
            Thread thread = new Thread(new Runnable() {
                public final void run() {
                    Stanag4586Server.this.lambda$setupHeartbeat$1$Stanag4586Server();
                }
            });
            this.heartbeatThread = thread;
            thread.start();
        }
    }

    public /* synthetic */ void lambda$setupHeartbeat$1$Stanag4586Server() {
        while (!Thread.interrupted()) {
            try {
                try {
                    if (System.currentTimeMillis() - this.lastUpdate > 2000) {
                        DatagramSocket datagramSocket = new DatagramSocket();
                        byte[] renderGenericInformationRequestMessageFrame = renderGenericInformationRequestMessageFrame(20);
                        datagramSocket.send(new DatagramPacket(renderGenericInformationRequestMessageFrame, renderGenericInformationRequestMessageFrame.length, InetAddress.getByName(this.upAddress), this.upPort));
                    }
                } catch (IOException e) {
                    Log.d(TAG, "Could not send heartbeat", e);
                }
                Thread.sleep(1000);
            } catch (InterruptedException unused) {
                Log.d(TAG, "Heartbeat thread interrupted");
            }
        }
        this.heartbeatThread = null;
    }

    static String byteToHex(byte b) {
        return String.format("%02x", new Object[]{Byte.valueOf(b)});
    }

    static String buildTimestamp(double d) {
        return new SimpleDateFormat("MM-dd-yyyy kk:mm:ss").format(new Date(((long) d) * 1000));
    }

    static String getControlledStation(int i) {
        if (i == 0) {
            return "No Change";
        }
        if (i == 1) {
            return "Stn #1";
        }
        if (i == 2) {
            return "Stn #2";
        }
        if (i == 4) {
            return "Stn #3";
        }
        if (i == 8) {
            return "Stn #4";
        }
        if (i == 16) {
            return "Stn #5";
        }
        if (i == 32) {
            return "Stn #6";
        }
        if (i == 64) {
            return "Stn #7";
        }
        if (i == 128) {
            return "Stn #8";
        }
        return "Unknown Controlled Station: " + i;
    }

    static String getControlledStationMode(byte b) {
        if (b == 0) {
            return "Relinquish/Handoff Control";
        }
        if (b == 1) {
            return "Request Control";
        }
        if (b == 2) {
            return "Override Control";
        }
        return "Unknown Controlled Station Mode: " + b;
    }

    public byte[] renderCUCSAuthRequestFrame() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(49);
            byteArrayOutputStream.write(48);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(101);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(1);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(35);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putDouble((double) System.currentTimeMillis());
            byteArrayOutputStream.write(allocate.array());
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(111);
            byteArrayOutputStream.write(111);
            byteArrayOutputStream.write(222);
            byteArrayOutputStream.write(106);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(1);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(1);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int calculateCRC = calculateCRC(Arrays.copyOfRange(byteArray, 0, byteArray.length - 4));
            byteArray[byteArray.length - 4] = (byte) ((calculateCRC >> 24) & 255);
            byteArray[byteArray.length - 3] = (byte) ((calculateCRC >> 16) & 255);
            byteArray[byteArray.length - 2] = (byte) ((calculateCRC >> 8) & 255);
            byteArray[byteArray.length - 1] = (byte) (calculateCRC & 255);
            return byteArray;
        } catch (IOException unused) {
            return null;
        }
    }

    public byte[] renderGenericInformationRequestMessageFrame(int i) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(49);
            byteArrayOutputStream.write(48);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(101);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(1);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(32);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putDouble((double) System.currentTimeMillis());
            byteArrayOutputStream.write(allocate.array());
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(255);
            byteArrayOutputStream.write(111);
            byteArrayOutputStream.write(111);
            byteArrayOutputStream.write(222);
            byteArrayOutputStream.write(106);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(i);
            byteArrayOutputStream.write(allocate2.array());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(20);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int calculateCRC = calculateCRC(Arrays.copyOfRange(byteArray, 0, byteArray.length - 4));
            byteArray[byteArray.length - 4] = (byte) ((calculateCRC >> 24) & 255);
            byteArray[byteArray.length - 3] = (byte) ((calculateCRC >> 16) & 255);
            byteArray[byteArray.length - 2] = (byte) ((calculateCRC >> 8) & 255);
            byteArray[byteArray.length - 1] = (byte) (calculateCRC & 255);
            return byteArray;
        } catch (IOException unused) {
            return null;
        }
    }

    public static int calculateCRC(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += b & 255;
        }
        return i & -1;
    }
}
