var autogenerationCharacterCode = true;
$(document).ready(function () {

    /*------------------------- Main menu -------------------------*/

    // Load edit user page when first load profile page
    getAjax("/user", 'div#content-profile-box', "div#body-profile-user");

    // menu
    $(document).on('click', '#profile-menu a', function (clickEvent) {
        clickEvent.preventDefault();
        $('#profile-menu a').removeClass("active");
        $(this).addClass("active");

        getAjax($(this).attr("href"), 'div#content-profile-box', "div#body-profile-user");

    })

    // UNdisabled input for field characterCode and stop autogeneration
    $(document).on('click', '#characterCodeButton', function (clickEvent) {
        $(document).find("#characterCode").removeAttr("disabled");
        autogenerationCharacterCode = false;
    });

    $(document).on('input', 'div#content-profile-box form input#nameField', function (ev) {
        if (autogenerationCharacterCode === true) {
            $(document).find("#characterCode").val($(this).val().toLowerCase().replace(/ /g, "_").replace(/-/g, "_").replace(/	/g, "_"))
        }
    });

    // // edit current info user or his password
    // $(document).on('submit', 'div#content-profile-box form', function (clickEvent) {
    //     // var form_data = $(this).serializeArray();
    //     clickEvent.preventDefault();
    //     var action = $(this).attr("action");
    //     postAjax(action, 'div#content-profile-box', $(this).serializeArray());
    // });

});

function getAjax(url, attr, container) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            if ($(data).find(attr) != null) {
                $(container).html($(data).find(attr));
            }
        },
        error: function (data) {
            if ($(data.responseText).find(attr) != null) {
                $(container).html($(data.responseText).find(attr));
            }
        }
    });

}

// function deleteAjax(url, attr, urlget) {
//     var request = $.ajax({
//         url: url,
//         type: 'DELETE',
//         data: {_method: 'delete'},
//         success: function (data) {
//             getAjax(urlget, attr, "div#body-profile-user");
//         },
//         error: function (data) {
//             if ($(data.responseText).find('div#content-profile-box') != null) {
//                 $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
//             }
//         }
//     });
// }


// function postAjax(url, attr, form_data) {
//     $.ajax({
//         url: url,
//         type: 'POST',
//         data: form_data,
//         success: function (data) {
//             if ($(data).find(attr) != null) {
//                 $('div#body-profile-user').html($(data).find(attr));
//             }
//         },
//         error: function (data) {
//             if ($(data.responseText).find('div#content-profile-box') != null) {
//                 $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
//             }
//         }
//     });
// }

//
// //Инициализация всех деревьев на странице
// function OnInitTreeViews() {
//     var treeviews = document.getElementsByClassName('treeview');
//     for (var i = 0; i < treeviews.length; i++)
//         OnInitTreeView(treeviews[i]);
// }
//
// //Инициализация отдельного дерева
// function OnInitTreeView(treeview) {
//     var nodes = SelectChildren(treeview, 'li');
//     for (var i = 0; i < nodes.length; i++) {
//         var node = nodes[i];
//         AddEventHandler(node, "click", OnTreeViewNodeClick);
//
//         var subtreeviews = SelectChildren(node, 'ul');
//
//         if (subtreeviews.length > 0) {
//             node.style.background = 'url(images/plus.png) top left no-repeat';
//
//             for (var j = 0; j < subtreeviews.length; j++) {
//                 var subtreeview = subtreeviews[j];
//                 subtreeview.style.display = 'none';
//
//                 //Инициализируем поддеревья текущего дерева по рекурсии
//                 OnInitTreeView(subtreeview);
//             }
//         }
//         else {
//             var subdivs = SelectChildren(node, 'div');
//
//             if (subdivs.length > 0) {
//                 node.style.background = 'url(images/plus.png) top left no-repeat';
//
//                 for (var j = 0; j < subdivs.length; j++)
//                     subdivs[j].style.display = 'none';
//             }
//         }
//     }
// }
//
// //Обработчик щелчка мыши по узлу (li) дерева или любому другому дочернему элементу
// function OnTreeViewNodeClick(event) {
//     //Для firefox важно ссылку на текущее событие получать через аргумент
//     var event = event || window.event;
//     //Ссылка на текущий элемент li
//     var node = this;
//
//     //Выбираем содержимое текущего элемента li
//     var subcontents = SelectChildren(node, 'ul');
//
//     if (subcontents.length == 0)
//         subcontents = SelectChildren(node, 'div');
//
//     for (var i = 0; i < subcontents.length; i++) {
//         var subcontent = subcontents[i];
//
//         if (subcontent.style.display == 'none') {
//             subcontent.style.display = 'block';
//             node.style.background = 'url(images/minus.png) top left no-repeat';
//         }
//         else {
//             subcontent.style.display = 'none';
//             node.style.background = 'url(images/plus.png) top left no-repeat';
//         }
//     }
//
//     //Останавливаем обработку события;
//     stopBubble(event);
// }

function modalGetAjax(url) {
    return $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            $('div#content-modal-box').html($(data).find('div#content-profile-box'));
            $('div#content-profile-box form button[type=submit]').hide();
            $('#modalForm').modal('show');
            autogenerationCharacterCode = true;
        },
        error: function (data) {
            if ($(data.responseText).find(attr) != null) {
                $(container).html($(data.responseText).find(attr));
            }
        }
    });

}

function deleteAjax(url, urlget, successMessage) {
    $.ajax({
        url: url,
        type: 'DELETE',
        data: {_method: 'delete'},
        success: function (data) {
            getAjax(urlget, 'div#content-profile-box', "div#body-profile-user");
            swal({
                title: successMessage,
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        },
        error: function (data) {
            if ($(data.responseText).find('div#content-profile-box') != null) {
                $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
            }
        }
    });
}

function modalPostAjax(url, form_data, createUrl) {
    return $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        success: function (data) {
            if ($(data).find('div#successFlag').length > 0) {

                $('div#content-modal-box').html($(data).find('div#content-profile-box'));
                $('div#content-profile-box form button[type=submit]').hide();
                $('body').css('padding-right', '0px');

            } else if ($(data).find('#list-table').length > 0) {

                $('#modalForm').modal('hide');
                $('body').css('padding-right', '0px');
                swal({
                    title: url === createUrl ? "Created!" : "Changed!",
                    type: "success",
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                }).then((result)=>
                {
                    $('div#body-profile-user').html($(data).find('div#content-profile-box'));
                $('body').css('padding-right', '0px');
            });
                $('body').css('padding-right', '0px');
            }
        },
        error: function (data) {
            if ($(data.responseText).find('div#content-profile-box') != null) {
                $('div#body-profile-user').html($(data.responseText).find('div#content-profile-box'));
            }
        }
    });
}