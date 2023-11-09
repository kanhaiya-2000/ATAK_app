package com.autel.internal.network.usb.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import com.autel.internal.network.usb.broadcast.UsbReceiver;
import com.autel.util.log.AutelLogTags;
import com.autel.video.NetWorkProxyJni;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UsbAccessoryService {
    public static final String ACTION_USB_PERMISSION = "org.ammlab.android.app.helloadk.action.USB_PERMISSION";
    /* access modifiers changed from: private */
    public int mFailedCount;
    private ParcelFileDescriptor mFileDescriptor;
    /* access modifiers changed from: private */
    public FileInputStream mInputStream;
    private FileOutputStream mOutputStream;
    private Thread mReceiveUsbThread = null;

    static /* synthetic */ int access$108(UsbAccessoryService usbAccessoryService) {
        int i = usbAccessoryService.mFailedCount;
        usbAccessoryService.mFailedCount = i + 1;
        return i;
    }

    public UsbAccessoryService(ParcelFileDescriptor parcelFileDescriptor) {
        this.mFileDescriptor = parcelFileDescriptor;
        this.mInputStream = new FileInputStream(this.mFileDescriptor.getFileDescriptor());
        this.mOutputStream = new FileOutputStream(this.mFileDescriptor.getFileDescriptor());
    }

    public void start() {
        destoryThread();
        Thread thread = new Thread(new UsbRvcThread(), "UsbRvcThread");
        this.mReceiveUsbThread = thread;
        thread.start();
    }

    public boolean isUsbOpened() {
        return (this.mInputStream == null || this.mOutputStream == null) ? false : true;
    }

    public boolean sendCommand(byte[] bArr, int i) {
        if (this.mOutputStream != null && isUsbOpened()) {
            try {
                this.mOutputStream.write(bArr, 0, i);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(AutelLogTags.TAG_USB, "write onFailure:" + e.getMessage());
            }
        }
        return false;
    }

    class UsbRvcThread implements Runnable {
        UsbRvcThread() {
        }

        public void run() {
            Process.setThreadPriority(Process.myTid(), -18);
            byte[] bArr = new byte[98304];
            Log.d(AutelLogTags.TAG_USB, "accessory opened UsbRvcThread ");
            while (!Thread.currentThread().isInterrupted()) {
                int i = 0;
                try {
                    if (UsbAccessoryService.this.isUsbOpened()) {
                        i = UsbAccessoryService.this.mInputStream.read(bArr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    UsbAccessoryService.access$108(UsbAccessoryService.this);
                    if (UsbAccessoryService.this.mFailedCount > 100) {
                        int unused = UsbAccessoryService.this.mFailedCount = 0;
                        Context context = AutelUSBHelper.instance().getContext();
                        if (context != null) {
                            context.sendBroadcast(new Intent(UsbReceiver.USB_RESET));
                        }
                    }
                }
                if (i > 0) {
                    NetWorkProxyJni.writeProxyData(bArr, i);
                }
            }
        }
    }

    public void destoryThread() {
        Thread thread = this.mReceiveUsbThread;
        if (thread != null && !thread.isInterrupted()) {
            this.mReceiveUsbThread.interrupt();
            this.mReceiveUsbThread = null;
        }
    }

    public void closeUsb() {
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.mFileDescriptor;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            FileOutputStream fileOutputStream = this.mOutputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.mOutputStream = null;
            }
            FileInputStream fileInputStream = this.mInputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
                this.mInputStream = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mFileDescriptor = null;
            throw th;
        }
        this.mFileDescriptor = null;
    }
}
