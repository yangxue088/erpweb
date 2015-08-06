<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
	<div class="row">
		<div class="col-sm-5">
			<div id="treeview" class="treeview"></div>
		</div>
	</div>

	<link href="<c:url value="/resources/webix/webix.css" />"
	rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/webix/webix.js" />"></script>

	<script type="text/javascript">

	webix.ready(function(){
		grid = webix.ui({
			container:"treeview",
			view:"treetable",
			columns:[
			{ id:"category", editor:"text", header:"产品组", width:400, template:"{common.treetable()} #category#" },
			{ id:"createSubCategory", header:"创建子分组", width:145, template:"<a href='#'>#createSubCategory#</a>" },
			{ id:"manageProduct", header:"组内产品管理", width:145, template:"<a href='#'>#manageProduct#</a>" },
			{ id:"operation", header:"操作", width:82, template:"<div class='glyphicon glyphicon-move' style='padding:0px 5px 0px 5px;'></div><div class='glyphicon glyphicon-remove' style='padding:0px 5px 0px 5px;'></div>" }
			],
			autoheight:true,
			autowidth:true,

			editable:true,
			editaction:"custom",
			select:"cell",
			navigation:true,

			url:"cate/tree",

			drag:"order",

			on:{
				onBeforeDrag:function(data, e){
					return (e.target||e.srcElement).className == "glyphicon glyphicon-move";
				},

				onEditorChange:function(id, value){
					alert(value);
					return true;
				}
			}
		});

		webix.UIManager.addHotKey("enter", function(view){
			var pos = view.getSelectedId();
			view.edit(pos);
		}, grid);
	});

	</script>
</body>
</html>