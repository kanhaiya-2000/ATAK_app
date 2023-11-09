package com.MAVLink.Messages;

import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_current;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_item;
import com.MAVLink.Messages.ardupilotmega.msg_ahrs;
import com.MAVLink.Messages.ardupilotmega.msg_ahrs2;
import com.MAVLink.Messages.ardupilotmega.msg_airspeed_autocal;
import com.MAVLink.Messages.ardupilotmega.msg_ap_adc;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.MAVLink.Messages.ardupilotmega.msg_attitude_quaternion;
import com.MAVLink.Messages.ardupilotmega.msg_attitude_quaternion_cov;
import com.MAVLink.Messages.ardupilotmega.msg_attitude_target;
import com.MAVLink.Messages.ardupilotmega.msg_auth_key;
import com.MAVLink.Messages.ardupilotmega.msg_autopilot_version;
import com.MAVLink.Messages.ardupilotmega.msg_battery2;
import com.MAVLink.Messages.ardupilotmega.msg_battery_status;
import com.MAVLink.Messages.ardupilotmega.msg_camera_feedback;
import com.MAVLink.Messages.ardupilotmega.msg_camera_status;
import com.MAVLink.Messages.ardupilotmega.msg_change_operator_control;
import com.MAVLink.Messages.ardupilotmega.msg_change_operator_control_ack;
import com.MAVLink.Messages.ardupilotmega.msg_command_ack;
import com.MAVLink.Messages.ardupilotmega.msg_command_int;
import com.MAVLink.Messages.ardupilotmega.msg_command_long;
import com.MAVLink.Messages.ardupilotmega.msg_compassmot_status;
import com.MAVLink.Messages.ardupilotmega.msg_custom_battery_status;
import com.MAVLink.Messages.ardupilotmega.msg_custom_flight_status;
import com.MAVLink.Messages.ardupilotmega.msg_data16;
import com.MAVLink.Messages.ardupilotmega.msg_data32;
import com.MAVLink.Messages.ardupilotmega.msg_data64;
import com.MAVLink.Messages.ardupilotmega.msg_data96;
import com.MAVLink.Messages.ardupilotmega.msg_data_stream;
import com.MAVLink.Messages.ardupilotmega.msg_data_transmission_handshake;
import com.MAVLink.Messages.ardupilotmega.msg_debug;
import com.MAVLink.Messages.ardupilotmega.msg_debug_vect;
import com.MAVLink.Messages.ardupilotmega.msg_digicam_configure;
import com.MAVLink.Messages.ardupilotmega.msg_digicam_control;
import com.MAVLink.Messages.ardupilotmega.msg_distance_sensor;
import com.MAVLink.Messages.ardupilotmega.msg_encapsulated_data;
import com.MAVLink.Messages.ardupilotmega.msg_fence_fetch_point;
import com.MAVLink.Messages.ardupilotmega.msg_fence_point;
import com.MAVLink.Messages.ardupilotmega.msg_fence_status;
import com.MAVLink.Messages.ardupilotmega.msg_file_transfer_protocol;
import com.MAVLink.Messages.ardupilotmega.msg_global_position_int;
import com.MAVLink.Messages.ardupilotmega.msg_global_position_int_cov;
import com.MAVLink.Messages.ardupilotmega.msg_global_vision_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_gps2_raw;
import com.MAVLink.Messages.ardupilotmega.msg_gps2_rtk;
import com.MAVLink.Messages.ardupilotmega.msg_gps_global_origin;
import com.MAVLink.Messages.ardupilotmega.msg_gps_inject_data;
import com.MAVLink.Messages.ardupilotmega.msg_gps_raw_int;
import com.MAVLink.Messages.ardupilotmega.msg_gps_rtk;
import com.MAVLink.Messages.ardupilotmega.msg_gps_status;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.MAVLink.Messages.ardupilotmega.msg_highres_imu;
import com.MAVLink.Messages.ardupilotmega.msg_hil_controls;
import com.MAVLink.Messages.ardupilotmega.msg_hil_gps;
import com.MAVLink.Messages.ardupilotmega.msg_hil_optical_flow;
import com.MAVLink.Messages.ardupilotmega.msg_hil_rc_inputs_raw;
import com.MAVLink.Messages.ardupilotmega.msg_hil_sensor;
import com.MAVLink.Messages.ardupilotmega.msg_hil_state;
import com.MAVLink.Messages.ardupilotmega.msg_hil_state_quaternion;
import com.MAVLink.Messages.ardupilotmega.msg_hwstatus;
import com.MAVLink.Messages.ardupilotmega.msg_limits_status;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned_cov;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned_system_global_offset;
import com.MAVLink.Messages.ardupilotmega.msg_log_data;
import com.MAVLink.Messages.ardupilotmega.msg_log_entry;
import com.MAVLink.Messages.ardupilotmega.msg_log_erase;
import com.MAVLink.Messages.ardupilotmega.msg_log_request_data;
import com.MAVLink.Messages.ardupilotmega.msg_log_request_end;
import com.MAVLink.Messages.ardupilotmega.msg_log_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_manual_control;
import com.MAVLink.Messages.ardupilotmega.msg_manual_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_meminfo;
import com.MAVLink.Messages.ardupilotmega.msg_memory_vect;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_mission_clear_all;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_current;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item_int;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item_reached;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_partial_list;
import com.MAVLink.Messages.ardupilotmega.msg_mission_set_current;
import com.MAVLink.Messages.ardupilotmega.msg_mission_write_partial_list;
import com.MAVLink.Messages.ardupilotmega.msg_mount_configure;
import com.MAVLink.Messages.ardupilotmega.msg_mount_control;
import com.MAVLink.Messages.ardupilotmega.msg_mount_status;
import com.MAVLink.Messages.ardupilotmega.msg_named_value_float;
import com.MAVLink.Messages.ardupilotmega.msg_named_value_int;
import com.MAVLink.Messages.ardupilotmega.msg_nav_controller_output;
import com.MAVLink.Messages.ardupilotmega.msg_nav_followme;
import com.MAVLink.Messages.ardupilotmega.msg_omnidirectional_flow;
import com.MAVLink.Messages.ardupilotmega.msg_optical_flow;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_read;
import com.MAVLink.Messages.ardupilotmega.msg_param_set;
import com.MAVLink.Messages.ardupilotmega.msg_param_value;
import com.MAVLink.Messages.ardupilotmega.msg_ping;
import com.MAVLink.Messages.ardupilotmega.msg_position_target_global_int;
import com.MAVLink.Messages.ardupilotmega.msg_position_target_local_ned;
import com.MAVLink.Messages.ardupilotmega.msg_power_status;
import com.MAVLink.Messages.ardupilotmega.msg_ptz_frame_cmd;
import com.MAVLink.Messages.ardupilotmega.msg_radio;
import com.MAVLink.Messages.ardupilotmega.msg_radio_status;
import com.MAVLink.Messages.ardupilotmega.msg_rally_fetch_point;
import com.MAVLink.Messages.ardupilotmega.msg_rally_point;
import com.MAVLink.Messages.ardupilotmega.msg_rangefinder;
import com.MAVLink.Messages.ardupilotmega.msg_raw_imu;
import com.MAVLink.Messages.ardupilotmega.msg_raw_pressure;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_override;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_raw;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_scaled;
import com.MAVLink.Messages.ardupilotmega.msg_request_data_stream;
import com.MAVLink.Messages.ardupilotmega.msg_safety_allowed_area;
import com.MAVLink.Messages.ardupilotmega.msg_safety_set_allowed_area;
import com.MAVLink.Messages.ardupilotmega.msg_scaled_imu;
import com.MAVLink.Messages.ardupilotmega.msg_scaled_imu2;
import com.MAVLink.Messages.ardupilotmega.msg_scaled_pressure;
import com.MAVLink.Messages.ardupilotmega.msg_sensor_offsets;
import com.MAVLink.Messages.ardupilotmega.msg_serial_control;
import com.MAVLink.Messages.ardupilotmega.msg_servo_output_raw;
import com.MAVLink.Messages.ardupilotmega.msg_set_attitude_target;
import com.MAVLink.Messages.ardupilotmega.msg_set_gps_global_origin;
import com.MAVLink.Messages.ardupilotmega.msg_set_local_position_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_set_mag_offsets;
import com.MAVLink.Messages.ardupilotmega.msg_set_mode;
import com.MAVLink.Messages.ardupilotmega.msg_set_position_target_global_int;
import com.MAVLink.Messages.ardupilotmega.msg_set_position_target_local_ned;
import com.MAVLink.Messages.ardupilotmega.msg_sim_state;
import com.MAVLink.Messages.ardupilotmega.msg_simstate;
import com.MAVLink.Messages.ardupilotmega.msg_statustext;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.MAVLink.Messages.ardupilotmega.msg_system_time;
import com.MAVLink.Messages.ardupilotmega.msg_terrain_check;
import com.MAVLink.Messages.ardupilotmega.msg_terrain_data;
import com.MAVLink.Messages.ardupilotmega.msg_terrain_report;
import com.MAVLink.Messages.ardupilotmega.msg_terrain_request;
import com.MAVLink.Messages.ardupilotmega.msg_v2_extension;
import com.MAVLink.Messages.ardupilotmega.msg_vfr_hud;
import com.MAVLink.Messages.ardupilotmega.msg_vicon_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_vision_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_vision_speed_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_wind;
import java.io.PrintStream;
import java.io.Serializable;

public class MAVLinkPacket implements Serializable {
    public static final int MAVLINK_STX = 254;
    private static final long serialVersionUID = 2095947771227815314L;
    public int compid;
    public CRC crc;
    public int len;
    public int msgid;
    public MAVLinkPayload payload = new MAVLinkPayload();
    public int seq;
    public int sysid;

    public boolean payloadIsFilled() {
        return this.payload.size() >= 511 || this.payload.size() == this.len;
    }

    public void generateCRC() {
        CRC crc2 = new CRC();
        this.crc = crc2;
        crc2.update_checksum(this.len);
        this.crc.update_checksum(this.seq);
        this.crc.update_checksum(this.sysid);
        this.crc.update_checksum(this.compid);
        this.crc.update_checksum(this.msgid);
        this.payload.resetIndex();
        for (int i = 0; i < this.payload.size(); i++) {
            this.crc.update_checksum(this.payload.getByte());
        }
        this.crc.finish_checksum(this.msgid);
    }

    public byte[] encodePacket() {
        int i = this.len;
        byte[] bArr = new byte[(i + 6 + 2)];
        int i2 = 0;
        bArr[0] = -2;
        bArr[1] = (byte) i;
        bArr[2] = (byte) this.seq;
        bArr[3] = (byte) this.sysid;
        bArr[4] = (byte) this.compid;
        bArr[5] = (byte) this.msgid;
        int i3 = 6;
        while (i2 < this.payload.size()) {
            bArr[i3] = this.payload.payload.get(i2);
            i2++;
            i3++;
        }
        generateCRC();
        bArr[i3] = (byte) this.crc.getLSB();
        bArr[i3 + 1] = (byte) this.crc.getMSB();
        return bArr;
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
                return new msg_set_local_position_setpoint(this);
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
                return new msg_omnidirectional_flow(this);
            case 107:
                return new msg_hil_sensor(this);
            case 108:
                return new msg_sim_state(this);
            case 109:
                return new msg_radio_status(this);
            case 110:
                return new msg_file_transfer_protocol(this);
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
            case 147:
                return new msg_battery_status(this);
            case 148:
                return new msg_autopilot_version(this);
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
            case 200:
                return new msg_ptz_frame_cmd(this);
            case 214:
                return new msg_custom_battery_status(this);
            case 216:
                return new msg_custom_flight_status(this);
            case 220:
                return new msg_nav_followme(this);
            case 221:
                return new mavlink_msg_mission_new_current(this);
            case 222:
                return new mavlink_msg_mission_new_item(this);
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
            default:
                PrintStream printStream = System.err;
                printStream.println("UNKNOWN MESSAGE - " + this.msgid);
                return null;
        }
    }
}
