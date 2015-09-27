$(document).ready(function(){
    $("#drpDwnState").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/stateByCityId?stateId=" + $("#drpDwnState").val()
        }).done(function(data) {
            $('#drpDwnCity').removeClass("dropdown");
            $('#drpDwnCity').empty();
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnCity')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
           // $('#drpDwnCity').addClass("dropdown");
        });
    });

    $("#drpDwnCity").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/locationByCityId?locationId=" + $("#drpDwnCity").val()
        }).done(function(data) {
            $('#drpDwnLocation').removeClass("dropdown");
            $('#drpDwnLocation').empty();
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnLocation')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
    });

    $("#denominationLakhs").change(function() {
        $("#expectedPrice").val(calculateAmount());
    });

    $("#denominationThousands").change(function() {
        $("#expectedPrice").val(calculateAmount());
    });

    $("#denominationHundreds").change(function() {
        $("#expectedPrice").val(calculateAmount());
    });

    $("#possessionStatus1").click(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/possessionByAvailabilityId?availabilityId=" + $("#possessionStatus1").val()
        }).done(function(data) {
            $('#drpPossessionOrAge').empty();
            $.each(data.module[0].moduleResponse.possessionOrAge, function() {
                $('#drpPossessionOrAge')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
     });

    $("#possessionStatus2").click(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/possessionByAvailabilityId?availabilityId=" + $("#possessionStatus2").val()
        }).done(function(data) {
            $('#drpPossessionOrAge').empty();
            $.each(data.module[0].moduleResponse.possessionOrAge, function() {
                $('#drpPossessionOrAge')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
    });
    function calculateAmount() {
        return getValue($("#denominationLakhs"), 100000) +
            getValue($("#denominationThousands"), 1000) +
            getValue($("#denominationHundreds"), 100);
     }

    function getValue(component, mulByVal) {
        var value = parseInt(component.val());
        if(value == -1) return 0;
        return value * mulByVal;
    }

});