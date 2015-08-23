<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Access is denied</title>
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
<form>
    <header class="header_bg">
        <h1>Property Portal</h1>
    </header>
    <div class="log_main">
        <div class="log_header"> <span class="text_1"> <h3>HTTP Status 403 - Access is denied</h3></span> </div>
        <div class="log_form cus_clr">
           <div class="login_block">
                <div class="mar_bot_20 icon_text">
                    <c:choose>
                        <c:when test="${empty username}">
                            <h2>You do not have permission to access this page!</h2>
                        </c:when>
                        <c:otherwise>
                            <h2> Sorry ${username}! <br> You do not have permission to access this page!</h2>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <a href="/admindashboard">Home</a>
                </div>
            </div>
        </div>
    </div>
    <div class="align_center mar_top_20"> © Copyright 2014. All Rights Reserved. </div>
    </div>
</form>
</body>
</html>
