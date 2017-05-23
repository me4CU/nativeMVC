<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form
		action="${pageContext.request.contextPath}/servlet/UploadHandleServletStronger" 
		enctype="multipart/form-data" method="post">
													<!-- UploadHandleServletStronger -->
													<!-- UploadHandleServlet -->
		上传用户：<input type="text" name="username"><br /> 
		上传文件1：<input type="file" name="file1"><br /> 
		上传文件2：<input type="file" name="file2"><br /> 
		<input type="submit" value="提交">
	</form>
	<input type="button" value="Back" onclick="window.location.href='jsp/login.jsp';"/>
</body>
</html>
