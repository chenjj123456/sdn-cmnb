package com.gwtt.ems.cmnb.southInterface.ems;

import com.gwtt.ems.cmnb.model.south.resources.LtpDataList;
import com.gwtt.ems.cmnb.model.south.resources.NeData;
import com.gwtt.ems.cmnb.model.south.resources.NeDataList;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventObserver;
import com.gwtt.ems.cmnb.util.CmnbLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by chenjj on 2019/9/1
 */
public class CmnbEmsHelper {
    private static CmnbEmsHelper instance;
    private List<CmnbEmsAPI> cmnbEmsApis = new ArrayList<>();

    private CmnbEmsHelper() {
        try {
            ClassLoader loader = CmnbEmsAPI.class.getClassLoader();
            CmnbLogger.CMNBOUT.log("loader:" + loader, 3);
            ServiceLoader<CmnbEmsAPI> serviceLoader = ServiceLoader.load(CmnbEmsAPI.class, loader);
            CmnbLogger.CMNBOUT.log("serviceLoader:" + loader, 3);
            for (CmnbEmsAPI api : serviceLoader) {
                CmnbLogger.CMNBOUT.log("loader api:" + api, 3);
                cmnbEmsApis.add(api);
            }

        } catch (Exception ex) {

            CmnbLogger.CMNBERR.logException(ex, 3);
        }


    }

    public static synchronized CmnbEmsHelper getInstance() {
        if (instance == null) {
            instance = new CmnbEmsHelper();
        }
        return instance;
    }

    public void start() {
        if (cmnbEmsApis != null) {
            //模块发给REST的事件
            for (CmnbEmsAPI api : cmnbEmsApis) {
                try {
                    api.addListener(CmnbEventObserver.getInstance());
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }

    }

    public void shutdown() {
        if (cmnbEmsApis != null) {
            //模块发给REST的事件
            for (CmnbEmsAPI api : cmnbEmsApis) {
                api.shutdown(CmnbEventObserver.getInstance());
            }
        }
    }

    public NeDataList getNes() {
        NeDataList result = null;

        if (cmnbEmsApis != null) {
            for (CmnbEmsAPI api : cmnbEmsApis) {
                try {
                    result = api.getNes();
                    //查询到一个结果后退出
                    if (result != null && result.getNeDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public LtpDataList getLtpsByNeId(String neId) {
        LtpDataList result = null;

        if (cmnbEmsApis != null) {
            for (CmnbEmsAPI api : cmnbEmsApis) {
                try {
                    result = api.getLtpsByNeId(neId);
                    //查询到一个结果后退出
                    if (result != null && result.getLtpDataList().size() > 0) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }

    public NeData getNeById(String neId) {
        NeData result = null;

        if (cmnbEmsApis != null) {
            for (CmnbEmsAPI api : cmnbEmsApis) {
                try {
                    result = api.getNeById(neId);
                    //查询到一个结果后退出
                    if (result != null) {
                        break;
                    }
                } catch (Exception ex) {
                    CmnbLogger.CMNBERR.log(api.getClass().getName(), 3);
                    CmnbLogger.CMNBERR.logException(ex, 3);
                }
            }
        }
        return result;
    }
}
