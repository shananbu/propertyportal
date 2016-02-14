<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Advertise With Us</title>
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
            <section class="full_width prop_page box_shadow">
                <h1 class="h_2">Advertise Your Properties With Us </h1>
                <ul class="prop_box">
                    <li id="Owner" <c:if test="${userType == 'Owner'}"> class="prop_active" </c:if>><i class="fa fa-home"></i> <span>  Property Owners </span></li>
                    <li id="Agent" <c:if test="${userType == 'Agent'}"> class="prop_active" </c:if>><i class="fa fa-users"></i> <span> Brokers, Agents and Consultants </span></li>
                    <li id="Builder" <c:if test="${userType == 'Builder'}"> class="prop_active" </c:if>><i class="fa fa-building-o"></i> <span> Builders </span></li>
                </ul>
                <ul id="prop_list">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.plans}">
                        <li><a href="postProperty">${data.name}</a>
                            <ul>
                                <c:forEach var="desc" items="${data.lineByeLineDescription}">
                                    <li> ${desc} </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </section>
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
<script>
    $(document).ready(function () {
        $('#prop_list > li > a').click(function () {

            if ($(this).attr('class') != 'pro_active') {
                $('#prop_list li ul').slideUp();
                $(this).next().slideToggle();
                $('#prop_list li a').removeClass('pro_active');
                $(this).addClass('pro_active');
            }
            else if ($(this).attr('class') == 'pro_active') {
                $('#prop_list li ul').slideUp();
                $('#prop_list li a').removeClass('pro_active');
            }
        });
    });
</script>
<!--script end-->
</body>
</html>
