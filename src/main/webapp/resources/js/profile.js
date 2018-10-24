$(document).ready(function () {

    getEditCurrentUserForm();

    $(document).on('click', '#profile-menu a', function(clickEvent) {
        $('#profile-menu a').removeClass("active");
        $(this).addClass("active");
    });

    $(document).on('submit', 'div#signup-user-box form', function(clickEvent) {
        var form_data = $(this).serializeArray();
        clickEvent.preventDefault();
        $.ajax({
            url: "/editCurrentUser",
            type: 'POST',
            data: form_data,
            success: function (data) {
                if ($(data).find('div#signup-user-box') != null) {
                    $('div#body-profile-user').html($(data).find('div#signup-user-box'));
                }
            }
        });
    });

    $(document).on('click', '#edit-current-user', function(clickEvent) {
        clickEvent.preventDefault();
        getEditCurrentUserForm();
    });

    $(document).on('click', '#get-users-list-box', function(clickEvent) {
        clickEvent.preventDefault();
        getUsersListBox();
    });




})

function getEditCurrentUserForm() {
    $.ajax({
        url: "/editCurrentUser",
        type: 'GET',
        success: function (data) {
            if ($(data).find('div#signup-user-box') != null) {
                // alert("Прибыли данные:");
                $('div#body-profile-user').html($(data).find('div#signup-user-box'));
            }
        }
    });
}
function getUsersListBox() {
    $.ajax({
        url: "/userslist",
        type: 'GET',
        success: function (data) {
            if ($(data).find('div#users-list-box') != null) {
                // alert("Прибыли данные:");
                $('div#body-profile-user').html($(data).find('div#users-list-box'));
            }
        }
    });
}