<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Account activation</title>
    <meta charset="utf-8"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
        To post advertisement login <a href="userLogin">here</a>
    </header>
    <section class="clr_fix">
        <div class="row_main terms_cond box_shadow">
            <h1 class="h_2">
                Your account is successfully activated.
            </h1>
        </div>
        <!-- footer start -->
        <footer class="clr_fix foot_main">
            <%@ include file="userFooter.jsp" %>
        </footer>
        <!-- footer end -->
</main>

</body>
</html>
