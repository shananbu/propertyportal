<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin User</title>
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
    <script src="js/jquery/jquery-1.11.2.min.js"></script>
    <script src="js/jquery/jquery-ui-1.11.2.min.js"></script>
    <script src="js/site/adminUserCreation.js"></script>

    <!-- jq_table script start-->
    <link href="css/demo_table.css" rel="stylesheet" type="text/css">
    <link href="css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf-8">
        $(document).ready(function () {
            var table = $('#userListingTable').dataTable({
                "bJQueryUI": true,
                "bAutoWidth": true,
                "bSort": true,
                "bScrollCollapse": false,
                "sScrollY": "190px",
                "sPaginationType": "full_numbers",
                "ajax": {
                    "url": "rest/v1/admin/modules/get/advertisePlanList",
                    "dataSrc": "module.0.moduleResponse.plans"
                },
                "columns": [
                    { "data": "name" },
                    { "data": "userTypeName" },
                    { "data": "cost", "sClass": "right" },
                    { "data": "validDays", "sClass": "right" },
                    { "data": "numberOfImages", "sClass": "right" },
                    { "data": "description" },
                    { "data": "id" },
                    { "data": "id" }
                ],
                "columnDefs": [
                    {
                        "targets": [ 6 ],
                        "visible": false,
                        "searchable": false
                    },
                    {
                        "targets": [ 7 ],
                        "visible": false,
                        "searchable": false
                    }
                ]
            });

        });
    </script>
    <!-- jq_table script end-->

</head>
<body>
<form method="post" commandName="moduleRequest" action="saveOrUpdateAdminUser">
<main class="wrapper clr_fix">
    <%@ include file="adminHeader.jsp" %>
    <section class="row_main clr_fix">
        <aside class="aside_left clr_fix">
            <%@ include file="adminMenu.jsp" %>
        </aside>
        <article class="right_art clr_fix">
            <div class="row_main col_1 clr_fix mar_bot">
                <div class="title"> Admin User Registration</div>
                <div class="box_block row_main text_center">
                    <label class="label_cus" name="">${response.messages[0].message}</label>
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <label class="label_right">Name </label>
                            </td>
                            <td class="td_left">
                                <input id="firstName" type="text" name="adminUser.firstName" required placeholder="Enter admin firstname">
                                <input type="hidden" id="id" name="adminUser.id">
                            </td>
                            <td>
                                <label class="label_right">User Name </label>
                            </td>
                            <td class="td_left">
                                <input id="userName" type="text" name="adminUser.userName" required placeholder="Enter admin username">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="label_right">Designation </label>
                            </td>
                            <td class="td_left">
                                <input type="text" id="designation" name="adminUser.designation" required placeholder="Enter designation">
                            </td>
                            <td>
                                <label class="label_right">Password </label>
                            </td>
                            <td class="td_left">
                                <input type="password" id="password" name="adminUser.password" required placeholder="Enter password">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="label_right">EMail </label>
                            </td>
                            <td class="td_left">
                                <input id="email" type="text" name="adminUser.mailId" <%--pattern="[a-zA-Z]{3,}@[a-zA-Z]{3,}[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,}"--%> required placeholder="Enter your Email">
                            </td>
                            <td>
                                <label class="label_right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Confirm Password </label>
                            </td>
                            <td>
                                <input type="password" id="cPassword" name="cPassword" required placeholder="Enter password">
                            </td>
                        </tr>

                        <tr>
                            <td >
                                <label class="label_right">Phone Number </label>
                            </td>
                            <td class="td_left">
                                <input type="text" id="phoneNumber" name="adminUser.phoneNumber" required placeholder="Enter Phone Number">
                            </td>
                            <td>
                                <label class="label_right">Date Of Joining </label>
                            </td>
                            <td class="td_left">
                                <input type="date" id="doj" name="adminUser.doj" required placeholder="Date of Joining">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="label_right">Status </label>
                            </td>
                            <td class="td_left">
                                <select name="adminUser.status" id="status">
                                    <option value="-1">--Select--</option>
                                    <c:forEach var="statusData" items="${response.module[0].moduleResponse.statusData}">
                                        <option value="${statusData.statusId}">${statusData.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <label class="label_right">Date Of Resign </label>
                            </td>
                            <td class="td_left">
                                <input type="date" id="dor" name="adminUser.dor" required placeholder="Date of Resign">
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
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="userListingTable">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Designation</th>
                            <th>EMail</th>
                            <th>Phone Number</th>
                            <th>User Name</th>
                            <th>Status</th>
                            <th>Date Of Joining</th>
                            <th>id</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="data" items="${response.module[0].moduleResponse.adminUsers}" varStatus="seqNo">
                            <tr>
                                <td>${data.firstName}</td>
                                 <td>${data.designation}</td>
                                <td>${data.mailId}</td>
                                <td>${data.phoneNumber}</td>
                                <td>${data.userName}</td>
                                <td>${data.doj}</td>
                                <td>${data.statusType}</td>
                                <td>${data.id}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
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

