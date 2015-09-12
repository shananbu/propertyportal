<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Post Property</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/img_upload.css" type="text/css"/>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>

    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll:false });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true });
        });
    </script>
    <script src="js/site/postProperty.js"></script>
</head>
<body>
<form method="post" id="frmPost" commandName="moduleRequest" action="saveOrUpdateAdvertisement">
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

            <select class="dropdown" name="advertisement.planId">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.plans}">
                    <option value="${data.id}">${data.name}</option>
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
                    <input type="radio" id="0${data.id}" value="0${data.id}" name="advertisement.propertyForTypeId" checked>
                    <label for="0${data.id}"></label>
                    ${data.nameForPoster}
                </span>
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
            <label>Property Type</label>
            <div class="search_loc">
                <div class="pro_type">
                    Property Type <i class="fa fa-caret-down"></i>
                </div>
                <div class="pro_list">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                        <h1> ${data.name}</h1>
                        <ul>
                            <c:forEach var="innerData" items="${data.propertyTypesById}">
                                <li>
                                    <span class="jq_chk">
                                        <input type="radio" name="advertisement.propertyTypeId" id="${innerData.id}" value="${innerData.id}">
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
            <label>State</label>
            <select class="dropdown" id="drpDwnState"  name="drpDwnState">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.states}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>City</label>
            <select id="drpDwnCity" name="drpDwnCity">
                <option value="-1">--Select--</option>
            </select>
        </li>
        <li>
            <label>Location</label>
            <select id="drpDwnLocation" name="advertisement.locationId">
                <option value="-1">--Select--</option>
            </select>
        </li>
        <li>
            <label>Address</label>
            <input type="text" placeholder="Locality" name="advertisement.address" class="projectname">
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Property Features</h1>
    <ul>

        <li class="col_2_text">
            <label>Builtup Area</label>
            <span><input type="text" placeholder="Buildup Area" name="advertisement.buildupArea"></span>
            <span>
            <select class="dropdown" name="advertisement.buildupAreaUnitId">
                <c:forEach var="data" items="${response.module[0].moduleResponse.units}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
           </span>
        </li>
        <li class="list_3">
            <label> Bed Rooms</label>
            <select placeholder="Select Bed Rooms" class="dropdown" name="advertisement.bedRoomId">
                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li class="list_3">
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
        </li>
        <li>
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
        </li>
        <li>
            <label>Total Floors</label>
            <select class="dropdown" name="advertisement.totalFloor">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
    </ul>
</div>
<div class="ad_3 ">
    <h1>Rent & Other Charges</h1>
    <ul>
        <li class="ad_col_1">
            <label>Expected Rent </label>
                <span>
                <label> Lakhs </label>
                Rs.<select class="dropdown">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="99" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span>
                <label> Thousands </label>
                <select class="dropdown">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="99" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span>
                <label> Hundreds </label>
                <select class="dropdown">
                    <option value="-1">Select</option>
                    <c:forEach begin="1" end="9" var="val">
                        <option value="${val}">${val}</option>
                    </c:forEach>
                </select>
                </span> <span> Or
                <input type="text" placeholder="Enter price" name="advertisement.expectedPrice">
                </span> </li>
                <li class="col_2_text">
                    <label>Maintanance Charges</label>
                    Rs.<span><input type="text" placeholder="Maintenance Charges" name="advertisement.maintenanceCharges">
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
            Rs.<input type="text" placeholder="Security Deposit" name="advertisement.securityDeposit">
        </li>
        <li class="check_brok">
            <label>Response from brokers</label>
                <span>
                <input type="checkbox" id="new_1" name="advertisement.responseFromBrokers" value="1">
                <label for="new_1"></label>
                </span> I am not interested in getting response from brokers </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Property Description</h1>
    <ul>
        <li>
            <label>Name of Project</label>
            <input type="text" name="advertisement.projectName" class="projectname">
        </li>
        <li>
            <label>Description</label>
            <textarea name="advertisement.description" cols="80" rows="6"></textarea>
        </li>
        <li>
            <label>Specification</label>
            <textarea name="advertisement.propertyFeatures" cols="80" rows="6"></textarea><br>
            OR Upload PDF file<input type="file">
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
                        <input type="checkbox" id="check_45" name="advertisement.isTermsAgreed" value="1">
                        <label for="check_45"></label>
                        <p> I am the owner/I have the authority to post this property.
                            I agree not to provide incorrect property information or state a discriminatory preference.
                            In case, the information does not comply with 1AcreIndia terms, 1AcreIndia.com has the right to edit/remove the property from their site. </p>
                    </li>
                </ul>
            </div>
        </li>
        <li class="text_center">
            <input type="submit" class="btn_5" value="Post Property">
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
