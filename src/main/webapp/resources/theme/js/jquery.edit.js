(function ($) {
    $(document).ready(function () {

        var editField = $(".edit-note"),
            editArea = $(".edit-note-content__text"),
            cancel = $(".edit-note-content__cancel"),
            save = $(".edit-note-content__save"),
            note,
            noteId;

        $(".startscreen-content-table").on('click', ".edit", function() {
             $(editField).fadeIn(300);
             note = $(this).parent().next().children();
             $(editArea).val(note.html().trim());
             noteId = this.id.slice(-1);
        });

        $(cancel).click(function(){
            $(editField).fadeOut(300);
        });

        $(save).click(function(){
            $.ajax({
               type: "POST",
               url: "/note/notes/edit",
               data: {
                         id: $.urlParam("id"),
                         page: $.urlParam("page"),
                         noteId: Number(noteId),
                         content: $(editArea).val()
                     },
               async: false,
               success: function(result){
                   $(editField).fadeOut(300);
                   if (result.length > 30) {
                        $(note).addClass("startscreen-content-table__note-wrapper");
                   } else {
                        $(note).removeClass("startscreen-content-table__note-wrapper");
                   }
                   $(note).html(result);
               }
           });
        });
    })
} ( jQuery ));
