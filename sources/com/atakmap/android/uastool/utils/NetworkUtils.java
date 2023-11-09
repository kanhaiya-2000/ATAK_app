package com.atakmap.android.uastool.utils;

import android.content.Context;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.comms.k;
import com.atakmap.coremap.log.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkUtils {
    private static final int DEFAULT_PORT = 49000;
    private static final String TAG = "NetworkUtils";

    private NetworkUtils() {
    }

    private static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp() && !nextElement.getDisplayName().equals("ppp0") && !nextElement.getDisplayName().startsWith("tun")) {
                    for (InterfaceAddress address : nextElement.getInterfaceAddresses()) {
                        InetAddress address2 = address.getAddress();
                        if (!address2.isLoopbackAddress() && (address2 instanceof Inet4Address) && !address2.getHostAddress().equals("0.0.0.0")) {
                            return address2.getHostAddress();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "error getting address", e);
        }
        return k.a();
    }

    private static String getLastOctet(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(46));
    }

    public static String getDefaultMulticastIpAddress(Context context) {
        String ipAddress = getIpAddress();
        if (ipAddress.contentEquals("")) {
            return context.getString(C1877R.string.default_multicast_base_address) + ".1";
        }
        String str = null;
        try {
            str = getLastOctet(ipAddress);
        } catch (Exception e) {
            Log.e(TAG, "Exception getting last octet", e);
        }
        StringBuilder sb = new StringBuilder(context.getString(C1877R.string.default_multicast_base_address));
        if (str == null || str.isEmpty()) {
            sb.append(".1");
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String getDefaultMulticastPort() {
        String ipAddress = getIpAddress();
        if (ipAddress.contentEquals("")) {
            Integer num = 49001;
            return num.toString();
        }
        int i = 1;
        try {
            String lastOctet = getLastOctet(ipAddress);
            if (lastOctet != null && !lastOctet.isEmpty()) {
                if (lastOctet.startsWith(".")) {
                    lastOctet = lastOctet.substring(1);
                }
                i = Utils.parseInt(lastOctet, 1);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception getting last octet", e);
        }
        return Integer.valueOf(i + DEFAULT_PORT).toString();
    }
}
