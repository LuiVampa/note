<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Note</title>

    <link href="<c:url value="/resources/css/authorization.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.ui.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.forms.js" />"></script>

</head>

<body>
    <section class="startscreen fullscreen">
        <div class="startscreen-form login">
            <form method="post" action="/note/?item">
                <ul class="startscreen-form-fields">
                    <li class="startscreen-form-fields__field">
                        <input type="text" name="login" placeholder="Логин" class="input-text">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input type="text" name="password"  placeholder="Пароль" class="input-text">
                    </li>
                </ul>
                <div class="startscreen-form-buttons">
                    <button type="submit" class="startscreen-form-buttons__enter left-button button">Войти</button>
                    <button type="button" class="startscreen-form-buttons__registry right-button sign-up button">Зарегистрироваться</button>
                </div>
            </form>
        </div>

        <div class="startscreen-form registry">
            <form method="post" action="/note/">
                <ul class="startscreen-form-fields">
                    <li class="startscreen-form-fields__field">
                        <input type="text" name="login" placeholder="Логин" class="input-text">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input type="text" name="password" placeholder="Пароль" class="input-text">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input type="text" placeholder="Повторите пароль" class="input-text">
                    </li>
                </ul>
                <div class="startscreen-form-buttons">
                    <button type="submit" class="startscreen-form-buttons__enter left-button button">Зарегистрироваться</button>
                    <button type="button" class="startscreen-form-buttons__registry right-button sign-in button">Назад</button>
                </div>
            </form>
        </div>

    </section>
</body>
</html>