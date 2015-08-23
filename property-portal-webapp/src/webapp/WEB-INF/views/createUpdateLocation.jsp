<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create / Update Location</title>
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
    <link href="css/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css">
    <script src="js/site/createUpdateLocation.js"></script>

/head>
<body>
<form method="post" id="frmLocation" commandName="moduleRequest" action="saveOrUpdateLocation">
<main class="wrapper clr_fix">
    <%@ include file="adminHeader.jsp" %>
    <section class="row_main clr_fix">
        <aside class="aside_left clr_fix">
            <%@ include file="adminMenu.jsp" %>
        </aside>
        <article class="right_art clr_fix">
            <div class="row_main col_1 clr_fix mar_bot">
                <div class="title"> Create / Update Location</div>
                <div class="box_block row_main text_center">
                    <label class="label_cus" name="">${response.messages[0].message}</label>
                    <table>
                        <tr>
                            <td>
                                <table border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td>
                                            <label class="label_right">City </label>
                                        </td>
                                        <td class="td_left">
                                            <select  name="location.parentId" id="parentId">
                                                <option value="-1">--Select--</option>
                                                <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                                                    <option value="${data.id}">${data.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="label_right">
                                                Location</label>
                                        </td>
                                        <td>
                                            <input id="locationName" type="text" name="location.name" required placeholder="Enter location">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="td_right_align">
                                            <input type="submit" value="Create">
                                        </td>
                                        <td class="td_right_align">
                                            <input type="reset" value="reset">
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <hr class="name-of-your-vertical-line">
                            </td>
                            <td>
                                <table border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td>
                                            <label class="label_right">Location </label>
                                        </td>
                                        <td>
                                            <input id="locationNameForUpdate" type="text" placeholder="Enter location name">
                                            <input type="hidden" id="updateId">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="td_right_align">
                                            <input type="button" value="Update" id="updateButton">
                                        </td>
                                        <td class="td_right_align">
                                            <input type="reset" value="reset">
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </article>
    </section>
</main>
</form>
</body>
</html>
