package com.autel.internal.network.usb.proxy;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class AutelUSBHelper {
    private static AutelUSBHelper instance;
    private Context mContext;
    private ParcelFileDescriptor mFileDescriptor;
    private boolean mIsOpenSuccess = false;
    private UsbAccessoryService mUsbAccessoryService = null;

    public static AutelUSBHelper instance() {
        if (instance == null) {
            instance = new AutelUSBHelper();
        }
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mUsbAccessoryService;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isUsbOpened() {
        /*
            r1 = this;
            boolean r0 = r1.mIsOpenSuccess
            if (r0 == 0) goto L_0x0010
            com.autel.internal.network.usb.proxy.UsbAccessoryService r0 = r1.mUsbAccessoryService
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isUsbOpened()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.network.usb.proxy.AutelUSBHelper.isUsbOpened():boolean");
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void openAccessory(ParcelFileDescriptor parcelFileDescriptor) {
        this.mFileDescriptor = parcelFileDescriptor;
        if (parcelFileDescriptor != null) {
            UsbAccessoryService usbAccessoryService = new UsbAccessoryService(parcelFileDescriptor);
            this.mUsbAccessoryService = usbAccessoryService;
            usbAccessoryService.start();
            this.mIsOpenSuccess = true;
            return;
        }
        closeAccessory();
    }

    public boolean writeUsbData(byte[] bArr, int i) {
        UsbAccessoryService usbAccessoryService = this.mUsbAccessoryService;
        return usbAccessoryService != null && usbAccessoryService.sendCommand(bArr, i);
    }

    public void closeAccessory() {
        try {
            this.mIsOpenSuccess = false;
            UsbAccessoryService usbAccessoryService = this.mUsbAccessoryService;
            if (usbAccessoryService != null) {
                usbAccessoryService.destoryThread();
                this.mUsbAccessoryService.closeUsb();
                this.mUsbAccessoryService = null;
            }
            ParcelFileDescriptor parcelFileDescriptor = this.mFileDescriptor;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mFileDescriptor = null;
            throw th;
        }
        this.mFileDescriptor = null;
    }
}
