<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta name="description" content="">
  	<meta name="author" content="">
  	<link href="<c:url value="/resources/css/bootstrap.min.css" />"
        rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/css/signin.css" />"
        rel="stylesheet"  type="text/css" />
</head>

<body>
	
    <div class="container">

      <form id="form" class="form-signin" action="signin" method="post" role="form">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="input" id="inputUsername" class="form-control" placeholder="Username" required="required" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div>

      <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
