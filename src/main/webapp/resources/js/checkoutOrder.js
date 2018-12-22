$(document).ready(function () {
    $(document).on('change', '[name=addressRadio]', function (clickEvent) {
        if($(this).attr("id") == "addressRadio1"){
            $("#userAddress").find("select").removeAttr('disabled');
            $("#userAddress").find("input").each(function() {
                if($( this ).attr("type") != "radio")
                    $( this ).attr('disabled','true');
            });

        }else{
            $("#userAddress").find("select").attr('disabled','true');
            $("#userAddress").find("input").each(function() {
                if($( this ).attr("type") != "radio")
                    $( this ).removeAttr('disabled');
            });
        }
    });
    if($(document).find('.totalPrice').length == 0)
        swal({
            title: "Cart is empty!",
            type: "error",
            confirmButtonText: "Ok",
            showCancelButton: false,
            allowOutsideClick: true
        });




});

