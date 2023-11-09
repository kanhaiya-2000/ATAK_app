package com.autel.AutelNet2.core.utils;

public class UdpConfig {
    public static int BUFFER_SIZE_1460 = 1460;
    public static int BUFFER_SIZE_524 = 524;
    public static String FLY_ROUTE_HOST_USB_ADDR = "127.0.0.1";
    public static int HEAD_LENGTH = 16;
    public static byte MAGIC0 = 0;
    public static byte MAGIC1 = 86;
    public static int RECEIVE_UDP_PORT = 5682;
    public static int SEND_UDP_PORT = 5681;
    public static int UPGRADE_SEND_UDP_PORT = 8081;
    public static byte VERSION = 1;
}
