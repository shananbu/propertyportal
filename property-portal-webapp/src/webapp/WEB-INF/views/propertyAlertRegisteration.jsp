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
            window.asd = $('.SlectBox').SumoSelect({ csvDispCount: 3});
            window.test = $('.testsel').SumoSelect({okCancelInMulti: true });
            window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti: true});
            window.testSelAll2 = $('.testSelAll2').SumoSelect({selectAll: true });
        });
    </script>
    <script src="js/propertyAlertRegisteration.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
    </header>
    <section class="clr_fix sec_main">
    <form method="post" id="frmPost" commandName="moduleRequest" action="registerPropertyAlert">
    <div class="row_main box_shadow">
            <section class="col_4 clr_fix">
                <section class="inner_wrapper">
                    <h1 class="h_2">Post Requirement for Property</h1>
                    <div class="user_register post_buy_pro jq_chk">
                        <ul>
                            <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS')">
                                <li class="log_face">
                                    <label>I am
                                        <small>*</small>
                                    </label>
                                    <span>
                                        <input type="radio" id="radio_5" name="1" data-modal="modal-11" class="md-trigger">
                                        <label for="radio_5"></label>
                                        Existing User
                                    </span>
                                    <span>
                                        <input type="radio" id="radio_6" name="1" data-modal="modal-10" class="md-trigger">
                                        <label for="radio_6"></label>
                                        New User
                                  </span>
                                </li>
                            </sec:authorize>
                            <li>
                                <label>I want to
                                    <small>*</small>
                                </label>
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.propertyForTypes}">
                                        <span>
                                            <input type="radio" id="0${data.id}" value="0${data.id}" name="alertRegistration.propertyForTypeId" checked>
                                            <label for="0${data.id}"></label>
                                            ${data.nameForFinder}
                                        </span>
                                    </c:forEach>
                            </li>
                            <li>
                                <label>State
                                    <small>*</small>
                                </label>
                                <select class="dropdown" id="drpDwnState">
                                    <option value="-1">--Select--</option>
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.states}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li>
                                <label>City
                                    <small>*</small>
                                </label>
                                <select class="dropdown" id="drpDwnCity">
                                </select>
                            </li>
                            <li>
                                <label>Location
                                    <small>*</small>
                                </label>
                                <select class="SlectBox" id="drpDwnLocation"  multiple="multiple" name="alertRegistration.locations">
                                </select>
                            </li>
                            <li>
                                <label>Bedrooms
                                    <small>*</small>
                                </label>
                                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="alertRegistration.bedRooms">
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li class="area_input">
                                <label>Covered/Built-up Area
                                    <small>*</small>
                                </label>
                                <input type="text" name="alertRegistration.buildupAreaFrom">
                                To
                                <input type="text" name="alertRegistration.buildupAreaTo">
                                <select class="dropdown" name="alertRegistration.buildupAreaUnitId">
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.units}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li class="buget_input" name="alertRegistration.buildupAreaTo">
                                <label>Budget
                                    <small>*</small>
                                </label>
                                <select class="dropdown" name="alertRegistration.budgetId">
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
                                      <input type="radio" id="radio_3" name="alertRegistration.alertFrequency" value="1">
                                      <label for="radio_3"></label> Daily
                                </span>
                                <span>
                                    <input type="radio" id="radio_4" name="alertRegistration.alertFrequency" value="2">
                                    <label for="radio_4"></label> Weekly
                                </span>
                            </li>
                            <li class="sub_btn_li">
                                <input type="submit" value="Submit" class="btn_5">
                            </li>
                        </ul>
                    </div>
                </section>
            </section>
        </div>
    </form>
        <!-- registe pop up start -->

        <div class="md-modal md-effect-10" id="modal-10">
            <div class="md-content pop_up_reg">
                <h1 class="h_2">New User Registration</h1>
                <i class="fa fa-times-circle md-close"></i>
                <div class="user_register jq_chk">
                    <ul>
                        <li>
                            <label>User Type<small>*</small></label>
                <span>
                <input id="usertype1" name="propertyUser.userTypeId" type="radio" value="1" checked="checked">
                <label for="usertype1"></label>
                Owner </span> <span>
               <input id="usertype2" name="propertyUser.userTypeId" type="radio" value="2">
                <label for="usertype2"></label>
                Agent </span> <span>
                <input id="usertype3" name="propertyUser.userTypeId" type="radio" value="3">
                <label for="usertype3"></label>
                Builder </span>
                        </li>
                        <li>
                            <label>Builder/Company Name<small>*</small></label>
                            <input id="builderName" name="propertyUser.builderName" type="text" value="" maxlength="30" placeholder="Company Name">
                        </li>
                        <li>
                            <label>First Name<small>*</small></label>
                            <input id="firstName" name="propertyUser.firstName" type="text" value="" maxlength="30" placeholder="First Name">
                        </li>
                        <li>
                            <label>Last Name<small>*</small></label>
                            <input id="lastName" name="propertyUser.lastName" type="text" value="" maxlength="30" placeholder="Last Name">
                        </li>

                        <li>
                            <label>Email<small>*</small></label>
                            <input id="emailId" name="propertyUser.emailId" class="txt" type="text" value="" maxlength="30" placeholder="Email">
                        </li>
                        <li>
                            <label>Password<small>*</small></label>
                            <input id="passwrd" name="propertyUser.passwrd" class="txt" type="password" value="" maxlength="30" placeholder="Password">
                            <small></small>
                        </li>
                        <li>
                            <label>Confirm Password<small>*</small></label>
                            <input id="cpasswrd" name="cpasswrd" class="txt" type="password" value="" maxlength="30" placeholder="Confirm Password">
                        </li>

                        <li class="mobile_drop">
                            <label>Mobile<small>*</small></label>
                            <select class="dropdown">
                                <option value="91">IND +91</option>
                            </select>
                            <input id="mobile" name="propertyUser.mobileNo" class="txt" type="text" value="" maxlength="30" placeholder="Mobile Number">
                        </li>
                        <li>
                            <p>
                                <input type="checkbox" id="check_1">
                                <label for="check_1"></label>
                                I agree to 1AcreIndia's Terms of Use. I would like to receive property related communication through Email, Call or SMS. </p>
                        </li>
                        <li>
                            <input type="submit" value="Register Now" class="btn_5" name="btnRegisterUser" id="btnRegisterUser">
                        </li>
                    </ul>
                </div>

            </div>
        </div>


        <div class="md-modal md-effect-10" id="modal-11">
            <div class="md-content pop_up_reg">
                <h1 class="h_2">Login here</h1>
                <i class="fa fa-times-circle md-close"></i>
                <div class="user_register jq_chk">
                    <ul>
                        <li>
                            <label>Email Id</label>
                            <input type="email" placeholder="Username" name="username">
                        </li>
                        <li>
                            <label>Password</label>
                            <input type="password" placeholder="Password" name="password">
                        </li>
                        <li>
                            <input type="button" class="btn_5" value="Login"  name="btnUserLogin" id="btnUserLogin">
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="md-overlay"></div>

        <!-- registe pop up end -->
    </section>
    <!-- footer start -->
    <footer class="clr_fix foot_main">
        <%@ include file="userFooter.jsp" %>
    </footer>
    <!-- footer end -->

</main>
<!--script start-->
<!-- pop up js start -->
<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>
<!-- pop up js end -->
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
