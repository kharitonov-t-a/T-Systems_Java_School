$(document).ready(function () {
    $('.header').height($(window).height());

    /*------------------------------------- userList.jsp -----------------------------------------------------*/

    $(document).on('click', '.btndeleteuser', function(clickEvent) {
        clickEvent.preventDefault();
        $.ajax({
            url: this.href,
            type: 'GET',
            success: function (data) {
                if ($(data).find('table#user-list-table') != null) {
                    // alert("Прибыли данные:");
                    $('table#user-list-table').html($(data).find('table#user-list-table'));
                }
            }
        });
    });

    /*------------------------------------- listProductProfile.jsp -----------------------------------------------------*/
    $("div.product-action button.addProduct").on("click",function(clickEvent){
        clickEvent.preventDefault();
        var button = $(this);
        $.ajax({
            url: $(this).attr("href"),
            type: 'GET',
            data: { productId: $(this).attr("attrIdProduct")},
            success: function (data) {
                $(button).closest('.single-product').find('img')
                    .clone()
                    .css({'position' : 'absolute', 'z-index' : '11100', top: $(button).offset().top-300, left:$(button).offset().left-100})
                    .appendTo("body")
                    .animate({opacity: 0.05,
                        left: $(".cd-cart-container").offset()['left'],
                        top: $(".cd-cart-container").offset()['top'],
                        width: 20}, 1000, function() {
                        // $(button).remove();
                    });
            },
            error: function(data){
                // // if ($(data.responseText).find('div#error') != null) {
                //     $('div#error').html($(data.responseText));
                //     $('div#alertStock').modal({
                //         backdrop: true
                //     });
                // // }
                swal({
                    title: "Checks Stock!",
                    text: data.responseText.toString(),
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }

        });



    });
})