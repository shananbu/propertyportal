<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/slider/simple-slider.js"></script>
<link href="css/slider/simple-slider.css" rel="stylesheet" type="text/css" />
<link href="css/slider/simple-slider-volume.css" rel="stylesheet" type="text/css" />

<link href="css/slider/customizedSlider.css" rel="stylesheet" type="text/css" />
<link href="css/slider/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/chart/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="js/chart/jqplot.pieRenderer.min.js"></script>
<link href="css/chart/jquery.jqplot.min.css" rel="stylesheet" type="text/css">
<style>
    #chartContainer {
        width: 300px;
        height: 240px;
        left: 90%;
    }
</style>


<div class="col-md-7">
    <h4><span class="label label-primary">Loan Amount is <strong><span class ='' id="la_value">500000</span></strong></span></h4>
    <input type="text" data-slider="true" value="500000" data-slider-range="100000,5000000" data-slider-step="10000" data-slider-snap="true" id="la">

    <h4><span class="label label-danger">No. of Month is <strong><span class =''  id="nm_value">36</span> </strong></span></h4>
    <input type="text" data-slider="true" value="60" data-slider-range="36,240" data-slider-step="1" data-slider-snap="true" id="nm">

    <h4><span class="label label-warning">Rate of Interest [ROI] is <strong><span class =''  id="roi_value">10.2</span></strong></span> </h4>
    <input type="text" data-slider="true" value="10.2" data-slider-range="8,16" data-slider-step=".05" data-slider-snap="true" id="roi">
    <br>

    <div class="alert alert-info col-md-5 ">
        <center><strong>Monthly EMI</strong> <BR>
            <button type="button" class="btn btn-success btn-lg" id='emi'></button></center>
    </div>

    <div class="alert alert-info col-md-5">
        <center><strong>Total Interest</strong> <BR>
            <button type="button" class="btn btn-warning btn-lg" id='tbl_int'></button></center>
    </div>

    <div class="alert alert-info col-md-5 ">
        <center><strong>Payable Amount</strong> <BR>
            <button type="button" class="btn btn-info btn-lg" id='tbl_full'></button>
        </center>
    </div>

    <div class="alert alert-info col-md-5 ">
        <center>
            <strong>Interest Percentage</strong><BR>
            <button type="button" class="btn btn-info btn-lg" id='tbl_int_pge'></button>
        </center>
    </div>


    <div id="chartContainer" ></div>

</div>


<script type="text/javascript">
    $(document).ready(function(){
        $("#la").bind(
                "slider:changed", function (event, data) {
                    $("#la_value").html(data.value.toFixed(0));
                   calculateEMI();
            }
        );

        $("#nm").bind(
                "slider:changed", function (event, data) {
                    $("#nm_value").html(data.value.toFixed(0));
                    calculateEMI();
                }
        );

        $("#roi").bind(
                "slider:changed", function (event, data) {
                    $("#roi_value").html(data.value.toFixed(2));
                    calculateEMI();
                }
        );

        function calculateEMI(){
            var loanAmount = $("#la_value").html();
            var numberOfMonths = $("#nm_value").html();
            var rateOfInterest = $("#roi_value").html();
            var monthlyInterestRatio = (rateOfInterest/100)/12;

            var top = Math.pow((1+monthlyInterestRatio),numberOfMonths);
            var bottom = top -1;
            var sp = top / bottom;
            var emi = ((loanAmount * monthlyInterestRatio) * sp);
            var full = numberOfMonths * emi;
            var interest = full - loanAmount;
            var int_pge =  (interest / full) * 100;
            $("#tbl_int_pge").html(int_pge.toFixed(2)+" %");
            //$("#tbl_loan_pge").html((100-int_pge.toFixed(2))+" %");

            var emi_str = emi.toFixed(2).toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            var loanAmount_str = loanAmount.toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            var full_str = full.toFixed(2).toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            var int_str = interest.toFixed(2).toString().replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");

            $("#emi").html(emi_str);
            $("#tbl_emi").html(emi_str);
            $("#tbl_la").html(loanAmount_str);
            $("#tbl_nm").html(numberOfMonths);
            $("#tbl_roi").html(rateOfInterest);
            $("#tbl_full").html(full_str);
            $("#tbl_int").html(int_str);
/*            var detailDesc = "<thead><tr class='success'><th>Payment No.</th><th>Begining Balance</th><th>EMI</th><th>Principal</th><th>Interest</th><th>Ending Balance</th></thead><tbody>";
            var bb=parseInt(loanAmount);
            var int_dd =0;var pre_dd=0;var end_dd=0;
            for (var j=1;j<=numberOfMonths;j++){
                int_dd = bb * ((rateOfInterest/100)/12);
                pre_dd = emi.toFixed(2) - int_dd.toFixed(2);
                end_dd = bb - pre_dd.toFixed(2);
                detailDesc += "<tr><td>"+j+"</td><td>"+bb.toFixed(2)+"</td><td>"+emi.toFixed(2)+"</td><td>"+pre_dd.toFixed(2)+"</td><td>"+int_dd.toFixed(2)+"</td><td>"+end_dd.toFixed(2)+"</td></tr>";
                bb = bb - pre_dd.toFixed(2);
            }
            detailDesc += "</tbody>";
            $("#illustrate").html(detailDesc);*/

            jQuery.jqplot.config.enablePlugins = true;
            plot1 = jQuery.jqplot('chartContainer',
                    [[['Loan', eval(loanAmount)],['Interest', eval(interest.toFixed(2))]]],
                    {
                        title: '',
                        seriesDefaults: {
                            shadow: false,
                            renderer: jQuery.jqplot.PieRenderer,
                            rendererOptions: { padding: 2, sliceMargin: 2, showDataLabels: false }
                        },
                        legend: { show:true, location: 'e' }
                    }
            );
        }
        calculateEMI();
    });


</script>