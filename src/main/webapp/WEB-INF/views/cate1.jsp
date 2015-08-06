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

	<script type="text/javascript">

	webix.ready(function(){
		grida = webix.ui({
			container:"treeview",
			view:"treetable",
			columns:[
			{ id:"id",	header:"", css:{"text-align":"right"},  	width:50},
			{ id:"value",	header:"Film title",	width:250,
			template:"{common.treetable()} #value#" },
			{ id:"chapter",	header:"Mode",	width:200}
			],
			autoheight:true,
			autowidth:true,

			data: [
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
			]
		});	
	});

	</script>
</body>
</html>