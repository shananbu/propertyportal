<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Post Property In Microsite</title>

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
    <link rel="stylesheet" type="text/css" href="css/fileUpload.css"/>

    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll:false });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true });

            <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
            <c:set var="options" value="${options} ${data.id}  :  ${data.name} ;" />
            </c:forEach>

            // Initialize appendGrid
            $('#tblAppendGrid').appendGrid({
                initRows: 1,
                maxRowsAllowed : 10,
                columns: [
                    { name: 'advertisement.moreProperty[].bedRoomId', display: 'Type', type: 'select', ctrlOptions: "${fn:substring(options, 0, (fn:length(options) - 1) )}", ctrlAttr: { maxlength: 70 }/*, ctrlCss: { width: '100px'}*/ },
                    { name: 'advertisement.moreProperty[].area', onChange: calculateTotalCost, display: 'Area (Sq.ft)', type: 'text', ctrlAttr: { maxlength: 5 }/*, ctrlCss: { width: '100px'}*/ },
                    { name: 'advertisement.moreProperty[].pricePerUnitArea',onChange: calculateTotalCost, display: 'Rate (Per sq.ft)', type: 'text', ctrlAttr: { maxlength: 5 }/*, ctrlCss: { width: '100px'} */},
                    { name: 'advertisement.moreProperty[].totalCost', display: 'Total Cost', type: 'text', ctrlAttr: { maxlength: 10 }/*, ctrlCss: { width: '100px'} */},
                    { name: 'advertisement.moreProperty[].floorPlanFileNameTd', display: 'Floor Plan', type: 'custom', ctrlAttr: { maxlength: 4 },
                        customBuilder:  function (cell, idPrefix, name, uniqueIndex) {
                            $('<div id="imagePreview' + uniqueIndex + '"></div>' +
                                    '<input type="hidden" id="floorPlanFileName' + uniqueIndex + '" name="advertisement.moreProperty[' + uniqueIndex + '].floorPlanFileName">' +
                                    '<input id="uploadFile' + uniqueIndex + '" type="file" name="floorPlanImage' + uniqueIndex + '" class="floorPlanImage"/>' +
                                    '<div id="status' + uniqueIndex + '"></div>').appendTo(cell);
                        }/*,
                     customGetter: function (idPrefix, name, uniqueIndex) {

                     },
                     customSetter: function (idPrefix, name, uniqueIndex, value) {

                     }*/
                    }
                ]
            });

            function calculateTotalCost() {
                //  alert();
            }
        });
    </script>
    <script src="js/site/postProperty.js"></script>
    <script src="js/site/fileUploader.js"></script>
    <script type="text/javascript" src="js/pop_up_div.js"></script>
</head>
<body>
<form method="post" id="frmPost" commandName="moduleRequest" action="saveOrUpdateAdvertisement">
<input type="hidden" name="advertisement.isMicroSite" value="true">
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
                            <c:if test="${planId eq data.id}"> selected </c:if> >${data.name}</option>
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
                <c:if test="${data.nameForPoster eq 'Sale'}">
                    <span>
                        <input type="radio" id="0${data.id}" value="0${data.id}" name="advertisement.propertyForTypeId" checked required>
                        <label for="0${data.id}"></label>
                        ${data.nameForPoster}
                    </span>
                </c:if>
            </c:forEach>
            <%--          <span>
                          <input type="radio" id="radio_1" name="1" checked>
                          <label for="radio_1"></label>
                          Sale
                      </span>
                      <span>
                          <input type="radio" id="radio_2" name="1">
                          <label for="radio_2"></label>
                          Rent
                      </span>
                      <span>
                          <input type="radio" id="radio_3" name="1">
                          <label for="radio_3"></label>
                          PG Accommodation
                      </span>--%>
        </li>

        <li>
            <label>Property Type <small>*</small></label>
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
                                        <input type="radio" name="advertisement.propertyTypeId" id="${innerData.id}" value="${innerData.id}" required onchange="setPropertyType('${innerData.name}')">
                                         <label for="${innerData.id}"></label>
                                    </span>  ${innerData.name}
                                </li>
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
            <input type="text" placeholder="Address" name="advertisement.address" class="projectname" required>
        </li>
        <%--        <li>
                    <label>Company /<br> Builder Name<small>*</small></label>
                    <input type="text" placeholder="Builder Name" name="advertisement.builderName" class="projectname" required>
                </li>--%>
    </ul>
</div>

<%--<div class="pro_feat">
    <h1>Property Features</h1>
    <ul class="drop_size_1">
        <li class="col_2_text">
            <label>Builtup Area</label>
            <input type="text" placeholder="Buildup Area" name="advertisement.buildupArea">
            <select class="dropdown" name="advertisement.buildupAreaUnitId">
                <c:forEach var="data" items="${response.module[0].moduleResponse.units}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li class="list_3">
            <label> Bed Rooms</label>
            <select placeholder="Select Bed Rooms" class="dropdown" name="advertisement.bedRoomId">
                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>

            <label> Bath Rooms</label>
            <select  placeholder="Select Bath Rooms" class="dropdown" name="advertisement.bathRoomId">
                <c:forEach var="data" items="${response.module[0].moduleResponse.bathrooms}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Furnished Status</label>
            <select class="dropdown" name="advertisement.furnishedStatusId">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.furnishedStatus}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>

            <label>Balconies</label>
            <select class="dropdown" name="advertisement.balconyId">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.balconies}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Floor No</label>
            <select class="dropdown" name="advertisement.propertyOnFloorId">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>

            <label>Total Floors</label>
            <select class="dropdown" name="advertisement.totalFloor">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
    </ul>
</div>--%>
<div class="ad_3">
    <h1>Availability</h1>
    <ul>
        <li>
            <label>Availability<small>*</small></label>
            <c:forEach var="data" items="${response.module[0].moduleResponse.possessionStatus}">
                <span>
                    <input type="radio" id="possessionStatus${data.id}" value="000${data.id}" name="advertisement.possessionStatusId" required>
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
                    <option value="${data.id}">${data.name}</option>
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
                <c:forEach var="innerData" items="${data.amenitiesesById}">
                    <li>
                        <input type="checkbox" name="advertisement.propertyAmenities" id="00${innerData.id}" value="${innerData.id}">
                        <label for="00${innerData.id}"></label>${innerData.name}
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </c:forEach>
</div>
<%--<div class="ad_3 ">
    <h1>Rent & Other Charges</h1>
    <ul>
        <li class="ad_col_1">
            <label>Expected Rent </label>
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
                <input type="text" placeholder="Enter price" name="advertisement.expectedPrice" id="expectedPrice">
                </span> </li>
        <li class="col_2_text">
            <label>Maintanance Charges</label>
            <i class="fa fa-inr fa-2x"></i> &nbsp;<span><input type="text" placeholder="Maintenance Charges" name="advertisement.maintenanceCharges">
                        </span> <span>
                        <select class="dropdown" name="advertisement.maintenancePeriodId">
                            <c:forEach var="data" items="${response.module[0].moduleResponse.terms}">
                                <option value="${data.id}">${data.name}</option>
                            </c:forEach>
                        </select>
                        </span>
        </li>
        <li>
            <label>Security Deposit</label>
            <i class="fa fa-inr fa-2x"></i> &nbsp;<input type="text" placeholder="Security Deposit" name="advertisement.securityDeposit">
        </li>
        <li class="check_brok">
            <label>Response from brokers</label>
                <span>
                <input type="checkbox" id="new_1" name="advertisement.responseFromBrokers" value="1">
                <label for="new_1"></label>
                </span> I am not interested in getting response from brokers </li>
    </ul>
</div>--%>
<div class="unit_left clr_fix appen_grid">
    <h1>More properties </h1>
    <div class="appendGrid">
        <table id="tblAppendGrid"></table>
    </div>
    <span> <b> OR </b> Upload PDF file <input type="file" class="morePropertiesFile" id="morePropertiesFile">
    <input type="hidden" id="morePropertiesFileName" name="advertisement.morePropertiesFileName"></span>
</div>
<div class="pro_desc">
    <h1>Property Description</h1>
    <ul>
        <li>
            <label>Name of Project / Title<small>*</small></label>
            <input type="text" name="advertisement.projectName" class="projectname" required>
        </li>
        <li>
            <label>Description<small>*</small></label>
            <textarea name="advertisement.description" cols="80" rows="6" required></textarea>
            <b>OR</b>Upload PDF/Excel file<input type="file" class="descriptionFile" id="descriptionFile">
            <input type="hidden" id="descriptionFileName" name="advertisement.descriptionFileName">
        </li>
        <li>
            <label>Specification<small>*</small></label>
            <textarea name="advertisement.propertyFeatures" cols="80" rows="6" required></textarea>
            <b>OR</b>Upload PDF/Excel file<input type="file" class="specificationFile" id="specificationFile">
            <input type="hidden" id="specificationFileName" name="advertisement.specificationFileName">
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
                        <input type="checkbox" id="check_45" name="advertisement.isTermsAgreed" value="1" required>
                        <label for="check_45"></label>
                        <p> I am the owner/I have the authority to post this property.
                            I agree not to provide incorrect property information or state a discriminatory preference.
                            In case, the information does not comply with 1AcreIndia terms, 1AcreIndia.com has the right to edit/remove the property from their site. </p>
                    </li>
                </ul>
            </div>
        </li>
        <li class="text_center">
            <input type="submit" class="btn_5" value="Proceed & Upload Gallery">
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
