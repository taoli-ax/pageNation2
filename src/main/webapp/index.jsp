<%--
  Created by IntelliJ IDEA.
  User: deuta
  Date: 2023/4/3
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.6.4.js"></script>
  </head>
  <body>
  $END$
  <button><a href="${pageContext.request.contextPath}/cup"></a></button>
  </body>
  <script>
    $(document).ready(function (){
      show();
    })
    function show(){
      $.ajax({
        url:"${pageContext.request.contextPath}/cup",
        type:"get",
        dataType:"json",
        success:function (msg){
          alert(msg);
        }

      })
    }
  </script>
</html>
