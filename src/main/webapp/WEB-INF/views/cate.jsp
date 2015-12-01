<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<div class="container">
		<div>
			<h4>管理分组</h4>
		</div>

		<hr class="soften"></hr>

		<div id="treeview" class="treeview"></div>
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
			{ id:"cateid", hidden:true},
			{ id:"category", fillspace:2, editor:"text", header:"产品组", template:"{common.treetable()} #category#",
			footer:{text:"<a href='javascript:void(0)' style='padding:0px 5px 0px 20px;' class='cbtn'>创建分组</a>"} },
			{ id:"createSubCate", fillspace:1, header:"创建子分组", template:"<a href='javascript:void(0)' class='cbtn'>#createSubCate#</a>" },
			{ id:"manageProduct", fillspace:1, header:"组内产品管理", template:"<a href='javascript:void(0)'>#manageProduct#</a>" },
			{ id:"operation", fillspace:1, header:"操作", template:"<div class='glyphicon glyphicon-move' style='padding:0px 10px 0px 5px;'></div><div class='glyphicon glyphicon-remove' style='padding:0px 5px 0px 5px;'></div>" }
			],
			autoheight:true,
			scrollX:false,
			/*autowidth:true,*/
			footer:true,

			editable:true,
			editaction:"custom",
			select:"row",
			navigation:true,
			

			url:"cate/tree",

			drag:true,

			on:{
				onBeforeDrag:function(context, e){
					return (e.target||e.srcElement).className == "glyphicon glyphicon-move";
				},

				onBeforeDragIn:function(context, e){
					if (!context.target) return false;

					var slevel=context.from.getItem(context.start).$level;
					var tlevel=context.to.getItem(context.target).$level;

					if(slevel==0){
						return tlevel==0;
					}else{
						var spid=context.from.getParentId(context.start);
						var tpid=context.to.getParentId(context.target);
						return spid==tpid;
					}
				},

				onAfterDrop:function(context, e){
					var sname=context.from.getItem(context.start).category;
					var tname=context.to.getItem(context.target).category;

					if(sname!=tname){
						$.post("cate/sort", { sname: sname, tname: tname });
					}

					return true;
				},

				onAfterEditStop:function(state, editor, ignoreUpdate){
					var item = this.getItem(editor.row);
					if(item.manageProduct){
						if(state.value == ""){
							item.category=state.old;
							webix.message("类别名字不能为空");
						}
						else{
							if(state.value != state.old){
								$.post("cate/upt", { id: item.cateid, name: item.category });
							}
						}
					}
					else{
						if(state.value != ""){
							var tree = this;
							var previd = this.getPrevSiblingId(editor.row);
							var child = false;
							if(!previd){
								previd = this.getParentId(editor.row);
								child = true;
							}
							var pitem = this.getItem(previd);
							$.post("cate/add", { pname: pitem.category, name: item.category, child: child }, function(data){
								item.cateid = data.cateid;
								item.category = data.category;
								item.manageProduct = data.manageProduct;
								if(item.$level == 1){
									item.createSubCate="创建子分组";
									tree.open(editor.row);
								}
								else{
									item.createSubCate="";
								}

								tree.data.updateItem(item.id, item);
							});
						}
						else{
							this.remove(editor.row);
							webix.message("类别名字不能为空");

						}
					}
				},

				onAfterLoad:function(){
					var data = this.data;
					if (data.eachSubItem){
						data.eachSubItem('0', function(item){
							if(item.$level == 1){
								item.createSubCate="创建子分组";
							}
							else{
								item.createSubCate="";	
							}

							data.updateItem(item.id, item);
						});
					}

					this.openAll();
				}
			},

			onClick:{
				"cbtn":function(e, id, trg){
					var item = this.getItem(id.row);

					if(item){
						this.add({category:"", createSubCate:"", manageProduct:""}, item.$count, item.id);
						this.open(item.id);
					}else{
						this.add({category:"", createSubCate:"", manageProduct:""}, this.data.$count, "0");
					}

					var row = this.find(function(row){
						return row.category == "";
					});

					this.editCell(row[0].id, "category");

					this.focusEditor();

					return false;
				},

				"glyphicon-remove":function(e, id, trg){
					var treeview = this;
					var name = this.getItem(id.row).category;
					webix.confirm({
						text:"删除类别" + name + "？",
						ok:"是", 
						cancel:"否",
						type:"confirm-warning",
						callback:function(result){ 
							if(result){
								treeview.remove(id.row);
								$.post("cate/del", { name: name });
							}
						}
					});
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