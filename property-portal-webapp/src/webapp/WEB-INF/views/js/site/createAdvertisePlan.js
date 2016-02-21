$(document).ready(function() {

    var table = $('#packageListingTable').dataTable({
        "bJQueryUI": true,
        "bAutoWidth": true,
        "bSort": true,
        "bScrollCollapse": false,
        "sScrollY": "180px",
        "ajax": {
            "url": "rest/v1/admin/modules/get/advertisePlanList",
            "dataSrc": "module.0.moduleResponse.plans"
        },
        "columns": [
            { "data": "name" },
            { "data": "userTypeName" },
            { "data": "cost", "sClass": "right" },
            { "data": "validDays", "sClass": "right" },
            { "data": "numberOfImages", "sClass": "right" },
            { "data": "description" },
            { "data": "id" },
            { "data": "id" }
        ],
        "columnDefs": [
            {
                "targets": [ 6 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 7 ],
                "visible": false,
                "searchable": false
            }
        ]
    });

  //  $('#packageListingTable tbody tr').live('click', function (event) {
        $('#packageListingTable').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        } else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            var aPos = table.fnGetPosition( this );
            var aData = table.fnGetData( aPos[0] );

            $( "#planId" ).val(aData[aPos].id);
            $( "#planName" ).val(aData[aPos].name);
            $( "#validDays" ).val(aData[aPos].validDays);
            $( "#cost" ).val(aData[aPos].cost);
            $( "#numberOfImages" ).val(aData[aPos].numberOfImages);
            $( "#userTypeId" ).val(aData[aPos].userTypeId);
            $( "#description" ).val(aData[aPos].description);

        }
    } );

} );