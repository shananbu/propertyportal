$(document).ready(function(){

    $( "#firstName" ).autocomplete({
        minLength: 1,
        source: function (request, response) {
            $.getJSON("rest/v1/admin/modules/get/userList",{ searchKey: request.term }, function(data) {
                response(data.module[0].moduleResponse.adminUsers);
            });
        },
        focus: function( event, ui ) {
            $( "#firstName" ).val( ui.item.name );
            return false;
        },
        select: function( event, ui ) {
            $( "#firstName" ).val( ui.item.firstName);
            $( "#id" ).val(ui.item.id);
            $( "#userName").val(ui.item.userName);
            $( "#designation").val(ui.item.designation);
            $( "#password").val(ui.item.password);
            $( "#cPassword").val(ui.item.password);
            $( "#email").val(ui.item.mailId);
            $( "#phoneNumber").val(ui.item.phoneNumber);
            $( "#status").val(ui.item.status);
            $( "#doj").val(ui.item.doj);
            $( "#dor").val(ui.item.dor);
            return false;
        }
    }).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
        return $( "<li>" )
            .append( "<a>" + item.firstName + "</a>" )
            .appendTo( ul );
    };

});