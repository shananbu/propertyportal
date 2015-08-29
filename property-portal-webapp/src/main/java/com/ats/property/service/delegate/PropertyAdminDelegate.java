package com.ats.property.service.delegate;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.common.constants.PropertyConstants;
import com.ats.property.dto.*;
import com.ats.property.service.IPropertyAdminService;
import com.ats.property.service.helper.IPropertyAdminHelper;
import com.google.common.base.Optional;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static com.google.common.base.Optional.fromNullable;

/**
 * The PropertyAdminDelegate.
 *
 * @author anbarasan.s
 */
public class PropertyAdminDelegate implements IPropertyAdminDelegate, InitializingBean {

    @Autowired
    private IPropertyAdminHelper adminHelper;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(adminHelper, "adminHelper must be non-null");
    }

    @Override
    public boolean authenticate(ModuleRequestType moduleRequest, ModuleList response) {

        if(fromNullable(moduleRequest).isPresent()) {
            if(fromNullable(moduleRequest.getStandardAuth()).isPresent()) {
                String userName = moduleRequest.getStandardAuth().getUsername();
                String password = moduleRequest.getStandardAuth().getPassword();
                return adminHelper.authenticate(userName, password, response);
            }
        }
        return false ;
    }

    @Override
    public boolean saveOrUpdateAdminUser(ModuleRequestType moduleRequest, ModuleList response) {
        AdminUserType adminUserType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            adminUserType = moduleRequest.getAdminUser();
        }
        return adminHelper.saveOrUpdateAdminUser(adminUserType, response);
    }

    @Override
    public boolean getStatusFieldData(ModuleList response) {
        return adminHelper.getStatusFieldData(PropertyConstants.USER.toString(), response);
    }

    @Override
    public boolean getUserList(String searchKey, ModuleList response) {
        return adminHelper.getUserList(searchKey, response);
    }

    @Override
    public boolean getStateList(String searchKey, ModuleList response) {
        return adminHelper.getStateList(searchKey, response);
    }

    @Override
    public boolean getCityList(String searchKey, ModuleList response) {
        return adminHelper.getCityList(searchKey, response);
    }

    @Override
    public boolean getCityByStateId(String stateId, ModuleList response) {
        return adminHelper.getCityByStateId(stateId, response);
    }

    @Override
    public boolean getLocationByCityId(String cityId, ModuleList response) {
        return adminHelper.getLocationByCityId(cityId, response);
    }

    @Override
    public boolean getLocationList(String searchKey, ModuleList response) {
        return adminHelper.getLocationList(searchKey, response);
    }

    @Override
    public boolean getAdvertisePlanList(String searchKey, ModuleList response,  boolean lineByLineBreak) {
        return adminHelper.getAdvertisePlanList(searchKey, response, lineByLineBreak);
    }

    @Override
    public boolean getAdvertisePlanListByUserType(String userType, ModuleList response, boolean lineByLineBreak) {
        return adminHelper.getAdvertisePlanListByUserType(userType, response, lineByLineBreak);
    }


    @Override
    public boolean saveOrUpdateCity(ModuleRequestType moduleRequest, ModuleList response) {
        NameDataType cityType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            cityType = moduleRequest.getCity();
        }
        return adminHelper.saveOrUpdateCity(cityType, response);
    }

    @Override
    public boolean saveOrUpdateLocation(ModuleRequestType moduleRequest, ModuleList response) {
        NameDataType localityType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            localityType = moduleRequest.getLocation();
        }
        return adminHelper.saveOrUpdateLocation(localityType, response);
    }

    @Override
    public boolean getUserType(ModuleList response) {
        return adminHelper.getUserType(response);
    }

    @Override
    public boolean saveOrUpdatePlan(ModuleRequestType moduleRequest, ModuleList response) {
        PlanType planType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            planType = moduleRequest.getPlan();
        }
        return adminHelper.saveOrUpdatePlan(planType, response);
    }

    @Override
    public boolean saveOrUpdateUser(ModuleRequestType moduleRequest, ModuleList response) {
        PropertyUserType user = null;
        if(fromNullable(moduleRequest).isPresent()) {
            user = moduleRequest.getPropertyUser();
        }
        return adminHelper.saveOrUpdateUser(user, response);

    }

    @Override
    public boolean activateAccount(String userMail, String userId) {
        if(fromNullable(userMail).isPresent() && fromNullable(userId).isPresent()) {
            adminHelper.activateAccount(userMail, userId);
        }
        return true;
    }

    @Override
    public boolean getPropertyTypeList(ModuleList response) {
        return adminHelper.getPropertyTypeList(response);
    }

    @Override
    public boolean getBudgetList(ModuleList response) {
        return adminHelper.getBudgetList(response);
    }

    @Override
    public boolean getBedroomsList(ModuleList response) {
        return adminHelper.getBedroomsList(response);
    }

    @Override
    public boolean getPropertyForTypeList(ModuleList response) {
        return adminHelper.getPropertyForTypeList(response);
    }

    @Override
    public boolean getFurnishedStatusList(ModuleList response) {
        return adminHelper.getFurnishedStatusList(response);
    }

    @Override
    public boolean getBathroomsList(ModuleList response) {
        return adminHelper.getBathroomsList(response);
    }

    @Override
    public boolean getBalconiesList(ModuleList response) {
        return adminHelper.getBalconiesList(response);
    }

    @Override
    public boolean getTotalFloorsList(ModuleList response) {
        return adminHelper.getTotalFloorsList(response);
    }

    @Override
    public boolean getUnitsList(ModuleList response) {
        return adminHelper.getUnitsList(response);
    }

    @Override
    public boolean getTransactionTypesList(ModuleList response) {
        return adminHelper.getTransactionTypesList(response);
    }

    @Override
    public boolean getPossessionStatusList(ModuleList response) {
        return adminHelper.getPossessionStatusList(response);
    }

    @Override
    public boolean getTermsList(ModuleList response) {
        return adminHelper.getTermsList(response);
    }
}
