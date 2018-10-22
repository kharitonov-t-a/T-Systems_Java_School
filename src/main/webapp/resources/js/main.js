$(document).ready(function(){
    $('.header').height($(window).height());

    $.ajax({
        url: "/delete-user-*",
        success: function(data){
            if($(data).find('table#user-list-table') != null){
                alert( "Прибыли данные:");
                $(this).find('table#user-list-table').html($(data).find('table#user-list-table'));
            }
        }
    });

})