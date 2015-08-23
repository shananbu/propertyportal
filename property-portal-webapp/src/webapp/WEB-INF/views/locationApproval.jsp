<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Location Approval</title>
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
            oTable = $('#locationApprovalTable').dataTable({
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
                <div class="title"> Location Approval</div>
                <div class="box_block row_main text_center">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                   &nbsp;
                            </td>
                            <td>

                            </td>
                            <td>

                            </td>
                            <td>

                            </td>
                        </tr>
                        </table>
                    </div>
                <div class="row_main tab_size clr_fix mar_bot">
                    <!-- jq_table start-->
                    <div class="jq_table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display" id="locationApprovalTable">
                            <thead>
                            <tr>
                                <th><input type="checkbox"/></th>
                                <th>Location</th>
                                <th>City</th>
                                <th>Created date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="odd gradeX">
                                <td><input type="checkbox"/></td>
                                <td>Chennai</td>
                                <td>Chrompet</td>
                                <td>12-JAN-2015</td>
                            </tr>
                            <tr class="even gradeX">
                                <td><input type="checkbox"/></td>
                                <td>Chennai</td>
                                <td>New street</td>
                                <td>13-JAN-2015</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- jq_table end-->
                </div>
                <div class="box_block row_main text_center">
                         <table>
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
        </article>
    </section>
</main>
</body>
</html>
