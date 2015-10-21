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

	<link href="<c:url value="/resources/bootstrap-modal/css/bootstrap-modal-bs3patch.css" />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value="/resources/bootstrap-modal/css/bootstrap-modal.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-modal/js/bootstrap-modalmanager.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-modal/js/bootstrap-modal.js" />"></script>

	<link href="<c:url value="/resources/bootstrap-treeview/css/bootstrap-treeview.min.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-treeview/js/bootstrap-treeview.min.js" />"></script>

	<style type="text/css">

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

	input[type="number"]{

		max-width: 100px;
		padding: 4px 8px;
		margin-bottom: -4px;
		margin-top: -4px;
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
						<button class="btn btn-md btn-danger">下架</button>
						<button class="btn btn-md btn-warning" data-toggle="modal" data-target="#group-modal">调整产品组</button>
					</div>
					<table id="selling-table" data-toggle="table" data-pagination="true" data-side-pagination="server" data-page-size="20" data-page-list="[20, 50, 100, 200]" data-url="product/search" data-query-params="query_selling_params" data-id-field="id" data-unique-id="id">
						<thead>
							<tr>
								<th data-checkbox="true"></th>
								<th data-field="id" data-visible="false"></th>
								<th data-field="title" data-formatter="title_format">产品信息</th>
								<th data-field="group">产品组</th>
								<th data-field="inventory">库存</th>
								<th data-formatter="edit_format" data-events="stock_manage">操作</th>
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

		<div id="stock-modal" class="modal fade" tabindex="-1" style="display: none;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">库存设置</h4>
			</div>
			<div class="modal-body">
				<table id="stock-table" data-toggle="table" style="">
					<thead>
						<tr>
							<th data-field="sale-style" data-width="%40">套餐</th>
							<th data-field="color" data-width="%40">颜色</th>
							<th data-field="inventory" data-width="%20" data-formatter="inventory_format" data-events="set_stock">余量</th>
							<th data-field="sale-style-name" data-visible="false"></th>
							<th data-field="color-name" data-visible="false"></th>
							<th data-field="code" data-visible="false"></th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
				<button type="button" data-dismiss="modal" class="btn btn-primary">设置</button>
			</div>
		</div>

		<div id="group-modal" class="modal fade" tabindex="-1" style="display: none;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">选择分组</h4>
			</div>
			<div class="modal-body">
				<div id="group-tree"></div>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
				<button type="button" data-dismiss="modal" class="btn btn-primary">确定</button>
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {
		init_group_select();

		$("button[name='product-selling-search']").on("click", search_selling_product);

		detail_url = '<c:url value="/product/detail?productid=" />';

		edit_url = '<c:url value="/publish/reedit?productid=" />';

		$("div[name='toolbar'] button:nth-child(1)").on("click", offshe_btn_click);

		$("div[name='toolbar'] button:nth-child(2)").on("click", group_btn_click);

		$("#stock-modal").find("button:nth-child(2)").on("click", setStock);

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

	function query_selling_params(params){
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
		params.state = 0;

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
		return '<a href="' + edit_url + row.id + '">编辑</a><a style="margin-left: 8px;" href="javascript:void(0)" data-toggle="modal" data-target="#stock-modal">库存</a>';
	}

	function title_format(value, row, index){
		return '<a href="' + detail_url + row.id + '">' + value + '</a>';
	}

	window.stock_manage = {
		'click a:nth-child(2)': function (e, value, row, index) {
			show_stock_modal(row.id);

			currentRow = row.id;

			currentIndex = index;
		}
	};

	window.set_stock = {
		'input input': function (e, value, row, index) {
			changed = true;
		}
	};

	function show_stock_modal(id){

		var rows = [];

		$.post("product/getProduct", { productId: id }, function(product){

			var pro = JSON.parse(product.json);

			$.post("product/getStocks", { productId: id }, function(stocks){
				$.each(stocks, function(i, stock){
					rows.push({
						"sale-style-name": stock[0],
						"sale-style": pro.salestyles[stock[0]],
						"color-name": stock[1],
						"color": pro.colors[stock[1]],
						"inventory": stock[2], 
						"code": stock[3]
					});
				});

				$("#stock-table").bootstrapTable('showColumn', 'sale-style');
				$("#stock-table").bootstrapTable('showColumn', 'color');

				if(pro.salestyles.length == 0 && pro.colors.length == 0){
					$("#stock-table").bootstrapTable('hideColumn', 'sale-style');
					$("#stock-table").bootstrapTable('hideColumn', 'color');
				}

				$("#stock-table").bootstrapTable('load', rows);

				changed = false;
			});
		});
	}

	function inventory_format(value, row, index){
		return "<input type='number' min='0' value='" + value + "'>";
	}

	function setStock(){
		if(changed){
			var inputs = $("#stock-table").find("input");

			var stocks = [];

			$.each($("#stock-table").bootstrapTable('getData'), function(i, row){
				stocks.push(row["sale-style-name"]);
				stocks.push(row["color-name"]);
				stocks.push($(inputs[i]).val());
				stocks.push(row["code"]);
			});

			$.post("product/setStocks", { productId: currentRow, stocks: JSON.stringify(stocks) }, function(result){

				var row = $('#selling-table').bootstrapTable("getRowByUniqueId", currentRow);

				var sum = 0;
				$.each(inputs, function(i, input){
					sum += parseInt($(input).val());
				});

				row.inventory = sum;

				$('#selling-table').bootstrapTable("updateRow", { index: currentIndex, row: row});

				$("#stock-table").bootstrapTable('refresh');
			});
		}
	}

	function getCheckedIds(){
		var ids = [];
		$.each($('#selling-table').bootstrapTable('getSelections'), function(i, item){
			ids.push(item.id);
		});
		return ids;
	}

	function offshe_btn_click(){
		var ids = getCheckedIds();

		if(ids.length > 0){
			$.ajax({
				url: "product/offshe",
				dataType: "json",
				contentType: "application/json;charset=utf-8",
				type: "POST",
				data: JSON.stringify(ids),
				success: function(result){
					$('#selling-table').bootstrapTable('remove', {field: "id", values: ids});
				}
			});
		}
		else{
			webix.message({
				type:"default", 
				text:'至少选择一个',
				expire:3000
			});
		}
	}

	var checkNode;

	function group_btn_click(){
		
	}

</script>

</body>
</html>
