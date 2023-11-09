package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_request_data_stream;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.communication.model.DataLink;

public class MavLinkStreamRates {
    public static void setupStreamRates(DataLink.DataLinkProvider dataLinkProvider, short s, short s2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        requestMavlinkDataStream(dataLinkProvider, s, s2, 2, i);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 10, i2);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 11, i3);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 12, i4);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 6, i5);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 1, i7);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 4, i8);
        requestMavlinkDataStream(dataLinkProvider, s, s2, 3, i6);
    }

    private static void requestMavlinkDataStream(DataLink.DataLinkProvider dataLinkProvider, short s, short s2, int i, int i2) {
        msg_request_data_stream msg_request_data_stream = new msg_request_data_stream();
        msg_request_data_stream.target_system = s;
        msg_request_data_stream.target_component = s2;
        msg_request_data_stream.req_message_rate = i2;
        msg_request_data_stream.req_stream_id = (short) i;
        if (i2 > 0) {
            msg_request_data_stream.start_stop = 1;
        } else {
            msg_request_data_stream.start_stop = 0;
        }
        dataLinkProvider.sendMessage(msg_request_data_stream, (ICommandListener) null);
    }
}
