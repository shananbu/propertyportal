<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Project Overview</title>
    <!-- common css start -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <!-- common css end-->
    <!-- overview slider css start -->
    <!-- overview slider css end -->
    <!-- image lightbox css end -->
    <link href="css/lightbox.css" rel="stylesheet" type="text/css" media="all">
    <!-- image lightbox  css end -->
    <!-- common js file start -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <!-- common js file end -->
</head>
<body>
<main class="main_wrapper clr_fix pro_view_top">
<header class="clr_fix top_head single-page-nav">
    <div class="row_main">
        <div class="col_1 clr_fix"><a href="index" class="logo"> <img src="images/logo.png"> </a></div>
        <div class="col_2 clr_fix">
            <nav class="clr_fix nav_1 top_nav_2">
                <ul>
                    <li class="menu_active"><a href="#unit">Unit Details </a></li>
                    <li><a href="#gallery"> gallery </a></li>
                    <li><a href="#map_view"> map view </a></li>
                </ul>
                <span class="over_contact"> <i class="fa fa-phone"></i> click here to contact </span></nav>
        </div>
    </div>
</header>
<section class="clr_fix">
    <div class="clr_fix prod_img_banner">
        <span>${response.module[0].moduleResponse.advertisement.companyName}</span>
        <ul class="rslides" id="slider1">
            <c:forEach var="data" items="${response.module[0].moduleResponse.advertisement.overviewBannerImages}">
                <li><img src="${data.imageName}"></li>
            </c:forEach>
        </ul>
    </div>
    <div class="clr_fix over_img_info">
        <div class="row_main">
            <ul>
                <li><i class="fa fa-map-marker"></i>

                    <p> Address <span> ${response.module[0].moduleResponse.advertisement.address} </span></p>
                </li>
                <li><i class="fa fa-arrows-alt"></i>

                    <p> Area Range <span> ${response.module[0].moduleResponse.advertisement.buildupAreaRange}</span></p>
                </li>
                <li><i class="fa fa-key"></i>

                    <p> Possession <span> ${response.module[0].moduleResponse.advertisement.possession} </span></p>
                </li>
                <li><i class="fa fa-inr"></i>

                    <p> Price <span> ${response.module[0].moduleResponse.advertisement.priceRange} </span> All Inclusive </p>
                </li>
                <li><i class="fa fa-bed"></i>

                    <p> Bed Room <span>${response.module[0].moduleResponse.advertisement.bedRooms} </span> Appartments</p>
                </li>
            </ul>
        </div>
    </div>
</section>
<section class="sec_view_1 sec_view_block">
    <div class="row_main">
        <h1><span>${response.module[0].moduleResponse.advertisement.projectName}</span></h1>

        <p>${response.module[0].moduleResponse.advertisement.description}<br>
        </p>
    </div>
    <div class="row_main">
        <h1><span>PROJECT SPECIFICATION</span></h1>

        <p>${response.module[0].moduleResponse.advertisement.propertyFeatures}</p>
    </div>
    <div class="pro_chk_list row_main">
        <h1><span>Property Features and Amenities</span></h1>
        <c:forEach var="data" items="${response.module[0].moduleResponse.amenitiesCategory}">
            <nav>
                <ul>
                    <c:forEach var="innerData" items="${response.module[0].moduleResponse.advertisement.propertyAmenitiesMap[data.id]}">
                        <li>
                            <i class="fa fa-check-square-o"></i>${innerData.name}
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </c:forEach>
    </div>
</section>
<section class="sec_view_2 sec_view_block" id="unit">
    <div class="row_main">
        <h1><span>Unit Details</span></h1>

        <div class="unit_left clr_fix">
            <div class="box_shadow">
                <table width="100%" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <td> Type</td>
                        <td> Area (SQ.FT)</td>
                        <td> Rate (Per sq.ft)</td>
                        <td> Total Cost</td>
                        <td> Floor Plan</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.advertisement.moreProperty}">
                        <tr>
                            <td> ${data.bedRoom} </td>
                            <td> ${data.area} </td>
                            <td> <i class="fa fa-inr fa-1x"></i> ${data.pricePerUnitArea} </td>
                            <td> <i class="fa fa-inr fa-1x"></i> ${data.totalCostInWords} </td>
                            <td><a href="${data.floorPlanFileName}" data-lightbox="img_1">View</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<section class="sec_view_3 sec_view_block" id="gallery">
    <div class="row_main">
        <h1><span>Image Gallery</span></h1>

        <div class="clr_fix unit_details">
            <div class="gallery_left img_gal_panel clr_fix">
                <ul class="gal_tab">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.imageTypes}">
                        <li <c:if test="${data.name eq 'EXTERIOR_VIEW'}"> class="gal_tab_active" </c:if>
                                rel="${data.id}"> ${data.label} </li>
                    </c:forEach>
                </ul>
                <c:forEach var="data" items="${response.module[0].moduleResponse.imageTypes}">
                    <div id="${data.id}" class="gal_tab_view_main">
                    <c:forEach var="imageType" items="${response.module[0].moduleResponse.advertisement.galleryImageByImageTypeMap[data.id]}">
                        <ul class="gal_pop">
                            <li><a href="${imageType.imageName}" data-lightbox="img_1">
                                <img src="${imageType.imageName}" alt=""/> </a></li>
                        </ul>
                    </c:forEach>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<section class="sec_view_5 sec_view_block" id="map_view">
    <div class="row_main">
        <h1><span>Map View</span></h1>

        <div class="clr_fix unit_details">
            <div class="map_left clr_fix">
                <ul class="map_tab">
                    <li class="map_tab_active" rel="map_tab_view_1"> Google Map</li>
                </ul>
                <div id="map_tab_view_1" class="map_tab_view_main" style="display:block;">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31090.344122589235!2d80.24697649499511!3d13.080606938195228!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a5265ea4f7d3361%3A0x6e61a70b6863d433!2sChennai%2C+Tamil+Nadu!5e0!3m2!1sen!2sin!4v1433845173540"
                            frameborder="0" style="border:0"></iframe>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="sec_view_7 sec_view_block">
    <div class="row_main">
        <h1><span>EMI CALCULATOR</span></h1>

        <div class="clr_fix box_shadow emi_cal">
            <%@ include file="emiCalculator.jsp" %>
        </div>
    </div>
</section>
<section class="sec_view_8 sec_view_block">
    <div class="row_main">
        <h1><span>Contact us</span></h1>

        <div class="clr_fix box_shadow contact_pro">
            <form>
                <p>
                    <label>Name</label>
                    <input type="text" placeholder="Name">
                </p>

                <p>
                    <label>Email</label>
                    <input type="text" placeholder="Email">
                </p>

                <p>
                    <label>City</label>
                    <input type="text" placeholder="City">
                </p>

                <p>
                    <label>Mobile</label>
                    <input type="text" placeholder="Mobile">
                </p>
          <span>
          <input type="button" value="Submit">
          </span>
            </form>
        </div>
    </div>
</section>
<!-- footer start -->
<footer class="clr_fix foot_main">
    <%@ include file="userFooter.jsp" %>
</footer>
<!-- footer end -->
<div class="over_view_pop">
    <div class="pop_info_view">
        <span class="overview_close"><i class="fa fa-times"></i></span>

        <div class="pop_view_left clr_fix"><img src="images/overview_pop_image.jpg"></div>
        <div class="pop_view_right clr_fix">
            <p> Please fill your details below so that
                we can help you find your dream home </p>

            <form class="form_pop_up">
                <input type="text" placeholder="Your Name">
                <input type="text" placeholder="Your Mobile">
                <input type="text" placeholder="Your Email">
                <input type="text" placeholder="Your City">
                <input type="button" value="Submit">
            </form>
            </form>
        </div>
    </div>
</div>
</main>
<!--script start-->
<script src="js/responsiveslides.js"></script>
<script type="text/javascript">
    $(window).load(function () {
        $('.nav_1 li').removeClass('menu_active');
    });


    $(function () {
        $("#slider1").responsiveSlides({
        });
    });
</script>

<!-- contact form pop up start  -->
<script type="text/javascript">
    $(document).ready(function () {
        $(".view_link_2, .over_contact, .view_link_1").click(function () {
            $('.over_view_pop').fadeIn();
        });

        $(".overview_close").click(function () {
            $('.over_view_pop').fadeOut();
        });
    });

</script>
<!-- contact form pop up end -->


<!-- image lighbox start -->
<script src="js/lightbox.js"></script>
<!-- image lighbox end -->
<!-- image gallery  tab menu start  -->
<script type="text/javascript">
    $(document).ready(function () {
        $(".gal_tab li").click(function () {
            $(".gal_tab li").removeClass("gal_tab_active");
            $(this).addClass("gal_tab_active");
            $(".gal_tab_view_main").hide();
            var activeTab = $(this).attr("rel");
            $("#" + activeTab).fadeIn();
        });
    });

</script>
<!-- image gallery  tab menu end -->
<!-- chart css start -->
<script src="js/Chart.js"></script>
<script>
    //var randomScalingFactor = function(){ return Math.round(Math.random()*7)};
    var lineChartData = {
        labels: ["Jan-Mar'10", "Jul-Mar'10", "Apr-Jun'10", "Jul-Mar'10"],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(220,220,220,0)",
                strokeColor: "rgba(52,152,219,1)",
                pointColor: "rgba(52,152,219,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(52,152,219,1)",
                data: [1000, 2000, 3000, 4000]
            },

            {
                label: "My Second dataset",
                fillColor: "rgba(151,187,205,0)",
                strokeColor: "rgba(231,76,60,1)",
                pointColor: "rgba(231,76,60,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(231,76,60,1)",
                data: [2000, 500, 2500, 3500]
            }

        ]

    }

    window.onload = function () {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myLine = new Chart(ctx).Line(lineChartData, {
            responsive: true
        });
    }


</script>
<!-- chart css end -->
<!-- map view  tab menu start  -->
<script type="text/javascript">
    $(document).ready(function () {
        $(".map_tab li").click(function () {
            $(".map_tab li").removeClass("map_tab_active");
            $(this).addClass("map_tab_active");
            $(".map_tab_view_main").hide();
            var activeTab = $(this).attr("rel");
            $("#" + activeTab).fadeIn();
        });
    });

</script>
<!-- map view  tab menu end -->
<!-- single page navigation start -->
<script src="js/jquery.singlePageNav.js"></script>
<script>

    // Prevent console.log from generating errors in IE for the purposes of the demo
    if (!window.console) console = { log: function () {
    } };

    // The actual plugin
    $('.single-page-nav').singlePageNav({
        offset: $('.single-page-nav').outerHeight(),
        filter: ':not(.external)',
        updateHash: true,
        beforeStart: function () {
            console.log('begin scrolling');
        },
        onComplete: function () {
            console.log('done scrolling');
        }
    });
</script>
<!-- single page navigation end -->
<!--script end-->
</body>
</html>
