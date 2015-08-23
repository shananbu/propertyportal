package com.ats.property.dao;

import com.ats.property.dto.LocalityType;
import com.ats.property.dto.PlanType;
import com.ats.property.dto.StatusType;
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
    AdminLogin saveOrUpdateAdminUser(AdminLogin adminLogin);
    List<StatusType> getStatusFieldData(String targetForm);
    StatusMast getStatusById(Long id);
    List<AdminLogin> findUsers(String searchKey);
    List<State> findState(String searchKey);
    List<City> findCity(String searchKey);
    List<Locations> findLocation(String searchKey);
    List<PlanMast> findAdvertisePlan(String searchKey);
    City saveOrUpdateCity(City city);
    City updateCity(City city);
    Locations updateLocation(Locations location);
    Locations saveOrUpdateLocation(Locations location);
    PlanMast updatePlan(PlanMast planMast);

    List<UserType> getUserType();
    UserType findUserTypeById(Long id);
    PlanMast saveOrUpdatePlan(PlanMast planMast);

    PropertyUser saveOrUpdateUser(PropertyUser user);
    PropertyUser updateUserByIdAndMail(Long id, String mailId);
    City findCityById(Long id);
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

}
