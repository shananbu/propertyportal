
$(document).ready(function () {
  /*  $('#clearContactForm').click(function () {
        reset();
    });*/
    $('#sendContactMail').click(function () {
        if ($('#contactUsCity').val() == "" || $('#contactUsName').val() == "" || $('#contactUsMobile').val() == "" || !isValidEmail($('#contactUsEMail').val())) {
            alert("All fields are mandatory..");
        } else {
            Common.showOverlay();
            var formData = new FormData();
            formData.append('contactUs.city', $('#contactUsCity').val());
            formData.append('contactUs.name', $('#contactUsName').val());
            formData.append('contactUs.mobileNo', $('#contactUsMobile').val());
            formData.append('contactUs.eMail', $('#contactUsEMail').val());
            formData.append('contactUs.advertisementId', $('#advertisementId').val());


            var sendMail = $.ajax({
                type: 'POST',
                url: "/sendContactUsMail",
                data: formData,
                dataType: "text",
                contentType: false,
                processData: false,
                success: function (resultData) {
                    Common.hideOverlay();
                    document.write(resultData);
                    reset();
                }
            });
            sendMail.error(function () {
                Common.hideOverlay();
                alert("Something went wrong while sending mail.");
            });
        }
    });

    function reset() {
        $('#contactUsCity').val("");
        $('#contactUsName').val("");
        $('#contactUsMobile').val("");
        $('#contactUsEMail').val("");
    }

    function isValidEmail(sEmail) {
        var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if (filter.test(sEmail)) {
            return true;
        }
        else {
            return false;
        }
    }
});