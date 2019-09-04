package com.gwtt.ems.cmnb.southInterface.ems;


import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.nms.security.authorization.AuthObserverImpl;
import com.gwtt.nms.util.NmsUtil;
import com.gwtt.security.authorization.AuthorizationEngineExt;
import com.gwtt.security.authorization.AuthorizationException;
import com.gwtt.security.authorization.CustomViewScopeAPI;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * DA 权限配置
 *
 */
public class CmnbEmsAuthHelper {

    private AuthObserverImpl authObserverApi = null;
    private AuthorizationEngineExt authEngineApi = null;
    private CustomViewScopeAPI authAdmin = null;

    private CmnbEmsAuthHelper() {
        try {
            authObserverApi = AuthObserverImpl.getInstance();
            authEngineApi = (AuthorizationEngineExt) NmsUtil.getAPI("NmsAuthEngineAPI");
            authAdmin = (CustomViewScopeAPI) NmsUtil.getAPI("NmsAuthAdminAPI");

        } catch (Exception ex) {

            CmnbLogger.CMNBERR.logException(ex, 3);
        }
    }
    private static CmnbEmsAuthHelper instance;

    public static CmnbEmsAuthHelper getInstance() {
        if (null == instance) {
            instance = new CmnbEmsAuthHelper();
        }
        return instance;
    }

    /**
     * 判断指定的用户对指定的MO对象是否可见. 业务用户在分权分域中实现的不完善，暂不实现 操作的分权分域，是针对配置,由于rest目前是查询，暂不支持
     *
     * @param username String
     * @param objname String
     * @return boolean
     */
    public boolean isCriteriaMatch(String username, String objname) {

        boolean result = true;
        try {
            if (authObserverApi == null) {
                authObserverApi = (AuthObserverImpl) AuthObserverImpl.getInstance();
            }
            if (((AuthObserverImpl) authObserverApi).isScopeExists(username, "Maps")) {
                Properties p = new Properties();
                p.put("name", objname);
                result = ((AuthObserverImpl) authObserverApi).isCriteriaMatch(username, "Maps", p);
            }
        } catch (Exception e) {
            CmnbLogger.CMNBERR.logException(e, 3);
        }
        return result;
    }

    public Set<String> getAllUsers() {
        HashSet<String> set = new HashSet<String>();
        try {
            for (Object o : authAdmin.getAllUserNames()) {
                CmnbLogger.CMNBOUT.log("RestEmsAuthHelper.getAllUsers " + o.toString(), 3);
                set.add(String.valueOf(o));
            }
        } catch (RemoteException ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        } catch (AuthorizationException ex) {
            CmnbLogger.CMNBERR.logException(ex, 3);
        }
        return set;
    }
}
