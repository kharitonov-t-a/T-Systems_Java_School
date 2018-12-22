$(document).ready(function () {

// edit current info user or his password
    $(document).on('submit', 'form#catalogForm', function (clickEvent) {
        clickEvent.preventDefault();
        postCatalogAjax($(this).attr("action"), $(this).serializeArray());
    });

    $(document).on('click', '.catalogPageNavigate', function (clickEvent) {
        getCatalogPageAjax($(this).attr("href"));
    });

});


function postCatalogAjax(url, form_data) {
    return $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        success: function (data) {
            if ($(data).find('div#catalogBox').length > 0) {
                $('div#catalogBox').html($(data).find('div#catalogBox').html());
            }
        },
        error: function (data) {
            swal({
                title: "Get category form exception",
                type: "error",
                html: $(data.responseText).filter('div#content-exception').html(),
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        }
    });
}

function getCatalogPageAjax(url) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            if ($(data).find('.changeCategory').length > 0) {
                $('div#categoryContainer').html($(data).find('div#categoryContainer'));
            }else if ($(data).find('div#catalogBox').length > 0) {
                $('div#catalogBox').html($(data).find('div#catalogBox'));
            }
        },
        error: function (data) {
            swal({
                title: "Get category form exception",
                type: "error",
                html: $(data.responseText).filter('div#content-exception').html(),
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        }
    });
}