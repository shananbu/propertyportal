<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>property-portal</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">

    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3,selectAll:false });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true }); });
    </script>
    <link href="css/banner_slider.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/banner_slider.js"></script>
    <script class="secret-source">
        $(document).ready(function($) {
            $('#banner-fade').bjqs({
                height      : 300,
                width       : '100%',
                responsive  : true
            });
        });
    </script>
    <script src="js/site/index.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
<header class="clr_fix top_head">
    <%@ include file="userHeader.jsp" %>
</header>
<div class="banner_main clr_fix">
<div class="banner_bg clr_fix">
<%--    <ul class="rslides" id="slider1">
        <li><img src="images/index_slider_1.jpg" title="sample title here"></li>
        <li><img src="images/index_slider_2.jpg" title="sample title here"></li>
    </ul>--%>
<div class="row_main banner_panel">
<section class="clr_fix search_panel">
<nav class="tab_menu clr_fix">
    <ul>
        <li class="tab_active tab_1"> Buy</li>
        <li class="tab_2"> Rent</li>
        <li class="tab_3"> New Project</li>
    </ul>
</nav>
<div class="tab_info clr_fix box_shadow">
<div class="tab_info_1 tab_view clr_fix" style="display:block;">
    <form method="post" id="tab_info_1" action="searchViewPage">
    <div class="clr_fix">
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
                                <input type="checkbox" id="0${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="0${innerData.id}"></label>
                            </span>  ${innerData.name}
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
        </div>
        <div class="text_panel">
            <input type="text" placeholder="Type Location or Project"  name="search.searchString">
            <input type="submit" value="Search" id="searchBtn1" class="searchBtn">
        </div>
    </div>

    <div class="clr_fix loc_list">
        <ul>
            <li class="list_3">
                <label> Price</label>
                <select  placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                    <option value="-1">No Budget Limit</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <c:if test="${data.propertyForTypeId eq 1}">
                            <option value="${data.id}">${data.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </li>
            <li class="list_3">
                <label> Bed Rooms</label>
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="list_3">
                <label> Posted By </label>
                <select class="dropdown" placeholder="select" name="search.userTypeId">
                    <option value="-1">All</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="list_4"><span> Clear All </span></li>
        </ul>
    </div>
    </form>
</div>
<div class="tab_info_2 tab_view clr_fix">
    <form method="post" id="tab_info_2" action="searchViewPage">
    <div class="clr_fix">
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
                                 <input type="checkbox" id="00${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="00${innerData.id}"></label>
                            </span>  ${innerData.name}
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>

            </div>

        </div>
        <div class="text_panel">
            <input type="text" placeholder="Type Location or Project"  name="search.searchString">
            <input type="submit" value="Search" id="searchBtn2" class="searchBtn">
        </div>
    </div>
    <div class="clr_fix loc_list">
        <ul>
            <li class="list_3">
                <label> Price</label>
                <select placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                    <option value="-1">No Budget Limit</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <c:if test="${data.propertyForTypeId eq 2}">
                        <option value="${data.id}">${data.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </li>
            <li class="list_3">
                <label> Bed Rooms</label>
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>

            </li>
            <li class="list_3">
                <label> Posted By </label>
                <select class="dropdown" placeholder="select" name="search.userTypeId">
                    <option value="-1">All</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="list_4"><span> Clear All </span></li>
        </ul>
    </div>
    </form>
</div>
<div class="tab_info_3 tab_view clr_fix">
    <form method="post" id="tab_info_3" action="searchViewPage">
    <div class="clr_fix">
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
                                 <input type="checkbox" id="000${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="000${innerData.id}"></label>
                            </span>  ${innerData.name}
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>

            </div>

        </div>
        <div class="text_panel">
            <input type="text" placeholder="Type Location or Project"  name="search.searchString">
            <input type="submit" value="Search" id="searchBtn3" class="searchBtn">
        </div>
    </div>
    <div class="clr_fix loc_list">
        <ul>
            <li class="list_3">
                <label> Price</label>
                <select placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                    <option value="-1">No Budget Limit</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <c:if test="${data.propertyForTypeId eq 1}">
                             <option value="${data.id}">${data.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </li>
            <li class="list_3">
                <label> Bed Rooms</label>
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>

            </li>
            <li class="list_3">
                <label> Posted By </label>
                <select class="dropdown" placeholder="select" name="search.userTypeId">
                    <option value="-1">All</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="list_4"><span> Clear All </span></li>
        </ul>
    </div>
    </form>
</div>
</div>
</section>
</div>
<div id="banner-fade">
    <ul class="bjqs">
        <li><img src="images/index_slider_1.jpg"></li>
        <li><img src="images/index_slider_2.jpg"></li>
    </ul>
</div>
</div>


</div>
<section class="clr_fix sec_main">
<div class="row_main">
<section class="col_4 clr_fix">
    <aside class="ad_1_left clr_fix">
        <h1 class="h_1">New projects</h1>
        <ul class="box_shadow clr_fix">
            <c:set var="counter" value="0" scope="request"/>
            <c:if test="${not empty response.module[0].moduleResponse.advertisements}">
                <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" begin="5" end="6" >
                    <c:set var="counter" value="${counter + 1}"/>
                    <li> <a href="projectOverview?advertisementId=${data.id}&isMicroSite=true" target="_blank"> <img src="${data.propertyLogo}">
                        <figcaption class="pro_info_1">
                            <h1>${data.projectName} </h1>
                            <p>${data.companyName}</p>
                            <span> <i class="fa fa-map-marker"></i>&nbsp;${data.locationName}</span>
                            <ul>
                                <li> Beds : <span>${data.bedRooms}</span> </li>
                                <li> Buildup Area : <span> ${data.buildupAreaName}</span> </li>
                                <li> Cost : <span> <i class="fa fa-inr"></i> ${data.cost}</span> </li>
                                <li> <span> <small>Read More</small> </span> </li>
                            </ul>
                        </figcaption>
                    </a> </li>
                </c:forEach>
            </c:if>

            <c:forEach begin="${counter}" end="1" var="val">
                <li> <img src="images/image_1.jpg">
                    <div class="adver_here"><a href="postPropertyInMicrosite" class="adver_here_txt"> ADvertise here</a>
                        <a target="_blank" href="projectOverviewSample" class="cli_add">click here for sample add</a> </div>
                    <figcaption class="pro_info_1">
                        <h1>Project Name </h1>
                        <p> Company Name </p>
                        <span> <i class="fa fa-map-marker"></i> Location </span>
                        <ul>
                            <li> Beds : <span> </span> </li>
                            <li> Buildup Area : <span> </span> </li>
                            <li> Cost : <span> </span> </li>
                            <li> <span>&nbsp; </span> </li>
                        </ul>
                    </figcaption>
                </li>
            </c:forEach>
            <c:set var="counter" value="0"/>
        </ul>
    </aside>
    <section class="clr_fix pro_block">
        <h1 class="h_2">Project Gallery</h1>
        <ul class="block_1">
            <c:if test="${not empty response.module[0].moduleResponse.advertisements}">
                <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" end="1" >
                    <c:set var="counter" value="${counter + 1}"/>
                    <li> <a href="projectOverview?advertisementId=${data.id}&isMicroSite=true"> <img src="${data.propertyLogo}">
                        <figcaption class="pro_info_1"> <img src="${data.companyLogo}">
                            <summary>
                                <h1>${data.projectName}</h1>
                                <p>${data.companyName}</p>
                                <span> <i class="fa fa-map-marker"></i>&nbsp;${data.locationName}</span> </summary>
                            <ul>
                                <li> Beds : <span>${data.bedRooms}</span> </li>
                                <li> Buildup Area : <span> ${data.buildupAreaName}</span> </li>
                                <li> Cost : <span> <i class="fa fa-inr"></i> ${data.cost}</span> </li>
                                <li> <span> <small>Read More</small> </span> </li>
                            </ul>
                        </figcaption>
                    </a> </li>
                </c:forEach>
            </c:if>

            <c:forEach begin="${counter}" end="1" var="val">
                <li>
                    <div class="adver_here"><a href="postPropertyInMicrosite" class="adver_here_txt"> ADvertise here</a>
                        <a target="_blank" href="projectOverviewSample" class="cli_add">click here for sample add</a> </div>
                    <a href="#"> <img src="images/image_3.jpg">
                        <figcaption class="pro_info_1"> <img src="images/no_image.jpg">
                            <summary>
                                <h1>Project Name </h1>
                                <p> Company Name </p>
                                <span> <i class="fa fa-map-marker"></i> Location </span> </summary>
                            <ul>
                                <li> Beds : <span> </span> </li>
                                <li> Buildup Area : <span> </span> </li>
                                <li> Cost : <span> </span> </li>
                                <li> <span> &nbsp; </span> </li>
                            </ul>
                        </figcaption>
                    </a>
                </li>
            </c:forEach>
            <c:set var="counter" value="0"/>
        </ul>
        <ul class="img_panel_2">
            <c:if test="${not empty response.module[0].moduleResponse.advertisements}">
                <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" begin="2" end="4">
                    <c:set var="counter" value="${counter + 1}"/>
                    <li> <a href="projectOverview?advertisementId=${data.id}&isMicroSite=true"> <img src="${data.propertyLogo}">
                        <figcaption class="pro_info_1">
                            <h1>${data.projectName}</h1>
                            <p>${data.companyName}</p>
                            <span> <i class="fa fa-map-marker"></i>&nbsp;${data.locationName}</span>
                            <ul>
                                <li> Beds : <span>${data.bedRooms}</span> </li>
                                <li> Buildup Area : <span> ${data.buildupAreaName}</span> </li>
                                <li> Cost : <span> <i class="fa fa-inr"></i> ${data.cost}</span> </li>
                                <li> <span> <small>Read More</small> </span> </li>
                            </ul>
                        </figcaption>
                    </a> </li>
                </c:forEach>
            </c:if>

            <c:forEach begin="${counter}" end="2" var="val">
                <li>
                    <div class="adver_here"><a href="postPropertyInMicrosite" class="adver_here_txt"> ADvertise here</a>
                        <a target="_blank" href="projectOverviewSample" class="cli_add">click here for sample add</a> </div>
                    <img src="images/image_6.jpg">
                    <figcaption class="pro_info_1">
                        <h1>Project Name </h1>
                        <p> Company Name </p>
                        <span> <i class="fa fa-map-marker"></i> Location </span>
                        <ul>
                            <li> Beds : <span> </span> </li>
                            <li> Buildup Area : <span> </span> </li>
                            <li> Cost : <span> </span> </li>
                            <li> <span>&nbsp; </span> </li>
                        </ul>
                    </figcaption>
                </li>
            </c:forEach>
            <c:set var="counter" value="0"/>
        </ul>
    </section>
    <aside class="ad_1_left re_m clr_fix">
        <h1 class="h_1">New projects</h1>
        <ul class="box_shadow clr_fix">
            <c:if test="${not empty response.module[0].moduleResponse.advertisements}">
                <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" begin="7" end="8" >
                    <c:set var="counter" value="${counter + 1}"/>
                    <li> <a href="projectOverview?advertisementId=${data.id}&isMicroSite=true" target="_blank"> <img src="${data.propertyLogo}">
                        <figcaption class="pro_info_1">
                            <h1>${data.projectName} </h1>
                            <p>${data.companyName}</p>
                            <span> <i class="fa fa-map-marker"></i>&nbsp;${data.locationName}</span>
                            <ul>
                                <li> Beds : <span>${data.bedRooms}</span> </li>
                                <li> Buildup Area : <span> ${data.buildupAreaName}</span> </li>
                                <li> Cost : <span> <i class="fa fa-inr"></i> ${data.cost}</span> </li>
                                <li> <span> <small>Read More</small> </span> </li>
                            </ul>
                        </figcaption>
                    </a> </li>
                </c:forEach>
             </c:if>
            <c:forEach begin="${counter}" end="1" var="val">
                <li> <img src="images/image_1.jpg">
                    <div class="adver_here"><a href="postPropertyInMicrosite" class="adver_here_txt"> ADvertise here</a>
                        <a target="_blank" href="projectOverviewSample" class="cli_add">click here for sample add</a> </div>
                    <figcaption class="pro_info_1">
                        <h1>Project Name </h1>
                        <p> Company Name </p>
                        <span> <i class="fa fa-map-marker"></i> Location </span>
                        <ul>
                            <li> Beds : <span> </span> </li>
                            <li> Buildup Area : <span> </span> </li>
                            <li> Cost : <span> </span> </li>
                            <li> <span>&nbsp; </span> </li>
                        </ul>
                    </figcaption>
                </li>
            </c:forEach>
            <c:set var="counter" value="0"/>
        </ul>

    </aside>
</section>
<section class="clr_fix box_shadow pro_gal">
    <h1> <span>Project Gallery</span> </h1>
    <ul class="img_panel_3 owl-carousel">
    <c:if test="${not empty response.module[0].moduleResponse.advertisements}">
        <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" begin="9" end="13" >
            <c:set var="counter" value="${counter + 1}"/>
            <li> <a href="projectOverview?advertisementId=${data.id}&isMicroSite=true" target="_blank"> <img src="${data.propertyLogo}">
                <figcaption class="pro_info_1">
                    <h1>${data.projectName} </h1>
                    <p>${data.companyName}</p>
                    <span> <i class="fa fa-map-marker"></i>&nbsp;${data.locationName}</span>
                    <ul>
                        <li> Beds : <span>${data.bedRooms}</span> </li>
                        <li> Buildup Area : <span> ${data.buildupAreaName}</span> </li>
                        <li> Cost : <span> <i class="fa fa-inr"></i> ${data.cost}</span> </li>
                        <li> <span> <small>Read More</small> </span> </li>
                    </ul>
                </figcaption>
            </a>
            </li>
        </c:forEach>
    </c:if>
    <c:forEach begin="${counter}" end="5" var="val">
        <li> <img src="images/image_1.jpg">
            <div class="adver_here"><a href="postPropertyInMicrosite" class="adver_here_txt"> ADvertise here</a>
                <a target="_blank" href="projectOverviewSample" class="cli_add">click here for sample add</a> </div>
            <figcaption class="pro_info_1">
                <h1>Project Name </h1>
                <p> Company Name </p>
                <span> <i class="fa fa-map-marker"></i> Location </span>
                <ul>
                    <li> Beds : <span> </span> </li>
                    <li> Buildup Area : <span> </span> </li>
                    <li> Cost : <span> </span> </li>
                    <li> <span>&nbsp; </span> </li>
                </ul>
            </figcaption>
        </li>
    </c:forEach>
    <c:set var="counter" value="0"/>
    </ul>
</section>
</div>
</section>
<!-- footer start -->
<footer class="clr_fix foot_main">
    <%@ include file="userFooter.jsp" %>
</footer>
<!-- footer end -->
</main>
<!--script start-->
<script src="js/responsiveslides.js"></script>
<script type="text/javascript">
    $(function () {
        $("#slider1").responsiveSlides({
        });
    });
</script>
<!-- tab script start-->
<script type="text/javascript">
    $(document).ready(function () {
        $('.text_panel input[type="text"]').click(function () {
            $('.loc_list').slideDown(300);
        })
        $('.pro_type').click(function () {
            $('.pro_list').slideToggle();
        })


        $('.top_loc_list a').click(function () {
            $('.loc_list_view').slideToggle();
        });


        $('.tab_1').click(function () {
            $('.tab_menu li').removeClass('tab_active')
            $(this).addClass('tab_active')
            $('.tab_view').hide();
            $('.tab_info_1').fadeIn();

        });
        $('.tab_2').click(function () {
            $('.tab_menu li').removeClass('tab_active')
            $(this).addClass('tab_active')
            $('.tab_view').hide();
            $('.tab_info_2').fadeIn();
        });

        $('.tab_3').click(function () {
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
        loop: true,
        margin: 20,
        nav: true,
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 3
            },
            1000: {
                items: 4
            }
        }
    })
</script>

<!-- Image navigation end-->


<!-- Image navigation start -->

<!-- Image navigation end -->
<!--script end-->
</body>
</html>
