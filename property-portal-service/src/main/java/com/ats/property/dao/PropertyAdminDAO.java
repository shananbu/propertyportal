package com.ats.property.dao;

import com.ats.property.common.constants.PropertyUtils;
import com.ats.property.dto.SearchType;
import com.ats.property.dto.StatusType;
import com.ats.property.model.*;
import com.google.common.base.Optional;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.InitializingBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static com.google.common.base.Optional.fromNullable;

/**
 * The PropertyAdminDAO.
 *
 * @author anbarasan.s
 */
public class PropertyAdminDAO extends AbstractDao implements IPropertyAdminDAO, InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }/*    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/
    
    @Override
    public void getCountry() {
        Session session = getSession();
        Query query = session.createQuery("from Country" );
        for (Object o : query.list()) {
            System.out.println(o.toString());
        }
    }

    @Override
    public AdminLogin getAdminUser(String userName) {
        Session session = getSession();
        Query query = session.createQuery("from AdminLogin a where a.userName = :userName" );
        query.setParameter("userName", userName);

        AdminLogin adminlogin = null;
        List<AdminLogin> responseList = query.list();
        if(responseList.size() > 0) {
            adminlogin = responseList.get(0);        }

        return adminlogin;
    }

    @Override
    public PropertyUser getPropertyUserById(Long id) {
        Session session = getSession();
        PropertyUser propertyUser = (PropertyUser)session.get(PropertyUser.class, id);
        return propertyUser;
    }

    @Override
    public AdminLogin saveOrUpdateAdminUser(AdminLogin adminLogin) {
        return (AdminLogin)persist(adminLogin);
    }

    @Override
    public List<StatusType> getStatusFieldData(String targetForm) {
        Session session = getSession();
        Query query = session.createQuery("from StatusMast s where s.target = :target");
        query.setParameter("target", targetForm);

        List<StatusMast> responseList = query.list();
        List<StatusType> response = new ArrayList<StatusType>();
        if (responseList.size() > 0) {
            for (StatusMast status : responseList) {
                StatusType type = new StatusType();
                type.setStatusId(status.getId());
                type.setName(status.getName());
                response.add(type);
            }
        }
        return response;
    }

    @Override
    public StatusMast getStatusById(Long id) {
        Session session = getSession();
        Query query = session.createQuery("from StatusMast s where s.id = :id");
        query.setParameter("id", id);
        StatusMast response = (StatusMast)query.uniqueResult();
        return response;
    }

    @Override
    public List<AdminLogin> findUsers(String userName) {
        Session session = getSession();
        Criteria cr = session.createCriteria(AdminLogin.class);
        if(userName != null) {
            cr.add(Restrictions.ilike("firstName", userName + "%"));
        }
        List<AdminLogin> results = cr.list();
        return results;
    }

    @Override
    public List<State> findState(String state) {
        Session session = getSession();
        Criteria cr = session.createCriteria(State.class);
        if(fromNullable(state).isPresent()) {
            cr.add(Restrictions.ilike("name", state + "%"));
        }
        List<State> results = cr.list();
        return results;
    }

    @Override
    public List<City> findCity(String city) {
        Session session = getSession();
        Criteria cr = session.createCriteria(City.class);
        if(fromNullable(city).isPresent()) {
            cr.add(Restrictions.ilike("name", city + "%"));
        }
        List<City> results = cr.list();
        return results;
    }

    @Override
    public List<Locations> findLocation(String location) {
        Session session = getSession();
        Criteria cr = session.createCriteria(Locations.class);
        if(fromNullable(location).isPresent()) {
            cr.add(Restrictions.ilike("name", location + "%"));
        }
        List<Locations> results = cr.list();
        return results;
    }

    @Override
    public List<City> findCityByStateId(String stateId) {
        Session session = getSession();
        Query query = session.createQuery("from City c where c.stateByStateId.id = :stateId");
        query.setParameter("stateId", Long.parseLong(stateId));
        List<City> responseList = query.list();
        return responseList;
    }

    @Override
    public List<Locations> findLocationByCityId(String cityId) {
        Session session = getSession();
        Query query = session.createQuery("from Locations l where l.cityByCityId.id = :cityId");
        query.setParameter("cityId", Long.parseLong(cityId));
        List<Locations> responseList = query.list();
        return responseList;
    }

    @Override
    public List<PlanMast> findAdvertisePlan(String planName) {
        Session session = getSession();
        Criteria cr = session.createCriteria(PlanMast.class);
        cr.setFetchMode("userTypeByUserTypeId", FetchMode.JOIN);
        if(fromNullable(planName).isPresent()) {
            cr.add(Restrictions.ilike("name", planName + "%"));
        }
        List<PlanMast> results = cr.list();
        return results;
    }

    @Override
    public City saveOrUpdateCity(City city) {
        return (City)persist(city);
    }

    @Override
    public City updateCity(City city) {
        Session session = getSession();
        City cityForUpdate =  (City)session.get(City.class, city.getId());
        cityForUpdate.setIsPopular(city.getIsPopular());
        cityForUpdate.setName(city.getName());
        session.update(cityForUpdate);
        session.flush();
        return cityForUpdate;
    }
    @Override
    public Locations updateLocation(Locations location) {
        Session session = getSession();
        Locations locationForUpdate =  (Locations)session.get(Locations.class, location.getId());
        locationForUpdate.setName(location.getName());
        locationForUpdate.setPincode(location.getPincode());
        session.update(locationForUpdate);
        session.flush();
        return locationForUpdate;
    }


    @Override
    public PlanMast updatePlan(PlanMast planMast) {
        Session session = getSession();
        PlanMast planForUpdate =  (PlanMast)session.get(PlanMast.class, planMast.getId());
        planForUpdate.setName(planMast.getName());
        planForUpdate.setCost(planMast.getCost());
        planForUpdate.setUserTypeByUserTypeId(findUserTypeById(planMast.getUserTypeId()));
        planForUpdate.setValidDays(planMast.getValidDays());
        planForUpdate.setNumberOfImages(planMast.getNumberOfImages());
        planForUpdate.setDescription(planMast.getDescription());
        session.update(planForUpdate);
        session.flush();
        return planForUpdate;
    }


    @Override
    public Locations saveOrUpdateLocation(Locations location) {
        return (Locations)persist(location);
    }

    @Override
    public List<UserType> getUserType() {
        Session session = getSession();
        Query query = session.createQuery("from UserType");
        List<UserType> response = query.list();
        return response;
    }

    @Override
    public UserType findUserTypeById(Long id) {
        Session session = getSession();
        Query query = session.createQuery("from UserType s where s.id = :id");
        query.setParameter("id", id);
        UserType response = (UserType)query.uniqueResult();
        return response;
    }

    @Override
    public PlanMast saveOrUpdatePlan(PlanMast planMast) {
        return (PlanMast)persist(planMast);
    }

    @Override
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return (Advertisement)persist(advertisement);
    }

    @Override
    public AdvertisementDetails saveAdvertisementDetails(AdvertisementDetails advertisementDetails) {
        return (AdvertisementDetails)persist(advertisementDetails);
    }

    @Override
    public Residential saveResidential(Residential residential) {
        return (Residential)persist(residential);

    }

    @Override
    public PropertyAmenities savePropertyAmenities(PropertyAmenities amenities) {
        return (PropertyAmenities)persist(amenities);
    }

    @Override
    public MorePropertyDetails saveMorePropertyDetails(MorePropertyDetails moreProperty) {
        return (MorePropertyDetails)persist(moreProperty);
    }

    @Override
    public Advertisement updateAdvertisement(Advertisement advertisement) {
        Session session = getSession();
        Advertisement advtForUpdate =  (Advertisement)session.get(Advertisement.class, advertisement.getId());
        session.merge(advertisement);
        session.flush();
        return advtForUpdate;
    }

    @Override
    public GalleryImages saveImage(GalleryImages galleryImage) {
        return (GalleryImages)persist(galleryImage);
    }

    @Override
    public PropertyUser saveOrUpdateUser(PropertyUser user) {
        return (PropertyUser)persist(user);
    }

    @Override
    public PropertyUser updateUserByIdAndMail(Long id, String mailId) {
        Session session = getSession();
        PropertyUser user =  (PropertyUser)session.get(PropertyUser.class, id);
        if(user.getEmailId().equals(mailId)) {
            user.setIsMailVerified("Y");
            session.update(user);
            session.flush();
        }
        return user;
    }

    @Override
    public City findCityById(Long id) {
        Session session = getSession();
        Query query = session.createQuery("from City c where c.id = :id");
        query.setParameter("id", id);
        City response = (City)query.uniqueResult();
        return response;
    }

    @Override
    public City findCityByName(String name) {
        Session session = getSession();
        Query query = session.createQuery("from City c where lower(c.name) = :name");
        query.setParameter("name", name.toLowerCase());
        City response = (City)query.uniqueResult();
        return response;
    }

    @Override
    public Locations findLocationByName(String name) {
        Session session = getSession();
        Query query = session.createQuery("from Locations l where lower(l.name) = :name");
        query.setParameter("name", name.toLowerCase());
        Locations response = (Locations)query.uniqueResult();
        return response;
    }

    @Override
    public State findStateById(Long id) {
        Session session = getSession();
        Query query = session.createQuery("from State s where s.id = :id");
        query.setParameter("id", id);
        State response = (State)query.uniqueResult();
        return response;
    }

    @Override
    public List<PropertyMainType> getPropertyTypes() {
        Session session = getSession();
        Query query = session.createQuery("from PropertyMainType");
        List<PropertyMainType> response = query.list();
        return response;
    }

    @Override
    public List<Budget> getBudgets() {
        Session session = getSession();
        Query query = session.createQuery("from Budget");
        List<Budget> response = query.list();
        return response;
    }

    @Override
    public List<Budget> getBudgetsByPropertyForType(Long pForTypeId) {
        Session session = getSession();
        Query query = session.createQuery("from Budget b where b.propertyForTypeId = :pForTypeId");
        query.setParameter("pForTypeId", pForTypeId);
        List<Budget> response = query.list();
        return response;
    }

    @Override
    public List<Bedroom> getBedrooms() {
        Session session = getSession();
        Query query = session.createQuery("from Bedroom");
        List<Bedroom> response = query.list();
        return response;
    }

    @Override
    public List<PropertyForType> getPropertyForTypes() {
        Session session = getSession();
        Query query = session.createQuery("from PropertyForType");
        List<PropertyForType> response = query.list();
        return response;
    }

    @Override
    public List<FurnishedStatus> getFurnishedStatus() {
        Session session = getSession();
        Query query = session.createQuery("from FurnishedStatus");
        List<FurnishedStatus> response = query.list();
        return response;
    }

    @Override
    public List<Bathroom> getBathrooms() {
        Session session = getSession();
        Query query = session.createQuery("from Bathroom");
        List<Bathroom> response = query.list();
        return response;
    }

    @Override
    public List<Balconies> getBalconies() {
        Session session = getSession();
        Query query = session.createQuery("from Balconies");
        List<Balconies> response = query.list();
        return response;
    }

    @Override
    public List<TotalFloors> getTotalFloors() {
        Session session = getSession();
        Query query = session.createQuery("from TotalFloors");
        List<TotalFloors> response = query.list();
        return response;
    }

    @Override
    public List<UnitMaster> getUnits() {
        Session session = getSession();
        Query query = session.createQuery("from UnitMaster");
        List<UnitMaster> response = query.list();
        return response;
    }

    @Override
    public List<TransactionType> getTransactionTypes() {
        Session session = getSession();
        Query query = session.createQuery("from TransactionType");
        List<TransactionType> response = query.list();
        return response;
    }

    @Override
    public List<PossessionStatus> getPossessionStatus() {
        Session session = getSession();
        Query query = session.createQuery("from PossessionStatus");
        List<PossessionStatus> response = query.list();
        return response;
    }

    @Override
    public List<Terms> getUTerms() {
        Session session = getSession();
        Query query = session.createQuery("from Terms");
        List<Terms> response = query.list();
        return response;
    }

    @Override
    public List<AmenitiesCategory> getAmenitiesCategory() {
        Session session = getSession();
        Query query = session.createQuery("from AmenitiesCategory c order by c.displayOrder");
        List<AmenitiesCategory> response = query.list();
        return response;
    }

    @Override
    public <T> T findObjectById(Long id, Class<T> clazz) {
        Session session = getSession();
        Query query = session.createQuery("from " + clazz.getName() + " t where t.id = :id");
        query.setParameter("id", id);
        T response = (T)query.uniqueResult();
        return response;
    }

    @Override
    public List<Advertisement> searchProperty(SearchType searchType) {
        Session session = getSession();
        Criteria searchCriteria = session.createCriteria(Advertisement.class);
        searchCriteria.createAlias("advertisementDetailsesById", "advertisementDetails");
        searchCriteria.createAlias("morePropertyDetailsesById", "morePropertyDetails", JoinType.LEFT_OUTER_JOIN);
        searchCriteria.createAlias("residentialsById", "residential");
       // searchCriteria.createAlias("planMastByPlanId", "plan");

        searchCriteria.add(Restrictions.eq("isApproved", true));
        searchCriteria.add(Restrictions.sqlRestriction("DATEDIFF(this_.approvedDate, curdate()) < validDays"));

        if (searchType.getSearchString() != null) {
            searchCriteria.add(Restrictions.like("projectName", searchType.getSearchString(), MatchMode.ANYWHERE));
        }

        if (searchType.getLocationId() != null) {
            searchCriteria.add(Restrictions.eq("locationId", searchType.getLocationId()));
        }
        if (searchType.getExpectedPrice() != null && searchType.getExpectedPrice() != -1) {
            Budget budget = findObjectById(searchType.getExpectedPrice(), Budget.class);

            Criterion price1 = Restrictions.between("advertisementDetails.expectedPrice", budget.getFromlevel(), budget.getTolevel());

            Criterion price2 = Restrictions.between("morePropertyDetails.totalCost", budget.getFromlevel(), budget.getTolevel());
            LogicalExpression priceOrExp = Restrictions.or(price1, price2);
            searchCriteria.add(priceOrExp);
        }

        if (searchType.getBedRoomId().size() > 0) {
            Criterion bedroom1 = Restrictions.in("residential.bedRoomId", searchType.getBedRoomId());
            Criterion bedroom2 = Restrictions.in("morePropertyDetails.bedRoomId", searchType.getBedRoomId());
            LogicalExpression priceOrExp = Restrictions.or(bedroom1, bedroom2);
            searchCriteria.add(priceOrExp);
        }

        if (searchType.getUserTypeId() != null && searchType.getUserTypeId() != -1) {
            searchCriteria.add(Restrictions.eq("propertyTypeId", searchType.getUserTypeId()));
        }

        return searchCriteria.list();
    }

    @Override
    public PropertyRequirement saveAlert(PropertyRequirement requirement) {
        return (PropertyRequirement)persist(requirement);
    }

    @Override
    public PreferredBeds savePreferredBeds(PreferredBeds preferredBeds) {
        return (PreferredBeds)persist(preferredBeds);
    }

    @Override
    public List<PossessionOrAge> getPossessionOrAge() {
        Session session = getSession();
        Query query = session.createQuery("from PossessionOrAge");
        List<PossessionOrAge> response = query.list();
        return response;
    }

    @Override
    public List<ImageType> getImageTypes() {
        Session session = getSession();
        Query query = session.createQuery("from ImageType");
        List<ImageType> response = query.list();
        return response;
    }

    @Override
    public List<Advertisement> getAdvertisements(boolean isApproved) {
        Session session = getSession();
        Query query = session.createQuery("from Advertisement a where a.isApproved = " + isApproved);
        List<Advertisement> response = query.list();
        return response;
    }

    @Override
    public PropertyUser getUserByMail(String mailId) {
        Session session = getSession();
        Query query = session.createQuery("from PropertyUser u where lower(u.emailId) = :mailId");
        query.setParameter("mailId", mailId.toLowerCase());
        PropertyUser response = (PropertyUser)query.uniqueResult();
        return response;
    }

    @Override
    public PropertyUser getUserByToken(String token) {
        Session session = getSession();
        Query query = session.createQuery("from PropertyUser u where u.passwordRecoveryToken = :token");
        query.setParameter("token", token);
        PropertyUser response = (PropertyUser)query.uniqueResult();
        return response;
    }

    @Override
    public <T> T deleteObjectById(Long id, Class<T> clazz) {
        Session session = getSession();
        T object = (T)session.load(clazz, id);
        session.delete(object);
        session.flush() ;
        return object;
    }

    @Override
    public PreferredLocations savePreferredLocations(PreferredLocations preferredLocations) {
        return (PreferredLocations)persist(preferredLocations);
    }

    @Override
    public List<Advertisement> getAdvertisementsByUser(Long userId) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Advertisement.class);
        criteria.createAlias("propertyUserByPropertyUserId", "propertyUser");
        criteria.add(Restrictions.eq("propertyUser.id", userId));
        List<Advertisement> results = criteria.list();
        return results;
    }

    @Override
    public PropertyUser updatePropertyUser(PropertyUser propertyUser) {
        Session session = getSession();
        PropertyUser userForUpdate =  (PropertyUser)session.get(PropertyUser.class, propertyUser.getId());
        PropertyUtils.copyFields(propertyUser, userForUpdate);
        userForUpdate.setUserTypeByUserTypeId(findObjectById(propertyUser.getUserTypeId(), UserType.class));
        session.flush();
        return userForUpdate;
    }

    @Override
    public List<PropertyUser> getUsersByDateRange(String fromDate, String toDate) {
        Session session = getSession();
        Query query = session.createQuery("from PropertyUser");// u where  u.registeredDate BETWEEN :stDate AND :edDate");
       // query.setParameter("stDate", fromDate).setParameter("edDate", toDate);
        List<PropertyUser> response = query.list();
        return response;
    }

    @Override
    public List<Advertisement> getAdvertisementsByType(boolean isMicroSite) {
        Session session = getSession();
        Query query = session.createQuery("from Advertisement a where a.isMicroSite = " + isMicroSite);
        List<Advertisement> response = query.list();
        return response;
    }
}
