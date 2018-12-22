$(document).ready(function () {


    $(document).on('click', 'button#createUserAddressBtn', function (clickEvent) {
        var request = modalGetAjax("/user/address");
    });

    $(document).on('click', 'a.btn-edit-userAddress', function (clickEvent) {
        clickEvent.preventDefault();
        modalGetAjax($(this).attr("href"))
    });

    $(document).on('click', 'button#modalUserAddressFormButton', function (clickEvent) {
        clickEvent.preventDefault();
        var form = $('div#content-profile-box form');
        modalPostAjax(form.attr('action'), form.serializeArray(), "/user/address");
    });

    // delete user for admin
    $(document).on('click', 'a.btn-delete-userAddress', function (clickEvent) {
        clickEvent.preventDefault();

        swal({
            title: 'Are you sure you want to delete this address?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result)=>
        {
            if (result.value) {
            deleteAjax($(this).attr("href"), "/user/address/list");
        }
    });

    });

});