<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>jQuery UI Autocomplete functionality</title>
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <style>
        #country-label {
            display: block;
            font-weight: bold;
            margin-bottom: 1em;
        }

        .ui-autocomplete-loading { background:url('/images/ajax-loader.gif') no-repeat right center }

    </style>
    <!-- Javascript -->
    <script>
/*        function split(val) {
            return val.split(/,\s*//*);
        }
        function extractLast(term) {
            return split(term).pop();
        }*/

        $(function() {
            $( "#country" ).autocomplete({
                minLength: 1,
                source: function (request, response) {
                    $.getJSON("/rest/v1/admin/modules/get/countryList",{ searchKey: request.term }, function(data) {
                        response(data.module[0].moduleResponse.countryData);
                    });
                },
                focus: function( event, ui ) {
                    $( "#country" ).val( ui.item.countryName );
                    return false;
                },
                select: function( event, ui ) {
                    $( "#country" ).val( ui.item.countryName );
                    $( "#country-id" ).val( ui.item.countryID );
                    return false;
                }
            }).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
                return $( "<li>" )
                        .append( "<a>" + item.countryName + "</a>" )
                        .appendTo( ul );
            };
        });
    </script>
</head>
<body>
Country: <input id="country">
<input type="text" id="country-id">
</body>
</html>