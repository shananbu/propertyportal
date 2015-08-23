package com.ats.property.service;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.dto.ModuleList;
import com.ats.property.dto.ModuleRequestType;
import com.ats.property.service.delegate.IPropertyAdminDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The PropertyUserController.
 *
 * @author anbarasan.s
 */
@Controller
public class PropertyUserController {

    @Autowired
    IPropertyAdminDelegate adminDelegate;


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
        ModelAndView modelAndView = new ModelAndView("userRegistration");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateUser(moduleRequest, response);
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
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

    @RequestMapping(value = { "/postProperty" }, method = RequestMethod.GET)
    public ModelAndView postProperty(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModelAndView modelAndView = new ModelAndView("postProperty");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getAdvertisePlanList(null, response, false);
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

        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/advertiseWithUs" }, method = RequestMethod.GET)
    public ModelAndView showAdvertiseWithUs() {
        ModelAndView modelAndView = new ModelAndView("advertiseWithUs");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        adminDelegate.getAdvertisePlanList(null,response, true);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/searchViewPage" }, method = RequestMethod.GET)
    public ModelAndView showSearchViewPage() {
        ModelAndView modelAndView = new ModelAndView("searchViewPage");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }


    @RequestMapping(value = { "/propertyAlertRegisteration" }, method = RequestMethod.GET)
    public ModelAndView showPropertyAlertRegisteration() {
        ModelAndView modelAndView = new ModelAndView("propertyAlertRegisteration");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/projectOverview" }, method = RequestMethod.GET)
    public ModelAndView showProjectOverview() {
        ModelAndView modelAndView = new ModelAndView("projectOverview");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        adminDelegate.getBedroomsList(response);
        adminDelegate.getBudgetList(response);
        adminDelegate.getPropertyTypeList(response);
        modelAndView.addObject("response", response);
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
    public ModelAndView activateAccount(HttpServletRequest request) {
        String userId = request.getParameter("userIdentification");
        String userMail = request.getParameter("userName");
        ModelAndView modelAndView = new ModelAndView("activateAccountResponse");
        adminDelegate.activateAccount(userId, userMail);
        ModuleList response = CommonHelper.getSuccessModuleList();
        modelAndView.addObject("response", response);
        return modelAndView;
    }
}
