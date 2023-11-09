package com.atakmap.android.uastool.p000av;

import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.coremap.log.Log;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.atakmap.android.uastool.av.DDLHandler */
public class DDLHandler implements Runnable {
    private static final int RX_PORT = 49173;
    private static final String TAG = "DDLHandler";
    private static ByteBuffer messageBuffer;
    private boolean cancelled = false;
    private final CaptureToStorage captureToStorage;
    private final List<DDLNodeDirectoryItem> ddlNodeList;

    /* renamed from: ds */
    private DatagramSocket f8386ds;
    private long lastNodeUpdate;
    private final Object lockDdlNodeList;
    private final byte[] receiveData;
    private final DatagramPacket receivePacket;
    private int rssi;
    private String uasCallsign;
    private String uasGuid;

    public DDLHandler(boolean z) {
        byte[] bArr = new byte[65536];
        this.receiveData = bArr;
        this.receivePacket = new DatagramPacket(bArr, bArr.length);
        this.lockDdlNodeList = new Object();
        CaptureToStorage captureToStorage2 = new CaptureToStorage("ddl");
        this.captureToStorage = captureToStorage2;
        captureToStorage2.setCaptureToStorage(z);
        this.ddlNodeList = new ArrayList();
        this.lastNodeUpdate = 0;
        messageBuffer = ByteBuffer.allocate(bArr.length * 2);
        try {
            this.f8386ds = new DatagramSocket((SocketAddress) null);
        } catch (SocketException unused) {
        }
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void run() {
        try {
            this.f8386ds.setReuseAddress(true);
            this.f8386ds.bind(new InetSocketAddress(RX_PORT));
        } catch (SocketException e) {
            Log.d(TAG, "Datagram socket exception: " + e.getMessage());
        }
        while (true) {
            synchronized (this) {
                if (!this.cancelled) {
                    try {
                        this.receivePacket.setLength(this.receiveData.length);
                        this.f8386ds.receive(this.receivePacket);
                        this.captureToStorage.saveToFile(this.receivePacket);
                        messageBuffer.clear();
                        messageBuffer.put(Arrays.copyOfRange(this.receivePacket.getData(), this.receivePacket.getOffset(), this.receivePacket.getLength()));
                        messageBuffer.flip();
                        byte[] bArr = new byte[messageBuffer.remaining()];
                        messageBuffer.get(bArr);
                        String str = new String(bArr);
                        if (str.contains("session_node_directory")) {
                            handleNodesMessage(str);
                        } else if (str.contains("node_radio_status")) {
                            handleRadioStatusMessage(str);
                        }
                    } catch (IOException e2) {
                        Log.d(TAG, "Receive exception: " + e2.getMessage());
                    }
                } else {
                    return;
                }
            }
        }
        try {
            Thread.sleep(250);
        } catch (Exception e3) {
            Log.d(TAG, "Receive exception: " + e3.getMessage());
        }
    }

    private void handleNodesMessage(String str) {
        try {
            synchronized (this.lockDdlNodeList) {
                this.ddlNodeList.clear();
                this.lastNodeUpdate = System.currentTimeMillis();
            }
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName("entry");
            boolean z = false;
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                if (item.getNodeType() == 1) {
                    Element element = (Element) item;
                    DDLNodeDirectoryItem dDLNodeDirectoryItem = new DDLNodeDirectoryItem(Integer.decode(element.getAttribute("suid")).intValue(), Integer.decode(element.getAttribute("type")).intValue(), Integer.decode(element.getAttribute("alloc_bw")).intValue(), element.getAttribute(UASTask.COTDETAIL_NAME), element.getAttribute("guid"));
                    synchronized (this.lockDdlNodeList) {
                        this.ddlNodeList.add(dDLNodeDirectoryItem);
                    }
                    if (!z) {
                        if (dDLNodeDirectoryItem.getType() == 1 && dDLNodeDirectoryItem.getSuid() >= 16) {
                            this.uasCallsign = dDLNodeDirectoryItem.getName();
                            this.uasGuid = dDLNodeDirectoryItem.getGuid();
                            z = true;
                        }
                    }
                }
            }
        } catch (IOException | ParserConfigurationException e) {
            Log.d(TAG, "Exception: " + e.getMessage());
        } catch (SAXException unused) {
        }
    }

    public List<DDLNodeDirectoryItem> getNodes() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.lockDdlNodeList) {
            if (currentTimeMillis - this.lastNodeUpdate > 30000) {
                Log.d("AVDebug", "Too much time since last node update " + (currentTimeMillis - this.lastNodeUpdate));
                this.ddlNodeList.clear();
            }
            arrayList = new ArrayList(this.ddlNodeList);
        }
        return arrayList;
    }

    private void handleRadioStatusMessage(String str) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName("node_radio_status");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                if (item.getNodeType() == 1) {
                    this.rssi = Integer.decode(((Element) item).getAttribute("rssi")).intValue();
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            Log.d(TAG, "Exception: " + e.getMessage());
        }
    }

    public int getRssi() {
        int i = this.rssi;
        if (i == 0) {
            return -95;
        }
        return i;
    }

    public String getUasCallsign() {
        return this.uasCallsign;
    }

    public String getUasGuid() {
        return this.uasGuid;
    }

    public void setCaptureToStorage(boolean z) {
        this.captureToStorage.setCaptureToStorage(z);
    }
}
