function sendFileToServer(formData,status)
{
    // previewImage(files);
    var uploadURL ="upload"; //Upload URL
    var extraData ={}; //Extra Data.
    var jqXHR=$.ajax({
        xhr: function() {
            var xhrobj = $.ajaxSettings.xhr();
            if (xhrobj.upload) {
                xhrobj.upload.addEventListener('progress', function(event) {
                    var percent = 0;
                    var position = event.loaded || event.position;
                    var total = event.total;
                    if (event.lengthComputable) {
                        percent = Math.ceil(position / total * 100);
                    }
                    //Set progress
                    status.setProgress(percent);
                }, false);
            }
            return xhrobj;
        },
        url: uploadURL,
        type: "POST",
        contentType: false,
        processData: false,
        cache: false,
        data: formData,
        success: function(data){
            status.setProgress(100);
            $("#" + data.label).val(data.name);
         }
    });

    status.setAbort(jqXHR);
}

var rowCount=0;
function createStatusbar(obj)
{
    rowCount++;
    var row="odd";
    if(rowCount %2 == 0) row ="even";
    this.statusbar = $("<div class='statusbar "+row+"'></div>");
    this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
    this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
    this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
    this.abort = $("<div class='abort'>Abort</div>").appendTo(this.statusbar);
    obj.after(this.statusbar);

    this.setFileNameSize = function(name,size)
    {
        var sizeStr="";
        var sizeKB = size/1024;
        if(parseInt(sizeKB) > 1024)
        {
            var sizeMB = sizeKB/1024;
            sizeStr = sizeMB.toFixed(2)+" MB";
        }
        else
        {
            sizeStr = sizeKB.toFixed(2)+" KB";
        }

        this.filename.html(name);
        this.size.html(sizeStr);
    }
    this.setProgress = function(progress)
    {
        var progressBarWidth =progress*this.progressBar.width()/ 100;
        this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
        if(parseInt(progress) >= 100)
        {
            this.abort.hide();
        }
    }
    this.setAbort = function(jqxhr)
    {
        var sb = this.statusbar;
        this.abort.click(function()
        {
            jqxhr.abort();
            sb.hide();
        });
    }
}
function handleFileUpload(files,obj, hiddenFieldName)
{
    for (var i = 0; i < files.length; i++)
    {
        var fd = new FormData();
        fd.append('file', files[i]);
        fd.append('hiddenFieldName', hiddenFieldName);
        var status = new createStatusbar(obj); //Using this we can set progress.
        status.setFileNameSize(files[i].name,files[i].size);
        sendFileToServer(fd,status);

    }
}
$(document).ready(function()
{
    var obj = $("#dragandrophandler");
    obj.on('dragenter', function (e)
    {
        e.stopPropagation();
        e.preventDefault();
        $(this).css('border', '2px solid #0B85A1');
    });
    obj.on('dragover', function (e)
    {
        e.stopPropagation();
        e.preventDefault();
    });
    obj.on('drop', function (e)
    {

        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.originalEvent.dataTransfer.files;

        //We need to send dropped files to Server
        handleFileUpload(files,obj, "");
    });
    $(document).on('dragenter', function (e)
    {
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on('dragover', function (e)
    {
        e.stopPropagation();
        e.preventDefault();
        obj.css('border', '2px dotted #0B85A1');
    });
    $(document).on('drop', function (e)
    {
        e.stopPropagation();
        e.preventDefault();
    });

    $(document).on('change', '.floorPlanImage', function(e)
        // $('input[type=file]').on('change',  function (e)
    {
        var obj = $("#dragandrophandler");
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();

        var files = e.target.files || (e.dataTransfer && e.dataTransfer.files);
        var hiddenFieldName = $(this).prev().attr('id');
        //We need to send dropped files to Server
        handleFileUpload(files, obj, hiddenFieldName);

    });

    $(document).on('change', '.morePropertiesFile', function(e) {
        var obj = $("#dragandrophandler");
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.target.files || (e.dataTransfer && e.dataTransfer.files);
        var hiddenFieldName = "morePropertiesFileName";
        //We need to send dropped files to Server
        handleFileUpload(files, obj, hiddenFieldName);
    });

    $(document).on('change', '.descriptionFile', function(e) {
        var obj = $("#dragandrophandler");
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.target.files || (e.dataTransfer && e.dataTransfer.files);
        var hiddenFieldName = "descriptionFileName";
        //We need to send dropped files to Server
        handleFileUpload(files, obj, hiddenFieldName);
    });

    $(document).on('change', '.specificationFile', function(e) {
        var obj = $("#dragandrophandler");
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.target.files || (e.dataTransfer && e.dataTransfer.files);
        var hiddenFieldName = "specificationFileName";
        //We need to send dropped files to Server
        handleFileUpload(files, obj, hiddenFieldName);
    });
});