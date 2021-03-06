package com.ats.property.service.delegate;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.common.constants.PropertyConstants;
import com.ats.property.common.constants.ResponseMessage;
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
    public boolean saveOrUpdateAdvertisement(ModuleRequestType moduleRequest, ModuleList response) {
        AdvertisementType advertisement = null;
        if(fromNullable(moduleRequest).isPresent()) {
            advertisement = moduleRequest.getAdvertisement();
        }
        return adminHelper.saveOrUpdateAdvertisement(advertisement, response);
    }

    @Override
    public boolean updateAdvertisement(ModuleRequestType moduleRequest, ModuleList response) {
        AdvertisementType advertisement = null;
        if(fromNullable(moduleRequest).isPresent()) {
            advertisement = moduleRequest.getAdvertisement();
        }
        return adminHelper.updateAdvertisement(advertisement, response);
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
    public boolean getBudgetsByPropertyForType(ModuleList response, Long propertyForTypeId) {
        return adminHelper.getBudgetsByPropertyForType(response, propertyForTypeId);
    }

    @Override
    public boolean getAdvertisementsByUser(ModuleList response) {
        return adminHelper.getAdvertisementsByUser(response);
    }

    @Override
    public boolean getPropertyUser(ModuleList response) {
        return adminHelper.getPropertyUser(response);
    }

    @Override
    public boolean getPlanById(Long planId, ModuleList response) {
        return adminHelper.getPlanById(planId, response);
    }

    @Override
    public int getRemainingImageCount(Long advertisementId) {
        return adminHelper.getRemainingImageCount(advertisementId);
    }

    @Override
    public boolean showClientReportView(String fromDate, String toDate, ModuleList response) {
        return adminHelper.showClientReportView(fromDate, toDate, response);
    }

    @Override
    public boolean getAdvertisementsByType(boolean isMicroSite, ModuleList response) {
        return adminHelper.getAdvertisementsByType(isMicroSite, response);
    }

    @Override
    public boolean sendPasswordRecoveryMail(ModuleRequestType moduleRequest, ModuleList response) {
        PropertyUserType user = null;
        if(fromNullable(moduleRequest).isPresent()) {
            user = moduleRequest.getPropertyUser();
        }
        return adminHelper.sendPasswordRecoveryMail(user, response);
    }

    @Override
    public boolean resetPassword(String token, String password, ModuleList response) {
        if(token == null) {
            response.getMessages().get(0).setCode(ResponseMessage.INVALID_REQUEST.code());
            response.getMessages().get(0).setMessage(ResponseMessage.INVALID_REQUEST.message());
            return true;
        }
        return adminHelper.resetPassword(token, password, response);
    }

    @Override
    public boolean sendContactUsMail(ModuleRequestType moduleRequest, ModuleList response) {
        ContactUsType contactUsType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            contactUsType = moduleRequest.getContactUs();
        }
        return adminHelper.sendContactUsMail(contactUsType, response);
    }

    @Override
    public boolean deleteUploadFile(String fileName, Long advertisementId, Long imageId, ModuleList response) {
        return adminHelper.deleteUploadFile(fileName, advertisementId, imageId, response);

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
    public boolean getPossessionOrAgeList(Long availabilityId, ModuleList response) {
        return adminHelper.getPossessionOrAgeList(availabilityId, response);
    }

    @Override
    public boolean getTermsList(ModuleList response) {
        return adminHelper.getTermsList(response);
    }

    @Override
    public boolean searchProperty(ModuleRequestType moduleRequest, ModuleList response) {

        SearchType searchType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            searchType = moduleRequest.getSearch();
        }
        return adminHelper.searchProperty(searchType, response);
    }

    @Override
    public boolean getAmenitiesCategory(ModuleList response) {
        return adminHelper.getAmenitiesCategory(response);
    }

    @Override
    public boolean saveAlert(ModuleRequestType moduleRequest, ModuleList response) {
        AlertRegistrationType alertRegistrationType = null;
        if(fromNullable(moduleRequest).isPresent()) {
            alertRegistrationType = moduleRequest.getAlertRegistration();
        }
        if(adminHelper.saveAlert(alertRegistrationType, response) == true) {
            response.getMessages().get(0).setCode(ResponseMessage.SUCCESSFUL_RESPONSE.code());
            response.getMessages().get(0).setMessage("Alert Registration completed Successfully.");
        } else {
            response.getMessages().get(0).setCode(ResponseMessage.UNEXPECTED_ERROR.code());
            response.getMessages().get(0).setMessage("Alert Registration failed. Please try again.");
        }
        return true;
    }

    @Override
    public boolean getImageTypeList(ModuleList response) {
        return adminHelper.getImageTypeList(response);
    }

    @Override
    public boolean getAdvertisementById(String advertisementId, ModuleList response) {
        return adminHelper.getAdvertisementById(advertisementId, response);
    }

    @Override
    public boolean getAdvertisements(ModuleList response) {
        return adminHelper.getAdvertisements(response);
    }

    @Override
    public boolean getAdvertisementsForApproval(String status, ModuleList response) {
        return adminHelper.getAdvertisementsForApproval(status, response);
    }

    @Override
    public boolean approveOrRejectAdvertisements(ModuleRequestType moduleRequest, ModuleList response) {
        return adminHelper.approveOrRejectAdvertisements(moduleRequest.getAdvertisements(), response);
    }
}
