<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
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
    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3,selectAll:true });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true });

            // Initialize appendGrid
            $('#tblAppendGrid').appendGrid({
                caption: 'More Properties',
                initRows: 1,
                maxRowsAllowed : 10,
                columns: [
                    { name: 'type', display: 'Type', type: 'text', ctrlAttr: { maxlength: 100 }, ctrlCss: { width: '160px'} },
                    { name: 'area', display: 'Area (Sq.ft)', type: 'text', ctrlAttr: { maxlength: 100 }, ctrlCss: { width: '100px'} },
                    { name: 'ratePerSqFt', display: 'Rate (Per sq.ft)', type: 'text', ctrlAttr: { maxlength: 1 }, ctrlCss: { width: '100px'} },
                    { name: 'totalCost', display: 'Total Cost', type: 'text', ctrlAttr: { maxlength: 4 }, ctrlCss: { width: '100px'} },
                    { name: 'floorPlan', display: 'Floor Plan', type: 'text', ctrlAttr: { maxlength: 4 }, ctrlCss: { width: '100px'} },
                ]
            });
        });
    </script>
    <script src="js/site/postProperty.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
<header class="clr_fix top_head">
    <%@ include file="userHeader.jsp" %>
</header>
<section class="clr_fix sec_main">
<div class="row_main">
<section class="clr_fix">
<nav class="clr_fix step_process">
    <ul>
        <li class="process_1 process_on process_end_1"> <span>1</span> </li>
        <li class="process_2"> <span>2</span> </li>
        <li class="process_3"> <span>3</span> </li>
    </ul>
</nav>
<div class="clr_fix box-shadow ad_post jq_chk">
<div class="ad_1">
    <ul>
        <li>
            <label>Select Listing Package <small>*</small></label>

            <select class="dropdown">
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
            <label>Property For<small>*</small></label>
                <span>
                <input type="radio" id="radio_1" name="1">
                <label for="radio_1"></label>
                Sale </span> <span>
                <input type="radio" id="radio_2" name="1">
                <label for="radio_2"></label>
                Rent </span> <span>
                <input type="radio" id="radio_3" name="1">
                <label for="radio_3"></label>
                PG Accommodation </span> </li>
        <li>
            <label>Property Type</label>
            <select class="dropdown">
                <option>Select Property Type</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                    <%--  <optGroup label="${data.name}">--%>
                    <c:forEach var="innerData" items="${data.propertyTypesById}">
                        <option value="${innerData.id}">${innerData.name}</option>
                    </c:forEach>
                    <%--  </optGroup>--%>
                </c:forEach>
            </select>
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
            <select class="dropdown" id="drpDwnCity"  name="drpDwnCity">
                <option value="-1">--Select--</option>
            </select>
        </li>
        <li>
            <label>Location</label>
            <select class="dropdown">
                <option value="-1">--Select--</option>

            </select>
        </li>
        <li>
            <label>Locality</label>
            <input type="text" placeholder="Locality">
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Property Features</h1>
    <ul>
        <li>
            <label>Balconies</label>
            <select class="dropdown">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.balconies}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Furnished Status</label>
            <select class="dropdown">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.furnishedStatus}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Floor No</label>
            <select class="dropdown">
                <option value="-1">--Select--</option>
                <c:forEach var="data" items="${response.module[0].moduleResponse.totalFloors}">
                    <option value="${data.id}">${data.name}</option>
                </c:forEach>
            </select>
        </li>
        <li>
            <label>Total Floors</label>
            <select class="dropdown">
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
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                </span> <span>
                <label> Thousands </label>
                <select class="dropdown">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                </span> <span>
                <label> Hundreds </label>
                <select class="dropdown">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                </span> <span> Or
                <input type="text" placeholder="Enter Toal Rent">
                </span> </li>
        <li class="col_2_text">
            <label>Maintanance Charges</label>
            Rs.<span><input type="text" placeholder="Maintanance Charges">
                </span> <span>
                <select class="dropdown">
                    <option>Monthly</option>
                    <option>Quarterly</option>
                    <option>Yearly</option>
                </select>
                </span> </li>
        <li>
            <label>Security Deposit</label>
            Rs.<input type="text" placeholder="Security Deposit">
        </li>
        <li class="check_brok">
            <label>Response from brokers</label>
                <span>
                <input type="checkbox" id="new_1">
                <label for="new_1"></label>
                </span> I am not interested in getting response from brokers </li>
    </ul>
</div>
<div class="unit_left clr_fix">
    <div class="box_shadow">
      <%--  <table width="100%" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <td> Type </td>
                <td> Area (SQ.FT) </td>
                <td> Rate (Per sq.ft) </td>
                <td> Total Cost </td>
                <td> Floor Plan </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td> 1bhk </td>
                <td> 65 </td>
                <td> Rs.6250 </td>
                <td> Rs.458.20 </td>
                <td><a href="#">click to view</a></td>
            </tr>
            <tr>
                <td> 1bhk </td>
                <td> 65 </td>
                <td> Rs.6250 </td>
                <td> Rs.458.20 </td>
                <td><a href="#">click to view</a></td>
            </tr>
            <tr>
                <td> 1bhk </td>
                <td> 65 </td>
                <td> Rs.6250 </td>
                <td> Rs.458.20 </td>
                <td><a href="#">click to view</a></td>
            </tr>
            <tr>
                <td> 1bhk </td>
                <td> 65 </td>
                <td> Rs.6250 </td>
                <td> Rs.458.20 </td>
                <td><a href="#">click to view</a></td>
            </tr>
            <tr>
                <td> 1bhk </td>
                <td> 65 </td>
                <td> Rs.6250 </td>
                <td> Rs.458.20 </td>
                <td><a href="#">click to view</a></td>
            </tr>
            </tbody>
        </table>--%>
         More properties: <table id="tblAppendGrid">
          </table>
    </div>
</div>
<div class="ad_3">
    <h1>Property Description</h1>
    <ul>
        <li>
            <label>Description</label>
            <textarea name="" cols="80" rows="6"></textarea>
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Add Photos </h1>
    <ul>
        <li>
            <div class="browse_block">
                <h2> Just click, Upload & Get upto 5 times higher response </h2>
                <ul class="browse_tab tabs">
                    <li class="upload_active" rel="tab1"> Exterior View </li>
                    <li rel="tab2"> Bedrooms </li>
                    <li rel="tab3"> Bathrooms </li>
                    <li rel="tab4"> Kitchen </li>
                    <li rel="tab5"> Floor Plan </li>
                    <li rel="tab6"> Master Plan </li>
                </ul>
                <div class="image_view">
                    <div id="tab1" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab2" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab3" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab4" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab5" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div id="tab6" class="tab_content">
                        <div flow-init
                             flow-files-submitted="$flow.upload()"
                             flow-file-added="!!{png:1,gif:1,jpg:1,jpeg:1}[$file.getExtension()]">
                            <div class="drop" flow-drop ng-class="dropClass"> <span class="btn btn-default" flow-btn>Upload Image</span> <b>OR</b> Drag And Drop your images here </div>
                            <br/>
                            <div>
                                <div ng-repeat="file in $flow.files" class="gallery-box"> <span class="title">{{file.name}}</span>
                                    <div class="thumbnail" ng-show="$flow.files.length"> <img flow-img="file" /> </div>
                                    <div class="progress progress-striped" ng-class="{active: file.isUploading()}">
                                        <div class="progress-bar" role="progressbar"
                                             aria-valuenow="{{file.progress() * 100}}"
                                             aria-valuemin="0"
                                             aria-valuemax="100"
                                             ng-style="{width: (file.progress() * 100) + '%'}"> <span class="sr-only">{{file.progress()}}% Complete</span> </div>
                                    </div>
                                    <div class="btn-group"> <a class="remove_btn" ng-click="file.cancel()"> <i class="fa fa-trash-o"></i> </a> </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</div>
<div class="ad_3">
    <h1>Spam Check </h1>
    <ul>
        <li>
            <div class="add_block">
                <h2> Just solve this simple question </h2>
                <ul>
                    <li>10 - 8 =
                        <input type="text">
                    </li>
                    <li class="agree_form">
                        <input type="checkbox" id="check_45">
                        <label for="check_45"></label>
                        <p> I am the owner/I have the authority to post this property.
                            I agree not to provide incorrect property information or state a discriminatory preference.
                            In case, the information does not comply with 1AcreIndia terms, 1AcreIndia.com has the right to edit/remove the property from their site. </p>
                    </li>
                </ul>
            </div>
        </li>
        <li class="text_center">
            <input type="button" class="btn_5" value="Post Property">
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
<!--script start-->
<script src="js/jquery.easydropdown.js"></script>
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
