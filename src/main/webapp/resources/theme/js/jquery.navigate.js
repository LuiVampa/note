(function ($) {
    $(document).ready(function () {

        var navigateLeft = $(".navigate-left"),
            navigateRight = $(".navigate-right"),
            allPages = parseInt($(".all-pages").text()),
            pageInput = $(".navigate-pages__page"),
            pageNumber = parseInt($(pageInput).val()),
            error = $(".wrapper");


         if (pageNumber === 1) {
            $(navigateLeft).css('background', 'url("resources/img/left-passive.svg") no-repeat center / contain');
            $(navigateLeft).removeClass('navigate-hover');
            if (allPages === 1) {
                $(navigateRight).css('background', 'url("resources/img/right-passive.svg") no-repeat center / contain');
                $(navigateRight).removeClass('navigate-hover');
            } else {
                $(navigateRight).css('background', 'url("resources/img/right-active.svg") no-repeat center / contain');
                $(navigateRight).addClass('navigate-hover');
            }
         } else if (pageNumber === allPages && allPages > 1) {
            $(navigateRight).css('background', 'url("resources/img/right-passive.svg") no-repeat center / contain');
            $(navigateLeft).css('background', 'url("resources/img/left-active.svg") no-repeat center / contain');
            $(navigateRight).removeClass('navigate-hover');
            $(navigateLeft).addClass('navigate-hover');
         } else {
            $(navigateLeft).css('background', 'url("resources/img/left-active.svg") no-repeat center / contain');
            $(navigateRight).css('background', 'url("resources/img/right-active.svg") no-repeat center / contain');
            $(navigateLeft).addClass('navigate-hover');
            $(navigateRight).addClass('navigate-hover');
         }

         $(pageInput).on('keypress', function (e) {
                    page = parseInt($(pageInput).val());
                  if(e.which === 13){
                    if (page <= allPages) {
                       window.location = "notes?id=" + $.urlParam("id") +  "&page=" + page;
                    } else {
                        $(pageInput).val(pageNumber);
                         $(error).fadeIn(200);
                         $(error).fadeOut(1200);
                       }
                  }
            });

        $(navigateLeft).click(function(){
            if (pageNumber > 1) {
                window.location = "notes?id=" + $.urlParam("id") +  "&page=" + (pageNumber - 1);
            }
        });

        $(navigateRight).click(function(){
            if (pageNumber < allPages) {
                window.location = "notes?id=" + $.urlParam("id") +  "&page=" + (pageNumber + 1);
            }
        });
    })
} ( jQuery ));