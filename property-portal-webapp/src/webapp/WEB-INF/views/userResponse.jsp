<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="app">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Response</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/img_upload.css" type="text/css"/>
    <script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<form method="post" id="frmPost">
    <main class="main_wrapper clr_fix">
        <header class="clr_fix top_head">
            <%@ include file="userHeader.jsp" %>
        </header>
        <section class="clr_fix sec_main">
            <div class="row_main">
                <section class="clr_fix">
                    <div class="clr_fix box-shadow ad_post jq_chk">
                        <div class="ad_3">
                            <ul>
                                <li class="text_center">
                                    <span class="success-screen"><i class="fa fa-check-square-o fa-5x"></i> </span>
                                    <span>
                                         ${response.messages[0].message}
                                    </span>
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
</body>
</html>