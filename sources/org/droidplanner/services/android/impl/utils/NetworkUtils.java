package org.droidplanner.services.android.impl.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import atakplugin.UASTool.cqb;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramSocket;
import java.net.Socket;
import org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection;

public class NetworkUtils {
    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!isOnSololinkNetwork(context) && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static String getCurrentWifiLink(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        return connectionInfo.getSSID().replace("\"", "");
    }

    public static boolean isOnSololinkNetwork(Context context) {
        return isSoloNetwork(getCurrentWifiLink(context));
    }

    public static boolean isSoloNetwork(String str) {
        return str != null && str.startsWith("SoloLink_");
    }

    public static void bindSocketToNetwork(Bundle bundle, Socket socket) {
        Network network;
        if (Build.VERSION.SDK_INT >= 21) {
            if (bundle == null) {
                network = null;
            } else {
                network = (Network) bundle.getParcelable(MavLinkConnection.EXTRA_NETWORK);
            }
            bindSocketToNetwork(network, socket);
        }
    }

    public static void bindSocketToNetwork(Network network, Socket socket) {
        if (Build.VERSION.SDK_INT >= 21 && network != null && socket != null) {
            cqb.m12007b("Binding socket to network %s", network);
            network.bindSocket(socket);
        }
    }

    public static void bindSocketToNetwork(Bundle bundle, DatagramSocket datagramSocket) {
        Network network;
        if (Build.VERSION.SDK_INT >= 21) {
            if (bundle == null) {
                network = null;
            } else {
                network = (Network) bundle.getParcelable(MavLinkConnection.EXTRA_NETWORK);
            }
            bindSocketToNetwork(network, datagramSocket);
        }
    }

    public static void bindSocketToNetwork(Network network, DatagramSocket datagramSocket) {
        if (network != null && datagramSocket != null) {
            cqb.m12007b("Binding datagram socket to network %s", network);
            if (Build.VERSION.SDK_INT >= 23) {
                network.bindSocket(datagramSocket);
            } else if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Network.class.getMethod("bindSocket", new Class[]{DatagramSocket.class}).invoke(network, new Object[]{datagramSocket});
                } catch (IllegalAccessException | NoSuchMethodException e) {
                    cqb.m12015e(e, "Unable to access Network#bindSocket(DatagramSocket).", new Object[0]);
                } catch (InvocationTargetException e2) {
                    cqb.m12015e(e2, "Unable to invoke Network#bindSocket(DatagramSocket).", new Object[0]);
                }
            }
        }
    }
}
