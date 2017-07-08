(function ($) {
    $(document).ready(function () {

        var registration = $(".sign-up"),
        enter = $(".sign-in");

        $(registration).click(function () {

            $(".registry").fadeIn(300);
            $(".login").fadeOut(300);

        });

        $(enter).click(function () {

            $(".login").fadeIn(300);
            $(".registry").fadeOut(300);

        });

    })
} ( jQuery ));