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
  <link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />"
  rel="stylesheet"  type="text/css" />
  <link href="<c:url value="/resources/erp/css/main-layout.css" />"
  rel="stylesheet"  type="text/css" />

  <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/bootstrap/bootstrap.min.js" />"></script>
</head>

<body>
  <div>

    <c:import url="/WEB-INF/views/tags/navbar.jsp"/>

    <div class="container">
      <decorator:body />
    </div>

    <c:import url="/WEB-INF/views/tags/footer.jsp"/>
    
  </div>

</body>
</html>
