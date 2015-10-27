package com.ats.property.service;

import com.ats.property.common.constants.CommonHelper;
import com.ats.property.dto.ModuleList;
import com.ats.property.dto.ModuleRequestType;
import com.ats.property.dto.NameDataType;
import com.ats.property.service.delegate.IPropertyAdminDelegate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * The PropertyAdminController.
 *
 * @author anbarasan.s
 */
@Controller
public class PropertyAdminController implements InitializingBean{

    @Autowired
    IPropertyAdminDelegate adminDelegate;

    @Autowired
    private Environment environment;

    private String fileRootDir = "";

    @Override
    public void afterPropertiesSet() throws Exception {
        fileRootDir = environment.getRequiredProperty("upload.resources.path");
    }

    /** Admin Pages Start*/
    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public String showAdminLogin() {
        return "adminlogin";
    }

    @RequestMapping(value = { "/adminLogout" }, method = RequestMethod.GET)
    public String showAdminLogout() {
        return "adminlogin";
    }

    @RequestMapping(value = { "/admindashboard" }, method = RequestMethod.GET)
    public String showAdminHome() {
        return "admindashboard";
    }

    @RequestMapping(value = { "/adminUserCreation" }, method = RequestMethod.GET)
    public ModelAndView showAdminUserCreation() {
        ModelAndView modelAndView = new ModelAndView("adminUserCreation");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStatusFieldData(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/createUpdateCity" }, method = RequestMethod.GET)
    public ModelAndView showCreateUpdateCity() {
        ModelAndView modelAndView = new ModelAndView("createUpdateCity");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(null, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/createUpdateLocation" }, method = RequestMethod.GET)
    public ModelAndView showCreateUpdateLocation() {
        ModelAndView modelAndView = new ModelAndView("createUpdateLocation");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getCityList(null, response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/createAdvertisePlan" }, method = RequestMethod.GET)
    public ModelAndView showCreateAdvertisePlan() {
        ModelAndView modelAndView = new ModelAndView("createAdvertisePlan");
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getUserType(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }

    @RequestMapping(value = { "/advertisementApproval" }, method = RequestMethod.GET)
    public String showAdvertisementApproval() {
        return "advertisementApproval";
    }

    @RequestMapping(value = { "/locationApproval" }, method = RequestMethod.GET)
    public String showaLocationApproval() {
        return "locationApproval";
    }

    @RequestMapping(value = { "/clientReport" }, method = RequestMethod.GET)
    public String showaClientReport() {
        return "clientReport";
    }

    @RequestMapping(value = { "/advertisementReport" }, method = RequestMethod.GET)
    public String showaAdvertisementReport() {
        return "advertisementReport";
    }

    @RequestMapping(value = {"/authenticateAdmin" }, method = RequestMethod.POST)
    public ModelAndView authenticateAdmin(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {

        System.out.println("UserName : " + moduleRequest.getStandardAuth().getUsername());
        System.out.println("Password : " + moduleRequest.getStandardAuth().getPassword());
        ModuleList response = CommonHelper.getSuccessModuleList();
        ModelAndView modelAndView = null;
        if(adminDelegate.authenticate(moduleRequest, response)) {
            modelAndView = new ModelAndView("admindashboard");
            return  modelAndView;
        } else {
            modelAndView = new ModelAndView("adminlogin");
            modelAndView.addObject("response", response);
            return modelAndView;
        }
    }

    @RequestMapping(value = { "/saveOrUpdateAdminUser" }, method = RequestMethod.POST)
    public ModelAndView saveOrUpdateAdminUser(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateAdminUser(moduleRequest, response);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("adminUserCreation");
        return  modelAndView;
    }


    @RequestMapping(value = { "/saveOrUpdateCity" }, method = RequestMethod.POST)
    public ModelAndView saveOrUpdateCity(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.getStateList(null, response);
        adminDelegate.saveOrUpdateCity(moduleRequest, response);
        ModelAndView modelAndView = new ModelAndView("createUpdateCity");
        adminDelegate.getStateList(null, response);
        return  modelAndView;
    }

    @RequestMapping(value = { "/saveOrUpdateLocation" }, method = RequestMethod.POST)
    public ModelAndView saveOrUpdateLocation(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdateLocation(moduleRequest, response);
        adminDelegate.getCityList(null, response);
        ModelAndView modelAndView = new ModelAndView("createUpdateLocation");
        modelAndView.addObject("response", response);
        return  modelAndView;
    }

    @RequestMapping(value = { "/saveOrUpdateAdvertisePlan" }, method = RequestMethod.POST)
    public ModelAndView saveOrUpdateAdvertisePlan(@ModelAttribute("moduleRequest") ModuleRequestType moduleRequest) {
        ModuleList response = CommonHelper.getSuccessModuleList();
        adminDelegate.saveOrUpdatePlan(moduleRequest, response);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("createAdvertisePlan");
        adminDelegate.getUserType(response);
        modelAndView.addObject("response", response);
        return modelAndView;
    }


    /** Admin Pages End*/

    @RequestMapping(value = { "/dnd" }, method = RequestMethod.GET)
    public String showDND(ModelMap model) {
        return "dnd";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody NameDataType handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("hiddenFieldName") String hiddenFieldName){
        String fileName = file.getOriginalFilename();
        NameDataType response = new NameDataType();
        response.setName(fileName);
        response.setLabel(hiddenFieldName);
        fileName = fileRootDir + "_" + fileName;
        System.out.print("uploadFileAndUpdate FileName >> " + fileName);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                stream.write(bytes);
                stream.close();
                return response;
            } catch (Exception e) {
                System.out.print("Error while saving >> " + fileName);
                e.printStackTrace();
                return response;
            }
        } else {
            return response;
        }
    }

    /**  Adminn Login using spring security*/
/*    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;*/

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("adminlogin");

        return model;

    }

    //customize the error message
    private String getErrorMessage(HttpServletRequest request, String key){

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        }else if(exception instanceof LockedException) {
            error = exception.getMessage();
        }else{
            error = "Invalid username and password!";
        }

        return error;
    }


    @RequestMapping(value = { "/403" }, method = RequestMethod.GET)
    public ModelAndView accesssDenied(HttpServletRequest request) {
        System.out.println(">>>" + request.isUserInRole("ADMIN"));
        ModelAndView model = new ModelAndView();
        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }
    // for 403 access denied page
}
