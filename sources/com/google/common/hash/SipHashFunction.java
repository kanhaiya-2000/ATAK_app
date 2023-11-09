package com.google.common.hash;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;

@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f8566c;

    /* renamed from: d */
    private final int f8567d;

    /* renamed from: k0 */
    private final long f8568k0;

    /* renamed from: k1 */
    private final long f8569k1;

    public int bits() {
        return 64;
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 <= 0 ? false : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f8566c = i;
        this.f8567d = i2;
        this.f8568k0 = j;
        this.f8569k1 = j2;
    }

    public Hasher newHasher() {
        return new SipHasher(this.f8566c, this.f8567d, this.f8568k0, this.f8569k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f8566c + "" + this.f8567d + "(" + this.f8568k0 + ", " + this.f8569k1 + ")";
    }

    public boolean equals(@cij Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f8566c == sipHashFunction.f8566c && this.f8567d == sipHashFunction.f8567d && this.f8568k0 == sipHashFunction.f8568k0 && this.f8569k1 == sipHashFunction.f8569k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.f8566c) ^ this.f8567d)) ^ this.f8568k0) ^ this.f8569k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f8570b = 0;

        /* renamed from: c */
        private final int f8571c;

        /* renamed from: d */
        private final int f8572d;
        private long finalM = 0;

        /* renamed from: v0 */
        private long f8573v0 = 8317987319222330741L;

        /* renamed from: v1 */
        private long f8574v1 = 7237128888997146477L;

        /* renamed from: v2 */
        private long f8575v2 = 7816392313619706465L;

        /* renamed from: v3 */
        private long f8576v3 = 8387220255154660723L;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f8571c = i;
            this.f8572d = i2;
            this.f8573v0 = 8317987319222330741L ^ j;
            this.f8574v1 = 7237128888997146477L ^ j2;
            this.f8575v2 = 7816392313619706465L ^ j;
            this.f8576v3 = 8387220255154660723L ^ j2;
        }

        /* access modifiers changed from: protected */
        public void process(ByteBuffer byteBuffer) {
            this.f8570b += 8;
            processM(byteBuffer.getLong());
        }

        /* access modifiers changed from: protected */
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f8570b += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }

        public HashCode makeHash() {
            long j = this.finalM ^ (this.f8570b << 56);
            this.finalM = j;
            processM(j);
            this.f8575v2 ^= 255;
            sipRound(this.f8572d);
            return HashCode.fromLong(((this.f8573v0 ^ this.f8574v1) ^ this.f8575v2) ^ this.f8576v3);
        }

        private void processM(long j) {
            this.f8576v3 ^= j;
            sipRound(this.f8571c);
            this.f8573v0 = j ^ this.f8573v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f8573v0;
                long j2 = this.f8574v1;
                this.f8573v0 = j + j2;
                this.f8575v2 += this.f8576v3;
                this.f8574v1 = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f8576v3, 16);
                this.f8576v3 = rotateLeft;
                long j3 = this.f8574v1;
                long j4 = this.f8573v0;
                this.f8574v1 = j3 ^ j4;
                this.f8576v3 = rotateLeft ^ this.f8575v2;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f8573v0 = rotateLeft2;
                long j5 = this.f8575v2;
                long j6 = this.f8574v1;
                this.f8575v2 = j5 + j6;
                this.f8573v0 = rotateLeft2 + this.f8576v3;
                this.f8574v1 = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f8576v3, 21);
                this.f8576v3 = rotateLeft3;
                long j7 = this.f8574v1;
                long j8 = this.f8575v2;
                this.f8574v1 = j7 ^ j8;
                this.f8576v3 = rotateLeft3 ^ this.f8573v0;
                this.f8575v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
