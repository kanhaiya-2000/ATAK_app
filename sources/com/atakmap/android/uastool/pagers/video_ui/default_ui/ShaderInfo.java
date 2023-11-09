package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.opengl.GLES20;
import com.atakmap.coremap.log.Log;
import java.nio.IntBuffer;

public class ShaderInfo {
    public static final String TAG = "ShaderInfo";
    public static final String imageFragmentShaderString = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D s_texture;\nuniform float alpha, no_alpha;\nvoid main() {\n  vec4 col = texture2D( s_texture, textureCoordinate );\n  gl_FragColor = vec4(col.r, col.g, col.b, (1.- no_alpha) * alpha + no_alpha * col.a);\n}\n";
    public static final String imageVertexShaderString = "attribute vec4 position;\nvarying vec2 textureCoordinate;\n\nuniform vec2 xyscale, center;\nuniform float rot;\nuniform float multip, addv;\n\nvoid main()\n{\n  float cs = cos(rot), sn = sin(rot);\n  float posx = position.x * cs - position.y * sn;\n  float posy = position.x * sn + position.y * cs;\n  gl_Position = vec4( ( ( ( center.x * multip ) + addv) + xyscale.x*posx ), (center.y + xyscale.y*posy), position.z, position.w);\n  textureCoordinate = (position.yx + 1.) / 2.;\n  textureCoordinate.y = 1.0 - textureCoordinate.y;\n}";

    public static int loadShader(int i, String str) {
        int glGetError;
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGetShaderiv(glCreateShader, 35713, allocate);
        int i2 = allocate.array()[0];
        if (!(i2 == 0 || (glGetError = GLES20.glGetError()) == 0)) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            Log.d(TAG, "loadShader: error=" + glGetError + " status=" + i2 + " type=" + i + " shaderCode=" + str + "\ninfoLog=" + glGetShaderInfoLog);
            Thread.currentThread();
            Thread.dumpStack();
        }
        return glCreateShader;
    }

    public static int loadImageShader() {
        int loadShader = loadShader(35633, imageVertexShaderString);
        int loadShader2 = loadShader(35632, imageFragmentShaderString);
        if (loadShader < 0 || loadShader2 < 0) {
            return -1;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, loadShader);
        int glGetError = GLES20.glGetError();
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        int glGetError2 = GLES20.glGetError();
        GLES20.glLinkProgram(glCreateProgram);
        int glGetError3 = GLES20.glGetError();
        if (!(glGetError3 == 0 && glGetError == 0 && glGetError2 == 0)) {
            Log.d(TAG, "loadImageShader: err=" + glGetError3 + " errv=" + glGetError + " errf=" + glGetError2);
        }
        return glCreateProgram;
    }
}
