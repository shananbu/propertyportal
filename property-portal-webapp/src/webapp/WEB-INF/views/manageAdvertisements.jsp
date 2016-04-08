<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Post Property In Microsite</title>

    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/img_upload.css" type="text/css"/>
    <script src="js/modernizr-2.6.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.min.js"></script>

    <link href="css/demo_table.css" rel="stylesheet" type="text/css">
    <link href="css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>

    <script type="text/javascript" charset="utf-8">
        $(document).ready(function () {
            oTable = $('#advertisementTable').dataTable({
                "bJQueryUI": true,
                "bAutoWidth": true,
                "bSort": false,
                "bFilter": false,
                "bScrollCollapse": false,
                "sScrollY": "300px",
                "oLanguage": {"sZeroRecords": "", "sEmptyTable": ""},
                "paging":   false,
                "ordering": false,
                "info":     false
            });
        });
    </script>
</head>
<body>
<form method="post" id="frmPost" commandName="moduleRequest">
<main class="main_wrapper clr_fix">
<header class="clr_fix top_head">
    <%@ include file="userHeader.jsp" %>
</header>
    <section class="clr_fix box-shadow ad_post ">
        <div class="row_main">
            <section class="clr_fix">
                <div class="jq_table">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="advertisementTable">
                        <thead>
                        <tr>
                            <th>S.No</th>
                            <th>Name of Project/Society</th>
                            <th>Property Type</th>
                            <th>Location</th>
                            <th>Property For</th>
                            <th>Advertisement Type</th>
                            <th>Status</th>
                            <th>View</th>
                            <th>Edit</th>
                            <th>Update Gallery</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="data" items="${response.module[0].moduleResponse.advertisements}" varStatus="seqNo">
                            <tr>
                                <td>${seqNo.index + 1}</td>
                                <td>${data.projectName}</td>
                                <td>${data.propertyTypeName}</td>
                                <td>${data.locationName}</td>
                                <td>${data.propertyForTypeName}</td>
                                <td>${data.advtTypeName}</td>
                                <td>${data.description}</td>
                                <td><a target="_blank" href="projectOverview?advertisementId=${data.id}&isMicroSite=${data.isMicroSite}">Preview</a></td>
                                <th><a href="modifyAdvertisement?advertisementId=${data.id}&isMicroSite=${data.isMicroSite}"><i class="fa fa-pencil-square-o"></i></a></th>
                                <th><a href="uploadFile?advertisementId=${data.id}"><i class="fa fa-plus"></i>/<i class="fa fa-minus"></i> <i class="fa fa-file-image-o"></i></a></th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
</form>
</body>
</html>
