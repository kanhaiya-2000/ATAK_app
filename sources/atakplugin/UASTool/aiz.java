package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface aiz {
    Socket createSocket(String str, int i);

    InputStream getInputStream(Socket socket);

    OutputStream getOutputStream(Socket socket);
}
