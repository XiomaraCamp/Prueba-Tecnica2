<%-- 
    Document   : nuevo
    Created on : 21 ago. 2023, 15:47:34
    Author     : jc997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo producto</title>
    </head>
    <body>
        <h1>Nuevo registro</h1>

        <form action="RegistrosController?accion=insertar" method="POST" autocomplete="off">
            
            <input id="id"  name="id" type="hidden" />
            
                Titulo: <input type="text" id="titulo" name="titulo" required autofocus="true" />
            

            <p>
                Autor: <input type="text" id="autor" name="autor" required />
            </p>

            <p>
                Año: <input type="text" id="año" name="año" required />
            </p>

            

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
