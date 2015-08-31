package com.ats.property.service;

import com.ats.property.dto.*;
import com.ats.property.model.*;
import com.ats.property.model.Advertisement;

/**
 * The PropertyAdminService.
 *
 * @author anbarasan.s
 */
public interface IPropertyAdminService {
    void getCountry();
    AdminLogin getAdminUser(String userName, String password);
    AdminUserType saveOrUpdateAdminUser(AdminLogin adminUser);
    boolean getStatusFieldData(String targetForm, ModuleList response);
    boolean getUserList(String searchKey, ModuleList response);
    boolean getStateList(String searchKey, ModuleList response);
    boolean getCityList(String searchKey, ModuleList response);
    boolean getCityByStateId(String stateId, ModuleList response);
    boolean getLocationByCityId(String cityId, ModuleList response);

    boolean getLocationList(String searchKey, ModuleList response);
    boolean getAdvertisePlanList(String searchKey, ModuleList response,  boolean lineByLineDesc);

    NameDataType saveOrUpdateCity(City city);
    NameDataType saveOrUpdateLocation(Locations location);

    boolean getUserType(ModuleList response);

    PlanType saveOrUpdatePlan(PlanMast planMast);
    AdvertisementType saveOrUpdateAdvertisement(Advertisement advertisement);
    PropertyUserType saveOrUpdateUser(PropertyUser user);
    PropertyUserType activateAccount(PropertyUser user);

    boolean getPropertyTypeList(ModuleList response);
    boolean getBudgetList(ModuleList response);
    boolean getBedroomsList(ModuleList response);

    boolean getPropertyForTypeList(ModuleList response);
    boolean getFurnishedStatusList(ModuleList response);
    boolean getBathroomsList(ModuleList response);
    boolean getBalconiesList(ModuleList response);
    boolean getTotalFloorsList(ModuleList response);
    boolean getUnitsList(ModuleList response);
    boolean getTransactionTypesList(ModuleList response);
    boolean getPossessionStatusList(ModuleList response);
    boolean getTermsList(ModuleList response);

}
