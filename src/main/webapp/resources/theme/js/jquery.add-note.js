(function ($) {
    $(document).ready(function () {

        var addNote = $(".startscreen-content-add-note"),
            close = $(".new-note__close"),
            newNote = $(".new-note");

        $(addNote).click(function () {

            $(newNote).fadeIn(300);

        });

        $(close).click(function () {

            $(newNote).fadeOut(300);

        });

    })
} ( jQuery ));