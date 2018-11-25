$(document).ready(function () {

    $(document).on('click', '#createProductButton', function (clickEvent) {
        var request = modalGetAjax("/product")
        request.done(function (data) {
            if($('div#content-profile-box .treeview input[type=radio]:checked').val() != null){
                if($('div#content-profile-box input[name=id]').val() != null && $('div#content-profile-box input[name=id]').val() !== "")
                    getProductCharacteristicAjax("/product/characteristic/" + $('div#content-profile-box .treeview input[type=radio]:checked').val() + "/" + $('div#content-profile-box input[name=id]').val());
                else
                    getProductCharacteristicAjax("/product/characteristic/" + $('div#content-profile-box .treeview input[type=radio]:checked').val());
            }
        });
    });

    $(document).on('input', '#product div#content-profile-box .treeview input[type=radio]', function (clickEvent) {
        $(".modal").css("z-index","1000");
        swal({
            title: 'Are you sure you want change category?',
            text: 'You\'ll lost all characteristics!',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, change it!'
        }).then((result)=>
        {
            if(result.value
    )
        {
            $(".modal").css("z-index","13000")
            if($('div#content-profile-box input[name=id]').val() != null && $('div#content-profile-box input[name=id]').val() !== "")
                getProductCharacteristicAjax("/product/characteristic/" + $('div#content-profile-box .treeview input[type=radio]:checked').val() + "/" + $('div#content-profile-box input[name=id]').val());
            else
                getProductCharacteristicAjax("/product/characteristic/" + $('div#content-profile-box .treeview input[type=radio]:checked').val());
        }

    });
    });

        $(document).on('click', 'button.closeProductCharacteristicCheckboxField', function (clickEvent) {
            $(this).parent().parent().detach();
        });

        // edit user for admin
        $(document).on('click', 'a.btn-edit-product', function (clickEvent) {
            clickEvent.preventDefault();
            modalGetAjax($(this).attr("href"))
        });

        $(document).on('click', 'button#modalProductFormButton', function (clickEvent) {
            clickEvent.preventDefault();
            var form = $('div#content-profile-box form');
            var request = modalPostAjax(form.attr('action'), form.serializeArray(), "/product/");
            request.done(function (data) {
                if ($('div#content-profile-box .treeview input[type=radio]:checked').val() != null) {
                        postProductCharacteristicAjax("/product/characteristic/retry", form.serializeArray());
                }
            });
        });

        // delete user for admin
        $(document).on('click', 'a.btn-delete-product', function (clickEvent) {
            clickEvent.preventDefault();

            swal({
                title: 'Are you sure you want to delete this product?',
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result)=>
            {
                if(result.value
        )
            {
                deleteAjax($(this).attr("href"), "/product/list");
            }
        })
            ;

        });

    });


function getProductCharacteristicAjax(url) {
    $.ajax({
        url: url,
        type: 'GET',
        context: $( "div#sub-content-modal-box" ),
        success: function (data) {
            $(this).html($(data).find("#characteristic-box"));
        },
        error: function (data) {
            $(".modal").css("z-index","1000");
                swal({
                    title: "Get category form exception",
                    type: "error",
                    html: $(data.responseText).filter('div#content-exception').html(),
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                }).then((result)=>
                {
                    $(".modal").css("z-index","13000");
                });
        }
    });
}

function postProductCharacteristicAjax(url, form_data) {
    $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        context: $( "div#sub-content-modal-box" ),
        success: function (data) {
            $(this).html($(data).find("#characteristic-box"));
        },
        error: function (data) {
            $(".modal").css("z-index","1000");
            swal({
                title: "Get category form exception",
                type: "error",
                html: $(data.responseText).filter('div#content-exception').html(),
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            }).then((result)=>
            {
                $(".modal").css("z-index","13000");
            });
        }
    });
}