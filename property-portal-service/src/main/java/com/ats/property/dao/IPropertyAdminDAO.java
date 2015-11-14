package com.ats.property.dao;

import com.ats.property.dto.*;
import com.ats.property.model.*;

import java.util.List;

/**
 * The PropertyAdminDAO.
 *
 * @author anbarasan.s
 */
public interface IPropertyAdminDAO {
    void getCountry();
    AdminLogin getAdminUser(String userName);
    PropertyUser getPropertyUser(String emailId);
    AdminLogin saveOrUpdateAdminUser(AdminLogin adminLogin);
    List<StatusType> getStatusFieldData(String targetForm);
    StatusMast getStatusById(Long id);
    List<AdminLogin> findUsers(String searchKey);
    List<State> findState(String searchKey);
    List<City> findCity(String searchKey);
    List<Locations> findLocation(String searchKey);
    List<City> findCityByStateId(String stateId);
    List<Locations> findLocationByCityId(String cityId);
    List<PlanMast> findAdvertisePlan(String searchKey);
    City saveOrUpdateCity(City city);
    City updateCity(City city);
    Locations updateLocation(Locations location);
    Locations saveOrUpdateLocation(Locations location);
    PlanMast updatePlan(PlanMast planMast);

    List<UserType> getUserType();
    UserType findUserTypeById(Long id);
    PlanMast saveOrUpdatePlan(PlanMast planMast);
    Advertisement saveAdvertisement(Advertisement advertisement);
    AdvertisementDetails saveAdvertisementDetails(AdvertisementDetails advertisementDetails);
    Residential saveResidential(Residential residential);
    PropertyAmenities savePropertyAmenities(PropertyAmenities amenities);
    MorePropertyDetails saveMorePropertyDetails(MorePropertyDetails moreProperty);

    Advertisement updateAdvertisement(Advertisement advertisement);
    GalleryImages saveImage(GalleryImages galleryImage);

    PropertyUser saveOrUpdateUser(PropertyUser user);
    PropertyUser updateUserByIdAndMail(Long id, String mailId);
    City findCityById(Long id);
    City findCityByName(String name);
    Locations findLocationByName(String name);
    State findStateById(Long id);
    List<PropertyMainType> getPropertyTypes();
    List<Budget> getBudgets();
    List<Bedroom> getBedrooms();

    List<PropertyForType> getPropertyForTypes();
    List<FurnishedStatus> getFurnishedStatus();
    List<Bathroom> getBathrooms();
    List<Balconies> getBalconies();
    List<TotalFloors> getTotalFloors();
    List<UnitMaster> getUnits();
    List<TransactionType> getTransactionTypes();

    List<PossessionStatus> getPossessionStatus();
    List<Terms> getUTerms();
    List<AmenitiesCategory> getAmenitiesCategory();


    <T> T findObjectById(Long id, Class<T> clazz);

    List<Advertisement> searchProperty(SearchType searchType);

    PropertyRequirement saveAlert(PropertyRequirement requirement);

    PreferredLocations savePreferredLocations(PreferredLocations preferredLocations);

    PreferredBeds savePreferredBeds(PreferredBeds preferredBeds);

    List<PossessionOrAge> getPossessionOrAge();

    List<ImageType> getImageTypes();

    List<Advertisement> getAdvertisements(boolean isApproved);

}
