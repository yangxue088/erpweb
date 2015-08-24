<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="top" class="top navbar navbar-inverse navbar-default navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">电子商务平台</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="cate">主页<span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">产品管理<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<c:url value="/publish" />">发布产品</a></li>
                <li><a href="<c:url value="/cate" />">分组管理</a></li>
              </ul>
            </li>
        <li><a href="#">库存管理</a></li>
        <li><a href="#">权限管理</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/signout" />">注销</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>