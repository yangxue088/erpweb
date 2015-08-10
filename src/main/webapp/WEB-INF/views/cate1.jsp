<%@ page language="java" contentType="text/html; charset=UTF-1"
pageEncoding="UTF-1"%>

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
			{ id:"operation", header:"操作", width:12, template:"<div class='glyphicon glyphicon-move' style='padding:0px 5px 0px 5px;'></div><div class='glyphicon glyphicon-remove' style='padding:0px 5px 0px 5px;'></div>" },
			{ id:"depth", hidden:true},
			{ id:"id", hidden:true}
			],
			autoheight:true,
			autowidth:true,

			editable:true,
			editaction:"custom",
			select:"cell",
			navigation:true,

			url:"cate/tree",

			drag:"true",

			on:{
				onBeforeDrag:function(context, e){
					return (e.target||e.srcElement).className == "glyphicon glyphicon-move";
				},

				onBeforeDragIn:function(context, e){
					if (!context.target) return false;

					var sdepth=context.from.getItem(context.start).depth;
					var tdepth=context.to.getItem(context.target).depth;

					if(sdepth==0){
						return tdepth==0;
					}else{
						var spid=context.from.getParentId(context.start);
						var tpid=context.to.getParentId(context.target);
						return spid==tpid;
					}
				},

				onAfterDrop:function(context, e){
					var sid=context.from.getItem(context.start).id;
					var tid=context.to.getItem(context.target).id;

					if(sid!=tid){
						$.post("cate/exchange", { sid: sid, tid: tid });
					}

					return true;
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