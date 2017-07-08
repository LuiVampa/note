<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Note</title>
   </head>

   <body>

<div>
    <form action = "http://localhost:8080/Bank/add_client" method = "GET">
            <table border = "0">

                <tr>
                    <td><b>Parameter1</b></td>
                        <td><input type = "text" name = "parameter1"
                            value = "http://localhost/some-test-url" size = "70"/></td>
                </tr>

                <tr>
                    <td><b>Parameter2</b></td>
                    <td><input type = "text" name = "parameter2"
                     value = "001" size = "65"/></td>
                </tr>


                <tr>
                    <td colspan = "2"><input type = "submit" value = "Start test"/></td>
                </tr>
            </table>
    </form>
</div>



   </body>
</html>