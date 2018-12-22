
$(document).ready(function () {
    /*------------------------- Product category -------------------------*/

    $(document).on('input', '#productCategory div#content-profile-box input[type=radio]', function (clickEvent) {
        $('form#productCategoryForm input#parentField').attr("value", $('div#content-profile-box input[type=radio]:checked').val());
        if($('div#content-profile-box label.treeLabel').attr("data") === "edit")
            getProductCategoryAjax("/productCategory/" + $('div#content-profile-box input[type=radio]:checked').val());
    });



    $(document).on('click', 'button.getProductCategoryForm', function (clickEvent) {
        clickEvent.preventDefault();

        if ($('div#content-profile-box input[type=radio]:checked').val() != null) {

            // add form fields for edit category
            if ($(this).attr("name") === "edit") {
                getProductCategoryAjax("/productCategory/" + $('div#content-profile-box input[type=radio]:checked').val());
                $('div#content-profile-box label.treeLabel').html("Changed category");
                $('div#content-profile-box label.treeLabel').attr("data", "edit");

                // add form fields for create category
            } else {
                getProductCategoryAjax('/productCategory');
                $('div#content-profile-box label.treeLabel').html("Parent category");
                $('div#content-profile-box label.treeLabel').attr("data", "create");
            }

        } else {
            swal({
                title: "Select category!",
                type: "info",
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        }

    });

    // delete category
    $(document).on('click', '.deleteCategory', function (clickEvent) {
        if ($('div#content-profile-box input[type=radio]:checked').val() != null) {

            swal({
                title: 'Are you sure?',
                text: "All slaved categories will be deleted!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result)=>
            {
                if (result.value) {
                    var categoryId = $('div#content-profile-box input[type=radio]:checked').val();
                    deleteAjax("/productCategory/" + categoryId, "/productCategory/list");
                }
            });

        } else {
            swal({
                title: "Select category!",
                type: "info",
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        }

    });

    // edit current info user or his password
    $(document).on('submit', 'div#content-profile-box form#productCategoryForm', function (clickEvent) {
        clickEvent.preventDefault();
        postProductCategoryAjax($(this).attr("action"), $(this).serializeArray());
    });


});

function getProductCategoryAjax(url) {
    $.ajax({
        url: url,
        type: 'GET',
        context: $( "div#content-productCategory-box" ),
        success: function (data) {
            if ($(data).filter('div#content-productCategory').length > 0) {
                $(this).html($(data).filter('#content-productCategory'));
                $('input#parentField').attr("value", $('div#content-profile-box input[type=radio]:checked').val());
            }
        },
        error: function (data) {
            if ($(data).filter('div#content-exception').length > 0) {
                swal({
                    title: "Get category form exception",
                    type: "error",
                    html: $(data.responseText).filter('div#content-exception').html(),
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }
        }
    });
}

function postProductCategoryAjax(url, form_data) {
    var attr=$("div#content-productCategory");
    $.ajax({
        url: url,
        type: 'POST',
        data: form_data,
        context: $('div#content-productCategory-box'),
        success: function (data) {
            if ($(data).filter(attr).length > 0) {
                $(this).html($(data).filter(attr));
            }
            else if($(data).find('div#content-profile-box').length > 0){
                $('div#body-profile-user').html($(data).find('div#content-profile-box'));
                swal({
                    title: url === "/productCategory" ? "Category created!" : "Category changed!",
                    type: "success",
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }
        },
        error: function (data) {
            if ($(data).filter('div#content-exception').length > 0) {
                swal({
                    title: "Check category structure exception",
                    type: "error",
                    html: $(data.responseText).filter('div#content-exception').html(),
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }
        }
    });
}

function deleteAjax(url, urlget) {
    var request = $.ajax({
        url: url,
        type: 'DELETE',
        data: {_method: 'delete'},
        success: function (data) {
            getAjax(urlget, 'div#content-profile-box', "div#body-profile-user");
            swal({
                title: "Category deleted!",
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false,
                allowOutsideClick: true
            });
        },
        error: function (data) {
            if ($(data).filter('div#content-exception').length > 0) {
                swal({
                    title: "Delete category exception",
                    type: "error",
                    html: $(data.responseText).filter('div#content-exception').html(),
                    confirmButtonText: "Ok",
                    showCancelButton: false,
                    allowOutsideClick: true
                });
            }
        }
    });
}