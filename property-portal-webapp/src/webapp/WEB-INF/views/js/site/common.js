Common = {
    showOverlay: function() {
        var docHeight = $(document).height();

        $("body").append("<div id='overlay'></div>");

        $("#overlay")
            .height(docHeight)
            .css({
                'opacity': 0.4,
                'position': 'absolute',
                'top': 0,
                'left': 0,
                'background-color': 'black',
                'width': '100%',
                'z-index': 5000
            });
    },

    hideOverlay: function() {
        $("#overlay").remove();
    }


}

$.extend({alert: function (message) {
    $("<div></div>").dialog( {
        buttons: { "Ok": function () { $(this).dialog("close"); } },
        close: function (event, ui) { $(this).remove(); },
        resizable: false,
        title: "Maritime1stchoice",
        modal: false,
        closeOnEscape: false,
        open: function(event, ui) { $(".ui-dialog-titlebar-close", ui.dialog | ui).hide(); }
    }).html(message);
}});