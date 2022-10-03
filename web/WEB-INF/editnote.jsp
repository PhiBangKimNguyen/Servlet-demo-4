<%-- 
    Document   : editnote.jsp
    Created on : 2-Oct-2022, 
    Author     : Phi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note"> 
            Title: <input type="text" name="title" value="${note.title}">
            <br>
            Content: <textarea name="contents" rows="6" cols="20">${note.contents}</textarea>
            <br>
            <input type="submit" name="saveNote" value="Save">
        </form>
    </body>
</html>
