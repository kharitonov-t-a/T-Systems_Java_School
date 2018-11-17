$(document).ready(function () {

    /*------------------------- Main menu -------------------------*/

    // Load edit user page when first load profile page
    getAjax("/editCurrentUser", 'div#content-profile-box', "div#body-profile-user");

    // menu
    $(document).on('click', '#profile-menu a', function(clickEvent) {
        clickEvent.preventDefault();
        $('#profile-menu a').removeClass("active");
        $(this).addClass("active");

        getAjax($(this).attr("href"), 'div#content-profile-box', "div#body-profile-user");

    })




    /*------------------------- Product category -------------------------*/

    $(document).on('click', 'button.getProductCategoryForm', function(clickEvent) {
        clickEvent.preventDefault();

        if($(this).attr("name") === "edit"){
            $('form#productCategoryForm').attr("method", "put");
            var d = $('form#productCategoryForm').serializeArray();
            getAjax("/productCategory/form/" + $('ul.treeview input[path=parent]:checked').val(), 'div#content-productCategory', "div#content-productCategory-box");
        }else{
            getAjax("/productCategory/form", 'div#content-productCategory', "div#content-productCategory-box");
        }
    });

    // menu
    $(document).on('click', '.deleteCategory', function(clickEvent) {
        var categoryId = document.querySelector('div#content-profile-box form input[type=radio]:checked').value;
        deleteAjax("/deleteCategory-"+categoryId, 'div#content-profile-box', "/productCategory");
    })







    // edit user for admin
    $(document).on('click', 'a.btn-edit-user', function(clickEvent) {
        clickEvent.preventDefault();
        getAjax($(this).attr("href"), 'div#content-profile-box', "div#body-profile-user")
    });

    // delete user for admin
    $(document).on('click', 'a.btn-delete-user', function(clickEvent) {
        clickEvent.preventDefault();
        deleteAjax($(this).attr("href"), 'div#content-profile-box', "/userslist");
    });


    // edit current info user or his password
    $(document).on('submit', 'div#content-profile-box form', function(clickEvent) {
        // var form_data = $(this).serializeArray();
        clickEvent.preventDefault();
        var action = $(this).attr("action");
        postAjax(action, 'div#content-profile-box', $(this).serializeArray());
    });

})

function getAjax(url, attr, container) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            if ($(data).find(attr) != null) {
                $(container).html($(data).find(attr));
            }
        },
        error: function(data){
            if ($(data.responseText).find(attr) != null) {
                $(container).html($(data.responseText).find(attr));
            }
        }
    });
}

function deleteAjax(url, attr, urlget) {
    var request = $.ajax({
        url: url,
        type: 'DELETE',
        data: {_method: 'delete'},
        success: function(data){
            getAjax(urlget, attr, "div#body-profile-user");
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


//Инициализация всех деревьев на странице
function OnInitTreeViews()
{
    var treeviews = document.getElementsByClassName('treeview');
    for(var i = 0; i < treeviews.length; i++)
        OnInitTreeView(treeviews[i]);
}

//Инициализация отдельного дерева
function OnInitTreeView(treeview)
{
    var nodes = SelectChildren(treeview, 'li');
    for(var i = 0; i < nodes.length; i++)
    {
        var node=nodes[i];
        AddEventHandler(node, "click", OnTreeViewNodeClick);

        var subtreeviews = SelectChildren(node, 'ul');

        if (subtreeviews.length > 0)
        {
            node.style.background = 'url(images/plus.png) top left no-repeat';

            for(var j = 0; j < subtreeviews.length; j++)
            {
                var subtreeview = subtreeviews[j];
                subtreeview.style.display = 'none';

                //Инициализируем поддеревья текущего дерева по рекурсии
                OnInitTreeView(subtreeview);
            }
        }
        else
        {
            var subdivs = SelectChildren(node, 'div');

            if (subdivs.length > 0)
            {
                node.style.background = 'url(images/plus.png) top left no-repeat';

                for(var j = 0; j < subdivs.length; j++)
                    subdivs[j].style.display = 'none';
            }
        }
    }
}

//Обработчик щелчка мыши по узлу (li) дерева или любому другому дочернему элементу
function OnTreeViewNodeClick(event)
{
    //Для firefox важно ссылку на текущее событие получать через аргумент
    var event = event || window.event;
    //Ссылка на текущий элемент li
    var node = this;

    //Выбираем содержимое текущего элемента li
    var subcontents = SelectChildren(node, 'ul');

    if (subcontents.length == 0)
        subcontents = SelectChildren(node, 'div');

    for(var i = 0; i < subcontents.length; i++)
    {
        var subcontent = subcontents[i];

        if (subcontent.style.display == 'none')
        {
            subcontent.style.display = 'block';
            node.style.background = 'url(images/minus.png) top left no-repeat';
        }
        else
        {
            subcontent.style.display = 'none';
            node.style.background = 'url(images/plus.png) top left no-repeat';
        }
    }

    //Останавливаем обработку события;
    stopBubble(event);
}