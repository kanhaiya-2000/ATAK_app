package com.autel.AutelNet2.aircraft.mission.engine;

import java.util.List;

public class WayPointMissionInfo {
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
        private int FinishAction;
        private int LostControlAction;
        private int MissionId;
        private int NumberOfWaypoints;
        private int ObstacleAvoidanceMode;
        private int ObstacleAvoidanceTimeout;
        private List<WaypointsBean> Waypoints;

        public int getFinishAction() {
            return this.FinishAction;
        }

        public void setFinishAction(int i) {
            this.FinishAction = i;
        }

        public int getLostControlAction() {
            return this.LostControlAction;
        }

        public void setLostControlAction(int i) {
            this.LostControlAction = i;
        }

        public int getMissionId() {
            return this.MissionId;
        }

        public void setMissionId(int i) {
            this.MissionId = i;
        }

        public int getNumberOfWaypoints() {
            return this.NumberOfWaypoints;
        }

        public void setNumberOfWaypoints(int i) {
            this.NumberOfWaypoints = i;
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

        public List<WaypointsBean> getWaypoints() {
            return this.Waypoints;
        }

        public void setWaypoints(List<WaypointsBean> list) {
            this.Waypoints = list;
        }

        public static class WaypointsBean {
            private List<ActionsBean> Actions;
            private int Altitude;
            private int AltitudePriorityMode;
            private int BeizerParameter;
            private double CameraPitch;
            private double CameraYaw;
            private int FocusAltitude;
            private int FocusLatitude;
            private int FocusLongtitude;
            private int HeadingMode;
            private int Latitude;
            private int Longtitude;
            private int MissionId;
            private int NumberOfActions;
            private int Speed;
            private double UserdefinedHeading;
            private int WaypointId;

            public int getAltitude() {
                return this.Altitude;
            }

            public void setAltitude(int i) {
                this.Altitude = i;
            }

            public int getAltitudePriorityMode() {
                return this.AltitudePriorityMode;
            }

            public void setAltitudePriorityMode(int i) {
                this.AltitudePriorityMode = i;
            }

            public int getBeizerParameter() {
                return this.BeizerParameter;
            }

            public void setBeizerParameter(int i) {
                this.BeizerParameter = i;
            }

            public double getCameraPitch() {
                return this.CameraPitch;
            }

            public void setCameraPitch(double d) {
                this.CameraPitch = d;
            }

            public double getCameraYaw() {
                return this.CameraYaw;
            }

            public void setCameraYaw(double d) {
                this.CameraYaw = d;
            }

            public int getFocusAltitude() {
                return this.FocusAltitude;
            }

            public void setFocusAltitude(int i) {
                this.FocusAltitude = i;
            }

            public int getFocusLatitude() {
                return this.FocusLatitude;
            }

            public void setFocusLatitude(int i) {
                this.FocusLatitude = i;
            }

            public int getFocusLongtitude() {
                return this.FocusLongtitude;
            }

            public void setFocusLongtitude(int i) {
                this.FocusLongtitude = i;
            }

            public int getHeadingMode() {
                return this.HeadingMode;
            }

            public void setHeadingMode(int i) {
                this.HeadingMode = i;
            }

            public int getLatitude() {
                return this.Latitude;
            }

            public void setLatitude(int i) {
                this.Latitude = i;
            }

            public int getLongtitude() {
                return this.Longtitude;
            }

            public void setLongtitude(int i) {
                this.Longtitude = i;
            }

            public int getMissionId() {
                return this.MissionId;
            }

            public void setMissionId(int i) {
                this.MissionId = i;
            }

            public int getNumberOfActions() {
                return this.NumberOfActions;
            }

            public void setNumberOfActions(int i) {
                this.NumberOfActions = i;
            }

            public int getSpeed() {
                return this.Speed;
            }

            public void setSpeed(int i) {
                this.Speed = i;
            }

            public double getUserdefinedHeading() {
                return this.UserdefinedHeading;
            }

            public void setUserdefinedHeading(double d) {
                this.UserdefinedHeading = d;
            }

            public int getWaypointId() {
                return this.WaypointId;
            }

            public void setWaypointId(int i) {
                this.WaypointId = i;
            }

            public List<ActionsBean> getActions() {
                return this.Actions;
            }

            public void setActions(List<ActionsBean> list) {
                this.Actions = list;
            }

            public static class ActionsBean {

                /* renamed from: Id */
                private int f8432Id;
                private List<Double> Parameters;
                private int Timeout;
                private int Type;

                public int getTimeout() {
                    return this.Timeout;
                }

                public void setTimeout(int i) {
                    this.Timeout = i;
                }

                public int getType() {
                    return this.Type;
                }

                public void setType(int i) {
                    this.Type = i;
                }

                public int getId() {
                    return this.f8432Id;
                }

                public void setId(int i) {
                    this.f8432Id = i;
                }

                public List<Double> getParameters() {
                    return this.Parameters;
                }

                public void setParameters(List<Double> list) {
                    this.Parameters = list;
                }
            }
        }
    }
}
