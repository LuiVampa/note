(function ($) {
    $(document).ready(function () {

        var registration = $(".sign-up"),
            enter = $(".sign-in"),
            registry = $(".registry"),
            login = $(".login"),
            errorLogin = $(".error-login"),
            errorReg = $(".error-registration"),
            errorPass = $(".error-password");

        $(registration).click(function () {

            $(login).fadeOut(200);
            $(registry).fadeIn(200);
            $(errorLogin).hide();

        });

        $(enter).click(function () {

            $(login).fadeIn(200);
            $(registry).fadeOut(200);
            $(errorReg).hide();
            $(errorPass).hide();

        });

        $('#registration-form').submit(function(e){
           e.preventDefault();
           pass = $(".pass").val();
           repeatPass = $(".repeat-pass").val();
           if (pass === repeatPass) {
                $(errorPass).hide();
                var m_method = $(this).attr('method'),
                    m_action = $(this).attr('action'),
                    m_data = $(this).serialize();
                $.ajax({
                   type: m_method,
                   url: m_action,
                   data: m_data,
                   async: false,
                   success: function(result){
                       if (result === "error") {
                           $(errorReg).show();
                       } else {
                           window.location = result;
                       }
                   }
               });
           } else {
                $(errorPass).show();
           }
      });

       $('#login-form').submit(function(e){
            e.preventDefault();
            var m_method = $(this).attr('method'),
                m_action = $(this).attr('action'),
                m_data = $(this).serialize();
            $.ajax({
                type: m_method,
                url: m_action,
                data: m_data,
                async: false,
                success: function(result){
                    if (result === "error") {
                        $(errorLogin).show();
                    } else {
                        window.location = result;
                    }
                }
            });
       });
    })
} ( jQuery ));