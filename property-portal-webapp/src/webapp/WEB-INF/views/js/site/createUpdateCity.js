
$(document).ready(function(){

    $( "#cityNameForUpdate" ).autocomplete({
        minLength: 1,
        source: function (request, response) {
            $.getJSON("rest/v1/admin/modules/get/cityList",{ searchKey: request.term }, function(data) {
                response(data.module[0].moduleResponse.cities);
            });
        },
        focus: function( event, ui ) {
            $( "#cityNameForUpdate" ).val( ui.item.name );
            return false;
        },
        select: function( event, ui ) {
            $( "#cityNameForUpdate" ).val( ui.item.name);
            $( "#updateId" ).val(ui.item.id);
            if(ui.item.isPopular == 1) {
                $("#isPopularCityForUpdate").prop('checked', true);
                $("#isPopularCityForUpdate").val(1);
            } else {
                $("#isPopularCityForUpdate").prop('checked', false);
                $("#isPopularCityForUpdate").val(0);
            }
            return false;
        }
    }).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
        return $( "<li>" )
            .append( "<a>" + item.name + "</a>" )
            .appendTo( ul );
    };


    $("#updateButton").click(function(){
       /* if($("#isPopularCityForUpdate").prop('checked') == true) {
            $("#isPopularCity").prop('checked', true);
        } else {
            $("#isPopularCity").prop('checked', false);
        }*/
        $("#cityName").val($("#cityNameForUpdate").val());
        $('<input>').attr({type : 'hidden',
                          name: 'city.id',
                          id: 'cityId'}).appendTo('form');
        $("#cityId").val($( "#updateId" ).val());
        $("#frmCity").submit();
    });

});