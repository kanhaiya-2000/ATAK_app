package com.autel.util.okhttp;

import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.Mutlipart;
import com.autel.util.okhttp.request.OKCancelable;
import java.io.File;

public interface HttpInterface {
    <T> void delete(String str, Headers headers, ResponseCallBack<T> responseCallBack);

    <T> void delete(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack);

    <T> void delete(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack);

    <T> void delete(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack);

    void download(String str, String str2, ResponseCallBack<File> responseCallBack);

    void download(String str, String str2, FormParams formParams, ResponseCallBack<File> responseCallBack);

    void download(String str, String str2, FormParams formParams, boolean z, ResponseCallBack<File> responseCallBack);

    void download(String str, String str2, boolean z, ResponseCallBack<File> responseCallBack);

    OKCancelable downloadCancelable(String str, String str2, ResponseCallBack<File> responseCallBack);

    OKCancelable downloadCancelable(String str, String str2, FormParams formParams, ResponseCallBack<File> responseCallBack);

    OKCancelable downloadCancelable(String str, String str2, FormParams formParams, boolean z, ResponseCallBack<File> responseCallBack);

    OKCancelable downloadCancelable(String str, String str2, boolean z, ResponseCallBack<File> responseCallBack);

    <T> void get(String str, Headers headers, ResponseCallBack<T> responseCallBack);

    <T> void get(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack);

    <T> void head(String str, Headers headers, ResponseCallBack<T> responseCallBack);

    <T> void post(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack);

    <T> void post(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack);

    <T> void post(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack);

    <T> void post(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack);

    <T> void post(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack);

    <T> void put(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack);

    <T> void put(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack);

    <T> void put(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack);

    <T> void put(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack);

    <T> void put(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack);

    <T> OKCancelable uploadCancelable(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack);

    <T> OKCancelable uploadCancelable(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack);

    <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack);

    <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack);

    <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack);
}
