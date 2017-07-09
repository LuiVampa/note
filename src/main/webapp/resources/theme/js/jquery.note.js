(function ($) {
    $(document).ready(function () {

        var note = $(".startscreen-content-table__note-wrapper");

        $.each(note, function () {
            if ($.trim($(this).text()).length < 30) {
                $(this).removeClass("startscreen-content-table__note-wrapper");
            }
        });

    })
} ( jQuery ));