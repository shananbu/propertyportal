$(document).ready(function() {
    var advtApprovalTable = $('#advertisementApprovalTable').dataTable({
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

    loadData();

    $("#advtStatus").change(loadData);

    $("#btnReload").click(loadData);

    $("#btnApprove").click(function(){
        var requestData = getApprovalRequestData();
        $.ajax({
            method: "POST",
            contentType: 'application/json',
            url: "rest/v1/admin/modules/update/approveOrRejectAdvertisements",
            data: requestData
        })
            .done(function( msg ) {
                alert("Updated the Advertisement(s)");
                loadData();
            });
    });

    $('#allCheck').change(function () {
        $('tbody tr td input[type="checkbox"]').prop('checked', $(this).prop('checked'));
    });

    function loadData(){
        $.ajax({
            url: "rest/v1/admin/modules/get/advertisementsForApprove?status=" + $("#advtStatus").val()
        }).done(function(data) {
            $('#advertisementApprovalTable').dataTable().fnClearTable();
            //advtApprovalTable.clear();
            $.each(data.module[0].moduleResponse.advertisements, function() {
                var isChecked = "";
                if($("#advtStatus").val() == "true") {
                    isChecked = "checked";
                }
  //              var checkBox = '<input type="checkbox" ' + isChecked + ' id="' + this.id + '"/>';
//                var viewUrl = '<a target="_blank" href="projectOverview?advertisementId=' + this.id + '&isMicroSite=' + this.isMicroSite + '">View</a>';
                $('#advertisementApprovalTable tr').last().after('<tr class="odd gradeX"><td><input type="checkbox" ' + isChecked + ' id="' + this.id + '"/></td><td>' + this.companyName + '</td><td>' + this.projectName + '</td><td>' + this.propertyTypeName + '</td><td>' + this.locationName  + '</td><td>' + this.propertyForTypeName + '</td><td>' + this.advtTypeName + '</td><td><a target="_blank" href="projectOverview?advertisementId=' + this.id + '&isMicroSite=' + this.isMicroSite + '">View</a></td><td>Edit</td></tr>');

//                advtApprovalTable.row.add([checkBox, this.companyName, this.projectName, this.propertyTypeName, this.locationName, this.propertyForTypeName, this.advtTypeName, viewUrl, 'Edit']).draw(false);
            });
            setButtonCaption();

        });
    }

    function getApprovalRequestData() {
        var requestBody = {
            "advertisements": []
        }
        var advertisements = [];

        $.each($('tbody tr td input[type="checkbox"]'), function() {
            var advertisement = {
                  "id":  + $(this).prop('id'),
                  "isApproved": $(this).prop('checked')
            };
            advertisements.push(advertisement);
        });
        $.extend(requestBody.advertisements, advertisements);
        return JSON.stringify(requestBody);
    }

    function setButtonCaption() {
        if($("#advtStatus").val() == 'true') {
            $("#btnApprove").val("Un Approve");
        } else if($("#advtStatus").val() == 'false') {
            $("#btnApprove").val("Approve");
        }
    }

});
