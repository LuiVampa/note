<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Note</title>

    <link href="<c:url value="/resources/css/note.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.ui.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.add-note.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.remove.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.edit.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.navigate.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.note.js" />"></script>

</head>

<body>
<section class="startscreen fullscreen">

    <div class="startscreen-content">
        <div class="startscreen-content-add-note transition"></div>

        <table class="startscreen-content-table">
            <tr class="startscreen-content-table__name">
                <th class="startscreen-content-table__buttons"></th>
                <th class="startscreen-content-table__note">
                    Заметка
                </th>
                <th class="startscreen-content-table__creator">
                    Создатель
                </th>
                <th class="startscreen-content-table__date">
                    Дата создания
                </th>
            </tr>
          <c:forEach var="note" items="${notes}">
              <tr class="startscreen-content-table__row">
                <td class="startscreen-content-table__buttons">
                    <div id="edit-<c:out value="${note.id}"/>" class="edit button transition "></div>
                    <div id="remove-<c:out value="${note.id}"/>" class="remove button transition "></div>
                </td>
                <td class="startscreen-content-table__note">
                    <div class="startscreen-content-table__note-wrapper transition"><c:out value="${note.content}"/></div>
                </td>
                <td class="startscreen-content-table__creator"><c:out value="${note.name}"/></td>
                <td class="startscreen-content-table__date"><c:out value="${note.date}"/></td>
              </tr>
          </c:forEach>
        </table>
    </div>

    <div class="navigate">
        <div class="navigate-left navigate-size transition"></div>
            <div class="navigate-pages">
                <input type="number" value="${page}" min="1" class="navigate-pages__page transition">
                <p class="navigate-pages__count">из <span class="all-pages">${pageCount}</span></p>
            </div>
        <div class="navigate-right navigate-size transition"></div>
    </div>

    <div class="wrapper">
        <div class="navigate-error__page"><p class="navigate-error__page-text">Неверный номер страницы!</p></div>
    </div>

    <div class="new-note">
        <div class="new-note-content">
            <div class="new-note__close"></div>
            <textarea class="new-note-content__text" rows="10" cols="45" name="text"></textarea>
            <button class="new-note-content__save transition">Сохранить</button>
        </div>
    </div>

    <div class="edit-note">
        <div class="edit-note-content">
            <textarea class="edit-note-content__text" rows="10" cols="45" name="text"></textarea>
            <button class="edit-note-content__save transition">Сохранить</button>
            <button class="edit-note-content__cancel transition">Отменить</button>
        </div>
    </div>

    <div class="remove-note">
        <div class="remove-note-content">
            <div class="align">
                <h2 class="remove-note-content-header">Удалить заметку?</h2>
                <button class="remove-note-content__remove transition">Удалить</button>
                <button class="remove-note-content__cancel transition">Отменить</button>
            </div>
        </div>
    </div>
</section>
</body>
</html>