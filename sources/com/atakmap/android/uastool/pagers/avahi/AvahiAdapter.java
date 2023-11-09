package com.atakmap.android.uastool.pagers.avahi;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class AvahiAdapter extends ArrayAdapter<AvahiServiceInfo> {
    /* access modifiers changed from: private */
    public final ArrayList<AvahiItemSelectedListener> itemSelectedListeners = new ArrayList<>();

    public interface AvahiItemSelectedListener {
        void onAvahiItemSelected(AvahiServiceInfo avahiServiceInfo);
    }

    public AvahiAdapter(Context context, ArrayList<AvahiServiceInfo> arrayList) {
        super(context, 0, arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f A[EDGE_INSN: B:30:0x008f->B:15:0x008f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            if (r7 != 0) goto L_0x0012
            android.content.Context r7 = r5.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131165187(0x7f070003, float:1.7944584E38)
            r1 = 0
            android.view.View r7 = r7.inflate(r0, r8, r1)
        L_0x0012:
            java.lang.Object r6 = r5.getItem(r6)
            com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo r6 = (com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo) r6
            if (r6 != 0) goto L_0x001b
            return r7
        L_0x001b:
            r8 = 2131034129(0x7f050011, float:1.7678767E38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            com.atakmap.android.uastool.pagers.avahi.AvahiAdapter$1 r0 = new com.atakmap.android.uastool.pagers.avahi.AvahiAdapter$1
            r0.<init>(r6)
            r8.setOnClickListener(r0)
            r8 = 2131034131(0x7f050013, float:1.767877E38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0 = 2130968664(0x7f040058, float:1.7545988E38)
            r8.setImageResource(r0)
            com.atakmap.android.uastool.pagers.avahi.AvahiAdapter$2 r0 = new com.atakmap.android.uastool.pagers.avahi.AvahiAdapter$2
            r0.<init>(r6, r8)
            r8.setOnClickListener(r0)
            r8 = 2131034132(0x7f050014, float:1.7678773E38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 2131034130(0x7f050012, float:1.7678769E38)
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r6.getServiceName()
            r0.setText(r1)
            java.util.Map r1 = r6.getAttributes()
            if (r1 == 0) goto L_0x008f
            java.util.Set r2 = r1.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x006a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008f
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "uri"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = "camera1"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x006a
        L_0x0086:
            java.lang.Object r1 = r1.get(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x008f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.getServiceName()
            java.lang.String r2 = " "
            if (r1 == 0) goto L_0x00bd
            java.lang.String r1 = r6.getServiceName()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00bd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r6.getServiceName()
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            goto L_0x00d3
        L_0x00bd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r6.getServiceType()
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x00d3:
            java.lang.String r1 = r6.getIpAddress()
            if (r1 == 0) goto L_0x00ea
            java.lang.String r1 = r6.getIpAddress()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00ea
            java.lang.String r1 = r6.getIpAddress()
            r0.append(r1)
        L_0x00ea:
            java.lang.String r1 = ":"
            r0.append(r1)
            int r6 = r6.getPort()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r8.setText(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.avahi.AvahiAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void addItemSelectedListener(AvahiItemSelectedListener avahiItemSelectedListener) {
        this.itemSelectedListeners.add(avahiItemSelectedListener);
    }

    public void removeItemSelectedListener(AvahiItemSelectedListener avahiItemSelectedListener) {
        this.itemSelectedListeners.remove(avahiItemSelectedListener);
    }
}
