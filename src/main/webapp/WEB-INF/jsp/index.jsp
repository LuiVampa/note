<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
            <p class="startscreen-form-error error-login">Введен неверный логин или пароль!</p>
            <form id="login-form" method="get" action="/note/login">
                <ul class="startscreen-form-fields">
                    <li class="startscreen-form-fields__field">
                        <input
                            type="text"
                            autocomplete="off"
                            name="login"
                            placeholder="Логин"
                            class="input-text"
                            required="required"
                            pattern="[A-Za-zА-Яа-яЁё0-9]{1,16}">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input
                            type="password"
                            autocomplete="off"
                            name="password"
                            placeholder="Пароль"
                            class="input-text"
                            required="required"
                            pattern="[A-Za-zА-Яа-яЁё0-9]{1,8}">
                    </li>
                </ul>
                <div class="startscreen-form-buttons">
                    <button type="submit" class="startscreen-form-buttons__enter left-button button transition">
                        Войти
                    </button>
                    <button type="button" class="startscreen-form-buttons__registry right-button sign-up button transition">
                        Регистрация
                    </button>
                </div>
            </form>
        </div>

        <div class="startscreen-form registry">
            <p class="startscreen-form-error error-registration">Этот логин уже занят!</p>
            <p class="startscreen-form-error error-password">Пароли не совпадают!</p>
            <form id="registration-form" method="post" action="/note/login">
                <ul class="startscreen-form-fields">
                    <li class="startscreen-form-fields__field">
                        <input
                            type="text"
                            autocomplete="off"
                            name="login"
                            placeholder="Логин"
                            class="input-text"
                            required="required"
                            pattern="[A-Za-zА-Яа-яЁё0-9]{1,16}">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input
                            type="password"
                            autocomplete="off"
                            name="password"
                            placeholder="Пароль"
                            class="input-text pass"
                            required="required"
                            pattern="[A-Za-zА-Яа-яЁё0-9]{1,8}">
                    </li>
                    <li class="startscreen-form-fields__field">
                        <input
                            type="password"
                            autocomplete="off"
                            placeholder="Повторите пароль"
                            class="input-text repeat-pass"
                            required="required"
                            pattern="[A-Za-zА-Яа-яЁё0-9]{1,8}">
                    </li>
                </ul>
                <div class="startscreen-form-buttons">
                    <button type="submit" class="startscreen-form-buttons__enter left-button button transition">
                        Зарегистрироваться
                    </button>
                    <button type="button" class="startscreen-form-buttons__registry right-button sign-in button transition">
                        Назад
                    </button>
                </div>
            </form>
        </div>

    </section>
</body>
</html>