$(document).ready(function(){
    // init bootpag
    $('#page-selection').bootpag({
        total: 10,
        page: 1,
        maxVisible: 5
    }).on("page", function(event, /* page number here */ num){
        $("#content").html("Insert content of page " + num); // some ajax content loading...
    });
});