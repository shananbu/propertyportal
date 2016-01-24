<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
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
    <script type="text/javascript" charset="utf-8">
        $(document).ready(function () {
            oTable = $('#example').dataTable({
                "bJQueryUI": true,
                "bAutoWidth": true,
                "bSort": true,
                //"sScrollX": "100%",
                "bScrollCollapse": false,
                "sScrollY": "200px",
                "sPaginationType": "full_numbers"
            });
        });
    </script>
    <!-- jq_table script end-->

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
    <div class="title"> Dashboard</div>
    <div class="box_block row_main text_center">
        <div class="row_main tab_size_50_right clr_fix mar_bot">
            <div class="title1"> Advertisement</div>

            <table border="0" cellspacing="0" cellpadding="4">
                <tr>
                    <td>
                        <label class="label_right">Newly created this month </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">100 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created this week </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">10 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created today </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">4 </label>
                    </td>
                </tr>
                </table>
        </div>

        <div class="row_main tab_size_50_left clr_fix mar_bot">
            <div class="title2"> Property developer</div>
            <table border="0" cellspacing="0" cellpadding="4">
                <tr>
                    <td>
                        <label class="label_right">Newly created this month </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">100 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created this week </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">10 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created today </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">4 </label>
                    </td>
                </tr>
            </table>

        </div>
        <div> &nbsp;</div>
        <div class="row_main tab_size_50_left clr_fix mar_bot">
            <div class="title2"> Location</div>
            <table border="0" cellspacing="0" cellpadding="4">
                <tr>
                    <td>
                        <label class="label_right">Newly created this month </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">100 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created this week </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">10 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created today </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">4 </label>
                    </td>
                </tr>
            </table>
        </div>
        <div class="row_main tab_size_50_right clr_fix mar_bot">
            <div class="title1"> Alerts</div>
            <table border="0" cellspacing="0" cellpadding="4">
                <tr>
                    <td>
                        <label class="label_right">Newly created this month </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">100 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created this week </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">10 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">Newly created today </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">4 </label>
                    </td>
                </tr>
            </table>
        </div>
        <div> &nbsp;</div>
        <div class="row_main tab_size_50_right clr_fix mar_bot">
            <div class="title1"> Advertisement Search</div>

            <table border="0" cellspacing="0" cellpadding="4">
                <tr>
                    <td>
                        <label class="label_right">New search this month </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">100 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">New search this week </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">10 </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="label_right">New search today </label>
                    </td>
                    <td class="td_left">
                        <label class="label_right">4 </label>
                    </td>
                </tr>
            </table>
        </div>
        </div>
    </div>
</div>
</article>
</section>
</main>
</body>
</html>
