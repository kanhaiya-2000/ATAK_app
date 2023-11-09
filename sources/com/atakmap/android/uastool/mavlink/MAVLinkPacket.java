package com.atakmap.android.uastool.MAVLink;

import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.CRC;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ahrs;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ahrs2;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ahrs3;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_airspeed_autocal;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ap_adc;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_autopilot_version_request;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_battery2;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_compassmot_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_data16;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_data32;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_data64;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_data96;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_deepstall;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_digicam_configure;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_digicam_control;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ekf_status_report;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_fence_fetch_point;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_fence_point;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_fence_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gimbal_control;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gimbal_report;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gimbal_torque_cmd_report;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_get_request;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_get_response;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_heartbeat;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_set_request;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_set_response;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_hwstatus;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_led_control;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_limits_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_progress;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_report;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_meminfo;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_configure;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_control;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_pid_tuning;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_radio;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_rally_fetch_point;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_rally_point;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_rangefinder;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_remote_log_block_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_remote_log_data_block;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_rpm;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_sensor_offsets;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_set_mag_offsets;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_simstate;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_wind;
import com.atakmap.android.uastool.MAVLink.common.msg_actuator_control_target;
import com.atakmap.android.uastool.MAVLink.common.msg_adsb_vehicle;
import com.atakmap.android.uastool.MAVLink.common.msg_altitude;
import com.atakmap.android.uastool.MAVLink.common.msg_att_pos_mocap;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude_quaternion;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude_quaternion_cov;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude_target;
import com.atakmap.android.uastool.MAVLink.common.msg_auth_key;
import com.atakmap.android.uastool.MAVLink.common.msg_autopilot_version;
import com.atakmap.android.uastool.MAVLink.common.msg_battery_status;
import com.atakmap.android.uastool.MAVLink.common.msg_camera_trigger;
import com.atakmap.android.uastool.MAVLink.common.msg_change_operator_control;
import com.atakmap.android.uastool.MAVLink.common.msg_change_operator_control_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_collision;
import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_int;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_control_system_state;
import com.atakmap.android.uastool.MAVLink.common.msg_data_stream;
import com.atakmap.android.uastool.MAVLink.common.msg_data_transmission_handshake;
import com.atakmap.android.uastool.MAVLink.common.msg_debug;
import com.atakmap.android.uastool.MAVLink.common.msg_debug_vect;
import com.atakmap.android.uastool.MAVLink.common.msg_distance_sensor;
import com.atakmap.android.uastool.MAVLink.common.msg_encapsulated_data;
import com.atakmap.android.uastool.MAVLink.common.msg_estimator_status;
import com.atakmap.android.uastool.MAVLink.common.msg_extended_sys_state;
import com.atakmap.android.uastool.MAVLink.common.msg_file_transfer_protocol;
import com.atakmap.android.uastool.MAVLink.common.msg_follow_target;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int_cov;
import com.atakmap.android.uastool.MAVLink.common.msg_global_vision_position_estimate;
import com.atakmap.android.uastool.MAVLink.common.msg_gps2_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_gps2_rtk;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_global_origin;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_inject_data;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_input;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_raw_int;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtcm_data;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtk;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_status;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.android.uastool.MAVLink.common.msg_high_latency;
import com.atakmap.android.uastool.MAVLink.common.msg_highres_imu;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_actuator_controls;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_controls;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_gps;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_optical_flow;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_rc_inputs_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_sensor;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_state;
import com.atakmap.android.uastool.MAVLink.common.msg_hil_state_quaternion;
import com.atakmap.android.uastool.MAVLink.common.msg_home_position;
import com.atakmap.android.uastool.MAVLink.common.msg_landing_target;
import com.atakmap.android.uastool.MAVLink.common.msg_local_position_ned;
import com.atakmap.android.uastool.MAVLink.common.msg_local_position_ned_cov;
import com.atakmap.android.uastool.MAVLink.common.msg_local_position_ned_system_global_offset;
import com.atakmap.android.uastool.MAVLink.common.msg_log_data;
import com.atakmap.android.uastool.MAVLink.common.msg_log_entry;
import com.atakmap.android.uastool.MAVLink.common.msg_log_erase;
import com.atakmap.android.uastool.MAVLink.common.msg_log_request_data;
import com.atakmap.android.uastool.MAVLink.common.msg_log_request_end;
import com.atakmap.android.uastool.MAVLink.common.msg_log_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_manual_control;
import com.atakmap.android.uastool.MAVLink.common.msg_manual_setpoint;
import com.atakmap.android.uastool.MAVLink.common.msg_memory_vect;
import com.atakmap.android.uastool.MAVLink.common.msg_message_interval;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_clear_all;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_count;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_current;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_int;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_reached;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request_int;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request_partial_list;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_set_current;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_write_partial_list;
import com.atakmap.android.uastool.MAVLink.common.msg_mount_orientation;
import com.atakmap.android.uastool.MAVLink.common.msg_named_value_float;
import com.atakmap.android.uastool.MAVLink.common.msg_named_value_int;
import com.atakmap.android.uastool.MAVLink.common.msg_nav_controller_output;
import com.atakmap.android.uastool.MAVLink.common.msg_optical_flow;
import com.atakmap.android.uastool.MAVLink.common.msg_optical_flow_rad;
import com.atakmap.android.uastool.MAVLink.common.msg_param_map_rc;
import com.atakmap.android.uastool.MAVLink.common.msg_param_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_param_request_read;
import com.atakmap.android.uastool.MAVLink.common.msg_param_set;
import com.atakmap.android.uastool.MAVLink.common.msg_param_value;
import com.atakmap.android.uastool.MAVLink.common.msg_ping;
import com.atakmap.android.uastool.MAVLink.common.msg_position_target_global_int;
import com.atakmap.android.uastool.MAVLink.common.msg_position_target_local_ned;
import com.atakmap.android.uastool.MAVLink.common.msg_power_status;
import com.atakmap.android.uastool.MAVLink.common.msg_radio_status;
import com.atakmap.android.uastool.MAVLink.common.msg_raw_imu;
import com.atakmap.android.uastool.MAVLink.common.msg_raw_pressure;
import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels;
import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_override;
import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_scaled;
import com.atakmap.android.uastool.MAVLink.common.msg_request_data_stream;
import com.atakmap.android.uastool.MAVLink.common.msg_resource_request;
import com.atakmap.android.uastool.MAVLink.common.msg_safety_allowed_area;
import com.atakmap.android.uastool.MAVLink.common.msg_safety_set_allowed_area;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_imu;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_imu2;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_imu3;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_pressure;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_pressure2;
import com.atakmap.android.uastool.MAVLink.common.msg_scaled_pressure3;
import com.atakmap.android.uastool.MAVLink.common.msg_serial_control;
import com.atakmap.android.uastool.MAVLink.common.msg_servo_output_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_set_actuator_control_target;
import com.atakmap.android.uastool.MAVLink.common.msg_set_attitude_target;
import com.atakmap.android.uastool.MAVLink.common.msg_set_gps_global_origin;
import com.atakmap.android.uastool.MAVLink.common.msg_set_home_position;
import com.atakmap.android.uastool.MAVLink.common.msg_set_mode;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_global_int;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_local_ned;
import com.atakmap.android.uastool.MAVLink.common.msg_sim_state;
import com.atakmap.android.uastool.MAVLink.common.msg_statustext;
import com.atakmap.android.uastool.MAVLink.common.msg_sys_status;
import com.atakmap.android.uastool.MAVLink.common.msg_system_time;
import com.atakmap.android.uastool.MAVLink.common.msg_terrain_check;
import com.atakmap.android.uastool.MAVLink.common.msg_terrain_data;
import com.atakmap.android.uastool.MAVLink.common.msg_terrain_report;
import com.atakmap.android.uastool.MAVLink.common.msg_terrain_request;
import com.atakmap.android.uastool.MAVLink.common.msg_timesync;
import com.atakmap.android.uastool.MAVLink.common.msg_v2_extension;
import com.atakmap.android.uastool.MAVLink.common.msg_vfr_hud;
import com.atakmap.android.uastool.MAVLink.common.msg_vibration;
import com.atakmap.android.uastool.MAVLink.common.msg_vicon_position_estimate;
import com.atakmap.android.uastool.MAVLink.common.msg_vision_position_estimate;
import com.atakmap.android.uastool.MAVLink.common.msg_vision_speed_estimate;
import com.atakmap.android.uastool.MAVLink.common.msg_wind_cov;
import java.io.Serializable;

public class MAVLinkPacket implements Serializable {
    public static final int MAVLINK_STX = 253;
    public static final int MAVLINK_STX_MAVLINK1 = 254;
    private static final long serialVersionUID = 2095947771227815314L;
    public int compat_flags = 0;
    public int compid;
    public CRC crc;
    public int crc_extra;
    public int incompat_flags = 0;
    public final int len;
    public int msgid;
    public MAVLinkPayload payload;
    public Protocol protocol = Protocol.PROTOCOL_1_0;
    public int seq;
    public int sysid;

    public enum Protocol {
        PROTOCOL_0_9,
        PROTOCOL_1_0,
        PROTOCOL_2_0
    }

    public MAVLinkPacket(int i) {
        this.len = i;
        this.payload = new MAVLinkPayload(i);
        this.crc_extra = -1;
    }

    public void setProtocol(Protocol protocol2) {
        this.protocol = protocol2;
    }

    public boolean payloadIsFilled() {
        return this.payload.size() >= this.len;
    }

    public void generateCRC() {
        generateCRC(this.payload.size());
    }

    private void generateCRC(int i) {
        CRC crc2 = this.crc;
        if (crc2 == null) {
            this.crc = new CRC();
        } else {
            crc2.start_checksum();
        }
        this.crc.update_checksum(this.len);
        if (this.protocol == Protocol.PROTOCOL_2_0) {
            this.crc.update_checksum(this.incompat_flags);
            this.crc.update_checksum(this.compat_flags);
        }
        this.crc.update_checksum(this.seq);
        this.crc.update_checksum(this.sysid);
        this.crc.update_checksum(this.compid);
        this.crc.update_checksum(this.msgid);
        if (this.protocol == Protocol.PROTOCOL_2_0) {
            this.crc.update_checksum(this.msgid >> 8);
            this.crc.update_checksum(this.msgid >> 16);
        }
        this.payload.resetIndex();
        for (int i2 = 0; i2 < i; i2++) {
            this.crc.update_checksum(this.payload.getByte());
        }
        int i3 = this.crc_extra;
        if (i3 != -1) {
            this.crc.update_checksum(i3);
        } else {
            this.crc_extra = this.crc.finish_checksum(this.msgid);
        }
    }

    private byte[] encodeMavlink1Packet() {
        int i = this.len;
        byte[] bArr = new byte[(i + 6 + 2)];
        int i2 = 0;
        bArr[0] = -2;
        bArr[1] = (byte) i;
        bArr[2] = (byte) this.seq;
        bArr[3] = (byte) this.sysid;
        bArr[4] = (byte) this.compid;
        bArr[5] = (byte) this.msgid;
        int size = this.payload.size();
        int i3 = 6;
        while (i2 < size) {
            bArr[i3] = this.payload.payload.get(i2);
            i2++;
            i3++;
        }
        generateCRC();
        bArr[i3] = (byte) this.crc.getLSB();
        bArr[i3 + 1] = (byte) this.crc.getMSB();
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public int trimPayload() {
        for (int size = this.payload.size(); size > 0; size--) {
            if (this.payload.get(size - 1) != 0) {
                return size;
            }
        }
        return 0;
    }

    private byte[] encodeMavlink2Packet() {
        int trimPayload = trimPayload();
        byte[] bArr = new byte[(trimPayload + 10 + 2)];
        int i = 0;
        bArr[0] = -3;
        bArr[1] = (byte) trimPayload;
        bArr[2] = (byte) this.incompat_flags;
        bArr[3] = (byte) this.compat_flags;
        bArr[4] = (byte) this.seq;
        bArr[5] = (byte) this.sysid;
        bArr[6] = (byte) this.compid;
        int i2 = this.msgid;
        bArr[7] = (byte) (i2 & 255);
        bArr[8] = (byte) ((i2 >> 8) & 255);
        bArr[9] = (byte) ((i2 >> 16) & 255);
        int i3 = 10;
        while (i < trimPayload) {
            bArr[i3] = this.payload.payload.get(i);
            i++;
            i3++;
        }
        generateCRC(trimPayload);
        bArr[i3] = (byte) this.crc.getLSB();
        bArr[i3 + 1] = (byte) this.crc.getMSB();
        return bArr;
    }

    public byte[] encodePacket() {
        if (this.protocol == Protocol.PROTOCOL_2_0) {
            return encodeMavlink2Packet();
        }
        return encodeMavlink1Packet();
    }

    public MAVLinkMessage unpack() {
        switch (this.msgid) {
            case 0:
                return new msg_heartbeat(this);
            case 1:
                return new msg_sys_status(this);
            case 2:
                return new msg_system_time(this);
            case 4:
                return new msg_ping(this);
            case 5:
                return new msg_change_operator_control(this);
            case 6:
                return new msg_change_operator_control_ack(this);
            case 7:
                return new msg_auth_key(this);
            case 11:
                return new msg_set_mode(this);
            case 20:
                return new msg_param_request_read(this);
            case 21:
                return new msg_param_request_list(this);
            case 22:
                return new msg_param_value(this);
            case 23:
                return new msg_param_set(this);
            case 24:
                return new msg_gps_raw_int(this);
            case 25:
                return new msg_gps_status(this);
            case 26:
                return new msg_scaled_imu(this);
            case 27:
                return new msg_raw_imu(this);
            case 28:
                return new msg_raw_pressure(this);
            case 29:
                return new msg_scaled_pressure(this);
            case 30:
                return new msg_attitude(this);
            case 31:
                return new msg_attitude_quaternion(this);
            case 32:
                return new msg_local_position_ned(this);
            case 33:
                return new msg_global_position_int(this);
            case 34:
                return new msg_rc_channels_scaled(this);
            case 35:
                return new msg_rc_channels_raw(this);
            case 36:
                return new msg_servo_output_raw(this);
            case 37:
                return new msg_mission_request_partial_list(this);
            case 38:
                return new msg_mission_write_partial_list(this);
            case 39:
                return new msg_mission_item(this);
            case 40:
                return new msg_mission_request(this);
            case 41:
                return new msg_mission_set_current(this);
            case 42:
                return new msg_mission_current(this);
            case 43:
                return new msg_mission_request_list(this);
            case 44:
                return new msg_mission_count(this);
            case 45:
                return new msg_mission_clear_all(this);
            case 46:
                return new msg_mission_item_reached(this);
            case 47:
                return new msg_mission_ack(this);
            case 48:
                return new msg_set_gps_global_origin(this);
            case 49:
                return new msg_gps_global_origin(this);
            case 50:
                return new msg_param_map_rc(this);
            case 51:
                return new msg_mission_request_int(this);
            case 54:
                return new msg_safety_set_allowed_area(this);
            case 55:
                return new msg_safety_allowed_area(this);
            case 61:
                return new msg_attitude_quaternion_cov(this);
            case 62:
                return new msg_nav_controller_output(this);
            case 63:
                return new msg_global_position_int_cov(this);
            case 64:
                return new msg_local_position_ned_cov(this);
            case 65:
                return new msg_rc_channels(this);
            case 66:
                return new msg_request_data_stream(this);
            case 67:
                return new msg_data_stream(this);
            case 69:
                return new msg_manual_control(this);
            case 70:
                return new msg_rc_channels_override(this);
            case 73:
                return new msg_mission_item_int(this);
            case 74:
                return new msg_vfr_hud(this);
            case 75:
                return new msg_command_int(this);
            case 76:
                return new msg_command_long(this);
            case 77:
                return new msg_command_ack(this);
            case 81:
                return new msg_manual_setpoint(this);
            case 82:
                return new msg_set_attitude_target(this);
            case 83:
                return new msg_attitude_target(this);
            case 84:
                return new msg_set_position_target_local_ned(this);
            case 85:
                return new msg_position_target_local_ned(this);
            case 86:
                return new msg_set_position_target_global_int(this);
            case 87:
                return new msg_position_target_global_int(this);
            case 89:
                return new msg_local_position_ned_system_global_offset(this);
            case 90:
                return new msg_hil_state(this);
            case 91:
                return new msg_hil_controls(this);
            case 92:
                return new msg_hil_rc_inputs_raw(this);
            case 93:
                return new msg_hil_actuator_controls(this);
            case 100:
                return new msg_optical_flow(this);
            case 101:
                return new msg_global_vision_position_estimate(this);
            case 102:
                return new msg_vision_position_estimate(this);
            case 103:
                return new msg_vision_speed_estimate(this);
            case 104:
                return new msg_vicon_position_estimate(this);
            case 105:
                return new msg_highres_imu(this);
            case 106:
                return new msg_optical_flow_rad(this);
            case 107:
                return new msg_hil_sensor(this);
            case 108:
                return new msg_sim_state(this);
            case 109:
                return new msg_radio_status(this);
            case 110:
                return new msg_file_transfer_protocol(this);
            case 111:
                return new msg_timesync(this);
            case 112:
                return new msg_camera_trigger(this);
            case 113:
                return new msg_hil_gps(this);
            case 114:
                return new msg_hil_optical_flow(this);
            case 115:
                return new msg_hil_state_quaternion(this);
            case 116:
                return new msg_scaled_imu2(this);
            case 117:
                return new msg_log_request_list(this);
            case 118:
                return new msg_log_entry(this);
            case 119:
                return new msg_log_request_data(this);
            case 120:
                return new msg_log_data(this);
            case 121:
                return new msg_log_erase(this);
            case 122:
                return new msg_log_request_end(this);
            case 123:
                return new msg_gps_inject_data(this);
            case 124:
                return new msg_gps2_raw(this);
            case 125:
                return new msg_power_status(this);
            case 126:
                return new msg_serial_control(this);
            case 127:
                return new msg_gps_rtk(this);
            case 128:
                return new msg_gps2_rtk(this);
            case 129:
                return new msg_scaled_imu3(this);
            case 130:
                return new msg_data_transmission_handshake(this);
            case 131:
                return new msg_encapsulated_data(this);
            case 132:
                return new msg_distance_sensor(this);
            case 133:
                return new msg_terrain_request(this);
            case 134:
                return new msg_terrain_data(this);
            case 135:
                return new msg_terrain_check(this);
            case 136:
                return new msg_terrain_report(this);
            case 137:
                return new msg_scaled_pressure2(this);
            case 138:
                return new msg_att_pos_mocap(this);
            case msg_set_actuator_control_target.MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET:
                return new msg_set_actuator_control_target(this);
            case 140:
                return new msg_actuator_control_target(this);
            case 141:
                return new msg_altitude(this);
            case 142:
                return new msg_resource_request(this);
            case 143:
                return new msg_scaled_pressure3(this);
            case 144:
                return new msg_follow_target(this);
            case 146:
                return new msg_control_system_state(this);
            case 147:
                return new msg_battery_status(this);
            case 148:
                return new msg_autopilot_version(this);
            case 149:
                return new msg_landing_target(this);
            case 150:
                return new msg_sensor_offsets(this);
            case 151:
                return new msg_set_mag_offsets(this);
            case 152:
                return new msg_meminfo(this);
            case 153:
                return new msg_ap_adc(this);
            case 154:
                return new msg_digicam_configure(this);
            case 155:
                return new msg_digicam_control(this);
            case 156:
                return new msg_mount_configure(this);
            case 157:
                return new msg_mount_control(this);
            case 158:
                return new msg_mount_status(this);
            case 160:
                return new msg_fence_point(this);
            case 161:
                return new msg_fence_fetch_point(this);
            case 162:
                return new msg_fence_status(this);
            case 163:
                return new msg_ahrs(this);
            case 164:
                return new msg_simstate(this);
            case 165:
                return new msg_hwstatus(this);
            case 166:
                return new msg_radio(this);
            case 167:
                return new msg_limits_status(this);
            case 168:
                return new msg_wind(this);
            case 169:
                return new msg_data16(this);
            case 170:
                return new msg_data32(this);
            case 171:
                return new msg_data64(this);
            case 172:
                return new msg_data96(this);
            case 173:
                return new msg_rangefinder(this);
            case 174:
                return new msg_airspeed_autocal(this);
            case 175:
                return new msg_rally_point(this);
            case 176:
                return new msg_rally_fetch_point(this);
            case 177:
                return new msg_compassmot_status(this);
            case 178:
                return new msg_ahrs2(this);
            case 179:
                return new msg_camera_status(this);
            case 180:
                return new msg_camera_feedback(this);
            case 181:
                return new msg_battery2(this);
            case 182:
                return new msg_ahrs3(this);
            case 183:
                return new msg_autopilot_version_request(this);
            case 184:
                return new msg_remote_log_data_block(this);
            case 185:
                return new msg_remote_log_block_status(this);
            case 186:
                return new msg_led_control(this);
            case 191:
                return new msg_mag_cal_progress(this);
            case 192:
                return new msg_mag_cal_report(this);
            case 193:
                return new msg_ekf_status_report(this);
            case 194:
                return new msg_pid_tuning(this);
            case 195:
                return new msg_deepstall(this);
            case 200:
                return new msg_gimbal_report(this);
            case 201:
                return new msg_gimbal_control(this);
            case 214:
                return new msg_gimbal_torque_cmd_report(this);
            case msg_gopro_heartbeat.MAVLINK_MSG_ID_GOPRO_HEARTBEAT:
                return new msg_gopro_heartbeat(this);
            case 216:
                return new msg_gopro_get_request(this);
            case 217:
                return new msg_gopro_get_response(this);
            case msg_gopro_set_request.MAVLINK_MSG_ID_GOPRO_SET_REQUEST:
                return new msg_gopro_set_request(this);
            case 219:
                return new msg_gopro_set_response(this);
            case 226:
                return new msg_rpm(this);
            case 230:
                return new msg_estimator_status(this);
            case 231:
                return new msg_wind_cov(this);
            case 232:
                return new msg_gps_input(this);
            case msg_gps_rtcm_data.MAVLINK_MSG_ID_GPS_RTCM_DATA:
                return new msg_gps_rtcm_data(this);
            case 234:
                return new msg_high_latency(this);
            case 241:
                return new msg_vibration(this);
            case 242:
                return new msg_home_position(this);
            case 243:
                return new msg_set_home_position(this);
            case 244:
                return new msg_message_interval(this);
            case 245:
                return new msg_extended_sys_state(this);
            case 246:
                return new msg_adsb_vehicle(this);
            case msg_collision.MAVLINK_MSG_ID_COLLISION:
                return new msg_collision(this);
            case 248:
                return new msg_v2_extension(this);
            case 249:
                return new msg_memory_vect(this);
            case 250:
                return new msg_debug_vect(this);
            case 251:
                return new msg_named_value_float(this);
            case 252:
                return new msg_named_value_int(this);
            case 253:
                return new msg_statustext(this);
            case 254:
                return new msg_debug(this);
            case msg_mount_orientation.MAVLINK_MSG_ID_MOUNT_ORIENTATION:
                return new msg_mount_orientation(this);
            default:
                return null;
        }
    }
}
