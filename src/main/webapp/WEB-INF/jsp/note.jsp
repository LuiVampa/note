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
    
</head>

<body>
<section class="startscreen fullscreen">

    <div class="startscreen-content">
        <div class="startscreen-content-add-note"></div>

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
          <c:forEach var="note" items="${DTO}">
              <tr class="startscreen-content-table__row">
                <td class="startscreen-content-table__buttons">
                    <div class="edit button"></div>
                    <div class="remove button"></div>
                </td>
                <td class="startscreen-content-table__note">${note.content}</td>
                <td class="startscreen-content-table__creator">${note.name}</td>
                <td class="startscreen-content-table__date">${note.date}</td>
              </tr>
          </c:forEach>
        </table>
    </div>

    <div class="new-note">
        <div class="new-note-content">
            <div class="new-note__close"></div>
            <textarea class="new-note-content__text" rows="10" cols="45" name="text"></textarea>
            <button class="new-note-content__save">Сохранить</button>
        </div>
    </div>

</section>
</body>
</html>