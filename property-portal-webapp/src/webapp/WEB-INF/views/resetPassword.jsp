<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Password Reset</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.sumoselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3, selectAll: true });
            window.test = $('.testsel').SumoSelect({okCancelInMulti: true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti: true, selectAll: true });
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll: true });

            $( "#btnSubmit" ).click(function( event ) {
                if( ($("#password").val() == "") || ($("#cPassword").val() == "" )) {
                    alert( "Please enter password and confirm password." );
                } else if($("#password").val() != $("#cPassword").val() ){
                    alert( "Password and confirm password doesn't match" );
                } else {
                    $("#frmResetPassword").submit();
                }
            });
        });
    </script>
</head>
<body>
<form method="post" class="frmAdminLogin" commandName="moduleRequest" action="updatePassword" id="frmResetPassword">
    <main class="main_wrapper clr_fix">
        <header class="clr_fix top_head">
            <%@ include file="userHeader.jsp" %>
        </header>
        <section class="clr_fix sec_main">
            <form method="post" commandName="moduleRequest" action="authenticateUser">
                <div class="row_main ad_to_mar">
                    <div class="log_left"></div>
                    <div class="log_right">
                        <div class="left_login clr_fix box_shadow">
                            <div class="log_head clr_fix"><b class="title_login">Password Reset</b></div>
                            <img src="images/reset-image.jpg">
                            <ul>
<%--                                <li>
                                    <label>Email Id</label>
                                    <input type="email" placeholder="Username" name="username">
                                </li>--%>
                                <li>
                                    <label>Password</label>
                                    <input type="password" placeholder="Password" name="password"  id="password">
                                    <input type="hidden" name="token" value="${token}">
                                </li>
                                <li>
                                    <label>Confirm Password</label>
                                    <input type="password" placeholder="Confirm Password" name="cPassword" id="cPassword">
                                </li>
                                <li class="log_for">
                                    <input type="button" value="Reset" class="sub_btn_3" id="btnSubmit">
                                </li>
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
</form>
<!-- tab menu end -->
</body>
</html>
