package com.autel.sdk10.AutelCommunity.engine;

import android.text.TextUtils;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.AutelCommunity.enums.AutelErrorReson;
import com.autel.sdk10.AutelCommunity.utils.AutelMD5Util;
import com.autel.sdk10.AutelCommunity.utils.AutelSystemUtils;
import com.autel.sdk10.AutelCommunity.utils.SignModel;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import com.autel.util.okhttp.OkHttpManager;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.HttpMediaType;
import com.autel.util.okhttp.model.Mutlipart;
import com.autel.util.okhttp.utils.MessageParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AutelCommunityRequest {
    private static AutelCommunityRequest s_instance;
    /* access modifiers changed from: private */
    public String TAG = "AutelCommunityRequest";
    private Headers headers;
    protected MessageParser messageParser;
    private OkHttpManager okHttpManager = new OkHttpManager.Builder().setConnectTimeout(ConnectionType.DEFAULT_UDP_PING_PERIOD, TimeUnit.MILLISECONDS).setReadTimeout(ConnectionType.DEFAULT_UDP_PING_PERIOD, TimeUnit.MILLISECONDS).setWriteTimeout(ConnectionType.DEFAULT_UDP_PING_PERIOD, TimeUnit.MILLISECONDS).build();

    public interface IAutelChangeCustomerAutelRoboticsIDListener {
        void onFailure(String str);

        void onStart();

        void onSuccess();
    }

    public interface IAutelCommunityListener {
        void onFailure(AutelErrorReson autelErrorReson);

        void onStart();

        void onSuccess();
    }

    public interface IAutelCommunityLoginListener {
        void onFailure(AutelErrorReson autelErrorReson);

        void onStart();

        void onSuccess(AutelCommunityInfo autelCommunityInfo);
    }

    public interface IAutelCommunityNoFlyZoneListener {
        void onFailure(String str);

        void onSuccess(NoFlyZoneResult noFlyZoneResult);
    }

    public interface IAutelCommunityQuerySNStatusListener {
        void onFailure(AutelErrorReson autelErrorReson);

        void onSuccess(int i, String str);
    }

    public interface IAutelCommunityRegProductListener {
        void onFailure(String str);

        void onStart();

        void onSuccess(String str);
    }

    public interface IAutelQueryPersonalRegProductsListener {
        void onFailure();

        void onStart();

        void onSuccess(int i, List<AutelRegProductInfo> list);
    }

    private AutelCommunityRequest() {
        Headers headers2 = new Headers();
        this.headers = headers2;
        headers2.put("User-Agent", AutelSystemUtils.getHttpUserAgent());
        this.messageParser = new MessageParser();
    }

    public static AutelCommunityRequest instance() {
        if (s_instance == null) {
            s_instance = new AutelCommunityRequest();
        }
        return s_instance;
    }

    public void requestAutelRegister(final String str, final String str2, final IAutelCommunityListener iAutelCommunityListener) {
        String checkIsExixtUrl = SignModel.getCheckIsExixtUrl("autelId=" + str);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(checkIsExixtUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(checkIsExixtUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (new JSONObject(str).optInt("code") == 0) {
                            AutelCommunityRequest.this.sendRegisterRequest(SignModel.getRegisterUrl("autelId=" + str + "&userPwd=" + AutelMD5Util.getMD5String(str2)), iAutelCommunityListener);
                            return;
                        }
                        IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                        if (iAutelCommunityListener != null) {
                            iAutelCommunityListener.onFailure(AutelErrorReson.EXIST_REGISTER);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                        if (iAutelCommunityListener2 != null) {
                            iAutelCommunityListener2.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                        }
                        String access$0002 = AutelCommunityRequest.this.TAG;
                        AutelLog.m15082d(access$0002, "onSuccess:JSONException " + e.getMessage());
                    }
                } else {
                    IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                    if (iAutelCommunityListener3 != null) {
                        iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void requestAutelLogin(String str, String str2, final IAutelCommunityLoginListener iAutelCommunityLoginListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("autelId", str);
        hashMap.put("password", AutelMD5Util.getMD5String(str2));
        String loginUrl = SignModel.getLoginUrl(hashMap);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(loginUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(loginUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityLoginListener iAutelCommunityLoginListener = iAutelCommunityLoginListener;
                if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onSuccess:" + str);
                AutelCommunityRequest.this.dealLoginResult(str, iAutelCommunityLoginListener);
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityLoginListener iAutelCommunityLoginListener = iAutelCommunityLoginListener;
                if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void requestAutelCommunityInfoModify(AutelCommunityInfo autelCommunityInfo, final IAutelCommunityListener iAutelCommunityListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("firstName", autelCommunityInfo.getUserFirstName());
        hashMap.put("actCode", autelCommunityInfo.getActCode());
        hashMap.put("code", autelCommunityInfo.getCode());
        hashMap.put("sex", autelCommunityInfo.getSex());
        hashMap.put("province", "null");
        hashMap.put("city", "null");
        hashMap.put("country", autelCommunityInfo.getCountry());
        String editUserUrl = SignModel.getEditUserUrl(hashMap);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(editUserUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(editUserUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendUpdateCustomerInfo onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int optInt = new JSONObject(str).optInt("code");
                        if (1 == optInt) {
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                            }
                        } else if (-142 == optInt) {
                            IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                            if (iAutelCommunityListener2 != null) {
                                iAutelCommunityListener2.onFailure(AutelErrorReson.REQUEST_ERROR_PARAM);
                            }
                        } else {
                            IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                            if (iAutelCommunityListener3 != null) {
                                iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_FAIL);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener4 = iAutelCommunityListener;
                        if (iAutelCommunityListener4 != null) {
                            iAutelCommunityListener4.onFailure(AutelErrorReson.REQUEST_LOSS_PARAM);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void requestAutelCommunityFindPwd(String str, final IAutelCommunityListener iAutelCommunityListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("autelId", str);
        String findPwdUrl = SignModel.getFindPwdUrl(hashMap);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(findPwdUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(findPwdUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendCheckEmail onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        int optInt = new JSONObject(str).optInt("code");
                        if (1 == optInt) {
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                            }
                        } else if (-161 == optInt) {
                            IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                            if (iAutelCommunityListener2 != null) {
                                iAutelCommunityListener2.onFailure(AutelErrorReson.EMAIL_NO_REGISTER);
                            }
                        } else if (optInt == 0) {
                            IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                            if (iAutelCommunityListener3 != null) {
                                iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_FAIL);
                            }
                        } else {
                            IAutelCommunityListener iAutelCommunityListener4 = iAutelCommunityListener;
                            if (iAutelCommunityListener4 != null) {
                                iAutelCommunityListener4.onFailure(AutelErrorReson.SYSTEM_ERROR);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener5 = iAutelCommunityListener;
                        if (iAutelCommunityListener5 != null) {
                            iAutelCommunityListener5.onFailure(AutelErrorReson.REQUEST_LOSS_PARAM);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public String requestAutelCommunityForumUrl(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("autelID", str);
        return SignModel.getAutelForumUrl(hashMap);
    }

    public void requestRegisterProduct(String str, String str2, final IAutelCommunityRegProductListener iAutelCommunityRegProductListener) {
        String regProductUrl = SignModel.getRegProductUrl(str, str2);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(regProductUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(regProductUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityRegProductListener iAutelCommunityRegProductListener = iAutelCommunityRegProductListener;
                if (iAutelCommunityRegProductListener != null) {
                    iAutelCommunityRegProductListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "requestRegisterProduct onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("code");
                        if (1 == optInt) {
                            IAutelCommunityRegProductListener iAutelCommunityRegProductListener = iAutelCommunityRegProductListener;
                            if (iAutelCommunityRegProductListener != null) {
                                iAutelCommunityRegProductListener.onSuccess((String) null);
                            }
                        } else if (-122 == optInt) {
                            IAutelCommunityRegProductListener iAutelCommunityRegProductListener2 = iAutelCommunityRegProductListener;
                            if (iAutelCommunityRegProductListener2 != null) {
                                iAutelCommunityRegProductListener2.onSuccess(jSONObject.optString("reg_autelId"));
                            }
                        } else if (iAutelCommunityRegProductListener != null) {
                            String access$0002 = AutelCommunityRequest.this.TAG;
                            AutelLog.m15082d(access$0002, "sendLoginRequest activate failed msg:" + jSONObject.optString("msg"));
                            iAutelCommunityRegProductListener.onFailure(String.valueOf(optInt));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (iAutelCommunityRegProductListener != null) {
                            String access$0003 = AutelCommunityRequest.this.TAG;
                            AutelLog.m15082d(access$0003, "sendLoginRequest Exception:" + e.toString());
                            iAutelCommunityRegProductListener.onFailure((String) null);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityRegProductListener iAutelCommunityRegProductListener = iAutelCommunityRegProductListener;
                if (iAutelCommunityRegProductListener != null) {
                    iAutelCommunityRegProductListener.onFailure((String) null);
                }
            }
        });
    }

    private void requestRegProduct(String str, String str2, final IAutelCommunityListener iAutelCommunityListener) {
        String regProductUrl = SignModel.getRegProductUrl(str, str2);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(regProductUrl), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(regProductUrl), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (1 == jSONObject.optInt("code")) {
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                            }
                        } else if ("reg".equals(jSONObject.optString("msg"))) {
                            IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                            if (iAutelCommunityListener2 != null) {
                                iAutelCommunityListener2.onSuccess();
                            }
                        } else {
                            IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                            if (iAutelCommunityListener3 != null) {
                                iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_LOSS_PARAM);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener4 = iAutelCommunityListener;
                        if (iAutelCommunityListener4 != null) {
                            iAutelCommunityListener4.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void dealLoginResult(Object obj, IAutelCommunityLoginListener iAutelCommunityLoginListener) {
        String obj2 = obj.toString();
        if (!TextUtils.isEmpty(obj2)) {
            try {
                JSONObject jSONObject = new JSONObject(obj2);
                int optInt = jSONObject.optInt("code");
                if (1 == optInt) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
                    AutelCommunityInfo.instance().setAutelId(jSONObject2.optString("autelId"));
                    AutelCommunityInfo.instance().setCode(jSONObject2.optString("code"));
                    String optString = jSONObject2.optString("firstName");
                    if (TextUtils.isEmpty(optString) || "null".equals(optString)) {
                        optString = AutelCommunityInfo.instance().getAutelId().replace(".com", "");
                    }
                    AutelCommunityInfo.instance().setUserFirstName(optString);
                    AutelCommunityInfo.instance().setSex(jSONObject2.optString("sex"));
                    AutelCommunityInfo.instance().setActCode(jSONObject2.optString("actCode"));
                    AutelCommunityInfo.instance().setCity(jSONObject2.optString("city"));
                    AutelCommunityInfo.instance().setCountry(jSONObject2.optString("country"));
                    AutelCommunityInfo.instance().setAddress(jSONObject2.optString("address"));
                    AutelCommunityInfo.instance().setProvince(jSONObject2.optString("province"));
                    AutelCommunityInfo.instance().setImageUrl(jSONObject2.optString("avatar_url"));
                    if (iAutelCommunityLoginListener != null) {
                        iAutelCommunityLoginListener.onSuccess(AutelCommunityInfo.instance());
                    }
                } else if (-151 == optInt) {
                    if (iAutelCommunityLoginListener != null) {
                        iAutelCommunityLoginListener.onFailure(AutelErrorReson.EMAIL_NO_REGISTER);
                    }
                } else if (-152 == optInt) {
                    if (iAutelCommunityLoginListener != null) {
                        iAutelCommunityLoginListener.onFailure(AutelErrorReson.PASSWORD_ERROR);
                    }
                } else if (-153 == optInt) {
                    if (iAutelCommunityLoginListener != null) {
                        iAutelCommunityLoginListener.onFailure(AutelErrorReson.SYSTEM_ERROR);
                    }
                } else if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onFailure(AutelErrorReson.REQUEST_FAIL);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendRegisterRequest(String str, final IAutelCommunityListener iAutelCommunityListener) {
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(str), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(str), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (1 == new JSONObject(str).optInt("code")) {
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                                return;
                            }
                            return;
                        }
                        IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                        if (iAutelCommunityListener2 != null) {
                            iAutelCommunityListener2.onFailure(AutelErrorReson.REQUEST_FAIL);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                        if (iAutelCommunityListener3 != null) {
                            iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void queryPersonalRegProducts(String str, final IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener) {
        if (iAutelQueryPersonalRegProductsListener != null) {
            iAutelQueryPersonalRegProductsListener.onStart();
        }
        String queryPersonalRegProducts = SignModel.queryPersonalRegProducts(str);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(queryPersonalRegProducts), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(queryPersonalRegProducts), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener = iAutelQueryPersonalRegProductsListener;
                if (iAutelQueryPersonalRegProductsListener != null) {
                    iAutelQueryPersonalRegProductsListener.onStart();
                }
            }

            public void onSuccess(String str) {
                AutelLog.m15082d("AutelProductAircraftRequestManager", "queryPersonalRegProducts onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (1 == jSONObject.optInt("code")) {
                            IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener = iAutelQueryPersonalRegProductsListener;
                            if (iAutelQueryPersonalRegProductsListener != null) {
                                AutelCommunityRequest.this.onQueryPersonalRegProductsSucc(jSONObject, iAutelQueryPersonalRegProductsListener);
                                return;
                            }
                            return;
                        }
                        IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener2 = iAutelQueryPersonalRegProductsListener;
                        if (iAutelQueryPersonalRegProductsListener2 != null) {
                            iAutelQueryPersonalRegProductsListener2.onFailure();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener3 = iAutelQueryPersonalRegProductsListener;
                        if (iAutelQueryPersonalRegProductsListener3 != null) {
                            iAutelQueryPersonalRegProductsListener3.onFailure();
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener = iAutelQueryPersonalRegProductsListener;
                if (iAutelQueryPersonalRegProductsListener != null) {
                    iAutelQueryPersonalRegProductsListener.onFailure();
                }
            }
        });
    }

    public void queryProductBindStatusByProductSn(String str, final IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener) {
        String queryProductBindStatus = SignModel.queryProductBindStatus(str);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(queryProductBindStatus), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(queryProductBindStatus), new ResponseCallBack<String>() {
            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "queryProductBindStatus onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("code");
                        String optString = new JSONObject(jSONObject.optString("data")).optString("autelId");
                        if (1 == optInt) {
                            int optInt2 = new JSONObject(jSONObject.optString("data")).optInt(DownloadTask.STATUS);
                            IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener = iAutelCommunityQuerySNStatusListener;
                            if (iAutelCommunityQuerySNStatusListener != null) {
                                iAutelCommunityQuerySNStatusListener.onSuccess(optInt2, optString);
                            }
                        } else if (optInt == 0) {
                            int optInt3 = new JSONObject(jSONObject.optString("data")).optInt(DownloadTask.STATUS);
                            IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener2 = iAutelCommunityQuerySNStatusListener;
                            if (iAutelCommunityQuerySNStatusListener2 != null) {
                                iAutelCommunityQuerySNStatusListener2.onSuccess(optInt3, optString);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener3 = iAutelCommunityQuerySNStatusListener;
                        if (iAutelCommunityQuerySNStatusListener3 != null) {
                            iAutelCommunityQuerySNStatusListener3.onFailure(AutelErrorReson.REQUEST_FAIL);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener = iAutelCommunityQuerySNStatusListener;
                if (iAutelCommunityQuerySNStatusListener != null) {
                    iAutelCommunityQuerySNStatusListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void onQueryPersonalRegProductsSucc(JSONObject jSONObject, IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        int optInt = jSONObject2.optInt("totalCount");
        JSONArray jSONArray = jSONObject2.getJSONArray("result");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
            AutelRegProductInfo autelRegProductInfo = new AutelRegProductInfo();
            autelRegProductInfo.setProSerialNo(jSONObject3.optString("proSerialNo"));
            autelRegProductInfo.setProRegTime(jSONObject3.optString("proRegTime"));
            autelRegProductInfo.setAircraftSerialNumber(jSONObject3.optString("aircraftSerialNumber"));
            autelRegProductInfo.setPicPath(jSONObject3.optString("picPath"));
            autelRegProductInfo.setProTypeName(jSONObject3.optString("proTypeName"));
            autelRegProductInfo.setDeviceAlias(jSONObject3.optString("deviceAlias"));
            autelRegProductInfo.setProCode(jSONObject3.optString("proCode"));
            arrayList.add(autelRegProductInfo);
        }
        iAutelQueryPersonalRegProductsListener.onSuccess(optInt, arrayList);
    }

    public void changeCustomerAutelRoboticsID(String str, String str2, String str3, final IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener) {
        if (iAutelChangeCustomerAutelRoboticsIDListener != null) {
            iAutelChangeCustomerAutelRoboticsIDListener.onStart();
        }
        String changeCustomerAutelRoboticsID = SignModel.changeCustomerAutelRoboticsID(str, str2, str3);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(changeCustomerAutelRoboticsID), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(changeCustomerAutelRoboticsID), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener = iAutelChangeCustomerAutelRoboticsIDListener;
                if (iAutelChangeCustomerAutelRoboticsIDListener != null) {
                    iAutelChangeCustomerAutelRoboticsIDListener.onStart();
                }
            }

            public void onSuccess(String str) {
                AutelLog.m15082d("AutelProductAircraftRequestManager", "changeCustomerAutelRoboticsID onSuccess:" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (1 == jSONObject.optInt("code")) {
                            IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener = iAutelChangeCustomerAutelRoboticsIDListener;
                            if (iAutelChangeCustomerAutelRoboticsIDListener != null) {
                                iAutelChangeCustomerAutelRoboticsIDListener.onSuccess();
                                return;
                            }
                            return;
                        }
                        IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener2 = iAutelChangeCustomerAutelRoboticsIDListener;
                        if (iAutelChangeCustomerAutelRoboticsIDListener2 != null) {
                            iAutelChangeCustomerAutelRoboticsIDListener2.onFailure(String.valueOf(jSONObject.optInt("code")));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener3 = iAutelChangeCustomerAutelRoboticsIDListener;
                        if (iAutelChangeCustomerAutelRoboticsIDListener3 != null) {
                            iAutelChangeCustomerAutelRoboticsIDListener3.onFailure((String) null);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener = iAutelChangeCustomerAutelRoboticsIDListener;
                if (iAutelChangeCustomerAutelRoboticsIDListener != null) {
                    iAutelChangeCustomerAutelRoboticsIDListener.onFailure((String) null);
                }
            }
        });
    }

    public void updateCustomerDeviceName(String str, String str2, String str3, final IAutelCommunityListener iAutelCommunityListener) {
        String createChangeCustomerDeviceName = SignModel.createChangeCustomerDeviceName(str, str2, str3);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(createChangeCustomerDeviceName), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(createChangeCustomerDeviceName), new ResponseCallBack<String>() {
            public void onStart() {
                super.onStart();
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String access$000 = AutelCommunityRequest.this.TAG;
                        AutelLog.m15089i(access$000, "updateCustomerDeviceName response:" + str);
                        if (1 == new JSONObject(str).optInt("code")) {
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                                return;
                            }
                            return;
                        }
                        IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                        if (iAutelCommunityListener2 != null) {
                            iAutelCommunityListener2.onFailure(AutelErrorReson.REQUEST_FAIL);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                        if (iAutelCommunityListener3 != null) {
                            iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_DATA_ERROR);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void requestUploadUserPhoto(AutelCommunityInfo autelCommunityInfo, InputStream inputStream, final IAutelCommunityListener iAutelCommunityListener) {
        String signString = SignModel.getSignString("autelId=" + autelCommunityInfo.getAutelId() + "&actCode=" + autelCommunityInfo.getActCode() + "&userCode=" + autelCommunityInfo.getCode());
        this.headers.put("Content-Type", HttpMediaType.MEDIA_TYPE_MULTI_FORM);
        Mutlipart mutlipart = new Mutlipart();
        mutlipart.setType(HttpMediaType.MEDIA_TYPE_MULTI_FORM);
        mutlipart.addPart("autelId", autelCommunityInfo.getAutelId());
        mutlipart.addPart("actCode", autelCommunityInfo.getActCode());
        mutlipart.addPart("userCode", autelCommunityInfo.getCode());
        mutlipart.addPart("_sign", signString);
        mutlipart.addPart("userfile", autelCommunityInfo.getImageName(), HttpMediaType.MEDIA_TYPE_STREAM, inputStream);
        this.okHttpManager.post(SignModel.getHttpUrlByActionName(SignModel.ACTION_UPLOADAVATAR), this.headers, mutlipart, new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onStart();
                }
            }

            public void onSuccess(String str) {
                AutelLog.m15082d(AutelLogTags.HTTP_COMMUNITY, "result: " + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("data"));
                        if ("ok".equals(jSONObject.optString(DownloadTask.STATUS))) {
                            AutelCommunityInfo.instance().setImageUrl(jSONObject.optString("avatar_url"));
                            IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                            if (iAutelCommunityListener != null) {
                                iAutelCommunityListener.onSuccess();
                                return;
                            }
                            return;
                        }
                        IAutelCommunityListener iAutelCommunityListener2 = iAutelCommunityListener;
                        if (iAutelCommunityListener2 != null) {
                            iAutelCommunityListener2.onFailure(AutelErrorReson.REQUEST_FAIL);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        IAutelCommunityListener iAutelCommunityListener3 = iAutelCommunityListener;
                        if (iAutelCommunityListener3 != null) {
                            iAutelCommunityListener3.onFailure(AutelErrorReson.REQUEST_FAIL);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                AutelLog.m15082d(AutelLogTags.HTTP_COMMUNITY, "onFailure: " + th.toString());
                IAutelCommunityListener iAutelCommunityListener = iAutelCommunityListener;
                if (iAutelCommunityListener != null) {
                    iAutelCommunityListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    private String parseErrMsg(JSONObject jSONObject) {
        return jSONObject.getJSONObject("data").optString("msg");
    }

    public void queryUserInfo(AutelCommunityInfo autelCommunityInfo, final IAutelCommunityLoginListener iAutelCommunityLoginListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("autelId", autelCommunityInfo.getAutelId());
        hashMap.put("usercode", autelCommunityInfo.getCode());
        String userInfo = SignModel.getUserInfo(hashMap);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(userInfo), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(userInfo), new ResponseCallBack<String>() {
            public void onStart() {
                IAutelCommunityLoginListener iAutelCommunityLoginListener = iAutelCommunityLoginListener;
                if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onStart();
                }
            }

            public void onSuccess(String str) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onSuccess:" + str);
                AutelCommunityRequest.this.dealLoginResult(str, iAutelCommunityLoginListener);
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "sendLoginRequest onFailure:" + th.toString());
                IAutelCommunityLoginListener iAutelCommunityLoginListener = iAutelCommunityLoginListener;
                if (iAutelCommunityLoginListener != null) {
                    iAutelCommunityLoginListener.onFailure(AutelErrorReson.REQUEST_NETWORK_FAILED);
                }
            }
        });
    }

    public void queryFlightRecordInfo(AutelCommunityInfo autelCommunityInfo, final CallbackWithOneParam<UserRecordInfo> callbackWithOneParam) {
        HashMap hashMap = new HashMap();
        hashMap.put("autelId", autelCommunityInfo.getAutelId());
        hashMap.put("actCode", autelCommunityInfo.getActCode());
        hashMap.put("userCode", autelCommunityInfo.getCode());
        String userRecordInfo = SignModel.getUserRecordInfo(hashMap);
        this.okHttpManager.post(CommunityFactory.buildAutelCommunityUrl(userRecordInfo), this.headers, AutelSystemUtils.CONTENT_TYPE, CommunityFactory.buildAutelCommunityBody(userRecordInfo), new ResponseCallBack<String>() {
            public void onStart() {
            }

            public void onSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        RecordResult recordResult = (RecordResult) AutelCommunityRequest.this.messageParser.getObject(str, RecordResult.class);
                        if (callbackWithOneParam != null) {
                            if (recordResult == null || recordResult.getCode() != 1) {
                                callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                            } else {
                                callbackWithOneParam.onSuccess(recordResult.getData().getUserRecordsInfo());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                        if (callbackWithOneParam != null) {
                            callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                        }
                    }
                    String access$000 = AutelCommunityRequest.this.TAG;
                    AutelLog.m15082d(access$000, "queryFlightRecordInfo onSuccess:" + str);
                }
            }

            public void onFailure(Throwable th) {
                String access$000 = AutelCommunityRequest.this.TAG;
                AutelLog.m15082d(access$000, "queryFlightRecordInfo onFailure:" + th.toString());
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                }
            }
        });
    }

    public void doFetchNoFlyZone(long j, final IAutelCommunityNoFlyZoneListener iAutelCommunityNoFlyZoneListener) {
        this.okHttpManager.get(SignModel.getNoFlyZoneUrl(j), (Headers) null, new ResponseCallBack<String>() {
            public void onSuccess(String str) {
                try {
                    BaseResult baseResult = (BaseResult) new Gson().fromJson(str, new TypeToken<BaseResult<NoFlyZoneResult>>() {
                    }.getType());
                    NoFlyZoneResult noFlyZoneResult = (NoFlyZoneResult) baseResult.getData();
                    if (baseResult.getCode() == 1) {
                        iAutelCommunityNoFlyZoneListener.onSuccess(noFlyZoneResult);
                    } else {
                        iAutelCommunityNoFlyZoneListener.onFailure(noFlyZoneResult.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(Throwable th) {
                iAutelCommunityNoFlyZoneListener.onFailure(th.getMessage());
            }
        });
    }
}
