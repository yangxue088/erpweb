<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <meta charset="utf-8">
  <title>ERP</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="<c:url value="/resources/css/bootstrap.min.css" />"
        rel="stylesheet"  type="text/css" />
</head>

<body>
    <div id="wrap">

        <c:import url="/WEB-INF/views/tags/navbar.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                  <div class="well sidebar-nav">
                    <c:import url="/WEB-INF/views/tags/menu.jsp"/>
                  </div>
                </div>

                <div class="col-md-10">
                    <div class="jumbotron">
                      <c:import url="/WEB-INF/views/tags/banner.jsp"/>
                    </div>

                    <div class="row">
                      <div class="col-md-12">
                          <div class="container">
                            <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=priyatam&repo=springmvc-twitterbootstrap-showcase&type=watch&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="100px" height="20px"></iframe>

                            <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://springmvc-twitterbootstrap-showcase.cloudfoundry.com" data-text="Spring MVC Twitter Bootstrap Showcase!">Tweet</a>
                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                          </div>

                        <hr class="soften">

                        <decorator:body />

                      </div>
                    </div><!--/col-->
                </div><!--/row-->
            </div><!--/col-->
          </div><!--/row-->

          <hr class="soften">
    </div>

    <c:import url="/WEB-INF/views/tags/footer.jsp"/>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
