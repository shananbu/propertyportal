$(document).ready(function(){
    $("#advtStatus").change(loadData);

    $("#btnReload").click(loadData);

    $("#btnApprove").click(function(){
        $.each($('tbody tr td input[type="checkbox"]'), function() {
            if( $(this).prop('checked') == true) {
                alert($(this).prop('id'));
            }
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
                $('#advertisementApprovalTable tr').last().after('<tr class="odd gradeX"><td><input type="checkbox" id="' + this.id + '"/></td><td>' + this.companyName + '</td><td>' + this.projectName + '</td><td>' + this.propertyTypeName + '</td><td>' + this.locationName  + '</td><td>' + this.propertyForTypeName + '</td><td><a target="_blank" href="projectOverview?advertisementId=' + this.id + '">View</a></td></tr>');
            });
        });
    }

});
