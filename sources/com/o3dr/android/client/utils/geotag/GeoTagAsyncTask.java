package com.o3dr.android.client.utils.geotag;

import android.os.AsyncTask;
import com.o3dr.android.client.utils.data.tlog.TLogParser;
import com.o3dr.android.client.utils.geotag.GeoTagUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GeoTagAsyncTask extends AsyncTask<Void, Integer, GeoTagUtils.ResultObject> {
    private final List<TLogParser.Event> events;
    private final GeoTagAlgorithm geoTagAlg;
    private final GeoTagUtils.GeoTagListener listener;
    private final ArrayList<File> photos;
    private final File rootDir;

    protected interface GeoTagAlgorithm {
        HashMap<TLogParser.Event, File> match(List<TLogParser.Event> list, ArrayList<File> arrayList);
    }

    public abstract void onFailed(Exception exc);

    public abstract void onProgress(int i, int i2);

    public abstract void onResult(HashMap<File, File> hashMap, HashMap<File, Exception> hashMap2);

    public GeoTagAsyncTask(File file, List<TLogParser.Event> list, ArrayList<File> arrayList) {
        this(file, list, arrayList, new SimpleGeoTagAlgorithm());
    }

    public GeoTagAsyncTask(File file, List<TLogParser.Event> list, ArrayList<File> arrayList, GeoTagAlgorithm geoTagAlgorithm) {
        this.listener = new GeoTagUtils.GeoTagListener() {
            public void onProgress(int i, int i2) {
                GeoTagAsyncTask.this.publishProgress(new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
            }
        };
        this.rootDir = file;
        this.events = list;
        this.photos = arrayList;
        this.geoTagAlg = geoTagAlgorithm;
    }

    /* access modifiers changed from: protected */
    public GeoTagUtils.ResultObject doInBackground(Void... voidArr) {
        if (isCancelled()) {
            return new GeoTagUtils.ResultObject();
        }
        return GeoTagUtils.geotag(this.rootDir, this.events, this.photos, this.geoTagAlg, this.listener);
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(GeoTagUtils.ResultObject resultObject) {
        if (resultObject.didSucceed()) {
            onResult(resultObject.getGeoTaggedPhotos(), resultObject.getFailedFiles());
        } else {
            onFailed(resultObject.getException());
        }
    }

    /* access modifiers changed from: protected */
    public final void onProgressUpdate(Integer... numArr) {
        onProgress(numArr[0].intValue(), numArr[1].intValue());
    }

    /* access modifiers changed from: protected */
    public final void onCancelled(GeoTagUtils.ResultObject resultObject) {
        onResult(resultObject.getGeoTaggedPhotos(), resultObject.getFailedFiles());
    }
}
