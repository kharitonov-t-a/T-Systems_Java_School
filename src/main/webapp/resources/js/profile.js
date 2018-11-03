$(document).ready(function () {

    // Load edit user page when first load profile page
    getAjax("/editCurrentUser", 'div#content-profile-box');

    // menu
    $(document).on('click', '#profile-menu a', function(clickEvent) {
        clickEvent.preventDefault();
        $('#profile-menu a').removeClass("active");
        $(this).addClass("active");

        getAjax($(this).attr("href"), 'div#content-profile-box');
    })

    // edit user for admin
    $(document).on('click', 'a.btn-edit-user', function(clickEvent) {
        clickEvent.preventDefault();
        getAjax($(this).attr("href"), 'div#content-profile-box')
    });

    // delete user for admin
    $(document).on('click', 'a.btn-delete-user', function(clickEvent) {
        clickEvent.preventDefault();
        deleteAjax($(this).attr("href"), 'div#content-profile-box');
    });

    // edit current info user or his password
    $(document).on('submit', 'div#content-profile-box form', function(clickEvent) {
        // var form_data = $(this).serializeArray();
        clickEvent.preventDefault();
        var action = $(this).attr("action");
        postAjax(action, 'div#content-profile-box', $(this).serializeArray());
    });

})

function getAjax(url, attr) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            if ($(data).find(attr) != null) {
                $('div#body-profile-user').html($(data).find(attr));
            }
        },
        error: function(data){
            if ($(data.responseText).find(attr) != null) {
                $('div#body-profile-user').html($(data.responseText).find(attr));
            }
        }
    });
}

function deleteAjax(url, attr) {
    var request = $.ajax({
        url: url,
        type: 'DELETE',
        data: {_method: 'delete'},
        success: function(data){
            getAjax("/userslist", attr);
        },
        error: function(data){
            if ($(data.responseText).find('div#content-profile-box') != null) {
                $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
            }
        }
    });
}

function postAjax(url, attr, form_data) {
    $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        success: function (data) {
            if ($(data).find(attr) != null) {
                $('div#body-profile-user').html($(data).find(attr));
            }
        },
        error: function(data){
            if ($(data.responseText).find('div#content-profile-box') != null) {
                $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
            }
        }
    });
}