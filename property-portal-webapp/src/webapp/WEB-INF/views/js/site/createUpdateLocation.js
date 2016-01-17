
$(document).ready(function(){

    $( "#locationNameForUpdate" ).autocomplete({
        minLength: 1,
        source: function (request, response) {
            $.getJSON("rest/v1/admin/modules/get/locationList",{ searchKey: request.term }, function(data) {
                response(data.module[0].moduleResponse.locations);
            });
        },
        focus: function( event, ui ) {
            $( "#locationNameForUpdate" ).val( ui.item.name );
            return false;
        },
        select: function( event, ui ) {
            $( "#locationNameForUpdate" ).val( ui.item.name);
            $( "#updateId" ).val(ui.item.id);
            $( "#pincodeForUpdate" ).val(ui.item.pincode);
            return false;
        }
    }).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
        return $( "<li>" )
            .append( "<a>" + item.name + "</a>" )
            .appendTo( ul );
    };

    $("#updateButton").click(function(){
        $("#locationName").val($("#locationNameForUpdate").val());
        $('<input>').attr({type : 'hidden',
            name: 'location.id',
            id: 'locationId'}).appendTo('form');
        $("#locationId").val($( "#updateId" ).val());
        $("#pincode").val($( "#pincodeForUpdate" ).val());
        $("#frmLocation").submit();
    });

});