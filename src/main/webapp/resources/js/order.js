$(document).ready(function () {
    $(document).on('click', '.orderStatusSelect .orderStatusLabel', function (clickEvent) {
        $.ajax({
            url: "/order/changeOrderStatus/"+$(this).find("input").attr("id")+"/"+$(this).find("input").attr("value"),
            type: 'GET',
            success: function (data) {

            },
            error: function (data) {
                swal({
                    title: "Something wrong",
                    type: "error",
                    html: $(data.responseText),
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }
        });
    });
});