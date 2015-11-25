<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<link href="<c:url value="/resources/bootstrap-table/css/bootstrap-table.css" />" rel="stylesheet"  type="text/css" />

	<script type="text/javascript" src="<c:url value="/resources/bootstrap-table/js/bootstrap-table.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-table/js/bootstrap-table-zh-CN.min.js" />"></script>

	<link href="<c:url value="/resources/bootstrap-modal/css/bootstrap-modal-bs3patch.css" />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value="/resources/bootstrap-modal/css/bootstrap-modal.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-modal/js/bootstrap-modalmanager.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap-modal/js/bootstrap-modal.js" />"></script>

	<style type="text/css">
	.pLeft10 {
		padding-left: 10px;
	}

	.p10 {
		padding: 10px;
	}

	.border3 {
		border: 1px solid #ccc;
	}

	.bgColor5 {
		background-color: #eee;
	}

	.fW600 {
		font-weight: 600;
	}

	.f14 {
		font-size: 14px;
	}

	.fColor5 {
		color: #f40;
	}

	div[name="toolbar"] {
		padding: 50px 0px 10px 0px;
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

	</style>

	<div id="categoryNav" class="col-xs-12 bgColor5 border3 p10 pLeft10">
		<span class="f14 fW600">当前位置：</span>
		<span class="fColor5 f14 fW600">平台授权 <span style="font-family:simsun" class="fColor4">&gt;</span>速卖通授权</span>
	</div>

	<div>
		<div name="toolbar">
			<button class="btn btn-md btn-primary">添加速卖通授权</button>
		</div>

		<table id="shop-table" data-toggle="table" data-url="shop/list" data-id-field="id">
			<thead>
				<tr>
					<th data-field="id" data-visible="false"></th>
					<th data-field="type">电商平台</th>
					<th data-field="name">店铺名称</th>
					<th data-field="expireTime">密钥有效期</th>
					<th data-field="authTime">密钥更新时间</th>
					<th data-field="operation" data-formatter="operation_format" data-events="operation_shop">操作</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="auth-modal" class="modal fade" tabindex="-1" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">添加速卖通授权</h4>
		</div>
		<div class="modal-body">
			<span>店铺名称：<input type="input" placeholder="店铺名称" id="shop" autocomplete="off"></span>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
			<button type="button" data-dismiss="modal" class="btn btn-primary">授权</button>
		</div>
	</div>

	<div id="result-modal" class="modal fade" tabindex="-1" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">授权结果</h4>
		</div>
		<div class="modal-body">
			<div class="col-xs-12 text-center">
				<div class="alert alert-warning" style="width: 399px;margin: 0 auto;padding: 5px 10px;">如果没有看到授权页，可能是浏览器拦截了弹窗
				</div>
				<div class="col-xs-12" style="padding-top:10px; padding-bottom:10px;">
					<div class="col-xs-3 col-xs-offset-4">
						<button type="button" class="btn btn-primary">授权成功</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="edit-modal" class="modal fade" tabindex="-1" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">修改店铺名称</h4>
		</div>
		<div class="modal-body">
			<span>店铺名称：<input type="input" placeholder="店铺名称" autocomplete="off"></span>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
			<button type="button" data-dismiss="modal" class="btn btn-primary">确定</button>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {

		$("div[name='toolbar'] button:nth-child(1)").on("click", addAliExpressAuth);

		$("#auth-modal").find("button:nth-child(2)").on("click", authOnLine);

		$("#result-modal").find("button:nth-child(1)").on("click", authResult);

		$("#edit-modal").find("button:nth-child(2)").on("click", edit_shop);
	});

	var auth_type;

	function addAliExpressAuth(){
		auth_type = "速卖通";

		$('#auth-modal').modal('show');
	}

	function authOnLine(){
		var shop = $("#shop").val();

		if(auth_type == "速卖通"){
			$.post("aliexpress/auth", { shop: shop }, function(auth_url){
				window.open(auth_url,'_blank');

				$('#result-modal').modal('show');
			});
		}
	}

	function authResult(){
		$('#result-modal').modal('hide');

		$('#shop-table').bootstrapTable('refresh');
	}
	
	function operation_format(value, row, index){
		return '<a href="javascript:void(0)">重新授权</a><a style="margin-left: 8px;" href="javascript:void(0)">修改</a><a style="margin-left: 8px;" href="javascript:void(0)">删除</a>';
	}

	window.operation_shop = {
		'click a:nth-child(1)': function (e, value, row, index) {
			if(row.type == "速卖通"){
				$.post("aliexpress/auth", { shop: row.name }, function(auth_url){
					window.open(auth_url,'_blank');

					$('#result-modal').modal('show');
				});
			}
		},

		'click a:nth-child(2)': function (e, value, row, index) {
			$('#edit-modal').find("input").val(row.shop_name);
			$('#edit-modal').modal('show');
			edit_id = row.id;
		},

		'click a:nth-child(3)': function (e, value, row, index) {
			$.post("shop/delete", { id: row.id }, function(){
				$('#shop-table').bootstrapTable('refresh');
			});
		}
	};

	function edit_shop(){
		var name = $("#edit-modal").find("input").val();

		$.post("shop/edit", { id: edit_id, name: name}, function(){
			$('#shop-table').bootstrapTable('refresh');
		});
	}
	</script>
</body>
</html>