package com.ats.property.service;

import com.ats.property.dto.*;
import com.ats.property.model.*;
import com.ats.property.model.Advertisement;

import java.util.List;

/**
 * The PropertyAdminService.
 *
 * @author anbarasan.s
 */
public interface IPropertyAdminService {
    Long ONE_LAKH = 100000L;
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
    AdvertisementType saveOrUpdateAdvertisement(Advertisement advertisement, AdvertisementDetails advertisementDetails,
                                                Residential residential, List<PropertyAmenities> amenitieses, List<MorePropertyDetails> moreProperties);
    AdvertisementType updateAdvertisement(AdvertisementType advertisementType);
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
    boolean getPossessionOrAgeList(ModuleList response);
    boolean getTermsList(ModuleList response);

    boolean searchProperty(SearchType searchType, ModuleList response);
    boolean getAmenitiesCategory(ModuleList response);

    PropertyRequirement saveAlert(PropertyRequirement requirement, AlertRegistrationType alertType);

    boolean getImageTypeList(ModuleList response);

    boolean getAdvertisementById(String advertisementId, ModuleList response);

    boolean getAdvertisements(ModuleList response);

}
