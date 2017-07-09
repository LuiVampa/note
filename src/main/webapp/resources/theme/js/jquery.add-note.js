(function ($) {
    $(document).ready(function () {

        var addNote = $(".startscreen-content-add-note"),
            close = $(".new-note__close"),
            newNote = $(".new-note"),
            save = $(".new-note-content__save"),
            textArea = $(".new-note-content__text"),
            tableBody = $(".startscreen-content-table tbody"),
            id = $.urlParam("id");

        $(addNote).click(function () {

            $(newNote).fadeIn(200);

        });

        $(close).click(function () {

            $(newNote).fadeOut(200);

        });

        $(save).click(function(){
            $.post({
                url: "/note/notes/add",
                data: {
                          id: id,
                          page: $.urlParam("page"),
                          note: $(textArea).val()
                      },
                success: function(result){
                     window.location = "notes?id=" + id +  "&page=1";
                }
            });
        });

    })
} ( jQuery ));

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
};