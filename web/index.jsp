<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/14
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>userinfo test</title>
</head>
<body>
<table border="0" align="center">
  <tr>
    <th>
      <h2>
        Accelerator Interface Test
      </h2>
    </th>
  </tr>
  <tr>
    <br>
    <br>
  </tr>

  <tr>
    <form action="submitUserInfo" method="get">
      <td>*New User:
        <input type="text" name="useridSubmit" id="useridSubmit" value="userid" />
        <input type="text" name="nickname" id="nickname" value="nickname" />
      </td>
      <td><input type="submit" value="Submit" /></td>

    </form>
  </tr>

  <tr><p></p></tr>

  <tr>
    <form action="getresult" method="get">
    <td>*Get UserInfo:
      <input type="text" name="useridGet" id="useridGet" value="userid"/></td>
      <td><input type="submit" value="Submit" /></td>
    </form>
  </tr>
</table>

</body>
</html>
