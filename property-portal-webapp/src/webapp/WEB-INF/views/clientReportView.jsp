<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clent Report</title>
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
    <link href="css/demo_table.css" rel="stylesheet" type="text/css">
    <link href="css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
</head>
<body>
<main class="wrapper clr_fix">
    <section class="row_main clr_fix">
        <div class="row_main col_1 clr_fix mar_bot">
            <div class="title">Client Report</div>
            <div class="box_block row_main text_center">
                <table border="1" cellspacing="0" cellpadding="3">
                    <tr>
                        <td>
                            First Name
                        </td>
                        <td>
                            Last Name
                        </td>
                        <td>
                            Builder Name
                        </td>
                        <td>
                            Email-ID / User Name
                        </td>
                        <td>
                            City
                        </td>
                        <td>
                            Mobile No
                        </td>
                        <td>
                            Is Mail Verified
                        </td>
                    </tr>
                    <c:forEach var="user" items="${response.module[0].moduleResponse.propertyUsers}">
                        <tr>
                            <td>
                                    ${user.firstName}
                            </td>
                            <td>
                                    ${user.lastName}
                            </td>
                            <td>
                                    ${user.builderName}
                            </td>
                            <td>
                                    ${user.emailId}
                            </td>
                            <td>
                                City
                            </td>
                            <td>
                                    ${user.mobileNo}
                            </td>
                            <td>
                                    ${user.isMailVerified}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        </article>
    </section>
</main>
</body>
</html>


