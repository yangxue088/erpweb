<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	
</head>
<body>
	<div class="row">
		<div class="col-sm-3">
			<div id="treeview" class="treeview"></div>
		</div>
		<div class="col-sm-9">
			
		</div>
	</div>

	<link href="<c:url value="/resources/webix/webix.css" />"
	rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/webix/webix.js" />"></script>

	<style type="text/css">
			.webix_drag_handle{
				background-image:url("<c:url value="/resources/webix/webix.js" />");
				background-repeat: no-repeat;
				background-position: -2px 3px;
				width:20px;
				height:20px;
				cursor:n-resize;
			}
	</style>

	<script type="text/javascript">

	webix.ready(function(){
		grida = webix.ui({
			container:"treeview",
			view:"treetable",
			columns:[
			{ id:"value", editor:"text", header:"产品组", width:400, template:"{common.treetable()} #value#" },
			{ id:"id", header:"展开分组", css:{"text-align":"right"}, width:100},
			{ id:"chapter", header:"组内产品管理", width:145},
			{ id:"op", header:"操作", width:82}
			],
			autoheight:true,
			autowidth:true,
			/*editable:true,*/
			select:"row",
			drag:true,

			url:"cate/tree"

			/*data: [
			{ "id":"1", "value":"The Shawshank Redemption", "open":true, "data":[
			{ "id":"1.1", "value":"Part 1", "chapter":"alpha"},
			{ "id":"1.2", "value":"Part 2", "chapter":"beta", "open":true, "data":[
			{ "id":"1.2.1", "value":"Part 1", "chapter":"beta-twin"},
			{ "id":"1.2.2", "value":"Part 1", "chapter":"beta-twin"}
			]},
			{ "id":"1.3", "value":"Part 3", "chapter":"gamma" }
			]},
			{ "id":"2", "value":"The Godfather", "data":[
			{ "id":"2.1", "value":"Part 1", "chapter":"alpha" },
			{ "id":"2.2", "value":"Part 2", "chapter":"beta" }
			]}
			]*/
		});	
	});

	</script>
</body>
</html>