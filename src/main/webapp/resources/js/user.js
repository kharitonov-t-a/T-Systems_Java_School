$(document).ready(function () {

    $(document).on('click', 'button#createUserBtn', function (clickEvent) {
        modalGetAjax("/user/create")
    });

    $(document).on('submit', 'div#content-profile-box form.userForm', function (clickEvent) {
        clickEvent.preventDefault();
        userPostAjax($(this).attr("action"), $(this).serializeArray())
    });

    // edit user for admin
    $(document).on('click', 'a.btn-edit-user', function (clickEvent) {
        clickEvent.preventDefault();
        modalGetAjax($(this).attr("href"))
    });

    $(document).on('click', 'button#modalUserFormButton', function (clickEvent) {
        clickEvent.preventDefault();
        var form = $('div#content-profile-box form');
        modalPostAjax(form.attr('action'), form.serializeArray(), "/user/create");
    });

    // delete user for admin
    $(document).on('click', 'a.btn-delete-user', function (clickEvent) {
        clickEvent.preventDefault();

        swal({
            title: 'Are you sure you want to delete this user?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result)=>
        {
            if (result.value) {
            deleteAjax($(this).attr("href"), "/user/list", "User deleted!");
        }
    });

    });

});





function userPostAjax(url, form_data) {
    $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        success: function (data) {
            if ($(data).find('div#content-profile-box').length > 0) {
                $('div#body-profile-user').html($(data).find('div#content-profile-box'));

                if ($(data).find('div#successFlag').attr('data') === "success") {
                    swal({
                        title: url === "/user/password" ? "Password changed!" : "User changed!",
                        type: "success",
                        confirmButtonText: "Ok",
                        showCancelButton: false,
                        allowOutsideClick: true
                    })
                }

            }
        },
        error: function (data) {
            if ($(data.responseText).find('div#content-profile-box') != null) {
                $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
            }
        }
    });
}


