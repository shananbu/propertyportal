// JavaScript Document
    $(document).ready(function () {
								
							$('#nav > li').click(function () {
												$('#nav > li').removeClass('menu_active');
												$(this).addClass('menu_active');
								 });
							
							$('#nav > li > ul > li').click(function () {
												$('#nav li ul li').removeClass('menu_active_2');
												$(this).addClass('menu_active_2');
								 });
							
        $('#nav > li > a').click(function () {
										   
										  

            if ($(this).attr('class') != 'active') {
                $('#nav li ul').slideUp();
                $(this).next().slideToggle();
                //$('#nav li a').removeClass('active');
                //$(this).addClass('active');

				
            }
            else if ($(this).attr('class') == 'active') {
                $('#nav li ul').slideUp();
                //$('#nav li a').removeClass('active');
				
            }
        });


        $('#nav > li > ul > li > a').click(function () {
            if ($(this).attr('class') != 'active') {

                $(this).next().slideToggle();
              //  $('#nav > li > ul > li > a').removeClass('active');
                //$(this).addClass('active');
            }
            else if ($(this).attr('class') == 'active') {
                $(this).next().slideToggle();
                //$('#nav > li > ul > li > a').removeClass('active');
            }
        });
    });