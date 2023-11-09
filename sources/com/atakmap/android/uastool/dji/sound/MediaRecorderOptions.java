package com.atakmap.android.uastool.dji.sound;

public class MediaRecorderOptions {
    private final Builder mBuilder;

    private MediaRecorderOptions(Builder builder) {
        this.mBuilder = builder;
    }

    public int getAudioSamplingRate() {
        return this.mBuilder.mAudioSamplingRate;
    }

    public int getAudioEncodingBitRate() {
        return this.mBuilder.mAudioEncodingBitRate;
    }

    public int getAudioChannels() {
        return this.mBuilder.mAudioChannels;
    }

    public static class Builder {
        int mAudioChannels = 1;
        int mAudioEncodingBitRate = 16000;
        int mAudioSamplingRate = 44100;

        public Builder audioSamplingRate(int i) {
            this.mAudioSamplingRate = i;
            return this;
        }

        public Builder audioEncodingBitRate(int i) {
            this.mAudioEncodingBitRate = i;
            return this;
        }

        public Builder audioChannels(int i) {
            this.mAudioChannels = i;
            return this;
        }

        public MediaRecorderOptions build() {
            return new MediaRecorderOptions(this);
        }
    }
}
