(function($) {
    $.fn.menumaker = function(options) {

        var nuvebar = $(this), settings = $.extend({
            title: "Menu",
            format: "dropdown",
            sticky: false
        }, options);

        return this.each(function() {
            nuvebar.prepend('<div id="menu-button">' + settings.title + '</div>');
            $(this).find("#menu-button").on('click', function(){
                    $(this).toggleClass('menu-opened');
                var mainmenu = $(this).next('ul');
                if (mainmenu.hasClass('open')) {
                    mainmenu.hide().removeClass('open');
                    $("ul#authorize").hide().removeClass('open');
                }
                else {
                    mainmenu.show().addClass('open');
                    $("ul#authorize").show().addClass('open');

                    if (settings.format === "dropdown") {
                        mainmenu.find('ul').show();
                        $("ul#authorize").find('ul').show();
                    }
                }
            });

            nuvebar.find('li ul').parent().addClass('has-sub');

            multiTg = function() {
                nuvebar.find(".has-sub").prepend('<span class="submenu-button"></span>');
                nuvebar.find('.submenu-button').on('click', function() {
                    $(this).toggleClass('submenu-opened');
                    if ($(this).siblings('ul').hasClass('open')) {
                        $(this).siblings('ul').removeClass('open').hide();
                    }
                    else {
                        $(this).siblings('ul').addClass('open').show();
                    }
                });
            };

            if (settings.format === 'multitoggle') multiTg();
            else nuvebar.addClass('dropdown');

            if (settings.sticky === true) nuvebar.css('position', 'fixed');

            resizeFix = function() {
                if ($( window ).width() > 768) {
                    nuvebar.find('ul').show();
                }

                if ($(window).width() <= 768) {
                    nuvebar.find('ul').hide().removeClass('open');
                }
            };
            resizeFix();
            return $(window).on('resize', resizeFix);

        });
    };
})(jQuery);

(function($){
    $(document).ready(function(){

        $("#nuvebar").menumaker({
            title: "Menu",
            format: "multitoggle"
        });

    });
})(jQuery);
var flag = false;
$(window).scroll(function () {
    if (flag == false && $(this).scrollTop() >= 46) {
        flag = true;
        $(".cd-cart-container").css({"top": "-15px"});
        $(".shoppingCartShow").css({"top": "13px"});
    } else if (flag == true && $(this).scrollTop() < 46){
        flag = false;
        $(".cd-cart-container").css({"top": "0"});
        $(".shoppingCartShow").css({"top": "29px"});
    }
});