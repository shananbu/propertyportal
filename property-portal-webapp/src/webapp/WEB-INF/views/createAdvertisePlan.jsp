<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Package creation</title>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <!-- Font Icon-->
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <!-- custom css-->

    <link href="css/main_style.css" rel="stylesheet" type="text/css">

    <script src="js/modernizr-2.6.2.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/nav_menu.js"></script>

    <!-- aside nav menu end-->
    <!-- jq_table script start-->
    <script src="js/jquery/jquery-1.11.2.min.js"></script>
    <script src="js/jquery/jquery-ui-1.11.2.min.js"></script>
    <script src="js/jquery/jquery.dataTables.min-1.10.7.js"></script>
    <link href="css/jquery.dataTables_1.10.7.css" rel="stylesheet" type="text/css">
    <link href="css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css">
    <script src="js/site/createAdvertisePlan.js"></script>

    <!-- jq_table script end-->

</head>
<body>
<form method="post" commandName="moduleRequest" action="saveOrUpdateAdvertisePlan">
<main class="wrapper clr_fix">
    <%@ include file="adminHeader.jsp" %>
    <section class="row_main clr_fix">
        <aside class="aside_left clr_fix">
            <%@ include file="adminMenu.jsp" %>
        </aside>
        <article class="right_art clr_fix">
            <div class="row_main col_1 clr_fix mar_bot">
                <div class="title"> Advertise Plan </div>
                <div class="box_block row_main text_center">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <label class="label_right">Package Name </label>
                            </td>
                            <td class="td_left">
                                <input id="planName" type="text" name="plan.name" required placeholder="Enter Package Name">
                                <input id="planId" type="hidden" name="plan.id">
                            </td>
                            <td>
                                <label class="label_right">Valid Days </label>
                            </td>
                            <td class="td_left">
                                <input id="validDays" type="text" name="plan.validDays" required placeholder="Enter Valid Days">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="label_right">Package Cost </label>
                            </td>
                            <td class="td_left">
                                <input id="cost" type="text" name="plan.cost" required placeholder="Enter cost">
                            </td>
                            <td>
                                <label class="label_right">Max No. of images </label>
                            </td>
                            <td class="td_left">
                                <input id="numberOfImages" type="text" name="plan.numberOfImages" required placeholder="Enter Max No. of images">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="label_right">User Type </label>
                            </td>
                            <td colspan="3" class="td_left">
                                <select name="plan.userTypeId" id="userTypeId">
                                    <option value="-1">--Select--</option>
                                    <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                                        <option value="${data.id}">${data.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr style="display:table-row">
                            <td>
                                <label class="label_right">Package highlights </label>
                            </td>
                            <td colspan="3">
                                <textarea rows=5 cols=80 name="plan.description" id="description"></textarea>
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td></td>
                            <td class="td_right_align">
                                <input type="submit" value="submit">
                            </td>
                            <td class="td_right_align">
                                <input type="reset" value="reset">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="row_main col_1 clr_fix mar_bot">
                <!-- jq_table start-->
                <div class="jq_table">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="packageListingTable">
                        <thead>
                        <tr>
                            <th>Package Name</th>
                            <th>User Type</th>
                            <th>Package Cost</th>
                            <th>Valid Days</th>
                            <th>Max No. of images</th>
                            <th>Highlights</th>
                            <th>id</th>
                            <th>userTypeId</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
                <!-- jq_table end-->
            </div>
        </article>
    </section>
</main>
</form>
</body>
</html>
