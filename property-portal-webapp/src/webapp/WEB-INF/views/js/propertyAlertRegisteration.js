$(document).ready(function(){
    $("#drpDwnState").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/stateByCityId?stateId=" + $("#drpDwnState").val()
        }).done(function(data) {
            $('#drpDwnCity').empty();
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnCity')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
    });

    $("#drpDwnCity").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/locationByCityId?locationId=" + $("#drpDwnCity").val()
        }).done(function(data) {
            $('#drpDwnLocation').empty();
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnLocation')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
    });
});