<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Post Requirement for Buying Property</title>
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
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
    </header>
    <section class="clr_fix sec_main">
        <div class="row_main">
            <section class="col_4 clr_fix">

                <section class="inner_wrapper">
                    <h1 class="h_2">Post Requirement for Buying Property</h1>

                    <div class="user_register post_buy_pro jq_chk">
                        <ul>
                            <li>
                                <label>I want to
                                    <small>*</small>
                                </label>
                <span>
                <input type="radio" id="radio_1" name="1">
                <label for="radio_1"></label>
                Buy </span> <span>
                <input type="radio" id="radio_2" name="1">
                <label for="radio_2"></label>
                Rent </span></li>

                            <li>
                                <label>State
                                    <small>*</small>
                                </label>
                                <select class="dropdown">
                                    <option>-- select your State --</option>
                                    <option>chennai</option>
                                </select>
                            </li>
                            <li>
                                <label>City
                                    <small>*</small>
                                </label>
                                <select class="dropdown">
                                    <option>-- select your City --</option>
                                    <option>chennai</option>
                                </select>
                            </li>
                            <li>
                                <label>Location
                                    <small>*</small>
                                </label>
                                <select class="dropdown">
                                    <option>-- select your Location --</option>
                                    <option>chennai</option>
                                </select>
                            </li>
                            <li>
                                <label>Bedrooms
                                    <small>*</small>
                                </label>
                                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox">
                                    <option selected value="saab">1 BHK</option>
                                    <option value="opel">2 BHK</option>
                                    <option value="mercedez">3 BHK</option>
                                    <option value="aston-martin">4 BHK</option>
                                    <option value="hyundai">5 BHK</option>
                                    <option value="mitsubishi">6 BHK</option>
                                </select>
                            </li>
                            <li class="area_input">
                                <label>Covered/Built-up Area
                                    <small>*</small>
                                </label>
                                <input type="text">
                                To
                                <input type="text">
                                <select class="dropdown">
                                    <option>Sq. Ft</option>
                                    <option>Sq. Mtr</option>
                                </select>
                            </li>
                            <li class="buget_input">
                                <label>Budget
                                    <small>*</small>
                                </label>
                                <select class="dropdown">
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select> To
                                <select class="dropdown">
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li>
                                <label>Alert Property
                                    <small>*</small>
                                </label>
                                <span>
                                      <input type="radio" id="radio_1" name="1">
                                      <label for="radio_1"></label> Daily
                                </span>
                                <span>
                                    <input type="radio" id="radio_2" name="1">
                                    <label for="radio_2"></label> Weekly
                                </span>
                            </li>
                            <li class="spam_input">
                                <label> Spam Check
                                    <small>*</small>
                                </label>
                                6 - 2 =
                                <input type="text">
                                <span>Please answer this simple math question</span></li>
                            <li class="log_face">
                                <label>I am
                                    <small>*</small>
                                </label>
                <span>
                <input type="radio" id="radio_3" name="1">
                <label for="radio_3"></label>
                Existing User </span> <span>
                <input type="radio" id="radio_4" name="1">
                <label for="radio_4"></label>
                New User </span></li>
                            <li>
                                <label>Username / Email id
                                    <small>*</small>
                                </label>
                                <input type="text">
                            </li>

                            <li>
                                <label>Password
                                    <small>*</small>
                                </label>
                                <input type="text">
                            </li>
                            <li class="sub_btn_li">
                                <input type="button" value="Submit" class="btn_5">
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

    <!-- forget password start -->
    <div class="forget_pop">
        <div class="pop_wrapper">
            <h1 class="h_2">Forget Password
                <span id="close_pop"> <i class="fa fa-close"></i> </span>
            </h1>

            <div class="for_para">
                <p>
                    Enter the username or email id you provided when you registered on Magicbricks.com. A reset password
                    link will be sent on your registered email id.

                </p>
    <span>
    <label>Username </label>
    <input type="text">
    </span>
                Or
    <span>
        <label>Email </label>
    <input type="text">
    </span>
    <span>
     I agree to MagicBricks' <a href="#">Terms & Conditions.</a>
     </span>
                <input type="button" value="Submit" class="btn_5">

                <p>
                    If you've signed up with Facebook, please visit your Facebook account to retrieve your password and
                    login again.

     <span>
     Contact customer care at: 0124-4869300
     </span>
                </p>
            </div>

        </div>
    </div>
    <!-- forget password end -->
</main>
<!--script start-->
<script src="js/jquery.easydropdown.js"></script>
<!-- tab script start-->
<script type="text/javascript">
    $(document).ready(function () {

        $('#forget_pass').click(function () {
            $('.forget_pop').fadeIn();
        });


        $('#close_pop').click(function () {
            $('.forget_pop').fadeOut();
        });


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
<!--script end-->
</body>
</html>
