<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<!-- Font Icon-->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- custom css-->
<link href="css/login_css.css" rel="stylesheet" type="text/css">
<script src="js/modernizr-2.6.2.min.js"></script>
<script src="js/jquery/jquery-1.11.2.min.js"></script>
<script src="js/site/adminLogin.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<form method="post" class="frmAdminLogin" commandName="moduleRequest"  action="<c:url value='/userLogin'/>">
<header class="header_bg">
  <h1>Property Portal</h1>
</header>
<div class="log_main">
  <div class="log_header"> <span class="text_1"><i class="fa fa-user sign_user"></i> Sign in</span> </div>
  <div class="log_form cus_clr">
    <!--login_block-->
      <label class="label_cus mand" name="">
          <c:if test="${not empty error}">
              <div class="error">${error}</div>
          </c:if>
          <c:if test="${not empty msg}">
              <div class="msg">${msg}</div>
          </c:if>
      </label>
      <div class="login_block">
      <div class="mar_bot_20 icon_text">
        <label class="label_cus"> Username / Email address <span class="mand">*</span> </label>
        <input type="text" class="text_box" placeholder="Username" name="username"<%--name="standardAuth.username"--%>>
        <i class="fa fa-user icon_1"></i> </div>
      <div class="mar_bot_20 icon_text">
        <label class="label_cus"> Password <span class="mand">*</span></label>
        <input type="password" class="text_box" placeholder="Password" name="password" <%--name="standardAuth.password"--%>>
        <i class="fa fa-lock icon_1"></i> </div>
      <div class="mar_bot_20"> <a href="#" class="link_1 forger_pass align_left">Forget Password</a>
        <input type="button" value="Sign In" class="submit align_right">
      </div>
    </div>
  </div>
</div>
<div class="align_center mar_top_20"> Copyright &copy; 2015 - 1AcreIndia.com. All Rights Reserved. </div>
</div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
