<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<link href="<c:url value="/resources/bootstrap-select/css/bootstrap-select.min.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-select/js/bootstrap-select.min.js" />"></script>

	<link href="<c:url value="/resources/webix/webix.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/webix/webix.js" />"></script>

	<link href="<c:url value="/resources/bootstrap-table/css/bootstrap-table.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-table/js/bootstrap-table.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-table/js/bootstrap-table-zh-CN.min.js" />"></script>

	<style type="text/css">

	.webix_message_area{
		padding-top: 50px;
	}

	input[type="input"]{
		padding: 6px 12px;
		margin-bottom: 0;
		font-size: 14px;
		font-weight: 400;
		line-height: 1.42857143;
		white-space: nowrap;


		border-bottom-color: #b3b3b3;
		border-bottom-left-radius: 3px;
		border-bottom-right-radius: 3px;
		border-bottom-style: solid;
		border-bottom-width: 1px;
		border-left-color: #b3b3b3;
		border-left-style: solid;
		border-left-width: 1px;
		border-right-color: #b3b3b3;
		border-right-style: solid;
		border-right-width: 1px;
		border-top-color: #b3b3b3;
		border-top-left-radius: 3px;
		border-top-right-radius: 3px;
		border-top-style: solid;
		border-top-width: 1px;
	}

	div[name="toolbar"] {
		padding: 8px 0px;
	}

	</style>

	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#selling">正在销售</a></li>
			<li><a data-toggle="tab" href="#deleted">已删除</a></li>
		</ul>

		<div class="tab-content" style="padding-top: 10px;">
			<div id="selling" class="tab-pane fade in active">
				<div>
					<input id="product-title" type="input" placeholder="产品标题(可选)">
					<input id="product-code" type="input" placeholder="产品编码(可选)">
					
					<select id="product-group" class="selectpicker">
						<option value="">产品分组</option>
						<option value="All">All</option>
					</select>
					<select id="product-inventory" class="selectpicker">
						<option value="">库存量</option>
						<option value="All">All</option>
						<option value="0">库存为0</option>
					</select>

					<button name="product-selling-search" type="button" class="btn btn-md btn-default">搜索</button>
				</div>

				<div>
					<div name="toolbar">
						<button class="btn btn-md btn-danger">删除</button>
						<button class="btn btn-md btn-warning">调整产品组</button>
					</div>
					<table id="selling-table" data-toggle="table" data-pagination="true" data-side-pagination="server" data-page-size="20" data-page-list="[20, 50, 100, 200]" data-url="product/search" data-query-params="query_params">
						<thead>
							<tr>
								<th data-checkbox="true"></th>
								<th data-field="title" data-formatter="title_format">产品信息</th>
								<th data-field="group">产品组</th>
								<th data-field="inventory">库存</th>
								<th data-formatter="edit_format">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div id="deleted" class="tab-pane fade">
				<h3>Menu 3</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {
		init_group_select();

		$("button[name='product-selling-search']").on("click", search_selling_product);

		detail_url = '<c:url value="/product/detail?productid=" />';

		edit_url = '<c:url value="/publish/reedit?productid=" />';
	});

	function init_group_select(){
		$.ajax({
			type: 'POST',
			url: "publish/select",
			async:false,
			success: function(nodes){
				var html = "";
				$.each(nodes, function(i, firstnode){
					html += "<optgroup label='" + firstnode.group + "'>";
					$.each(firstnode.data, function(j, secondnode){
						html += "<option value='"+ secondnode.groupid +"'>" + secondnode.group + "</option>";
					});
					html += "</optgroup>";
				});

				$("#product-group").append(html);

				$('#product-group-selecter').selectpicker('refresh');
			}
		});
	}

	function query_params(params){
		var title = $('#product-title').val();
		var code = $('#product-code').val();
		var group = $('#product-group').val();
		var inventory = $('#product-inventory').val();

		params.title = title;
		params.code = code;

		if(!group){
			group = "All";
		}

		if(!inventory){
			inventory = "All";
		}

		params.group = group;
		params.inventory = inventory;

		return params;
	}

	function search_selling_product(){
		var title = $('#product-title').val();
		var code = $('#product-code').val();
		var group = $('#product-group').val();
		var inventory = $('#product-inventory').val();

		if(title || code || group || inventory){
			$('#selling-table').bootstrapTable('refresh');
		}
		else{
			webix.message({
				type:"default", 
				text:'请输入或选择查询条件',
				expire:3000
			});
		}
	}

	function edit_format(value, row, index){
		return '<a href="' + edit_url + row.id + '">编辑</a>';
	}

	function title_format(value, row, index){
		return '<a href="' + detail_url + row.id + '">' + value + '</a>';
	}

	</script>

</body>
</html>