<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Post Property</title>

    <script type="text/javascript" src="appendGrid/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="appendGrid/jquery-ui-1.11.2.min.js"></script>
    <script type="text/javascript" src="appendGrid/jquery.appendGrid-1.6.0.js"></script>

    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/img_upload.css" type="text/css"/>
    <%--
        <script src="js/jquery-1.10.2.min.js"></script>
    --%>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="appendGrid/jquery-ui.structure.min.css"/>
    <link rel="stylesheet" type="text/css" href="appendGrid/jquery-ui.theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="appendGrid/jquery.appendGrid-1.6.0.css"/>

    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll:false });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true });

            function calculateTotalCost() {
                //  alert();
            }
        });
    </script>
    <script src="js/site/postProperty.js"></script>
    <script type="text/javascript" src="js/pop_up_div.js"></script>
</head>
<body>
<form method="post" id="frmPost" commandName="moduleRequest" action="saveOrUpdateAdvertisement">
<input type="hidden" name="advertisement.isMicroSite" value="false">
<main class="main_wrapper clr_fix">
<header class="clr_fix top_head">
    <%@ include file="userHeader.jsp" %>
</header>
<section class="clr_fix sec_main">
<div class="row_main">
<section class="clr_fix">
<nav class="clr_fix step_process">
    <ul>
        <li class="process_1 process_on"> <span>1</span> </li>
        <li class="process_2"> <span>2</span> </li>
        <li class="process_3"> <span>3</span> </li>
    </ul>
</nav>
<div class="clr_fix box-shadow ad_post jq_chk">
<div class="ad_1">
    <ul>
        <li>
            <label>Select Listing Package <small>*</small></label>

            <select class="dropdown" name="advertisement.planId" required>
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.plans}">
                        <option value="${data.id}"
                                <c:if test="${response.module[0].moduleResponse.advertisement.planId eq data.id}"> selected </c:if> >${data.name}</option>
                </c:forEach>
            </select>
        </li>
    </ul>
</div>
<div class="ad_2">
    <h1>Property Info</h1>
    <ul>
        <li>
            <label>Property For
                <small>*</small>
            </label>
            <c:forEach var="data" items="${response.module[0].moduleResponse.propertyForTypes}">
                <span>
                    <input type="radio" id="0${data.id}" value="0${data.id}" name="advertisement.propertyForTypeId"
                           <c:if test="${response.module[0].moduleResponse.advertisement.propertyForTypeId eq data.id}">checked</c:if> required>
                    <label for="0${data.id}"></label>
                    ${data.nameForPoster}
                </span>
            </c:forEach>
        </li>

        <li>
            <label>Property Type<small>*</small></label>
            <div class="search_loc">
                <div class="pro_type">
                    <label id="propertyTypeSelected">Property Type</label> <i class="fa fa-caret-down"></i>
                </div>
                <div class="pro_list">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                        <h1> ${data.name}</h1>
                        <ul>
                            <c:forEach var="innerData" items="${data.propertyTypesById}">
                                <li>
                                    <span class="jq_chk">
                                        <input type="radio" name="advertisement.propertyTypeId" id="${innerData.id}" value="${innerData.id}" required onchange="setPropertyType('${innerData.name}')"
                                               <c:if test="${response.module[0].moduleResponse.advertisement.propertyTypeId eq innerData.id}">
                                               checked
                                               </c:if>
                                        >
                                         <label for="${innerData.id}"></label>
                                    </span>  ${innerData.name}
                                </li>
                                <c:if test="${response.module[0].moduleResponse.advertisement.propertyTypeId eq innerData.id}">
                                    <script>
                                        setPropertyType('${innerData.name}');
                                    </script>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </c:forEach>
                </div>
            </div>
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Location</h1>
    <ul>
        <li>
            <label>State<small>*</small></label>
            <select class="dropdown" id="drpDwnState"  name="drpDwnState" required>
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.states}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>City<small>*</small></label>
            <select id="drpDwnCity" name="drpDwnCity" required>
                <option value="-1">--Select--</option>
            </select>
            <span class="pop_up_icon" pop-model-id="addCityPopup" id="addCityButton"><i class="fa fa-plus-square"></i></span>
        </li>
        <li>
            <label>Location<small>*</small></label>
            <select id="drpDwnLocation" name="advertisement.locationId" required>
                <option value="-1">--Select--</option>
            </select>
            <span class="pop_up_icon" pop-model-id="addLocationPopup" id="addLocationButton"><i class="fa fa-plus-square"></i></span>
        </li>
        <li>
            <label>Address<small>*</small></label>
            <input type="text" placeholder="Address" name="advertisement.address" class="projectname" value="${response.module[0].moduleResponse.advertisement.address}" required>
        </li>
        <%-- <li>
             <label>Company / <br> Builder Name<small>*</small></label>
             <input type="text" placeholder="Builder Name" name="advertisement.builderName" class="projectname" required>
         </li>--%>
    </ul>
</div>

<div class="pro_feat">
    <h1>Property Features</h1>
    <ul class="drop_size_1 drop_size_2">
        <li class="col_2_text">
            <label>Builtup Area<small>*</small></label>
            <input type="text" placeholder="Buildup Area" name="advertisement.buildupArea" value="${response.module[0].moduleResponse.advertisement.buildupArea}" required>
            <select class="dropdown" name="advertisement.buildupAreaUnitId" required>
                <c:forEach var="data" items="${response.module[0].moduleResponse.units}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.buildupAreaUnitId eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li class="list_3">
            <label> Bed Rooms<small>*</small></label>
            <select placeholder="Select Bed Rooms" class="dropdown" name="advertisement.bedRoomId" required>
                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.bedRoomId eq data.id}"> selected </c:if> >${data.name}</option>
                </c:forEach>
            </select>

            <label> Bath Rooms<small>*</small></label>
            <select  placeholder="Select Bath Rooms" class="dropdown" name="advertisement.bathRoomId" required>
                <c:forEach var="data" items="${response.module[0].moduleResponse.bathrooms}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.bathRoomId eq data.id}"> selected </c:if> >${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Furnished Status<small>*</small></label>
            <select class="dropdown" name="advertisement.furnishedStatusId" required>
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.furnishedStatus}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.furnishedStatusId eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>

            <label>Balconies</label>
            <select class="dropdown" name="advertisement.balconyId" >
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.balconies}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.balconyId eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Floor No.</label>
            <select class="dropdown" name="advertisement.propertyOnFloorId">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.propertyOnFloorId eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>

            <label>Total Floors<small>*</small></label>
            <select class="dropdown" name="advertisement.totalFloor" required>
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.totalFloor eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Availability</h1>
    <ul>
        <li>
            <label>Availability<small>*</small></label>
            <c:forEach var="data" items="${response.module[0].moduleResponse.possessionStatus}">
                <span>
                    <input type="radio" id="possessionStatus${data.id}" value="000${data.id}" name="advertisement.possessionStatusId"
                    <c:if test="${response.module[0].moduleResponse.advertisement.possessionStatusId eq data.id}"> checked </c:if>required>
                    <label for="possessionStatus${data.id}"></label>
                    ${data.name}
                </span>
            </c:forEach>
        </li>
        <li>
            <label>Possession of Property<small>*</small></label>
            <select id="drpPossessionOrAge" name="advertisement.possessionOrAgeId" required>
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.possessionOrAge}">
                    <option value="${data.id}"
                            <c:if test="${response.module[0].moduleResponse.advertisement.possessionOrAgeId eq data.id}"> selected </c:if>>${data.name}</option>
                </c:forEach>
            </select>
        </li>
    </ul>
</div>
<div class="pro_chk_list">
    <h1>Property Features and Amenities</h1>
    <c:forEach var="data" items="${response.module[0].moduleResponse.amenitiesCategory}">
        <nav>
            <ul>
                <c:set var="amenitiesList" value="${response.module[0].moduleResponse.advertisement.propertyAmenitiesMap[data.id]}"/>
                <c:forEach var="innerData" items="${data.amenitiesesById}">
                    <li>
                        <input type="checkbox" name="advertisement.propertyAmenities" id="00${innerData.id}" value="${innerData.id}"
                          <c:forEach var="obj" items="${amenitiesList}" ><c:if test="${obj.id eq innerData.id}"> checked </c:if></c:forEach>
                        >
                        <label for="00${innerData.id}"></label>${innerData.name}
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </c:forEach>
</div>
<div class="ad_3 ">
    <h1>Rent & Other Charges</h1>
    <ul>
        <li class="ad_col_1">
            <label>Expected Rent <small>*</small></label>
                <span>
                <label> Lakhs </label>
                <i class="fa fa-inr fa-2x"></i> &nbsp;<select class="dropdown" id="denominationLakhs">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="99" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span>
                <label> Thousands </label>
                <select class="dropdown" id="denominationThousands">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="99" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span>
                <label> Hundreds </label>
                <select class="dropdown" id="denominationHundreds">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="9" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span>
                <label> &nbsp;</label>
                Or
                <input type="text" placeholder="Enter price" name="advertisement.expectedPrice" id="expectedPrice" value="${response.module[0].moduleResponse.advertisement.expectedPrice}" required>
                </span> </li>
        <li class="col_2_text">
            <label>Maintanance Charges</label>
            <i class="fa fa-inr fa-2x"></i> &nbsp;<span><input type="text" placeholder="Maintenance Charges" name="advertisement.maintenanceCharges" value="${response.module[0].moduleResponse.advertisement.maintenanceCharges}">
                        </span> <span>
                        <select class="dropdown" name="advertisement.maintenancePeriodId">
                            <c:forEach var="data" items="${response.module[0].moduleResponse.terms}">
                                <option value="${data.id}"
                                        <c:if test="${response.module[0].moduleResponse.advertisement.maintenancePeriodId eq data.id}"> selected </c:if>>${data.name}</option>
                            </c:forEach>
                        </select>
                        </span>
        </li>
        <li>
            <label>Security Deposit</label>
            <i class="fa fa-inr fa-2x"></i> &nbsp;<input type="text" placeholder="Security Deposit" name="advertisement.securityDeposit" value="${response.module[0].moduleResponse.advertisement.securityDeposit}">
        </li>
        <li class="check_brok">
            <label>Response from brokers</label>
                <span>
                <input type="checkbox" id="new_1" name="advertisement.responseFromBrokers"
                       value="${response.module[0].moduleResponse.advertisement.responseFromBrokers}"
                       <c:if test="${response.module[0].moduleResponse.advertisement.responseFromBrokers eq 1}"> checked </c:if>>
                <label for="new_1"></label>
                </span> I am not interested in getting response from brokers </li>
    </ul>
</div>

<div class="pro_desc">
    <h1>Property Description</h1>
    <ul>
        <li>
            <label>Name of Project / Title <small>*</small></label>
            <input type="text" name="advertisement.projectName" class="projectname" required value="${response.module[0].moduleResponse.advertisement.projectName}">
        </li>
        <li>
            <label>Description<small>*</small></label>
            <textarea name="advertisement.description" cols="80" rows="6" required>${response.module[0].moduleResponse.advertisement.description}</textarea>
        </li>
    </ul>
</div>

<div class="ad_3">
    <h1> Terms & Conditions </h1>
    <ul>
        <li>
            <div class="add_block">
                <ul>
                    <li class="agree_form">
                        <input type="checkbox" id="check_45" name="advertisement.isTermsAgreed"
                               value="${response.module[0].moduleResponse.advertisement.isTermsAgreed}"
                               <c:if test="${response.module[0].moduleResponse.advertisement.isTermsAgreed eq 1}"> checked </c:if>
                               required>
                        <label for="check_45"></label>
                        <p> I am the owner/I have the authority to post this property.
                            I agree not to provide incorrect property information or state a discriminatory preference.
                            In case, the information does not comply with 1AcreIndia terms, 1AcreIndia.com has the right to edit/remove the property from their site. </p>
                    </li>
                </ul>
            </div>
        </li>
        <li class="text_center">
            <input type="submit" class="btn_5" value="Update">
        </li>
    </ul>
</div>
</div>
</section>
</div>
</section>
</section>
<!-- footer start -->
<footer class="clr_fix foot_main">
    <%@ include file="userFooter.jsp" %>
</footer>
<!-- footer end -->
</main>
</form>
<div  id="addCityPopup" class="modal-box" style="width:40%">
    <div class="md-content pop_up_reg">
        <h1 class="h_2">Add City</h1>
        <i class="fa fa-times js-modal-close"></i>
        <div class="user_register jq_chk">
            <ul>
                <li>
                    <label>City<small>*</small></label>
                    <input type="text" id="txtCity" placeholder="City">
                </li>
                <input type="button" class="btn_5" value="Add" name="addCity" id="addCity">
                </li>
            </ul>
        </div>
    </div>
</div>

<div  id="addLocationPopup" class="modal-box" style="width:40%">
    <div class="md-content pop_up_reg">
        <h1 class="h_2">Add Location</h1>
        <i class="fa fa-times js-modal-close"></i>
        <div class="user_register jq_chk">
            <ul>
                <li>
                    <label>Location<small>*</small></label>
                    <input type="text" placeholder="Location" id="txtLocation">
                </li>
                <input type="button" class="btn_5" value="Add" id="addLocation" name="addLocation">
                </li>
            </ul>
        </div>
    </div>
</div>

</div>

<!--script start-->
<!-- tab script start-->
<script type="text/javascript">
    $(document).ready(function (){
        $('.text_panel input[type="text"]').click(function(){
            $('.loc_list').slideDown(300);
        })
        $('.pro_type').click(function(){
            $('.pro_list').slideToggle();
        })


        $('.top_loc_list a').click(function(){
            $('.loc_list_view').slideToggle();
        });


        $('.tab_1').click(function (){
            $('.tab_menu li').removeClass('tab_active')
            $(this).addClass('tab_active')
            $('.tab_view').hide();
            $('.tab_info_1').fadeIn();

        });
        $('.tab_2').click(function (){
            $('.tab_menu li').removeClass('tab_active')
            $(this).addClass('tab_active')
            $('.tab_view').hide();
            $('.tab_info_2').fadeIn();
        });

        $('.tab_3').click(function (){
            $('.tab_menu li').removeClass('tab_active')
            $(this).addClass('tab_active')
            $('.tab_view').hide();
            $('.tab_info_3').fadeIn();
        });
    });
</script>
<!-- tab script end -->
<!-- Image navigation start-->
<script src="js/owl.carousel.js"></script>
<script type="text/javascript">
    $('.owl-carousel').owlCarousel({
        loop:true,
        margin:20,
        nav:true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:3
            },
            1000:{
                items:4
            }
        }
    })

</script>
<!-- tab menu start -->
<script type="text/javascript">

    $(document).ready(function() {

        $(".tab_content").hide();
        $(".tab_content:first").show();

        $("ul.tabs li").click(function() {
            $("ul.tabs li").removeClass("upload_active");
            $(this).addClass("upload_active");
            $(".tab_content").hide();
            var activeTab = $(this).attr("rel");
            $("#"+activeTab).fadeIn();
        });
    });


    $(document).ready(function() {

        $(".tab_content_2").hide();
        $(".tab_content_2:first").show();

        $("ul.tabs_2 li").click(function() {
            $("ul.tabs_2 li").removeClass("inner_tab_active");
            $(this).addClass("inner_tab_active");
            $(".tab_content_2").hide();
            var activeTab = $(this).attr("rel");
            $("#"+activeTab).fadeIn();
        });
    });

</script>
<!-- tab menu end -->
<!-- script image upload -->
<script src="js/angular.js"></script>
<script src="js/flow.js"></script>
<script src="js/fusty-flow-factory.js"></script>
<script src="js/ng-flow.js"></script>
<script src="js/app.js"></script>
<!-- script image upload -->
<!--script end-->
</body>
</html>
