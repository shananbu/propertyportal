<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Advertisement Report</title>
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

</head>
<body>
<main class="wrapper clr_fix">
    <%@ include file="adminHeader.jsp" %>
    <section class="row_main clr_fix">
        <aside class="aside_left clr_fix">
            <%@ include file="adminMenu.jsp" %>
        </aside>
        <article class="right_art clr_fix">
            <div class="row_main col_1 clr_fix mar_bot">
                <div class="title"> Advertisement Report</div>
                <div class="box_block row_main text_center">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <label class="label_right">Advertisement created date from </label>
                            </td>
                            <td>
                                <input type="date">
                            </td>
                            <td>
                                <label class="label_right">to </label>
                            </td>
                            <td>
                                <input type="date">
                            </td>
                        </tr>

                        <tr style="display:table-row">
                            <td>
                                <label class="label_right">Proprty developer name</label>
                            </td>
                            <td colspan="2" class="td_left">
                                <select>
                                    <option>---Select---</option>
                                </select>
                            </td>
                        </tr>

                        <tr style="display:table-row">
                            <td colspan="4">
                                <input type="submit" value="Get Report">

                                <input type="reset" value="reset">
                            </td>
                        </tr>

                    </table>
                </div>
            </div>
        </article>
    </section>
</main>
</body>
</html>
