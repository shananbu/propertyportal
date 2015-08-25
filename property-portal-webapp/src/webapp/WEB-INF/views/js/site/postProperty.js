$(document).ready(function(){
    $("#drpDwnState").change(function() {
        $.ajax({
            url: "/rest/v1/admin/modules/get/stateByCityId?stateId=" + $("#drpDwnState").val()
        }).done(function(data) {

            $.each(data.module[0].moduleResponse.cities, function() {
                alert(this.name);
                $("#drpDwnCity").append(new Option(this.id, this.name));
            });
        });
    });
});