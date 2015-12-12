package com.ats.property.service;


import com.ats.property.common.CommonServiceHelper;
import com.ats.property.common.constants.CommonHelper;
import com.ats.property.dto.CountryType;
import com.ats.property.dto.ModuleList;
import com.ats.property.dto.ModuleRequestType;
import com.ats.property.model.sample.DummyDB;
import com.ats.property.service.delegate.IPropertyAdminDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * The PropertyAdminWebService.
 *
 * @author anbarasan.s
 */

@Path("/v1/{a:admin.json|admin.xml|admin}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PropertyAdminWebService {

    @Autowired
    IPropertyAdminDelegate adminDelegate;

    public void init() {
        Assert.notNull(adminDelegate, "adminDelegate must be non-null");

        System.out.println("PropertyAdminWebService Initialzed");
    }

    @POST
    @Path("/modules/create")
    public ModuleList create() {
        return CommonHelper.getSuccessModuleList();
    }

    @POST
    @Path("/modules/modify")
    public ModuleList modify() {
        return new ModuleList();
    }

    @POST
    @Path("/modules/get")
    public ModuleList get() {
        return new ModuleList();
    }

    @POST
    @Path("/modules/delete")
    public ModuleList delete() {
        return CommonHelper.getSuccessModuleList();
    }

    @POST
    @Path("/modules/create/authenticate")
    public ModuleList authenticate() {
        ModuleRequestType moduleRequest = null;
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.authenticate(moduleRequest, response);
        return response;
    }

    @GET
    @Path("/modules/get/userList")
    public ModuleList getUserList(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getUserList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/stateList")
    public ModuleList getStateList(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/cityList")
    public ModuleList getCityList(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/locationList")
    public ModuleList getLocationList(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getLocationList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/advertisePlanList")
    public ModuleList getAdvertisePlanList(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getAdvertisePlanList(key, response, false);
        return response;
    }

    @GET
    @Path("/modules/get/advertisementForApproval")
    public ModuleList getAdvertisementForApproval(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getUserList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/locationForApproval")
    public ModuleList getLocationForApproval(@QueryParam("searchKey") String key) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getUserList(key, response);
        return response;
    }

    @GET
    @Path("/modules/get/stateByCityId")
    public ModuleList getStateByCityId(@QueryParam("stateId") String stateId) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityByStateId(stateId, response);
        return response;
    }

    @GET
    @Path("/modules/get/locationByCityId")
    public ModuleList getLocationByCityId(@QueryParam("locationId") String locationId) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getLocationByCityId(locationId, response);
        return response;
    }

    @GET
    @Path("/modules/get/possessionByAvailabilityId")
    public ModuleList getPossessionByAvailabilityId(@QueryParam("availabilityId") Long availabilityId) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getPossessionOrAgeList(availabilityId, response);
        return response;
    }

    @GET
    @Path("/modules/get/budgetByPropertyForTypeId")
    public ModuleList getBudgetByPropertyForType(@QueryParam("propertyForTypeId") Long propertyForTypeId) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getBudgetsByPropertyForType(response, propertyForTypeId);
        return response;
    }

    @GET
    @Path("/modules/get/advertisementsForApprove")
    public ModuleList getAdvertisementsForApproval(@QueryParam("status") String status) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getAdvertisementsForApproval(status, response);
        return response;
    }

    @POST
    @Path("/modules/update/approveOrRejectAdvertisements")
    public ModuleList approveOrRejectAdvertisements(ModuleRequestType request) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.approveOrRejectAdvertisements(request, response);
        return response;
    }

    @GET
    @Path("/modules/get/getAdvertisement")
    public ModuleList getAdvertisementById(@QueryParam("advertisementId") String advertisementId) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getAdvertisementById(advertisementId, response);
        return response;
    }

    @POST
    @Path("/modules/create/registerUser")
    @Consumes("application/json")
    public ModuleList registerUser(ModuleRequestType moduleRequest) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateUser(moduleRequest, response);
        return response;
    }



    //Sample starts here.............................

    private static DummyDB dummyDB = new DummyDB();

    @GET
    @Path("/modules/get/countryList")
    public ModuleList getCountryList(@QueryParam("searchKey") String query) {
        List<String[]> countryList = dummyDB.getCountryList(query);
        List<CountryType> countries = new ArrayList<CountryType>();
        for(String[] country : countryList) {
            if(country[1].toLowerCase().startsWith(query)) {
                CountryType cntry = new CountryType();
                cntry.setId(country[0]);
                cntry.setName(country[1]);
                countries.add(cntry);
            }
        }
        ModuleList moduleList = CommonServiceHelper.getModuleListWithData(countries);
        return moduleList;

    }

    @GET
    @Path("/modules/get/techList")
    public List<String> getTechList(@RequestParam("term") String query) {
        List<String> countryList = dummyDB.getTechList(query);

        return countryList;
    }

    //Sample ends here.............................
}
