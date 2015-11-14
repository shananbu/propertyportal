$(document).ready(function(){
    $("#drpDwnState").change(function() {
        loadCityByState();
    });

    $("#drpDwnCity").change(function() {
        loadLocationByCity();
    });

    $("#drpDwnLocation").change(function() {
        if(Number($("#drpDwnLocation").val()) == -99 ) {
            $("#addLocationButton").css('visibility', 'visible');
        } else {
            $("#addLocationButton").css("visibility", "hidden");
        }
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


    $('.pro_list li input[type="radio"]').click(function(){
        $('.pro_list').hide();
    })

    $('#addLocation').click(function(){
        var requestMap = new Object();
        requestMap["location.parentId"] = $('#drpDwnCity').val();
        requestMap["location.name"] = $('#txtLocation').val();

        var saveCity = $.ajax({
            type: 'POST',
            url: "saveOrUpdateLocation",
            data: requestMap,
            dataType: "text",
            success: function(resultData) {
                loadLocationByCity();
                $(".modal-box, .modal-overlay").fadeOut(200, function() {
                    $(".modal-overlay").remove();
                });
            }
        });
        saveCity.error(function() { alert("Something went wrong while adding Location"); });
    });

    $('#addCity').click(function(){
        var requestMap = new Object();
        requestMap["city.parentId"] = $('#drpDwnState').val();
        requestMap["city.name"] = $('#txtCity').val();
        requestMap["city.isPopular"] = 0;

        var saveCity = $.ajax({
            type: 'POST',
            url: "saveOrUpdateCity",
            data: requestMap,
            dataType: "text",
            success: function(resultData) {
                loadCityByState();
                $(".modal-box, .modal-overlay").fadeOut(200, function() {
                    $(".modal-overlay").remove();
                });
            }
        });
        saveCity.error(function() { alert("Something went wrong while adding Location"); });
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

    function loadCityByState() {
        $.ajax({
            url: "rest/v1/admin/modules/get/stateByCityId?stateId=" + $("#drpDwnState").val()
        }).done(function(data) {
            $('#drpDwnCity').removeClass("dropdown");
            $('#drpDwnCity').empty();
            $('#drpDwnCity').append($("<option></option>")
                .attr("value", -2)
                .text("--Select--"));
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnCity')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });

            $("#drpDwnCity option").filter(function() {
                 return $(this).text() == $('#txtCity').val();
            }).prop('selected', true);
            $('#txtCity').val("");
        });
    }

    function loadLocationByCity() {
        if(Number($("#drpDwnCity").val()) == -99 ) {
            $("#addCityButton").css('visibility', 'visible');
        } else {
            $("#addCityButton").css("visibility", "hidden");
            $.ajax({
                url: "rest/v1/admin/modules/get/locationByCityId?locationId=" + $("#drpDwnCity").val()
            }).done(function (data) {
                $('#drpDwnLocation').removeClass("dropdown");
                $('#drpDwnLocation').empty();
                $('#drpDwnLocation')
                    .append($("<option></option>")
                        .attr("value", -2)
                        .text("--Select--"));
                $.each(data.module[0].moduleResponse.cities, function () {
                    $('#drpDwnLocation')
                        .append($("<option></option>")
                            .attr("value", this.id)
                            .text(this.name));
                });

                $("#drpDwnLocation option").filter(function() {
                    return $(this).text() == $('#txtLocation').val();
                }).prop('selected', true);
                $('#txtLocation').val("")
            });
        }
    }

});