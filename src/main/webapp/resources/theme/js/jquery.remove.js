(function ($) {
    $(document).ready(function () {

        var question = $(".remove-note"),
            cancel = $(".remove-note-content__cancel"),
            removeQ = $(".remove-note-content__remove"),
            tableBody = $(".startscreen-content-table tbody"),
            id = $.urlParam("id"),
            page = $.urlParam("page");



        $(".startscreen-content-table").on('click', ".remove", function() {
            $(question).fadeIn(200);
            noteId = this.id.slice(-1);
        });

        $(cancel).click(function(){
            $(question).fadeOut(200);
        });

        $(removeQ).click(function(){
           $.post({
               url: "/note/notes/remove",
               data: {
                         id: id,
                         page: page,
                         noteId: Number(noteId)
                     },
               async: false,
               success: function(result){
                   window.location = "notes?id=" + id +  "&page=" + page;
               }
           });
        });
    })
} ( jQuery ));