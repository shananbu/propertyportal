$(document).ready(function() {
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
            $.each(data.module[0].moduleResponse.advertisements, function() {
                var isChecked = "";
                if($("#advtStatus").val() == "true") {
                    isChecked = "checked";
                }
                $('#advertisementApprovalTable tr').last().after('<tr class="odd gradeX"><td><input type="checkbox" ' + isChecked + ' id="' + this.id + '"/></td><td>' + this.companyName + '</td><td>' + this.projectName + '</td><td>' + this.propertyTypeName + '</td><td>' + this.locationName  + '</td><td>' + this.propertyForTypeName + '</td><td><a target="_blank" href="projectOverview?advertisementId=' + this.id + '">View</a></td></tr>');
            });
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
});
