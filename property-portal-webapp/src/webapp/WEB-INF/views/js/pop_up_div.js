// JavaScript Document
$(function(){

var overlay =  ("<div class='modal-overlay js-modal-close'></div>");

	$('[pop-model-id]').click(function(e) {
        e.preventDefault();
        var modalBox = $(this).attr('pop-model-id');
        if(modalBox == 'addCityPopup') {
         //   $('#'+modalBox).fadeIn($(this).data());
            if($('#drpDwnState').val() == -1) {
                alert("Please select State to add city under the selected State");
            } else {
                $("body").append(overlay);
                $(".modal-overlay").fadeTo(500, 0.7);
                $('#'+modalBox).fadeIn($(this).data());
            }
        } else if(modalBox == 'addLocationPopup') {
            if($('#drpDwnCity').val() == -1) {
                alert("Please select City to add Location under the selected City");
            } else {
                $("body").append(overlay);
                $(".modal-overlay").fadeTo(500, 0.7);
                $('#'+modalBox).fadeIn($(this).data());
            }
        }
	});
  
  
    $(".js-modal-close, .modal-overlay").click(function() {
        $(".modal-box, .modal-overlay").fadeOut(500, function() {
            $(".modal-overlay").remove();
        });
    });


    $(window).resize(function() {
        $(".modal-box").css({
            top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
            left: ($(window).width() - $(".modal-box").outerWidth()) / 2
        });
    });
 
    $(window).resize();
});