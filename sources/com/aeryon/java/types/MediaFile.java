package com.aeryon.java.types;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ProgressBar;
import com.aeryon.java.AdkInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MediaFile implements Serializable {
    private static final String BASE_DIRECTORY;
    public static final String MEDIA_DIRECTORY;
    public static final String SERIALIZATION_DIRECTORY;
    private static final String TAG = "ACTS_MEDIA_FILE";
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final long serialVersionUID = 9039563091583761247L;
    private String acSerial = null;
    private String aircraft;
    private String aircraftIP;
    private int dateCreated;
    /* access modifiers changed from: private */
    public boolean downloadedImage;
    private String downloadedPath;
    /* access modifiers changed from: private */
    public boolean downloadedThumbnail;
    private String downloadedThumbnailPath;
    private final String filePath;
    /* access modifiers changed from: private */
    public transient Runnable imageDownloadCallback;
    /* access modifiers changed from: private */
    public transient boolean imageDownloadInProgress = false;
    /* access modifiers changed from: private */
    public transient ReentrantLock imageStatusLock = new ReentrantLock();
    private String metadataFilename;
    private String mission;
    private String path;
    /* access modifiers changed from: private */
    public transient boolean thumbNailDownloadInProgress = false;
    /* access modifiers changed from: private */
    public transient Runnable thumbnailDownloadCallback;
    private String thumbnailPath;
    /* access modifiers changed from: private */
    public transient ReentrantLock thumbnailStatusLock = new ReentrantLock();

    static {
        String str = Environment.getExternalStorageDirectory() + "/Aeryon/";
        BASE_DIRECTORY = str;
        MEDIA_DIRECTORY = str + "data";
        SERIALIZATION_DIRECTORY = str + "metadata/";
    }

    protected MediaFile(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7) {
        this.path = str;
        this.thumbnailPath = str2;
        this.metadataFilename = str3;
        this.dateCreated = i;
        this.mission = str4;
        this.aircraft = str5;
        this.acSerial = str6;
        this.aircraftIP = str7;
        this.filePath = SERIALIZATION_DIRECTORY + str6 + "-" + i + "-" + str2.replace("/", "-") + ".ser";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.imageStatusLock = new ReentrantLock();
        this.thumbnailStatusLock = new ReentrantLock();
        this.imageDownloadInProgress = false;
        this.thumbNailDownloadInProgress = false;
        this.thumbnailDownloadCallback = null;
        this.imageDownloadCallback = null;
    }

    /* JADX INFO: finally extract failed */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("'path' : '" + this.path + "'\n");
        sb.append("'thumbnail' : '" + this.thumbnailPath + "'\n");
        sb.append("'metadata' : '" + this.metadataFilename + "'\n");
        this.imageStatusLock.lock();
        try {
            sb.append("'downloaded' : '" + this.downloadedImage + "'\n");
            this.imageStatusLock.unlock();
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            this.imageStatusLock.unlock();
            throw th;
        }
    }

    private String getThumbnailUri() {
        return "http://" + getActualIp() + ":8088" + this.thumbnailPath;
    }

    private String getImageUri() {
        return "http://" + getActualIp() + ":8088" + this.path;
    }

    private String getActualIp() {
        return prefs().getString("aircraftIp", this.aircraftIP);
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(AdkInterface.getContext());
    }

    public void downloadImage() {
        downloadImage((ProgressBar) null);
    }

    public void downloadImage(ProgressBar progressBar) {
        this.imageStatusLock.lock();
        try {
            if (!this.downloadedImage) {
                if (!this.imageDownloadInProgress) {
                    this.downloadedPath = MEDIA_DIRECTORY + this.path;
                    this.imageDownloadInProgress = true;
                    final AsyncDownload asyncDownload = new AsyncDownload(AdkInterface.getContext(), getImageUri(), this.downloadedPath, progressBar, (Runnable) null);
                    asyncDownload.setCallback(new Runnable() {
                        public void run() {
                            boolean z;
                            try {
                                z = ((Boolean) asyncDownload.get()).booleanValue();
                            } catch (Exception e) {
                                Log.e(MediaFile.TAG, "AsyncDownload failed: ", e);
                                z = false;
                            }
                            MediaFile.this.imageStatusLock.lock();
                            if (z) {
                                try {
                                    boolean unused = MediaFile.this.downloadedImage = true;
                                    MediaFile.this.saveToDisk();
                                } catch (Throwable th) {
                                    MediaFile.this.imageStatusLock.unlock();
                                    throw th;
                                }
                            }
                            boolean unused2 = MediaFile.this.imageDownloadInProgress = false;
                            MediaFile.this.imageStatusLock.unlock();
                            if (MediaFile.this.imageDownloadCallback != null) {
                                new Thread(MediaFile.this.imageDownloadCallback).start();
                            }
                        }
                    });
                    asyncDownload.executeOnExecutor(AsyncDownload.THREAD_POOL_EXECUTOR, new Void[0]);
                    this.imageStatusLock.unlock();
                }
            }
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public void downloadThumbnail() {
        downloadThumbnail((ProgressBar) null);
    }

    public void downloadThumbnail(ProgressBar progressBar) {
        this.thumbnailStatusLock.lock();
        try {
            if (!this.downloadedThumbnail) {
                if (!this.thumbNailDownloadInProgress) {
                    this.downloadedThumbnailPath = MEDIA_DIRECTORY + this.thumbnailPath;
                    this.thumbNailDownloadInProgress = true;
                    final AsyncDownload asyncDownload = new AsyncDownload(AdkInterface.getContext(), getThumbnailUri(), this.downloadedThumbnailPath, progressBar, (Runnable) null);
                    asyncDownload.setCallback(new Runnable() {
                        public void run() {
                            boolean z;
                            try {
                                z = ((Boolean) asyncDownload.get()).booleanValue();
                            } catch (Exception e) {
                                Log.e(MediaFile.TAG, "AsyncDownload failed: ", e);
                                z = false;
                            }
                            MediaFile.this.thumbnailStatusLock.lock();
                            if (z) {
                                try {
                                    boolean unused = MediaFile.this.downloadedThumbnail = true;
                                    MediaFile.this.saveToDisk();
                                } catch (Throwable th) {
                                    MediaFile.this.thumbnailStatusLock.unlock();
                                    throw th;
                                }
                            }
                            boolean unused2 = MediaFile.this.thumbNailDownloadInProgress = false;
                            MediaFile.this.thumbnailStatusLock.unlock();
                            if (MediaFile.this.thumbnailDownloadCallback != null) {
                                new Thread(MediaFile.this.thumbnailDownloadCallback).start();
                            }
                        }
                    });
                    asyncDownload.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    this.thumbnailStatusLock.unlock();
                }
            }
        } finally {
            this.thumbnailStatusLock.unlock();
        }
    }

    private String toBitmap(String str, boolean z) {
        FileOutputStream fileOutputStream;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        String str2 = str + ".png";
        try {
            fileOutputStream = new FileOutputStream(str2);
            decodeFile.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            if (z) {
                new File(str).delete();
            }
            fileOutputStream.close();
            return str2;
        } catch (IOException unused) {
            Log.e(TAG, "Failed to convert image to bitmap.");
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static boolean downloadFile(String str, String str2) {
        try {
            Log.d(TAG, "Starting connection to " + str);
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                Log.d(TAG, "Download of " + url.toString() + " failed with http response code: " + responseCode + " " + httpURLConnection.getResponseMessage());
                return false;
            }
            httpURLConnection.getContentLength();
            byte[] bArr = new byte[4096];
            InputStream inputStream = httpURLConnection.getInputStream();
            new File(str2).getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(str2, false);
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    Log.d(TAG, "Downloaded file to " + str2);
                    return true;
                }
            }
        } catch (IOException e) {
            Log.d(TAG, "Download failed: ", e);
            return false;
        }
    }

    public void deleteImage() {
        File file = new File(this.downloadedPath);
        this.imageStatusLock.lock();
        try {
            if (!this.imageDownloadInProgress) {
                this.downloadedImage = false;
                file.delete();
                saveToDisk();
                this.imageStatusLock.unlock();
            }
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaFile)) {
            return false;
        }
        MediaFile mediaFile = (MediaFile) obj;
        boolean equals = mediaFile.thumbnailPath.equals(this.thumbnailPath);
        boolean z = mediaFile.dateCreated == this.dateCreated;
        boolean equals2 = mediaFile.path.equals(this.path);
        boolean equals3 = this.acSerial.equals(mediaFile.acSerial);
        if (!equals || !equals2 || !z || !equals3) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.thumbnailPath.hashCode() ^ this.dateCreated) ^ this.path.hashCode()) ^ this.acSerial.hashCode();
    }

    public boolean isThumbnailDownloaded() {
        this.thumbnailStatusLock.lock();
        try {
            return this.downloadedThumbnail;
        } finally {
            this.thumbnailStatusLock.unlock();
        }
    }

    public boolean isHighResImageDownloaded() {
        this.imageStatusLock.lock();
        try {
            return this.downloadedImage;
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public void setThumbnailDownloadCallback(Runnable runnable) {
        this.thumbnailStatusLock.lock();
        try {
            this.thumbnailDownloadCallback = runnable;
            if (this.downloadedThumbnail) {
                new Thread(this.thumbnailDownloadCallback).start();
            }
        } finally {
            this.thumbnailStatusLock.unlock();
        }
    }

    public void setImageDownloadCallback(Runnable runnable) {
        this.imageStatusLock.lock();
        try {
            this.imageDownloadCallback = runnable;
            if (this.downloadedImage) {
                new Thread(this.imageDownloadCallback).start();
            }
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public boolean saveToDisk() {
        try {
            Log.d(TAG, "Writing mediafile data to " + this.filePath);
            new ObjectOutputStream(new FileOutputStream(this.filePath)).writeObject(this);
            return true;
        } catch (IOException e) {
            Log.e(TAG, "Failed to serialize MediaFile object: ", e);
            return false;
        }
    }

    public String getRemoteThumbnailPath() {
        return this.thumbnailPath;
    }

    public String getRemoteMediaPath() {
        return this.path;
    }

    public int getDateCreated() {
        return this.dateCreated;
    }

    public String getLocalThumbnailPath() {
        this.imageStatusLock.lock();
        try {
            if (!this.downloadedThumbnail) {
                return null;
            }
            this.imageStatusLock.unlock();
            return this.downloadedThumbnailPath;
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public Drawable getLocalImage() {
        Log.d(TAG, "Getting image.");
        this.imageStatusLock.lock();
        try {
            if (!this.downloadedImage) {
                return null;
            }
            this.imageStatusLock.unlock();
            if (!new File(this.downloadedPath).exists()) {
                return null;
            }
            return Drawable.createFromPath(this.downloadedPath);
        } finally {
            this.imageStatusLock.unlock();
        }
    }

    public String getImageName() {
        return new File(this.path).getName();
    }
}
