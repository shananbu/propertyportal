<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>Contact us</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<main class="main_wrapper clr_fix">
    <header class="clr_fix top_head">
        <%@ include file="userHeader.jsp" %>
    </header>
    <!-- contact page start -->
    <section class="clr_fix">
        <div class="row_main cont_info box_shadow">
            <div class="cont_left">
                <h1 class="h_2">contact Address</h1>
                <h2>1AcreIndia </h2>
                <div><i class="fa fa-map-marker"></i>
                    <p> No. 3A Railway Station Road,<br> Kilambakkam,<br> Chennai-603210, India.  </p>
                </div>
                <div><i class="fa fa-phone"></i>
                    <p>### - #######</p>
                </div>
                <div class="address_1 clearfix"><i class="fa fa-envelope"></i>
                    <p> <a href="mailto:support@1acreindia.com"> support@1acreindia.com </a> </p>
                </div>
            </div>
            <div class="clr_fix contact_map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d60409.713620763425!2d80.25567601081691!3d13.083917518335932!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a5265ea4f7d3361%3A0x6e61a70b6863d433!2sChennai%2C+Tamil+Nadu!5e0!3m2!1sen!2sin!4v1440562128275" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
        </div>
    </section>
    <!-- contact page end -->

    <!-- footer start -->
    <footer class="clr_fix foot_main">
        <%@ include file="userFooter.jsp" %>
    </footer>
    <!-- footer end -->
</main>

</body>
</html>
