<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="app">
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
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll: false });
            window.test = $('.testsel').SumoSelect({okCancelInMulti: true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti: true, selectAll: true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll: true });
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
                            <li class="process_1 process_on process_end_1"><span>1</span></li>
                            <li class="process_2 process_on process_end_1"><span>2</span></li>
                            <li class="process_3 process_on"><span>3</span></li>
                        </ul>
                    </nav>
                    <div class="clr_fix box-shadow ad_post jq_chk">
                        <div class="ad_3">
                            <li class="text_center">
                                Successfully updated the advertisement. <br>
                                Yor advertisement will be displayed after the admin review and approval.
                            </li>
                            </ul>
                        </div>
                    </div>
                </section>
            </div>
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
<!-- tab menu start -->
<script type="text/javascript">

    $(document).ready(function () {

        $(".tab_content").hide();
        $(".tab_content:first").show();

        $("ul.tabs li").click(function () {
            $("ul.tabs li").removeClass("upload_active");
            $(this).addClass("upload_active");
            $(".tab_content").hide();
            var activeTab = $(this).attr("rel");
            $("#" + activeTab).fadeIn();
        });
    });


    $(document).ready(function () {

        $(".tab_content_2").hide();
        $(".tab_content_2:first").show();

        $("ul.tabs_2 li").click(function () {
            $("ul.tabs_2 li").removeClass("inner_tab_active");
            $(this).addClass("inner_tab_active");
            $(".tab_content_2").hide();
            var activeTab = $(this).attr("rel");
            $("#" + activeTab).fadeIn();
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
