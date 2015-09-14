<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<style type="text/css">


	</style>

	<div>
		<h4>浏览产品</h4>
	</div>

	<hr class="soften"></hr>
	
	<div>
		<div class="row">
			<div class="col-sm-2">
				行业及产品类目:
			</div>
			<div class="col-sm-10" id="product-type">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>产品属性:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>产品名称:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>产品图片:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>最小计量单位:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>销售方式:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>价格和数量:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>产品包装后的尺寸:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<label>产品包装毛重:</label>
			</div>
			<div class="col-sm-10">
			</div>
		</div>
	</div>

	<script type="text/javascript">

	$(function() {
		var req = {};

		if("${productId}".length){
			eval(
				'req.pid = ${productId};'
				);
		}

		$.post('get', {productId: req.pid}, function(data){
			var type = data.type;
			var product = JSON.parse(data.json);


		});

	});

	</script>
</body>
</html>