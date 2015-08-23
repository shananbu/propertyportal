package com.ats.property.common;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The CommonServiceHelper.
 *
 * @author anbarasan.s
 */
public class CommonServiceHelper extends CommonHelper {

    static ObjectFactory objectFactory= null;

    static {
        objectFactory = new ObjectFactory();
    }

    public static <T> ModuleList getModuleListWithData(T data) {
        ModuleType moduleType = objectFactory.createModuleType();
        ModuleList moduleList = objectFactory.createModuleList();
        ModuleResponseType responseType = objectFactory.createModuleResponseType();
        if(data != null ) {
            if (data instanceof AuthenticationResponseType) {
                responseType.setAuthenticationData((AuthenticationResponseType) data);
            }
            if (data instanceof List<?>) {
                if (((List) data).size() > 0 && ((List) data).get(0) instanceof CountryType) {
                    responseType.getCountryData().addAll((List<CountryType>) data);
                }
            }
        }
        moduleType.setModuleResponse(responseType);
        moduleList.getModule().add(moduleType);
        moduleList.getMessages().add(getSuccessMessage());
        return moduleList;
    }
}
