<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Feedback</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
    </header>
    <section class="clr_fix sec_main">
        <div class="row_main">
            <section class="clr_fix">
                    <div class="cont_right">
                        <div class="left_login clr_fix box_shadow">
                            <div class="log_head clr_fix"><b class="title_login">Feedback Form</b></div>
                            <ul>
                                <li>
                                    <input type="text" placeholder="Name">
                                </li>
                                <li>
                                    <input type="text" placeholder="Mobile">
                                </li>
                                <li>
                                    <input type="text" placeholder="Mail Id">
                                </li>
                                <li>
                                    <textarea placeholder="Message"></textarea>
                                </li>
                                <li class="log_for">
                                    <input type="button" value="Submit" class="sub_btn_3">
                                </li>
                            </ul>
                        </div>
                    </div>
            </section>
        </div>
    </section>
    </section>
    <!-- footer start -->
    <footer class="clr_fix foot_main">
        <%@ include file="userFooter.jsp" %>
    </footer>
    <!-- footer end -->
</main>

</body>
</html>
