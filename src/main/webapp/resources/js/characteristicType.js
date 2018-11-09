$(document).ready(function () {

    $(document).on("focus", "#checkbox-values input:last-child", function(clickEvent) {
        $("#checkbox-values").append("<input type=\"text\" class=\"form-control\" name=\"checkboxCharacteristicNameValuesString\" placeholder=\"Checkbox Name Values\"/>");
    });
});