package com.aeryon.java.types;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class AsyncDownload extends AsyncTask<Void, Integer, Boolean> {
    private static final String TAG = "com.aeryon.java.types.AsyncDownload";
    private Context activityContext;
    private AtomicReference<Runnable> callbackRef;
    private final String destinationPath;
    /* access modifiers changed from: private */
    public final ProgressBar progressBar;
    private final String sourceUri;

    public AsyncDownload(Context context, String str, String str2, ProgressBar progressBar2, Runnable runnable) {
        AtomicReference<Runnable> atomicReference = new AtomicReference<>((Object) null);
        this.callbackRef = atomicReference;
        this.sourceUri = str;
        this.destinationPath = str2;
        this.progressBar = progressBar2;
        atomicReference.set(runnable);
        this.activityContext = context;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(Void... voidArr) {
        try {
            String str = TAG;
            Log.d(str, "Starting connection to " + this.sourceUri);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.sourceUri).openConnection();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                Log.d(str, "Download of " + this.sourceUri.toString() + " failed with http response code: " + responseCode + " " + httpURLConnection.getResponseMessage());
                return false;
            }
            final double contentLength = (double) httpURLConnection.getContentLength();
            if (this.progressBar != null) {
                ((Activity) this.activityContext).runOnUiThread(new Runnable() {
                    public void run() {
                        AsyncDownload.this.progressBar.setMax((int) contentLength);
                    }
                });
            }
            byte[] bArr = new byte[4096];
            InputStream inputStream = httpURLConnection.getInputStream();
            new File(this.destinationPath).getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(this.destinationPath, false);
            double d = 0.0d;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    d += (double) read;
                    publishProgress(new Integer[]{Integer.valueOf((int) d)});
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    String str2 = TAG;
                    Log.d(str2, "Downloaded file to " + this.destinationPath);
                    return true;
                }
            }
        } catch (IOException e) {
            Log.d(TAG, "Download failed: ", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(numArr[0].intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        Runnable runnable = this.callbackRef.get();
        if (runnable != null) {
            new Thread(runnable).start();
        }
    }

    public void setCallback(Runnable runnable) {
        this.callbackRef.set(runnable);
    }
}
