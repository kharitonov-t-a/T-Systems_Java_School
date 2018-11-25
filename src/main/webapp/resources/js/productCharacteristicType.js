$(document).ready(function () {

    var counter = 1;
    $(document).on("focus", "#checkbox-values div.input-group.mb-3:last-child input", function(clickEvent) {
        counter++;
        $("#checkbox-values").append("   <div class=\"input-group mb-3\">\n" +
            "                                <input type=\"text\" class=\"form-control\" name=\"productCharacteristicCheckboxFieldList[" + counter + "].value\"\n" +
            "                                       placeholder=\"Checkbox Name Value\" aria-label=\"Checkbox Name Value\" aria-describedby=\"basic-addon2\">\n" +
            "                                <div class=\"input-group-append\">\n" +
            "                                    <button class=\"btn btn-outline-secondary close closeProductCharacteristicCheckboxField\" type=\"button\" aria-label=\"Close\">\n" +
            "                                        <span aria-hidden=\"true\">&times;</span>\n" +
            "                                    </button>\n" +
            "                                </div>\n" +
            "                            </div>");
    });

    $(document).on('change', 'select[name=characteristicType]', function (clickEvent) {
        if($(this).val() === "CHECKBOX"){
            $("#checkbox-values").parent().show();
        }
        else{
            $("#checkbox-values").parent().hide();
        }
    });


    $(document).on('click', 'button.closeProductCharacteristicCheckboxField', function (clickEvent) {
        $(this).parent().parent().detach();
    });


    $(document).on('click', 'button#createCharacteristicBtn', function (clickEvent) {
            var request = modalGetAjax("/product/characteristic/type");
            request.done(function (data) {
                counter = $("#checkbox-values div.input-group.mb-3").length - 1;
            });
    });

    // edit user for admin
    $(document).on('click', 'a.btn-edit-productCharacteristic', function (clickEvent) {
        clickEvent.preventDefault();
        modalGetAjax($(this).attr("href"))
    });

    $(document).on('click', 'button#modalCharacteristicFormButton', function (clickEvent) {
        clickEvent.preventDefault();
        var form = $('div#content-profile-box form');
        modalPostAjax(form.attr('action'), form.serializeArray(), "/product/characteristic/type");
    });

    // delete user for admin
    $(document).on('click', 'a.btn-delete-productCharacteristic', function (clickEvent) {
        clickEvent.preventDefault();

        swal({
            title: 'Are you sure you want to delete this product characteristic?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result)=>
        {
            if (result.value) {
            deleteAjax($(this).attr("href"), "/product/characteristic/type/list");
        }
    });

    });

});