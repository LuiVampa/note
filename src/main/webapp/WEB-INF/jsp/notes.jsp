<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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