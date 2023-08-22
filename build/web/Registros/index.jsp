<%-- 
    Document   : index
    Created on : 21 ago. 2023, 15:47:24
    Author     : jc997
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
    </head>
    <body>
        <h1>Registro de Libros</h1>

        <p><a href="RegistrosController?accion=nuevo">Registra tus libros</a></p>

        <table border="1" width="80%">
            <thead>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Año</th>
            
            <th></th>
            <th></th>
        </thead>

        <tbody>
            <c:forEach var="registro" items="${lista}">
                <tr>
                    <td><c:out value="${registro.titulo}" /></td>
                    <td><c:out value="${registro.autor}" /></td>
                    <td><c:out value="${registro.año}" /></td>

                    <td><a href="RegistrosController?accion=eliminar&id=<c:out value="${registro.id}" />">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>