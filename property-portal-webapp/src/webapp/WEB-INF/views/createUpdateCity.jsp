<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create City</title>
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
    <script src="js/site/createUpdateCity.js"></script>

</head>
<body>
<form method="post" id="frmCity" commandName="moduleRequest" action="saveOrUpdateCity">
<main class="wrapper clr_fix">
    <%@ include file="adminHeader.jsp" %>
    <section class="row_main clr_fix">
        <aside class="aside_left clr_fix">
            <%@ include file="adminMenu.jsp" %>
        </aside>
        <article class="right_art clr_fix">
            <div class="row_main col_1 clr_fix mar_bot">
                <div class="title"> Create/Update City</div>
                <div class="box_block row_main text_center">
                    <label class="label_cus" name="">${response.messages[0].message}</label>
                    <table>
                        <tr>
                            <td>
                                <table border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td>
                                            <label class="label_right">State </label>
                                        </td>
                                        <td class="td_left">
                                            <select  name="city.parentId" id="parentId">
                                                <option value="-1">--Select--</option>
                                                <c:forEach var="data" items="${response.module[0].moduleResponse.states}">
                                                    <option value="${data.id}">${data.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="label_right">
                                                City</label>
                                        </td>
                                        <td>
                                            <input id="cityName" type="text" name="city.name" required placeholder="Enter city name">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="label_right">
                                                Popular City</label>
                                        </td>
                                        <td  class="td_left">
                                            <input id="isPopularCity" type="checkbox" name="city.isPopular" value="1">
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
                                            <label class="label_right">City </label>
                                        </td>
                                        <td>
                                            <input id="cityNameForUpdate" type="text" placeholder="Enter city name">
                                            <input type="hidden" id="updateId">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="label_right">
                                                Popular City</label>
                                        </td>
                                        <td  class="td_left">
                                            <input id="isPopularCityForUpdate" type="checkbox" >
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
