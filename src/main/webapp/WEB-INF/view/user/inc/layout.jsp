<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/index.css">

</head>
<body>
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
 

    <!-- --------------------------- <body> --------------------------------------- -->
	  	
	<tiles:insertAttribute name="main" />


    <!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
	
</body>
</html>