$(document).ready(function(){
    $("#Owner").click(function(){
        window.location.href = "advertiseWithUs?name=Owner";
        $("#Owner").attr('class',"prop_active");
    });
    $("#Agent").click(function(){
        window.location.href = "advertiseWithUs?name=Agent";
        $("#Agent").attr('class',"prop_active");
    });
    $("#Builder").click(function(){
        window.location.href = "advertiseWithUs?name=Builder";
        $("#Builder").attr('class',"prop_active");
    });
});


