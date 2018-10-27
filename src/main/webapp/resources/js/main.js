$(document).ready(function () {
    $('.header').height($(window).height());

    /*------------------------------------- userslist.jsp -----------------------------------------------------*/

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

    /*------------------------------------- profile.jsp -----------------------------------------------------*/












})