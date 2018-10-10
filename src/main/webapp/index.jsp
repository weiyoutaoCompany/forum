<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
<h2>Hello World!</h2>
<a href="<%=basePath%>customer/login1">跳转登录</a>
<a href="<%=basePath%>customer/signup">跳转注册</a>
<a href="jsp/customer/updatepassword.jsp">跳转修改</a>
<a href="<%=basePath%>customer/list">列表</a>
</body>
</html>
