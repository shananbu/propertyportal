<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Forgot Password</title>
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
        });
    </script>
</head>
<body>
<form method="post" commandName="moduleRequest" action="sendPasswordRecoveryMail">
    <main class="main_wrapper clr_fix">
        <header class="clr_fix top_head">
            <%@ include file="userHeader.jsp" %>
        </header>
        <section class="clr_fix sec_main">
            <div class="row_main box_shadow">
                <section class="col_4 clr_fix">
                    <section class="inner_wrapper">
                        <h1 class="h_2">Forgot Password</h1>
                        <div class="user_register jq_chk">
                            <ul>
                                <li>
                                    Forgot your account's password? Enter your email address and we'll send you a recovery link.
                                </li>
                                <li>
                                    <label>Email<small>*</small></label>
                                    <input id="emailId" name="propertyUser.emailId" class="txt" type="text" value="" maxlength="30" placeholder="Email">
                                </li>
                                <li>
                                    <input type="submit" value="Send Recovery Mail" class="btn_5">
                                </li>
                            </ul>
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


        });
    </script>
    <!-- tab script end -->

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
</form>
</body>
</html>
