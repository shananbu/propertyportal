<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>User Register</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="css/sumoselect.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll: true });
            window.test = $('.testsel').SumoSelect({okCancelInMulti: true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti: true, selectAll: true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll: true });
        });
    </script>
</head>
<body>
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
    </header>
<%--    <section class="inner_top clr_fix">
        <%@ include file="userSmallSearchMenu.jsp" %>
    </section>--%>
    <section class="clr_fix sec_main">
        <form method="post" commandName="moduleRequest" action="authenticateUser">
            <div class="row_main ad_to_mar">
                <div class="log_left"><img src="images/login_page.png"></div>
                <div class="log_right">
                    <div class="left_login clr_fix box_shadow">
                        <div class="log_head clr_fix"><b class="title_login">Login Now</b> <span> New User <a
                                href="userRegistration">Register Now</a> </span></div>
                        <ul>
                            <li>
                                <label>Username / Email Id</label>
                                <input type="text" placeholder="Username"  name="standardAuth.username">
                            </li>
                            <li>
                                <label>Password</label>
                                <input type="password" placeholder="Password"  name="standardAuth.password">
                            </li>
                            <li class="log_for"><span> <a href="#">Forgot Password ? </a> </span>
                                <input type="submit" value="Login" class="sub_btn_3">
                            </li>
                            <%--
                                        <li class="or_log"> <span> Sign in using FConnect </span> <a href="#"><i class="fa fa-facebook"></i> facebook</a> </li>
                            --%>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
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
    });
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
</body>
</html>
