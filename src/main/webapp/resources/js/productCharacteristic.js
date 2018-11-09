$(document).ready(function () {

    $(document).on("click", "#ProductCharacteristicTypeButton", function(clickEvent) {

        $.ajax({
            url: "/getFormProductCharacteristic",
            type: 'GET',
            data: { id: $("#ProductCharacteristicType").val(),
                    productId: $("#ProductCharacteristicTypeButton").attr("attrIdProduct")},
            success: function (data) {
                $('div#product-characteristic-addform-box').html(data);
            }
        });
    });

});