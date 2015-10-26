<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Search Result</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3,selectAll:true });
            window.test = $('.testsel').SumoSelect({okCancelInMulti:true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti:true, selectAll:true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll:true });

            $('.more-link').click(function () {
                if ($(this).prev().hasClass('truncate')) {
                    $(this).prev().removeClass('truncate');
                    $(this).text("Read More");

                } else {
                    $(this).prev().addClass('truncate');
                    $(this).prev().addClass('full_text');
                    $(this).text("Less");
                }
                $(this).toggle();
                //$(this).prev().toggle();
                return false;
            });
        });


    </script>
</head>
<body>
<main class="main_wrapper clr_fix">
<header class="clr_fix top_head">
    <%@ include file="userHeader.jsp" %>
</header>
<section class="inner_top clr_fix">
    <%@ include file="userSmallSearchMenu.jsp" %>
</section>
<section class="clr_fix sec_main">
<div class="row_main">
    <section class="col_4 clr_fix">
        <section class="inner_wrapper">
            <div class="search_title box_shadow"> <span> Refine Your Results </span>
                <div>
                    <select class="dropdown">
                        <option> Most Recent Ads </option>
                        <option> Low to Hight </option>
                        <option> Hight to Low </option>
                    </select>
                </div>
            </div>
<%--            <div class="sear_list">
                <ul>
                    <li>
                        <figure class="gal_pop_open"> <img src="images/image_1.jpg">
                            <figcaption>5 photos</figcaption>
                        </figure>
                        <div>
                            <div class="search_head">
                                <div class="left_head">
                                    <h1>BBCL Ananya</h1>
                                </div>
                            </div>
                            <div class="clr_fix sear_block_2">
                                <ul>
                                    <li>
                                        <label>Property Type :</label>
                                        <span>Residential Appartments</span> </li>
                                    <li>
                                        <label>Location :</label>
                                        <span>Porur, Chennai </span> </li>
                                    <li>
                                        <label>Bed Rooms :</label>
                                        <span>1,2,3BHK Penthouses </span> </li>
                                    <li>
                                        <label>Starting Prie :</label>
                                        <span>On Request </span> </li>
                                    <li>
                                        <label>Possession :</label>
                                        <span>August 2015 </span> </li>
                                    <li class="unit_block">
                                        <label>Decritpion : </label>
                                        <p class="content more truncate" will-truncate-max-height="0" data-text-truncate-lines="5"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p>
                                        <a class="more-link" href="#">Read More</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>--%>
            <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}">
            <div class="sear_list">
                <ul>
                    <li>
                        <figure class="gal_pop_open"> <img src="images/image_1.jpg">
                            <figcaption>5 photos</figcaption>
                        </figure>
                        <div>
                            <div class="search_head">
                                <div class="left_head">
                                    <h1>${data.projectName}</h1>
                                </div>
                            </div>
                            <div class="clr_fix sear_block_2">
                                <ul>
                                    <li>
                                        <label>Property Type :</label>
                                        <span>${data.propertyTypeName}</span> </li>
                                    <li>
                                        <label>Location :</label>
                                        <span>${data.address}</span> </li>
                                    <li>
                                        <label>Bed Rooms :</label>
                                        <span>${data.bedRooms}</span> </li>
                                    <li>
                                        <label>Starting Price :</label>
                                        <span>${data.cost}</span> </li>
                                    <li>
                                        <label>Possession :</label>
                                        <span>August 2015 </span> </li>
                                    <li class="unit_block">
                                        <label>Description : </label>
                                        <p class="content more truncate" will-truncate-max-height="0" data-text-truncate-lines="5">${data.description}</p>
                                        <a class="more-link" href="#">Read More</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            </c:forEach>
        </section>
 <%--       <aside class="ad_1_left re_m clr_fix">
            <h1 class="h_1">New projects</h1>
            <ul class="box_shadow clr_fix">
                <li> <a href="#"> <img src="images/image_1.jpg">
                    <figcaption class="pro_info_1">
                        <h1>Silver Ripples </h1>
                        <p> Sumadhura Infracon Pvt. Ltd. </p>
                        <span> <i class="fa fa-map-marker"></i> Bangalore East </span>
                        <ul>
                            <li> Beds : <span> 2, 3  BHK </span> </li>
                            <li> Buildup Area : <span> 900 sq.ft onwards </span> </li>
                            <li> Cost : <span> <i class="fa fa-inr"></i> 2.5 Lac onwards</span> </li>
                            <li> <span> <small>Read More</small> </span> </li>
                        </ul>
                    </figcaption>
                </a> </li>
                <li> <a href="#"> <img src="images/image_1.jpg">
                    <figcaption class="pro_info_1">
                        <h1>Silver Ripples </h1>
                        <p> Sumadhura Infracon Pvt. Ltd. </p>
                        <span> <i class="fa fa-map-marker"></i> Bangalore East </span>
                        <ul>
                            <li> Beds : <span> 2, 3  BHK </span> </li>
                            <li> Buildup Area : <span> 900 sq.ft onwards </span> </li>
                            <li> Cost : <span> <i class="fa fa-inr"></i> 2.5 Lac onwards</span> </li>
                            <li> <span> <small>Read More</small> </span> </li>
                        </ul>
                    </figcaption>
                </a> </li>
            </ul>
        </aside>--%>

    </section>
</div>
</section>
<!-- footer start -->
<footer class="clr_fix foot_main">
    <%@ include file="userFooter.jsp" %>
</footer>
<!-- footer end -->
<!-- image gallery popup start -->
<div class="img_gal_pop">
    <div class="img_gal_pop_wrap">
        <h1 class="h_2">Image Gallery <span class="gal_close"> <i class="fa fa-times-circle"></i> </span> </h1>

        <div class="ad_gallery_user">
            <div class="img_wrapper"> <span> <img src="images/large_img_1.jpg" /> </span></div>
            <div class="nav_tab">
                <div class="slider">
                    <ul>
                        <li><span><img src="images/large_img_1.jpg"> </span></li>
                        <li><span><img src="images/large_img_2.jpg"> </span></li>
                        <li> <span><img src="images/large_img_3.jpg"></span> </li>
                        <li><span> <img src="images/large_img_4.jpg"></span></li>
                        <li> <span><img src="images/large_img_5.jpg"> </span></li>
                        <li><span><img src="images/large_img_6.jpg"> </span></li>
                    </ul>
                </div>
                <a href="#" class="slider-arrow sa-left"><i class="fa fa-chevron-circle-left"></i> </a> <a href="#" class="slider-arrow sa-right"><i class="fa fa-chevron-circle-right"></i></a> </div>
        </div>

    </div>
</div>
<!-- image gallery popup end -->
</main>
<!--script start-->


<!--image gallery start -->
<script src="js/jquery_image_gallery.js"></script>
<script type="text/javascript">
    function pop_gal(){
        jQuery('.slider').lbSlider({
            leftBtn: '.sa-left',
            rightBtn: '.sa-right',
            visible: 9,
            autoPlay: false,
            autoPlayDelay: 5
        });
    }

    $(function(){
        var i=0;
        $(document).on('click','.slider ul li img',function(){
            $('.img_wrapper img').attr('src',$(this).attr('src')+'?'+i);
            i=parseInt(i)+1;
            $('.slider ul li img').removeClass('thum_active');
            $(this).addClass('thum_active');
        });
    });
</script>
<!--image gallery end-->
<!-- tab script start-->
<script type="text/javascript">
    $(document).ready(function (){
        var k = 0;
        $('#contact_adver').click(function(){
            $('.forget_pop').fadeIn();
        });


        $('#close_pop').click(function(){
            $('.forget_pop').fadeOut();
        });


        $('.gal_pop_open').click(function(){

            $('.img_gal_pop').fadeIn();
            if(k == 0){
                pop_gal();
                k++;
            }
        });


        $('.gal_close').click(function(){
            $('.img_gal_pop').fadeOut();

        });

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

<!--script end-->
</body>
</html>
