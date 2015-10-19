package com.ats.property.service.delegate;

import com.ats.property.dto.ModuleList;
import com.ats.property.dto.ModuleRequestType;

/**
 * The PropertyAdminDelegate.
 *
 * @author anbarasan.s
 */
public interface IPropertyAdminDelegate {
    boolean authenticate(ModuleRequestType moduleRequest, ModuleList response);
    boolean saveOrUpdateAdminUser(ModuleRequestType moduleRequest, ModuleList response);
    boolean getStatusFieldData(ModuleList response);
    boolean getUserList(String searchKey, ModuleList response);
    boolean getStateList(String searchKey, ModuleList response);
    boolean getCityList(String searchKey, ModuleList response);
    boolean getCityByStateId(String stateId, ModuleList response);
    boolean getLocationByCityId(String cityId, ModuleList response);

    boolean getLocationList(String searchKey, ModuleList response);
    boolean getAdvertisePlanList(String searchKey, ModuleList response,  boolean lineByLineBreak);
    boolean getAdvertisePlanListByUserType(String userType, ModuleList response,  boolean lineByLineBreak);
    boolean saveOrUpdateCity(ModuleRequestType moduleRequest, ModuleList response);
    boolean saveOrUpdateLocation(ModuleRequestType moduleRequest, ModuleList response);
    boolean getUserType(ModuleList response);
    boolean saveOrUpdatePlan(ModuleRequestType moduleRequest, ModuleList response);
    boolean saveOrUpdateAdvertisement(ModuleRequestType moduleRequest, ModuleList response);
    boolean updateAdvertisement(ModuleRequestType moduleRequest, ModuleList response);

    boolean saveOrUpdateUser(ModuleRequestType moduleRequest, ModuleList response);
    boolean activateAccount(String userMail, String userId);

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
    boolean getPossessionOrAgeList(Long availabilityId, ModuleList response);
    boolean getTermsList(ModuleList response);

    boolean searchProperty(ModuleRequestType moduleRequest, ModuleList response);
    boolean getAmenitiesCategory(ModuleList response);

    boolean saveAlert(ModuleRequestType moduleRequest, ModuleList response);

    boolean getImageTypeList(ModuleList response);

    boolean getAdvertisementById(String advertisementId, ModuleList response);

    boolean getAdvertisements(ModuleList response);

    boolean getAdvertisementsForApproval(String status, ModuleList response);

}
