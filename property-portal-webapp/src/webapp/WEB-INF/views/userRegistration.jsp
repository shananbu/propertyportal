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
<form method="post" commandName="moduleRequest" action="registerUser">
<main class="main_wrapper clr_fix">
  <header class="clr_fix top_head">
      <%@ include file="userHeader.jsp" %>
  </header>
  <section class="clr_fix sec_main">
    <div class="row_main box_shadow">
      <section class="col_4 clr_fix">
        <section class="inner_wrapper">
          <h1 class="h_2">New User Registration</h1>
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
                <small>[ Password only consists of a-z, 0-9, (_) ] [ Min. 6 char and Max. 12 char ]</small>
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
                <input type="submit" value="Register Now" class="btn_5">
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
