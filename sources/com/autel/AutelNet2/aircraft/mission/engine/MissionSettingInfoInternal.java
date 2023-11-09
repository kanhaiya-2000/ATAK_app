package com.autel.AutelNet2.aircraft.mission.engine;

import java.util.List;

public class MissionSettingInfoInternal {
    private String method;
    private ParamsBean params;

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public ParamsBean getParams() {
        return this.params;
    }

    public void setParams(ParamsBean paramsBean) {
        this.params = paramsBean;
    }

    public static class ParamsBean {
        private FMUMissionInfoBean FMUMissionInfo;
        private List<WaypointBean> Waypoint;

        public FMUMissionInfoBean getFMUMissionInfo() {
            return this.FMUMissionInfo;
        }

        public void setFMUMissionInfo(FMUMissionInfoBean fMUMissionInfoBean) {
            this.FMUMissionInfo = fMUMissionInfoBean;
        }

        public List<WaypointBean> getWaypoint() {
            return this.Waypoint;
        }

        public void setWaypoint(List<WaypointBean> list) {
            this.Waypoint = list;
        }

        public static class FMUMissionInfoBean {
            private int FinishAction;
            private int LostControlAction;
            private int MissionId;
            private int ObstacleAvoidanceMode;
            private int ObstacleAvoidanceTimeout;

            public int getMissionId() {
                return this.MissionId;
            }

            public void setMissionId(int i) {
                this.MissionId = i;
            }

            public int getFinishAction() {
                return this.FinishAction;
            }

            public void setFinishAction(int i) {
                this.FinishAction = i;
            }

            public int getObstacleAvoidanceMode() {
                return this.ObstacleAvoidanceMode;
            }

            public void setObstacleAvoidanceMode(int i) {
                this.ObstacleAvoidanceMode = i;
            }

            public int getObstacleAvoidanceTimeout() {
                return this.ObstacleAvoidanceTimeout;
            }

            public void setObstacleAvoidanceTimeout(int i) {
                this.ObstacleAvoidanceTimeout = i;
            }

            public int getLostControlAction() {
                return this.LostControlAction;
            }

            public void setLostControlAction(int i) {
                this.LostControlAction = i;
            }
        }

        public static class WaypointBean {
            private List<ActionsBean> Actions;
            private int Altitude;
            private int AltitudePriorityMode;
            private int BeizerParameter;
            private int CameraPitch;
            private int CameraYaw;
            private int FocusAltitude;
            private int FocusLatitude;
            private int FocusLongitude;
            private int HeadingMode;
            private int Latitude;
            private int Longitude;
            private OrbitInfo OrbitInfo;
            private int Speed;
            private int UserdefinedHeading;
            private int WaypointId;
            private int WaypointType;

            public int getWaypointId() {
                return this.WaypointId;
            }

            public void setWaypointId(int i) {
                this.WaypointId = i;
            }

            public int getWaypointType() {
                return this.WaypointType;
            }

            public void setWaypointType(int i) {
                this.WaypointType = i;
            }

            public int getLatitude() {
                return this.Latitude;
            }

            public void setLatitude(int i) {
                this.Latitude = i;
            }

            public int getLongitude() {
                return this.Longitude;
            }

            public void setLongitude(int i) {
                this.Longitude = i;
            }

            public int getAltitude() {
                return this.Altitude;
            }

            public void setAltitude(int i) {
                this.Altitude = i;
            }

            public int getSpeed() {
                return this.Speed;
            }

            public void setSpeed(int i) {
                this.Speed = i;
            }

            public int getFocusLatitude() {
                return this.FocusLatitude;
            }

            public void setFocusLatitude(int i) {
                this.FocusLatitude = i;
            }

            public int getFocusLongitude() {
                return this.FocusLongitude;
            }

            public void setFocusLongitude(int i) {
                this.FocusLongitude = i;
            }

            public int getFocusAltitude() {
                return this.FocusAltitude;
            }

            public void setFocusAltitude(int i) {
                this.FocusAltitude = i;
            }

            public int getBeizerParameter() {
                return this.BeizerParameter;
            }

            public void setBeizerParameter(int i) {
                this.BeizerParameter = i;
            }

            public int getAltitudePriorityMode() {
                return this.AltitudePriorityMode;
            }

            public void setAltitudePriorityMode(int i) {
                this.AltitudePriorityMode = i;
            }

            public int getHeadingMode() {
                return this.HeadingMode;
            }

            public void setHeadingMode(int i) {
                this.HeadingMode = i;
            }

            public int getUserdefinedHeading() {
                return this.UserdefinedHeading;
            }

            public void setUserdefinedHeading(int i) {
                this.UserdefinedHeading = i;
            }

            public int getCameraPitch() {
                return this.CameraPitch;
            }

            public void setCameraPitch(int i) {
                this.CameraPitch = i;
            }

            public int getCameraYaw() {
                return this.CameraYaw;
            }

            public void setCameraYaw(int i) {
                this.CameraYaw = i;
            }

            public OrbitInfo getOrbitInfo() {
                return this.OrbitInfo;
            }

            public void setOrbitInfo(OrbitInfo orbitInfo) {
                this.OrbitInfo = orbitInfo;
            }

            public List<ActionsBean> getActions() {
                return this.Actions;
            }

            public void setActions(List<ActionsBean> list) {
                this.Actions = list;
            }

            public static class OrbitInfo {
                private int CenterAltitude;
                private int CenterLattidue;
                private int CenterLongitude;
                private int Cycles;
                private int EntryDirection;
                private int HeadingDirection;
                private int Radius;
                private int RemainDegree;
                private int RotateDirection;
                private int Speed;

                public int getSpeed() {
                    return this.Speed;
                }

                public void setSpeed(int i) {
                    this.Speed = i;
                }

                public int getRadius() {
                    return this.Radius;
                }

                public void setRadius(int i) {
                    this.Radius = i;
                }

                public int getCycles() {
                    return this.Cycles;
                }

                public void setCycles(int i) {
                    this.Cycles = i;
                }

                public int getRemainDegree() {
                    return this.RemainDegree;
                }

                public void setRemainDegree(int i) {
                    this.RemainDegree = i;
                }

                public int getRotateDirection() {
                    return this.RotateDirection;
                }

                public void setRotateDirection(int i) {
                    this.RotateDirection = i;
                }

                public int getHeadingDirection() {
                    return this.HeadingDirection;
                }

                public void setHeadingDirection(int i) {
                    this.HeadingDirection = i;
                }

                public int getCenterLattidue() {
                    return this.CenterLattidue;
                }

                public void setCenterLattidue(int i) {
                    this.CenterLattidue = i;
                }

                public int getCenterLongitude() {
                    return this.CenterLongitude;
                }

                public void setCenterLongitude(int i) {
                    this.CenterLongitude = i;
                }

                public int getCenterAltitude() {
                    return this.CenterAltitude;
                }

                public void setCenterAltitude(int i) {
                    this.CenterAltitude = i;
                }

                public int getEntryDirection() {
                    return this.EntryDirection;
                }

                public void setEntryDirection(int i) {
                    this.EntryDirection = i;
                }
            }

            public static class ActionsBean {
                private int ActionId;
                private int[] ActionParameters;
                private int ActionTimeout;
                private int ActionType;

                public int getActionId() {
                    return this.ActionId;
                }

                public void setActionId(int i) {
                    this.ActionId = i;
                }

                public int getActionType() {
                    return this.ActionType;
                }

                public void setActionType(int i) {
                    this.ActionType = i;
                }

                public int getActionTimeout() {
                    return this.ActionTimeout;
                }

                public void setActionTimeout(int i) {
                    this.ActionTimeout = i;
                }

                public int[] getActionParameters() {
                    return this.ActionParameters;
                }

                public void setActionParameters(int[] iArr) {
                    this.ActionParameters = iArr;
                }
            }
        }
    }
}
