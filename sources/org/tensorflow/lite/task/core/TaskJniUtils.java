package org.tensorflow.lite.task.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TaskJniUtils {
    public static final long INVALID_POINTER = 0;
    private static final String TAG = "TaskJniUtils";

    public interface EmptyHandleProvider {
        long createHandle();
    }

    public interface FdAndOptionsHandleProvider<T> {
        long createHandle(int i, long j, long j2, T t);
    }

    public interface MultipleBuffersHandleProvider {
        long createHandle(ByteBuffer... byteBufferArr);
    }

    public static <T> long createHandleFromFdAndOptions(Context context, final FdAndOptionsHandleProvider<T> fdAndOptionsHandleProvider, String str, String str2, final T t) {
        final AssetFileDescriptor openFd = context.getAssets().openFd(str2);
        try {
            long createHandleFromLibrary = createHandleFromLibrary(new EmptyHandleProvider() {
                public long createHandle() {
                    return FdAndOptionsHandleProvider.this.createHandle(openFd.getParcelFileDescriptor().getFd(), openFd.getLength(), openFd.getStartOffset(), t);
                }
            }, str);
            if (openFd != null) {
                openFd.close();
            }
            return createHandleFromLibrary;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static long createHandleFromLibrary(EmptyHandleProvider emptyHandleProvider, String str) {
        tryLoadLibrary(str);
        try {
            return emptyHandleProvider.createHandle();
        } catch (Exception e) {
            String str2 = "Error getting native address of native library: " + str;
            Log.e(TAG, str2, e);
            throw new IllegalStateException(str2, e);
        }
    }

    public static long createHandleWithMultipleAssetFilesFromLibrary(Context context, final MultipleBuffersHandleProvider multipleBuffersHandleProvider, String str, String... strArr) {
        final MappedByteBuffer[] mappedByteBufferArr = new MappedByteBuffer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            mappedByteBufferArr[i] = loadMappedFile(context, strArr[i]);
        }
        return createHandleFromLibrary(new EmptyHandleProvider() {
            public long createHandle() {
                return MultipleBuffersHandleProvider.this.createHandle(mappedByteBufferArr);
            }
        }, str);
    }

    public static MappedByteBuffer loadMappedFile(Context context, String str) {
        FileInputStream fileInputStream;
        AssetFileDescriptor openFd = context.getAssets().openFd(str);
        try {
            fileInputStream = new FileInputStream(openFd.getFileDescriptor());
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
            fileInputStream.close();
            if (openFd != null) {
                openFd.close();
            }
            return map;
        } catch (Throwable th) {
            if (openFd != null) {
                try {
                    openFd.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        throw th;
    }

    private TaskJniUtils() {
    }

    static void tryLoadLibrary(String str) {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            String str2 = "Error loading native library: " + str;
            Log.e(TAG, str2, e);
            throw new UnsatisfiedLinkError(str2);
        }
    }
}
