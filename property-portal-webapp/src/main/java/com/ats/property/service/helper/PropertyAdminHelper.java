package com.ats.property.service.helper;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.common.constants.PropertyUtils;
import com.ats.property.common.constants.ResponseMessage;
import com.ats.property.dto.*;
import com.ats.property.model.*;
import com.ats.property.service.IPropertyAdminService;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The PropertyAdminHelper.
 *
 * @author anbarasan.s
 */
public class PropertyAdminHelper implements IPropertyAdminHelper, InitializingBean {

    @Autowired
    private IPropertyAdminService adminService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(adminService, "adminService must be non-null");
    }

    @Override
    public boolean authenticate(final String username, final String password, ModuleList response) {
        AdminLogin adminlogin = adminService.getAdminUser(username, password);
        MessageType message = null;
        boolean status = false;
        if (!Optional.fromNullable(adminlogin).isPresent()) {
            message = CommonHelper.getMessage(ResponseMessage.INVALID_CREDENTIALS);
        } else {
            message = CommonHelper.getMessage(ResponseMessage.SUCCESSFUL_RESPONSE);
            status = true;
        }
        response.getMessages().add(message);
        return status;
    }

    @Override
    public boolean saveOrUpdateAdminUser(AdminUserType adminUser, ModuleList response) {
        AdminLogin adminlogin = new AdminLogin();
        adminlogin.setFirstName(adminUser.getFirstName());
        adminlogin.setDesignation(adminUser.getDesignation());

        adminlogin.setId(adminUser.getId());
        adminlogin.setMailId(adminUser.getMailId());
        adminlogin.setPhoneNumber(adminUser.getPhoneNumber());
        adminlogin.setStatusId(adminUser.getStatus());
        adminlogin.setUserName(adminUser.getUserName());
        adminlogin.setPassword(adminUser.getPassword());
        adminlogin.setDoj(Timestamp.valueOf(adminUser.getDoj() + " 00:00:00"));
        adminlogin.setDor(Timestamp.valueOf(adminUser.getDor() + " 00:00:00"));
        AdminUserType userType = adminService.saveOrUpdateAdminUser(adminlogin);
        boolean status = false;
        MessageType message = CommonHelper.getMessage(ResponseMessage.INVALID_CREDENTIALS);
        if (Optional.fromNullable(userType).isPresent()) {
            status = true;
            message = CommonHelper.getMessage(ResponseMessage.SUCCESSFUL_RESPONSE);
        }
        response.getMessages().add(message);
        return status;
    }

    @Override
    public boolean getStatusFieldData(String targetForm, ModuleList response) {
        return adminService.getStatusFieldData(targetForm, response);
    }

    @Override
    public boolean getUserList(String searchKey, ModuleList response) {
        return adminService.getUserList(searchKey, response);
    }

    @Override
    public boolean getStateList(String searchKey, ModuleList response) {
        return adminService.getStateList(searchKey, response);
    }

    @Override
    public boolean getCityList(String searchKey, ModuleList response) {
        return adminService.getCityList(searchKey, response);
    }

    @Override
    public boolean getCityByStateId(String stateId, ModuleList response) {
        return adminService.getCityByStateId(stateId, response);
    }

    @Override
    public boolean getLocationByCityId(String cityId, ModuleList response) {
        return adminService.getLocationByCityId(cityId, response);
    }

    @Override
    public boolean getLocationList(String searchKey, ModuleList response) {
        return adminService.getLocationList(searchKey, response);
    }

    @Override
    public boolean getAdvertisePlanList(String searchKey, ModuleList response, boolean lineByLineBreak) {
        return adminService.getAdvertisePlanList(searchKey, response, lineByLineBreak);
    }

    @Override
    public boolean getAdvertisePlanListByUserType(final String userType, ModuleList response, boolean lineByLineBreak) {
        boolean status = adminService.getAdvertisePlanList(null, response, lineByLineBreak);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(userType != null) {
            List<PlanType> filteredPlans = Lists.newArrayList(Collections2.filter(moduleResponseType.getPlans(), new Predicate<PlanType>() {
                        @Override
                        public boolean apply(PlanType input) {
                            return input.getUserTypeName().toLowerCase().contains(userType.toLowerCase());
                        }
                    }
            ));
            moduleResponseType.getPlans().clear();
            moduleResponseType.getPlans().addAll(filteredPlans);
        }
        return status;
    }

    @Override
    public boolean saveOrUpdateCity(NameDataType cityData, ModuleList response) {
        City city = new City();
        city.setId(cityData.getId());
        city.setName(cityData.getName());
        if(cityData.getParentId() != -1) {
            city.setStateId(cityData.getParentId());
        }
        city.setIsPopular(cityData.getIsPopular());
        adminService.saveOrUpdateCity(city);
        return true;
    }

    @Override
    public boolean saveOrUpdateLocation(NameDataType locationData, ModuleList response) {
        Locations location = new Locations();
        location.setName(locationData.getName());
        location.setId(locationData.getId());
        if(locationData.getParentId() != -1) {
            location.setCityId(locationData.getParentId());
        }
        adminService.saveOrUpdateLocation(location);
        return true;
    }

    @Override
    public boolean saveOrUpdatePlan(PlanType planType, ModuleList response) {
        PlanMast planMast = new PlanMast();
        PropertyUtils.copyFields(planType, planMast);
        adminService.saveOrUpdatePlan(planMast);
        return true;
    }

    @Override
    public boolean saveOrUpdateAdvertisement(AdvertisementType advertisementType, ModuleList response) {
        Advertisement advertisement = new Advertisement();
        Residential residential = new Residential();
        AdvertisementDetails advertisementDetails = new AdvertisementDetails();
        PropertyUtils.copyFields(advertisementType, advertisement);
        PropertyUtils.copyFields(advertisementType, residential);
        PropertyUtils.copyFields(advertisementType, advertisementDetails);
        residential.setAdvertisementByAdvertisementId(advertisement);
        advertisementDetails.setAdvertisementByAdvertisementId(advertisement);

        List<PropertyAmenities> amenitieses = new ArrayList<PropertyAmenities>();
        if(advertisementType.getPropertyAmenities() != null) {
            String[] amenities = advertisementType.getPropertyAmenities().split(",");
            for(String amenity: amenities) {
                if(amenity != null) {
                    PropertyAmenities amenityDB = new PropertyAmenities();
                    amenityDB.setAmenitiesId(Long.parseLong(amenity));
                    amenitieses.add(amenityDB);
                }
            }
        }
        AdvertisementType resAdvertisementType = adminService.saveOrUpdateAdvertisement(advertisement, advertisementDetails, residential, amenitieses);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        moduleResponseType.setAdvertisement(resAdvertisementType);
        return true;
    }

    @Override
    public boolean updateAdvertisement(AdvertisementType advertisementType, ModuleList response) {
       adminService.updateAdvertisement(advertisementType);
        return true;
    }

    @Override
    public boolean getUserType(ModuleList response) {
        return adminService.getUserType(response);
    }

    @Override
    public boolean saveOrUpdateUser(PropertyUserType userType, ModuleList response) {
        PropertyUser user = new PropertyUser();
        PropertyUtils.copyFields(userType, user);
        adminService.saveOrUpdateUser(user);
        return true;
    }

    @Override
    public boolean activateAccount(String userMail, String userId) {
        PropertyUser user = new PropertyUser();
        user.setEmailId(userMail);
        user.setId(Long.valueOf(userId));
        adminService.activateAccount(user);
        return true;
    }

    @Override
    public boolean getPropertyTypeList(ModuleList response) {
        return   adminService.getPropertyTypeList(response);
    }

    @Override
    public boolean getBudgetList(ModuleList response) {
        return adminService.getBudgetList(response);
    }

    @Override
    public boolean getBedroomsList(ModuleList response) {
        return adminService.getBedroomsList(response);
    }

    @Override
    public boolean getPropertyForTypeList(ModuleList response) {
        return adminService.getPropertyForTypeList(response);
    }

    @Override
    public boolean getFurnishedStatusList(ModuleList response) {
        return adminService.getFurnishedStatusList(response);
    }

    @Override
    public boolean getBathroomsList(ModuleList response) {
        return adminService.getBathroomsList(response);
    }

    @Override
    public boolean getBalconiesList(ModuleList response) {
        return adminService.getBalconiesList(response);
    }

    @Override
    public boolean getTotalFloorsList(ModuleList response) {
        return adminService.getTotalFloorsList(response);
    }

    @Override
    public boolean getUnitsList(ModuleList response) {
        return adminService.getUnitsList(response);
    }

    @Override
    public boolean getTransactionTypesList(ModuleList response) {
        return adminService.getTransactionTypesList(response);
    }

    @Override
    public boolean getPossessionStatusList(ModuleList response) {
        return adminService.getPossessionStatusList(response);
    }

    @Override
    public boolean getTermsList(ModuleList response) {
        return adminService.getTermsList(response);
    }

    @Override
    public boolean searchProperty(SearchType searchType, ModuleList response) {
        return adminService.searchProperty(searchType, response);
    }

    @Override
    public boolean getAmenitiesCategory(ModuleList response) {
        return adminService.getAmenitiesCategory(response);
    }
}
