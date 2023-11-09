package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.prefs.UtilitiesPreferenceFragment;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;

public abstract class abc extends C1002wn {

    /* renamed from: d */
    private static HashMap<String, String> f162d;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f163e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f164f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f165o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f166p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f167q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f168r = null;

    /* renamed from: a */
    int f169a;

    /* renamed from: b */
    int f170b;

    /* renamed from: c */
    int f171c;

    /* renamed from: a */
    private static /* synthetic */ void mo109a() {
        cdj cdj = new cdj("AppleDataBox.java", abc.class);
        f163e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguageString", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "java.lang.String"), 25);
        f164f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataType", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 43);
        f165o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 47);
        f166p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataCountry", "", "void"), 51);
        f167q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 55);
        f168r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataLanguage", "", "void"), 59);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract byte[] mo111b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo36c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo112c(ByteBuffer byteBuffer);

    protected abc(String str, int i) {
        super(str);
        this.f169a = i;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f163e, (Object) this, (Object) this));
        HashMap<String, String> hashMap = f162d;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f171c);
        String str = hashMap.get(sb.toString());
        if (str != null) {
            return str;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[2]);
        C0681nm.m12514b(wrap, this.f171c);
        wrap.reset();
        return new Locale(C0679nk.m12505l(wrap)).getDisplayLanguage();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo36c() + 16);
    }

    /* renamed from: j */
    public int mo117j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f164f, (Object) this, (Object) this));
        return this.f169a;
    }

    /* renamed from: k */
    public int mo118k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f165o, (Object) this, (Object) this));
        return this.f170b;
    }

    /* renamed from: a */
    public void mo113a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f166p, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f170b = i;
    }

    /* renamed from: l */
    public int mo119l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f167q, (Object) this, (Object) this));
        return this.f171c;
    }

    /* renamed from: b */
    public void mo114b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f168r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f171c = i;
    }

    /* access modifiers changed from: protected */
    @C1016xa
    /* renamed from: d */
    public ByteBuffer mo115d(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        this.f169a = byteBuffer.getInt();
        short s = byteBuffer.getShort();
        this.f170b = s;
        if (s < 0) {
            this.f170b = s + 65536;
        }
        short s2 = byteBuffer.getShort();
        this.f171c = s2;
        if (s2 < 0) {
            this.f171c = s2 + 65536;
        }
        int i2 = i - 16;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().slice().limit(i2);
        byteBuffer.position(i2 + byteBuffer.position());
        return byteBuffer2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo112c(mo115d(byteBuffer));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo116f(byteBuffer);
        byteBuffer.put(mo111b());
    }

    /* access modifiers changed from: protected */
    @C1016xa
    /* renamed from: f */
    public void mo116f(ByteBuffer byteBuffer) {
        byteBuffer.putInt(mo36c() + 16);
        byteBuffer.put("data".getBytes());
        byteBuffer.putInt(this.f169a);
        C0681nm.m12514b(byteBuffer, this.f170b);
        C0681nm.m12514b(byteBuffer, this.f171c);
    }

    static {
        mo109a();
        HashMap<String, String> hashMap = new HashMap<>();
        f162d = hashMap;
        hashMap.put("0", "English");
        f162d.put("1", "French");
        f162d.put("2", "German");
        f162d.put("3", "Italian");
        f162d.put("4", "Dutch");
        f162d.put("5", "Swedish");
        f162d.put("6", "Spanish");
        f162d.put("7", "Danish");
        f162d.put("8", "Portuguese");
        f162d.put("9", "Norwegian");
        f162d.put("10", "Hebrew");
        f162d.put("11", "Japanese");
        f162d.put("12", "Arabic");
        f162d.put("13", "Finnish");
        f162d.put("14", "Greek");
        f162d.put("15", "Icelandic");
        f162d.put("16", "Maltese");
        f162d.put("17", "Turkish");
        f162d.put("18", "Croatian");
        f162d.put("19", "Traditional_Chinese");
        f162d.put("20", "Urdu");
        f162d.put("21", "Hindi");
        f162d.put("22", "Thai");
        f162d.put(UtilitiesPreferenceFragment.DEFAULT_DANGER_LOW_ALT, "Korean");
        f162d.put("24", "Lithuanian");
        f162d.put("25", "Polish");
        f162d.put("26", "Hungarian");
        f162d.put("27", "Estonian");
        f162d.put("28", "Lettish");
        f162d.put("29", "Sami");
        f162d.put("30", "Faroese");
        f162d.put("31", "Farsi");
        f162d.put("32", "Russian");
        f162d.put("33", "Simplified_Chinese");
        f162d.put("34", "Flemish");
        f162d.put("35", "Irish");
        f162d.put("36", "Albanian");
        f162d.put("37", "Romanian");
        f162d.put("38", "Czech");
        f162d.put("39", "Slovak");
        f162d.put("40", "Slovenian");
        f162d.put("41", "Yiddish");
        f162d.put("42", "Serbian");
        f162d.put("43", "Macedonian");
        f162d.put("44", "Bulgarian");
        f162d.put("45", "Ukrainian");
        f162d.put("46", "Belarusian");
        f162d.put("47", "Uzbek");
        f162d.put("48", "Kazakh");
        f162d.put("49", "Azerbaijani");
        f162d.put("50", "AzerbaijanAr");
        f162d.put("51", "Armenian");
        f162d.put("52", "Georgian");
        f162d.put("53", "Moldavian");
        f162d.put("54", "Kirghiz");
        f162d.put("55", "Tajiki");
        f162d.put("56", "Turkmen");
        f162d.put("57", "Mongolian");
        f162d.put("58", "MongolianCyr");
        f162d.put("59", "Pashto");
        f162d.put("60", "Kurdish");
        f162d.put("61", "Kashmiri");
        f162d.put("62", "Sindhi");
        f162d.put("63", "Tibetan");
        f162d.put("64", "Nepali");
        f162d.put("65", "Sanskrit");
        f162d.put("66", "Marathi");
        f162d.put("67", "Bengali");
        f162d.put("68", "Assamese");
        f162d.put("69", "Gujarati");
        f162d.put("70", "Punjabi");
        f162d.put("71", "Oriya");
        f162d.put("72", "Malayalam");
        f162d.put("73", "Kannada");
        f162d.put("74", "Tamil");
        f162d.put("75", "Telugu");
        f162d.put("76", "Sinhala");
        f162d.put("77", "Burmese");
        f162d.put("78", "Khmer");
        f162d.put("79", "Lao");
        f162d.put("80", "Vietnamese");
        f162d.put("81", "Indonesian");
        f162d.put("82", "Tagalog");
        f162d.put("83", "MalayRoman");
        f162d.put("84", "MalayArabic");
        f162d.put("85", "Amharic");
        f162d.put("87", "Galla");
        f162d.put("87", "Oromo");
        f162d.put("88", "Somali");
        f162d.put("89", "Swahili");
        f162d.put("90", "Kinyarwanda");
        f162d.put("91", "Rundi");
        f162d.put("92", "Nyanja");
        f162d.put("93", "Malagasy");
        f162d.put("94", "Esperanto");
        f162d.put("128", "Welsh");
        f162d.put("129", "Basque");
        f162d.put("130", "Catalan");
        f162d.put("131", "Latin");
        f162d.put("132", "Quechua");
        f162d.put("133", "Guarani");
        f162d.put("134", "Aymara");
        f162d.put("135", "Tatar");
        f162d.put("136", "Uighur");
        f162d.put("137", "Dzongkha");
        f162d.put("138", "JavaneseRom");
        f162d.put("32767", "Unspecified");
    }
}
