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
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3,selectAll:false });
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
    <section class="clr_fix sec_main">
        <div class="row_main">
            <section class="col_4 clr_fix">
                <section class="inner_wrapper">
                    <c:set var="data" value="${response.module[0].moduleResponse.advertisement}"/>
                        <div id="content">
                            <div class="sear_list">
                                <ul>
                                    <li>
                                        <figure class="gal_pop_open" id="${data.id}"> <img src="images/image_1.jpg">
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
                        </div>
                 </section>
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
                <div class="img_wrapper"> <span> <img src="${data.propertyLogo}" /> </span></div>
                <div class="nav_tab">
                    <div class="slider">
                        <ul id="img_gal_pop_ul">
                        </ul>
                    </div>
                    <a href="#" class="slider-arrow sa-left"><i class="fa fa-chevron-circle-left"></i> </a>
                    <a href="#" class="slider-arrow sa-right"><i class="fa fa-chevron-circle-right"></i></a>
                </div>
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

            $.ajax({
                url: "rest/v1/admin/modules/get/getAdvertisement?advertisementId=" + $(this).prop("id")
            }).done(function(data) {
                $('#img_gal_pop_ul').empty();
                $.each(data.module[0].moduleResponse.advertisement.galleryImage, function() {
                    $('#img_gal_pop_ul').append($('<li><span><img src="./..' + (this.imageName) + '"> </span></li>'));
                });

                $('.img_gal_pop').fadeIn();
                if(k == 0){
                    pop_gal();
                    k++;
                }
            });


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
