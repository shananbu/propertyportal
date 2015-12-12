$(document).ready(function(){
    $("#drpDwnState").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/stateByCityId?stateId=" + $("#drpDwnState").val()
        }).done(function(data) {
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
        });
    });

    $("#drpDwnCity").change(function() {
        $.ajax({
            url: "rest/v1/admin/modules/get/locationByCityId?locationId=" + $("#drpDwnCity").val()
        }).done(function(data) {
            clearLocation();
            $('#drpDwnLocation').append($("<option></option>")
                .attr("value", -2)
                .text("--Select--"));
            $.each(data.module[0].moduleResponse.cities, function() {
                $('#drpDwnLocation')[0].sumo.add(this.id, this.name);
            });
        });
    });


    $('#btnRegisterUser').click(function(){
        var rootRequestMap = new Object();
        var requestMap = new Object();
        requestMap["userTypeId"] = $('[name="propertyUser.userTypeId"]').val();
        requestMap["builderName"] = $('[name="propertyUser.builderName"]').val();
        requestMap["firstName"] = $('[name="propertyUser.firstName"]').val();
        requestMap["lastName"] = $('[name="propertyUser.lastName"]').val();
        requestMap["emailId"] = $('[name="propertyUser.emailId"]').val();
        requestMap["passwrd"] = $('[name="propertyUser.passwrd"]').val();
        requestMap["mobileNo"] = $('[name="propertyUser.mobileNo"]').val();
        rootRequestMap["propertyUser"] = requestMap;
        var saveCity = $.ajax({
            type: 'POST',
            url: "rest/v1/admin/modules/create/registerUser",
            data: JSON.stringify(rootRequestMap),
            contentType: "application/json",
            success: function(data) {
                alert(data.messages[0].message)
                if(data.messages[0].code == 100) {
                    $(".md-modal, .mod-overlay").fadeOut(200, function () {
                        $(".md-overlay").remove();
                        $("#modal-10").remove();
                    });
                } else {
                    $('#btnRegisterUser').prop('disabled', false);
                }
            }
        });
        saveCity.error(function() { alert("Something went wrong while registering the user.."); });
        $(this).prop('disabled', true);
    });


    $('#btnUserLogin').click(function(){
        var requestMap = new Object();
        requestMap["username"] = $('[name="username"]').val();
        requestMap["password"] = $('[name="password"]').val();
        var loginResponse;
            loginResponse = $.ajax({
            type: 'POST',
            url: "userLogin",
            data: requestMap,
            dataType: "text",
            success: function(resultData, status, xhr) {
                 if(xhr.getResponseHeader("isAutheticated") == "true") {
                    window.location.href = "propertyAlertRegisteration";
/*                     $(".md-modal, .mod-overlay").fadeOut(200, function() {
                         $(".md-overlay").remove();
                         $("#modal-11").remove();
                     });*/
                } else {
                    alert("Invalid Username / Password.");
                     $('[name="username"]').val("");
                     $('[name="password"]').val("");
                }
            }
        });
        loginResponse.error(function() { alert("Something went wrong while registering the user.."); });
    });

    $('.propertyForType').click(function(){
        $.ajax({
            url: "rest/v1/admin/modules/get/budgetByPropertyForTypeId?propertyForTypeId=" + $(this).val()
        }).done(function(data) {
            $('#budget').empty();
            $.each(data.module[0].moduleResponse.budgets, function() {
                $('#budget')
                    .append($("<option></option>")
                        .attr("value", this.id)
                        .text(this.name));
            });
        });
    });


    function clearLocation() {
        var num = $('#drpDwnLocation option').length;
        for(var i= num -1 ; i >= 0; i--){
           $('#drpDwnLocation')[0].sumo.remove(i);
        }
    }
});