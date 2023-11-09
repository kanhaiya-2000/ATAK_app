package com.autel.downloader.client;

import android.util.Log;
import android.util.SparseArray;
import atakplugin.UASTool.brw;
import atakplugin.UASTool.bsb;
import atakplugin.UASTool.bsh;
import com.autel.downloader.error.HttpDownloadError;
import com.autel.util.log.AutelLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class OkHttpClientManager implements IHttpClientInterface {
    private brw mOkHttpClient;
    private SparseArray<bsh> responseList;

    public OkHttpClientManager() {
        this.mOkHttpClient = null;
        this.responseList = null;
        this.mOkHttpClient = new brw.C0231a().mo3296a((long) HeartBeat.HEARTBEAT_NORMAL_TIMEOUT, TimeUnit.MILLISECONDS).mo3315b(HeartBeat.HEARTBEAT_NORMAL_TIMEOUT, TimeUnit.MILLISECONDS).mo3321c(HeartBeat.HEARTBEAT_NORMAL_TIMEOUT, TimeUnit.MILLISECONDS).mo3323c();
        this.responseList = new SparseArray<>();
    }

    public OkHttpClientManager(brw brw) {
        this.mOkHttpClient = null;
        this.responseList = null;
        this.mOkHttpClient = brw;
        this.responseList = new SparseArray<>();
    }

    public void download(int i, String str, long j, boolean z) {
        bsb.C0234a a = new bsb.C0234a().mo3360a(str);
        if (j > 0 && z) {
            a.mo3367b("RANGE", "bytes=" + j + "-");
            StringBuilder sb = new StringBuilder();
            sb.append("resume range:");
            sb.append(j);
            AutelLog.m15082d("OkHttpClientManager", sb.toString());
        }
        bsh b = this.mOkHttpClient.mo3060a(a.mo3371d()).mo3056b();
        if (b.mo3380d()) {
            synchronized (this) {
                this.responseList.remove(i);
                this.responseList.put(i, b);
            }
            return;
        }
        b.close();
        throw new HttpDownloadError(b.mo3378c());
    }

    public int code(int i) {
        return this.responseList.get(i).mo3378c();
    }

    public synchronized boolean isSuccessful(int i) {
        return this.responseList.get(i).mo3380d();
    }

    public String header(int i, String str) {
        Log.d("Ivanwu", this.responseList.get(i).mo3383g().toString());
        return this.responseList.get(i).mo3377b(str);
    }

    public long contentLength(int i) {
        return this.responseList.get(i).mo3384h().mo3017b();
    }

    public InputStream byteStream(int i) {
        bsh bsh = this.responseList.get(i);
        InputStream d = bsh.mo3384h().mo3412d();
        Log.d("Ivanwu", "11111length:" + bsh.mo3384h().mo3017b());
        if (d != null) {
            try {
                if (bsh.mo3384h().mo3017b() > 0) {
                    return d;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return d;
            }
        }
        Log.d("Ivanwu", "length:" + bsh.mo3384h().mo3017b());
        return new ByteArrayInputStream(bsh.mo3384h().mo3413e());
    }

    public void close(int i) {
        if (this.responseList.get(i) != null) {
            this.responseList.get(i).close();
        }
        synchronized (this) {
            this.responseList.remove(i);
        }
    }

    public brw getOkHttpClient() {
        return this.mOkHttpClient;
    }
}
