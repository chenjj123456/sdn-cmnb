package com.gwtt.ems.cmnb.southInterface.ems;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.south.EmsConfigResult;
import com.gwtt.ems.cmnb.model.south.resources.LtpData;
import com.gwtt.ems.cmnb.model.south.resources.MeLocationData;
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
        //用于测试
        result=new NeDataList();
        List<NeData> neDataList=new ArrayList<>();

        NeData neData=new NeData();
        neData.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427b");
        neData.setAdminIp("192.168.10.95");
        neData.setAdminStatus(AdminStatus.AdminUp);
        neData.setVendorName("GWTT");
        LtpData ltpData=new LtpData();
        ltpData.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427d");
        ltpData.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427b");
        ltpData.setLayerRate(1L);
        ltpData.setMtu("1000");

        LtpData ltpData1=new LtpData();
        ltpData1.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427e");
        ltpData1.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427b");
        ltpData1.setLayerRate(1L);
        ltpData1.setMtu("2000");
        List<LtpData> ltpDataList=new ArrayList<>();
        ltpDataList.add(ltpData);
        ltpDataList.add(ltpData1);
        neData.setLtpDataList(ltpDataList);

        NeData neData1=new NeData();
        neData1.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427c");
        neData1.setAdminIp("192.168.10.95");
        neData1.setAdminStatus(AdminStatus.AdminDown);
        neData1.setVendorName("GWTT");

        LtpData ltpData2=new LtpData();
        ltpData2.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427f");
        ltpData2.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427c");
        ltpData2.setLayerRate(1L);
        ltpData2.setMtu("1000");

        LtpData ltpData3=new LtpData();
        ltpData3.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427g");
        ltpData3.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427c");
        ltpData3.setLayerRate(1L);
        ltpData3.setMtu("2000");
        List<LtpData> ltpDataList1=new ArrayList<>();
        ltpDataList1.add(ltpData2);
        ltpDataList1.add(ltpData3);
        neData1.setLtpDataList(ltpDataList1);


        neDataList.add(neData);
        neDataList.add(neData1);
        result.setNeDataList(neDataList);
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

        //用于测试
        result=new NeData();
        result.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427b");
        result.setAdminIp("192.168.10.95");
        result.setAdminStatus(AdminStatus.AdminUp);
        result.setVendorName("GWTT");
        LtpData ltpData=new LtpData();
        ltpData.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427d");
        ltpData.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427b");
        ltpData.setLayerRate(1L);
        ltpData.setMtu("1000");

        LtpData ltpData1=new LtpData();
        ltpData1.setUuid("0d1cfe72-015e-1000-0000-1c3947d8427e");
        ltpData1.setNeId("0d1cfe72-015e-1000-0000-1c3947d8427b");
        ltpData1.setLayerRate(1L);
        ltpData1.setMtu("2000");
        List<LtpData> ltpDataList=new ArrayList<>();
        ltpDataList.add(ltpData);
        ltpDataList.add(ltpData1);
        result.setLtpDataList(ltpDataList);
        return result;
    }

    public EmsConfigResult addMeLocation(List<MeLocationData> meLocationDataList){
        EmsConfigResult result=null;
        if (cmnbEmsApis != null) {
            for (CmnbEmsAPI api : cmnbEmsApis) {
                try {
                    result = api.addMeLocation(meLocationDataList);
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
