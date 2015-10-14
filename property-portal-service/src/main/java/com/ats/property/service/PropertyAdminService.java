package com.ats.property.service;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.common.constants.PropertyConstants;
import com.ats.property.common.constants.PropertyUtils;
import com.ats.property.dao.IPropertyAdminDAO;
import com.ats.property.dto.*;
import com.ats.property.mail.MailBean;
import com.ats.property.mail.MailService;
import com.ats.property.model.*;
import com.ats.property.model.Advertisement;
import com.ats.property.model.TotalFloors;
import com.ats.property.spring.UserInformation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.ats.property.common.constants.PropertyUtils.isNotNull;
import static com.google.common.base.Optional.fromNullable;

/**
 * The PropertyAdminService.
 *
 * @author anbarasan.s
 */
public class PropertyAdminService implements IPropertyAdminService, InitializingBean {

    @Autowired
    private IPropertyAdminDAO adminDAO;

    @Autowired
    public MailService mailService;

    private  ObjectFactory objectFactory;

    public static UserInformation getCurrentUser(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserInformation ? (UserInformation) principal : null;
        }
        return null;
    }

    public Long getCurrentUserId() {
        UserInformation user = getCurrentUser();
        if (user != null) {
            return user.getUserId();
        }
        return null;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
         objectFactory = new ObjectFactory();
    }

    @Override
    @Transactional
    public void getCountry() {
        adminDAO.getCountry();
    }

    @Override
    @Transactional
    public AdminLogin getAdminUser(String userName, String password) {
        AdminLogin adminlogin = adminDAO.getAdminUser(userName);
        if (fromNullable(adminlogin).isPresent()) {
            if(adminlogin.getPassword().equals(password)) {
                return adminlogin;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public AdminUserType saveOrUpdateAdminUser(AdminLogin adminUser) {
        AdminLogin adminlogin = adminDAO.saveOrUpdateAdminUser(adminUser);
        if(fromNullable(adminlogin).isPresent()) {
            AdminUserType adminUserType =  new AdminUserType();
            adminUserType.setId(adminlogin.getId());
            return adminUserType;
        } else {
            return null;
        }
    }

    @Override
    public boolean getStatusFieldData(String targetForm, ModuleList response) {
        List<StatusType> data = adminDAO.getStatusFieldData(targetForm);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        moduleResponseType.getStatusData().addAll(data);
        return true;
    }

    @Override
    public boolean getUserList(String searchKey, ModuleList response) {
        List<AdminLogin> logins = adminDAO.findUsers(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(logins).isPresent()) {
            for(AdminLogin admin : logins) {
                AdminUserType userType = objectFactory.createAdminUserType();
                String doj = admin.getDoj().toString();
                if(fromNullable(doj).isPresent()) {
                    userType.setDoj(doj.replaceAll(" 00:00:00.0", ""));
                }
                String dob = admin.getDor().toString();
                if(fromNullable(dob).isPresent()) {
                    userType.setDor(dob.replaceAll(" 00:00:00.0", ""));
                }

                userType.setStatus(admin.getStatusId());
                PropertyUtils.copyFields(admin, userType);
                moduleResponseType.getAdminUsers().add(userType);
            }
        }
        return true;
    }

    @Override
    public boolean getStateList(String searchKey, ModuleList response) {
        List<State> states = adminDAO.findState(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(states).isPresent()) {
            for(State state : states) {
                NameDataType stateType = new NameDataType();
                PropertyUtils.copyFields(state, stateType);
                moduleResponseType.getStates().add(stateType);
            }
        }
        return true;
    }

    @Override
    public boolean getCityList(String searchKey, ModuleList response) {
        List<City> cities = adminDAO.findCity(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(cities).isPresent()) {
            for(City city : cities) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(city, nameDataType);
                nameDataType.setParentId(city.getStateByStateId().getId());
                moduleResponseType.getCities().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getCityByStateId(String stateId, ModuleList response) {
        List<City> cities = adminDAO.findCityByStateId(stateId);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(cities).isPresent()) {
            for(City city : cities) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(city, nameDataType);
                nameDataType.setParentId(city.getStateByStateId().getId());
                moduleResponseType.getCities().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getLocationByCityId(String cityId, ModuleList response) {
        List<Locations> locations = adminDAO.findLocationByCityId(cityId);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(locations).isPresent()) {
            for(Locations location : locations) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(location, nameDataType);
                nameDataType.setParentId(location.getCityByCityId().getId());
                moduleResponseType.getCities().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getLocationList(String searchKey, ModuleList response) {
        List<Locations> locations = adminDAO.findLocation(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(locations).isPresent()) {
            for(Locations location : locations) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(location, nameDataType);
                moduleResponseType.getLocations().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getAdvertisePlanList(String searchKey, ModuleList response, boolean lineByLineDesc) {
        List<PlanMast> plans = adminDAO.findAdvertisePlan(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(plans).isPresent()) {
            for(PlanMast plan : plans) {
                PlanType planType = new PlanType();
                PropertyUtils.copyFields(plan, planType);
                if(lineByLineDesc) {
                    String dataFilledString = planType.getDescription()
                            .replaceAll(PropertyConstants.MAX_IMAGE_PLACEHOLDER.value(), planType.getNumberOfImages().toString())
                            .replaceAll(PropertyConstants.PLAN_COST_PLACEHOLDER.value(), planType.getCost().toString())
                            .replaceAll(PropertyConstants.PLAN_DAYS_PLACEHOLDER.value(), planType.getValidDays().toString());
                    CommonHelper.parseLineByLine(dataFilledString, planType.getLineByeLineDescription());
                }
                planType.setUserTypeName(plan.getUserTypeByUserTypeId().getName());
                moduleResponseType.getPlans().add(planType);
            }
        };
        return true;
    }

    @Override
    public NameDataType saveOrUpdateCity(City location) {
        City city = null;
        if(!fromNullable(location.getId()).isPresent() || location.getId() == -1) {
            location.setStateByStateId(adminDAO.findStateById(location.getStateId()));
            city = adminDAO.saveOrUpdateCity(location);
        } else {
            city = adminDAO.updateCity(location);
        }
        if(fromNullable(city).isPresent()) {
            NameDataType nameDataType = new NameDataType();
            nameDataType.setId(city.getId());
            return nameDataType;
        } else {
            return null;
        }
    }

    @Override
    public NameDataType saveOrUpdateLocation(Locations location) {

        Locations locations = null;
        if(!fromNullable(location.getId()).isPresent() || location.getId() == -1) {
            location.setCityByCityId(adminDAO.findCityById(location.getCityId()));
            locations = adminDAO.saveOrUpdateLocation(location);
        } else {
            locations = adminDAO.updateLocation(location);
        }

        if(fromNullable(location).isPresent()) {
            NameDataType nameDataType = new NameDataType();
            nameDataType.setId(locations.getId());
            return nameDataType;
        } else {
            return null;
        }
    }

    @Override
    public boolean getUserType(ModuleList response) {
        List<UserType> userTypes = adminDAO.getUserType();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(userTypes).isPresent()) {
            for(UserType userType : userTypes) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(userType, nameDataType);
                moduleResponseType.getUserType().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    @Transactional
    public PlanType saveOrUpdatePlan(PlanMast planMast) {

        PlanMast planMastResponse = null;
        if(!fromNullable(planMast.getId()).isPresent() || planMast.getId() == -1) {
            planMast.setUserTypeByUserTypeId(adminDAO.findUserTypeById(planMast.getUserTypeId()));
            planMastResponse = adminDAO.saveOrUpdatePlan(planMast);
        } else {
            planMastResponse = adminDAO.updatePlan(planMast);
        }

        if(fromNullable(planMastResponse).isPresent()) {
            PlanType planType =  new PlanType();
            planType.setId(planMastResponse.getId());
            return planType;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public AdvertisementType saveOrUpdateAdvertisement(Advertisement advertisement, AdvertisementDetails advertisementDetails, Residential residential,
                                                       List<PropertyAmenities> amenitieses, List<MorePropertyDetails> moreProperties) {
        advertisement.setPropertyForTypeByPropertyForTypeId(adminDAO.findObjectById(advertisement.getPropertyForTypeId() , PropertyForType.class));
        advertisement.setPropertyTypeByPropertyTypeId(adminDAO.findObjectById(advertisement.getPropertyTypeId(), PropertyType.class));
        advertisement.setLocationsByLocationId(adminDAO.findObjectById(advertisement.getLocationId(), Locations.class));
        advertisement.setPropertyUserByPropertyUserId(adminDAO.findObjectById(getCurrentUserId(), PropertyUser.class));

        advertisement.setPossessionOrAgeByPossessionOrAgeId(adminDAO.findObjectById(advertisement.getPossessionOrAgeId(), PossessionOrAge.class));
        advertisement.setPossessionStatusByPossessionStatusId(adminDAO.findObjectById(advertisement.getPossessionStatusId(), PossessionStatus.class));

        advertisement.setPlanMastByPlanId(adminDAO.findObjectById(advertisement.getPlanId(), PlanMast.class));
        advertisementDetails.setUnitMasterByBuildupAreaUnitId(adminDAO.findObjectById(advertisementDetails.getBuildupAreaUnitId(), UnitMaster.class));
        advertisementDetails.setBalconiesByBalconyId(adminDAO.findObjectById(advertisementDetails.getBalconyId(), Balconies.class));
        advertisementDetails.setTotalFloorsByPropertyOnFloorId(adminDAO.findObjectById(advertisementDetails.getPropertyOnFloorId(), TotalFloors.class));
        advertisementDetails.setTotalFloorsByTotalFloor(adminDAO.findObjectById(advertisementDetails.getTotalFloor(), TotalFloors.class));

        residential.setFurnishedStatusByFurnishedStatusId(adminDAO.findObjectById(residential.getFurnishedStatusId(), FurnishedStatus.class));
        residential.setTermsByMaintenancePeriodId(adminDAO.findObjectById(residential.getMaintenancePeriodId(), Terms.class));
        residential.setBedroomByBedRoomId(adminDAO.findObjectById(residential.getBedRoomId(), Bedroom.class));
        residential.setBathroomByBathRoomId(adminDAO.findObjectById(residential.getBathRoomId(), Bathroom.class));

        Advertisement advertisementFromDb = adminDAO.saveAdvertisement(advertisement);
        if(fromNullable(advertisementFromDb).isPresent() && advertisementFromDb.getId() != 0) {
            AdvertisementDetails detailsFromDB = adminDAO.saveAdvertisementDetails(advertisementDetails);
            Residential residentialFromDB = adminDAO.saveResidential(residential);
            if(amenitieses.size() > 0 ) {
                for(PropertyAmenities am : amenitieses) {
                    am.setAdvertisementByAdvertisementId(advertisementFromDb);
                    am.setAmenitiesByAmenitiesId(adminDAO.findObjectById(am.getAmenitiesId(), Amenities.class));
                     PropertyAmenities amenitiesFromDB = adminDAO.savePropertyAmenities(am);
                }
            }

            if(moreProperties.size() > 0 ) {
                moreProperties.remove(0);
                for(MorePropertyDetails morePropertyDetail : moreProperties) {
                    morePropertyDetail.setAdvertisementByAdvertisementId(advertisementFromDb);
                    morePropertyDetail.setUnitMasterByAreaAreaUnitId(adminDAO.findObjectById(1L, UnitMaster.class));
                    morePropertyDetail.setBedroomByBedRoomId(adminDAO.findObjectById(morePropertyDetail.getBedRoomId(), Bedroom.class));
                    MorePropertyDetails morePropertyDetails = adminDAO.saveMorePropertyDetails(morePropertyDetail);
                }
            }
        }

        AdvertisementType advertisementType = new AdvertisementType();
        advertisementType.setId(advertisement.getId());
        return advertisementType;
    }

    @Override
    @Transactional
    public AdvertisementType updateAdvertisement(AdvertisementType advertisementType) {
        Advertisement advtForUpdate =  adminDAO.findObjectById(advertisementType.getId(), Advertisement.class);
        GalleryImages images = null;
        for(GalleryImageType imageType : advertisementType.getGalleryImage()) {
            GalleryImages image = new GalleryImages();
            image.setImageName(imageType.getImageName());
            image.setImageTypeByImageTypeId(adminDAO.findObjectById(advertisementType.getImageTypeId(), ImageType.class));
            image.setAdvertisementByAdvertisementId(advtForUpdate);
            images = adminDAO.saveImage(image);

          //  advtForUpdate.getGalleryImagesesById().add(image);
        }
       // Advertisement advertisementFromDb = adminDAO.updateAdvertisement(advtForUpdate);
        AdvertisementType advertisement = new AdvertisementType();
        advertisement.setId(images.getId());
        return advertisement;
    }


    @Override
    public PropertyUserType saveOrUpdateUser(PropertyUser user) {
        user.setUserTypeByUserTypeId(adminDAO.findUserTypeById(user.getUserTypeId()));
        user.setCityByCityId(adminDAO.findCityById(user.getCityId()));
        PropertyUser propertyUserResponse = adminDAO.saveOrUpdateUser(user);
        if(fromNullable(propertyUserResponse).isPresent()) {
            PropertyUserType userType =  new PropertyUserType();
            userType.setId(propertyUserResponse.getId());
            if(user.getEmailId() != null){
                MailBean data = getMailData(user);
                mailService.sendMail(data);
            }
            return userType;
        } else {
            return null;
        }
    }

    @Override
    public PropertyUserType activateAccount(PropertyUser user) {
        PropertyUserType propertyUserResponse = null;
        adminDAO.updateUserByIdAndMail(user.getId(), user.getEmailId());
        return propertyUserResponse;
    }

    private MailBean getMailData(PropertyUser user) {
        MailBean data = new MailBean();
        data.setToMailId(user.getEmailId());
        data.setMailBody(getMailBody(user));
        data.setSubject("Welcome to 1acreindia.com");
        return data;
    }

    private String getMailBody(PropertyUser user){
        String message="Hi<br><br> " +
                "We thank you to register with us which is a great opportunity to get more business through our site. <br> " +
                "We request you to confirm your registration by clicking on the URL :  " +
                "<a href='www.1acreindia.com/property-portal/activateAccount?userName=" + user.getEmailId() + "&userIdentification=" + user.getId()  + "' target='_blank'> Approve Me.</a> <br>" +
                "This confirmation is to allow you to post your advertisement in the site.<br><br><br>" +
                "Thanking you. <br><br><br>" +
                "Regards, <br>" +
                "Administrator <br> wwww.1acreindia.com " ;
        System.out.println(message);
        return message;
    }

    @Override
    public boolean getPropertyTypeList(ModuleList response) {
        List<PropertyMainType> propertyTypes = adminDAO.getPropertyTypes();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(propertyTypes).isPresent()) {
            for(PropertyMainType propertyType : propertyTypes) {
                MainPropertyType mainPropertyType = new MainPropertyType();
                PropertyUtils.copyFields(propertyType, mainPropertyType);
                for(PropertyType type : propertyType.getPropertyTypesById()) {
                    NameDataType nameDataType = new NameDataType();
                    PropertyUtils.copyFields(type, nameDataType);
                    mainPropertyType.getPropertyTypesById().add(nameDataType);
                }
                moduleResponseType.getMainPropertyTypes().add(mainPropertyType);
            }
        }
        return true;
    }

    @Override
    public boolean getBudgetList(ModuleList response) {
        List<Budget> budgets = adminDAO.getBudgets();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(budgets).isPresent()) {
            for(Budget budget : budgets) {
                BudgetType budgetType = new BudgetType();
                PropertyUtils.copyFields(budget, budgetType);
                moduleResponseType.getBudgets().add(budgetType);
            }
        }
        return true;
    }

    @Override
    public boolean getBedroomsList(ModuleList response) {
        List<Bedroom> bedrooms = adminDAO.getBedrooms();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(bedrooms).isPresent()) {
            for(Bedroom bedroom : bedrooms) {
                BedroomType bedroomType = new BedroomType();
                PropertyUtils.copyFields(bedroom, bedroomType);
                moduleResponseType.getBedrooms().add(bedroomType);
            }
        }
        return true;
    }

    @Override
    public boolean getPropertyForTypeList(ModuleList response) {
        List<PropertyForType> types = adminDAO.getPropertyForTypes();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(PropertyForType type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getPropertyForTypes().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getFurnishedStatusList(ModuleList response) {
        List<FurnishedStatus> types = adminDAO.getFurnishedStatus();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(FurnishedStatus type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getFurnishedStatus().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getBathroomsList(ModuleList response) {
        List<Bathroom> types = adminDAO.getBathrooms();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(Bathroom type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getBathrooms().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getBalconiesList(ModuleList response) {
        List<Balconies> types = adminDAO.getBalconies();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(Balconies type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getBalconies().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getTotalFloorsList(ModuleList response) {
        List<TotalFloors> types = adminDAO.getTotalFloors();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(TotalFloors type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getTotalFloors().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getUnitsList(ModuleList response) {
        List<UnitMaster> types = adminDAO.getUnits();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(UnitMaster type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getUnits().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getTransactionTypesList(ModuleList response) {
        List<TransactionType> types = adminDAO.getTransactionTypes();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(TransactionType type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getTransactionTypes().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getPossessionStatusList(ModuleList response) {
        List<PossessionStatus> types = adminDAO.getPossessionStatus();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(PossessionStatus type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getPossessionStatus().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getPossessionOrAgeList(ModuleList response) {
        List<PossessionOrAge> types = adminDAO.getPossessionOrAge();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(PossessionOrAge type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                nameDataType.setParentId(type.getPossessionStatusByPossessionStatusId().getId());
                moduleResponseType.getPossessionOrAge().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getTermsList(ModuleList response) {
        List<Terms> types = adminDAO.getUTerms();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(Terms type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getTerms().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean searchProperty(SearchType searchType, ModuleList response) {
        List<Advertisement> result = adminDAO.searchProperty(searchType);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(Advertisement advt : result) {
            SearchResultType searchResult = new SearchResultType();
            searchResult.setProjectName(advt.getProjectName());
            searchResult.setDescription(advt.getDescription());
            searchResult.setPropertyType(advt.getPropertyTypeByPropertyTypeId().getName());
            moduleResponseType.getSearchResult().add(searchResult);
        }
        return true;
    }

    @Override
    public boolean getAmenitiesCategory(ModuleList response) {
        List<AmenitiesCategory> result = adminDAO.getAmenitiesCategory();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(AmenitiesCategory cat : result) {
            AmenitiesCategoryType categoryType = new AmenitiesCategoryType();
            categoryType.setId(cat.getId());
            categoryType.setName(cat.getName());
            for(Amenities amenities : cat.getAmenitiesesById()) {
                NameDataType amenity = new NameDataType();
                amenity.setId(amenities.getId());
                amenity.setName(amenities.getName());
                categoryType.getAmenitiesesById().add(amenity);
            }
            moduleResponseType.getAmenitiesCategory().add(categoryType);
        }
        return true;
    }

    @Override
    public PropertyRequirement saveAlert(PropertyRequirement requirement, AlertRegistrationType alertType) {
        requirement.setBudgetByBudgetId(adminDAO.findObjectById(requirement.getBudgetId(), Budget.class));
        requirement.setPropertyForTypeByPropertyForTypeId(adminDAO.findObjectById(requirement.getPropertyForTypeId(), PropertyForType.class));
        requirement.setUnitMasterByBuildupAreaUnitId(adminDAO.findObjectById(requirement.getBuildupAreaUnitId(), UnitMaster.class));
        PropertyRequirement requirementFromDB = adminDAO.saveAlert(requirement);
        if(isNotNull(requirementFromDB)) {
            if(isNotNull(alertType)) {
                if(isNotNull(alertType.getBedRooms())) {
                    String bedArray[] = alertType.getBedRooms().split(",");
                    for(String bed : bedArray) {
                        PreferredBeds preferredBeds = new PreferredBeds();
                        preferredBeds.setPropertyRequirementByPropertyRequirementId(requirementFromDB);
                        preferredBeds.setBedroomByBedRoomId(adminDAO.findObjectById(Long.parseLong(bed), Bedroom.class));
                        adminDAO.savePreferredBeds(preferredBeds);
                    }
                }

                if(isNotNull(alertType.getLocations())) {
                    String locationArray[] = alertType.getLocations().split(",");
                    for(String location : locationArray) {
                        PreferredLocations preferredLocations = new PreferredLocations();
                        preferredLocations.setPropertyRequirementByPropertyRequirementId(requirementFromDB);
                        preferredLocations.setLocationsByLocationId(adminDAO.findObjectById(Long.parseLong(location), Locations.class));
                        adminDAO.savePreferredLocations(preferredLocations);
                    }
                }
            }
        }
        return requirementFromDB;
    }

    @Override
    public boolean getImageTypeList(ModuleList response) {
        List<ImageType> types = adminDAO.getImageTypes();
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(types).isPresent()) {
            for(ImageType type : types) {
                NameDataType nameDataType = new NameDataType();
                PropertyUtils.copyFields(type, nameDataType);
                moduleResponseType.getImageTypes().add(nameDataType);
            }
        }
        return true;
    }

    @Override
    public boolean getAdvertisementById(String advertisementId, ModuleList response) {
        Advertisement advertisement = adminDAO.findObjectById(Long.parseLong(advertisementId), Advertisement.class);
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        advertisements.add(advertisement);
        getAdvertisements(advertisements, response);
        return true;
    }

    private boolean getAdvertisements(List<Advertisement> advertisements, ModuleList response) {
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(Advertisement advertisement : advertisements) {
            AdvertisementType advertisementType = new AdvertisementType();
            Long EXTERIOR_VIEW_ID = null;
            if(fromNullable(advertisement).isPresent()) {
                PropertyUtils.copyFields(advertisement, advertisementType);
                if(advertisement.getPossessionOrAgeByPossessionOrAgeId() != null) {
                    advertisementType.setPossession(advertisement.getPossessionOrAgeByPossessionOrAgeId().getName());
                }
                advertisementType.setCompanyName(advertisement.getBuilderName());
                if(advertisement.getBuilderName() == null) {
                    advertisementType.setCompanyName(advertisement.getPropertyUserByPropertyUserId().getBuilderName());
                }
                advertisementType.setCompanyLogo("image_7.jpg");
                advertisementType.setLocationName(advertisement.getLocationsByLocationId().getName());
                for(Residential residential : advertisement.getResidentialsById()) {
                    advertisementType.setBedRooms(residential.getBedroomByBedRoomId().getName());
                }
                for(AdvertisementDetails advertisementDetails : advertisement.getAdvertisementDetailsesById()) {
                    String buildupAreaName = advertisementDetails.getBuildupArea().longValue() + " " + advertisementDetails.getUnitMasterByBuildupAreaUnitId().getName() + " " + PropertyConstants.ONWARDS.value();
                    advertisementType.setBuildupAreaName(buildupAreaName);
                    advertisementType.setBuildupAreaRange(buildupAreaName);
                    String cost = advertisementDetails.getExpectedPrice() / ONE_LAKH + " " + PropertyConstants.LAKHS.value() + " " + PropertyConstants.ONWARDS.value();
                    advertisementType.setCost(cost);
                    advertisementType.setPriceRange(cost);
                }


                if(fromNullable(advertisement.getGalleryImagesesById()).isPresent()) {
                    advertisementType.setGalleryImageByImageTypeMap(new HashMap());
                    for(GalleryImages galleryImage : advertisement.getGalleryImagesesById()) {
                        Long parent = galleryImage.getImageTypeByImageTypeId().getId();
                        Object dataFromMap = (advertisementType.getGalleryImageByImageTypeMap() != null) ? advertisementType.getGalleryImageByImageTypeMap().get(parent) : null;
                        List<GalleryImageType> imagesList = null;
                        if(dataFromMap == null) {
                            imagesList = new ArrayList<GalleryImageType>();
                        } else {
                            imagesList = (List<GalleryImageType>)dataFromMap;
                        }
                        GalleryImageType imageType = new GalleryImageType();
                        PropertyUtils.copyFields(galleryImage, imageType);
                        imageType.setImageName(PropertyConstants.RESOURCE_DIR.value() + imageType.getImageName());
                        if(galleryImage.getImageTypeByImageTypeId().getName().equals(PropertyConstants.EXTERIOR_VIEW.value())) {
                            advertisementType.setPropertyLogo(PropertyConstants.RESOURCE_DIR.value() + galleryImage.getImageName());
                            EXTERIOR_VIEW_ID = galleryImage.getImageTypeByImageTypeId().getId();
                        }

                        imagesList.add(imageType);

                        advertisementType.getGalleryImageByImageTypeMap().put(parent, imagesList);
                    }
                    List<GalleryImageType> exteriorImagesList = (List<GalleryImageType>)advertisementType.getGalleryImageByImageTypeMap().get(EXTERIOR_VIEW_ID);
                    advertisementType.getOverviewBannerImages().addAll(exteriorImagesList);
                }

                if(fromNullable(advertisement.getMorePropertyDetailsesById()).isPresent()) {
                    for(MorePropertyDetails morePropertyDetails : advertisement.getMorePropertyDetailsesById()) {
                        MorePropertyType morePropertyType = new MorePropertyType();
                        PropertyUtils.copyFields(morePropertyDetails, morePropertyType);
                        advertisementType.getMoreProperty().add(morePropertyType);
                    }
                }

                if(fromNullable(advertisement.getPropertyAmenitiesesById()).isPresent()) {
                    advertisementType.setPropertyAmenitiesMap(new HashMap());
                    for(PropertyAmenities propertyAmenity : advertisement.getPropertyAmenitiesesById()) {
                        Long parent = propertyAmenity.getAmenitiesByAmenitiesId().getAmenitiesCategoryByAmenitiesCategoryId().getId();
                        Object dataFromMap = (advertisementType.getPropertyAmenitiesMap() != null) ? advertisementType.getPropertyAmenitiesMap().get(parent) : null;
                        List<NameDataType> amenitiesList = null;
                        if(dataFromMap == null) {
                            amenitiesList = new ArrayList<NameDataType>();
                        } else {
                            amenitiesList = (List<NameDataType>)dataFromMap;
                        }
                        NameDataType amenity = new NameDataType();
                        amenity.setName(propertyAmenity.getAmenitiesByAmenitiesId().getName());
                        amenitiesList.add(amenity);

                        advertisementType.getPropertyAmenitiesMap().put(parent, amenitiesList);
                    }
                }
            }
            moduleResponseType.setAdvertisement(advertisementType);
            moduleResponseType.getAdvertisements().add(advertisementType);
        }

        return true;
    }

    @Override
    public boolean getAdvertisements(ModuleList response) {
        List<Advertisement> advertisements = adminDAO.getAdvertisements();
        getAdvertisements(advertisements, response);
        return true;
    }
}
