package com.autel.AutelNet2.core.utils;

import atakplugin.UASTool.bvh;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.base.ParamsAckPacket;
import com.autel.AutelNet2.aircraft.battery.message.BatteryStatusPacket;
import com.autel.AutelNet2.aircraft.camera.message.CameraStatusPacket;
import com.autel.AutelNet2.aircraft.firmware.message.DeviceInfoStatusPacket;
import com.autel.AutelNet2.aircraft.firmware.message.FirmwarePacket;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeNotifyPacket;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeProgressPacket;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeStartRespPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.AttitudePacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.FlightControlPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.GPSInfoPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.GimbalPryAnglePacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.HeartbeatPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.IMUCalibrationStatusPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.IMUStatusPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.LocalCoordinateInfoPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.RtkDataPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.RtkInfoReportPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalAngleRangeAckPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalCmdAckPacket;
import com.autel.AutelNet2.aircraft.mission.message.BreakPointMissionPacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentFollowMePacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentHotPointPacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentMissionPacket;
import com.autel.AutelNet2.aircraft.mission.message.MissionTransferPacket;
import com.autel.AutelNet2.aircraft.mission.message.RequestMissionAllSettingsPacket;
import com.autel.AutelNet2.aircraft.mission.message.TripodSettingPacket;
import com.autel.AutelNet2.aircraft.mission.message.UploadMissionAllSettingsPacket;
import com.autel.AutelNet2.aircraft.mission.message.UploadMissionFileNotifyPacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ObstacleAvoidancePacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ObstacleAvoidanceParamterPacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ViewpointPacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.VisualHeartPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.OrbitStatusPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.OrbitTargetAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.ReportGoalAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.UploadGoalAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.VisualEventPacket;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.dsp.message.BandModeWidthInfoPacket;
import com.autel.AutelNet2.dsp.message.DspAppMsgPacket;
import com.autel.AutelNet2.dsp.message.DspFactoryPacket;
import com.autel.AutelNet2.dsp.message.LiveDeckGetIpPacket;
import com.autel.AutelNet2.dsp.message.LogManagerPacket;
import com.autel.AutelNet2.dsp.message.RemoteLogPacket;
import com.autel.AutelNet2.dsp.message.RemoteRecordPacket;
import com.autel.AutelNet2.dsp.message.ReportBertInfoPacket;
import com.autel.AutelNet2.dsp.message.RequestZteRemoteLogPacket;
import com.autel.AutelNet2.dsp.message.SetVideoTransferModePacket;
import com.autel.AutelNet2.dsp.message.SetZteRemoteLogPacket;
import com.autel.AutelNet2.dsp.message.SignalStrengthPacket;
import com.autel.AutelNet2.dsp.message.VideoRateInfoPacket;
import com.autel.AutelNet2.dsp.message.VideoStreamAckPacket;
import com.autel.AutelNet2.dsp.message.VideoTransferModePacket;
import com.autel.AutelNet2.remotecontroller.message.RCButtonPacket;
import com.autel.AutelNet2.remotecontroller.message.RCMsgPacket;
import com.autel.AutelNet2.remotecontroller.message.RcGetCustomKeyPacket;
import com.autel.AutelNet2.remotecontroller.message.RcSetCustomKeyPacket;
import com.autel.AutelNet2.utils.BytesUtils;

public class MsgParser {
    private static final int READ_BUFFER_SIZE = 4096;
    private byte[] buffer = new byte[4096];
    private int length;

    public byte[] getBuffer() {
        return this.buffer;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public MsgHead parseHead() {
        MsgHead msgHead = new MsgHead();
        msgHead.magic0 = this.buffer[0];
        msgHead.magic1 = this.buffer[1];
        msgHead.version = this.buffer[2];
        msgHead.flag = this.buffer[3];
        byte[] bArr = this.buffer;
        msgHead.length = (short) ((bArr[5] & 255) | ((bArr[4] & 255) << 8));
        byte[] bArr2 = this.buffer;
        msgHead.msg_src = (short) ((bArr2[7] & 255) | ((bArr2[6] & 255) << 8));
        byte[] bArr3 = this.buffer;
        msgHead.msg_dst = (short) ((bArr3[9] & 255) | ((bArr3[8] & 255) << 8));
        byte[] bArr4 = this.buffer;
        msgHead.msg_type = (short) ((bArr4[11] & 255) | ((bArr4[10] & 255) << 8));
        byte[] bArr5 = this.buffer;
        msgHead.sequence = (short) ((bArr5[13] & 255) | ((bArr5[12] & 255) << 8));
        byte[] bArr6 = this.buffer;
        msgHead.package_id = (short) ((bArr6[15] & 255) | ((bArr6[14] & 255) << 8));
        return msgHead;
    }

    public BaseMsgPacket parsePacket(MsgHead msgHead) {
        byte[] bArr = this.buffer;
        if (bArr == null || bArr.length < UdpConfig.HEAD_LENGTH) {
            return null;
        }
        return disPatch(msgHead, BytesUtils.arraySplit(this.buffer, UdpConfig.HEAD_LENGTH, msgHead.length));
    }

    public BaseMsgPacket disPatch(MsgHead msgHead, byte[] bArr) {
        switch (msgHead.msg_type) {
            case 4:
                return new LogManagerPacket(msgHead, bArr);
            case 25:
                return new CameraStatusPacket(msgHead, bArr);
            case 43:
                return new DspFactoryPacket(msgHead, bArr);
            case 53:
                return new SetZteRemoteLogPacket(msgHead, bArr, true);
            case 54:
                return new SetZteRemoteLogPacket(msgHead, bArr, false);
            case 55:
                return new RequestZteRemoteLogPacket(msgHead, bArr);
            case 57:
                return new DspAppMsgPacket(msgHead, bArr);
            case 66:
                return new RemoteLogPacket(msgHead, bArr);
            case 72:
                return new RemoteRecordPacket(msgHead, bArr);
            case 74:
                return new LiveDeckGetIpPacket(msgHead, bArr);
            case 256:
            case 320:
                return new HeartbeatPacket(msgHead, bArr);
            case 263:
                return new CommandAckPacket(msgHead, bArr);
            case 267:
                return new ParamsAckPacket(msgHead, bArr);
            case 272:
                return new IMUStatusPacket(msgHead, bArr);
            case 274:
                return new GPSInfoPacket(msgHead, bArr);
            case 292:
                return new AttitudePacket(msgHead, bArr);
            case 294:
                return new LocalCoordinateInfoPacket(msgHead, bArr);
            case bvh.f4038b:
                return new BatteryStatusPacket(msgHead, bArr);
            case 310:
                return new CurrentMissionPacket(msgHead, bArr);
            case 312:
                return new CurrentHotPointPacket(msgHead, bArr);
            case 314:
                return new CurrentFollowMePacket(msgHead, bArr);
            case 323:
                return new GimbalPryAnglePacket(msgHead, bArr);
            case 325:
                return new GimbalAngleRangeAckPacket(msgHead, bArr);
            case 331:
                return new GimbalCmdAckPacket(msgHead, bArr);
            case 350:
                return new RequestMissionAllSettingsPacket(msgHead, bArr);
            case 351:
                return new UploadMissionAllSettingsPacket(msgHead, bArr);
            case 361:
                return new TripodSettingPacket(msgHead, bArr);
            case 364:
                return new BreakPointMissionPacket(msgHead, bArr);
            case 394:
                return new RtkDataPacket(msgHead, bArr);
            case 395:
                return new IMUCalibrationStatusPacket(msgHead, bArr);
            case 396:
                return new RtkInfoReportPacket(msgHead, bArr);
            case 513:
                return new VideoStreamAckPacket(true, msgHead, bArr);
            case 517:
                return new VideoStreamAckPacket(false, msgHead, bArr);
            case MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS:
                return new VideoTransferModePacket(msgHead, bArr);
            case 529:
                return new SetVideoTransferModePacket(msgHead, bArr);
            case 769:
                return new FirmwarePacket(msgHead, bArr);
            case 770:
                return new DeviceInfoStatusPacket(msgHead, bArr);
            case 771:
                return new UpgradeStartRespPacket(msgHead, bArr);
            case 776:
                return new UpgradeProgressPacket(msgHead, bArr);
            case 784:
                return new UpgradeNotifyPacket(msgHead, bArr);
            case 817:
                return new MissionTransferPacket(msgHead, bArr);
            case 819:
                return new UploadMissionFileNotifyPacket(msgHead, bArr);
            case 1024:
                return new RCButtonPacket(msgHead, bArr);
            case 1027:
                return new RCMsgPacket(msgHead, bArr);
            case 1029:
                return new FlightControlPacket(msgHead, bArr);
            case 1030:
                return new RcSetCustomKeyPacket(msgHead, bArr);
            case 1031:
                return new RcGetCustomKeyPacket(msgHead, bArr);
            case 1547:
            case 2317:
                return new UploadGoalAreaPacket(msgHead, bArr);
            case 2048:
            case 2049:
                return new SignalStrengthPacket(msgHead, bArr);
            case 2053:
                return new ReportBertInfoPacket(msgHead, bArr);
            case 2056:
                return new VideoRateInfoPacket(msgHead, bArr);
            case 2060:
                return new BandModeWidthInfoPacket(msgHead, bArr);
            case 2305:
                return new ObstacleAvoidanceParamterPacket(msgHead, bArr);
            case 2306:
                return new VisualEventPacket(msgHead, bArr);
            case 2307:
                return new ObstacleAvoidancePacket(msgHead, bArr);
            case 2308:
                return new ViewpointPacket(msgHead, bArr);
            case 2311:
                return new VisualHeartPacket(msgHead, bArr);
            case 2316:
                return new ReportGoalAreaPacket(msgHead, bArr);
            case 2319:
                return new OrbitStatusPacket(msgHead, bArr);
            case 2320:
                return new OrbitTargetAreaPacket(msgHead, bArr);
            default:
                return new BaseMsgPacket(msgHead, bArr) {
                    /* access modifiers changed from: protected */
                    public String loadBody() {
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void loadHead() {
                    }

                    public BaseMsgPacket parseBody() {
                        return this;
                    }
                };
        }
    }

    public boolean checkPacket(MsgHead msgHead) {
        if (msgHead.magic0 == UdpConfig.MAGIC0 && msgHead.magic1 == UdpConfig.MAGIC1 && msgHead.version == UdpConfig.VERSION) {
            return true;
        }
        return false;
    }
}
