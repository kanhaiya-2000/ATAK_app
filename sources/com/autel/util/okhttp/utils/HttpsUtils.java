package com.autel.util.okhttp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpsUtils {
    public static SSLSocketFactory getSslSocketFactory(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        TrustManager trustManager;
        try {
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            SSLContext instance = SSLContext.getInstance("TLS");
            if (prepareTrustManager != null) {
                trustManager = new MyTrustManager(chooseTrustManager(prepareTrustManager));
            } else {
                trustManager = new UnSafeTrustManager();
            }
            instance.init(prepareKeyManager, new TrustManager[]{trustManager}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        }
    }

    public static X509TrustManager getX509TrustManager(InputStream[] inputStreamArr) {
        return chooseTrustManager(prepareTrustManager(inputStreamArr));
    }

    private static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load((KeyStore.LoadStoreParameter) null);
                int length = inputStreamArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    InputStream inputStream = inputStreamArr[i];
                    int i3 = i2 + 1;
                    instance2.setCertificateEntry(Integer.toString(i2), instance.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    i++;
                    i2 = i3;
                }
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                return instance3.getTrustManagers();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (CertificateException e3) {
                e3.printStackTrace();
            } catch (KeyStoreException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    private static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        if (!(inputStream == null || str == null)) {
            try {
                KeyStore instance = KeyStore.getInstance("BKS");
                instance.load(inputStream, str.toCharArray());
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, str.toCharArray());
                return instance2.getKeyManagers();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (UnrecoverableKeyException e3) {
                e3.printStackTrace();
            } catch (CertificateException e4) {
                e4.printStackTrace();
            } catch (IOException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (X509TrustManager x509TrustManager : trustManagerArr) {
            if (x509TrustManager instanceof X509TrustManager) {
                return x509TrustManager;
            }
        }
        return null;
    }

    private static class UnSafeTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        private UnSafeTrustManager() {
        }
    }

    private static class MyTrustManager implements X509TrustManager {
        private X509TrustManager defaultTrustManager;
        private X509TrustManager localTrustManager;

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public MyTrustManager(X509TrustManager x509TrustManager) {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.defaultTrustManager = HttpsUtils.chooseTrustManager(instance.getTrustManagers());
            this.localTrustManager = x509TrustManager;
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }
    }
}
