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
            <c:set var="imageClass" scope="request" value="fa fa-check-square-o fa-5x"/>
            <c:set var="screenType" scope="request" value="success-screen"/>
            <c:if test="${not empty imageClassFromResponse}">
                <c:set var="imageClass" scope="request" value="${imageClassFromResponse}"/>
                <c:set var="screenType" scope="request" value="failure-screen"/>
            </c:if>
        </header>
        <section class="clr_fix sec_main">
            <div class="row_main">
                <section class="clr_fix">
                    <div class="clr_fix box-shadow ad_post jq_chk">
                        <div class="ad_3">
                            <ul>
                                <li class="text_center">
                                    <span class='<c:out value="${screenType}"/>'><i class='<c:out value="${imageClass}"/>'></i> </span>
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
