<%-- 
    Document   : index
    Created on : May 6, 2021, 1:42:44 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAX-WS Example</title>
        <style>
            td {
                text-align: center; 
            }
        </style>
    </head>
    <body>
        <h1><a href="MessageKeeperClient">GoTo Servlet</a></h1>
        <form name="add" action="MessageKeeperClient">
            <table border="0">
                <tbody>

                    <tr>
                        <td colspan="2">Add new message</td>
                    </tr>

                    <tr>
                        <td>User:</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>

                    <tr>
                        <td>Message:</td>
                        <td><input type="text" name="msg" value="" /></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="ADD MSG" name="addMsg" /></td>
                    </tr>

                </tbody>
            </table>

        </form>

        <form name="get1" action="MessageKeeperClient">
            <table border="0">
                <tbody>

                    <tr>
                        <td colspan="2">Get message by index</td>
                    </tr>

                    <tr>
                        <td>User:</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>

                    <tr>
                        <td>Index:</td>
                        <td><input type="text" name="msg" value="" /></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="GET MSG" name="getMsg" /></td>
                    </tr>

                </tbody>
            </table>

        </form>

        <form name="all" action="MessageKeeperClient">
            <table border="0">
                <tbody>

                    <tr>
                        <td colspan="2">Get all messages</td>
                    </tr>

                    <tr>
                        <td>User:</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="GET ALL MSGS" name="allMsg" /></td>
                    </tr>

                </tbody>
            </table>

        </form>
        <%String answer = (String) request.getAttribute("response");
            if (answer != null) {
        %>

        <%=answer%>

        <% }%>






    </body>
</html>
