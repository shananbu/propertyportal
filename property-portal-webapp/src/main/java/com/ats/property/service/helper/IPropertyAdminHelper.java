package com.ats.property.service.helper;

import com.ats.property.dto.*;
import com.ats.property.model.PlanMast;
import com.ats.property.model.PropertyUser;

import java.util.List;

/**
 * The PropertyAdminHelper.
 *
 * @author anbarasan.s
 */
public interface IPropertyAdminHelper {
    boolean authenticate(final String username, final String password, ModuleList response);
    boolean saveOrUpdateAdminUser(AdminUserType adminUser, ModuleList response);
    boolean getStatusFieldData(String targetForm, ModuleList response);
    boolean getUserList(String searchKey, ModuleList response);
    boolean getStateList(String searchKey, ModuleList response);
    boolean getCityList(String searchKey, ModuleList response);
    boolean getCityByStateId(String stateId, ModuleList response);
    boolean getLocationByCityId(String cityId, ModuleList response);

    boolean getLocationList(String searchKey, ModuleList response);
    boolean getAdvertisePlanList(String searchKey, ModuleList response,  boolean lineByLineBreak);
    boolean getAdvertisePlanListByUserType(String userType, ModuleList response, boolean lineByLineBreak);

    boolean saveOrUpdateCity(NameDataType cityData, ModuleList response);
    boolean saveOrUpdateLocation(NameDataType locationData, ModuleList response);
    boolean saveOrUpdatePlan(PlanType planType, ModuleList response);
    boolean saveOrUpdateAdvertisement(AdvertisementType advertisement, ModuleList response);
    boolean updateAdvertisement(AdvertisementType advertisementType,  ModuleList response);

    boolean getUserType(ModuleList response);

    boolean saveOrUpdateUser(PropertyUserType userType, ModuleList response);
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

    boolean searchProperty(SearchType searchType, ModuleList response);
    boolean getAmenitiesCategory(ModuleList response);

    boolean saveAlert(AlertRegistrationType alertType, ModuleList response);

    boolean getImageTypeList(ModuleList response);

    boolean getAdvertisementById(String advertisementId, ModuleList response);

    boolean getAdvertisements(ModuleList response);

    boolean getAdvertisementsForApproval(String status, ModuleList response);

    boolean approveOrRejectAdvertisements(List<AdvertisementType> advertisements,  ModuleList response);

    boolean getBudgetsByPropertyForType(ModuleList response, Long propertyForTypeId);

    boolean getAdvertisementsByUser(ModuleList response);

    boolean getPropertyUser(ModuleList response);

    boolean getPlanById(Long planId, ModuleList response);

    int getRemainingImageCount(Long advertisementId);

    boolean showClientReportView(String fromDate, String toDate, ModuleList response);

    boolean getAdvertisementsByType(boolean isMicroSite, ModuleList response);

    boolean sendPasswordRecoveryMail(PropertyUserType userType, ModuleList response);

    boolean resetPassword(String token, String password, ModuleList response);

    boolean sendContactUsMail(ContactUsType contactUsType, ModuleList response);

    boolean deleteUploadFile(String fileName, Long advertisementId, Long imageId, ModuleList response);

}
