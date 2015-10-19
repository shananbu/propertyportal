$(document).ready(function(){
    $("#advtStatus").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/advertisementsForApprove?status=" + $("#advtStatus").val()
        }).done(function(data) {
            $.each(data.module[0].moduleResponse.advertisements, function() {
                $('#advertisementApprovalTable tr').last().after('<tr class="odd gradeX"><td><input type="checkbox"/></td><td>' + this.companyName + '</td><td>' + this.projectName + '</td><td>' + this.propertyTypeName + '</td><td>' + this.locationName  + '</td><td>' + this.propertyForTypeName + '</td><td><a href="projectOverview?advertisementId=' + this.id + '">View</a></td></tr>');
            });
        });
    });
});
