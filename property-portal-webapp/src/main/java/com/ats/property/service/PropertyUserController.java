package com.ats.property.service;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.dto.*;
import com.ats.property.service.delegate.IPropertyAdminDelegate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

/**
 * The PropertyUserController.
 *
 * @author anbarasan.s
 */
@Controller
public class PropertyUserController implements InitializingBean {

    @Autowired
    IPropertyAdminDelegate adminDelegate;

    @Autowired
    private Environment environment;

    private String fileRootDir = "";

    @RequestMapping(value = {"/authenticateUser" }, method = RequestMethod.POST)
    public ModelAndView authenticateAdmin(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {

        System.out.println("UserName : " + moduleRequest.getStandardAuth().getUsername());
        System.out.println("Password : " + moduleRequest.getStandardAuth().getPassword());
        ModuleList response = CommonHelper.getSuccessModuleList();
        ModelAndView modelAndView = null;
/*        if(adminDelegate.authenticate(moduleRequest, response)) {
            modelAndView = new ModelAndView("admindashboard");
            return  modelAndView;
        } else {
            modelAndView = new ModelAndView("adminlogin");
            modelAndView.addObject("response", response);
            return modelAndView;
        }*/
        return modelAndView;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getAdvertisements(response);
        adminDelegate.getUserType(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/userRegistration" }, method = RequestMethod.GET)
    public ModelAndView showUserRegistration() {
        ModelAndView modelAndView = new ModelAndView("userRegistration");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/registerUser" }, method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModelAndView modelAndView = new ModelAndView("userResponse");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateUser(moduleRequest, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/userLogin" }, method = RequestMethod.GET)
    public ModelAndView showUserLogin() {
        ModelAndView modelAndView = new ModelAndView("userLogin");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

/*
    @RequestMapping(value = {"/authenticateUser" }, method = RequestMethod.POST)
    public ModelAndView authenticateUser(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        System.out.println("UserName : " + moduleRequest.getStandardAuth().getUsername());
        System.out.println("Password : " + moduleRequest.getStandardAuth().getPassword());
        ModuleList response = CommonHelper.getSuccessModuleList();
        ModelAndView modelAndView = null;
        if(adminDelegate.authenticate(moduleRequest, response)) {
            modelAndView = new ModelAndView("postProperty");
            return  modelAndView;
        } else {
            modelAndView = new ModelAndView("adminlogin");
            modelAndView.addObject("response", response);
            return modelAndView;
        }
    }
*/

    @RequestMapping(value = { "/postProperty" }, method = RequestMethod.GET)
    @Secured ({"ROLE_USER"})
    public ModelAndView postProperty(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest,
                                     @ModelAttribute("planId") final String planId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("postProperty");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(null, response);
        adminDelegate.getCityList(null, response);

        adminDelegate.getBedroomsList(response);
        adminDelegate.getAdvertisePlanListByUserType(PropertyAdminService.getCurrentUserTypeId().toString(), response, false);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);

        adminDelegate.getPropertyForTypeList(response);
        adminDelegate.getFurnishedStatusList(response);
        adminDelegate.getBathroomsList(response);
        adminDelegate.getBalconiesList(response);
        adminDelegate.getTotalFloorsList(response);
        adminDelegate.getUnitsList(response);
        adminDelegate.getTransactionTypesList(response);
        adminDelegate.getPossessionStatusList(response);
       // adminDelegate.getPossessionOrAgeList(response);
        adminDelegate.getTermsList(response);
        adminDelegate.getAmenitiesCategory(response);
        modelAndView.addObject("response", response);
        modelAndView.addObject("planId", planId);
        return modelAndView;
    }

    @RequestMapping(value = { "/advertiseWithUs" }, method = RequestMethod.GET)
    public ModelAndView showAdvertiseWithUs(@ModelAttribute("name") final String userType) {
        ModelAndView modelAndView = new ModelAndView("advertiseWithUs");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getUserType(response);
        adminDelegate.getAdvertisePlanListByUserType(userType, response, true);
        modelAndView.addObject("response", response);
        modelAndView.addObject("userType", userType);
        return modelAndView;
    }

    @RequestMapping(value = { "/searchViewPage" }, method = RequestMethod.POST)
    public ModelAndView showSearchViewPage(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {

        ModelAndView modelAndView = new ModelAndView("searchViewPage");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.searchProperty(moduleRequest, response);
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getUserType(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }


    @RequestMapping(value = { "/propertyAlertRegisteration" }, method = RequestMethod.GET)
    public ModelAndView showPropertyAlertRegisteration() {
        ModelAndView modelAndView = new ModelAndView("propertyAlertRegisteration");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(null, response);
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getPropertyForTypeList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getUnitsList(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/projectOverview" }, method = RequestMethod.GET)
    public ModelAndView showProjectOverview(@ModelAttribute("advertisementId") String advertisementId, @ModelAttribute("isMicroSite")Boolean isMicroSite) {
        ModelAndView modelAndView = null;
        if(isMicroSite == null || !isMicroSite) {
            modelAndView = new ModelAndView("projectOverviewClassifieds");
        } else {
            modelAndView = new ModelAndView("projectOverview");
        }
        ModuleList response = CommonHelper.getSuccessModuleList();
        getProjectForOverview(advertisementId, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    private void getProjectForOverview(String advertisementId, ModuleList response) {
        adminDelegate.getAdvertisementById(advertisementId, response);
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getImageTypeList(response);
        adminDelegate.getAmenitiesCategory(response);
    }

    @RequestMapping(value = { "/projectOverviewSample" }, method = RequestMethod.GET)
    public ModelAndView showProjectOverview() {
        ModelAndView modelAndView = new ModelAndView("projectOverviewSample");
        return modelAndView;
    }

    @RequestMapping(value = { "/emiCalculator" }, method = RequestMethod.GET)
    public ModelAndView emiCalculator() {
        ModelAndView modelAndView = new ModelAndView("emiCalculator");
        ModuleList response = CommonHelper.getSuccessModuleList();
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/activateAccount" }, method = RequestMethod.GET)
    public ModelAndView activateAccount(@ModelAttribute("userIdentification") final String userId, @ModelAttribute("userName") final String userMail) {
        ModelAndView modelAndView = new ModelAndView("activateAccountResponse");
        adminDelegate.activateAccount(userMail, userId);
        ModuleList response = CommonHelper.getSuccessModuleList();
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/contactUs" }, method = RequestMethod.GET)
    public ModelAndView contactUs() {
        ModelAndView modelAndView = new ModelAndView("contactUs");
        return modelAndView;
    }

    @RequestMapping(value = { "/feedback" }, method = RequestMethod.GET)
    public ModelAndView feedback() {
        ModelAndView modelAndView = new ModelAndView("feedback");
        return modelAndView;
    }

    @RequestMapping(value = { "/privacyPolicy" }, method = RequestMethod.GET)
    public ModelAndView privacyPolicy() {
        ModelAndView modelAndView = new ModelAndView("privacyPolicy");
        return modelAndView;
    }

    @RequestMapping(value = { "/termsAndConditions" }, method = RequestMethod.GET)
    public ModelAndView termsAndConditions() {
        ModelAndView modelAndView = new ModelAndView("termsAndConditions");
        return modelAndView;
    }

    @RequestMapping(value = { "/postPropertyInMicrosite" }, method = RequestMethod.GET)
    @Secured ({"ROLE_USER"})
    public ModelAndView postPropertyInMicrosite(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest,
                                                @ModelAttribute("planId") final String planId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("postPropertyInMicrosite");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(null, response);
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getAdvertisePlanListByUserType(PropertyAdminService.getCurrentUserTypeId().toString(), response, false);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);

        adminDelegate.getPropertyForTypeList(response);
        adminDelegate.getFurnishedStatusList(response);
        adminDelegate.getBathroomsList(response);
        adminDelegate.getBalconiesList(response);
        adminDelegate.getTotalFloorsList(response);
        adminDelegate.getUnitsList(response);
        adminDelegate.getTransactionTypesList(response);
        adminDelegate.getPossessionStatusList(response);
        // adminDelegate.getPossessionOrAgeList(response);
        adminDelegate.getTermsList(response);
        adminDelegate.getAmenitiesCategory(response);

        modelAndView.addObject("response", response);
        modelAndView.addObject("planId", planId);
        return modelAndView;
    }

    @RequestMapping(value = {"/saveOrUpdateAdvertisement" }, method = RequestMethod.POST)
    public ModelAndView saveOrUpdateAdvertisement(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        System.out.println("PlanId : " + moduleRequest.getAdvertisement().getPlanId());
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateAdvertisement(moduleRequest, response);
        ModelAndView modelAndView = new ModelAndView("redirect:uploadFile?advertisementId=" +
                response.getModule().get(0).getModuleResponse().getAdvertisement().getId() + "&planId=" +
                response.getModule().get(0).getModuleResponse().getAdvertisement().getPlanId());
        return modelAndView;
    }

    @RequestMapping(value = {"/uploadFile" }, method = RequestMethod.GET)
    @Secured ({"ROLE_USER"})
    public ModelAndView uploadFileForAdvertisement(@ModelAttribute("uploadFile") ModuleRequestType moduleRequest,
                                                   @RequestParam("advertisementId") Long advertisementId,
                                                   HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("uploadFile");
        ModuleList response = CommonHelper.getSuccessModuleList();
       // adminDelegate.getPl
        adminDelegate.getImageTypeList(response);

        modelAndView.addObject("response", response);
        modelAndView.addObject("remainingFileCount", adminDelegate.getRemainingImageCount(advertisementId));

        return modelAndView;
    }

    @RequestMapping(value = "/uploadFileAndUpdate", method = RequestMethod.POST)
    public String uploadFileAndUpdateAdvertisement(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("flowFilename") String fileName,
                                                   @RequestParam("advertisementId") Long advertisementId,
                                                   @RequestParam("imageTypeId") Long imageTypeId) {
        if (!file.isEmpty()) {
            String absoluteFileNameAlone =  advertisementId + "_" + fileName;
            String absoluteFileName = fileRootDir + absoluteFileNameAlone;
            try {
                System.out.print("uploadFileAndUpdate FileName >> " + absoluteFileName);
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(absoluteFileName)));
                stream.write(bytes);
                stream.close();
                ModuleList response = CommonHelper.getSuccessModuleList();
                ModuleRequestType moduleRequest = new ModuleRequestType();
                AdvertisementType advertisementType = new AdvertisementType();
                advertisementType.setId(advertisementId);
                advertisementType.setImageTypeId(imageTypeId);
                GalleryImageType imageType = new GalleryImageType();
                imageType.setImageName(absoluteFileNameAlone);
                advertisementType.getGalleryImage().add(imageType);
                moduleRequest.setAdvertisement(advertisementType);
                adminDelegate.updateAdvertisement(moduleRequest, response);
                return "uploadSuccess";
            } catch (Exception e) {
                 System.out.print("Error while saving >> " + absoluteFileName);
                 e.printStackTrace();
                 return "uploadSuccess";
            }
        } else {
            return "uploadSuccess";
        }
    }

    @RequestMapping(value = {"/deleteUploadFile" }, method = RequestMethod.GET)
    public ModelAndView deleteUploadFile(@RequestParam("flowFilename") String fileName, @RequestParam("advertisementId") String advertisementId) {
        System.out.print("fileName>>" + fileName);
        ModelAndView modelAndView = new ModelAndView("uploadFile");
        return modelAndView;
    }

    @RequestMapping(value = {"/advtPostingComplete" }, method = RequestMethod.POST)
    public ModelAndView advtPostingComplete() {
        ModelAndView modelAndView = new ModelAndView("advtPostingComplete");
        return modelAndView;
    }

    @RequestMapping(value = {"/registerPropertyAlert" }, method = RequestMethod.POST)
    public ModelAndView registerPropertyAlert(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModelAndView modelAndView = new ModelAndView("userResponse");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveAlert(moduleRequest, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ex.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("genericErrorpage");
        return modelAndView;
    }

    @RequestMapping(value = {"/userResponse" }, method = RequestMethod.GET)
    public ModelAndView userResponse() {
        ModelAndView modelAndView = new ModelAndView("userResponse");
        return modelAndView;
    }

    @Secured ({"ROLE_USER"})
    @RequestMapping(value = {"/manageAdvertisements" }, method = RequestMethod.GET)
    public ModelAndView manageAdvertisements() {
        ModelAndView modelAndView = new ModelAndView("manageAdvertisements");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getAdvertisementsByUser(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @Secured ({"ROLE_USER"})
    @RequestMapping(value = {"/manageProfile" }, method = RequestMethod.GET)
    public ModelAndView manageProfile() {
        ModelAndView modelAndView = new ModelAndView("manageProfile");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getPropertyUser(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }


    @RequestMapping(value = {"/clientReportView" }, method = RequestMethod.GET)
    public ModelAndView showClientReportView(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
        ModelAndView modelAndView = new ModelAndView("clientReportView");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.showClientReportView(fromDate, toDate, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @Secured ({"ROLE_USER"})
    @RequestMapping(value = {"/modifyAdvertisement" }, method = RequestMethod.GET)
    public ModelAndView modifyAdvertisement(@RequestParam("advertisementId") String advertisementId,  @ModelAttribute("isMicroSite")Boolean isMicroSite) {
        ModelAndView modelAndView = null;
        if(isMicroSite) {
            modelAndView = new ModelAndView("modifyMicrositeAdvt");
        } else {
            modelAndView = new ModelAndView("modifyClassifiedAdvt");
        }

        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getAdvertisementById(advertisementId, response);
        adminDelegate.getStateList(null, response);
        adminDelegate.getCityList(null, response);

        adminDelegate.getBedroomsList(response);
        adminDelegate.getAdvertisePlanListByUserType(PropertyAdminService.getCurrentUserTypeId().toString(), response, false);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);

        adminDelegate.getPropertyForTypeList(response);
        adminDelegate.getFurnishedStatusList(response);
        adminDelegate.getBathroomsList(response);
        adminDelegate.getBalconiesList(response);
        adminDelegate.getTotalFloorsList(response);
        adminDelegate.getUnitsList(response);
        adminDelegate.getTransactionTypesList(response);
        adminDelegate.getPossessionStatusList(response);
        adminDelegate.getTermsList(response);
        adminDelegate.getAmenitiesCategory(response);

        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        fileRootDir = environment.getRequiredProperty("upload.resources.path");
    }
}
