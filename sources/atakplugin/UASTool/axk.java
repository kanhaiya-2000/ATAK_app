package atakplugin.UASTool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\b¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\b¢\u0006\u0002\u0010\b\u001a&\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\b¢\u0006\u0002\u0010\u0005¨\u0006\n"}, mo1538e = {"read", "T", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"})
public final class axk {
    /* renamed from: a */
    private static final <T> T m5805a(Lock lock, bdk<? extends T> bdk) {
        lock.lock();
        try {
            return bdk.invoke();
        } finally {
            bfn.m6527b(1);
            lock.unlock();
            bfn.m6528c(1);
        }
    }

    /* renamed from: a */
    private static final <T> T m5806a(ReentrantReadWriteLock reentrantReadWriteLock, bdk<? extends T> bdk) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return bdk.invoke();
        } finally {
            bfn.m6527b(1);
            readLock.unlock();
            bfn.m6528c(1);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: b */
    private static final <T> T m5807b(java.util.concurrent.locks.ReentrantReadWriteLock r4, atakplugin.UASTool.bdk<? extends T> r5) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r4.readLock()
            int r1 = r4.getWriteHoldCount()
            r2 = 0
            if (r1 != 0) goto L_0x0010
            int r1 = r4.getReadHoldCount()
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            r3 = 0
        L_0x0012:
            if (r3 >= r1) goto L_0x001a
            r0.unlock()
            int r3 = r3 + 1
            goto L_0x0012
        L_0x001a:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.lock()
            r3 = 1
            java.lang.Object r5 = r5.invoke()     // Catch:{ all -> 0x0038 }
            atakplugin.UASTool.bfn.m6527b(r3)
        L_0x0029:
            if (r2 >= r1) goto L_0x0031
            r0.lock()
            int r2 = r2 + 1
            goto L_0x0029
        L_0x0031:
            r4.unlock()
            atakplugin.UASTool.bfn.m6528c(r3)
            return r5
        L_0x0038:
            r5 = move-exception
            atakplugin.UASTool.bfn.m6527b(r3)
        L_0x003c:
            if (r2 >= r1) goto L_0x0044
            r0.lock()
            int r2 = r2 + 1
            goto L_0x003c
        L_0x0044:
            r4.unlock()
            atakplugin.UASTool.bfn.m6528c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.axk.m5807b(java.util.concurrent.locks.ReentrantReadWriteLock, atakplugin.UASTool.bdk):java.lang.Object");
    }
}
