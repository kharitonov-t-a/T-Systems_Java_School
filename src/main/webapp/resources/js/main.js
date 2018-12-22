$(document).ready(function () {
    $('.header').height($(window).height());
    if($(document).find('.megaTotalPrice').length > 0){
        var megaTotalPrice = 0;
        $(document).find('.totalPrice').each(function(i,elem) {
            megaTotalPrice = parseFloat(megaTotalPrice) + parseFloat($(elem).html());
        });
        $(document).find('.megaTotalPrice').html(megaTotalPrice);
    }

    $(document).on('click', '.cd-cart-container', function (clickEvent) {
        clickEvent.preventDefault();
        if ($('#smallShoppingCart').hasClass('shoppingCartHide')) {
            $('#smallShoppingCart').removeClass('shoppingCartHide');
            $("#smallShoppingCart").addClass('shoppingCartShow')
        } else if ($('#smallShoppingCart').hasClass('shoppingCartShow')) {
            $('#smallShoppingCart').removeClass('shoppingCartShow');
            $("#smallShoppingCart").addClass('shoppingCartHide')
        }
    });


    /*------------------------------------- userList.jsp -----------------------------------------------------*/

    $(document).on('click', '.btndeleteuser', function (clickEvent) {
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

    $(document).on('click', '.increaseCountProduct', function (clickEvent) {
        $(this).closest(".countProductAction").find("input.countProductAdd").val(
            parseInt($(this).closest(".countProductAction").find("input.countProductAdd").val()) + 1
        );
        if (countProductChangeAlert($(this).closest(".countProductAction").find("input.countProductAdd"), $(this))) {
            if ($(this).closest(".shoppingCart").find('.shCrt').length > 0) {
                putCountOrderProduct($(this).attr("productId"), 1);
                $(this).closest("tr").find('.totalPrice').html(parseFloat(
                    parseFloat($(this).closest("tr").find('.unitPrice').html())
                    *
                    parseFloat($(this).closest("tr").find("input.countProductAdd").val())
                    ).toFixed(2)
                );
                if($(document).find('.megaTotalPrice').length > 0){
                    var megaTotalPrice = 0;
                    $(document).find('.totalPrice').each(function(i,elem) {
                        megaTotalPrice = parseFloat(megaTotalPrice) + parseFloat($(elem).html());
                    });
                    $(document).find('.megaTotalPrice').html(megaTotalPrice);
                }
            }
        }
    });

    $(document).on('click', '.deleteOrderProduct', function (clickEvent) {
        clickEvent.preventDefault();
        var button = $(this);
        $.ajax({
            url: $(this).attr("href") + "/" + $(this).attr("productId"),
            type: 'DELETE',
            data: {_method: 'delete'},
            success: function (data) {
                $(button).closest("tr").remove();
            },
            error: function (data) {
                swal({
                    title: "Error!",
                    text: data.responseText.toString(),
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }

        });
    });

    $(document).on('click', '.reduceCountProduct', function (clickEvent) {
        $(this).closest(".countProductAction").find("input.countProductAdd").val(
            parseInt($(this).closest(".countProductAction").find("input.countProductAdd").val()) - 1
        );
        if (countProductChangeAlert($(this).closest(".countProductAction").find("input.countProductAdd"), $(this))) {
            if ($(this).closest(".shoppingCart").find('.shCrt').length > 0) {
                putCountOrderProduct($(this).attr("productId"), -1);
                $(this).closest("tr").find('.totalPrice').html(parseFloat(
                    parseFloat($(this).closest("tr").find('.unitPrice').html())
                    *
                    parseFloat($(this).closest("tr").find("input.countProductAdd").val())
                    ).toFixed(2)
                );
            }
        }
        ;
    });

    $(document).on('change input', 'input.countProductAdd', function (clickEvent) {
        countProductChangeAlert($(this), $(this));
    });

    function countProductChangeAlert(inputCountProductAdd, currentElement) {
        if (parseInt(inputCountProductAdd.val()) > parseInt(inputCountProductAdd.attr("max"))) {
            inputCountProductAdd.val(inputCountProductAdd.attr("max"));
            $('.tooltip-block').stop(true);
            $('.tooltip-block').html("Stock max").show('slow')
                .offset({
                    top: currentElement.offset().top + currentElement.height(),
                    left: currentElement.offset().left
                });
            setTimeout(function () {
                $(".tooltip-block").hide('slow');
            }, 2000);
            return false;

            // inputCountProductAdd.closest(".countProductAction").find("input.increaseCountProduct").disable();
        } else if (parseInt(inputCountProductAdd.val()) < parseInt(inputCountProductAdd.attr("min"))) {
            inputCountProductAdd.val(inputCountProductAdd.attr("min"));
            $('.tooltip-block').stop(true);
            $('.tooltip-block').html("Stock min").show('slow')
                .offset({
                    top: currentElement.offset().top + currentElement.height(),
                    left: currentElement.offset().left
                });
            setTimeout(function () {
                $(".tooltip-block").hide('slow');
            }, 2000);
            return false;
        }
        return true;
    }

    /*------------------------------------- listProductProfile.jsp -----------------------------------------------------*/
    $("div.product-action button.addProduct").on("click", function (clickEvent) {
        clickEvent.preventDefault();
        var button = $(this);
        $.ajax({
            url: $(this).attr("href"),
            type: 'GET',
            data: {
                productId: $(this).attr("attrIdProduct"),
                countProduct: $(this).closest(".product-action").find("input.countProductAdd").val()
            },
            success: function (data) {
                $(button).closest('.single-product').find('img')
                    .clone()
                    .css({
                        'position': 'absolute',
                        'z-index': '11100',
                        top: $(button).offset().top - 300,
                        left: $(button).offset().left - 100
                    })
                    .appendTo("body")
                    .animate({
                        opacity: 0.05,
                        left: $(".cd-cart-container").offset()['left'],
                        top: $(".cd-cart-container").offset()['top'],
                        width: 20
                    }, 1000, function () {
                    });
                $('#smallShoppingCart table#smShCrt').html($(data).find('table#smShCrt').html());
            },
            error: function (data) {
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

function putCountOrderProduct(productId, countProduct) {
    $.ajax({
        url: "/changeCountProductInOrder",
        type: 'GET',
        data: {
            productId: productId,
            countProduct: countProduct
        },
        success: function (data) {
        },
        error: function (data) {
            swal({
                title: "Error!",
                text: data.responseText.toString(),
                type: "error",
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        }
    });
}