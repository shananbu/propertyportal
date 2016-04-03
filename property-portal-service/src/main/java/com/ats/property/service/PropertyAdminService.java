package com.ats.property.service;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.common.constants.PropertyConstants;
import com.ats.property.common.constants.PropertyUtils;
import com.ats.property.dao.IPropertyAdminDAO;
import com.ats.property.dto.*;
import com.ats.property.mail.MailBean;
import com.ats.property.mail.MailService;
import com.ats.property.model.*;
import com.ats.property.spring.UserInformation;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.transaction.Transactional;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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

    @Autowired
    private VelocityEngine velocityEngine;


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
    @Transactional
    public boolean getAdvertisementsByUser(ModuleList response) {
        List<Advertisement> advertisements = adminDAO.getAdvertisementsByUser(getCurrentUserId());
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(Advertisement advertisement : advertisements) {
            AdvertisementType advertisementType = new AdvertisementType();
            if (fromNullable(advertisement).isPresent()) {
                PropertyUtils.copyFields(advertisement, advertisementType);
                advertisementType.setCompanyName(advertisement.getBuilderName());
                if(advertisement.getBuilderName() == null || (advertisement.getBuilderName() != null && advertisement.getBuilderName().equals("") )) {
                    advertisementType.setCompanyName(advertisement.getPropertyUserByPropertyUserId().getBuilderName());
                }
                advertisementType.setLocationName(advertisement.getLocationsByLocationId().getName());
                advertisementType.setPropertyForTypeName(advertisement.getPropertyForTypeByPropertyForTypeId().getNameForPoster());
                advertisementType.setPropertyTypeName(advertisement.getPropertyTypeByPropertyTypeId().getName());
                if(advertisement.getIsMicroSite() == null || !advertisement.getIsMicroSite()) {
                    advertisementType.setAdvtTypeName(PropertyConstants.CLASSIFIEDS.value());
                    advertisementType.setIsMicroSite(false);
                } else {
                    advertisementType.setAdvtTypeName(PropertyConstants.MICROSITE.value());
                    advertisementType.setIsMicroSite(true);
                }
                if(advertisement.getIsApproved()== null || !advertisement.getIsApproved() ) {
                    advertisementType.setDescription(PropertyConstants.APPROVAL_PENDING.value());
                } else {
                    advertisementType.setDescription(PropertyConstants.APPROVED.value());
                }
            }
            moduleResponseType.getAdvertisements().add(advertisementType);
        }
        return false;
    }

    @Override
    @Transactional
    public PropertyUser getPropertyUserById() {
        PropertyUser propertyUser = adminDAO.getPropertyUserById(getCurrentUserId());
        return propertyUser;
    }

    @Override
    @Transactional
    public int getRemainingImageCount(Long advertisementId) {
        Advertisement advertisement = adminDAO.findObjectById(advertisementId, Advertisement.class);
        Integer planImageCount = advertisement.getPlanMastByPlanId().getNumberOfImages();
        return planImageCount -  advertisement.getGalleryImagesesById().size();
    }

    @Override
    @Transactional
    public boolean showClientReportView(String fromDate, String toDate, ModuleList response) {
        List<PropertyUser> users = adminDAO.getUsersByDateRange(fromDate, toDate);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(PropertyUser user : users) {
            PropertyUserType userType = objectFactory.createPropertyUserType();
            PropertyUtils.copyFields(user, userType);
            moduleResponseType.getPropertyUsers().add(userType);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean getAdvertisementsByType(boolean isMicroSite, ModuleList response) {
        List<Advertisement> advertisements = adminDAO.getAdvertisements(isMicroSite);
        getAdvertisements(advertisements, response);
        return true;
    }

    @Override
    @Transactional
    public boolean sendPasswordRecoveryMail(String mailId, ModuleList response) {
        PropertyUser user = adminDAO.getUserByMail(mailId);
        boolean stats = false;
        if( user != null) {
            if (user.getEmailId() != null) {
                MailBean data = getRecoveryMailData(user);
                user.setPasswordRecoveryToken(data.getPasswordRecoveryToken());
                mailService.sendMail(data);
            }
            adminDAO.updatePropertyUser(user);
            stats = true;
        }
        return stats;
    }

    @Override
    @Transactional
    public boolean resetPassword(String token, String password) {
        PropertyUser user = adminDAO.getUserByToken(token);
        boolean stats = false;
        if( user != null) {
            user.setPasswrd(password);
            user.setPasswordRecoveryToken("");
            adminDAO.updatePropertyUser(user);
            stats = true;
        }
        return stats;
    }

    @Override
    @Transactional
    public boolean sendContactUsMail(ContactUsType contactUsType, ModuleList response) {

        boolean stats = false;
        if (contactUsType.getEMail() != null) {
            Advertisement advertisement = adminDAO.findObjectById(contactUsType.getAdvertisementId(), Advertisement.class);
            contactUsType.setBuilderEmail(advertisement.getPropertyUserByPropertyUserId().getEmailId());
            contactUsType.setBuilderName(advertisement.getPropertyUserByPropertyUserId().getFirstName());
            MailBean data = getContactUsMailData(contactUsType);
            mailService.sendMail(data);
            stats = true;
        }
        return stats;
    }

    public static Long getCurrentUserTypeId() {
        UserInformation user = getCurrentUser();
        if (user != null) {
            return user.getUserTypeId();
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
    @Transactional
    public boolean getStatusFieldData(String targetForm, ModuleList response) {
        List<StatusType> data = adminDAO.getStatusFieldData(targetForm);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        moduleResponseType.getStatusData().addAll(data);
        return true;
    }

    @Override
    @Transactional
    public boolean getUserList(String searchKey, ModuleList response) {
        List<AdminLogin> logins = adminDAO.findUsers(searchKey);
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(logins).isPresent()) {
            for(AdminLogin admin : logins) {
                AdminUserType userType = objectFactory.createAdminUserType();

                if(fromNullable(admin.getDoj()).isPresent()) {
                    String doj = admin.getDoj().toString();
                    userType.setDoj(doj.replaceAll(" 00:00:00.0", ""));
                }

                if(fromNullable(admin.getDor()).isPresent()) {
                    String dob = admin.getDor().toString();
                    userType.setDor(dob.replaceAll(" 00:00:00.0", ""));
                }
                if(admin.getStatusId() != null) {
                    userType.setStatus(admin.getStatusId());
                }
                PropertyUtils.copyFields(admin, userType);
                moduleResponseType.getAdminUsers().add(userType);
            }
        }
        return true;
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
        moduleResponseType.getCities().add(getOtherLocation());
        return true;
    }

    @Override
    @Transactional
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
        moduleResponseType.getCities().add(getOtherLocation());
        return true;
    }

    @Override
    @Transactional
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
    @Transactional
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
                planType.setPostPropertyUrl(plan.getUserTypeByUserTypeId().getPostPropertyUrl());
                planType.setUserTypeName(plan.getUserTypeByUserTypeId().getName());
                moduleResponseType.getPlans().add(planType);
            }
        };
        return true;
    }

    @Override
    @Transactional
    public NameDataType saveOrUpdateCity(City location) {
        City city = null;
        if(!fromNullable(location.getId()).isPresent() || location.getId() == -1) {
            if(adminDAO.findCityByName(location.getName()) == null) {
                location.setStateByStateId(adminDAO.findStateById(location.getStateId()));
                city = adminDAO.saveOrUpdateCity(location);
            }
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
    @Transactional
    public NameDataType saveOrUpdateLocation(Locations location) {

        Locations locations = null;
        if(!fromNullable(location.getId()).isPresent() || location.getId() == -1) {
            if(adminDAO.findLocationByName(location.getName()) == null) {
                location.setCityByCityId(adminDAO.findCityById(location.getCityId()));
                locations = adminDAO.saveOrUpdateLocation(location);
            }
        } else {
            locations = adminDAO.updateLocation(location);
        }

        if(fromNullable(locations).isPresent()) {
            NameDataType nameDataType = new NameDataType();
            nameDataType.setId(locations.getId());
            return nameDataType;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
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
        advertisement.setIsApproved(false);
        advertisement.setPostDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
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
        if(advertisement.getId() != null) {
            MailBean data = getAdvtPostingMailData(advertisement);
       //     mailService.sendMail(data);

            MailBean dataToAdmin = getAdvtPostingMailDataToAdmin(advertisement);
         //   mailService.sendMail(dataToAdmin);
        }
        AdvertisementType advertisementType = new AdvertisementType();
        advertisementType.setId(advertisement.getId());
        advertisementType.setPlanId(advertisement.getPlanMastByPlanId().getId());
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
    @Transactional
    public PropertyUserType saveOrUpdateUser(PropertyUser user) {
        if(user.getId() != null ) {
            user.setIsMailVerified("N");
            adminDAO.updatePropertyUser(user);
            if (user.getEmailId() != null) {
                MailBean data = getMailData(user, "Your profile successfully updated");
                mailService.sendMail(data);
            }
            return new PropertyUserType();
        } else {
            if (getUserByMail(user.getEmailId())) {
                user.setUserTypeByUserTypeId(adminDAO.findUserTypeById(user.getUserTypeId()));
                user.setCityByCityId(adminDAO.findCityById(user.getCityId()));
                user.setIsMailVerified("N");
                user.setRegisteredDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                PropertyUser propertyUserResponse = adminDAO.saveOrUpdateUser(user);
                if (fromNullable(propertyUserResponse).isPresent()) {
                    PropertyUserType userType = new PropertyUserType();
                    userType.setId(propertyUserResponse.getId());
                    if (user.getEmailId() != null) {
                        MailBean data = getMailData(user, "Welcome to 1acreindia.com");
                        mailService.sendMail(data);
                    }
                    return userType;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    @Override
    @Transactional
    public PropertyUserType activateAccount(PropertyUser user) {
        PropertyUserType propertyUserResponse = null;
        adminDAO.updateUserByIdAndMail(user.getId(), user.getEmailId());
        return propertyUserResponse;
    }

    private MailBean getMailData(PropertyUser user, String subject) {
        MailBean data = new MailBean();
        data.setToMailId(user.getEmailId());
        data.setMailBody(buildMailBodyFromTemplate(user));
        data.setSubject(subject);
        return data;
    }

 /*   private String getMailBody(PropertyUser user){
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
    }*/


    @Override
    @Transactional
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
    @Transactional
    public boolean getBudgetList(ModuleList response) {
        List<Budget> budgets = adminDAO.getBudgets();
        populateBudget(budgets, response);
        return true;
    }

    @Override
    @Transactional
    public boolean getBudgetsByPropertyForType(ModuleList response, Long pForTypeId) {
        List<Budget> budgets = adminDAO.getBudgetsByPropertyForType(pForTypeId);
        populateBudget(budgets, response);
        return false;
    }

    private void populateBudget(List<Budget> budgets, ModuleList response) {
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        if(fromNullable(budgets).isPresent()) {
            for(Budget budget : budgets) {
                BudgetType budgetType = new BudgetType();
                PropertyUtils.copyFields(budget, budgetType);
                moduleResponseType.getBudgets().add(budgetType);
            }
        }
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
    public boolean searchProperty(SearchType searchType, ModuleList response) {
        List<Advertisement> result = adminDAO.searchProperty(searchType);
        /*ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(Advertisement advt : result) {
            SearchResultType searchResult = new SearchResultType();
            searchResult.setProjectName(advt.getProjectName());
            searchResult.setDescription(advt.getDescription());
            searchResult.setPropertyType(advt.getPropertyTypeByPropertyTypeId().getName());
            moduleResponseType.getSearchResult().add(searchResult);
        }*/
        getAdvertisements(result, response);
        return true;
    }

    @Override
    @Transactional
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
    @Transactional
    public PropertyRequirement saveAlert(PropertyRequirement requirement, AlertRegistrationType alertType) {
        requirement.setBudgetByBudgetId(adminDAO.findObjectById(requirement.getBudgetId(), Budget.class));
        requirement.setPropertyForTypeByPropertyForTypeId(adminDAO.findObjectById(requirement.getPropertyForTypeId(), PropertyForType.class));
        requirement.setUnitMasterByBuildupAreaUnitId(adminDAO.findObjectById(requirement.getBuildupAreaUnitId(), UnitMaster.class));
        requirement.setPropertyUserByPropertyUserId(adminDAO.findObjectById(getCurrentUserId(), PropertyUser.class));

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
    @Transactional
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
    @Transactional
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
                advertisementType.setCompanyLogo(PropertyConstants.NO_IMAGE_PATH.value());
                if( advertisement.getLocationsByLocationId() != null){
                    advertisementType.setAddress(advertisement.getAddress() + ", " + advertisement.getLocationsByLocationId().getName());
                }
                if(advertisement.getPossessionOrAgeByPossessionOrAgeId() != null) {
                    advertisementType.setPossession(advertisement.getPossessionOrAgeByPossessionOrAgeId().getName());
                }
                if(null != advertisement.getPropertyTypeByPropertyTypeId()) {
                    advertisementType.setPropertyTypeName(advertisement.getPropertyTypeByPropertyTypeId().getName());
                }
                if( null != advertisement.getMorePropertiesFileName()) {
                    advertisementType.setMorePropertiesFileName(PropertyConstants.RESOURCE_DIR.value() + advertisement.getMorePropertiesFileName());
                }
                if( null != advertisement.getDescriptionFileName()) {
                    advertisementType.setDescriptionFileName(PropertyConstants.RESOURCE_DIR.value() + advertisement.getDescriptionFileName());
                }
                if( null != advertisement.getSpecificationFileName()) {
                    advertisementType.setSpecificationFileName(PropertyConstants.RESOURCE_DIR.value() + advertisement.getSpecificationFileName());
                }

                if( null == advertisement.getBuilderName()) {
                    advertisementType.setOwnerFirstName(advertisement.getPropertyUserByPropertyUserId().getFirstName());
                }

                advertisementType.setCompanyName(advertisement.getBuilderName());
                if(advertisement.getBuilderName() == null || (advertisement.getBuilderName() != null && advertisement.getBuilderName().equals("") )) {
                    advertisementType.setCompanyName(advertisement.getPropertyUserByPropertyUserId().getBuilderName());
                }

                advertisementType.setLocationName(advertisement.getLocationsByLocationId().getName());
                for(Residential residential : advertisement.getResidentialsById()) {
                    if(residential.getBedroomByBedRoomId() != null) {
                        advertisementType.setBedRooms(residential.getBedroomByBedRoomId().getName());
                    }
                }
                for(AdvertisementDetails advertisementDetails : advertisement.getAdvertisementDetailsesById()) {
                    if(advertisementDetails.getBuildupArea() != null) {
                        String buildupAreaName = advertisementDetails.getBuildupArea().longValue() + " " + advertisementDetails.getUnitMasterByBuildupAreaUnitId().getName() + " " + PropertyConstants.ONWARDS.value();
                        advertisementType.setBuildupAreaName(buildupAreaName);
                        advertisementType.setBuildupAreaRange(buildupAreaName);
                        String cost = advertisementDetails.getExpectedPrice() / ONE_LAKH + " " + PropertyConstants.LAKHS.value() + " " + PropertyConstants.ONWARDS.value();
                        advertisementType.setCost(cost);
                        advertisementType.setPriceRange(cost);
                    }
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

                        if(galleryImage.getImageTypeByImageTypeId().getName().equals(PropertyConstants.LOGO.value())) {
                            advertisementType.setCompanyLogo(PropertyConstants.RESOURCE_DIR.value() + galleryImage.getImageName());
                        }
                        advertisementType.getGalleryImage().add(imageType);

                        imagesList.add(imageType);

                        advertisementType.getGalleryImageByImageTypeMap().put(parent, imagesList);
                    }
                    if(null != advertisementType.getGalleryImageByImageTypeMap().get(EXTERIOR_VIEW_ID)) {
                        List<GalleryImageType> exteriorImagesList = (List<GalleryImageType>) advertisementType.getGalleryImageByImageTypeMap().get(EXTERIOR_VIEW_ID);
                        advertisementType.getOverviewBannerImages().addAll(exteriorImagesList);
                    }
                }
                if(fromNullable(advertisement.getMorePropertyDetailsesById()).isPresent() && advertisement.getMorePropertyDetailsesById().size() > 0) {
                    List<Long> costList = new ArrayList<Long>();
                    List<Long> buildupAreaList = new ArrayList<Long>();
                    String unitName = "";
                    String bedRooms = "";
                    for(MorePropertyDetails morePropertyDetails : advertisement.getMorePropertyDetailsesById()) {
                        unitName = morePropertyDetails.getUnitMasterByAreaAreaUnitId().getName();
                        bedRooms = bedRooms + ", " + morePropertyDetails.getBedroomByBedRoomId().getName();
                        MorePropertyType morePropertyType = new MorePropertyType();
                        PropertyUtils.copyFields(morePropertyDetails, morePropertyType);
                        morePropertyType.setFloorPlanFileName(PropertyConstants.RESOURCE_DIR.value() + morePropertyDetails.getFloorPlanFileName());
                        buildupAreaList.add(morePropertyDetails.getArea());
                        costList.add(morePropertyDetails.getTotalCost());
                        morePropertyType.setBedRoom(morePropertyDetails.getBedroomByBedRoomId().getName());
                        morePropertyType.setTotalCostInWords(morePropertyDetails.getTotalCost() / ONE_LAKH + " " + PropertyConstants.LAKHS.value());
                        advertisementType.getMoreProperty().add(morePropertyType);
                    }
                    bedRooms = bedRooms.substring(1);
                    bedRooms = bedRooms.replaceAll("BHK","");
                    bedRooms = bedRooms + " BHK";
                    advertisementType.setBedRooms(bedRooms);
                    String buildupAreaName = Collections.min(buildupAreaList) + " " + unitName + " " + PropertyConstants.ONWARDS.value();
                    advertisementType.setBuildupAreaName(buildupAreaName);
                    advertisementType.setBuildupAreaRange(buildupAreaName);
                    String cost = Collections.min(costList) / ONE_LAKH + " " + PropertyConstants.LAKHS.value() + " " + PropertyConstants.ONWARDS.value();
                    advertisementType.setCost(cost);
                    advertisementType.setPriceRange(cost);

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
    @Transactional
    public boolean getAdvertisements(ModuleList response) {
        List<Advertisement> advertisements = adminDAO.getAdvertisements(true);
        getAdvertisements(advertisements, response);
        return true;
    }

    @Override
    @Transactional
    public boolean getAdvertisementsForApproval(String status, ModuleList response) {
        List<Advertisement> advertisements = adminDAO.getAdvertisements(Boolean.parseBoolean(status));
        ModuleType moduleType = CommonHelper.getFirstModule(response);
        ModuleResponseType moduleResponseType = moduleType.getModuleResponse();
        for(Advertisement advertisement : advertisements) {
            AdvertisementType advertisementType = new AdvertisementType();
            if (fromNullable(advertisement).isPresent()) {
                PropertyUtils.copyFields(advertisement, advertisementType);
                advertisementType.setCompanyName(advertisement.getBuilderName());
                if(advertisement.getPropertyUserByPropertyUserId().getBuilderName() == null || (advertisement.getPropertyUserByPropertyUserId().getBuilderName() != null && advertisement.getPropertyUserByPropertyUserId().getBuilderName().equals("") )) {
                    advertisementType.setCompanyName(advertisement.getPropertyUserByPropertyUserId().getFirstName());
                }
                advertisementType.setLocationName(advertisement.getLocationsByLocationId().getName());
                advertisementType.setPropertyForTypeName(advertisement.getPropertyForTypeByPropertyForTypeId().getNameForPoster());
                advertisementType.setPropertyTypeName(advertisement.getPropertyTypeByPropertyTypeId().getName());
                if(advertisement.getIsMicroSite() == null || !advertisement.getIsMicroSite() ) {
                    advertisementType.setAdvtTypeName(PropertyConstants.CLASSIFIEDS.value());
                    advertisementType.setIsMicroSite(false);
                } else {
                    advertisementType.setAdvtTypeName(PropertyConstants.MICROSITE.value());
                    advertisementType.setIsMicroSite(true);
                }
                if(advertisement.getIsApproved()== null || !advertisement.getIsApproved() ) {
                    advertisementType.setIsApproved(false);
                } else {
                    advertisementType.setIsApproved(true);
                }
            }
            moduleResponseType.getAdvertisements().add(advertisementType);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean approveOrRejectAdvertisements(List<AdvertisementType> advertisements, ModuleList response) {
        for(AdvertisementType advertisement : advertisements) {
             Advertisement advtFromDB = adminDAO.findObjectById(advertisement.getId(), Advertisement.class);
            advtFromDB.setIsApproved(advertisement.isIsApproved());
            if(advertisement.isIsApproved()) {
                advtFromDB.setApprovedDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            } else {
                advtFromDB.setApprovedDate(null);
            }
            adminDAO.updateAdvertisement(advtFromDB);
        }
        return true;
    }

    @Override
    public boolean getUserByMail(String mailId) {
        return adminDAO.getUserByMail(mailId) == null;

    }

    @Override
    public PlanType getPlanById(Long planId) {
        PlanMast planMast = adminDAO.findObjectById(planId, PlanMast.class);
        PlanType planType = new PlanType();
        PropertyUtils.copyFields(planMast, planType);
        return planType;
    }

    private NameDataType getOtherLocation() {
        NameDataType nameDataType = new NameDataType();
        nameDataType.setName("Others");
        nameDataType.setId(-99L);
        return nameDataType;
    }

    private String buildMailBodyFromTemplate(PropertyUser user) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Map model = new HashMap<String, String>();
        model.put("registeredDate", formatter.format(new java.util.Date()));
        model.put("emailAddress", user.getEmailId());
        model.put("id", user.getId());
        model.put("name", user.getFirstName());

        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mailtemplate/registration-confirmation.vm", "UTF-8", model);
        return text;
    }

    private MailBean getAdvtPostingMailData(Advertisement advertisement) {
        MailBean data = new MailBean();
        data.setToMailId(advertisement.getPropertyUserByPropertyUserId().getEmailId());
        data.setMailBody(buildAdvtPostingMailBodyFromTemplate(advertisement));
        data.setSubject("Advertisement posting complete");
        return data;
    }

    private String buildAdvtPostingMailBodyFromTemplate(Advertisement advertisement) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Map model = new HashMap<String, String>();
        model.put("postingDate", formatter.format(new java.util.Date()));
        model.put("developerName", advertisement.getPropertyUserByPropertyUserId().getBuilderName() +
                " " + advertisement.getPropertyUserByPropertyUserId().getFirstName());
        model.put("projectName", advertisement.getProjectName());
        model.put("propertyType", advertisement.getPropertyTypeByPropertyTypeId().getName());
        model.put("location", advertisement.getAddress());
        model.put("propertyFor", advertisement.getPropertyForTypeByPropertyForTypeId().getNameForPoster());

        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mailtemplate/advt-posting-confirmation-to-user.vm", "UTF-8", model);
        return text;
    }

    private MailBean getAdvtPostingMailDataToAdmin(Advertisement advertisement) {
        MailBean data = new MailBean();
        data.setToMailId("support@1acreindia.com");
        data.setMailBody(buildAdvtPostingMailBodyFromTemplateToAdmin(advertisement));
        data.setSubject("Advertisement posting complete");
        return data;
    }

    private String buildAdvtPostingMailBodyFromTemplateToAdmin(Advertisement advertisement) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Map model = new HashMap<String, String>();
        model.put("postingDate", formatter.format(new java.util.Date()));
        model.put("developerName", advertisement.getPropertyUserByPropertyUserId().getBuilderName() +
                " " + advertisement.getPropertyUserByPropertyUserId().getFirstName());
        model.put("projectName", advertisement.getProjectName());
        model.put("propertyType", advertisement.getPropertyTypeByPropertyTypeId().getName());
        model.put("location", advertisement.getAddress());
        model.put("propertyFor", advertisement.getPropertyForTypeByPropertyForTypeId().getNameForPoster());

        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mailtemplate/advt-posting-confirmation-to-user.vm", "UTF-8", model);
        return text;
    }

    private MailBean getRecoveryMailData(PropertyUser user) {
        MailBean data = new MailBean();
        data.setToMailId(user.getEmailId());
        String token = CommonHelper.getToken(user.getEmailId() + user.getId() + user.getCityId());
        data.setPasswordRecoveryToken(token);
        data.setMailBody(buildPasswordRecoveryMailBodyFromTemplate(user.getFirstName(), token));
        data.setSubject("Password Recovery");
        return data;
    }

    private String buildPasswordRecoveryMailBodyFromTemplate(String name, String token) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Map model = new HashMap<String, String>();
        model.put("token", token);
        model.put("name", name);
        model.put("date", formatter.format(new java.util.Date()));
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mailtemplate/password-recovery.vm", "UTF-8", model);
        return text;
    }

    private MailBean getContactUsMailData(ContactUsType user) {
        MailBean data = new MailBean();
        data.setToMailId(user.getBuilderEmail());
        data.setMailBody(buildContactUsMailBodyFromTemplate(user));
        data.setSubject("Interest on property");
        return data;
    }

    private String buildContactUsMailBodyFromTemplate(ContactUsType user) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Map model = new HashMap<String, String>();
        model.put("name", user.getName());
        model.put("builderName", user.getBuilderName());
        model.put("mobile", user.getMobileNo());
        model.put("email", user.getEMail());
        model.put("city", user.getCity());
        model.put("date", formatter.format(new java.util.Date()));
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mailtemplate/contact-property-owner-builder.vm", "UTF-8", model);
        return text;
    }

}
