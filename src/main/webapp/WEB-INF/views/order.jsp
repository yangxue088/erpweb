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
	.p0 {padding:0px;}
	.w200 {width:200px;}
	.dropdown-menuTree {min-width: 160px;padding:0;margin: 2px 0 0;font-size: 13px;text-align:left;background-color: #fff;border: 1px solid #ccc;}
	.dropdown-menuTree li.tit1 {height:32px;line-height:32px;color:#000;list-style: none;vertical-align:top;padding-left:5px;}
	.bgColor5 {background-color:#eee;}
	.liBorder {border-bottom:1px solid #dbdbdb;}
	.dropdown-menuTree li.liMousover {color:#000;list-style: none;line-height:28px;vertical-align:top;height:28px;}
	.treeBackgrounda {background-color:#428bca;}
	.liMousover{cursor: pointer;}
	.liMousover:hover{background-color:#428bca;}
	.pRight10 {padding-right:10px;}
	.pLeft10 {padding-left:10px;}
	.mLeft12 {margin-left:12px;}
	.treeBackgrounda span.txt, .treeBackgrounda a.txt {color:#FFF;}/*js添加Css后要用到*/
	.pLeft10 {padding-left: 10px;}
	.p10 {padding: 10px;}
	.border3 {border: 1px solid #ccc;}
	.bgColor5 {background-color: #eee;}
	.fW600 {font-weight: 600;}
	.f14 {font-size: 14px;}
	.fColor5 {color: #f40;}
	.fColor4 {color:#fa8200;}/*#e5511d*/

	div[name="toolbar"] {
		padding: 50px 0px 40px 0px;
	}

	</style>

	<div class="col-xs-12">
		<div class="dropdown w200 p0 col-xs-1">
			<div class="col-xs-12 p0 mTop10">
				<ul class="dropdown-menuTree col-xs-12" id="treeTab" style="margin-top:0px;">
					<li class="liBorder bgColor5 tit1" name="liTwo"><span>&nbsp;<b>搜索</b></span></li>
					<div id="liTwo">
						<li class="tabA liMousover liBorder">
							<div class="pLeft10 pRight10 " id="m1-1" onclick="selState('m1-1','',-1,0);"><span class="txt mLeft12">订单搜索</span></div>
						</li>
					</div>
					<li class="liBack liBorder bgColor5 tit1" name="liOne"><span class="txt">&nbsp;<b>订单</b></span></li>
					<div id="liOne">
						<li class="tabA liMousover liBorder treeBackgrounda">
							<div class="pLeft10 pRight10" id="m101" onclick="selState('m101', 'approved')">
								<span class="txt mLeft12">待处理&nbsp;（<span id="approvedNum">0</span>）</span>
							</div>
						</li>
					</div>
					<li id="m302" class="text-center bgColor5 tit1">
					</li>
				</ul>
			</div>
		</div>

		<div class="tab-content col-xs-10 mTop10">
			<div id="categoryNav" class="col-xs-12 bgColor5 border3 p10 pLeft10">
				<span class="f14 fW600">当前位置：</span>
				<span class="fColor5 f14 fW600">订单</span>
				<span style="font-family:simsun" class="fColor4">&gt;</span>
				<span id="cNavSpan" class="fColor4">待处理</span>
			</div>
			<div>
				<div name="toolbar">
					<button class="btn btn-md btn-primary pull-right">同步订单</button>
				</div>

				<table id="order-table" data-toggle="table" data-url="order/list" data-id-field="id">
					<thead>
						<tr>
							<th data-field="skuVos" data-formatter="product_format">商品信息</th>
							<th data-field="totalPrice" data-formatter="price_format">订单金额</th>
							<th data-field="receipt" data-formatter="receipt_format">收件人「国家」</th>
							<th data-field="orderNO">订单号</th>
							<th data-field="time" data-formatter="time_format">时间</th>
							<th data-field="operation" data-formatter="operation_format" data-events="operation_shop">操作</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {
		$("div[name='toolbar'] button:contains('同步订单')").on("click", syncOrder);
	});

	function syncOrder(){
		$.post("order/sync", {}, function(result){
			alert(result);
		});
	}
	
	function product_format(value, row, index){
		var str = '<table><tbody>';
		$.each(row['skuVos'], function(i, skuVo){
			str += '<tr>' + '<td>' + skuVo['productSku'] + ' ' +skuVo['productNum'] + '*' + skuVo['unitPrice'] + ' ' + skuVo['unitPriceCur'] + '</td>' +'</tr>';
		});
		str += '</tbody></table>';
		return str;
	}
	
	function price_format(value, row, index){
		return value + ' ' + row['priceCur'];
	}
	
	function receipt_format(value, row, index){
		return row['receipt'] + '「' + row['country']+ '」';
	}
	
	function time_format(value, row, index){
		return '下单：' + row['orderTime'].substring(0, 16);
	}

	</script>
</body>
</html>