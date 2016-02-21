<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Advertisement Approval</title>
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
            oTable = $('#advertisementApprovalTable').dataTable({
                "bJQueryUI": true,
                "bAutoWidth": true,
                "bSort": false,
                "bFilter": false,
                //"sScrollX": "100%",
                "bScrollCollapse": false,
                "sScrollY": "300px",
                "sPaginationType": "full_numbers",
                "oLanguage": {"sZeroRecords": "", "sEmptyTable": ""}
            });
        });
    </script>
    <!-- jq_table script end-->
    <script type="text/javascript" language="javascript" src="js/site/advertisementApproval.js"></script>
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
                <div class="title"> Advertisement Approval</div>
                <div class="box_block row_main text_center">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <label class="label_right">Status </label>
                            </td>
                            <td class="td_left">
                                <select id="advtStatus">
                                    <option value="false">UnApproved</option>
                                    <option value="true">Approved</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="row_main col_1 clr_fix mar_bot">
                    <!-- jq_table start-->
                    <div class="jq_table">
                        <table cellpadding="0" cellspacing="0" border="0" class="display" id="advertisementApprovalTable">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="allCheck"/></th>
                                <th>Property Developer Name</th>
                                <th>Name of Project/Society</th>
                                <th>Property Type</th>
                                <th>Location</th>
                                <th>Property For</th>
                                <th>Advertisement Type</th>
                                <th>View details</th>
                            </tr>
                            </thead>
                            <tbody>
<%--                            <tr class="odd gradeX">
                                <td><input type="checkbox"/></td>
                                <td>Ardente Realtors Pvt. Ltd</td>
                                <td>Pine Grove</td>
                                <td>Multistorey Apartment</td>
                                <td>Chennai north</td>
                                <td>Sale</td>
                                <td><a href="">View</a></td>
                            </tr>--%>
<%--                            <tr class="even gradeX">
                                <td><input type="checkbox"/></td>
                                <td>Ardente Realtors Pvt. Ltd</td>
                                <td>Pine Grove</td>
                                <td>Multistorey Apartment</td>
                                <td>Chennai north</td>
                                <td>Sale</td>
                                <td><a href="">View</a></td>
                            </tr>--%>

                            </tbody>
                        </table>
                    </div>
                    <!-- jq_table end-->
                </div>
                <div class="box_block row_main text_center">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="td_right_align">
                                <input type="button" value="Approve" id="btnApprove">
                            </td>
                            <td class="td_right_align">
                                <input type="button" value="Reload" id="btnReload">
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
